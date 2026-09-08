package com.android.contacts.util;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import java.lang.Thread;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.E;

/* compiled from: CrashHandler.kt */
/* loaded from: classes.dex */
public final class m implements Thread.UncaughtExceptionHandler {

    /* renamed from: b, reason: collision with root package name */
    public static final a f17578b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f17579a = Thread.getDefaultUncaughtExceptionHandler();

    /* compiled from: CrashHandler.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final void a(Context context, String stackTrace) {
            Map f10;
            kotlin.jvm.internal.i.f(stackTrace, "stackTrace");
            Pair a10 = m9.g.a("version_flavor", "oppoStoreGdprAall");
            Pair a11 = m9.g.a("version_code", 160000000);
            Pair a12 = m9.g.a("version_name", "16.0.0");
            String substring = stackTrace.substring(0, Math.min(stackTrace.length(), 4000));
            kotlin.jvm.internal.i.e(substring, "substring(...)");
            f10 = E.f(a10, a11, a12, m9.g.a("stack_trace", substring));
            com.android.contacts.framework.baseui.util.A.a(context, 2000302, 200031213, f10, false);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public static final void a(Context context, String str) {
        f17578b.a(context, str);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable throwable) {
        kotlin.jvm.internal.i.f(thread, "thread");
        kotlin.jvm.internal.i.f(throwable, "throwable");
        String str = "uncaughtException: thread:" + thread.getName() + " throwable: \n " + Log.getStackTraceString(throwable);
        H7.b.c("CrashHandler", str);
        if (kotlin.jvm.internal.i.b(Looper.myLooper(), Looper.getMainLooper())) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f17579a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, throwable);
                return;
            }
            return;
        }
        f17578b.a(P7.a.f2961a.a(), str);
    }
}
