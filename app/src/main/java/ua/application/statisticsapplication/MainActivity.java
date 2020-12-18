package ua.application.statisticsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
    }

    public void onClick(View v){
        fTrans = getFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.btnOpen:
                fTrans.add(R.id.frgmCont, homeFragment);
                break;
        }
        fTrans.commit();
    }
}