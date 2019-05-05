package com.example.thirdassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDisplay extends AppCompatActivity {
    ImageView imageView;
    TextView name,price,desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_display);

init();
    }

    private void init(){
        imageView=findViewById(R.id.individualImage);
        name=findViewById(R.id.individuaName);
        price=findViewById(R.id.individualPrice);
        desc=findViewById(R.id.individualDesc);

//        imageView.setImageResource(getIntent().getStringExtra("image"));
        name.setText(getIntent().getStringExtra("name"));
        price.setText(getIntent().getStringExtra("price"));
        desc.setText(getIntent().getStringExtra("desc"));
    }
}
