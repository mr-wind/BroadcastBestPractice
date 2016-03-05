package com.quhaofeng.broadcastbestpractice;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Quhaofeng on 2016-3-4-0004.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityCollecter.addActivity(this);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollecter.removeActivity(this);
    }
}
