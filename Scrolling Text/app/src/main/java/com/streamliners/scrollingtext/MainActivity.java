package com.streamliners.scrollingtext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.streamliners.scrollingtext.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String COUNT = "countKey";
    private static final String COLOR = "colorKey";
    ActivityMainBinding b;
//    Current background color
    int mColor;
//    Current Count
    int mCount = 0;

    private TextView mShowCountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupLayout();
        mShowCountTextView = findViewById(R.id.count_textview);
        mColor = ContextCompat.getColor(this, R.color.gray);

        if(savedInstanceState != null){
            mCount = savedInstanceState.getInt(COUNT);
            if(mCount != 0){
                mShowCountTextView.setText(String.format("%s",mCount));
            }
            mColor = savedInstanceState.getInt(COLOR);
            mShowCountTextView.setBackgroundColor(mColor);

        }

    }

    private void setupLayout() {
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
    }


    public void changeBackground(View view) {
        int color = ((ColorDrawable) view.getBackground()).getColor();
        mShowCountTextView.setBackgroundColor(color);
        mColor = color;
    }

    public void countUp(View view) {
        mCount++;
        mShowCountTextView.setText(String.format("%s",mCount));
    }

    public void reset(View view) {
//        Reseting Count
        mCount = 0;
        mShowCountTextView.setText(String.format("%s",mCount));

//        Reset Color
        mColor = ContextCompat.getColor(this,R.color.gray);
        mShowCountTextView.setBackgroundColor(mColor);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNT,mCount);
        outState.putInt(COLOR,mColor);
    }
}