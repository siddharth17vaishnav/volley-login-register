package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewAdapter> {
    private Context context;
    private List<Post> postList;
    public PostAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.post_list_item,parent,false);
        return new PostViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewAdapter holder, int position) {
        holder.title.setText(postList.get(position).getTitle());
        holder.desc.setText(postList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}

class PostViewAdapter extends RecyclerView.ViewHolder {
    TextView title,desc;

    public PostViewAdapter(@NonNull View itemView) {
        super(itemView);
        title=itemView.findViewById(R.id.title);
        desc=itemView.findViewById(R.id.desc);
    }
}
