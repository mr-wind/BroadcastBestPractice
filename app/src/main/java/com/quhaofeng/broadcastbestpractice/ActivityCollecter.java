package com.quhaofeng.broadcastbestpractice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quhaofeng on 2016-3-4-0004.
 */
public class ActivityCollecter {
    public static List<Activity> sActivities = new ArrayList<Activity>();

    public static void addActivity(Activity activity){
        //通过判断来去掉重复的Activity
        if (!sActivities.contains(activity)){
            sActivities.add(activity);
        }
    }

    public static void removeActivity(Activity activity){
        sActivities.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity : sActivities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
