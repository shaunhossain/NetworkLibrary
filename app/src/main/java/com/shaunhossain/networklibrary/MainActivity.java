package com.shaunhossain.networklibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetworkService.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NetworkService service = retrofit.create(NetworkService.class);
        Call<List<User>> call = service.getUserInfo();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                List<User> users = response.body();

                for (User h : users) {
                    Log.d("UserID", h.getUserId());
                    Log.d("ID", h.getId());
                    Log.d("Title", h.getTitle());
                    Log.d("Completed", h.getCompleted());

                }

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
   
}
