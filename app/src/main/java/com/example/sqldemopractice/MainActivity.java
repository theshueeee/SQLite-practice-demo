package com.example.sqldemopractice;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn_viewAll, btn_add;
    TextView et_name, et_age;
    Switch sw_active;
    ListView lv_customerList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            btn_add=findViewById(R.id.btn_add);
            btn_viewAll=findViewById(R.id.btn_viewAll);
            et_name=findViewById(R.id.et_name);
            et_age=findViewById(R.id.et_age);
            sw_active=findViewById(R.id.sw_active);
            lv_customerList=findViewById(R.id.lv_customerList);

            btn_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CustomerModel customerModel;
                    try {
                        customerModel = new CustomerModel(-1,et_name.getText().toString(), Integer.parseInt(et_age.getText().toString()), sw_active.isChecked());
                        Toast.makeText(MainActivity.this, customerModel.toString(), Toast.LENGTH_SHORT).show();

                    }catch(Exception e){
                        Toast.makeText(MainActivity.this, "Error in creating customer", Toast.LENGTH_SHORT).show();
                        customerModel = new CustomerModel(-1, "error", 0, false);
                    }

                    DatabaseHelper databaseHelper= new DatabaseHelper(MainActivity.this);
                    boolean success = databaseHelper.addOne(customerModel);
                    Toast.makeText(MainActivity.this, "Success: " + success, Toast.LENGTH_SHORT).show();


                };
        });
    }
}