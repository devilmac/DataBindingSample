package com.colantoni.federico.databindingsample.view;


import android.text.Editable;

import com.hannesdorfmann.mosby.mvp.MvpView;


public interface MainView extends MvpView {

    void updateTextView(Editable text);
}
