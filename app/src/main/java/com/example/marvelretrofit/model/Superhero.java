package com.example.marvelretrofit.model;

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

    private int id;

    public Superhero() {
    }

    public Superhero(String name, String realname, String team, String firstappearance, String createdby, String publisher, String imageurl, String bio, int id) {
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.imageurl = imageurl;
        this.bio = bio;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
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

    public void setName(String name) {
        this.name = name;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setFirstappearance(String firstappearance) {
        this.firstappearance = firstappearance;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.realname);
        dest.writeString(this.team);
        dest.writeString(this.firstappearance);
        dest.writeString(this.createdby);
        dest.writeString(this.publisher);
        dest.writeString(this.imageurl);
        dest.writeString(this.bio);
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.realname = source.readString();
        this.team = source.readString();
        this.firstappearance = source.readString();
        this.createdby = source.readString();
        this.publisher = source.readString();
        this.imageurl = source.readString();
        this.bio = source.readString();
    }

    protected Superhero(Parcel in) {
        this.name = in.readString();
        this.realname = in.readString();
        this.team = in.readString();
        this.firstappearance = in.readString();
        this.createdby = in.readString();
        this.publisher = in.readString();
        this.imageurl = in.readString();
        this.bio = in.readString();
    }

    public static final Creator<Superhero> CREATOR = new Creator<Superhero>() {
        @Override
        public Superhero createFromParcel(Parcel source) {
            return new Superhero(source);
        }

        @Override
        public Superhero[] newArray(int size) {
            return new Superhero[size];
        }
    };
}
