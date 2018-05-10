package org.ellalee.lab4_2;

import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private boolean pageOpen = false;
    Animation translateLeft;
    Animation translateRight;
    LinearLayout slideLayout;
    Button btnOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slideLayout = findViewById(R.id.slidingLayout);
        btnOpen = findViewById(R.id.btnOpen);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pageOpen){ //currently page is opened
                    slideLayout.startAnimation(translateRight);
                }
                else{
                    slideLayout.setVisibility(View.VISIBLE);
                    slideLayout.startAnimation(translateLeft);
                }
            }
        });

        translateLeft = AnimationUtils.loadAnimation(this,R.anim.left);
        translateRight = AnimationUtils.loadAnimation(this,R.anim.right);

        SlidingPageAnimationListener animationListener = new SlidingPageAnimationListener();
        translateLeft.setAnimationListener(animationListener);
        translateRight.setAnimationListener(animationListener);
    }

    private class SlidingPageAnimationListener implements Animation.AnimationListener{
        @Override
        public void onAnimationStart(Animation animation) {}

        @Override
        public void onAnimationRepeat(Animation animation) {}

        @Override
        public void onAnimationEnd(Animation animation) {
            if(pageOpen){ //currently open -> close
                slideLayout.setVisibility(View.INVISIBLE);
                btnOpen.setText("OPEN  PAGE");
                pageOpen=false;
            }
            else{ //currently close -> open
                btnOpen.setText("CLOSE PAGE");
                pageOpen=true;
            }
        }

    }
}
