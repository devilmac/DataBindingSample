package com.colanton.federico.databindingsample.presenter;


import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Toast;

import com.colanton.federico.databindingsample.model.BindingFields;
import com.colanton.federico.databindingsample.service.Forismatic;
import com.colanton.federico.databindingsample.service.response.ForismaticGetQuoteResponse;
import com.colanton.federico.databindingsample.view.MainView;
import com.colantoni.federico.networklibrary.NetworkConnection;
import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class MainPresenter extends MvpNullObjectBasePresenter<MainView> {

    private BindingFields bindingFields;

    public MainPresenter(BindingFields bindingFields) {

        this.bindingFields = bindingFields;
    }

    public void clickButton(View view) {

        bindingFields.changeButtonVisibility();

        NetworkConnection networkConnection = NetworkConnection.getInstance();

        Observable<ForismaticGetQuoteResponse> quoteResponseObservable = networkConnection.initializeServiceInstance(view.getContext(), Forismatic.class).getQuote("getQuote", "en", "json", null);

        quoteResponseObservable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Action1<ForismaticGetQuoteResponse>() {

            @Override
            public void call(ForismaticGetQuoteResponse forismaticGetQuoteResponse) {

                MainPresenter.this.getView().updateTextView(new SpannableStringBuilder(forismaticGetQuoteResponse.getQuoteText()));
            }
        }, throwable -> Toast.makeText(view.getContext(), throwable.getMessage() != null ? throwable.getMessage() : "Network or API error", Toast.LENGTH_LONG).show(), new Action0() {

            @Override
            public void call() {

                bindingFields.dataIsLoaded();
            }
        });
    }
}
