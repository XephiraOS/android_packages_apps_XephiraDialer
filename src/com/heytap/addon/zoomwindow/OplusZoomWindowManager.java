package com.heytap.addon.zoomwindow;

import A5.a;
import com.color.zoomwindow.ColorZoomWindowManager;
import com.color.zoomwindow.IColorZoomWindowObserver;
import com.heytap.addon.zoomwindow.IOplusZoomWindowObserver;

/* loaded from: classes3.dex */
public class OplusZoomWindowManager {
    public static int WINDOWING_MODE_ZOOM;
    private static OplusZoomWindowManager sInstance;
    private ColorZoomWindowManager mManager;
    private com.oplus.zoomwindow.OplusZoomWindowManager mOplusManager;

    static {
        if (a.b()) {
            WINDOWING_MODE_ZOOM = 100;
        } else {
            WINDOWING_MODE_ZOOM = ColorZoomWindowManager.WINDOWING_MODE_ZOOM;
        }
    }

    private OplusZoomWindowManager(ColorZoomWindowManager colorZoomWindowManager) {
        this.mManager = colorZoomWindowManager;
    }

    public static OplusZoomWindowManager getInstance() {
        if (sInstance == null) {
            synchronized (OplusZoomWindowManager.class) {
                try {
                    if (sInstance == null) {
                        if (a.b()) {
                            sInstance = new OplusZoomWindowManager(com.oplus.zoomwindow.OplusZoomWindowManager.getInstance());
                        } else if (a.a()) {
                            sInstance = new OplusZoomWindowManager(ColorZoomWindowManager.getInstance());
                        } else {
                            sInstance = new OplusZoomWindowManager();
                        }
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    public OplusZoomWindowInfo getCurrentZoomWindowState() {
        if (a.b()) {
            return new OplusZoomWindowInfo(this.mOplusManager.getCurrentZoomWindowState());
        }
        if (a.a()) {
            return new OplusZoomWindowInfo(this.mManager.getCurrentZoomWindowState());
        }
        return new OplusZoomWindowInfo();
    }

    public boolean isSupportZoomWindowMode() {
        if (a.b()) {
            return this.mOplusManager.isSupportZoomWindowMode();
        }
        return this.mManager.isSupportZoomWindowMode();
    }

    public boolean registerZoomWindowObserver(IOplusZoomWindowObserver iOplusZoomWindowObserver) {
        if (iOplusZoomWindowObserver.isStub()) {
            if (a.b()) {
                return this.mOplusManager.registerZoomWindowObserver(new IOplusZoomWindowObserver.Stub.IOplusZoomWindowObserverStubImplR(iOplusZoomWindowObserver));
            }
            if (!a.a()) {
                return false;
            }
            return this.mManager.registerZoomWindowObserver(new IOplusZoomWindowObserver.Stub.IColorZoomWindowObserverStubImplQ(iOplusZoomWindowObserver));
        }
        if (a.b()) {
            return this.mOplusManager.registerZoomWindowObserver(new IOplusZoomWindowObserver.IOplusZoomWindowObserverRImpl(iOplusZoomWindowObserver));
        }
        if (!a.a()) {
            return false;
        }
        return this.mManager.registerZoomWindowObserver(new IOplusZoomWindowObserver.IOplusZoomWindowObserverQImpl(iOplusZoomWindowObserver));
    }

    public boolean unregisterZoomWindowObserver(IOplusZoomWindowObserver iOplusZoomWindowObserver) {
        if (a.b()) {
            return this.mOplusManager.unregisterZoomWindowObserver((com.oplus.zoomwindow.IOplusZoomWindowObserver) iOplusZoomWindowObserver.getZoomWindowObserver());
        }
        if (a.a()) {
            return this.mManager.unregisterZoomWindowObserver((IColorZoomWindowObserver) iOplusZoomWindowObserver.getZoomWindowObserver());
        }
        return false;
    }

    private OplusZoomWindowManager(com.oplus.zoomwindow.OplusZoomWindowManager oplusZoomWindowManager) {
        this.mOplusManager = oplusZoomWindowManager;
    }

    private OplusZoomWindowManager() {
    }
}
