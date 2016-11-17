package com.colantoni.federico.databindingsample;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.colantoni.federico.databindingsample.adapter.QuoteViewHolder;
import com.colantoni.federico.databindingsample.databinding.ActivityMainBinding;
import com.colantoni.federico.databindingsample.model.BindingFields;
import com.colantoni.federico.databindingsample.model.Quote;
import com.colantoni.federico.databindingsample.presenter.MainPresenter;
import com.colantoni.federico.databindingsample.view.MainView;
import com.colantoni.federico.networklibrary.NetworkConnection;
import com.hannesdorfmann.mosby.mvp.MvpActivity;


public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView {

    private ActivityMainBinding binding;

    private BindingFields bindingFields = new BindingFields();

    RecyclerView.Adapter<QuoteViewHolder> adapter = new RecyclerView.Adapter<QuoteViewHolder>() {

        @Override
        public QuoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = getLayoutInflater().inflate(R.layout.quote_item_list_layout, parent, false);

            return new QuoteViewHolder(v);
        }

        @Override
        public void onBindViewHolder(QuoteViewHolder holder, int position) {

            Quote quote = bindingFields.getQuotes().get(position);

            holder.getBinding().setVariable(BR.quote, quote);
            holder.getBinding().executePendingBindings();
        }

        @Override
        public long getItemId(int position) {

            return bindingFields.getQuotes().get(position).hashCode();
        }

        @Override
        public int getItemCount() {

            return bindingFields.getQuotes().size();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, com.colantoni.federico.databindingsample.R.layout.activity_main);

        NetworkConnection.setBaseUrl(BuildConfig.BASE_URL);

        binding.setBindingFields(bindingFields);
        binding.setPresenter(getPresenter());
        binding.quoteEditText.setEnabled(false);

        adapter.setHasStableIds(true);

        RecyclerView quoteList = binding.quoteList;
        quoteList.setAdapter(adapter);
        quoteList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {

        return new MainPresenter(bindingFields);
    }

    @Override
    public void updateSelectedQuote(Quote quote) {

        binding.quoteEditText.setText(quote.getTextQuote());

        getPresenter().saveQuote(quote, bindingFields.getQuotes());
    }
}
