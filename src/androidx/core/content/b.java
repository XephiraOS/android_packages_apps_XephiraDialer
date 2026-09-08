package androidx.core.content;

import A.h;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import java.io.File;
import java.util.concurrent.Executor;

/* compiled from: ContextCompat.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f9410a = new Object();

    /* compiled from: ContextCompat.java */
    /* loaded from: classes.dex */
    public static class a {
        public static Drawable a(Context context, int i10) {
            return context.getDrawable(i10);
        }
    }

    /* compiled from: ContextCompat.java */
    /* renamed from: androidx.core.content.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0108b {
        public static int a(Context context, int i10) {
            return context.getColor(i10);
        }

        public static <T> T b(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }
    }

    /* compiled from: ContextCompat.java */
    /* loaded from: classes.dex */
    public static class c {
        public static Context a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }
    }

    /* compiled from: ContextCompat.java */
    /* loaded from: classes.dex */
    public static class d {
        public static Executor a(Context context) {
            return context.getMainExecutor();
        }
    }

    public static int a(Context context, String str) {
        I.c.c(str, "permission must be non-null");
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static Context b(Context context) {
        return c.a(context);
    }

    public static int c(Context context, int i10) {
        return C0108b.a(context, i10);
    }

    public static ColorStateList d(Context context, int i10) {
        return h.e(context.getResources(), i10, context.getTheme());
    }

    public static Drawable e(Context context, int i10) {
        return a.a(context, i10);
    }

    @Deprecated
    public static File[] f(Context context) {
        return context.getExternalCacheDirs();
    }

    @Deprecated
    public static File[] g(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    public static Executor h(Context context) {
        return d.a(context);
    }

    public static <T> T i(Context context, Class<T> cls) {
        return (T) C0108b.b(context, cls);
    }

    public static boolean j(Context context, Intent[] intentArr, Bundle bundle) {
        context.startActivities(intentArr, bundle);
        return true;
    }

    @Deprecated
    public static void k(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }
}
