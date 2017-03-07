package app.rocketship.pedia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.rocketship.natrapharmutil.ActivityHandler;
import app.rocketship.natrapharmutil.DataHandler;
import app.rocketship.natrapharmutil.ProfileActivity;
import app.rocketship.natrapharmutil.sqlite.SQLiteSingleton;
import app.rocketship.pedia.utils.PageSlidesHandler;
import app.rocketship.pedia.utils.SliderActivity;

public class MenuActivity extends AppCompatActivity {

    /*
    TextView tvBrezu;
    TextView tvBrezuVideo;
    TextView tvClarithromycin;
    TextView tvDibher;
    TextView tvDibher1mg;
    TextView tvKidzkit;
    TextView tvMontemax;
    TextView tvNatravox;
    TextView tvCorpVideo;
    */

    ImageView ivBack;

    ListView mainListView;

    public static PageSlidesHandler.Page selectedPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu);

        DataHandler.setNetworkConnection();

        /*
        // Load the textviews
        tvBrezuVideo = (TextView) findViewById(R.id.tv_brezu_video);
        tvCorpVideo = (TextView) findViewById(R.id.tv_corp_video);
        tvClarithromycin = (TextView) findViewById(R.id.tv_clarithromycin);
        tvBrezu = (TextView) findViewById(R.id.tv_brezu);
        tvDibher = (TextView) findViewById(R.id.tv_dibher);
        tvDibher1mg = (TextView) findViewById(R.id.tv_dibher1mg);
        tvKidzkit = (TextView) findViewById(R.id.tv_kidzkit);
        tvMontemax = (TextView) findViewById(R.id.tv_montemax);
        tvNatravox = (TextView) findViewById(R.id.tv_natravox);
        */

        ivBack = (ImageView) findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ActivityHandler.goToLanding(MenuActivity.this);

            }

        });

        mainListView = (ListView) findViewById(R.id.mainListView);

        final List<String> list = new ArrayList<String>();

        list.add(getString(R.string.brezu));
        list.add(getString(R.string.brezu_video));
        list.add(getString(R.string.clarithromycin));
        list.add(getString(R.string.dibher));
        list.add(getString(R.string.dibher1mg));
        list.add(getString(R.string.kidzkit));
        list.add(getString(R.string.montemax));
        list.add(getString(R.string.natravox));
        list.add(getString(R.string.corpvideo));

        final StableArrayAdapter viewAdapter = new StableArrayAdapter(this,
                R.layout.list_item_view, list);

        mainListView.setAdapter(viewAdapter);

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {

                Intent i;

                switch(position){
                    case 0: goToSliderActivity(PageSlidesHandler.Page.BREZU); break;
                    case 1:
                        DataHandler.savePageClick(PageSlidesHandler.Page.BREZU_VIDEO.getKey());

                        i = new Intent(MenuActivity.this, BrezuVideoActivity.class);
                        startActivity(i);
                        finish();
                        overridePendingTransition( 0, R.anim.fade_in );
                        break;
                    case 2: goToSliderActivity(PageSlidesHandler.Page.CLARITHROMYCIN); break;
                    case 3: goToSliderActivity(PageSlidesHandler.Page.DIBENCOZIDE_HERACLENE); break;
                    case 4: goToSliderActivity(PageSlidesHandler.Page.DIBENCOZIDE_HERACLENE_1MG); break;
                    case 5: goToSliderActivity(PageSlidesHandler.Page.KIDZ_KIT); break;
                    case 6: goToSliderActivity(PageSlidesHandler.Page.MONTEMAX); break;
                    case 7: goToSliderActivity(PageSlidesHandler.Page.NATRAVOX); break;
                    case 8:
                        DataHandler.savePageClick(PageSlidesHandler.Page.CORPORATE_VIDEO.getKey());

                        i = new Intent(MenuActivity.this, CorpVideoActivity.class);
                        startActivity(i);
                        finish();
                        overridePendingTransition( 0, R.anim.fade_in );
                        break;
                }
            }

        });

        /*
        // Load the listeners
        tvBrezuVideo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                DataHandler.savePageClick(PageSlidesHandler.Page.BREZU_VIDEO.getKey());

                Intent i = new Intent(MenuActivity.this, BrezuVideoActivity.class);
                startActivity(i);
                finish();
                overridePendingTransition( 0, R.anim.fade_in );
            }

        });

        tvCorpVideo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                DataHandler.savePageClick(PageSlidesHandler.Page.CORPORATE_VIDEO.getKey());


                Intent i = new Intent(MenuActivity.this, CorpVideoActivity.class);
                startActivity(i);
                finish();
                overridePendingTransition( 0, R.anim.fade_in );
            }

        });

        tvBrezu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSliderActivity(PageSlidesHandler.Page.BREZU);
            }
        });

        tvDibher.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                goToSliderActivity(PageSlidesHandler.Page.DIBENCOZIDE_HERACLENE);
            }
        });

        tvClarithromycin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                goToSliderActivity(PageSlidesHandler.Page.CLARITHROMYCIN);
            }
        });

        tvDibher1mg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                goToSliderActivity(PageSlidesHandler.Page.DIBENCOZIDE_HERACLENE_1MG);
            }
        });

        tvKidzkit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                goToSliderActivity(PageSlidesHandler.Page.KIDZ_KIT);
            }
        });

        tvMontemax.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                goToSliderActivity(PageSlidesHandler.Page.MONTEMAX);
            }
        });

        tvNatravox.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                goToSliderActivity(PageSlidesHandler.Page.NATRAVOX);
            }
        });
        */

    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }

    public void switchSlider(PageSlidesHandler.Page page){
        goToSliderActivity(page);
    }

    private void goToSliderActivity(PageSlidesHandler.Page page){

        DataHandler.setCurrentContext(this);
        DataHandler.savePageClick(page.getKey());

        // DataHandler.printClicks();

        selectedPage = page;

        Intent i = new Intent(this, SliderActivity.class);

        startActivity(i);
        finish();
        overridePendingTransition(0, R.anim.fade_in);
    }

    @Override
    public void onBackPressed() {
        ActivityHandler.goToLanding(MenuActivity.this);
    }

    @Override
    protected void onDestroy(){

        SQLiteSingleton.getInstance(this).close();

        super.onDestroy();
    }
}
