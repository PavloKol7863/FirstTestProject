package ua.application.statisticsapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class HomeFragment extends Fragment implements View.OnClickListener {
    AppDatabase db;
    CostsOneDao cosOneDao;
    CostsTwoDao cosTwoDao;
    EditText edtWidth, edtHeight, edtArea, edtSumm, edtPrice;
    Button btnCalculateArea, btnCalculateSum, btnAdd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment, null);

        edtWidth = (EditText)v.findViewById(R.id.edtWeidth);
        edtHeight = (EditText)v.findViewById(R.id.edtHeight);
        edtArea = (EditText)v.findViewById(R.id.edtArea);
        edtSumm = (EditText)v.findViewById(R.id.edtSum);
        edtPrice = (EditText)v.findViewById(R.id.edtPriceArea);


        btnCalculateArea = (Button)v.findViewById(R.id.btnCalculateArea);
        btnCalculateSum = (Button)v.findViewById(R.id.btnCalculateSum);
        btnAdd = (Button)v.findViewById(R.id.btnAddCosts);

        db = App.getInstance().getDatabase();
        cosOneDao = db.costsOneDao();
        cosTwoDao = db.costsTwoDao();



        btnAdd.setOnClickListener(this);
        btnCalculateArea.setOnClickListener(this);
        btnCalculateSum.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        CostsOne costsOne = new CostsOne();
        CostsTwo costsTwo = new CostsTwo();
float area, sum;
        switch(v.getId()){
            case R.id.btnCalculateArea:
                if(!edtHeight.getText().equals("") && !edtWidth.getText().equals("")){
                    area = Long.parseLong(String.valueOf(edtHeight.getText())) * Long.parseLong(String.valueOf(edtWidth.getText()));
                    area = (float) (area*0.0001);
                    edtArea.setText(String.valueOf(area));
                }
                break;
            case R.id.btnCalculateSum:
                if(!edtArea.getText().equals("") && !edtPrice.getText().equals("")){
                    sum = (float)Float.parseFloat(String.valueOf(edtArea.getText()))*Long.parseLong(String.valueOf(edtPrice.getText()));
                    edtSumm.setText(String.valueOf(sum));
                }
                break;
            case R.id.btnAddCosts:
                if(!edtArea.getText().equals("") && !edtSumm.equals("")){
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    String data = sdf.format(new Date(System.currentTimeMillis()));
                    costsOne.setDat(data);
                    costsOne.setSumm(String.valueOf(edtSumm.getText()));
                    cosOneDao.insert(costsOne);

                    costsTwo.setArea(String.valueOf(edtArea.getText()));
                    costsTwo.setSumm(String.valueOf(edtSumm.getText()));
                    cosTwoDao.insert(costsTwo);
                }else

                break;
        }

    }
}
