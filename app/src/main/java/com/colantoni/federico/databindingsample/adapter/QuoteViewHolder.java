package com.colantoni.federico.databindingsample.adapter;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class QuoteViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding binding;

    private TextView quote;

    private TextView author;

    public QuoteViewHolder(View itemView) {

        super(itemView);
        binding = DataBindingUtil.bind(itemView);

        //        quote = (TextView) itemView.findViewById(R.id.quote);
        //        author = (TextView) itemView.findViewById(R.id.author);
    }

    public ViewDataBinding getBinding() {

        return binding;
    }

    public TextView getQuote() {

        return quote;
    }

    public TextView getAuthor() {

        return author;
    }
}
