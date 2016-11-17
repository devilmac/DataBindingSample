package com.colantoni.federico.databindingsample.view;


import com.colantoni.federico.databindingsample.model.Quote;
import com.hannesdorfmann.mosby.mvp.MvpView;


public interface MainView extends MvpView {

    void updateSelectedQuote(Quote text);
}
