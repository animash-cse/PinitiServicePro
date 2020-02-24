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

import Adapter.CleaningRecycleAdapter;
import ModelClass.HomeCategoryModelClass;
import bd.piniti.service_pro.R;


public class CleaningFragment extends Fragment {

    private View view;

    private ArrayList<HomeCategoryModelClass> homeCategoryModelClasses;
    private RecyclerView recyclerView;
    private CleaningRecycleAdapter bAdapter;


    private  Integer image[] = {R.drawable.home_deep_cleaning,R.drawable.kitchen_deep_cleaning,R.drawable.carpet_cleaning,R.drawable.bathroom_cleaning,
            R.drawable.sofa_cleaning,R.drawable.sweep_mop};
    private String title[] = {"Home Deep Cleaning","Kitchen Deep Cleaning","Carpet Cleaning","Bathroom Cleaning","Sofa Cleaning","Sweep & Mop"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cleaning, container, false);

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
        bAdapter = new CleaningRecycleAdapter(getActivity(),homeCategoryModelClasses);
        recyclerView.setAdapter(bAdapter);

        return  view;
    }


}
