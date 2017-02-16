package app.rocketship.pedia.pedia;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class CorpVideoActivity extends AppCompatActivity {

    VideoView videoCorp;
    String current;
    String path;
    Boolean isPaused;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_corp_video);

        path = "android.resource://"+ getPackageName() + "/" + R.raw.corp_video;
        videoCorp = (VideoView) findViewById(R.id.videoCorp);

        if (path == null || path.length() == 0) {
            Toast.makeText(CorpVideoActivity.this, "File URL/path is empty",
                    Toast.LENGTH_LONG).show();

        } else {

            MediaController mediaController = new
                    MediaController(this);
            mediaController.setAnchorView(videoCorp);
            videoCorp.setMediaController(mediaController);

            if (path.equals(current) && videoCorp != null) {
                videoCorp.start();
                videoCorp.requestFocus();
                return;
            }

            current = path;
            videoCorp.setVideoPath(path);
            videoCorp.start();
            videoCorp.requestFocus();
        }

        videoCorp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(!isPaused) {
                    videoCorp.pause();
                    isPaused = true;
                } else {
                    videoCorp.resume();
                    isPaused = false;
                }
            }

        });

        videoCorp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {

                Intent i = new Intent(CorpVideoActivity.this, MenuActivity.class);
                startActivity(i);
                finish();
                overridePendingTransition( 0, R.anim.fade_in );
            }

        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(CorpVideoActivity.this, MenuActivity.class);
        startActivity(i);
        finish();
        overridePendingTransition( 0, R.anim.fade_in );
    }
}
