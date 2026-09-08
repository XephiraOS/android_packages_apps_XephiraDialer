package f7;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Stack;

/* compiled from: ActivityStackManager.java */
/* renamed from: f7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1019a {

    /* renamed from: a, reason: collision with root package name */
    public final Stack<WeakReference<Activity>> f31771a = new Stack<>();

    /* renamed from: b, reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f31772b = new C0299a();

    public void c(Application application) {
        if (application != null) {
            application.registerActivityLifecycleCallbacks(this.f31772b);
        }
    }

    public final synchronized void d(Activity activity) {
        if (activity == null) {
            return;
        }
        this.f31771a.push(new WeakReference<>(activity));
    }

    public final synchronized void e(Activity activity) {
        Activity activity2;
        if (activity == null) {
            return;
        }
        for (int size = this.f31771a.size() - 1; size >= 0; size--) {
            try {
                WeakReference<Activity> weakReference = this.f31771a.get(size);
                if (weakReference != null && (activity2 = weakReference.get()) != null && activity2.getClass().getSimpleName().equals(activity.getClass().getSimpleName())) {
                    this.f31771a.remove(size);
                    break;
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: ActivityStackManager.java */
    /* renamed from: f7.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0299a implements Application.ActivityLifecycleCallbacks {
        public C0299a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            C1019a.this.d(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            C1019a.this.e(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
