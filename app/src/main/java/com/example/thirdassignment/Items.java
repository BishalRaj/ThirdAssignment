package com.example.thirdassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Items extends AppCompatActivity {
    RecyclerView recyclerView;
    List<ItemsModel> itemsModelList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        recyclerView=findViewById(R.id.itemRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerView.setAdapter(new ItemsAdapter(itemsModelList,getApplicationContext()));
        getList();
    }

    private void getList(){
        itemsModelList.add(new ItemsModel("Cap","lalalalalala",R.drawable.topi,"50"));
        itemsModelList.add(new ItemsModel("Daura","lalalalalala",R.drawable.daura,"50"));
        itemsModelList.add(new ItemsModel("Saluwar","lalalalalala",R.drawable.suruwal,"50"));
        itemsModelList.add(new ItemsModel("Shoe","lalalalalala",R.drawable.shoe,"50"));
    }

}
