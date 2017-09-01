package com.jascal.clare.main.view;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jascal.clare.R;
import com.jascal.clare.base.BaseActivity;
import com.jascal.clare.bean.HistoryEvent;
import com.jascal.clare.main.MainContract;
import com.jascal.clare.main.presenter.MainPresenter;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author No.47 create at 2017/8/28 14:57
 */
public class MainActivity extends BaseActivity implements MainContract.View {
    private MainContract.Presenter presenter;
    @Bind(R.id.main_navigation)
    NavigationView navigationView;
    @Bind(R.id.main_content)
    CoordinatorLayout content;

    @Bind(R.id.main_toolbar)
    Toolbar toolbar;
    @Bind(R.id.main_recycle)
    RecyclerView recyclerView;
    @Bind(R.id.main_refresh)
    SwipeRefreshLayout refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        new MainPresenter(this);
        initToolbar();
        presenter.getHistoryToday(11, 1);
    }

    private void initToolbar() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showHistoryOfToday(String data) {

    }
}
