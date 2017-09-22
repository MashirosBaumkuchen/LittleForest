package com.jascal.clare.main.model;

import com.google.gson.GsonBuilder;
import com.jascal.clare.Constant;
import com.jascal.clare.bean.HistoryEvent;
import com.jascal.clare.utils.Logger;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.functions.Action1;

/**
 * @author No.47 create at 2017/9/1.
 */
public class TOHistoryModel {
    private final String TAG = "TOHistoryModel";
    private int month;
    private int day;
    private String key;
    private String v;
    private String url;
    private TOHistoryModel.OnResponse callback;
    private List<HistoryEvent.Event> eventList = new ArrayList<>();

    public TOHistoryModel(TOHBuilder tohBuilder) {
        this.month = tohBuilder.month;
        this.day = tohBuilder.day;
        this.v = tohBuilder.v;
        this.key = tohBuilder.key;
        this.url = tohBuilder.url;
        this.callback = tohBuilder.callBack;
    }

    public void getHistoryToday(int month, int day) {
        // TODO: 2017/9/5
        Observable observable = Observable.just("1");
        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {

            }
        });
    }

    public void getHistoryToday() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();
        TOHistoryModel.HistoryOfToadyService accessTakenService = retrofit.create(TOHistoryModel.HistoryOfToadyService.class);
        Call<HistoryEvent> call = accessTakenService.getHistoryOfToady(key, v, month, day);
        call.enqueue(new Callback<HistoryEvent>() {
            @Override
            public void onResponse(Call<HistoryEvent> call, Response<HistoryEvent> response) {
                if (response.body().getError_code() == Constant.HISTORY_OF_TODAY_SUCCESS_CODE)
                    callback.onSuccess(response.body().getResult());
                else
                    callback.onFail(response.body().getReason());
            }

            @Override
            public void onFailure(Call<HistoryEvent> call, Throwable t) {
                Logger.d(TAG, "onFailure");
            }
        });
    }

    public interface HistoryOfToadyService {
        @GET(Constant.HISTORY_OF_TODAY_ACTION)
        Call<HistoryEvent> getHistoryOfToady(@Query("key") String key, @Query("v") String v, @Query("month") int month, @Query("day") int day);
    }

    public interface OnResponse {
        void onSuccess(List<HistoryEvent.Event> data);

        void onFail(String reason);
    }

    public static class TOHBuilder {
        private String key;
        private String v;
        private String url;
        private String action;
        private int month;
        private int day;
        private TOHistoryModel.OnResponse callBack;

        public TOHBuilder(int month, int day) {
            this.month = month;
            this.day = day;
        }

        public TOHBuilder setVersion(String v) {
            this.v = v;
            return this;
        }

        public TOHBuilder setKey(String key) {
            this.key = key;
            return this;
        }

        public TOHBuilder setUrl(String url) {
            this.url = url;
            return this;
        }

        public TOHBuilder setAction(String action) {
            this.action = action;
            return this;
        }

        public TOHBuilder setCallback(TOHistoryModel.OnResponse callBack) {
            this.callBack = callBack;
            return this;
        }

        public TOHistoryModel build() {
            return new TOHistoryModel(this);
        }
    }
}
