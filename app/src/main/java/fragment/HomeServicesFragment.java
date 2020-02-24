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

import Adapter.HomeServicesRecycleAdapter;
import ModelClass.HomeCategoryModelClass;
import bd.piniti.service_pro.R;


public class HomeServicesFragment extends Fragment {



    private View view;



    private ArrayList<HomeCategoryModelClass> homeCategoryModelClasses;
    private RecyclerView recyclerView;
    private HomeServicesRecycleAdapter bAdapter;


    private Integer[] image = {R.drawable.fans, R.drawable.lights, R.drawable.inverter,
            R.drawable.full_home_health_check1, R.drawable.fans, R.drawable.lights,
            R.drawable.inverter, R.drawable.fans, R.drawable.lights, R.drawable.inverter,
            R.drawable.lights, R.drawable.inverter, R.drawable.full_home_health_check1,
            R.drawable.fans, R.drawable.lights};
    private String[] title = {"Home Maid", "Landscaper", "Gardener", "Additions & Remodels",
            "Cabinets & Countertop", "Carpet", "Doors & Windows", "Driveway, Patios & Walk",
            "Fences", "Interior Designer", "Roofing", "Tile & Stone", "Walls & Ceilings", "Construction Supply", "Property Management"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home_services, container, false);


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
        bAdapter = new HomeServicesRecycleAdapter (getActivity(),homeCategoryModelClasses);
        recyclerView.setAdapter(bAdapter);

        return  view;
    }


}
