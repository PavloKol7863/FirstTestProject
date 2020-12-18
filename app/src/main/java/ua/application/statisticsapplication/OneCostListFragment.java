package ua.application.statisticsapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class OneCostListFragment extends ListFragment {
    AppDatabase db;
    CostsOneDao cosOneDao;
    List<CostsOne> costsOneList;
    ArrayAdapter<String> adapter;
    String[] data;
    ArrayList<String> arrayList;




    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        db = App.getInstance().getDatabase();
        cosOneDao = db.costsOneDao();
        costsOneList = cosOneDao.getAll();

        createOutput();
        data = arrayList.toArray(new String[0]);

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data);
        if(costsOneList.size()!=0)
            setListAdapter(adapter);
    }
    public void createOutput(){
        arrayList = new ArrayList<>();
        for (CostsOne co:costsOneList){
            arrayList.add(co.getId()+"\t|"+co.getDat()+"\t|"+co.getSumm());
        }
    }

}

