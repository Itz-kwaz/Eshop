package com.example.eshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder> {

    Context context;
    ArrayList<Items> groceryItem;


    public myAdapter(Context context,ArrayList<Items> groceryItem){
        this.context = context;
        this.groceryItem = groceryItem;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final myAdapter.MyViewHolder holder, final int position) {

        holder.itemPrice.setText("$"+groceryItem.get(position).getItemPrice()+"/kg");
        holder.itemName.setText(groceryItem.get(position).getItemName());
        holder.itemQuantity.setText(""+groceryItem.get(position).getItemQuantity());
        holder.itemImage.setImageResource(groceryItem.get(position).getItemImage());
        holder.itemTotalPrice.setText("$"+groceryItem.get(position).getTotalPRice());



        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity =  groceryItem.get(position).getItemQuantity();
                int price;
                if (quantity > 0) {
                   quantity  -= 1;
                    price = quantity * groceryItem.get(position).getItemPrice();
                    holder.itemQuantity.setText(""+quantity);
                    holder.itemTotalPrice.setText("$"+price);
                    groceryItem.get(position).setItemQuantity(quantity);
                    groceryItem.get(position).setTotalPRice(price);

                } else {
                    Toast.makeText(context, "Minimum Value .", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.plus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int quantity =  groceryItem.get(position).getItemQuantity();
                int price;
                if ( quantity < 20) {
                    quantity += 1;
                    holder.itemQuantity.setText(""+quantity);
                    price = quantity * groceryItem.get(position).getItemPrice();
                    holder.itemTotalPrice.setText("$"+price);
                    groceryItem.get(position).setItemQuantity(quantity);
                    groceryItem.get(position).setTotalPRice(price);

                }else{
                    Toast.makeText(context,"You can't have more than 20 ",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return groceryItem.size();
    }

    class  MyViewHolder extends RecyclerView.ViewHolder{

        ImageView itemImage;
        TextView itemName;
        TextView itemQuantity;
        TextView itemPrice;
        TextView itemTotalPrice;
        Button plus;
        Button minus;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.imageView2);
            itemName = itemView.findViewById(R.id.name);
            itemQuantity = itemView.findViewById(R.id.quantity);
            itemTotalPrice = itemView.findViewById(R.id.total_price);
            itemPrice = itemView.findViewById(R.id.price);
            plus = itemView.findViewById(R.id.plus_button);
            minus = itemView.findViewById(R.id.minus_button);

        }

    }
}
