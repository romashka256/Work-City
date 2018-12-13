package com.workcity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;

import com.workcity.model.AppManager;
import com.workcity.model.AppPOJO;
import com.workcity.model.listeners.OnGetAppsSuccess;

import java.util.List;

import timber.log.Timber;

public class SettingsActivity extends AppCompatActivity {

    boolean recreated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            recreated = true;
        } else {
            recreated = false;
        }

        Timber.i("OnCreate, recreated : %s",recreated);

        setContentView(R.layout.settings_activity);

        AppManager appManager = new AppManager(this, new OnGetAppsSuccess() {
            @Override
            public void onSuccess(List<AppPOJO> installed, List<AppPOJO> system) {
                Timber.e("OnGetAppsSuccess");
            }
        });

        appManager.getInstalledApplications();

        startService(new Intent(this, AppsTrackerService.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Timber.i("onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Timber.i("onResume");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Timber.i("onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Timber.i("onDestroy");

    }
}

//   ActivityManager activity_manager = (ActivityManager) getSystemService(Activity.ACTIVITY_SERVICE);

//        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//
//        final List<ActivityManager.RunningTaskInfo> recentTasks = activityManager.getRunningTasks(Integer.MAX_VALUE);
//
//        for (ActivityManager.RunningTaskInfo ri : recentTasks){
//            Timber.e(ri.baseActivity.getPackageName());
//            Timber.e(String.valueOf(ri.topActivity));
//        }