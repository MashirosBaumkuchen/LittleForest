package com.jascal.clare.main.presenter;

import com.jascal.clare.Constant;
import com.jascal.clare.main.MainContract;
import com.jascal.clare.main.model.TOHistoryModel;

/**
 * @author No.47 create at 2017/8/28.
 */
public class MainPresenter implements MainContract.Presenter, TOHistoryModel.OnResponse {
    MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    public void getHistoryToday(int month, int day) {
        new TOHistoryModel.TOHBuilder(month, day)
                .setCallback(this)
                .setUrl(Constant.HISTORY_OF_TODAY_URL)
                .setKey(Constant.HISTORY_OF_TODAY_KEY)
                .setVersion(Constant.HISTORY_OF_TODAY_VERSION)
                .build()
                .getHistoryToday();
    }

    @Override
    public void onSuccess(String data) {
        view.showHistoryOfToday(data);
    }
}
