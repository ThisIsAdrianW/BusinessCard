package com.example.android.businesscard;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Here we will have Image Array that we can use later to change photos.
    //Amazing stuff generated from edges2cat.
    int[] imageArray = { R.drawable.cat1, R.drawable.cat2, R.drawable.cat3,R.drawable.cat4 };
    // TextViews and ImageView from MainActivity that i will hide and show. Now just declaring variables.
    TextView textNrOne, textNrTwo, textNrThree, textNrFour;
    ImageView catFace;
    //Handler for changing image.
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        catFace = findViewById(R.id.catFace);
        textNrOne = findViewById(R.id.texNrOne);
        textNrTwo = findViewById(R.id.textNrTwo);
        textNrThree = findViewById(R.id.textNrThree);
        textNrFour = findViewById(R.id.textNrFour);
        //Now that i found all TextViews i will merge them into array, behold ... ^_^
        final TextView[] textArray = {textNrOne, textNrTwo, textNrThree, textNrFour};
        //This will change image in ImageView called catFace every 3 sec.
        //Also hide and show TextViews from textArray.
        Runnable runnable = new Runnable() {
            int i = 0;
            public void run() {
                //setting all 4 elements of array invisible for dramatic effect.
                textArray[0].setVisibility(View.INVISIBLE);
                textArray[1].setVisibility(View.INVISIBLE);
                textArray[2].setVisibility(View.INVISIBLE);
                textArray[3].setVisibility(View.INVISIBLE);
                //and boom, now we set new image and show one of TextViews.
                catFace.setImageResource(imageArray[i]);
                textArray[i].setVisibility(View.VISIBLE);
                i++;
                if (i > imageArray.length - 1) {
                    i = 0;
                }
                handler.postDelayed(this, 3000);
            }
        };
        handler.postDelayed(runnable, 3000);
    }
}
