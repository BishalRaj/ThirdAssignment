package com.example.thirdassignment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder> {
  private List<ItemsModel> itemsModelList;
  private Context context;

    public ItemsAdapter(List<ItemsModel> list,Context context){
        this.itemsModelList=list;
        this.context=context;
    }

    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_itemsactivity,viewGroup,false);
        return new ItemsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder itemsViewHolder, int i) {
        final ItemsModel itemsModel=itemsModelList.get(i);
//        itemsViewHolder.itemName.setText(itemsModel.getItemName());
//        itemsViewHolder.itemDescription.setText(itemsModel.getItemDescription());
//        itemsViewHolder.itemPrice.setText(itemsModel.getItemPrice());
        itemsViewHolder.itemImageName.setImageResource(itemsModel.getItemImageName());
    }

    @Override
    public int getItemCount() {
        return itemsModelList.size();
    }


    public class ItemsViewHolder extends RecyclerView.ViewHolder{

        public TextView itemName,itemPrice,itemDescription;
        public ImageView itemImageName;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName=itemView.findViewById(R.id.itemName);
            itemPrice=itemView.findViewById(R.id.itemPrice);
            itemDescription=itemView.findViewById(R.id.itemDescription);
            itemImageName=itemView.findViewById(R.id.itemImage);
        }
    }
}
