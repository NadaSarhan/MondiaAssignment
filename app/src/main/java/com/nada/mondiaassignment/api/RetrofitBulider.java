package com.nada.mondiaassignment.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nada.mondiaassignment.constants.Constant;
import com.nada.mondiaassignment.interfaces.SearchInterface;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBulider {


    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    private static final OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .connectionPool(new ConnectionPool(15, 500000, TimeUnit.MILLISECONDS))
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(logging);

    public RetrofitBulider() {
    }

    public static Retrofit getClient() {
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new Retrofit.Builder()
                .baseUrl(Constant.ROOT_URL)
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getAccessTokenClient() {
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new Retrofit.Builder()
                .baseUrl(Constant.ROOT_URL_ACCESSTOKEN)
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
