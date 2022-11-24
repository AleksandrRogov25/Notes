package com.example.notes;

import android.os.Parcel;
import android.os.Parcelable;

public class Notes implements Parcelable {
    private final String name;
    private final String description;
    private final String date;


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }


    public Notes(String name, String description, String date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    protected Notes(Parcel in) {
        name = in.readString();
        description = in.readString();
        date = in.readString();
    }

    public static final Creator<Notes> CREATOR = new Creator<Notes>() {
        @Override
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        @Override
        public Notes[] newArray(int size) {
            return new Notes[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(date);
    }
}
