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
        Call<List<Post>> call = service.post();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                List<Post> posts = response.body();


                //Toast.makeText(MainActivity.this, (CharSequence) posts,Toast.LENGTH_LONG).show();

                for (Post h : posts) {
                    Log.d("UserID", String.valueOf(h.getUserId()));
                    Log.d("ID", String.valueOf(h.getId()));
                    Log.d("Title", h.getTitle());
                    Log.d("Completed", h.getBody());

                }


            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("erro", t.getMessage());
            }
        });

    }
   
}
