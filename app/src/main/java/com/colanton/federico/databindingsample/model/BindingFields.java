package com.colanton.federico.databindingsample.model;


import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;


public class BindingFields extends BaseObservable {

    public final ObservableBoolean isLoaded = new ObservableBoolean(true);

    public final ObservableBoolean isButtonVisible = new ObservableBoolean();

    public void changeButtonVisibility() {

        isButtonVisible.set(!isButtonVisible.get());
    }

    public void dataIsLoaded() {

        isLoaded.set(true);
        isButtonVisible.set(!isButtonVisible.get());
    }
}
