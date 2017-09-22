package com.jascal.clare.login.model;

import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author No.47 create at 2017/8/31.
 */
public class LoginModel {
    private final String TAG = "LoginModel";
    private OnResponse callback;
    private Retrofit retrofit;
    private String KEY = "eff36bdaeeb868a6b8057a34f32d1326";
    private String VERSION = "1.0";

    public void getList() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.juheapi.com/")
                .build();
        AccessTakenService accessTakenService = retrofit.create(AccessTakenService.class);
        Call<ResponseBody> call = accessTakenService.getAccessTaken(KEY, VERSION, 11, 1);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    callback.onSuccess(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    // 324d8a155119554dcd127f2281a1ff93
    public void setCallBack(OnResponse callBack) {
        this.callback = callBack;
    }

    public interface AccessTakenService {
        @GET("/japi/toh")
        Call<ResponseBody> getAccessTaken(@Query("key") String key, @Query("v") String v, @Query("month") int month, @Query("day") int day);
    }

    public interface OnResponse {
        void onSuccess(String data);
    }
}
