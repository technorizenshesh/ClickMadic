package com.technorizen.crysco.pharmacy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.ActivityProductDetailBinding;

public class ProductDetailActivity extends AppCompatActivity {

    Context mContext = ProductDetailActivity.this;
    ActivityProductDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_product_detail);

        init();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        binding.btMyCart.setOnClickListener(v -> {
            startActivity(new Intent(mContext,MyCartActivity.class));
        });

    }


}
