package com.example.marvelretrofit;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Superhero implements Parcelable {

    @SerializedName("name")
    private String name;

    @SerializedName("realname")
    private String realname;

    @SerializedName("team")
    private String team;

    @SerializedName("firstappearance")
    private String firstappearance;

    @SerializedName("createdby")
    private String createdby;

    @SerializedName("publisher")
    private String publisher;

    @SerializedName("imageurl")
    private String imageurl;

    @SerializedName("bio")
    private String bio;

    public Superhero(String name) {
        this.name = name;
    }




    public Superhero(String name, String realName, String team, String firstappearance, String createdby, String publisher, String imageurl, String bio) {
        this.name = name;
        this.realname = realName;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.imageurl = imageurl;
        this.bio = bio;
    }

    protected Superhero(Parcel in) {
        name = in.readString();
        realname = in.readString();
        team = in.readString();
        firstappearance = in.readString();
        createdby = in.readString();
        publisher = in.readString();
        imageurl = in.readString();
        bio = in.readString();
    }

    public static final Creator<Superhero> CREATOR = new Creator<Superhero>() {
        @Override
        public Superhero createFromParcel(Parcel in) {
            return new Superhero(in);
        }

        @Override
        public Superhero[] newArray(int size) {
            return new Superhero[size];
        }
    };

    public String getRealName() {
        return realname;
    }

    public String getTeam() {
        return team;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public String getCreatedby() {
        return createdby;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getBio() {
        return bio;
    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.name);
        parcel.writeValue(this.realname);
        parcel.writeValue(this.team);
        parcel.writeValue(this.firstappearance);
        parcel.writeValue(this.createdby);
        parcel.writeValue(this.publisher);
        parcel.writeValue(this.imageurl);
        parcel.writeValue(this.bio);
    }
}
