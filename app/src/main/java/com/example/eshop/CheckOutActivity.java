package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class CheckOutActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private  RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    StringBuilder stringBuilder = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        ArrayList<Items> groceryList = bundle.getParcelableArrayList("list");

        String user_name = getIntent().getExtras().getString("name");
        String user_number = getIntent().getExtras().getString("number");
        String user_address = getIntent().getExtras().getString("address");

        TextView name = findViewById(R.id.name);
        name.setText("Name: "+user_name);

        TextView number = findViewById(R.id.number);
        number.setText("Phone Number: "+user_number);

        TextView address = findViewById(R.id.address);
        address.setText("Address: "+user_address);

        for(int i = 0;i<groceryList.size();i++){
            if(groceryList.get(i).getTotalPRice() <= 0){
                groceryList.remove(i);
               }
       }
        adapter = new myCheckOutAdapter(this,groceryList);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration( new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        String summary = "";

        stringBuilder.append("Name: "+user_name + "\n");
        stringBuilder.append("Phone Number: "+user_number + "\n");
        stringBuilder.append("Address: " + user_address+"\n");
        TextView textView = findViewById(R.id.checkout_list);
        int total = 0;
        for(int i = 0; i< groceryList.size();i++){
         summary = getResources().getString(groceryList.get(i).getItemName()) + " ," +groceryList.get(i).getItemQuantity() +" ,"
                 + groceryList.get(i).getTotalPRice();
         stringBuilder.append(summary);
         stringBuilder.append("\n");
         total += groceryList.get(i).getTotalPRice();

        }


        textView.setText("Total: $"+total);

        Button sendOrder = findViewById(R.id.button2);
        sendOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitOrder(view);
            }
        });

    }

    public void submitOrder(View view) {
        EditText comment = findViewById(R.id.editText);
        stringBuilder.append(comment.getText().toString());
        String priceMessage = stringBuilder.toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));  //only email apps should handle this.
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }

    }
}
