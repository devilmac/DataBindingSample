package com.colantoni.federico.databindingsample.model;


import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;


public class BindingFields extends BaseObservable {

    public final ObservableBoolean isLoaded = new ObservableBoolean(true);

    public final ObservableBoolean isButtonVisible = new ObservableBoolean(true);

    private final ObservableArrayList<String> quotes = new ObservableArrayList<>();

    public ObservableArrayList<String> getQuotes() {

        return quotes;
    }

    public void changeButtonVisibility() {

        isButtonVisible.set(!isButtonVisible.get());
        isLoaded.set(false);
    }

    public void dataIsLoaded() {

        isLoaded.set(true);
        isButtonVisible.set(!isButtonVisible.get());
    }
}
