package com.example.notes;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AboutProgramFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about_program, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            TextView tv = view.findViewById(R.id.textView);
            tv.setText("Что-то о программе");
            tv.setTextSize(30);
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Button btnBack = view.findViewById(R.id.btn_about_back);
            btnBack.setOnClickListener(view1 ->
                    requireActivity().getSupportFragmentManager().popBackStack());
        }
    }

    public static AboutProgramFragment newInstance(String param1) {
        AboutProgramFragment fragment = new AboutProgramFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }


}