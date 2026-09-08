package com.customize.contacts.startupspeed;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.p;
import com.oplus.foundation.util.OsUtils;
import com.oplus.uah.UAHResClient;
import com.oplus.uah.info.UAHEventRequest;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: FastReadData.kt */
/* loaded from: classes3.dex */
public final class FastReadData {

    /* renamed from: d, reason: collision with root package name */
    public static final a f21818d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final ComponentActivity f21819a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<Integer> f21820b;

    /* renamed from: c, reason: collision with root package name */
    public final d f21821c;

    /* compiled from: FastReadData.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public FastReadData(ComponentActivity activity) {
        d b10;
        i.f(activity, "activity");
        this.f21819a = activity;
        this.f21820b = new ArrayList<>();
        b10 = kotlin.a.b(new InterfaceC1637a<UAHResClient>() { // from class: com.customize.contacts.startupspeed.FastReadData$uahResClient$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final UAHResClient invoke() {
                return UAHResClient.get(FastReadData.class);
            }
        });
        this.f21821c = b10;
    }

    public final synchronized void d() {
        int acquireEvent = f().acquireEvent(new UAHEventRequest(403, "", 4000, (ArrayList) null));
        if (acquireEvent != -1) {
            this.f21820b.add(Integer.valueOf(acquireEvent));
        }
    }

    public final void e() {
        if (OsUtils.f28279e) {
            C1248i.d(p.a(this.f21819a), S.a(), null, new FastReadData$acquireEvent$1(this, null), 2, null);
        }
    }

    public final UAHResClient f() {
        return (UAHResClient) this.f21821c.getValue();
    }

    public final synchronized boolean g() {
        return this.f21820b.isEmpty();
    }

    public final synchronized void h() {
        try {
            Iterator<Integer> it = this.f21820b.iterator();
            while (it.hasNext()) {
                Integer handle = it.next();
                UAHResClient f10 = f();
                i.e(handle, "handle");
                f10.release(handle.intValue());
            }
            this.f21820b.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void i() {
        if (!g()) {
            C1248i.d(p.a(this.f21819a), S.a(), null, new FastReadData$releaseEventHandle$1(this, null), 2, null);
        }
    }
}
