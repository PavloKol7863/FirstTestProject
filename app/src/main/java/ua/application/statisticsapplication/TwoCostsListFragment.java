package ua.application.statisticsapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class TwoCostsListFragment extends ListFragment {
    AppDatabase db;
    CostsTwoDao cosTwoDao;
    List<CostsTwo> costsTwoList;
    ArrayAdapter<String> adapter;
    String[] data;
    ArrayList<String> arrayList;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        db = App.getInstance().getDatabase();

        cosTwoDao = db.costsTwoDao();

        costsTwoList = cosTwoDao.getAll();

        createOutput();
        data = arrayList.toArray(new String[0]);
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data);
        if(costsTwoList.size()!=0)
            setListAdapter(adapter);
        else{

        }
    }
    public void createOutput(){
        arrayList = new ArrayList<>();
        for (CostsTwo to:costsTwoList){
            arrayList.add(to.getId()+"\t|"+to.getArea()+"\t|"+to.getSumm());
        }
    }
}
