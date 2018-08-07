package com.tahsin.testretrofit.interfaces;

import com.tahsin.testretrofit.models.Notice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetNoticeDataResponse {

    @GET("bins/1bsqcn/")
    Call<Notice.NoticeList> getNoticeData();
}
