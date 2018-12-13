package com.workcity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Service;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.util.ArrayMap;

import java.lang.reflect.Field;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Nullable;

import timber.log.Timber;

public class AppsTrackerService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;

    }

    @Override
    public void onCreate() {
        super.onCreate();

    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (((App) getApplication()).getActiveActivity() != null)
            Timber.e(((App) getApplication()).getActiveActivity().getPackageName());

        return Service.START_STICKY;
    }
}

//  while (true)
//    {
//        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//
//        final List<ActivityManager.RunningTaskInfo> recentTasks = activityManager.getRunningTasks(Integer.MAX_VALUE);
//
//        for (ActivityManager.RunningTaskInfo ri : recentTasks) {
//            Timber.e(ri.baseActivity.getPackageName());
//            Timber.e(String.valueOf(ri.topActivity));
//        }
//    }
//}


//  try {
//          Class activityThreadClass = Class.forName("android.app.ActivityThread");
//          Object activityThread = activityThreadClass.getMethod("currentActivityThread")
//          .invoke(null);
//          Field activitiesField = activityThreadClass.getDeclaredField("mActivities");
//          activitiesField.setAccessible(true);
//          ArrayMap activities = (ArrayMap) activitiesField.get(activityThread);
//          for (Object activityRecord : activities.values()) {
//          Class activityRecordClass = activityRecord.getClass();
//          Field pausedField = activityRecordClass.getDeclaredField("paused");
//          pausedField.setAccessible(true);
//          if (!pausedField.getBoolean(activityRecord)) {
//          Field activityField = activityRecordClass.getDeclaredField("activity");
//          activityField.setAccessible(true);
//          Timber.e(((Activity) activityField.get(activityRecord)).getPackageName());
//          }
//          }
//          } catch (Exception e) {
//          throw new RuntimeException(e);
//          }


//
//                while (true) {
//                    UsageStatsManager mUsageStatsManager = (UsageStatsManager) getSystemService(USAGE_STATS_SERVICE);
//                    long time = System.currentTimeMillis();
//
//                    // We get usage stats for the last 10 seconds
//                    List<UsageStats> stats = mUsageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, time - 1000 * 10, time);
//
//                    // Sort the stats by the last time used
//                    if (stats != null) {
//                        SortedMap<Long, UsageStats> mySortedMap = new TreeMap<>();
//                        for (UsageStats usageStats : stats) {
//                            mySortedMap.put(usageStats.getLastTimeUsed(), usageStats);
//                        }
//                        if (mySortedMap != null && !mySortedMap.isEmpty()) {
//                            Timber.e(mySortedMap.get(mySortedMap.lastKey()).getPackageName());
//                        }
//                    }
//                }
//            }