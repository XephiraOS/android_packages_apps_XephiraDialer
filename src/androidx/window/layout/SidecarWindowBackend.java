package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import androidx.window.core.Version;
import androidx.window.layout.ExtensionInterfaceCompat;
import androidx.window.layout.SidecarWindowBackend;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.o;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: SidecarWindowBackend.kt */
/* loaded from: classes.dex */
public final class SidecarWindowBackend implements WindowBackend {

    /* renamed from: d, reason: collision with root package name */
    public static volatile SidecarWindowBackend f12050d;

    /* renamed from: a, reason: collision with root package name */
    public ExtensionInterfaceCompat f12052a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> f12053b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public static final Companion f12049c = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    public static final ReentrantLock f12051e = new ReentrantLock();

    /* compiled from: SidecarWindowBackend.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final SidecarWindowBackend a(Context context) {
            i.f(context, "context");
            if (SidecarWindowBackend.f12050d == null) {
                ReentrantLock reentrantLock = SidecarWindowBackend.f12051e;
                reentrantLock.lock();
                try {
                    if (SidecarWindowBackend.f12050d == null) {
                        SidecarWindowBackend.f12050d = new SidecarWindowBackend(SidecarWindowBackend.f12049c.b(context));
                    }
                    q qVar = q.f35511a;
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            SidecarWindowBackend sidecarWindowBackend = SidecarWindowBackend.f12050d;
            i.c(sidecarWindowBackend);
            return sidecarWindowBackend;
        }

        public final ExtensionInterfaceCompat b(Context context) {
            i.f(context, "context");
            try {
                if (!c(SidecarCompat.f12030f.c())) {
                    return null;
                }
                SidecarCompat sidecarCompat = new SidecarCompat(context);
                if (!sidecarCompat.l()) {
                    return null;
                }
                return sidecarCompat;
            } catch (Throwable unused) {
                return null;
            }
        }

        public final boolean c(Version version) {
            if (version == null || version.compareTo(Version.f11924f.a()) < 0) {
                return false;
            }
            return true;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* compiled from: SidecarWindowBackend.kt */
    /* loaded from: classes.dex */
    public final class ExtensionListenerImpl implements ExtensionInterfaceCompat.ExtensionCallbackInterface {
        public ExtensionListenerImpl() {
        }

        @Override // androidx.window.layout.ExtensionInterfaceCompat.ExtensionCallbackInterface
        public void a(Activity activity, WindowLayoutInfo newLayout) {
            i.f(activity, "activity");
            i.f(newLayout, "newLayout");
            Iterator<WindowLayoutChangeCallbackWrapper> it = SidecarWindowBackend.this.g().iterator();
            while (it.hasNext()) {
                WindowLayoutChangeCallbackWrapper next = it.next();
                if (i.b(next.d(), activity)) {
                    next.b(newLayout);
                }
            }
        }
    }

    /* compiled from: SidecarWindowBackend.kt */
    /* loaded from: classes.dex */
    public static final class WindowLayoutChangeCallbackWrapper {

        /* renamed from: a, reason: collision with root package name */
        public final Activity f12055a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f12056b;

        /* renamed from: c, reason: collision with root package name */
        public final I.a<WindowLayoutInfo> f12057c;

        /* renamed from: d, reason: collision with root package name */
        public WindowLayoutInfo f12058d;

        public WindowLayoutChangeCallbackWrapper(Activity activity, Executor executor, I.a<WindowLayoutInfo> callback) {
            i.f(activity, "activity");
            i.f(executor, "executor");
            i.f(callback, "callback");
            this.f12055a = activity;
            this.f12056b = executor;
            this.f12057c = callback;
        }

        public static final void c(WindowLayoutChangeCallbackWrapper this$0, WindowLayoutInfo newLayoutInfo) {
            i.f(this$0, "this$0");
            i.f(newLayoutInfo, "$newLayoutInfo");
            this$0.f12057c.accept(newLayoutInfo);
        }

        public final void b(final WindowLayoutInfo newLayoutInfo) {
            i.f(newLayoutInfo, "newLayoutInfo");
            this.f12058d = newLayoutInfo;
            this.f12056b.execute(new Runnable() { // from class: androidx.window.layout.a
                @Override // java.lang.Runnable
                public final void run() {
                    SidecarWindowBackend.WindowLayoutChangeCallbackWrapper.c(SidecarWindowBackend.WindowLayoutChangeCallbackWrapper.this, newLayoutInfo);
                }
            });
        }

        public final Activity d() {
            return this.f12055a;
        }

        public final I.a<WindowLayoutInfo> e() {
            return this.f12057c;
        }

        public final WindowLayoutInfo f() {
            return this.f12058d;
        }
    }

    public SidecarWindowBackend(ExtensionInterfaceCompat extensionInterfaceCompat) {
        this.f12052a = extensionInterfaceCompat;
        ExtensionInterfaceCompat extensionInterfaceCompat2 = this.f12052a;
        if (extensionInterfaceCompat2 != null) {
            extensionInterfaceCompat2.b(new ExtensionListenerImpl());
        }
    }

    @Override // androidx.window.layout.WindowBackend
    public void a(I.a<WindowLayoutInfo> callback) {
        i.f(callback, "callback");
        synchronized (f12051e) {
            try {
                if (this.f12052a == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<WindowLayoutChangeCallbackWrapper> it = this.f12053b.iterator();
                while (it.hasNext()) {
                    WindowLayoutChangeCallbackWrapper callbackWrapper = it.next();
                    if (callbackWrapper.e() == callback) {
                        i.e(callbackWrapper, "callbackWrapper");
                        arrayList.add(callbackWrapper);
                    }
                }
                this.f12053b.removeAll(arrayList);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    f(((WindowLayoutChangeCallbackWrapper) it2.next()).d());
                }
                q qVar = q.f35511a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.window.layout.WindowBackend
    public void b(Activity activity, Executor executor, I.a<WindowLayoutInfo> callback) {
        WindowLayoutInfo windowLayoutInfo;
        Object obj;
        List h10;
        i.f(activity, "activity");
        i.f(executor, "executor");
        i.f(callback, "callback");
        ReentrantLock reentrantLock = f12051e;
        reentrantLock.lock();
        try {
            ExtensionInterfaceCompat extensionInterfaceCompat = this.f12052a;
            if (extensionInterfaceCompat == null) {
                h10 = o.h();
                callback.accept(new WindowLayoutInfo(h10));
                return;
            }
            boolean h11 = h(activity);
            WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper = new WindowLayoutChangeCallbackWrapper(activity, executor, callback);
            this.f12053b.add(windowLayoutChangeCallbackWrapper);
            if (!h11) {
                extensionInterfaceCompat.a(activity);
            } else {
                Iterator<T> it = this.f12053b.iterator();
                while (true) {
                    windowLayoutInfo = null;
                    if (it.hasNext()) {
                        obj = it.next();
                        if (i.b(activity, ((WindowLayoutChangeCallbackWrapper) obj).d())) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper2 = (WindowLayoutChangeCallbackWrapper) obj;
                if (windowLayoutChangeCallbackWrapper2 != null) {
                    windowLayoutInfo = windowLayoutChangeCallbackWrapper2.f();
                }
                if (windowLayoutInfo != null) {
                    windowLayoutChangeCallbackWrapper.b(windowLayoutInfo);
                }
            }
            q qVar = q.f35511a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void f(Activity activity) {
        CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> copyOnWriteArrayList = this.f12053b;
        if (!(copyOnWriteArrayList instanceof Collection) || !copyOnWriteArrayList.isEmpty()) {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (i.b(((WindowLayoutChangeCallbackWrapper) it.next()).d(), activity)) {
                    return;
                }
            }
        }
        ExtensionInterfaceCompat extensionInterfaceCompat = this.f12052a;
        if (extensionInterfaceCompat != null) {
            extensionInterfaceCompat.c(activity);
        }
    }

    public final CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> g() {
        return this.f12053b;
    }

    public final boolean h(Activity activity) {
        CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> copyOnWriteArrayList = this.f12053b;
        if ((copyOnWriteArrayList instanceof Collection) && copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (i.b(((WindowLayoutChangeCallbackWrapper) it.next()).d(), activity)) {
                return true;
            }
        }
        return false;
    }
}
