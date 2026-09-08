package v8;

import android.content.Context;
import java.util.UUID;
import w8.C1657d;

/* compiled from: StatIdManager.java */
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public String f37505a;

    /* renamed from: b, reason: collision with root package name */
    public long f37506b;

    /* compiled from: StatIdManager.java */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final l f37507a = new l();
    }

    public static l e() {
        return b.f37507a;
    }

    public final String a() {
        return UUID.randomUUID().toString();
    }

    public final long b(Context context) {
        return C1657d.d(context, "AppExitTime", 0L);
    }

    public String c(Context context) {
        if (this.f37505a == null) {
            i(context);
        }
        return this.f37505a;
    }

    public final String d(Context context) {
        return C1657d.i(context, "AppSessionId", "");
    }

    public final boolean f(Context context) {
        if (this.f37506b == 0) {
            this.f37506b = b(context);
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f37506b;
        if (currentTimeMillis > 0 && currentTimeMillis < 30000) {
            return true;
        }
        return false;
    }

    public void g(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f37506b = currentTimeMillis;
        j(context, currentTimeMillis);
    }

    public void h(Context context) {
        String a10 = a();
        this.f37505a = a10;
        k(context, a10);
    }

    public void i(Context context) {
        if (!f(context)) {
            h(context);
        } else {
            this.f37505a = d(context);
        }
    }

    public final void j(Context context, long j10) {
        C1657d.m(context, "AppExitTime", j10);
    }

    public final void k(Context context, String str) {
        C1657d.p(context, "AppSessionId", str);
    }

    public l() {
        this.f37505a = null;
        this.f37506b = 0L;
    }
}
