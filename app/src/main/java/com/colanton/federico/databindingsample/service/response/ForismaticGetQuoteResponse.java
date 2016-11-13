package com.colanton.federico.databindingsample.service.response;


import android.os.Parcel;
import android.os.Parcelable;


public class ForismaticGetQuoteResponse implements Parcelable {

    public static final Creator<ForismaticGetQuoteResponse> CREATOR = new Creator<ForismaticGetQuoteResponse>() {

        @Override
        public ForismaticGetQuoteResponse createFromParcel(Parcel source) {

            ForismaticGetQuoteResponse var = new ForismaticGetQuoteResponse();
            var.quoteLink = source.readString();
            var.quoteText = source.readString();
            var.senderName = source.readString();
            var.quoteAuthor = source.readString();
            var.senderLink = source.readString();
            return var;
        }

        @Override
        public ForismaticGetQuoteResponse[] newArray(int size) {

            return new ForismaticGetQuoteResponse[size];
        }
    };

    private String quoteLink;

    private String quoteText;

    private String senderName;

    private String quoteAuthor;

    private String senderLink;

    public String getQuoteLink() {

        return this.quoteLink;
    }

    public void setQuoteLink(String quoteLink) {

        this.quoteLink = quoteLink;
    }

    public String getQuoteText() {

        return this.quoteText;
    }

    public void setQuoteText(String quoteText) {

        this.quoteText = quoteText;
    }

    public String getSenderName() {

        return this.senderName;
    }

    public void setSenderName(String senderName) {

        this.senderName = senderName;
    }

    public String getQuoteAuthor() {

        return this.quoteAuthor;
    }

    public void setQuoteAuthor(String quoteAuthor) {

        this.quoteAuthor = quoteAuthor;
    }

    public String getSenderLink() {

        return this.senderLink;
    }

    public void setSenderLink(String senderLink) {

        this.senderLink = senderLink;
    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.quoteLink);
        dest.writeString(this.quoteText);
        dest.writeString(this.senderName);
        dest.writeString(this.quoteAuthor);
        dest.writeString(this.senderLink);
    }
}
