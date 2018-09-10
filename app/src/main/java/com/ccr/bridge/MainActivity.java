package com.ccr.bridge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ccr.apt.FCallbackId;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, Fragment1.newInstance(), "f1").commit();
        }

    }

    @FCallbackId(id = Fragment1.EVENT_CLICK)
    public void setData(List<String> s) {
        StringBuilder stringBuilder=new StringBuilder();
        for (String s1:s){
            stringBuilder.append(s1);
        }
        textView.setText(stringBuilder.toString());
    }
}
