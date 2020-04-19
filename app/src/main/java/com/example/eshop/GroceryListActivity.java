package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class GroceryListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private  RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);

        final ArrayList<Items> groceryItems = new ArrayList<>();
        groceryItems.add(new Items(R.string.apple,5,R.drawable.apple));
        groceryItems.add(new Items(R.string.peanut,2,R.drawable.peanut));
        groceryItems.add(new Items(R.string.pineapple,4,R.drawable.pineapple));
        groceryItems.add(new Items(R.string.orange,3,R.drawable.orange));
        groceryItems.add(new Items(R.string.water,1,R.drawable.water));
        groceryItems.add(new Items(R.string.wine,30,R.drawable.wine));
        groceryItems.add(new Items(R.string.tomato,12,R.drawable.tomato));
        groceryItems.add(new Items(R.string.meat,15,R.drawable.meat));
        groceryItems.add(new Items(R.string.milk,5,R.drawable.milk));
        groceryItems.add(new Items(R.string.banana,7,R.drawable.banana));
        groceryItems.add(new Items(R.string.eggs,2,R.drawable.eggs));
        groceryItems.add(new Items(R.string.pepper,6,R.drawable.chili));
        groceryItems.add(new Items(R.string.avocado,8,R.drawable.avocado));


        adapter = new myAdapter(this,groceryItems);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration( new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        final String user_name = getIntent().getExtras().getString("name");
        final String user_number = getIntent().getExtras().getString("number");
        final String user_address = getIntent().getExtras().getString("address");

        Button checkOutButton = findViewById(R.id.checkout_button);
        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CheckOutActivity.class);
                intent.putParcelableArrayListExtra("list",groceryItems);
                intent.putExtra("name",user_name);
                intent.putExtra("number",user_number);
                intent.putExtra("address",user_address);
                startActivity(intent);
            }
        });

    }

}
