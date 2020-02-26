package com.digitalhouse.digitalhousefoods.views.activity.splash;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import com.digitalhouse.digitalhousefoods.views.activity.LoginActivity;
import com.digitalhouse.digitalhousefoods.views.activity.MainActivity;
import com.digitalhouse.digitalhousefoods.R;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                jump();
            }
        }, 2000);
    }

    private void jump() {
        timer.cancel();
        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        finish();
    }
}
