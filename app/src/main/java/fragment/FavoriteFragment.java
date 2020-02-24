package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import bd.piniti.service_pro.R;
import bd.piniti.service_pro.activitys.AddFavorites;


public class FavoriteFragment extends Fragment {

    private Button addFavorite;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        addFavorite = view.findViewById(R.id.add_favorite);

        addFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddFavorites.class);
                startActivity(intent);
            }
        });

        return view;
    }


}
