package com.workcity.model;

import android.support.annotation.FloatRange;

import java.util.Objects;

import io.realm.RealmObject;
import lombok.Getter;
import lombok.Setter;

public class AppPOJO extends RealmObject {

    @Getter
    @Setter
    public String appPackage;

    @Getter
    @Setter
    public String appName;

    boolean isSystem;
    boolean inWhiteList;

    public AppPOJO() {
    }

    public AppPOJO(String appPackage, String appName, boolean isSystem) {
        this.appPackage = appPackage;
        this.appName = appName;
        this.isSystem = isSystem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppPOJO appPOJO = (AppPOJO) o;
        return appPOJO.appPackage.equals(this.appPackage);
    }

    @Override
    public int hashCode() {

        return Objects.hash(appPackage, appName);
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public boolean isSystem() {
        return isSystem;
    }

    public void setSystem(boolean system) {
        isSystem = system;
    }

    public boolean isInWhiteList() {
        return inWhiteList;
    }

    public void setInWhiteList(boolean inWhiteList) {
        this.inWhiteList = inWhiteList;
    }
}
