package com.example.dynamicalculator;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubClient {
    @GET("/{posts}")
    Call<List<GitRepos>> reposForUser(@Path("posts") String posts);
}
