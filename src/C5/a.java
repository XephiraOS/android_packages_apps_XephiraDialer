package C5;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Stack;

/* compiled from: ActivityStackManager.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final Stack<WeakReference<Activity>> f363a = new Stack<>();

    /* renamed from: b, reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f364b = new C0009a();

    public void c(Application application) {
        if (application != null) {
            application.registerActivityLifecycleCallbacks(this.f364b);
        }
    }

    public final synchronized void d(Activity activity) {
        if (activity == null) {
            return;
        }
        this.f363a.push(new WeakReference<>(activity));
    }

    public final synchronized void e(Activity activity) {
        Activity activity2;
        if (activity == null) {
            return;
        }
        for (int size = this.f363a.size() - 1; size >= 0; size--) {
            try {
                WeakReference<Activity> weakReference = this.f363a.get(size);
                if (weakReference != null && (activity2 = weakReference.get()) != null && activity2.getClass().getSimpleName().equals(activity.getClass().getSimpleName())) {
                    this.f363a.remove(size);
                    break;
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: ActivityStackManager.java */
    /* renamed from: C5.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0009a implements Application.ActivityLifecycleCallbacks {
        public C0009a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            a.this.d(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            a.this.e(activity);
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
