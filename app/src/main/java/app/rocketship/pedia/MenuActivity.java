package app.rocketship.pedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import app.rocketship.natrapharmutil.DataHandler;
import app.rocketship.natrapharmutil.sqlite.SQLiteSingleton;
import app.rocketship.pedia.utils.PageSlidesHandler;
import app.rocketship.pedia.utils.SliderActivity;

public class MenuActivity extends AppCompatActivity {

    TextView tvBrezu;
    TextView tvBrezuVideo;
    TextView tvClarithromycin;
    TextView tvDibher;
    TextView tvDibher1mg;
    TextView tvKidzkit;
    TextView tvMontemax;
    TextView tvNatravox;
    TextView tvCorpVideo;

    public static PageSlidesHandler.Page selectedPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu);


        DataHandler.setNetworkConnection();

        // TO-DO: Add activities first or focus on the sliders

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

    }


    private void goToSliderActivity(PageSlidesHandler.Page page){

        DataHandler.setCurrentContext(this);
        DataHandler.savePageClick(page.getKey());

//        DataHandler.printClicks();

        selectedPage = page;

        Intent i = new Intent(this, SliderActivity.class);

        startActivity(i);
        finish();
        overridePendingTransition(0, R.anim.fade_in);
    }

    @Override
    protected void onDestroy(){


        SQLiteSingleton.getInstance(this).close();

        super.onDestroy();
    }
}
