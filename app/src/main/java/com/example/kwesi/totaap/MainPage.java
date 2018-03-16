package com.example.kwesi.totaap;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    RecyclerView toDoView;
    ToDoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


        //Creates listeners for the buttons
        TextView addButton = findViewById(R.id.add_button);
        TextView removeButton = findViewById(R.id.remove_button);
        TextView checkButton = findViewById(R.id.check_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(view.getContext(),AddNew.class);
                startActivityForResult(addIntent,0); //wait for data from AddNew
            }
        });
        removeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });
        checkButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });

        toDoView = findViewById(R.id.to_do_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        toDoView.setLayoutManager(layoutManager);
        toDoView.setHasFixedSize(true);
        adapter = new ToDoAdapter(new ToDoItem[0],toDoView);
        toDoView.setAdapter(adapter);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == AddNew.resultCodes.RETURN_VALUE.ordinal()){ //when we are recieving a single value
            ToDoItem[] newItem = {(ToDoItem) data.getParcelableExtra("item")};
            adapter.add(newItem);
        }
        else if(resultCode == AddNew.resultCodes.RETURN_ARRAY.ordinal()){
            adapter.add((ToDoItem[]) data.getParcelableArrayExtra("item"));
        }
        else if(resultCode == AddNew.resultCodes.CANCEL.ordinal()){
            //Do nothing if cancel
        }

    }
}
