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

    ToDoItem(String title, String date, String location){
        this.title = title;
        this.date = date;
        this.location = location;
    }

    ToDoItem(Parcel in){
        Object[] arr = in.readArray(String.class.getClassLoader());
        title = arr[0].toString();
        location = arr[1].toString();
        date = arr[2].toString();
    }

    @Override
    public String toString(){
        return title + " : " + location + ", " + date;
    }

    public String[] toArray(){
        String[] newArray = {title,location,date};
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
