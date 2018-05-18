package org.ellalee.lab5_1;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1,imageView2;
    EditText editText;
    Button btn;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.img1);
        imageView2 = findViewById(R.id.img2);
        editText = findViewById(R.id.stateHistory);
        btn = findViewById(R.id.btnChange);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MinionThread thread1 = new MinionThread(0);
                thread1.start();
                MinionThread thread2 = new MinionThread(1);
                thread2.start();

            }
        });
    }

    class MinionThread extends Thread{
        private int stateIndex;
        private int minionIndex;

        ArrayList<Integer> images = new ArrayList<>();

        public MinionThread(int idx){
            minionIndex = idx;
            images.add(R.drawable.minion1);
            images.add(R.drawable.minion2);
            images.add(R.drawable.minion3);
        }

        public void run(){
            stateIndex =0;
            for(int i=0;i<9;i++){
                final String msg = "minion #" + minionIndex + " state: "+stateIndex; //state message
                handler.post(new Runnable() { //send runnable obj to handler
                    @Override
                    public void run() {
                        editText.append(msg+"\n");
                        if(minionIndex ==0 ){
                            imageView1.setImageResource(images.get(stateIndex)); //change image of view1
                        }else if(minionIndex==1){
                            imageView2.setImageResource(images.get(stateIndex)); //change image of view2
                        }
                    }
                });
                try{
                    int sleepTime = getRandomTime(500,3000);//ramdom sleep time for thread
                    Thread.sleep(sleepTime);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                stateIndex = (stateIndex+1)%images.size(); //rotate image
            }

        }
        public int getRandomTime(int min,int max){
            return min+(int)(Math.random()*(max-min));
        }
    }
}
