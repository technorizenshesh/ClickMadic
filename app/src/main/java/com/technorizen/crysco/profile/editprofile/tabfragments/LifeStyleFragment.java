package com.technorizen.crysco.profile.editprofile.tabfragments;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.FragmentLifeStyleBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class LifeStyleFragment extends Fragment {

    Context mContext;
    FragmentLifeStyleBinding binding;

    public LifeStyleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_life_style, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private void init() {

        binding.tvSmoking.setOnClickListener(v -> {
            addSmokingDialog();
        });

        binding.tvAlcohalComp.setOnClickListener(v -> {
            addAlchohalCompDialog();
        });

        binding.tvActivityLevel.setOnClickListener(v -> {
            addActiveDialog();
        });

        binding.tvFoodPreference.setOnClickListener(v -> {
            addDietConsistDialog();
        });

        binding.tvOccupation.setOnClickListener(v -> {
            addOccupationDialog();
        });

    }

    private void addSmokingDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.life_per_day_cigrate_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView next = dialog.findViewById(R.id.next);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        next.setOnClickListener(v -> {
            addAlchohalCompDialog();
        });

        dialog.show();
    }

    private void addAlchohalCompDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.life_alchohal_perday_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView next = dialog.findViewById(R.id.next);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        next.setOnClickListener(v -> {
            addActiveDialog();
        });

        dialog.show();

    }

    private void addActiveDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.life_active_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView next = dialog.findViewById(R.id.next);
        TextView back = dialog.findViewById(R.id.back);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        back.setOnClickListener(v -> {
            dialog.dismiss();
        });

        next.setOnClickListener(v -> {
            addDietConsistDialog();
        });

        dialog.show();
    }

    private void addDietConsistDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.life_consist_diet_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView next = dialog.findViewById(R.id.next);
        TextView back = dialog.findViewById(R.id.back);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        back.setOnClickListener(v -> {
            dialog.dismiss();
        });

        next.setOnClickListener(v -> {
            addOccupationDialog();
        });

        dialog.show();
    }

    private void addOccupationDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.life_profession_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView save = dialog.findViewById(R.id.save);
        TextView back = dialog.findViewById(R.id.back);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        back.setOnClickListener(v -> {
            dialog.dismiss();
        });

        save.setOnClickListener(v -> {
            dialog.dismiss();
            getActivity().finish();
        });

        dialog.show();
    }

}
