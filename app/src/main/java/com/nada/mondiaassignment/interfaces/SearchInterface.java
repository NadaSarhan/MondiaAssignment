package com.nada.mondiaassignment.interfaces;

import com.nada.mondiaassignment.model.AccessToken;
import com.nada.mondiaassignment.model.MainModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SearchInterface {

    //POST METHOD
    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded",
            "X-MM-GATEWAY-KEY: Ge6c853cf-5593-a196-efdb-e3fd7b881eca"
    })
    @POST("gateway/token/client")
    Call<AccessToken> getToken();

    // GET METHOD
    @Headers("Accept: application/json")
    @GET("sayt/flat?limit=20")
    Call<List<MainModel>> getList(@Header("Authorization") String token, @Query("query") String searchText);

}
