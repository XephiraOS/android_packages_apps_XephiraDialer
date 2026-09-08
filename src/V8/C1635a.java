package v8;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: AppLifecycleCallbacks.java */
/* renamed from: v8.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1635a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public int f37495a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f37496b;

    /* compiled from: AppLifecycleCallbacks.java */
    /* renamed from: v8.a$b */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final C1635a f37497a = new C1635a();
    }

    public static C1635a a() {
        return b.f37497a;
    }

    public synchronized void b(Application application) {
        if (!this.f37496b) {
            application.registerActivityLifecycleCallbacks(this);
            this.f37496b = true;
        }
    }

    public final boolean c() {
        if (this.f37495a == 1) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        if (this.f37495a == 0) {
            return true;
        }
        return false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (c()) {
            l.e().i(activity.getApplicationContext());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.f37495a++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.f37495a--;
        if (d()) {
            l.e().g(activity.getApplicationContext());
        }
    }

    public C1635a() {
        this.f37495a = 0;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
