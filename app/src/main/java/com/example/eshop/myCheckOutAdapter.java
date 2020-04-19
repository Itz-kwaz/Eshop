package com.example.eshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myCheckOutAdapter extends RecyclerView.Adapter<myCheckOutAdapter.MyViewHolder> {

    Context context;
    ArrayList<Items> items;

    public myCheckOutAdapter(Context context, ArrayList<Items> items){
        this.context = context;
        this.items = items;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.checkout_list,parent,false);
        return new myCheckOutAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myCheckOutAdapter.MyViewHolder holder, int position) {
        holder.price.setText("$"+ items.get(position).getTotalPRice());
        holder.name.setText(items.get(position).getItemName());
        holder.qty.setText(""+items.get(position).getItemQuantity());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView qty;
        TextView price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView);
            qty = itemView.findViewById(R.id.textView4);
            price =itemView.findViewById(R.id.textView5);

        }
    }
}
