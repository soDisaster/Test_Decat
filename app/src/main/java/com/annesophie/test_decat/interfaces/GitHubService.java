package com.annesophie.test_decat.interfaces;

import com.annesophie.test_decat.pojo.DataDecathlon;

import retrofit2.Call;
import retrofit2.http.GET;

/* Interface pour utiliser Retrofit */

public interface GitHubService {

    @GET("stores")
    Call<DataDecathlon> groupListNameDecat();
}
