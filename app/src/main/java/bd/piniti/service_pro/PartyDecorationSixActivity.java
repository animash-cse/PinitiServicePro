package bd.piniti.service_pro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import at.grabner.circleprogress.CircleProgressView;

public class PartyDecorationSixActivity extends AppCompatActivity {

    TextView title, type;
    ImageView back_img, search;
    Button button;
    LinearLayout linear;

    CircleProgressView circleProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_decoration_six);

        circleProgressView = findViewById(R.id.circleView);
        circleProgressView.setVisibility(View.VISIBLE);
        circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        circleProgressView.setTextSize(20);
        circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        circleProgressView.setValue(Float.parseFloat("85"));

        type = findViewById(R.id.type);
        type.setText("Wedding & Events");

        title = findViewById(R.id.title);
        title.setText("Party Decoration");

        search = findViewById(R.id.search);
        search.setVisibility(View.GONE);

        back_img = findViewById(R.id.back_img);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        linear = findViewById(R.id.linear);
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartyDecorationSixActivity.this,PartyDecorationSevenActivity.class);
                startActivity(intent);
            }
        });
    }
}