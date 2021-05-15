package com.technorizen.crysco.onlinedoctors.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.technorizen.crysco.Constant.BaseClass;
import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.ActivityBookingPaymentBinding;
import com.technorizen.crysco.labathome.activities.AppointmentHistory;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import www.develpoeramit.mapicall.ApiCallBuilder;

public class BookingPaymentActivity extends AppCompatActivity {

    Context mContext = BookingPaymentActivity.this;
    ActivityBookingPaymentBinding binding;
    private HashMap<String, String> param;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_booking_payment);
        init();

    }

    private void init() {
        param=(HashMap<String,String>)getIntent().getExtras().getSerializable("param");
        param.put("payment_type","card");
        binding.ivBack.setOnClickListener(v -> {
            finish();
        });
        binding.btnContinue.setOnClickListener(v -> {
            addBooking();
        });
        binding.llCash.setOnClickListener(v->{
            param.put("payment_type","cash");
            binding.tvCreditCart.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,0,0);
            binding.imgCash.setImageResource(R.drawable.ic_check_button_blue);
            binding.imgBankTransfer.setImageResource(0);
        });
        binding.tvCreditCart.setOnClickListener(v->{
            param.put("payment_type","card");
            binding.tvCreditCart.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_check_button_blue,0);
            binding.imgCash.setImageResource(0);
            binding.imgBankTransfer.setImageResource(0);
        });
        binding.layoutBankTransfer.setOnClickListener(v->{
            param.put("payment_type","bank_transfer");
            binding.tvCreditCart.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,0,0);
            binding.imgCash.setImageResource(0);
            binding.imgBankTransfer.setImageResource(R.drawable.ic_check_button_blue);
        });


    }
    private void addBooking(){
        ApiCallBuilder.build(this).setUrl(BaseClass.get().add_booking())
                .setParam(param).isShowProgressBar(true)
                .execute(new ApiCallBuilder.onResponse() {
                    @Override
                    public void Success(String response) {
                        try {
                            JSONObject object=new JSONObject(response);
                            if (object.getString("status").contains("1")){
                                Toast.makeText(mContext, "Appointment submitted successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(mContext, AppointmentHistory.class));
                                finish();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void Failed(String error) {

                    }
                });
    }


}
