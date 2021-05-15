package com.technorizen.crysco.profile;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.FragmentWomensCalenderBinding;

import de.hdodenhof.circleimageview.CircleImageView;

public class WomensCalenderFragment extends Fragment {

    Context mContext;
    FragmentWomensCalenderBinding binding;

    public WomensCalenderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_womens_calender, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.llNotes.setOnClickListener(v -> {
            notesDialog();
        });


    }


    private void notesDialog() {

        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.add_notes_dialog);

        CircleImageView ivBack = dialog.findViewById(R.id.ivBack);

        ivBack.setOnClickListener(v -> {
            dialog.dismiss();
        });

        dialog.show();

    }

}
