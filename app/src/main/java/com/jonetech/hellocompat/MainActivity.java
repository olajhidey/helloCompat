package com.jonetech.hellocompat;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView displayedText;

    private String[] mColorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayedText = (TextView) findViewById(R.id.hello_textview);

        if(savedInstanceState != null){
            displayedText.setTextColor(savedInstanceState.getInt("color"));
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("color", displayedText.getCurrentTextColor());
    }

    /**
     * This method handles the click of the Change Color button by
     * picking a random color from a color array.
     *
     * @param view The view that was clicked
     */

    public void changeColor(View view) {

        // Get random name from the array
        Random mRandom = new Random();

        String colorName = mColorArray[mRandom.nextInt(20)];

        int colorResources = getResources().getIdentifier(colorName, "color", getApplicationContext().getPackageName());

        // Get thr colour id from the resources
        int colorRes = ContextCompat.getColor(this, colorResources);

        // set textview color

        displayedText.setTextColor(colorRes);

    }
}
