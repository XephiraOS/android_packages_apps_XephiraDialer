package com.coui.appcompat.lifecycle;

import android.app.Activity;
import android.content.res.Configuration;
import androidx.lifecycle.InterfaceC0491n;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.x;

/* loaded from: classes.dex */
public class COUILifeCycleObserver implements InterfaceC0491n {
    public Activity mActivity;

    public COUILifeCycleObserver(Activity activity) {
        this.mActivity = activity;
    }

    @x(Lifecycle.Event.ON_CREATE)
    private void componentCreate() {
    }

    @x(Lifecycle.Event.ON_DESTROY)
    private void componentDestory() {
    }

    @x(Lifecycle.Event.ON_PAUSE)
    private void componentPause() {
    }

    @x(Lifecycle.Event.ON_RESUME)
    private void componentResume() {
    }

    @x(Lifecycle.Event.ON_START)
    private void componentStart() {
    }

    @x(Lifecycle.Event.ON_STOP)
    private void componentStop() {
    }

    public void updateChanged(Configuration configuration) {
    }
}
