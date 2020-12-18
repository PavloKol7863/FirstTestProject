package ua.application.statisticsapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.app.FragmentTransaction;
import android.os.Bundle;

public class IncomeActivity extends AppCompatActivity {
IncomeSettingsFragment inStFrag;
FragmentTransaction fTrans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.income);

        inStFrag = new IncomeSettingsFragment();

        fTrans = getFragmentManager().beginTransaction();
        fTrans.add(R.id.frgmIncome, inStFrag).commit();
    }

}