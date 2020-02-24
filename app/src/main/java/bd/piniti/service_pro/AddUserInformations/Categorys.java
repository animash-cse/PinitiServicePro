package bd.piniti.service_pro.AddUserInformations;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.List;

import bd.piniti.service_pro.HomePageActivity;
import bd.piniti.service_pro.R;
import bd.piniti.service_pro.SearchingActivity;
import bd.piniti.service_pro.location.LocationActivity;
import bd.piniti.service_pro.notification.NotificationActivity;
import fragment.BookingFragment;
import fragment.CategoryFragment;
import fragment.FavoriteFragment;
import fragment.HomeFragment;
import fragment.ProfileFragment;

public class Categorys extends AppCompatActivity {
    FrameLayout frameLayout;

    LinearLayout linear, city_linear;
    TextView title, city;
    String service;
    private double latitude, logitude;
    private DatabaseReference databaseUser;
    Boolean chooseLocation;
    private ImageView search, notification, locationOn, locationOff;
    protected BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {

                case R.id.navigation_shop:

                    city_linear.setVisibility(View.VISIBLE);
                    title.setText("");
                    search.setVisibility(View.VISIBLE);
                    notification.setVisibility(View.INVISIBLE);
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;

                case R.id.navigation_gifts:

                    city_linear.setVisibility(View.GONE);
                    title.setText("My Favorite");
                    search.setVisibility(View.VISIBLE);
                    notification.setVisibility(View.INVISIBLE);

                    fragment = new FavoriteFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_cart:

                    city_linear.setVisibility(View.GONE);
                    title.setText("My Booking");
                    search.setVisibility(View.VISIBLE);
                    notification.setVisibility(View.INVISIBLE);

                    fragment = new BookingFragment();
                    loadFragment(fragment);


                    return true;
                case R.id.navigation_profile:

                    city_linear.setVisibility(View.GONE);
                    title.setText("Account");
                    search.setVisibility(View.INVISIBLE);
                    notification.setVisibility(View.VISIBLE);

                    fragment = new ProfileFragment();
                    loadFragment(fragment);


                    return true;
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorys);

        city_linear = findViewById(R.id.city_linear);
        title = findViewById(R.id.title);
        city = findViewById(R.id.city_name);

        // Button Actions for go location page and search
        linear = findViewById(R.id.linear);
        search = findViewById(R.id.search);
        notification = findViewById(R.id.notification);
        locationOn = findViewById(R.id.location_enable);
        locationOff = findViewById(R.id.location_disable);

        // Here get user id in current Firebase User
        //  Declare firebase user for get user id
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        // Set database location
        databaseUser = FirebaseDatabase.getInstance().getReference().child("Users").child(currentFirebaseUser.getUid()).child("Locations");

        databaseUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                service = dataSnapshot.child("service_loc_text").getValue(String.class);
                chooseLocation=(Boolean) dataSnapshot.child("locationChoose").getValue();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        loadFragment(new CategoryFragment());


        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        HomePageActivity.BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        for (int i = 0; i < menuView.getChildCount(); i++) {
            final View iconView = menuView.getChildAt(i).findViewById(android.support.design.R.id.icon);
            final ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
            final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 18, displayMetrics);
            layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 18, displayMetrics);
            iconView.setLayoutParams(layoutParams);


        }

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        if (locationManager != null) {
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                // onLocationChange(location);
                latitude = location.getLatitude();
                logitude = location.getLongitude();

                try {
                    Geocoder geocoder = new Geocoder(this);
                    List<Address> addresses;
                    addresses = geocoder.getFromLocation(latitude, logitude, 1);
                    String countryName = addresses.get(0).getCountryName();
                    String addressLine = addresses.get(0).getAddressLine(1);
                    String adminArea = addresses.get(0).getAdminArea();
                    String subAdminArea = addresses.get(0).getSubAdminArea();
                    String locality = addresses.get(0).getLocality();
                    String subLocality = addresses.get(0).getSubLocality();
                    String fetureName = addresses.get(0).getFeatureName();
                    String address = locality + ", " + subAdminArea + ", " + adminArea;
                    databaseUser.child("last_location").setValue(address);

                    locationOn.setVisibility(View.VISIBLE);
                    city.setText(address);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                /*if(!chooseLocation.equals(true)){

                }else{
                    city.setText(service);
                }*/
            } else {

                locationOff.setVisibility(View.VISIBLE);
                //city.setText(R.string.turn_on_location);
            }
        }

        buttonAction();
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.commit();
    }

    private void buttonAction() {

        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categorys.this, LocationActivity.class);
                startActivity(intent);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categorys.this, SearchingActivity.class);
                startActivity(intent);
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categorys.this, NotificationActivity.class);
                startActivity(intent);
            }
        });
    }
}
