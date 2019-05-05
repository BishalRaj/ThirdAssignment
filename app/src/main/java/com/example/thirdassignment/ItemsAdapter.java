package com.example.thirdassignment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
    public void onBindViewHolder(@NonNull final ItemsViewHolder itemsViewHolder, final int i) {
        final ItemsModel itemsModel=itemsModelList.get(i);
        String img="@drawable/"+itemsModelList.get(i).getItemImageName();
        final int imageResource=context.getResources().getIdentifier(img,null,context.getPackageName());
        itemsViewHolder.itemImageName.setImageResource(imageResource);


        itemsViewHolder.itemImageName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,ItemDisplay.class);
                intent.putExtra("image",imageResource);
                intent.putExtra("name",itemsModel.getItemName());
                intent.putExtra("price",itemsModel.getItemPrice());
                intent.putExtra("desc",itemsModel.getItemDescription());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsModelList.size();
    }


    public class ItemsViewHolder extends RecyclerView.ViewHolder{

        public TextView individuaName,individualPrice,individualDesc;
        public ImageView itemImageName,individualImage;
        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            individuaName=itemView.findViewById(R.id.individuaName);
            individualPrice=itemView.findViewById(R.id.individualPrice);
            individualDesc=itemView.findViewById(R.id.individualDesc);
            itemImageName=itemView.findViewById(R.id.itemImage);
            individualImage=itemView.findViewById(R.id.individualImage);

        }
    }
}
