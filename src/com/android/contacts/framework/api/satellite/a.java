package com.android.contacts.framework.api.satellite;

import H7.b;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import com.android.contacts.framework.api.satellite.ISatelliteComm;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.feature.FeatureUtil;
import kotlin.Result;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: ISatelliteCommWrapper.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15607a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final String f15608b = "ISatelliteCommWrapper";

    /* renamed from: c, reason: collision with root package name */
    public static final ISatelliteComm f15609c = ISatelliteComm.f15603a.a();

    /* renamed from: d, reason: collision with root package name */
    public static final v<Boolean> f15610d = new v<>();

    /* compiled from: ISatelliteCommWrapper.kt */
    /* renamed from: com.android.contacts.framework.api.satellite.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0163a implements ISatelliteComm.a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0163a f15611a = new C0163a();
    }

    public static final void a(Context context) {
        Object b10;
        q qVar;
        i.f(context, "context");
        b.e(f15608b, "init");
        try {
            Result.a aVar = Result.f34166a;
            ISatelliteComm iSatelliteComm = f15609c;
            if (iSatelliteComm != null) {
                iSatelliteComm.b(context, C0163a.f15611a);
                qVar = q.f35511a;
            } else {
                qVar = null;
            }
            b10 = Result.b(qVar);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            b.c(f15608b, "init: exception: " + d10);
        }
    }

    public static final boolean b() {
        boolean z10;
        try {
            Result.a aVar = Result.f34166a;
            if (OsUtils.f28279e && OsUtils.f() && FeatureUtil.W()) {
                z10 = true;
            } else {
                z10 = false;
            }
            boolean Q10 = FeatureUtil.f28316a.Q();
            if (H7.a.b()) {
                b.b(f15608b, "isFeatureDefined: " + z10 + ", " + FeatureUtil.W() + ", " + Q10);
            }
            if (!z10 || !Q10) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Throwable d10 = Result.d(Result.b(kotlin.b.a(th)));
            if (d10 != null) {
                b.c(f15608b, "isFeatureDefined: exception: " + d10);
            }
            return false;
        }
    }

    public static final boolean d() {
        boolean z10;
        ISatelliteComm iSatelliteComm = f15609c;
        if (iSatelliteComm != null) {
            z10 = iSatelliteComm.a();
        } else {
            z10 = false;
        }
        if (H7.a.b()) {
            b.b(f15608b, "isSatelliteEnable: " + z10);
        }
        return z10;
    }

    public static final boolean e() {
        boolean z10;
        ISatelliteComm iSatelliteComm = f15609c;
        if (iSatelliteComm != null) {
            z10 = iSatelliteComm.c();
        } else {
            z10 = false;
        }
        if (H7.a.b()) {
            b.b(f15608b, "isSatelliteInService: " + z10);
        }
        return z10;
    }

    public final LiveData<Boolean> c() {
        return f15610d;
    }
}
