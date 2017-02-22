package app.rocketship.natrapharmutil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;

public class LandingActivity extends AppCompatActivity {

    public static Class<?> menuClass;

    Button buttonMenu;
    ImageButton buttonProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        menuClass = ActivityHandler.getMenuClass();

        // this is from activity_profile.xml
        buttonMenu = (Button) findViewById(R.id.button_back);

    }

    private static void goToMenu(Context contextFrom){
        Intent i = new Intent(contextFrom, menuClass);
        contextFrom.startActivity(i);

        ((Activity) contextFrom).finish();
        ((Activity) contextFrom).overridePendingTransition(0, R.anim.screen_splash_fade_out);
    }

}
