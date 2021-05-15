package com.technorizen.crysco.onlinedoctors.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.technorizen.crysco.R;
import com.technorizen.crysco.activities.SignUpActivity;
import com.technorizen.crysco.databinding.ActivityBookTestPacakgesOnlineBinding;

public class BookTestPacakgesOnlineActivity extends AppCompatActivity {

    Context mContext = BookTestPacakgesOnlineActivity.this;
    ActivityBookTestPacakgesOnlineBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_book_test_pacakges_online);

        init();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        binding.ivPatientArrow.setOnClickListener(v -> {
            startActivity(new Intent(mContext,BookingPaymentActivity.class));
        });

        binding.ivChildArrow.setOnClickListener(v -> {
            startActivity(new Intent(mContext,ChildInfoForBookingActivity.class));
        });

        binding.ivCreateAccount.setOnClickListener(v -> {
            createAccountDialog();
        });

    }

    private void createAccountDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage("Are you sure you want to create a new account?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        startActivity(new Intent(mContext, SignUpActivity.class));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        startActivity(new Intent(mContext, FillPatientDetailActivity.class));
                    }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


}
