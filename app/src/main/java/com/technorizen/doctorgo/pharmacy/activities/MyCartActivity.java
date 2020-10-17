package com.technorizen.doctorgo.pharmacy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.ActivityMyCartBinding;

public class MyCartActivity extends AppCompatActivity {

    Context mContext = MyCartActivity.this;
    ActivityMyCartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_my_cart);

        init();

    }

    private void init() {

        binding.btnProceedtopay.setOnClickListener(v -> {
            startActivity(new Intent(mContext,AddTimeAndDateActivity.class));
        });

    }


}
