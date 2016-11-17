package com.colantoni.federico.databindingsample.service.response;


public class ForismaticGetQuoteResponse {

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
}
