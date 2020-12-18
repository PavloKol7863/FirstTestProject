package ua.application.statisticsapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    FragmentTransaction fTrans;
    EditText edtTime, edtDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();

        edtTime = (EditText)findViewById(R.id.edtTimeHome);
        edtDate = (EditText)findViewById(R.id.edtDateHome);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(new Date(System.currentTimeMillis()));
        edtTime.setText(time);

        sdf = new SimpleDateFormat("dd.MM.yyyy");
        String date = sdf.format(new Date(System.currentTimeMillis()));
        edtDate.setText(date);

    }

    public void onClick(View v){
        Intent intent;
        fTrans = getFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.btnOpen:
                fTrans.add(R.id.frgmCont, homeFragment);
                break;
            case R.id.btnIncome:
                intent = new Intent("application.open.incomescreen");
                startActivity(intent);
                break;
            case R.id.btnCosts:
                intent = new Intent("apllication.open.costsscreen");
                startActivity(intent);
                break;
        }
        fTrans.commit();
    }
}