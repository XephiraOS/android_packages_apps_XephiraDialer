package com.oplus.common.data;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.i;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: WashManager.kt */
/* loaded from: classes3.dex */
public final class WashManager {

    /* renamed from: a, reason: collision with root package name */
    public static final WashManager f27755a = new WashManager();

    /* renamed from: b, reason: collision with root package name */
    public static Application f27756b;

    /* renamed from: c, reason: collision with root package name */
    public static HashSet<a> f27757c;

    /* renamed from: d, reason: collision with root package name */
    public static final d f27758d;

    static {
        d b10;
        b10 = kotlin.a.b(new InterfaceC1637a<HashSet<a>>() { // from class: com.oplus.common.data.WashManager$dataWashList$2
            /* JADX WARN: Removed duplicated region for block: B:36:0x00c3 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:40:0x0068 A[SYNTHETIC] */
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.util.HashSet<com.oplus.common.data.a> invoke() {
                /*
                    r9 = this;
                    com.oplus.common.data.WashManager r9 = com.oplus.common.data.WashManager.f27755a
                    java.util.HashSet r0 = r9.f()
                    if (r0 != 0) goto Le8
                    java.util.HashSet r0 = new java.util.HashSet
                    r0.<init>()
                    android.app.Application r9 = r9.a()
                    r1 = 0
                    if (r9 == 0) goto L25
                    android.content.pm.PackageManager r2 = r9.getPackageManager()
                    if (r2 == 0) goto L25
                    java.lang.String r9 = r9.getPackageName()
                    r3 = 128(0x80, float:1.794E-43)
                    android.content.pm.ApplicationInfo r9 = r2.getApplicationInfo(r9, r3)
                    goto L26
                L25:
                    r9 = r1
                L26:
                    java.lang.String r2 = "WashManager"
                    if (r9 == 0) goto Lc7
                    android.os.Bundle r9 = r9.metaData
                    if (r9 == 0) goto Lc7
                    java.lang.String r3 = "metaData"
                    kotlin.jvm.internal.i.e(r9, r3)
                    java.util.Set r3 = r9.keySet()
                    java.lang.String r4 = "it.keySet()"
                    kotlin.jvm.internal.i.e(r3, r4)
                    java.util.ArrayList r4 = new java.util.ArrayList
                    r4.<init>()
                    java.util.Iterator r3 = r3.iterator()
                L45:
                    boolean r5 = r3.hasNext()
                    if (r5 == 0) goto L64
                    java.lang.Object r5 = r3.next()
                    r6 = r5
                    java.lang.String r6 = (java.lang.String) r6
                    java.lang.Object r6 = r9.get(r6)
                    if (r6 == 0) goto L45
                    java.lang.String r7 = "DataWashClass"
                    boolean r6 = r6.equals(r7)
                    if (r6 == 0) goto L45
                    r4.add(r5)
                    goto L45
                L64:
                    java.util.Iterator r9 = r4.iterator()
                L68:
                    boolean r3 = r9.hasNext()
                    if (r3 == 0) goto Lc7
                    java.lang.Object r3 = r9.next()
                    java.lang.String r3 = (java.lang.String) r3
                    android.util.Log.d(r2, r3)
                    java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Throwable -> L86
                    java.lang.Object r3 = r3.newInstance()     // Catch: java.lang.Throwable -> L86
                    boolean r4 = r3 instanceof com.oplus.common.data.a     // Catch: java.lang.Throwable -> L86
                    if (r4 == 0) goto Lc0
                    com.oplus.common.data.a r3 = (com.oplus.common.data.a) r3     // Catch: java.lang.Throwable -> L86
                    goto Lc1
                L86:
                    r3 = move-exception
                    java.lang.StackTraceElement[] r4 = r3.getStackTrace()
                    r5 = 0
                    r4 = r4[r5]
                    int r5 = r4.getLineNumber()
                    java.lang.String r6 = r4.getMethodName()
                    java.lang.String r4 = r4.getClassName()
                    java.lang.String r3 = r3.getMessage()
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>()
                    java.lang.String r8 = "line:"
                    r7.append(r8)
                    r7.append(r5)
                    java.lang.String r5 = " "
                    r7.append(r5)
                    r7.append(r6)
                    r7.append(r5)
                    r7.append(r3)
                    java.lang.String r3 = r7.toString()
                    android.util.Log.e(r4, r3)
                Lc0:
                    r3 = r1
                Lc1:
                    if (r3 == 0) goto L68
                    r0.add(r3)
                    goto L68
                Lc7:
                    com.oplus.common.data.WashManager r9 = com.oplus.common.data.WashManager.f27755a
                    android.app.Application r9 = r9.a()
                    int r1 = r0.size()
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    r3.append(r9)
                    java.lang.String r9 = ", DataWashClass size is "
                    r3.append(r9)
                    r3.append(r1)
                    java.lang.String r9 = r3.toString()
                    android.util.Log.d(r2, r9)
                Le8:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.common.data.WashManager$dataWashList$2.invoke():java.util.HashSet");
            }
        });
        f27758d = b10;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> T d(android.content.SharedPreferences r5, java.lang.String r6, T r7, v9.InterfaceC1637a<? extends T> r8) {
        /*
            java.lang.String r0 = "prefs"
            kotlin.jvm.internal.i.f(r5, r0)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.i.f(r6, r0)
            java.lang.String r0 = "function"
            kotlin.jvm.internal.i.f(r8, r0)
            r0 = 0
            boolean r5 = r5.contains(r6)     // Catch: java.lang.Throwable -> L1b
            if (r5 == 0) goto L55
            java.lang.Object r5 = r8.invoke()     // Catch: java.lang.Throwable -> L1b
            goto L56
        L1b:
            r5 = move-exception
            java.lang.StackTraceElement[] r8 = r5.getStackTrace()
            r1 = 0
            r8 = r8[r1]
            int r1 = r8.getLineNumber()
            java.lang.String r2 = r8.getMethodName()
            java.lang.String r8 = r8.getClassName()
            java.lang.String r5 = r5.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "line:"
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " "
            r3.append(r1)
            r3.append(r2)
            r3.append(r1)
            r3.append(r5)
            java.lang.String r5 = r3.toString()
            android.util.Log.e(r8, r5)
        L55:
            r5 = r0
        L56:
            if (r5 != 0) goto L67
            com.oplus.common.data.WashManager r5 = com.oplus.common.data.WashManager.f27755a
            java.lang.Object r5 = r5.c(r6)
            if (r5 != 0) goto L61
            goto L62
        L61:
            r0 = r5
        L62:
            if (r0 != 0) goto L65
            goto L68
        L65:
            r7 = r0
            goto L68
        L67:
            r7 = r5
        L68:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.common.data.WashManager.d(android.content.SharedPreferences, java.lang.String, java.lang.Object, v9.a):java.lang.Object");
    }

    public static final <T> T e(String key, T t10, InterfaceC1637a<? extends T> function) {
        T t11;
        i.f(key, "key");
        i.f(function, "function");
        Object obj = null;
        try {
            t11 = function.invoke();
        } catch (Throwable th) {
            StackTraceElement stackTraceElement = th.getStackTrace()[0];
            int lineNumber = stackTraceElement.getLineNumber();
            String methodName = stackTraceElement.getMethodName();
            Log.e(stackTraceElement.getClassName(), "line:" + lineNumber + " " + methodName + " " + th.getMessage());
            t11 = null;
        }
        if (t11 == null) {
            Object c10 = f27755a.c(key);
            if (c10 != null) {
                obj = c10;
            }
            if (obj != null) {
                return (T) obj;
            }
            return t10;
        }
        return t11;
    }

    public static final void h(SQLiteDatabase db, Context context) {
        i.f(db, "db");
        i.f(context, "context");
        Iterator<T> it = f27755a.b().iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(db, context);
        }
    }

    public final Application a() {
        return f27756b;
    }

    public final HashSet<a> b() {
        return (HashSet) f27758d.getValue();
    }

    public final Object c(String str) {
        Object obj;
        Iterator<T> it = b().iterator();
        do {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            try {
                obj = ((a) it.next()).a(str);
            } catch (Throwable th) {
                StackTraceElement stackTraceElement = th.getStackTrace()[0];
                int lineNumber = stackTraceElement.getLineNumber();
                String methodName = stackTraceElement.getMethodName();
                Log.e(stackTraceElement.getClassName(), "line:" + lineNumber + " " + methodName + " " + th.getMessage());
            }
        } while (obj == null);
        return obj;
    }

    public final HashSet<a> f() {
        return f27757c;
    }

    public final void g(Application application) {
        f27756b = application;
    }
}
