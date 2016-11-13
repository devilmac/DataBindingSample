package com.colanton.federico.databindingsample.presenter;


import android.text.SpannableStringBuilder;
import android.view.View;

import com.colanton.federico.databindingsample.model.User;
import com.colanton.federico.databindingsample.view.MainView;
import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;


public class MainPresenter extends MvpNullObjectBasePresenter<MainView> {

    private User user;

    public MainPresenter(User user) {

        this.user = user;
    }

    public void clickButton(View view) {

        SpannableStringBuilder s = new SpannableStringBuilder();
        s.append("Ciccio Baciccio");

        user.changeButtonVisibility();

        getView().updateTextView(s);
    }
}
