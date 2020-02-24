package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import Adapter.DevotionalServiceRecycleAdapter;
import ModelClass.HomeCategoryModelClass;
import bd.piniti.service_pro.R;


public class DevotionalServiceFragment extends Fragment {

    private  View view;

    private ArrayList<HomeCategoryModelClass> homeCategoryModelClasses;
    private RecyclerView recyclerView;
    private DevotionalServiceRecycleAdapter bAdapter;


    private  Integer image[] = {R.drawable.packers_movers,R.drawable.packers_movers,R.drawable.packers_movers,R.drawable.packers_movers,R.drawable.packers_movers,R.drawable.packers_movers};
    private String title[] = {"All Devotional Services","Devotional Books","Idol","Temple","Pondit","Devotional Accessories"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_devotional_service, container, false);

        /*category recyclerview code is here*/

        recyclerView = view.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        homeCategoryModelClasses = new ArrayList<>();

        for (int i = 0; i < image.length; i++) {
            HomeCategoryModelClass mycreditList = new HomeCategoryModelClass(image[i],title[i]);
            homeCategoryModelClasses.add(mycreditList);
        }
        bAdapter = new DevotionalServiceRecycleAdapter (getActivity(),homeCategoryModelClasses);
        recyclerView.setAdapter(bAdapter);

        return view;
    }

}
