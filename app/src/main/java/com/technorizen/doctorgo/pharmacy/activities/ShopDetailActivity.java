package com.technorizen.doctorgo.pharmacy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.ActivityShopDetailBinding;

public class ShopDetailActivity extends AppCompatActivity {

    Context mContext = ShopDetailActivity.this;
    ActivityShopDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_shop_detail);

        init();

    }

    private void init() {

        binding.cvItem1.setOnClickListener(v -> {
           startActivity(new Intent(mContext,ProductDetailActivity.class));
        });

        binding.cvItem1.setOnClickListener(v -> {
           startActivity(new Intent(mContext,ProductDetailActivity.class));
        });

    }


}
