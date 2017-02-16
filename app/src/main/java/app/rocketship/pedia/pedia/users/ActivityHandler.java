package app.rocketship.pedia.pedia.users;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.util.Log;

import app.rocketship.pedia.pedia.R;
import app.rocketship.pedia.pedia.SplashActivity;

/**
 * Created by Candice on 14/02/2017.
 */

public class ActivityHandler {

    private static void changeActivity(Context changeFrom, Class<?> changeTo){
        Intent i = new Intent(changeFrom, changeTo);
        changeFrom.startActivity(i);

        ((Activity) changeFrom).finish();
        ((Activity) changeFrom).overridePendingTransition(0, R.anim.screen_splash_fade_out);

    }

    public static void goHome(Context context){
//        Intent i = new Intent(Intent.ACTION_MAIN);
//        i.addCategory(Intent.CATEGORY_HOME);
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        ((Activity) context).finish();

    }

    public static void refreshActivity(Context context){
        ((Activity) context).finish();
        context.startActivity(((Activity) context).getIntent());
    }

    public static void afterSplashActivity(final Context splashActivity, final Class<?> registerClass, final Class<?> menuClass){
        DataHandler.setCurrentContext(splashActivity);

        if(DataHandler.hasUserData())
            changeActivity(splashActivity, menuClass);
        else
            DataHandler.isDeviceRegistered(
                    new DataHandler.VolleyCallback() {
                        @Override
                        public void doAction(String result) {
                            Log.d("Test", "device exists: " + result);
                            DataHandler.setUserData(result);
                            changeActivity(splashActivity, menuClass);
                        }
                    },
                    new DataHandler.VolleyCallback() {
                        @Override
                        public void doAction(String result) {
                            changeActivity(splashActivity, registerClass);
                        }
                    }
            );
//            changeActivity(splashActivity, registerClass);


    }
}
