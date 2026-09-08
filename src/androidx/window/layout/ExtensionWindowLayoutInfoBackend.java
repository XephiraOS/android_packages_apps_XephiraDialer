package androidx.window.layout;

import android.app.Activity;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.layout.ExtensionWindowLayoutInfoBackend;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.k;
import m9.q;
import v9.l;

/* compiled from: ExtensionWindowLayoutInfoBackend.kt */
/* loaded from: classes.dex */
public final class ExtensionWindowLayoutInfoBackend implements WindowBackend {

    /* renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f11990a;

    /* renamed from: b, reason: collision with root package name */
    public final ConsumerAdapter f11991b;

    /* renamed from: c, reason: collision with root package name */
    public final ReentrantLock f11992c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<Activity, MulticastConsumer> f11993d;

    /* renamed from: e, reason: collision with root package name */
    public final Map<I.a<WindowLayoutInfo>, Activity> f11994e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<MulticastConsumer, ConsumerAdapter.Subscription> f11995f;

    /* compiled from: ExtensionWindowLayoutInfoBackend.kt */
    /* loaded from: classes.dex */
    public static final class MulticastConsumer implements I.a<androidx.window.extensions.layout.WindowLayoutInfo> {

        /* renamed from: a, reason: collision with root package name */
        public final Activity f11996a;

        /* renamed from: b, reason: collision with root package name */
        public final ReentrantLock f11997b;

        /* renamed from: c, reason: collision with root package name */
        public WindowLayoutInfo f11998c;

        /* renamed from: d, reason: collision with root package name */
        public final Set<I.a<WindowLayoutInfo>> f11999d;

        public MulticastConsumer(Activity activity) {
            i.f(activity, "activity");
            this.f11996a = activity;
            this.f11997b = new ReentrantLock();
            this.f11999d = new LinkedHashSet();
        }

        @Override // I.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(androidx.window.extensions.layout.WindowLayoutInfo value) {
            i.f(value, "value");
            ReentrantLock reentrantLock = this.f11997b;
            reentrantLock.lock();
            try {
                this.f11998c = ExtensionsWindowLayoutInfoAdapter.f12000a.b(this.f11996a, value);
                Iterator<T> it = this.f11999d.iterator();
                while (it.hasNext()) {
                    ((I.a) it.next()).accept(this.f11998c);
                }
                q qVar = q.f35511a;
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        public final void b(I.a<WindowLayoutInfo> listener) {
            i.f(listener, "listener");
            ReentrantLock reentrantLock = this.f11997b;
            reentrantLock.lock();
            try {
                WindowLayoutInfo windowLayoutInfo = this.f11998c;
                if (windowLayoutInfo != null) {
                    listener.accept(windowLayoutInfo);
                }
                this.f11999d.add(listener);
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        public final boolean c() {
            return this.f11999d.isEmpty();
        }

        public final void d(I.a<WindowLayoutInfo> listener) {
            i.f(listener, "listener");
            ReentrantLock reentrantLock = this.f11997b;
            reentrantLock.lock();
            try {
                this.f11999d.remove(listener);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public ExtensionWindowLayoutInfoBackend(WindowLayoutComponent component, ConsumerAdapter consumerAdapter) {
        i.f(component, "component");
        i.f(consumerAdapter, "consumerAdapter");
        this.f11990a = component;
        this.f11991b = consumerAdapter;
        this.f11992c = new ReentrantLock();
        this.f11993d = new LinkedHashMap();
        this.f11994e = new LinkedHashMap();
        this.f11995f = new LinkedHashMap();
    }

    @Override // androidx.window.layout.WindowBackend
    public void a(I.a<WindowLayoutInfo> callback) {
        i.f(callback, "callback");
        ReentrantLock reentrantLock = this.f11992c;
        reentrantLock.lock();
        try {
            Activity activity = this.f11994e.get(callback);
            if (activity == null) {
                reentrantLock.unlock();
                return;
            }
            MulticastConsumer multicastConsumer = this.f11993d.get(activity);
            if (multicastConsumer == null) {
                reentrantLock.unlock();
                return;
            }
            multicastConsumer.d(callback);
            if (multicastConsumer.c()) {
                ConsumerAdapter.Subscription remove = this.f11995f.remove(multicastConsumer);
                if (remove != null) {
                    remove.b();
                }
                this.f11994e.remove(callback);
                this.f11993d.remove(activity);
            }
            q qVar = q.f35511a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // androidx.window.layout.WindowBackend
    public void b(Activity activity, Executor executor, I.a<WindowLayoutInfo> callback) {
        q qVar;
        i.f(activity, "activity");
        i.f(executor, "executor");
        i.f(callback, "callback");
        ReentrantLock reentrantLock = this.f11992c;
        reentrantLock.lock();
        try {
            MulticastConsumer multicastConsumer = this.f11993d.get(activity);
            if (multicastConsumer != null) {
                multicastConsumer.b(callback);
                this.f11994e.put(callback, activity);
                qVar = q.f35511a;
            } else {
                qVar = null;
            }
            if (qVar == null) {
                final MulticastConsumer multicastConsumer2 = new MulticastConsumer(activity);
                this.f11993d.put(activity, multicastConsumer2);
                this.f11994e.put(callback, activity);
                multicastConsumer2.b(callback);
                this.f11995f.put(multicastConsumer2, this.f11991b.d(this.f11990a, k.b(androidx.window.extensions.layout.WindowLayoutInfo.class), "addWindowLayoutInfoListener", "removeWindowLayoutInfoListener", activity, new l<androidx.window.extensions.layout.WindowLayoutInfo, q>() { // from class: androidx.window.layout.ExtensionWindowLayoutInfoBackend$registerLayoutChangeCallback$1$2$disposableToken$1
                    {
                        super(1);
                    }

                    public final void b(androidx.window.extensions.layout.WindowLayoutInfo value) {
                        i.f(value, "value");
                        ExtensionWindowLayoutInfoBackend.MulticastConsumer.this.accept(value);
                    }

                    @Override // v9.l
                    public /* bridge */ /* synthetic */ q invoke(androidx.window.extensions.layout.WindowLayoutInfo windowLayoutInfo) {
                        b(windowLayoutInfo);
                        return q.f35511a;
                    }
                }));
            }
            q qVar2 = q.f35511a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
