package com.example.kwesi.totaap;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by Kwesi on 3/14/2018.
 */

public class AddNew extends AppCompatActivity {


    public enum resultCodes{RETURN_VALUE,RETURN_ARRAY};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        final EditText toDoBox =  (EditText) findViewById(R.id.to_do_box);
        final EditText locationBox = (EditText) findViewById(R.id.location_box);
        final EditText dateBox = (EditText) findViewById(R.id.date_box);



        Button saveButton = (Button) findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toDo = toDoBox.getText().toString();
                String location = locationBox.getText().toString();
                String date = dateBox.getText().toString();
                //ToDO: Place in Recycler view
                ToDoItem item = new ToDoItem(toDo,date,location);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("item",(Parcelable) item);
                setResult(resultCodes.RETURN_VALUE.ordinal(),resultIntent);
                finish();

            }
        });
    }

}





