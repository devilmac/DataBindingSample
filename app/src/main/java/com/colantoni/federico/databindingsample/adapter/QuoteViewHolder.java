package com.colantoni.federico.databindingsample.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.colantoni.federico.databindingsample.R;


public class QuoteViewHolder extends RecyclerView.ViewHolder {

    //    private ViewDataBinding binding;

    private TextView quote;

    public QuoteViewHolder(View itemView) {

        super(itemView);
        //        binding = DataBindingUtil.bind(itemView);

        quote = (TextView) itemView.findViewById(R.id.quote);
    }

    //    public ViewDataBinding getBinding() {
    //
    //        return binding;
    //    }

    public TextView getQuote() {

        return quote;
    }
}
