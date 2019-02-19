package com.ashwin.retrofitusingmvp.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ashwin.retrofitusingmvp.R;
import com.ashwin.retrofitusingmvp.adapter.NoticeAdapter;
import com.ashwin.retrofitusingmvp.model.MainModelImpl;
import com.ashwin.retrofitusingmvp.mvp.MainMvp;
import com.ashwin.retrofitusingmvp.presenter.MainPresenterImpl;
import com.ashwin.retrofitusingmvp.retrofit.NoticeModel.Notice;
import com.ashwin.retrofitusingmvp.utility.RecyclerViewClickListener;
import com.ashwin.retrofitusingmvp.utility.Viewer;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements Viewer, MainMvp.MainView {
    private RecyclerView recyclerViewNotice;
    private ProgressDialog mProgressDialog;

    private RecyclerViewClickListener recyclerViewClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        setClickListener();
    }

    @Override
    public void initView() {
        recyclerViewNotice = findViewById(R.id.recyclerViewNotice);
    }

    @Override
    public void initData() {
        MainPresenterImpl mainPresenter = new MainPresenterImpl(this, new MainModelImpl());
        mainPresenter.requestFromServer();
    }

    @Override
    public void setClickListener() {
        recyclerViewClickListener = new RecyclerViewClickListener() {
            @Override
            public void onItemClick(Object obj) {
                Notice notice = (Notice) obj;
                Toast.makeText(mActivity, notice.getBrief(), Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    public void showProgress() {
        mProgressDialog = new ProgressDialog(mActivity);
        mProgressDialog.setMessage(mActivity.getResources().getString(R.string.progress_please_wait));
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }

    @Override
    public void hideProgress() {
        if (mProgressDialog != null)
            mProgressDialog.dismiss();
    }

    @Override
    public void setNoticeList(ArrayList<Notice> noticeList) {
        recyclerViewNotice.setLayoutManager(new GridLayoutManager(mActivity, 1));

        NoticeAdapter noticeAdapter = new NoticeAdapter(noticeList, recyclerViewClickListener);
        recyclerViewNotice.setAdapter(noticeAdapter);
    }

    @Override
    public void onResponseFailure(Throwable t) {
        Toast.makeText(mActivity, mActivity.getResources().getString(R.string.toast_response_failure) + t, Toast.LENGTH_SHORT).show();
    }
}
