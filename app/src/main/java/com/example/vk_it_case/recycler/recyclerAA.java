package com.example.vk_it_case.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vk_it_case.R;

import java.util.ArrayList;

public class recyclerAA extends RecyclerView.Adapter<recyclerAA.MyViewHolder> {

    Context context;
    ArrayList<Model> models;

    public  recyclerAA(Context context, ArrayList<Model> models){
        this.context = context;
        this.models = models;
    }


    @NonNull
    @Override
    public recyclerAA.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view  = inflater.inflate(R.layout.recycler_view_row, parent,false);
        return new recyclerAA.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAA.MyViewHolder holder, int position) {
        holder.Name.setText(models.get(position).getName());
        holder.imageView.setImageResource(models.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView Name;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView_1_re);
            Name = itemView.findViewById(R.id.textView_re);

        }
    }
}
