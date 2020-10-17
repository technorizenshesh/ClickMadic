package com.technorizen.doctorgo.pharmacy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.ActivityPharmaHomeBinding;

public class PharmaHomeActivity extends AppCompatActivity {

    Context mContext = PharmaHomeActivity.this;
    ActivityPharmaHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_pharma_home);

        init();

    }

    private void init() {

        binding.cvShop1.setOnClickListener(v -> {
            startActivity(new Intent(mContext,ShopDetailActivity.class));
        });

        binding.cvShop1.setOnClickListener(v -> {
            startActivity(new Intent(mContext,ShopDetailActivity.class));
        });

    }


}
