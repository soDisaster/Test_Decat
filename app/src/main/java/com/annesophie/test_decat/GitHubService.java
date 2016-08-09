package com.annesophie.test_decat;

import com.firebase.client.core.Repo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/* Interface pour utiliser Retrofit */

public interface GitHubService {

    @GET("stores")
    Call <ArrayList<Data>> groupListNameDecat();
}
