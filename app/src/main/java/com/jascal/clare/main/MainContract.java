package com.jascal.clare.main;


import com.jascal.clare.bean.HistoryEvent;

import java.util.List;

/**
 * @author No.47 create at 2017/8/28 14:57
 */
public interface MainContract {
    interface View {
        void setPresenter(MainContract.Presenter presenter);

        void showHistoryOfToday(List<HistoryEvent> data);

        void showGetHistoryFail(String reason);
    }

    interface Presenter {
        void getHistoryToday(int month, int day);
    }
}
