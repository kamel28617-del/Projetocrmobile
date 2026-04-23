package com.example.projetocrmobile;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface HuggingFaceApiService {

    @POST("models/google/pegasus-cnn_dailymail")
    Call<HuggingFaceResponse[]> summarizeText(
        @Header("Authorization") String auth,
        @Header("Content-Type") String contentType,
        @Body HuggingFaceRequest request
    );
}