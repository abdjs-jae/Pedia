package app.rocketship.pedia.utils;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import app.rocketship.pedia.MenuActivity;
import app.rocketship.pedia.R;

public class SliderActivity extends AppCompatActivity {

    private PagerAdapter pagerAdapter;
    private ViewPager sliderViewPager;
    private Spinner spinnerMenu;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        sliderViewPager = (ViewPager) findViewById(R.id.sliderViewPager);
        tabLayout = (TabLayout) findViewById(R.id.sliderdotlayout);
        spinnerMenu = (Spinner) findViewById(R.id.menu_spinner);

        initializeSpinner();

        pagerAdapter = new SliderFragmentPagerAdapter(getSupportFragmentManager(), MenuActivity.selectedPage);
        sliderViewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(sliderViewPager, true);
    }

    private void initializeSpinner(){

        // Create arraylist for the spinner
        List<String> list = new ArrayList<String>();
        list.add(getString(R.string.brezu));
        list.add(getString(R.string.brezu_video));
        list.add(getString(R.string.clarithromycin));
        list.add(getString(R.string.dibher));
        list.add(getString(R.string.dibher1mg));
        list.add(getString(R.string.kidzkit));
        list.add(getString(R.string.montemax));
        list.add(getString(R.string.natravox));
        list.add(getString(R.string.corpvideo));

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMenu.setAdapter(dataAdapter);

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(SliderActivity.this, MenuActivity.class);
        startActivity(i);
        finish();
        overridePendingTransition( 0, R.anim.fade_in );
    }

}
