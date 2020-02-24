package fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import Adapter.CustomAdapter;
import ModelClass.Team;
import bd.piniti.service_pro.MehndiActivity;
import bd.piniti.service_pro.R;


public class RepairFragment extends Fragment {


    private View view;

    LinearLayout linear_shoes, linear_furniture, linear_machine, linear_engine, linear_motorcycle, linear_auto, linear_water_pump, linear_tools;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_repair, container, false);


        linear_shoes = view.findViewById(R.id.linear_shoes);
        linear_shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MehndiActivity.class);
                startActivity(intent);
            }
        });


        //THE EXPANDABLE
        ExpandableListView elv = view.findViewById(R.id.expandblelistview);
        elv.setBackgroundColor(Color.WHITE);
        ExpandableListView elv2 = view.findViewById(R.id.expandblelistview2);
        elv2.setBackgroundColor(Color.WHITE);

        final ArrayList<Team> electroList = getElectronicsData();
        final ArrayList<Team> homeList = getHomeData();

        //CREATE AND BIND TO ADAPTER
        CustomAdapter electronicAdapter = new CustomAdapter(getActivity(), electroList);
        CustomAdapter homeAdapter = new CustomAdapter(getActivity(), homeList);
        elv.setAdapter(electronicAdapter);
        elv2.setAdapter(homeAdapter);
        elv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                setListViewHeight(parent, groupPosition);
                return false;
            }
        });

        //SET ONCLICK LISTENER
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPos,
                                        int childPos, long id) {

                Toast.makeText(getActivity().getApplicationContext(), electroList.get(groupPos).players.get(childPos), Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        elv2.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                setListViewHeight(parent, groupPosition);
                return false;
            }
        });

        //SET ONCLICK LISTENER
        elv2.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPos,
                                        int childPos, long id) {

                Toast.makeText(getActivity().getApplicationContext(), electroList.get(groupPos).players.get(childPos), Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        return view;
    }

    private void setListViewHeight(ExpandableListView listView, int groupPosition) {
        ExpandableListAdapter listAdapter = listView.getExpandableListAdapter();
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.EXACTLY);
        for (int i = 0; i < listAdapter.getGroupCount(); i++) {
            View groupItem = listAdapter.getGroupView(i, false, null, listView);
            groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

            totalHeight += groupItem.getMeasuredHeight();

            if (((listView.isGroupExpanded(i)) && (i != groupPosition))
                    || ((!listView.isGroupExpanded(i)) && (i == groupPosition))) {
                for (int j = 0; j < listAdapter.getChildrenCount(i); j++) {
                    View listItem = listAdapter.getChildView(i, j, false, null,
                            listView);
                    listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

                    totalHeight += listItem.getMeasuredHeight();

                }
            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        int height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getGroupCount() - 1));
        if (height < 10)
            height = 200;
        params.height = height;
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    //ADD AND GET DATA
    private ArrayList<Team> getElectronicsData() {

        Team t1 = new Team("Electronics");
        t1.players.add("Desktop");
        t1.players.add("Laptop");
        t1.players.add("Smart Phone");
        t1.players.add("Watch");

        ArrayList<Team> allTeams = new ArrayList<Team>();
        allTeams.add(t1);

        return allTeams;

    }

    //ADD AND GET DATA
    private ArrayList<Team> getHomeData() {
        Team t2 = new Team("Home Appliance");
        t2.players.add("Geyser");
        t2.players.add("AC");
        t2.players.add("Washing Machine");
        t2.players.add("Water Purifier");
        t2.players.add("TV");
        t2.players.add("Microwave");
        t2.players.add("Refrigerator");
        t2.players.add("Gas Stove");

        ArrayList<Team> allTeams = new ArrayList<Team>();
        allTeams.add(t2);

        return allTeams;

    }

    public boolean onChildClick(ExpandableListView parent, View v,
                                int groupPosition, int childPosition, long id) {

        v.setBackgroundColor(Color.BLUE);

        return false;
    }

}