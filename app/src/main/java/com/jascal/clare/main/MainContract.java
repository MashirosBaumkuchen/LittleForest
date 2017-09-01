package com.jascal.clare.main;


/**
 * @author No.47 create at 2017/8/28 14:57
 */
public interface MainContract {
    interface View {
        void setPresenter(MainContract.Presenter presenter);

        void showHistoryOfToday(String data);
    }

    interface Presenter {
        void getHistoryToday(int month, int day);
    }
}
