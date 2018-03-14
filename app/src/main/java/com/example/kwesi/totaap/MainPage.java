package com.example.kwesi.totaap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


        //Creates listeners for the buttons
        TextView addButton = (TextView) findViewById(R.id.add_button);
        TextView removeButton = (TextView) findViewById(R.id.remove_button);
        TextView checkButton = (TextView) findViewById(R.id.check_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(view.getContext(),AddNew.class);
                startActivity(addIntent);
            }
        });
        removeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });
    }
}
