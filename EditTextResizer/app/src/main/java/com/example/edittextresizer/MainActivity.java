package com.example.edittextresizer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;



public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    AutoFitEditText mAutoFitEditText;
    CoordinatorLayout mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAutoFitEditText = (AutoFitEditText) findViewById(R.id.rET);
        mRootView = (CoordinatorLayout) findViewById(R.id.root);

        initAutoFitEditText();

    }


    public void initAutoFitEditText() {

        mAutoFitEditText.setEnabled(true);
        mAutoFitEditText.setFocusableInTouchMode(true);
        mAutoFitEditText.setFocusable(true);
        mAutoFitEditText.setEnableSizeCache(false);
        //might cause crash on some devices
        mAutoFitEditText.setMovementMethod(null);
        // can be added after layout inflation;
        mAutoFitEditText.setMaxHeight(80);
        //don't forget to add min text size programmatically
        mAutoFitEditText.setMinTextSize(15f);

        AutoFitEditTextUtil.setNormalization(this, mRootView, mAutoFitEditText);
    }


}