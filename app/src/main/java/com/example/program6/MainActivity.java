package com.example.program6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements prisoner1Fragment.PrisonerChoice, prisoner2Fragment.PrisonerChoice {

    private int currentPrisoner;
    private String prisoner1Choice = null;
    private String prisoner2Choice = null;
    private prisoner1Fragment prisoner1Frag = null;
    private prisoner2Fragment prisoner2Frag = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView lblResult = findViewById(R.id.lblResult);
        currentPrisoner = 1;
        if(savedInstanceState != null){
            prisoner1Choice = savedInstanceState.getString("p1Choice", "");
            prisoner2Choice = savedInstanceState.getString("p2Choice", "");
            currentPrisoner = savedInstanceState.getInt("currentPrisoner", -1);
            lblResult.setText(savedInstanceState.getString("result", ""));
        }

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        prisoner1Frag = new prisoner1Fragment();
        prisoner2Frag = new prisoner2Fragment();
        transaction.add(R.id.prisonerContainer,prisoner1Frag);
        transaction.add(R.id.prisonerContainer,prisoner2Frag);
        if (currentPrisoner == 1){
            transaction.hide(prisoner2Frag);
            transaction.commit();
        }else if(currentPrisoner == 2){
            transaction.hide(prisoner1Frag);
            transaction.commit();
        }else{
            transaction.hide(prisoner1Frag);
            transaction.hide(prisoner2Frag);
            transaction.commit();
        }
    }

    public void prisonerChoice(int prisoner, String choice){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();


        if (currentPrisoner == 1 ){
            prisoner1Choice = choice;
            currentPrisoner++;
            transaction.hide(prisoner1Frag);
            transaction.show(prisoner2Frag);
            transaction.commit();
        }else{
            prisoner2Choice = choice;
            currentPrisoner++;
            transaction.hide(prisoner2Frag);
            transaction.commit();
            TextView lblResult = findViewById(R.id.lblResult);
            if (prisoner1Choice.equals("betray") && prisoner2Choice.equals("betray")){
                lblResult.setText("Prisoner 1 - Betrayal gains 1\nPrisoner 2 - Betrayal gains 1");
            }else if (prisoner1Choice.equals("silent") && prisoner2Choice.equals("silent")){
                lblResult.setText("Prisoner 1 - Silence gains 3\nPrisoner 2 - Silence gains 3");
            }else if (prisoner1Choice.equals("betray") && prisoner2Choice.equals("silent")){
                lblResult.setText("Prisoner 1 - Betrayal gains 5\nPrisoner 2 - Silence gains 0");
            }else{
                lblResult.setText("Prisoner 1 - Silence gains 0\nPrisoner 2 - Betrayal gains 5");
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle saved){
        super.onSaveInstanceState(saved);
        TextView lblResult = findViewById(R.id.lblResult);
        saved.putInt("currentPrisoner", currentPrisoner);
        saved.putString("p1Choice", prisoner1Choice);
        saved.putString("p2Choice", prisoner2Choice);
        saved.putString("result", lblResult.getText().toString());
    }
}
