package app.rocketship.natrapharmutil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LandingActivity extends AppCompatActivity {

    public static Class<?> menuClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        menuClass = ActivityHandler.getMenuClass();

        goToMenu(getBaseContext());
    }

    private static void goToMenu(Context contextFrom){
        Intent i = new Intent(contextFrom, menuClass);
        contextFrom.startActivity(i);

        ((Activity) contextFrom).finish();
        ((Activity) contextFrom).overridePendingTransition(0, R.anim.screen_splash_fade_out);
    }

}
