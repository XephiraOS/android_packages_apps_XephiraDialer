package L7;

import android.content.Context;
import android.database.ContentObserver;
import android.provider.Settings;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: SuperPowerSaveMode.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f1731b;

    /* renamed from: a, reason: collision with root package name */
    public static final a f1730a = new a();

    /* renamed from: c, reason: collision with root package name */
    public static final HashSet<InterfaceC0040a> f1732c = new HashSet<>();

    /* renamed from: d, reason: collision with root package name */
    public static Context f1733d = P7.a.f2961a.a();

    /* renamed from: e, reason: collision with root package name */
    public static final b f1734e = new b();

    /* compiled from: SuperPowerSaveMode.kt */
    /* renamed from: L7.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0040a {
        void a(boolean z10);
    }

    /* compiled from: SuperPowerSaveMode.kt */
    /* loaded from: classes3.dex */
    public static final class b extends ContentObserver {
        public b() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            boolean c10 = a.c();
            synchronized (a.f1732c) {
                try {
                    Iterator it = a.f1732c.iterator();
                    while (it.hasNext()) {
                        ((InterfaceC0040a) it.next()).a(c10);
                    }
                    q qVar = q.f35511a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static final void b(InterfaceC0040a observer) {
        i.f(observer, "observer");
        HashSet<InterfaceC0040a> hashSet = f1732c;
        synchronized (hashSet) {
            try {
                if (hashSet.isEmpty()) {
                    f1730a.d();
                }
                hashSet.add(observer);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final boolean c() {
        if (Settings.System.getInt(f1733d.getContentResolver(), "super_powersave_mode_state", 0) != 1) {
            return false;
        }
        return true;
    }

    public static final void e(InterfaceC0040a observer) {
        i.f(observer, "observer");
        HashSet<InterfaceC0040a> hashSet = f1732c;
        synchronized (hashSet) {
            try {
                hashSet.remove(observer);
                if (hashSet.isEmpty()) {
                    f1730a.f();
                }
                q qVar = q.f35511a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        if (!f1731b) {
            f1733d.getContentResolver().registerContentObserver(Settings.System.getUriFor("super_powersave_mode_state"), false, f1734e);
            f1731b = true;
        }
    }

    public final void f() {
        if (f1731b) {
            f1733d.getContentResolver().unregisterContentObserver(f1734e);
            f1731b = false;
        }
    }
}
