package com.example.thirdassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Items extends AppCompatActivity {
    RecyclerView recyclerView;
//    private Map<String,String> items;
    Button btnload;
    List<ItemsModel> itemsModelList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btnload=findViewById(R.id.insert);
        setContentView(R.layout.activity_items);
//        items=new HashMap<>();
//        readFile();
        recyclerView=findViewById(R.id.itemRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerView.setAdapter(new ItemsAdapter(itemsModelList,getApplicationContext()));
        readFile();


        btnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Items.this,AddItems.class);
                startActivity(intent);
            }
        });

    }


    private void readFile(){
        try {
            FileInputStream fileInputStream=openFileInput("items.txt");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                String[] parts=line.split("->");
                itemsModelList.add(new ItemsModel(parts[0],parts[1],parts[2],parts[3]));
            }

            if ((line=bufferedReader.readLine())==null){
                String txtname,txtprice,txtdesc,img;


            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
