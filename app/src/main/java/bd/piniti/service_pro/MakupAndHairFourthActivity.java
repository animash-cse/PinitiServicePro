package bd.piniti.service_pro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import Adapter.BridalMakupFourSubRecycleAdapter;
import ModelClass.CategorySubModelClass;
import at.grabner.circleprogress.CircleProgressView;

public class MakupAndHairFourthActivity extends AppCompatActivity {

    TextView title,number,number1;
    ImageView back_img,search;
    LinearLayout linear;

    /*Bridal data is here*/

    private ArrayList<CategorySubModelClass> categorySubModelClasses;
    private RecyclerView recyclerView1;
    private BridalMakupFourSubRecycleAdapter Adapter;


    private String title2[] = {"Erica","Monika","Erica","Monika","Erica","Monika","Erica","Monika"};

    CircleProgressView circleProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makup_and_hair_fourth);


        circleProgressView = findViewById(R.id.circleView);
        circleProgressView.setVisibility(View.VISIBLE);
        circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        circleProgressView.setTextSize(20);
        circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        circleProgressView.setValue(Float.parseFloat("50"));



        linear = findViewById(R.id.linear);
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MakupAndHairFourthActivity.this,MakupAndHairFifthActivity.class);
                startActivity(intent);
            }
        });



        title = findViewById(R.id.title);
        title.setText("Bridal Makeup Artist");

        search = findViewById(R.id.search);
        search.setVisibility(View.GONE);

        back_img = findViewById(R.id.back_img);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


         /*vertical category recyclerview code is here*/

        recyclerView1 = findViewById(R.id.recyclerview_bridle);

        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(MakupAndHairFourthActivity.this);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        categorySubModelClasses = new ArrayList<>();

        for (int i = 0; i < title2.length; i++) {
            CategorySubModelClass mycreditList = new CategorySubModelClass(title2[i]);
            categorySubModelClasses.add(mycreditList);
        }
        Adapter = new BridalMakupFourSubRecycleAdapter(MakupAndHairFourthActivity.this,categorySubModelClasses);
        recyclerView1.setAdapter(Adapter);

    }
}
