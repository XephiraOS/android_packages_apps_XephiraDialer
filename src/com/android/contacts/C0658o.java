package com.android.contacts;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: ContactsActivityManager.kt */
/* renamed from: com.android.contacts.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0658o {

    /* renamed from: a, reason: collision with root package name */
    public final List<Activity> f17045a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final a f17046b = new a();

    /* compiled from: ContactsActivityManager.kt */
    /* renamed from: com.android.contacts.o$a */
    /* loaded from: classes.dex */
    public static final class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.i.f(activity, "activity");
            C0658o.this.b().add(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            kotlin.jvm.internal.i.f(activity, "activity");
            C0658o.this.b().remove(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            kotlin.jvm.internal.i.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            kotlin.jvm.internal.i.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            kotlin.jvm.internal.i.f(activity, "activity");
            kotlin.jvm.internal.i.f(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            kotlin.jvm.internal.i.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            kotlin.jvm.internal.i.f(activity, "activity");
        }
    }

    public final void a() {
        List<Activity> M10;
        M10 = CollectionsKt___CollectionsKt.M(this.f17045a);
        for (Activity activity : M10) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    public final List<Activity> b() {
        return this.f17045a;
    }

    public final void c(Application application) {
        kotlin.jvm.internal.i.f(application, "application");
        application.registerActivityLifecycleCallbacks(this.f17046b);
    }
}
