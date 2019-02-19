package com.ashwin.retrofitusingmvp.presenter;

import com.ashwin.retrofitusingmvp.mvp.MainMvp;
import com.ashwin.retrofitusingmvp.retrofit.NoticeModel.Notice;

import java.util.ArrayList;

public class MainPresenterImpl implements MainMvp.MainPresenter, MainMvp.MainModel.OnFinishedListener {
    private MainMvp.MainView mMainView;
    private MainMvp.MainModel mMainModel;

    public MainPresenterImpl(MainMvp.MainView mainView, MainMvp.MainModel mainModel) {
        mMainView = mainView;
        mMainModel = mainModel;
    }

    @Override
    public void requestFromServer() {
        mMainView.showProgress();
        mMainModel.getNoticeList(this);
    }

    @Override
    public void OnFinished(ArrayList<Notice> noticeList) {
        if (mMainView != null) {
            mMainView.setNoticeList(noticeList);
            mMainView.hideProgress();
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        if (mMainView != null) {
            mMainView.onResponseFailure(t);
            mMainView.hideProgress();
        }
    }
}
