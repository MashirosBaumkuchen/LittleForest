package com.jascal.clare.main.view;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.jascal.clare.Constant;
import com.jascal.clare.R;
import com.jascal.clare.base.BaseActivity;
import com.jascal.clare.bean.HistoryEvent;
import com.jascal.clare.main.MainContract;
import com.jascal.clare.main.adapter.RecyclerAdapter;
import com.jascal.clare.main.presenter.MainPresenter;
import com.jascal.clare.utils.Logger;

import java.sql.Date;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author No.47 create at 2017/8/28 14:57
 */
public class MainActivity extends BaseActivity implements MainContract.View {
    private String TAG = "MainActivity";
    private MainContract.Presenter presenter;
    @Bind(R.id.main_drawer)
    DrawerLayout drawerLayout;
    @Bind(R.id.main_navigation)
    NavigationView navigationView;
    @Bind(R.id.main_content)
    CoordinatorLayout content;

    @Bind(R.id.main_toolbar)
    Toolbar toolbar;
    @Bind(R.id.main_title)
    TextView title;

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

        initRecyclerView();
        initToolbar();
    }

    private void initRecyclerView() {
        Date date = new Date(Calendar.getInstance().getTimeInMillis());
        Logger.d(TAG, date.getMonth()+""+date.getDay()+" "+date.toString());
        String d[] = date.toString().split("-");
        Logger.d(TAG, (new Integer(d[1]))+""+(new Integer(d[2])));
        if (Constant.DEBUG) {
            initDebugData();
        } else {
            presenter.getHistoryToday(Integer.valueOf(d[1]), Integer.valueOf(d[2]));
        }
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setHasFixedSize(true);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh.setRefreshing(false);
            }
        });
    }

    private void initDebugData() {
        int _id = 0;
        List<HistoryEvent.Event> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            HistoryEvent.Event he = new HistoryEvent.Event();
            he.setDay(1);
            he.setDes("demo");
            he.setId(_id++);
            he.setLunar("demo");
            he.setMonth(1);
            he.setPic("");
            he.setTitle("demo");
            he.setYear(1900);
            data.add(he);
        }
        recyclerView.setAdapter(new RecyclerAdapter(MainActivity.this, data));
        title.setText(data.get(0).getMonth() + "/" + data.get(0).getDay());
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(navigationView);
                Logger.d(TAG, MainActivity.class.getName() + " " + view.getId() + "");
            }
        });
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void showHistoryOfToday(List<HistoryEvent.Event> data) {
        // TODO: 2017/9/4
        Logger.d(TAG, data.get(1).toString());
        recyclerView.setAdapter(new RecyclerAdapter(MainActivity.this, data));
        title.setText(data.get(0).getMonth() + "/" + data.get(0).getDay());
    }

    @Override
    public void showGetHistoryFail(String reason) {
        // TODO: 2017/9/4
        Logger.d(TAG, reason);
    }
}
