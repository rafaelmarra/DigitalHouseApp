package dh.com.digitalhouseapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dh.com.digitalhouseapp.R;
import dh.com.digitalhouseapp.adapter.RecyclerViewColearningAdapter;
import dh.com.digitalhouseapp.model.dao.ColearnDao;


public class ColearningFragment extends Fragment {


    public ColearningFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_colearning, container, false);

        ColearnDao colearnDao = new ColearnDao();

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_colearning_id);
        recyclerView.setAdapter(new RecyclerViewColearningAdapter(colearnDao.getColearns(getContext())));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

}
