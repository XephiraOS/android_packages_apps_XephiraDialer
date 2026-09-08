package m8;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import p8.C1465b;
import q8.d;
import q8.i;
import r8.C1516a;
import r8.C1517b;

/* compiled from: PermissionCheck.java */
/* renamed from: m8.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1346c {

    /* renamed from: f, reason: collision with root package name */
    public static volatile C1346c f35484f;

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f35485a = false;

    /* renamed from: b, reason: collision with root package name */
    public Context f35486b;

    /* renamed from: c, reason: collision with root package name */
    public C1516a f35487c;

    /* renamed from: d, reason: collision with root package name */
    public r8.c f35488d;

    /* renamed from: e, reason: collision with root package name */
    public C1517b f35489e;

    public static C1346c a() {
        if (f35484f == null) {
            synchronized (C1346c.class) {
                try {
                    if (f35484f == null) {
                        f35484f = new C1346c();
                    }
                } finally {
                }
            }
        }
        return f35484f;
    }

    public final String b() {
        if (i.b()) {
            return "com.oplus.systemcore";
        }
        return C1344a.a();
    }

    public synchronized void c(Context context) {
        try {
            if (this.f35485a) {
                return;
            }
            this.f35485a = true;
            if (!(context instanceof Application)) {
                context = context.getApplicationContext();
            }
            this.f35486b = context;
            if (context != null && TextUtils.equals(context.getPackageName(), b())) {
                C1465b.b();
                d.e(this.f35486b);
                q8.c.e().f(this.f35486b);
            }
            this.f35487c = new C1516a(this.f35486b);
            this.f35488d = new r8.c(this.f35486b);
            this.f35489e = new C1517b(this.f35486b);
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean d() {
        return !q8.c.e().g();
    }

    public boolean e(String str, int i10) {
        return this.f35488d.h(str, i10);
    }
}
