package com.jascal.clare.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @author No.47 create at 2017/8/28.
 */
public class BaseActivity extends AppCompatActivity {
    private final String TAG = "BaseActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
