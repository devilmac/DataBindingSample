package com.colantoni.federico.databindingsample.presenter;


import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Toast;

import com.colantoni.federico.databindingsample.model.BindingFields;
import com.colantoni.federico.databindingsample.service.Forismatic;
import com.colantoni.federico.databindingsample.service.response.ForismaticGetQuoteResponse;
import com.colantoni.federico.databindingsample.view.MainView;
import com.colantoni.federico.networklibrary.NetworkConnection;
import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;

import java.util.Random;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainPresenter extends MvpNullObjectBasePresenter<MainView> {

    private BindingFields bindingFields;

    public MainPresenter(BindingFields bindingFields) {

        this.bindingFields = bindingFields;
    }

    public void clickButton(View view) {

        bindingFields.changeButtonVisibility();

        NetworkConnection networkConnection = NetworkConnection.getInstance();

        Observable<ForismaticGetQuoteResponse> quoteResponseObservable = networkConnection.initializeServiceInstance(view.getContext(), Forismatic.class).getQuote("getQuote", "en", "json", new Random().nextInt(999999) + 1);

        quoteResponseObservable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(forismaticGetQuoteResponse -> MainPresenter.this.getView().updateTextView(new SpannableStringBuilder(forismaticGetQuoteResponse.getQuoteText())), throwable -> Toast.makeText(view.getContext(), throwable.getMessage() != null ? throwable.getMessage() : "Network or API error", Toast.LENGTH_LONG).show(), () -> bindingFields.dataIsLoaded());
    }
}
