package bd.piniti.service_pro.location;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import bd.piniti.service_pro.R;
import bd.piniti.service_pro.SearchingActivity;
import bd.piniti.service_pro.location.utils.Utility;

public class LocationActivity extends AppCompatActivity {


    private CardView cardview;
    private LinearLayout location, home, work, chooseOnMap;
    private ImageView back, cancle;
    private EditText searchText;
    private DatabaseReference databaseUser;
    private TextView addHomeText, homeText, setHome, workText, addWorkText,setWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        back = findViewById(R.id.back_img);
        searchText = findViewById(R.id.search_text);
        location = findViewById(R.id.detect_my_location);
        home = findViewById(R.id.home_location);
        work = findViewById(R.id.work_location);
        chooseOnMap = findViewById(R.id.choose_on_map);
        cardview = findViewById(R.id.cardview);

        addHomeText = findViewById(R.id.add_home_text);
        homeText = findViewById(R.id.home_text);
        setHome = findViewById(R.id.set_home_add);

        addWorkText = findViewById(R.id.add_work_text);
        workText = findViewById(R.id.work_text);
        setWork = findViewById(R.id.set_work_add);

        // Here get user id in currentFirebaseUser
        //  Declare firebase user for get user id
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        // Set database location
        databaseUser = FirebaseDatabase.getInstance().getReference().child("Users").child(currentFirebaseUser.getUid()).child("Locations");
        databaseUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String workString = dataSnapshot.child("work_loc_text").getValue(String.class);
                String homeString = dataSnapshot.child("home_loc_text").getValue(String.class);
                if(workString != null){
                    String workSet = "\n"+workString;
                    setWork.setText(workSet);
                    addWorkText.setVisibility(View.INVISIBLE);
                    workText.setVisibility(View.VISIBLE);
                    setWork.setVisibility(View.VISIBLE);
                }
                if(homeString != null){
                    String homeSet = "\n"+homeString;
                    setHome.setText(homeSet);
                    addHomeText.setVisibility(View.INVISIBLE);
                    homeText.setVisibility(View.VISIBLE);
                    setHome.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LocationActivity.this, SearchingActivity.class);
                startActivity(intent);
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseUser.child("locationChoose").setValue(false);
                Toast.makeText(LocationActivity.this, "Set Your Current Location as Service", Toast.LENGTH_LONG).show();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showMapsDialog("home_location", "home_loc_text", "Home Location Added");
                Intent intent = new Intent(LocationActivity.this, GetLocation.class);
                intent.putExtra("message", "Home Location Added");
                intent.putExtra("locationText", "home_loc_text");
                intent.putExtra("locationLatlang", "home_location");
                startActivity(intent);
            }
        });
        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showMapsDialog("work_location", "work_loc_text", "Work Location Added");
                Intent intent = new Intent(LocationActivity.this, GetLocation.class);
                intent.putExtra("message", "Work Location Added");
                intent.putExtra("locationText", "work_loc_text");
                intent.putExtra("locationLatlang", "work_location");
                startActivity(intent);
            }
        });
        chooseOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocationActivity.this, GetLocation.class);
                intent.putExtra("message", "Service Location Added");
                intent.putExtra("locationText", "service_loc_text");
                intent.putExtra("locationLatlang", "service_in");
                intent.putExtra("locationChoose", "true");
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        cancle = findViewById(R.id.cancle);
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchText.setText("");
            }
        });
    }

    private void showMapsDialog(String databaseDirectory, String locationText, String message) {
        Dialog dialog = new Dialog(LocationActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND); //make map clear
        dialog.setContentView(R.layout.dialog_maps);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //lp.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(lp);

        dialog.setCancelable(true); //dismiss by clicking outside
        dialog.show();

        EditText address = dialog.findViewById(R.id.search_text);

        (dialog.findViewById(R.id.cancle)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address.setText("");
            }
        });
        (dialog.findViewById(R.id.back_image)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        MapView mMapView = dialog.findViewById(R.id.mapView);
        //TextView address = dialog.findViewById(R.id.address);
        MapsInitializer.initialize(LocationActivity.this);
        mMapView.onCreate(dialog.onSaveInstanceState());
        mMapView.onResume();


        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(final GoogleMap googleMap) {
                if (ActivityCompat.checkSelfPermission(LocationActivity.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    googleMap.setMyLocationEnabled(true);
                } else {
                    googleMap.setMyLocationEnabled(true);
                }
                googleMap.getUiSettings().setZoomControlsEnabled(true);
                googleMap.getUiSettings().setAllGesturesEnabled(true);
                googleMap.getUiSettings().setZoomGesturesEnabled(true);

                LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                Criteria criteria = new Criteria();

                if (ActivityCompat.checkSelfPermission(LocationActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(LocationActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));


                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 13));


                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(new LatLng(location.getLatitude(), location.getLongitude()))      // Sets the center of the map to location user
                        .zoom(14)                   // Sets the zoom
                        .bearing(90)                // Sets the orientation of the camera to east
                        //.tilt(40)                   // Sets the tilt of the camera to 30 degrees
                        .build();                   // Creates a CameraPosition from the builder
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                googleMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
                    @Override
                    public void onCameraIdle() {
                        LatLng latLng = googleMap.getCameraPosition().target;
                        String addr = Utility.getAddress(LocationActivity.this, latLng);
                        address.setText(addr);

                        final double lat = latLng.latitude;
                        final double log = latLng.longitude;
                        String setLocation = lat+","+log;
                        databaseUser.child(databaseDirectory).setValue(setLocation);
                        databaseUser.child(locationText).setValue(addr);
                    }
                });

                (dialog.findViewById(R.id.pick_point_ok)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(LocationActivity.this, message, Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });
            }
        });
    }


}
