package com.android.contacts.dialpad;

import android.content.Context;
import android.telephony.SubscriptionInfo;
import com.customize.contacts.util.b0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;

/* compiled from: SimInfoManager.kt */
/* loaded from: classes.dex */
public final class SimInfoManager {

    /* renamed from: g, reason: collision with root package name */
    public static final a f14884g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public int f14885a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f14886b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14887c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap<String, String> f14888d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList<b0.a> f14889e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public List<? extends SubscriptionInfo> f14890f;

    /* compiled from: SimInfoManager.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final void b(String str) {
            if (H7.a.b()) {
                H7.b.b("SimInfoManager", str);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: SimInfoManager.kt */
    /* loaded from: classes.dex */
    public interface b {
        void a(int i10, long j10);
    }

    public final void a() {
        f14884g.b("Dump SimInfoManager's Status -> {mSimCount=" + this.f14885a + ", mSim1IsUnavailable=" + this.f14886b + ", mSim2IsUnavailable=" + this.f14887c + ", mInsertedSimInfo=" + this.f14888d + ", mSimInfos=" + this.f14889e + "}");
    }

    public final HashMap<String, String> b() {
        return this.f14888d;
    }

    public final int c() {
        return this.f14885a;
    }

    public final ArrayList<b0.a> d() {
        return this.f14889e;
    }

    public final List<SubscriptionInfo> e() {
        return this.f14890f;
    }

    public final boolean f() {
        return this.f14886b;
    }

    public final boolean g() {
        return this.f14887c;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(android.content.Context r26, com.android.contacts.dialpad.SimInfoManager.b r27) {
        /*
            Method dump skipped, instructions count: 876
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.dialpad.SimInfoManager.h(android.content.Context, com.android.contacts.dialpad.SimInfoManager$b):void");
    }

    public final void i(Context context, b bVar, Runnable runnable) {
        if (context != null) {
            C1248i.d(C1241e0.f34422a, S.a(), null, new SimInfoManager$refreshSimInfoBackground$1(this, context, bVar, runnable, null), 2, null);
        } else {
            H7.b.i("SimInfoManager", "refreshSimInfoBackground: illegal param: context is null.");
        }
    }
}
