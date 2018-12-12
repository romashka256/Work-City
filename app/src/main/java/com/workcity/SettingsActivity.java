package com.workcity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        AppManager appManager = new AppManager(this, new OnGetAppsSuccess() {
            @Override
            public void onSuccess(List<AppPOJO> installed, List<AppPOJO> system) {
                Timber.e("OnGetAppsSuccess");
            }
        });

        appManager.getInstalledApplications();
    }
}
