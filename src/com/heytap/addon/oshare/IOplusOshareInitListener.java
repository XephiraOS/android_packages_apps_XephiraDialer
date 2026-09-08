package com.heytap.addon.oshare;

import android.os.Binder;
import android.os.IInterface;
import com.oplus.oshare.IOplusOshareInitListener;

/* loaded from: classes3.dex */
public interface IOplusOshareInitListener extends IInterface {

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IOplusOshareInitListener {

        /* loaded from: classes3.dex */
        public static class StubR extends IOplusOshareInitListener.Stub {

            /* renamed from: f, reason: collision with root package name */
            public IOplusOshareInitListener f25410f;

            public void onShareInit() {
                this.f25410f.onShareInit();
            }

            public void onShareUninit() {
                this.f25410f.onShareUninit();
            }
        }
    }

    void onShareInit();

    void onShareUninit();
}
