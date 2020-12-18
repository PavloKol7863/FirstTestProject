package ua.application.statisticsapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class IncomeListFragment extends ListFragment {
    AppDatabase db;
    IncomeDao inDao;
    List<Income> incomeList;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        db = App.getInstance().getDatabase();

        inDao = db.incomeDao();
        incomeList = inDao.getAll();

        createOutput();
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arrayList);
        if (incomeList.size() != 0)
            setListAdapter(adapter);
    }
    public void createOutput(){
        arrayList = new ArrayList<>();
        for (Income in:incomeList){
            arrayList.add(in.getId()+"\t|"+in.getDat()+"\t|"+in.getNumLiter()+"\t|"+in.getSumm());
        }
    }
}
