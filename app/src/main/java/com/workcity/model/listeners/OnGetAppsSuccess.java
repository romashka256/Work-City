package com.workcity.model.listeners;

import android.util.Pair;

import com.workcity.model.AppPOJO;

import java.util.List;

public interface OnGetAppsSuccess {
    void onSuccess(List<AppPOJO> installed, List<AppPOJO> system);
}
