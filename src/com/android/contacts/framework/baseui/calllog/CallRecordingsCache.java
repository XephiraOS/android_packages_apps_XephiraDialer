package com.android.contacts.framework.baseui.calllog;

import C7.e;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import com.google.common.collect.y;
import java.util.Set;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.InterfaceC1265l0;
import kotlinx.coroutines.S;

/* compiled from: CallRecordingsCache.kt */
/* loaded from: classes.dex */
public final class CallRecordingsCache {

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f15756c;

    /* renamed from: d, reason: collision with root package name */
    public static volatile boolean f15757d;

    /* renamed from: e, reason: collision with root package name */
    public static volatile boolean f15758e;

    /* renamed from: f, reason: collision with root package name */
    public static volatile boolean f15759f;

    /* renamed from: h, reason: collision with root package name */
    public static volatile InterfaceC1265l0 f15761h;

    /* renamed from: i, reason: collision with root package name */
    public static Context f15762i;

    /* renamed from: a, reason: collision with root package name */
    public static final CallRecordingsCache f15754a = new CallRecordingsCache();

    /* renamed from: b, reason: collision with root package name */
    public static final Set<Long> f15755b = y.c();

    /* renamed from: g, reason: collision with root package name */
    public static volatile Object f15760g = new Object();

    /* renamed from: j, reason: collision with root package name */
    public static final v<Boolean> f15763j = new v<>();

    /* compiled from: CallRecordingsCache.kt */
    /* loaded from: classes.dex */
    public static final class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public static final a f15764a = new a();

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            int d10 = e.d(intent, "recording_count", 0);
            if (intent != null) {
                str = intent.getAction();
            } else {
                str = null;
            }
            H7.b.e("CallRecordingsCache", "onReceive: " + str + ", count: " + d10);
            if (d10 > 0) {
                CallRecordingsCache.f15754a.s();
            }
        }
    }

    /* compiled from: CallRecordingsCache.kt */
    /* loaded from: classes.dex */
    public static final class contentObserver extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        public static final contentObserver f15765a = new contentObserver();

        public contentObserver() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            InterfaceC1265l0 d10;
            H7.b.e("CallRecordingsCache", "onChange: " + z10);
            CallRecordingsCache.f15754a.s();
            if (!CallRecordingsCache.f15759f && CallRecordingsCache.f15761h == null) {
                d10 = C1248i.d(C1241e0.f34422a, S.b(), null, new CallRecordingsCache$contentObserver$onChange$1(null), 2, null);
                CallRecordingsCache.f15761h = d10;
            }
        }
    }

    public final LiveData<Boolean> o() {
        return f15763j;
    }

    public final boolean p() {
        return f15757d;
    }

    public final boolean q(long j10) {
        return f15755b.contains(Long.valueOf(j10));
    }

    public final void r(Context context) {
        i.f(context, "context");
        f15762i = context.getApplicationContext();
        if (!f15756c) {
            C1248i.d(C1241e0.f34422a, S.b(), null, new CallRecordingsCache$init$1(context, null), 2, null);
        } else if (H7.a.b()) {
            H7.b.b("CallRecordingsCache", "Already inited.");
        }
    }

    public final void s() {
        Context context = f15762i;
        if (context != null) {
            f15756c = false;
            f15754a.r(context);
        }
    }
}
