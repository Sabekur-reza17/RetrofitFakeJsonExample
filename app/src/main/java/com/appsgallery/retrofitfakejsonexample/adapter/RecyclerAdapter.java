package com.appsgallery.retrofitfakejsonexample.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appsgallery.retrofitfakejsonexample.R;
import com.appsgallery.retrofitfakejsonexample.activities.PostDetailsActivity;
import com.appsgallery.retrofitfakejsonexample.model.Post;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CustomRecyclerViewHolder> {
    private List<Post> postList;
    private Context context;

    public RecyclerAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;

    }

    @NonNull
    @Override
    public CustomRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_row_item, parent, false);

        return new CustomRecyclerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final CustomRecyclerViewHolder holder, final int position) {
        holder.titile.setText(postList.get(position).getTitle());
        holder.body.setText(postList.get(position).getBody());
        holder.titile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Post post=new Post(postList.get(position).getId(),postList.get(position).getUserId(),postList.get(position).getTitle(),postList.get(position).getBody());
                Post post = postList.get(position);
                Intent intent = new Intent(context.getApplicationContext(), PostDetailsActivity.class);
                intent.putExtra("post", post);
                context.startActivity(intent);
                // Log.d("item", post.getTitle());

                //Toast.makeText(context, "Clicked: " + postList.get(position).getTitle(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }


    class CustomRecyclerViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        TextView titile, body;

        public CustomRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            titile = view.findViewById(R.id.title_post);
            body = view.findViewById(R.id.body_post);
        }


    }
}
