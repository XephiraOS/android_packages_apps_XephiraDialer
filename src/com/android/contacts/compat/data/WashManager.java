package com.android.contacts.compat.data;

import android.app.Application;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Result;
import kotlin.jvm.internal.i;
import v9.InterfaceC1637a;

/* compiled from: WashManager.kt */
/* loaded from: classes.dex */
public final class WashManager {

    /* renamed from: a, reason: collision with root package name */
    public static final WashManager f14100a = new WashManager();

    /* renamed from: b, reason: collision with root package name */
    public static Application f14101b;

    /* renamed from: c, reason: collision with root package name */
    public static HashSet<a> f14102c;

    /* renamed from: d, reason: collision with root package name */
    public static final m9.d f14103d;

    static {
        m9.d b10;
        b10 = kotlin.a.b(new InterfaceC1637a<HashSet<a>>() { // from class: com.android.contacts.compat.data.WashManager$dataWashList$2
            /* JADX WARN: Removed duplicated region for block: B:36:0x00d5 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:40:0x0068 A[SYNTHETIC] */
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.util.HashSet<com.android.contacts.compat.data.a> invoke() {
                /*
                    r9 = this;
                    com.android.contacts.compat.data.WashManager r9 = com.android.contacts.compat.data.WashManager.f14100a
                    java.util.HashSet r0 = r9.f()
                    if (r0 != 0) goto Lfa
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
                    if (r9 == 0) goto Ld9
                    android.os.Bundle r9 = r9.metaData
                    if (r9 == 0) goto Ld9
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
                    if (r3 == 0) goto Ld9
                    java.lang.Object r3 = r9.next()
                    java.lang.String r3 = (java.lang.String) r3
                    H7.b.b(r2, r3)
                    kotlin.Result$a r4 = kotlin.Result.f34166a     // Catch: java.lang.Throwable -> L88
                    java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Throwable -> L88
                    java.lang.Object r3 = r3.newInstance()     // Catch: java.lang.Throwable -> L88
                    boolean r4 = r3 instanceof com.android.contacts.compat.data.a     // Catch: java.lang.Throwable -> L88
                    if (r4 == 0) goto Ld2
                    com.android.contacts.compat.data.a r3 = (com.android.contacts.compat.data.a) r3     // Catch: java.lang.Throwable -> L88
                    goto Ld3
                L88:
                    r3 = move-exception
                    kotlin.Result$a r4 = kotlin.Result.f34166a
                    java.lang.Object r3 = kotlin.b.a(r3)
                    java.lang.Object r3 = kotlin.Result.b(r3)
                    java.lang.Throwable r3 = kotlin.Result.d(r3)
                    if (r3 == 0) goto Ld2
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
                    H7.b.c(r4, r3)
                Ld2:
                    r3 = r1
                Ld3:
                    if (r3 == 0) goto L68
                    r0.add(r3)
                    goto L68
                Ld9:
                    com.android.contacts.compat.data.WashManager r9 = com.android.contacts.compat.data.WashManager.f14100a
                    android.app.Application r9 = r9.a()
                    int r1 = r0.size()
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    r3.append(r9)
                    java.lang.String r9 = ", DataWashClass size is "
                    r3.append(r9)
                    r3.append(r1)
                    java.lang.String r9 = r3.toString()
                    H7.b.b(r2, r9)
                Lfa:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.compat.data.WashManager$dataWashList$2.invoke():java.util.HashSet");
            }
        });
        f14103d = b10;
    }

    public static final String b(String key) {
        String str;
        i.f(key, "key");
        for (a aVar : f14100a.c()) {
            try {
                Result.a aVar2 = Result.f34166a;
                str = aVar.c(key);
            } catch (Throwable th) {
                Result.a aVar3 = Result.f34166a;
                Throwable d10 = Result.d(Result.b(kotlin.b.a(th)));
                if (d10 != null) {
                    StackTraceElement stackTraceElement = d10.getStackTrace()[0];
                    int lineNumber = stackTraceElement.getLineNumber();
                    String methodName = stackTraceElement.getMethodName();
                    H7.b.c(stackTraceElement.getClassName(), "line:" + lineNumber + " " + methodName + " " + d10.getMessage());
                }
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        return key;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> T e(android.content.SharedPreferences r5, java.lang.String r6, T r7, v9.InterfaceC1637a<? extends T> r8) {
        /*
            java.lang.String r0 = "prefs"
            kotlin.jvm.internal.i.f(r5, r0)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.i.f(r6, r0)
            java.lang.String r0 = "function"
            kotlin.jvm.internal.i.f(r8, r0)
            r0 = 0
            kotlin.Result$a r1 = kotlin.Result.f34166a     // Catch: java.lang.Throwable -> L1d
            boolean r5 = r5.contains(r6)     // Catch: java.lang.Throwable -> L1d
            if (r5 == 0) goto L67
            java.lang.Object r5 = r8.invoke()     // Catch: java.lang.Throwable -> L1d
            goto L68
        L1d:
            r5 = move-exception
            kotlin.Result$a r8 = kotlin.Result.f34166a
            java.lang.Object r5 = kotlin.b.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
            java.lang.Throwable r5 = kotlin.Result.d(r5)
            if (r5 == 0) goto L67
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
            H7.b.c(r8, r5)
        L67:
            r5 = r0
        L68:
            if (r5 != 0) goto L79
            com.android.contacts.compat.data.WashManager r5 = com.android.contacts.compat.data.WashManager.f14100a
            java.lang.Object r5 = r5.d(r6)
            if (r5 != 0) goto L73
            goto L74
        L73:
            r0 = r5
        L74:
            if (r0 != 0) goto L77
            goto L7a
        L77:
            r7 = r0
            goto L7a
        L79:
            r7 = r5
        L7a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.compat.data.WashManager.e(android.content.SharedPreferences, java.lang.String, java.lang.Object, v9.a):java.lang.Object");
    }

    public static final String g(String oldString) {
        i.f(oldString, "oldString");
        Iterator<T> it = f14100a.c().iterator();
        while (it.hasNext()) {
            oldString = ((a) it.next()).b(oldString);
        }
        return oldString;
    }

    public final Application a() {
        return f14101b;
    }

    public final HashSet<a> c() {
        return (HashSet) f14103d.getValue();
    }

    public final Object d(String key) {
        Object obj;
        i.f(key, "key");
        Iterator<T> it = c().iterator();
        do {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            a aVar = (a) it.next();
            try {
                Result.a aVar2 = Result.f34166a;
                obj = aVar.a(key);
            } catch (Throwable th) {
                Result.a aVar3 = Result.f34166a;
                Throwable d10 = Result.d(Result.b(kotlin.b.a(th)));
                if (d10 != null) {
                    StackTraceElement stackTraceElement = d10.getStackTrace()[0];
                    int lineNumber = stackTraceElement.getLineNumber();
                    String methodName = stackTraceElement.getMethodName();
                    H7.b.c(stackTraceElement.getClassName(), "line:" + lineNumber + " " + methodName + " " + d10.getMessage());
                }
            }
        } while (obj == null);
        return obj;
    }

    public final HashSet<a> f() {
        return f14102c;
    }

    public final void h(Application application) {
        f14101b = application;
    }
}
