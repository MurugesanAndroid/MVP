package com.ashwin.retrofitusingmvp.retrofit;

import com.ashwin.retrofitusingmvp.retrofit.NoticeModel.NoticeResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("bins/1bsqcn/")
    Call<NoticeResponse> getNoticeData();
}
