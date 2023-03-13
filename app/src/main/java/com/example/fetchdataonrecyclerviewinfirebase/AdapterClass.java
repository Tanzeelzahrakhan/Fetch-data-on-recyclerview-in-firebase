package com.example.fetchdataonrecyclerviewinfirebase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fetchdataonrecyclerviewinfirebase.databinding.ListItemBinding;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class AdapterClass extends FirebaseRecyclerAdapter<ModelClass,AdapterClass.ViewHolder> {



    public AdapterClass(@NonNull FirebaseRecyclerOptions<ModelClass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull ModelClass model) {
        holder.binding.textView.setText(model.getName());
        holder.binding.textView2.setText(model.getEmail());
        holder.binding.textView3.setText(model.getPassword());
        Glide.with(holder.itemView.getContext()).load(model.getImageUrl()).into(holder.binding.imageView);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        ListItemBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=ListItemBinding.bind(itemView);

        }
    }
}
