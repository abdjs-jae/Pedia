package app.rocketship.natrapharmutil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LandingActivity extends AppCompatActivity {

    public static Class<?> menuClass;

    ImageView ivMenu;
    ImageView ivProfile;
    TextView tvMenu;
    TextView tvProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        menuClass = ActivityHandler.getMenuClass();

        // this is from activity_profile.xml
        ivMenu = (ImageView) findViewById(R.id.iv_menu);
        ivProfile = (ImageView) findViewById(R.id.iv_profile);

        tvMenu = (TextView) findViewById(R.id.tv_menu);
        tvMenu.setPaintFlags(tvMenu.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        tvProfile = (TextView) findViewById(R.id.tv_profile);
        tvProfile.setPaintFlags(tvProfile.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        ivMenu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                goToMenu(LandingActivity.this);
            }

        });

        ivProfile.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                goToProfile(LandingActivity.this);
            }

        });
    }

    private static void goToMenu(Context contextFrom){
        Intent i = new Intent(contextFrom, menuClass);
        contextFrom.startActivity(i);

        ((Activity) contextFrom).finish();
        ((Activity) contextFrom).overridePendingTransition(0, R.anim.screen_splash_fade_out);
    }

    private static void goToProfile(Context contextFrom){
        Intent i = new Intent(contextFrom, ProfileActivity.class);
        contextFrom.startActivity(i);

        ((Activity) contextFrom).finish();
        ((Activity) contextFrom).overridePendingTransition(0, R.anim.screen_splash_fade_out);
    }
}
