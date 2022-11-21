package com.example.notes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
            int index = arguments.getInt(ARG_INDEX);
            TextView tvNote = view.findViewById(R.id.textNote);
            String[] note = getResources().getStringArray(R.array.notes);
            tvNote.setText(note[index]);
            tvNote.setTextSize(28);
            TextView tvNoteDesc = view.findViewById(R.id.textDescription);
            String[] note_description = getResources().getStringArray(R.array.notes_detail);
            tvNoteDesc.setText(note_description[index]);
            tvNoteDesc.setTextSize(24);
        }
    }

    public static NotesDetailFragment newInstance(int index) {
        NotesDetailFragment fragment = new NotesDetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }
}
