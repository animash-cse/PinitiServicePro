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

import Adapter.LocalServicesRecycleAdapter;
import ModelClass.HomeCategoryModelClass;
import bd.piniti.service_pro.R;


public class LocalServicesFragment extends Fragment {


    private View view;


    private ArrayList<HomeCategoryModelClass> homeCategoryModelClasses;
    private RecyclerView recyclerView;
    private LocalServicesRecycleAdapter bAdapter;


    private  Integer image[] = {R.drawable.blocks_leakages,R.drawable.toilet_and_sanitary_work,R.drawable.bathroom_fitting,
            R.drawable.water_tank,R.drawable.full_home_health_check,R.drawable.full_home_health_check};
    private String title[] = {"Tailor","Machine Operator","Driver","Blacksmith","Carpentry","Construction"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_local_services, container, false);


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
        bAdapter = new LocalServicesRecycleAdapter(getActivity(),homeCategoryModelClasses);
        recyclerView.setAdapter(bAdapter);

        return  view;
    }


}
