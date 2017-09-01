package com.jascal.clare.login.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jascal.clare.R;
import com.jascal.clare.login.model.LoginModel;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity implements LoginModel.OnResponse {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        LoginModel loginModel = new LoginModel();
        loginModel.setCallBack(this);
        loginModel.getList();
    }

    @Bind(R.id.login_text)
    TextView textView;

    @Override
    public void onSuccess(String data) {
        textView.setText(data);
    }
}
