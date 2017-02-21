package app.rocketship.pedia.utils;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import app.rocketship.pedia.MenuActivity;
import app.rocketship.pedia.R;

public class SliderActivity extends AppCompatActivity {

    private PagerAdapter pagerAdapter;
    private ViewPager sliderViewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        sliderViewPager = (ViewPager) findViewById(R.id.sliderViewPager);
        tabLayout = (TabLayout) findViewById(R.id.sliderdotlayout);


        pagerAdapter = new SliderFragmentPagerAdapter(getSupportFragmentManager(), MenuActivity.selectedPage);
        sliderViewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(sliderViewPager, true);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(SliderActivity.this, MenuActivity.class);
        startActivity(i);
        finish();
        overridePendingTransition( 0, R.anim.fade_in );
    }

}
