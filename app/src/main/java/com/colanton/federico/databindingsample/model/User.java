package com.colanton.federico.databindingsample.model;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;
import android.os.Handler;

import java.util.Random;


public class User extends BaseObservable {

    public final ObservableBoolean isLoaded = new ObservableBoolean(true);

    public final ObservableBoolean isButtonVisible = new ObservableBoolean(true);

    private String firstName;

    private String lastName;

    @Bindable
    public String getFirstName() {

        return this.firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    @Bindable
    public String getLastName() {

        return this.lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public void changeButtonVisibility() {

        load(() -> isButtonVisible.set(!isButtonVisible.get()));
    }

    private void load(Runnable onLoaded) {

        isLoaded.set(false);
        new Handler().postDelayed(() -> {
            isButtonVisible.set(!isButtonVisible.get());
            isLoaded.set(true);
        }, new Random().nextInt(3000) + 1000);
    }
}
