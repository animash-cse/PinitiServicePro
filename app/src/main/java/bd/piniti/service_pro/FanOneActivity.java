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

public class FanOneActivity extends AppCompatActivity implements View.OnClickListener {

    TextView title, number, number1,type;
    ImageView back_img, search;
    Button button;

    CheckBox checkBox1,checkBox2,checkBox3;
    CircleProgressView circleProgressView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fan_one);


        circleProgressView = findViewById(R.id.circleView);
        circleProgressView.setVisibility(View.VISIBLE);
        circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        circleProgressView.setTextSize(20);
        circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        circleProgressView.setValue(Float.parseFloat("12"));


        type = findViewById(R.id.type);
        type.setText("Electrician");

        title = findViewById(R.id.title);
        title.setText("Fan");

        search = findViewById(R.id.search);
        search.setVisibility(View.GONE);

        back_img = findViewById(R.id.back_img);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);


        checkBox1.setOnClickListener(this);
        checkBox2.setOnClickListener(this);
        checkBox3.setOnClickListener(this);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FanOneActivity.this,FanSecondActivity.class);
                intent.putExtra("layout",1);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.checkbox1:

                checkBox1.setChecked(true);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);

                break;

            case R.id.checkbox2:

                checkBox1.setChecked(false);
                checkBox2.setChecked(true);
                checkBox3.setChecked(false);

                break;

            case R.id.checkbox3:

                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
                checkBox3.setChecked(true);

                break;
        }
    }
}
