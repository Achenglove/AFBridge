package com.ccr.bridge;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ccr.library.AFBridge;

import java.util.ArrayList;
import java.util.List;


/**
 * @Created on 2018/8/31.
 * @autthor Acheng
 * @Email 345887272@qq.com
 * @Description
 */

public class Fragment1 extends Fragment implements View.OnClickListener {
    private Activity mActivity;
    public static final String EVENT_CLICK = "event_click";
    private List<String> list=new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    public Fragment1() {
    }

    public static Fragment1 newInstance() {
        return new Fragment1();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.fragment1, container, false);
        view.findViewById(R.id.button).setOnClickListener(this);
        setData();
        return view;
    }

    private void setData(){
        list.add("Activity");
        list.add("与");
        list.add("Fragment");
        list.add("之间的通信");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:

                AFBridge.call(mActivity,EVENT_CLICK,list);
                break;
        }

    }
}
