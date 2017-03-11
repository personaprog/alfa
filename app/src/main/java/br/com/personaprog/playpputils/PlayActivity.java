package br.com.personaprog.playpputils;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
/**
 * Created by] persprog on 14/02/17.
 */

public class PlayActivity extends Activity {
    public static final String TAG = "GameEngine";
    private PlayPreferences mpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public void enebleKeepScreenOn(){
       // getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    public void enableFullScreen(){
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.requestFeature(Window.FEATURE_NO_TITLE);
        if(android.os.Build.VERSION.SDK_INT >= 19){
            window.getDecorView().setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    public PlayPreferences getPreferences(){
        return mpreferences;
    }

}
