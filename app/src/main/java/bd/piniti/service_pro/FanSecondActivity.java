package bd.piniti.service_pro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import at.grabner.circleprogress.CircleProgressView;

public class FanSecondActivity extends AppCompatActivity {

    TextView title, number, number1,type,text3;
    CheckBox checkBox3;
    ImageView back_img, search;
    Button button;
    int layout;

    CircleProgressView circleProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fan_second);

        type = findViewById(R.id.type);
        title = findViewById(R.id.title);

        text3 = findViewById(R.id.text3);
        checkBox3 = findViewById(R.id.checkbox3);



        Intent i=getIntent();
        layout = i.getIntExtra("layout",0);
        if(layout==1){
            type.setText("Electrician");
            title.setText("Fan");


            circleProgressView = findViewById(R.id.circleView);
            circleProgressView.setVisibility(View.VISIBLE);
            circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            circleProgressView.setTextSize(20);
            circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            circleProgressView.setValue(Float.parseFloat("24"));
        }
        if(layout==2){
            type.setText("Electrician");
            title.setText("Light");
            text3.setVisibility(View.GONE);
            checkBox3.setVisibility(View.GONE);

            circleProgressView = findViewById(R.id.circleView);
            circleProgressView.setVisibility(View.VISIBLE);
            circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            circleProgressView.setTextSize(20);
            circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            circleProgressView.setValue(Float.parseFloat("24"));



        }

        search = findViewById(R.id.search);
        search.setVisibility(View.GONE);

        back_img = findViewById(R.id.back_img);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FanSecondActivity.this,FanThirdActivity.class);
                intent.putExtra("layout",layout);
                startActivity(intent);
            }
        });

    }
}
