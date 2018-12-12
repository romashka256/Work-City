package com.workcity.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.util.Log;
import android.util.Pair;

import com.workcity.model.listeners.OnGetAppsSuccess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppManager {

    private Context context;
    private OnGetAppsSuccess lisntener;

    public AppManager(Context context, OnGetAppsSuccess lisntener) {
        this.context = context;
        this.lisntener = lisntener;
    }

    public void getInstalledApplications() {
        List<AppPOJO> installedApps = new ArrayList<>();
        List<AppPOJO> systemApps = new ArrayList<>();

        final PackageManager pm = context.getPackageManager();

        List<ApplicationInfo> apps = pm.getInstalledApplications(0);
        for (ApplicationInfo ai : apps) {
            final String applicationName = (String) (ai != null ? pm.getApplicationLabel(ai) : "(unknown)");
            if ((ai.flags & (ApplicationInfo.FLAG_UPDATED_SYSTEM_APP | ApplicationInfo.FLAG_SYSTEM)) > 0) {
                systemApps.add(new AppPOJO(ai.packageName, applicationName, true));
            } else {
                installedApps.add(new AppPOJO(ai.packageName, applicationName, false));
                // It is installed by the user
            }
        }
        lisntener.onSuccess(installedApps, systemApps);
    }
}
