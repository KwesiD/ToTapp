package com.example.kwesi.totaap;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Kwesi on 3/14/2018.
 */

public class ToDoItem implements Parcelable{
    private String title;
    private String date;
    private String location;
    private String color;

    ToDoItem(String title, String date, String location,String color){
        this.title = title;
        this.date = date;
        this.location = location;
        this.color = color;
    }

    ToDoItem(Parcel in){
        Object[] arr = in.readArray(String.class.getClassLoader());
        title = arr[0].toString();
        location = arr[1].toString();
        date = arr[2].toString();
        color = arr[3].toString();
    }

    @Override
    public String toString(){
        String newString = title;
        if(!location.trim().equals("")){
            newString += " : " + location;
        }
        if(!date.trim().equals("")){
            newString += ", " + date;
        }
        return newString;
    }

    public int getColor(){
        return Integer.parseInt(this.color);
    }
    public String[] toArray(){
        String[] newArray = {title,location,date,color};
        return newArray;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeArray(this.toArray());
    }

    public static final Parcelable.Creator<ToDoItem> CREATOR = new Parcelable.Creator<ToDoItem>(){

        public ToDoItem createFromParcel(Parcel in){
            return new ToDoItem(in);
        }

        public ToDoItem[] newArray(int size){
            return new ToDoItem[size];
        }
    };
}
