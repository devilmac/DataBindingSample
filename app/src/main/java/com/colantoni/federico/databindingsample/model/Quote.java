package com.colantoni.federico.databindingsample.model;


import android.os.Parcel;
import android.os.Parcelable;


public class Quote implements Parcelable {

    public static final Parcelable.Creator<Quote> CREATOR = new Parcelable.Creator<Quote>() {

        @Override
        public Quote createFromParcel(Parcel source) {

            return new Quote(source);
        }

        @Override
        public Quote[] newArray(int size) {

            return new Quote[size];
        }
    };

    private String author;

    private String textQuote;

    public Quote(String author, String textQuote) {

        this.author = author;
        this.textQuote = textQuote;
    }

    protected Quote(Parcel in) {

        this.author = in.readString();
        this.textQuote = in.readString();
    }

    public String getTextQuote() {

        return textQuote;
    }

    public void setTextQuote(String textQuote) {

        this.textQuote = textQuote;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.author);
        dest.writeString(this.textQuote);
    }
}
