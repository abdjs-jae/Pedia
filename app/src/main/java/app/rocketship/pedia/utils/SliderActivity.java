package app.rocketship.pedia.utils;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import app.rocketship.natrapharmutil.ActivityHandler;
import app.rocketship.natrapharmutil.DataHandler;
import app.rocketship.natrapharmutil.sqlite.SQLiteSingleton;
import app.rocketship.pedia.BrezuVideoActivity;
import app.rocketship.pedia.CorpVideoActivity;
import app.rocketship.pedia.MenuActivity;
import app.rocketship.pedia.R;

public class SliderActivity extends AppCompatActivity {

    private PagerAdapter pagerAdapter;
    private ViewPager sliderViewPager;
    private Spinner spinnerMenu;
    private TabLayout tabLayout;

    int currentItem = 0;

    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        sliderViewPager = (ViewPager) findViewById(R.id.sliderViewPager);
        tabLayout = (TabLayout) findViewById(R.id.sliderdotlayout);
        spinnerMenu = (Spinner) findViewById(R.id.menu_spinner);

        DataHandler.setNetworkConnection();
        initializeSpinner();

        pagerAdapter = new SliderFragmentPagerAdapter(getSupportFragmentManager(), MenuActivity.selectedPage);
        sliderViewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(sliderViewPager, true);
    }

    private void initializeSpinner(){

        // Create arraylist for the spinner
        list = new ArrayList<String>();

        list.add("Choose a page");

        PageSlidesHandler.Page[] listPage = PageSlidesHandler.Page.values();
        for(int i=0; i < listPage.length; i++){
            list.add(getString(listPage[i].getLabelId()));
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMenu.setAdapter(dataAdapter);
        //spinnerMenu.setSelection(list.indexOf(getString(MenuActivity.selectedPage.getLabelId())));

        spinnerMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(currentItem == position || parent.getItemAtPosition(position).toString().equals("Choose a page")){
                    return;
                }
                else {

                    // Set current item on view and spinner
                    currentItem = position;

                    switch(parent.getItemAtPosition(position).toString()) {
                        case "Brezu":
                            switchSliders(PageSlidesHandler.Page.BREZU);
                            break;
                        case "Brezu (Video)": {
                            DataHandler.savePageClick(PageSlidesHandler.Page.BREZU_VIDEO.getKey());

                            Intent i = new Intent(getBaseContext(), BrezuVideoActivity.class);
                            startActivity(i);
                            finish();
                            overridePendingTransition(0, R.anim.fade_in);
                            break;
                        }
                        case "Clarithromycin":
                            switchSliders(PageSlidesHandler.Page.CLARITHROMYCIN);
                            break;
                        case "Dibencozide Heraclene":
                            switchSliders(PageSlidesHandler.Page.DIBENCOZIDE_HERACLENE);
                            break;
                        case "Dibencozide Heraclene 1mg":
                            switchSliders(PageSlidesHandler.Page.DIBENCOZIDE_HERACLENE_1MG);
                            break;
                        case "Kidz Kit":
                            switchSliders(PageSlidesHandler.Page.KIDZ_KIT);
                            break;
                        case "Montemax":
                            switchSliders(PageSlidesHandler.Page.MONTEMAX);
                            break;
                        case "Natravox":
                            switchSliders(PageSlidesHandler.Page.NATRAVOX);
                            break;
                        case "Corporate Video": {
                            DataHandler.savePageClick(PageSlidesHandler.Page.CORPORATE_VIDEO.getKey());

                            Intent i = new Intent(getBaseContext(), CorpVideoActivity.class);
                            startActivity(i);
                            finish();
                            overridePendingTransition(0, R.anim.fade_in);
                            break;
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void switchSliders(PageSlidesHandler.Page page){

        DataHandler.setCurrentContext(this);
        DataHandler.savePageClick(page.getKey());

        MenuActivity.selectedPage = page;

        Intent i = new Intent(this, SliderActivity.class);

        startActivity(i);
        finish();
        overridePendingTransition(0, R.anim.fade_in);

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(SliderActivity.this, MenuActivity.class);
        startActivity(i);
        finish();
        overridePendingTransition( 0, R.anim.fade_in );
    }

    @Override
    protected void onDestroy(){

        SQLiteSingleton.getInstance(this).close();

        super.onDestroy();
    }

}
