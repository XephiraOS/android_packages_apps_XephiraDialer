package com.oplus.systembarlib;

import android.util.Log;
import kotlin.collections.C1229j;

/* compiled from: SystemBarLog.kt */
/* loaded from: classes3.dex */
public final class SystemBarLog {

    /* renamed from: a, reason: collision with root package name */
    public static final SystemBarLog f29001a = new SystemBarLog();

    /* renamed from: b, reason: collision with root package name */
    public static LogEnum f29002b = LogEnum.f29004b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: SystemBarLog.kt */
    /* loaded from: classes3.dex */
    public static final class LogEnum implements a {

        /* renamed from: a, reason: collision with root package name */
        public static final LogEnum f29003a = new Debug("Debug", 0);

        /* renamed from: b, reason: collision with root package name */
        public static final LogEnum f29004b = new Release("Release", 1);

        /* renamed from: c, reason: collision with root package name */
        public static final LogEnum f29005c = new LogEnum("LogNone", 2);

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ LogEnum[] f29006d = a();

        /* compiled from: SystemBarLog.kt */
        /* loaded from: classes3.dex */
        public static final class Debug extends LogEnum {
            public Debug(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.oplus.systembarlib.SystemBarLog.LogEnum
            public void b(String str, String str2, Throwable th) {
                Log.d(str, kotlin.jvm.internal.i.l(str2, SystemBarLog.f29001a.d(th)));
            }

            @Override // com.oplus.systembarlib.SystemBarLog.LogEnum
            public void c(String str, String str2, Throwable th) {
                Log.w(str, kotlin.jvm.internal.i.l(str2, SystemBarLog.f29001a.d(th)));
            }
        }

        /* compiled from: SystemBarLog.kt */
        /* loaded from: classes3.dex */
        public static final class Release extends LogEnum {
            public Release(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.oplus.systembarlib.SystemBarLog.LogEnum
            public void c(String str, String str2, Throwable th) {
                Log.w(str, kotlin.jvm.internal.i.l(str2, SystemBarLog.f29001a.d(th)));
            }
        }

        public /* synthetic */ LogEnum(String str, int i10, kotlin.jvm.internal.f fVar) {
            this(str, i10);
        }

        public static final /* synthetic */ LogEnum[] a() {
            return new LogEnum[]{f29003a, f29004b, f29005c};
        }

        public static LogEnum valueOf(String str) {
            return (LogEnum) Enum.valueOf(LogEnum.class, str);
        }

        public static LogEnum[] values() {
            return (LogEnum[]) f29006d.clone();
        }

        public void b(String str, String str2, Throwable th) {
            a.C0280a.a(this, str, str2, th);
        }

        public void c(String str, String str2, Throwable th) {
            a.C0280a.b(this, str, str2, th);
        }

        public LogEnum(String str, int i10) {
        }
    }

    /* compiled from: SystemBarLog.kt */
    /* loaded from: classes3.dex */
    public interface a {

        /* compiled from: SystemBarLog.kt */
        /* renamed from: com.oplus.systembarlib.SystemBarLog$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0280a {
            public static void a(a aVar, String str, String str2, Throwable th) {
                kotlin.jvm.internal.i.f(aVar, "this");
            }

            public static void b(a aVar, String str, String str2, Throwable th) {
                kotlin.jvm.internal.i.f(aVar, "this");
            }
        }
    }

    public static final void b(String str, String str2) {
        c(str, str2, null);
    }

    public static final void c(String str, String str2, Throwable th) {
        f29002b.b(str, str2, th);
    }

    public static final void e(String str, String str2) {
        f(str, str2, null);
    }

    public static final void f(String str, String str2, Throwable th) {
        f29002b.c(str, str2, th);
    }

    public final String d(Throwable th) {
        Object A10;
        if (th == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) th.getMessage());
        sb.append(' ');
        StackTraceElement[] stackTrace = th.getStackTrace();
        kotlin.jvm.internal.i.e(stackTrace, "it.stackTrace");
        A10 = C1229j.A(stackTrace, 0);
        sb.append(A10);
        String sb2 = sb.toString();
        if (sb2 == null) {
            return "";
        }
        return sb2;
    }
}
