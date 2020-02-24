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

public class BlocksLeakageOneActivity extends AppCompatActivity implements View.OnClickListener{

    TextView title, type;
    ImageView back_img, search;
    Button button;
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5;
    CircleProgressView circleProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocks_leakage_one);

        circleProgressView = findViewById(R.id.circleView);
        circleProgressView.setVisibility(View.VISIBLE);
        circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        circleProgressView.setTextSize(20);
        circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        circleProgressView.setValue(Float.parseFloat("12"));

        type = findViewById(R.id.type);
        type.setText("Plumber");

        title = findViewById(R.id.title);
        title.setText("Blocks & Leakages");

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
                Intent intent = new Intent(BlocksLeakageOneActivity.this,BlocksLeakageSecondActivity.class);
                startActivity(intent);
            }
        });


        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        checkBox4 = findViewById(R.id.checkbox4);
        checkBox5 = findViewById(R.id.checkbox5);



        checkBox1.setOnClickListener(this);
        checkBox2.setOnClickListener(this);
        checkBox3.setOnClickListener(this);
        checkBox4.setOnClickListener(this);
        checkBox5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){

            case R.id.checkbox1:

                checkBox1.setChecked(true);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
                checkBox4.setChecked(false);
                checkBox5.setChecked(false);

                break;

            case R.id.checkbox2:

                checkBox1.setChecked(false);
                checkBox2.setChecked(true);
                checkBox3.setChecked(false);
                checkBox4.setChecked(false);
                checkBox5.setChecked(false);

                break;


            case R.id.checkbox3:

                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
                checkBox3.setChecked(true);
                checkBox4.setChecked(false);
                checkBox5.setChecked(false);

                break;

            case R.id.checkbox4:

                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
                checkBox4.setChecked(true);
                checkBox5.setChecked(false);

                break;


            case R.id.checkbox5:

                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
                checkBox4.setChecked(false);
                checkBox5.setChecked(true);

                break;


        }

    }
}
