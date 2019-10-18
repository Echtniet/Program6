package com.example.program6;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class prisoner2Fragment extends Fragment {
    public interface PrisonerChoice{
        public void prisonerChoice(int prisonerNumber, String choice);
    }

    private prisoner2Fragment.PrisonerChoice myActivity = null;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        myActivity = (prisoner2Fragment.PrisonerChoice)context;
    }

    public prisoner2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_prisoner2, container, false);
        Button btnBetray = view.findViewById(R.id.btnp2Betray);
        Button btnSilent = view.findViewById(R.id.btnp2Silent);

        btnBetray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.prisonerChoice(2, "betray");
            }
        });
        btnSilent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.prisonerChoice(2, "silent");
            }
        });
        return view;
    }

}
