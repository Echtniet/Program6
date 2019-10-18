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
public class prisoner1Fragment extends Fragment {
    public interface PrisonerChoice{
        public void prisonerChoice(int prisonerNumber, String choice);
    }

    private prisoner1Fragment.PrisonerChoice myActivity = null;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        myActivity = (prisoner1Fragment.PrisonerChoice)context;
    }

    public prisoner1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_prisoner1, container, false);
        Button btnBetray = view.findViewById(R.id.btnp1Betray);
        Button btnSilent = view.findViewById(R.id.btnp1Silent);

        btnBetray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.prisonerChoice(1, "betray");
            }
        });
        btnSilent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.prisonerChoice(1, "silent");
            }
        });
        return view;
    }

}
