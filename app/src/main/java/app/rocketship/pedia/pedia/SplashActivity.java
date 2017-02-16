package app.rocketship.pedia.pedia;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;
import android.widget.VideoView;

import app.rocketship.pedia.pedia.users.ActivityHandler;
import app.rocketship.pedia.pedia.users.RegisterActivityAbstract;

public class SplashActivity extends AppCompatActivity {

    VideoView videoHome;
    String current;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);


        path = "android.resource://"+ getPackageName() + "/" + R.raw.pedia_bg;
        videoHome = (VideoView) findViewById(R.id.videoHome);

        if (path == null || path.length() == 0) {
            Toast.makeText(SplashActivity.this, "File URL/path is empty",
                    Toast.LENGTH_LONG).show();

        } else {

            if (path.equals(current) && videoHome != null) {
                videoHome.start();
                videoHome.requestFocus();
                return;
            }

            current = path;
            videoHome.setVideoPath(path);
            videoHome.start();
            videoHome.requestFocus();
        }


        final Activity a = this;

        videoHome.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {

                ActivityHandler.afterSplashActivity(a, RegisterActivity.class, MenuActivity.class);
            }

        });
    }
}
