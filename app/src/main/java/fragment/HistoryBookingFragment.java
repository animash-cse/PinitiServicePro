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

import Adapter.BookingHistoryRecycleAdapter;
import ModelClass.BookingModelClass;
import bd.piniti.service_pro.R;


public class HistoryBookingFragment extends Fragment {

    private View view;
    private ArrayList<BookingModelClass> bookingModelClasses;
    private RecyclerView recyclerView;
    private BookingHistoryRecycleAdapter bAdapter;


    private String[] accept = {"Service Completed", "Service Canceled"};
    private String[] title = {"Salon at home for Women", "Massage for Men"};
    private String[] action = {"by John Doe", "by You"};
    private String[] rate = {"Rate", "Reschedule"};
    private String[] feed = {"Feedback", "Dismiss"};
    private Integer[] image = {R.drawable.ic_green_circle, R.drawable.ic_circle_cancel};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_history_booking, container, false);

        /*category recyclerview code is here*/

        recyclerView = view.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        bookingModelClasses = new ArrayList<>();

        for (int i = 0; i < title.length; i++) {

            BookingModelClass mycreditList = new BookingModelClass(accept[i],title[i],action[i], rate[i], feed[i], image[i]);
            bookingModelClasses.add(mycreditList);
            bAdapter = new BookingHistoryRecycleAdapter(getActivity(), bookingModelClasses);
            recyclerView.setAdapter(bAdapter);

        }

        return view;
    }

}
