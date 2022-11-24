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

public class NotesDetailFragment extends Fragment {
    static private final String ARG_INDEX = "index";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null)
            requireActivity().getSupportFragmentManager().popBackStack();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Notes notes = arguments.getParcelable(ARG_INDEX);
            TextView tvNote = view.findViewById(R.id.textNote);
            tvNote.setText(notes.getName());
            tvNote.setTextSize(28);
            TextView tvNoteDesc = view.findViewById(R.id.textDescription);
            tvNoteDesc.setText(notes.getDescription());
            tvNoteDesc.setTextSize(24);
            TextView tvDate = view.findViewById(R.id.textDate);
            tvDate.setText(notes.getDate());
            tvDate.setTextSize(24);
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Button btnBack = view.findViewById(R.id.btn_back);
            btnBack.setOnClickListener(view1 -> requireActivity().getSupportFragmentManager().popBackStack());
        }
    }

    public static NotesDetailFragment newInstance(Notes notes) {
        NotesDetailFragment fragment = new NotesDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_INDEX, notes);
        fragment.setArguments(args);
        return fragment;
    }
}
