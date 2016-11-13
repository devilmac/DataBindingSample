package com.colantoni.federico.databindingsample.service;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.colantoni.federico.databindingsample.service.response.ForismaticGetQuoteResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface Forismatic {

    String METHOD = "method";

    String LANGUAGE = "lang";

    String FORMAT = "format";

    String KEY = "key";

    @GET(value = "{" + METHOD + "}/")
    Observable<ForismaticGetQuoteResponse> getQuote(@NonNull @Query(METHOD) String method, @Query(LANGUAGE) String language, @Query(FORMAT) String format, @Nullable @Query(KEY) Integer key);
}

