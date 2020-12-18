package ua.application.statisticsapplication;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class IncomeSettingsFragment extends Fragment implements View.OnClickListener {
    AppDatabase db;
    IncomeDao incomeDao;
    EditText edtDate, edtNumLiter, edtPriceLiter, edtSumm;
    Button btnCalculateFuel, btnAddFuel;
    String data;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.income_settinsfragment, null);


        edtDate = (EditText)v.findViewById(R.id.edtDateIncome);

        edtNumLiter = (EditText)v.findViewById(R.id.edtNumLiter);
        edtPriceLiter  = (EditText)v.findViewById(R.id.edtPriceTwo);
        edtSumm = (EditText)v.findViewById(R.id.edtSunFuel);

        btnCalculateFuel = (Button)v.findViewById(R.id.btnCalculateFuel);
        btnAddFuel = (Button)v.findViewById(R.id.btnAddFuel);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        data = sdf.format(new Date(System.currentTimeMillis()));
        edtDate.setText(data);

        db = App.getInstance().getDatabase();
        incomeDao = db.incomeDao();

        btnCalculateFuel.setOnClickListener(this);
        btnAddFuel.setOnClickListener(this);

        return  v;
    }

    @Override
    public void onClick(View v) {
        Income income = new Income();
        float sum = 0;
        switch (v.getId()){
            case R.id.btnCalculateFuel:
                if(!edtNumLiter.getText().equals("")&&!edtPriceLiter.getText().equals("")&&!edtSumm.getText().equals("")){
                    sum = (float)Long.parseLong(String.valueOf(edtNumLiter.getText()))*Long.parseLong(String.valueOf(edtPriceLiter.getText()));
                    edtSumm.setText(String.valueOf(sum));
                }
                break;
            case R.id.btnAddFuel:
                if(!edtNumLiter.getText().equals("")&&!edtPriceLiter.getText().equals("")&&!edtSumm.getText().equals("")){
                    income.setDat(data);
                    income.setNumLiter(String.valueOf(edtNumLiter.getText()));
                    income.setSumm(String.valueOf(edtSumm.getText()));
                    incomeDao.insert(income);
                }
                break;
        }
    }
}