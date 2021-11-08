package org.bedu.okayapp.Trivia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import org.bedu.okayapp.R;
import org.bedu.okayapp.Temas.ShowTemas;

public class Estudio extends AppCompatActivity {
    private YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudio);
        getSupportActionBar().hide();

        youTubePlayerView = findViewById(R.id.youtubePlayer);
        getLifecycle().addObserver(youTubePlayerView);

        Button botoncito = (Button) findViewById(R.id.boton_regreso);
        botoncito.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Estudio.this,ShowTemas.class));
            }
        });
    }
}
