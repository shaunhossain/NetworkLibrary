package com.shaunhossain.networklibrary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService {
    String Base_URL = "https://jsonplaceholder.typicode.com/todos/";

    @GET("1")
    Call<List<User>> getUserInfo();
}
