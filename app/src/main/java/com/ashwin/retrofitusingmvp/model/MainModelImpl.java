package com.ashwin.retrofitusingmvp.model;

import com.ashwin.retrofitusingmvp.mvp.MainMvp;
import com.ashwin.retrofitusingmvp.retrofit.NoticeModel.NoticeResponse;
import com.ashwin.retrofitusingmvp.retrofit.RetrofitApi;
import com.ashwin.retrofitusingmvp.retrofit.RetrofitService;
import com.ashwin.retrofitusingmvp.utility.CommonLog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainModelImpl implements MainMvp.MainModel {
    private final String TAG = MainModelImpl.class.getSimpleName();

    @Override
    public void getNoticeList(final OnFinishedListener onFinishedListener) {
        RetrofitService retrofitService = RetrofitApi.getRetrofit().create(RetrofitService.class);

        Call<NoticeResponse> noticeResponseCall = retrofitService.getNoticeData();

        noticeResponseCall.enqueue(new Callback<NoticeResponse>() {
            @Override
            public void onResponse(Call<NoticeResponse> call, Response<NoticeResponse> response) {
                NoticeResponse noticeResponse = response.body();

                CommonLog.createLog(CommonLog.LOG_TYPE_ERROR, TAG, "Notification Response Success ===> " + noticeResponse.isSuccess());

                if (noticeResponse.isSuccess()) {
                    onFinishedListener.OnFinished(noticeResponse.getNotice_list());
                }
            }

            @Override
            public void onFailure(Call<NoticeResponse> call, Throwable t) {
                onFinishedListener.OnFailure(t);
            }
        });
    }
}
