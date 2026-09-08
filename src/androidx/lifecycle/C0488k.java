package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: LifecycleDispatcher.kt */
/* renamed from: androidx.lifecycle.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0488k {

    /* renamed from: a, reason: collision with root package name */
    public static final C0488k f10368a = new C0488k();

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f10369b = new AtomicBoolean(false);

    /* compiled from: LifecycleDispatcher.kt */
    /* renamed from: androidx.lifecycle.k$a */
    /* loaded from: classes.dex */
    public static final class a extends C0483f {
        @Override // androidx.lifecycle.C0483f, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.i.f(activity, "activity");
            B.f10233b.b(activity);
        }
    }

    public static final void a(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        if (f10369b.getAndSet(true)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.i.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new a());
    }
}
