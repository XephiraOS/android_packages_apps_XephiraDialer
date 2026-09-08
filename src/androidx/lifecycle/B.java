package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;

/* compiled from: ReportFragment.kt */
/* loaded from: classes.dex */
public class B extends Fragment {

    /* renamed from: b, reason: collision with root package name */
    public static final b f10233b = new b(null);

    /* renamed from: a, reason: collision with root package name */
    public a f10234a;

    /* compiled from: ReportFragment.kt */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();

        void onStart();
    }

    /* compiled from: ReportFragment.kt */
    /* loaded from: classes.dex */
    public static final class b {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Activity activity, Lifecycle.Event event) {
            kotlin.jvm.internal.i.f(activity, "activity");
            kotlin.jvm.internal.i.f(event, "event");
            if (activity instanceof r) {
                ((r) activity).getLifecycle().i(event);
            } else if (activity instanceof InterfaceC0492o) {
                Lifecycle lifecycle = ((InterfaceC0492o) activity).getLifecycle();
                if (lifecycle instanceof q) {
                    ((q) lifecycle).i(event);
                }
            }
        }

        public final void b(Activity activity) {
            kotlin.jvm.internal.i.f(activity, "activity");
            c.Companion.a(activity);
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragmentManager.beginTransaction().add(new B(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
                fragmentManager.executePendingTransactions();
            }
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: ReportFragment.kt */
    /* loaded from: classes.dex */
    public static final class c implements Application.ActivityLifecycleCallbacks {
        public static final a Companion = new a(null);

        /* compiled from: ReportFragment.kt */
        /* loaded from: classes.dex */
        public static final class a {
            public a() {
            }

            public final void a(Activity activity) {
                kotlin.jvm.internal.i.f(activity, "activity");
                activity.registerActivityLifecycleCallbacks(new c());
            }

            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        public static final void registerIn(Activity activity) {
            Companion.a(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.i.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            kotlin.jvm.internal.i.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            kotlin.jvm.internal.i.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.i.f(activity, "activity");
            B.f10233b.a(activity, Lifecycle.Event.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            kotlin.jvm.internal.i.f(activity, "activity");
            B.f10233b.a(activity, Lifecycle.Event.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            kotlin.jvm.internal.i.f(activity, "activity");
            B.f10233b.a(activity, Lifecycle.Event.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            kotlin.jvm.internal.i.f(activity, "activity");
            B.f10233b.a(activity, Lifecycle.Event.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            kotlin.jvm.internal.i.f(activity, "activity");
            B.f10233b.a(activity, Lifecycle.Event.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            kotlin.jvm.internal.i.f(activity, "activity");
            B.f10233b.a(activity, Lifecycle.Event.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            kotlin.jvm.internal.i.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.i.f(activity, "activity");
            kotlin.jvm.internal.i.f(bundle, "bundle");
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

    public static final void e(Activity activity) {
        f10233b.b(activity);
    }

    public final void b(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void c(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    public final void d(a aVar) {
        if (aVar != null) {
            aVar.onStart();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(this.f10234a);
        a(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(Lifecycle.Event.ON_DESTROY);
        this.f10234a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        c(this.f10234a);
        a(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        d(this.f10234a);
        a(Lifecycle.Event.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(Lifecycle.Event.ON_STOP);
    }

    public final void a(Lifecycle.Event event) {
    }
}
