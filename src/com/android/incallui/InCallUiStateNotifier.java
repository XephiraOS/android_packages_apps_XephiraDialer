package com.android.incallui;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class InCallUiStateNotifier implements DisplayManager.DisplayListener {
    private static InCallUiStateNotifier sInCallUiStateNotifier;
    private Context mContext;
    private DisplayManager mDisplayManager;
    private List<InCallUiStateNotifierListener> mInCallUiStateNotifierListeners = new CopyOnWriteArrayList();
    private boolean mIsDisplayOn;
    private boolean mIsInBackground;

    private InCallUiStateNotifier() {
    }

    public static synchronized InCallUiStateNotifier getInstance() {
        InCallUiStateNotifier inCallUiStateNotifier;
        synchronized (InCallUiStateNotifier.class) {
            try {
                if (sInCallUiStateNotifier == null) {
                    sInCallUiStateNotifier = new InCallUiStateNotifier();
                }
                inCallUiStateNotifier = sInCallUiStateNotifier;
            } catch (Throwable th) {
                throw th;
            }
        }
        return inCallUiStateNotifier;
    }

    private boolean isUiShowing() {
        if (!this.mIsInBackground && this.mIsDisplayOn) {
            return true;
        }
        return false;
    }

    private void notifyOnUiShowing(boolean z10) {
        com.google.common.base.k.o(this.mInCallUiStateNotifierListeners);
        Iterator<InCallUiStateNotifierListener> it = this.mInCallUiStateNotifierListeners.iterator();
        while (it.hasNext()) {
            it.next().onUiShowing(z10);
        }
    }

    public void addListener(InCallUiStateNotifierListener inCallUiStateNotifierListener) {
        com.google.common.base.k.o(inCallUiStateNotifierListener);
        this.mInCallUiStateNotifierListeners.add(inCallUiStateNotifierListener);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int i10) {
        boolean z10;
        DisplayManager displayManager = this.mDisplayManager;
        if (displayManager != null && displayManager.getDisplay(i10) != null) {
            Display display = this.mDisplayManager.getDisplay(i10);
            if (display == null) {
                Log.w("InCallUiStateNotifier", "onDisplayChanged Ignoring for display is null");
                return;
            }
            int state = display.getState();
            Log.d(this, "onDisplayChanged displayState: " + state + " displayId: " + i10);
            if (i10 != 0) {
                Log.w(this, "onDisplayChanged Ignoring...");
                return;
            }
            boolean isUiShowing = isUiShowing();
            if (state != 2 && state != 3 && state != 4) {
                z10 = false;
            } else {
                z10 = true;
            }
            this.mIsDisplayOn = z10;
            boolean isUiShowing2 = isUiShowing();
            Log.d(this, "onDisplayChanged wasShowing: " + isUiShowing + " isShowing: " + isUiShowing2);
            if (isUiShowing != isUiShowing2) {
                notifyOnUiShowing(this.mIsDisplayOn);
                return;
            }
            return;
        }
        Log.w("InCallUiStateNotifier", "onDisplayChanged Ignoring for mDisplayManager is null");
    }

    public void onUiShowing(boolean z10) {
        boolean isUiShowing = isUiShowing();
        this.mIsInBackground = !z10;
        boolean isUiShowing2 = isUiShowing();
        Log.d(this, "onUiShowing wasShowing: " + isUiShowing + " isShowing: " + isUiShowing2);
        if (isUiShowing != isUiShowing2) {
            notifyOnUiShowing(z10);
        }
    }

    public void removeListener(InCallUiStateNotifierListener inCallUiStateNotifierListener) {
        if (inCallUiStateNotifierListener != null) {
            this.mInCallUiStateNotifierListeners.remove(inCallUiStateNotifierListener);
        } else {
            Log.e(this, "Can't remove null listener");
        }
    }

    public void setUp(Context context) {
        this.mContext = context;
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        this.mDisplayManager = displayManager;
        displayManager.registerDisplayListener(this, null);
        boolean z10 = false;
        if (this.mDisplayManager.getDisplay(0).getState() == 2) {
            z10 = true;
        }
        this.mIsDisplayOn = z10;
        Log.d(this, "setUp mIsDisplayOn: " + this.mIsDisplayOn);
    }

    public void tearDown() {
        this.mDisplayManager.unregisterDisplayListener(this);
        this.mDisplayManager = null;
        this.mContext = null;
        this.mInCallUiStateNotifierListeners.clear();
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int i10) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int i10) {
    }
}
