package com.appsgallery.retrofitfakejsonexample.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.appsgallery.retrofitfakejsonexample.R;
import com.appsgallery.retrofitfakejsonexample.model.Post;

public class PostDetailsActivity extends AppCompatActivity {
    TextView id, userId, title, body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);
        id = findViewById(R.id.post_id);
        userId = findViewById(R.id.post_user_id);
        title = findViewById(R.id.post_title_details);
        body = findViewById(R.id.post_body_details);
        Post post = getIntent().getParcelableExtra("post");
        String id_str = String.valueOf(post.getId());
        String userId_str = String.valueOf(post.getUserId());
        String title_str = String.valueOf(post.getTitle());
        //Log.d("title", title_str);
        String body_str = String.valueOf(post.getBody());
        //Log.d("body", body_str);

        id.setText(id_str);
        userId.setText(userId_str);
        title.setText(title_str);
        body.setText(body_str);
    }
}
