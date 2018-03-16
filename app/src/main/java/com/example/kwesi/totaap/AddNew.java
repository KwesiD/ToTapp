package com.example.kwesi.totaap;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Kwesi on 3/14/2018.
 */

public class AddNew extends AppCompatActivity {


    public enum resultCodes{RETURN_VALUE,RETURN_ARRAY,CANCEL};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        final EditText toDoBox =  (EditText) findViewById(R.id.to_do_box);
        final EditText locationBox = (EditText) findViewById(R.id.location_box);
        final EditText dateBox = (EditText) findViewById(R.id.date_box);
        final ImageView colorIndicator = (ImageView) findViewById(R.id.color_indicator);
        colorIndicator.setBackgroundTintList(ColorStateList.valueOf(0));



        GridLayout colorGrid = findViewById(R.id.color_box);

        for(int i = 0;i < colorGrid.getChildCount();i++){
            colorGrid.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ColorStateList tintList = view.getBackgroundTintList();
                    colorIndicator.setBackgroundTintList(tintList);
                }
            });
        }

/*
       TextView b1 = (TextView) findViewById(R.id.color_button_1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GridLayout parent = (GridLayout) view.getParent();
                int color = view.getBackgroundTintList().getColorForState(new int[]{0},0);
                colorIndicator.setBackgroundTintList(tintList);
            }
        });
*/

        Button saveButton = (Button) findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toDo = toDoBox.getText().toString();
                String location = locationBox.getText().toString();
                String date = dateBox.getText().toString();
                String color = "" + colorIndicator.getBackgroundTintList().getDefaultColor();
                if(toDo.trim().equals("")){
                    Toast.makeText(AddNew.this, "ToDo Item is Required", Toast.LENGTH_SHORT).show();
                }
                else{
                    //ToDO: Place in Recycler view
                    ToDoItem item = new ToDoItem(toDo,date,location,color);
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("item",(Parcelable) item);
                    setResult(resultCodes.RETURN_VALUE.ordinal(),resultIntent);
                    finish();
                }
            }
        });

        Button cancelButton = (Button) findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(resultCodes.CANCEL.ordinal(),intent);
                finish();
            }
        });
    }

}





