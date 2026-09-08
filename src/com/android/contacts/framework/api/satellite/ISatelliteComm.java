package com.android.contacts.framework.api.satellite;

import android.content.Context;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import kotlin.Result;
import kotlin.b;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: ISatelliteComm.kt */
/* loaded from: classes.dex */
public interface ISatelliteComm {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f15603a = Companion.f15604a;

    /* compiled from: ISatelliteComm.kt */
    /* loaded from: classes.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f15604a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final d<ISatelliteComm> f15605b;

        static {
            d<ISatelliteComm> b10;
            b10 = kotlin.a.b(new InterfaceC1637a<ISatelliteComm>() { // from class: com.android.contacts.framework.api.satellite.ISatelliteComm$Companion$instance$2
                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final ISatelliteComm invoke() {
                    Object b11;
                    Object obj = null;
                    if (!CommonFeatureOption.j()) {
                        return null;
                    }
                    try {
                        Result.a aVar = Result.f34166a;
                        b11 = Result.b((ISatelliteComm) A8.a.f202a.a(ISatelliteComm.class));
                    } catch (Throwable th) {
                        Result.a aVar2 = Result.f34166a;
                        b11 = Result.b(b.a(th));
                    }
                    Throwable d10 = Result.d(b11);
                    if (d10 != null) {
                        H7.b.c("ISatelliteComm", "init component: exception: " + d10);
                    }
                    if (!Result.f(b11)) {
                        obj = b11;
                    }
                    return (ISatelliteComm) obj;
                }
            });
            f15605b = b10;
        }

        public final ISatelliteComm a() {
            return f15605b.getValue();
        }
    }

    /* compiled from: ISatelliteComm.kt */
    /* loaded from: classes.dex */
    public interface a {
    }

    boolean a();

    void b(Context context, a aVar);

    boolean c();
}
