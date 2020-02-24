package bd.piniti.service_pro;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import Adapter.MehndiPagerAdapter;
import at.grabner.circleprogress.CircleProgressView;
import me.relex.circleindicator.CircleIndicator;

public class MehndiArtistFourth_OneActivity extends AppCompatActivity {

    TextView title,number,number1;
    ImageView back_img,search;


    private ViewPager viewPager;

    private MehndiPagerAdapter subCategoryPagerAdapter;

    LinearLayout linear_add,linear_count,bottom_linear,linear;
    ImageView add,minus;


    int count=1,adult=1;
    int layout;
    CircleProgressView circleProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mehndi_artist_fourth__one);

        title = findViewById(R.id.title);
//        title.setText("Mehendi Artist for Bride");

        Intent j=getIntent();
        layout = j.getIntExtra("layout",0);
        if(layout==11){
            title.setText("Mehendi Artist for Bride");

            circleProgressView = findViewById(R.id.circleView);
            circleProgressView.setVisibility(View.VISIBLE);
            circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            circleProgressView.setTextSize(20);
            circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            circleProgressView.setValue(Float.parseFloat("62"));
        }
        if(layout==22){
            title.setText("Mehendi Artist for Bride & Guests");
        }if(layout==33){
            title.setText("Mehendi Artist for Bride & Guests");
            circleProgressView = findViewById(R.id.circleView);
            circleProgressView.setVisibility(View.VISIBLE);
            circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            circleProgressView.setTextSize(20);
            circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            circleProgressView.setValue(Float.parseFloat("70"));

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


        linear = findViewById(R.id.linear);
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(layout==11){
                    Intent intent = new Intent(MehndiArtistFourth_OneActivity.this,MakupAndHairSixActivity.class);
                    intent.putExtra("layout",layout);
                    startActivity(intent);
                }
                if(layout==33){
                    Intent intent = new Intent(MehndiArtistFourth_OneActivity.this,MehendiArtistBrideGuestsSevenActivity.class);
                    intent.putExtra("layout",layout);
                    startActivity(intent);
                }

            }
        });






        linear_add = findViewById(R.id.linear_add);
        linear_count = findViewById(R.id.linear_count);
        add = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        number = findViewById(R.id.number);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                number.setText(String.valueOf(count));
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count!=1){
                    count--;
                    number.setText(String.valueOf(count));
                }
            }

        });

//
//        linear_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                linear_count.setVisibility(View.VISIBLE);
//                linear_add.setVisibility(View.GONE);
//                number.setText(String.valueOf(count));
//            }
//        });





        viewPager = (ViewPager) findViewById(R.id.viewpager);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);


         /*view pager and indicator code is here*/


        subCategoryPagerAdapter = new MehndiPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(subCategoryPagerAdapter);
        indicator.setViewPager(viewPager);
        subCategoryPagerAdapter.registerDataSetObserver(indicator.getDataSetObserver());


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
