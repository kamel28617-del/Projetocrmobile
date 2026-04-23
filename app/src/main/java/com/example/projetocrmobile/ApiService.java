package com.example.projetocrmobile;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Header;

public interface ApiService {

    @POST("v1/chat/completions")
    Call<OpenAIResponse> summarizeText(@Header("Authorization") String auth, @Body OpenAIRequest request);
}