package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: VolleyLog.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static String f19251a = "Volley";

    /* renamed from: b, reason: collision with root package name */
    public static boolean f19252b = Log.isLoggable("Volley", 2);

    /* renamed from: c, reason: collision with root package name */
    public static final String f19253c = e.class.getName();

    /* compiled from: VolleyLog.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: c, reason: collision with root package name */
        public static final boolean f19254c = e.f19252b;

        /* renamed from: a, reason: collision with root package name */
        public final List<C0187a> f19255a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public boolean f19256b = false;

        /* compiled from: VolleyLog.java */
        /* renamed from: com.android.volley.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0187a {

            /* renamed from: a, reason: collision with root package name */
            public final String f19257a;

            /* renamed from: b, reason: collision with root package name */
            public final long f19258b;

            /* renamed from: c, reason: collision with root package name */
            public final long f19259c;

            public C0187a(String str, long j10, long j11) {
                this.f19257a = str;
                this.f19258b = j10;
                this.f19259c = j11;
            }
        }

        public synchronized void a(String str, long j10) {
            if (!this.f19256b) {
                this.f19255a.add(new C0187a(str, j10, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public synchronized void b(String str) {
            this.f19256b = true;
            long c10 = c();
            if (c10 <= 0) {
                return;
            }
            long j10 = this.f19255a.get(0).f19259c;
            e.b("(%-4d ms) %s", Long.valueOf(c10), str);
            for (C0187a c0187a : this.f19255a) {
                long j11 = c0187a.f19259c;
                e.b("(+%-4d) [%2d] %s", Long.valueOf(j11 - j10), Long.valueOf(c0187a.f19258b), c0187a.f19257a);
                j10 = j11;
            }
        }

        public final long c() {
            if (this.f19255a.size() == 0) {
                return 0L;
            }
            return this.f19255a.get(r4.size() - 1).f19259c - this.f19255a.get(0).f19259c;
        }

        public void finalize() {
            if (!this.f19256b) {
                b("Request on the loose");
                e.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    public static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i10 = 2;
        while (true) {
            if (i10 < stackTrace.length) {
                if (!stackTrace[i10].getClassName().equals(f19253c)) {
                    String className = stackTrace[i10].getClassName();
                    String substring = className.substring(className.lastIndexOf(46) + 1);
                    str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i10].getMethodName();
                    break;
                }
                i10++;
            } else {
                str2 = "<unknown>";
                break;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void b(String str, Object... objArr) {
        Log.d(f19251a, a(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f19251a, a(str, objArr));
    }

    public static void d(Throwable th, String str, Object... objArr) {
        Log.e(f19251a, a(str, objArr), th);
    }

    public static void e(String str, Object... objArr) {
        if (f19252b) {
            Log.v(f19251a, a(str, objArr));
        }
    }
}
