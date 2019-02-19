package com.ashwin.retrofitusingmvp.mvp;

import com.ashwin.retrofitusingmvp.retrofit.NoticeModel.Notice;

import java.util.ArrayList;

public interface MainMvp {
    interface MainView {
        void showProgress();

        void hideProgress();

        void setNoticeList(ArrayList<Notice> noticeList);

        void onResponseFailure(Throwable t);
    }

    interface MainPresenter {
        void requestFromServer();
    }

    interface MainModel {
        interface OnFinishedListener {
            void OnFinished(ArrayList<Notice> noticeList);

            void OnFailure(Throwable t);
        }

        void getNoticeList(OnFinishedListener onFinishedListener);
    }
}
