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


public class TutorFragment extends Fragment {


    private View view;

    LinearLayout linear_kindergarten;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tutor, container, false);


        linear_kindergarten = view.findViewById(R.id.linear_kindergarten);
        linear_kindergarten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MehndiActivity.class);
                startActivity(intent);
            }
        });


        //THE EXPANDABLE
        ExpandableListView elv = (ExpandableListView) view.findViewById(R.id.expandblelistview);
        elv.setBackgroundColor(Color.WHITE);


        final ArrayList<Team> team = getData();

        //CREATE AND BIND TO ADAPTER
        CustomAdapter adapter = new CustomAdapter(getActivity(), team);
        elv.setAdapter(adapter);
        elv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                setListViewHeight(parent, groupPosition);
                return false;
            }
        });

        //SET ONCLICK LISTENER
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPos,
                                        int childPos, long id) {

                Toast.makeText(getActivity().getApplicationContext(), team.get(groupPos).players.get(childPos), Toast.LENGTH_SHORT).show();

                return false;
            }
        });
        return view;
    }

    private void setListViewHeight(ExpandableListView listView, int groupPosition) {
        ExpandableListAdapter listAdapter = (ExpandableListAdapter) listView.getExpandableListAdapter();
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

    private ArrayList<Team> getData() {

        Team t1 = new Team("Admission");
        t1.players.add("Medical");
        t1.players.add("Engineering");
        t1.players.add("Top School");

        Team t2 = new Team("Test Prep");
        t2.players.add("BCS");
        t2.players.add("HSC");
        t2.players.add("SSC");
        t2.players.add("JSC");
        t2.players.add("PSC");

        Team t3 = new Team("English");
        t3.players.add("Class 12");
        t3.players.add("Class 11");
        t3.players.add("Class 10");
        t3.players.add("Class 9");
        t3.players.add("Class 8");
        t3.players.add("Class 7");
        t3.players.add("Class 6");
        t3.players.add("Class 5");

        Team t4 = new Team("Math");
        t4.players.add("Class 12");
        t4.players.add("Class 11");
        t4.players.add("Class 10");
        t4.players.add("Class 9");
        t4.players.add("Class 8");
        t4.players.add("Class 7");
        t4.players.add("Class 6");
        t4.players.add("Class 5");

        Team t5 = new Team("Science");
        t5.players.add("Class 12");
        t5.players.add("Class 11");
        t5.players.add("Class 10");
        t5.players.add("Class 9");
        t5.players.add("Class 8");
        t5.players.add("Class 7");
        t5.players.add("Class 6");
        t5.players.add("Class 5");

        Team t6 = new Team("Information Technology");
        t6.players.add("Class 12");
        t6.players.add("Class 11");
        t6.players.add("Class 10");
        t6.players.add("Class 9");
        t6.players.add("Class 8");
        t6.players.add("Class 7");
        t6.players.add("Class 6");
        t6.players.add("Class 5");

        ArrayList<Team> allTeams = new ArrayList<Team>();
        allTeams.add(t1);
        allTeams.add(t2);
        allTeams.add(t3);
        allTeams.add(t4);
        allTeams.add(t5);
        allTeams.add(t6);
        // allTeams.add(t3);

        return allTeams;

    }

    public boolean onChildClick(ExpandableListView parent, View v,
                                int groupPosition, int childPosition, long id) {

        v.setBackgroundColor(Color.BLUE);

        return false;
    }

}