package com.appsgallery.retrofitfakejsonexample.service;

import com.appsgallery.retrofitfakejsonexample.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiService {
    @GET("/posts")
    Call<List<Post>> getAllPost();
}
