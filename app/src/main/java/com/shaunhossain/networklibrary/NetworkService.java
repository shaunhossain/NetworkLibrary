package com.shaunhossain.networklibrary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService {
   /* String Base_URL = "https://www.simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<User>> getUserInfo();*/

    String Base_URL = "https://jsonplaceholder.typicode.com/";

    @GET("posts")
    Call<List<Post>> post();
}
