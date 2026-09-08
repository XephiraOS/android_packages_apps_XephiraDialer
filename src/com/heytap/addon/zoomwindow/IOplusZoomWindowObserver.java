package com.heytap.addon.zoomwindow;

import com.color.zoomwindow.ColorZoomWindowInfo;
import com.color.zoomwindow.IColorZoomWindowObserver;
import com.oplus.zoomwindow.IOplusZoomWindowObserver;

/* loaded from: classes3.dex */
public abstract class IOplusZoomWindowObserver {
    Object mObserver;

    /* loaded from: classes3.dex */
    public static class IOplusZoomWindowObserverQImpl extends IColorZoomWindowObserver.Default {
        IOplusZoomWindowObserver mIOplusZoomWindowObserver;

        public IOplusZoomWindowObserverQImpl(IOplusZoomWindowObserver iOplusZoomWindowObserver) {
            this.mIOplusZoomWindowObserver = iOplusZoomWindowObserver;
            iOplusZoomWindowObserver.setZoomWindowObserver(this);
        }

        public void onInputMethodChanged(boolean z10) {
            this.mIOplusZoomWindowObserver.onInputMethodChanged(z10);
        }

        public void onZoomWindowDied(String str) {
            this.mIOplusZoomWindowObserver.onZoomWindowDied(str);
        }

        public void onZoomWindowHide(ColorZoomWindowInfo colorZoomWindowInfo) {
            this.mIOplusZoomWindowObserver.onZoomWindowHide(new OplusZoomWindowInfo(colorZoomWindowInfo));
        }

        public void onZoomWindowShow(ColorZoomWindowInfo colorZoomWindowInfo) {
            this.mIOplusZoomWindowObserver.onZoomWindowShow(new OplusZoomWindowInfo(colorZoomWindowInfo));
        }
    }

    /* loaded from: classes3.dex */
    public static class IOplusZoomWindowObserverRImpl extends IOplusZoomWindowObserver.Default {
        IOplusZoomWindowObserver mIOplusZoomWindowObserver;

        public IOplusZoomWindowObserverRImpl(IOplusZoomWindowObserver iOplusZoomWindowObserver) {
            this.mIOplusZoomWindowObserver = iOplusZoomWindowObserver;
            iOplusZoomWindowObserver.setZoomWindowObserver(this);
        }

        public void onInputMethodChanged(boolean z10) {
            this.mIOplusZoomWindowObserver.onInputMethodChanged(z10);
        }

        public void onZoomWindowDied(String str) {
            this.mIOplusZoomWindowObserver.onZoomWindowDied(str);
        }

        public void onZoomWindowHide(com.oplus.zoomwindow.OplusZoomWindowInfo oplusZoomWindowInfo) {
            this.mIOplusZoomWindowObserver.onZoomWindowHide(new OplusZoomWindowInfo(oplusZoomWindowInfo));
        }

        public void onZoomWindowShow(com.oplus.zoomwindow.OplusZoomWindowInfo oplusZoomWindowInfo) {
            this.mIOplusZoomWindowObserver.onZoomWindowShow(new OplusZoomWindowInfo(oplusZoomWindowInfo));
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Stub extends IOplusZoomWindowObserver {

        /* loaded from: classes3.dex */
        public static class IColorZoomWindowObserverStubImplQ extends IColorZoomWindowObserver.Stub {
            IOplusZoomWindowObserver mIOplusZoomWindowObserver;

            public IColorZoomWindowObserverStubImplQ(IOplusZoomWindowObserver iOplusZoomWindowObserver) {
                this.mIOplusZoomWindowObserver = iOplusZoomWindowObserver;
                iOplusZoomWindowObserver.setZoomWindowObserver(this);
            }

            public void onInputMethodChanged(boolean z10) {
                this.mIOplusZoomWindowObserver.onInputMethodChanged(z10);
            }

            public void onZoomWindowDied(String str) {
                this.mIOplusZoomWindowObserver.onZoomWindowDied(str);
            }

            public void onZoomWindowHide(ColorZoomWindowInfo colorZoomWindowInfo) {
                this.mIOplusZoomWindowObserver.onZoomWindowHide(new OplusZoomWindowInfo(colorZoomWindowInfo));
            }

            public void onZoomWindowShow(ColorZoomWindowInfo colorZoomWindowInfo) {
                this.mIOplusZoomWindowObserver.onZoomWindowShow(new OplusZoomWindowInfo(colorZoomWindowInfo));
            }
        }

        /* loaded from: classes3.dex */
        public static class IOplusZoomWindowObserverStubImplR extends IOplusZoomWindowObserver.Stub {
            IOplusZoomWindowObserver mIOplusZoomWindowObserver;

            public IOplusZoomWindowObserverStubImplR(IOplusZoomWindowObserver iOplusZoomWindowObserver) {
                this.mIOplusZoomWindowObserver = iOplusZoomWindowObserver;
                iOplusZoomWindowObserver.setZoomWindowObserver(this);
            }

            public void onInputMethodChanged(boolean z10) {
                this.mIOplusZoomWindowObserver.onInputMethodChanged(z10);
            }

            public void onZoomWindowDied(String str) {
                this.mIOplusZoomWindowObserver.onZoomWindowDied(str);
            }

            public void onZoomWindowHide(com.oplus.zoomwindow.OplusZoomWindowInfo oplusZoomWindowInfo) {
                this.mIOplusZoomWindowObserver.onZoomWindowHide(new OplusZoomWindowInfo(oplusZoomWindowInfo));
            }

            public void onZoomWindowShow(com.oplus.zoomwindow.OplusZoomWindowInfo oplusZoomWindowInfo) {
                this.mIOplusZoomWindowObserver.onZoomWindowShow(new OplusZoomWindowInfo(oplusZoomWindowInfo));
            }
        }

        @Override // com.heytap.addon.zoomwindow.IOplusZoomWindowObserver
        public boolean isStub() {
            return true;
        }
    }

    public <T> T getZoomWindowObserver() {
        try {
            return (T) this.mObserver;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public boolean isStub() {
        return false;
    }

    public abstract void onInputMethodChanged(boolean z10);

    public abstract void onZoomWindowDied(String str);

    public abstract void onZoomWindowHide(OplusZoomWindowInfo oplusZoomWindowInfo);

    public abstract void onZoomWindowShow(OplusZoomWindowInfo oplusZoomWindowInfo);

    public void setZoomWindowObserver(Object obj) {
        this.mObserver = obj;
    }
}
