package com.appsgallery.retrofitfakejsonexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appsgallery.retrofitfakejsonexample.adapter.RecyclerAdapter;
import com.appsgallery.retrofitfakejsonexample.model.Post;
import com.appsgallery.retrofitfakejsonexample.service.RestApiBuilder;
import com.appsgallery.retrofitfakejsonexample.service.RestApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        RestApiService apiService = new RestApiBuilder().getService();
        Call<List<Post>> call = apiService.getAllPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                //Log.i("INFO", String.valueOf(response.body().size()));
                if (response.isSuccessful()) {
                    fetchDataInList(response.body());
                    //String title = String.valueOf(response.body());
                    //String body = String.valueOf(response.body());
                    //Log.i("title", title);
                    // Log.i("body", body);
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

    private void fetchDataInList(List<Post> postList) {

        adapter = new RecyclerAdapter(this, postList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
