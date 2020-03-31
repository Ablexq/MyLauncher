package com.example.mylauncher;

import android.content.ComponentName;
import android.content.pm.PackageManager;

public class LaunchUtil {

    private PackageManager mPm;

    public LaunchUtil(PackageManager mPm) {
        this.mPm = mPm;
    }

    /**
     * @param componentName
     */
    public void enableComponent(ComponentName componentName) {
        mPm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

    /**
     * @param componentName
     */
    public void disableComponent(ComponentName componentName) {
        mPm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }
}
