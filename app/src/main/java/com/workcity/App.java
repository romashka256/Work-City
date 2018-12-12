package com.workcity;

import android.app.Application;
import android.content.Context;
import android.telecom.Conference;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import timber.log.Timber;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG)
            Timber.plant(new Timber.DebugTree() {
                @Override
                protected @Nullable String createStackElementTag(@NotNull StackTraceElement element) {
                    return String.format("%s:%s",
                            super.createStackElementTag(element),
                            element.getLineNumber());
                }
            });
        else
            Timber.plant(new ReleaseTree());


    }
}
