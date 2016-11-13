package com.colanton.federico.databindingsample;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;

import com.colanton.federico.databindingsample.databinding.ActivityMainBinding;
import com.colanton.federico.databindingsample.model.User;
import com.colanton.federico.databindingsample.presenter.MainPresenter;
import com.colanton.federico.databindingsample.view.MainView;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

import java.util.Locale;


public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView {

    private static final String S = "Hello world! My name is %s";

    private ActivityMainBinding binding;

    private User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setUser(user);
        binding.setPresenter(getPresenter());
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {

        return new MainPresenter(user);
    }

    @Override
    public void updateTextView(Editable text) {

        binding.helloWorld.setText(String.format(Locale.getDefault(), S, text));
    }
}
