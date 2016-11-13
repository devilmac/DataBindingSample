package com.colantoni.federico.databindingsample;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;

import com.colantoni.federico.databindingsample.databinding.ActivityMainBinding;
import com.colantoni.federico.databindingsample.model.BindingFields;
import com.colantoni.federico.databindingsample.presenter.MainPresenter;
import com.colantoni.federico.databindingsample.view.MainView;
import com.colantoni.federico.networklibrary.NetworkConnection;
import com.hannesdorfmann.mosby.mvp.MvpActivity;


public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView {

    private ActivityMainBinding binding;

    private BindingFields bindingFields = new BindingFields();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, com.colantoni.federico.databindingsample.R.layout.activity_main);

        NetworkConnection.setBaseUrl(BuildConfig.BASE_URL);

        binding.setBindingFields(bindingFields);
        binding.setPresenter(getPresenter());
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {

        return new MainPresenter(bindingFields);
    }

    @Override
    public void updateTextView(Editable text) {

        binding.helloWorld.setText(text);
    }
}
