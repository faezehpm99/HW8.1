package com.example.hw81;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private  String name;
    private  String pass;

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public User(User user) {
    }


    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.pass);
        dest.writeString(this.name);
    }

    protected User(Parcel in) {
        this.pass = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
