package com.example.fetchdataonrecyclerviewinfirebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.fetchdataonrecyclerviewinfirebase.databinding.ActivityMain2Binding;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MainActivity2 extends AppCompatActivity {
 ActivityMain2Binding binding;
 AdapterClass adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        binding=ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);

        Query query= FirebaseDatabase.getInstance().getReference().child("Student")
                .orderByChild("Name").equalTo("zahra");

        Query query2= FirebaseDatabase.getInstance().getReference().child("Student")
                .orderByChild("Name").startAt("a").endAt("a\uf8ff");


        FirebaseRecyclerOptions<ModelClass> options= new FirebaseRecyclerOptions.Builder<ModelClass>()
                .setQuery(query2,ModelClass.class)
                .build();

        adapter=new AdapterClass(options);
        binding.recyclerview.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}