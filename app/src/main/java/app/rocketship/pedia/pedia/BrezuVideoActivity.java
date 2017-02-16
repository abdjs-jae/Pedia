package app.rocketship.pedia.pedia;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class BrezuVideoActivity extends AppCompatActivity {

    VideoView videoBrezu;
    String current;
    String path;
    boolean isPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_brezu_video);

        path = "android.resource://"+ getPackageName() + "/" + R.raw.brezu_video;
        videoBrezu = (VideoView) findViewById(R.id.videoBrezu);

        if (path == null || path.length() == 0) {
            Toast.makeText(BrezuVideoActivity.this, "File URL/path is empty",
                    Toast.LENGTH_LONG).show();

        } else {

            MediaController mediaController = new
                    MediaController(this);
            mediaController.setAnchorView(videoBrezu);
            videoBrezu.setMediaController(mediaController);

            if (path.equals(current) && videoBrezu != null) {
                videoBrezu.start();
                videoBrezu.requestFocus();
                return;
            }

            current = path;
            videoBrezu.setVideoPath(path);
            videoBrezu.start();
            videoBrezu.requestFocus();
        }

        videoBrezu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(!isPaused) {
                    videoBrezu.pause();
                    isPaused = true;
                } else {
                    videoBrezu.resume();
                    isPaused = false;
                }
            }

        });

        videoBrezu.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {

                Intent i = new Intent(BrezuVideoActivity.this, MenuActivity.class);
                startActivity(i);
                finish();
                overridePendingTransition( 0, R.anim.fade_in );
            }

        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(BrezuVideoActivity.this, MenuActivity.class);
        startActivity(i);
        finish();
        overridePendingTransition( 0, R.anim.fade_in );
    }
}
