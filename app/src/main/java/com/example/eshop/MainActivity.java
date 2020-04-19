package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = findViewById(R.id.name_field);
        final EditText number = findViewById(R.id.number);
        final EditText address = findViewById(R.id.address);





        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name =  name.getText().toString();
                 String user_number = number.getText().toString();
                 String user_address = address.getText().toString();
                Intent intent = new Intent(getApplicationContext(),GroceryListActivity.class);
                intent.putExtra("name",user_name);
                intent.putExtra("number",user_number);
                intent.putExtra("address",user_address);

                startActivity(intent);
            }
        });
    }
}
