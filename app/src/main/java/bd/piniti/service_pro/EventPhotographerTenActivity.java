package bd.piniti.service_pro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import at.grabner.circleprogress.CircleProgressView;
import bd.piniti.service_pro.startActivitys.HomePageActivity;

public class EventPhotographerTenActivity extends AppCompatActivity {

    TextView title, type;
    ImageView back_img, search;
    Button button;

    CircleProgressView circleProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_photographer_ten);

        circleProgressView = findViewById(R.id.circleView);
        circleProgressView.setVisibility(View.VISIBLE);
        circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        circleProgressView.setTextSize(20);
        circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        circleProgressView.setValue(Float.parseFloat("100"));


        type = findViewById(R.id.type);
        type.setText("Wedding & Events");

        title = findViewById(R.id.title);
        title.setText("Event Photographer");

        search = findViewById(R.id.search);
        search.setVisibility(View.GONE);

        back_img = findViewById(R.id.back_img);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



//        Intent launchNextActivity;
//        launchNextActivity = new Intent(EventPhotographerTenActivity.this, EventPhotographerOneActivity.class);
//        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//        startActivity(launchNextActivity);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(EventPhotographerTenActivity.this, HomePageActivity.class);

        finish();
        startActivity(intent);

    }
}
