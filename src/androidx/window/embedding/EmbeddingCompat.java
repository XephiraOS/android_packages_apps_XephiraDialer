package androidx.window.embedding;

import android.util.Log;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.embedding.EmbeddingCompat;
import androidx.window.embedding.EmbeddingInterfaceCompat;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.k;
import m9.q;
import v9.l;

/* compiled from: EmbeddingCompat.kt */
@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class EmbeddingCompat implements EmbeddingInterfaceCompat {

    /* renamed from: d, reason: collision with root package name */
    public static final Companion f11941d = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final ActivityEmbeddingComponent f11942a;

    /* renamed from: b, reason: collision with root package name */
    public final EmbeddingAdapter f11943b;

    /* renamed from: c, reason: collision with root package name */
    public final ConsumerAdapter f11944c;

    /* compiled from: EmbeddingCompat.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public static final q d(Object obj, Method method, Object[] objArr) {
            return q.f35511a;
        }

        public static final q e(Object obj, Method method, Object[] objArr) {
            return q.f35511a;
        }

        public final ActivityEmbeddingComponent c() {
            if (g()) {
                ActivityEmbeddingComponent activityEmbeddingComponent = WindowExtensionsProvider.getWindowExtensions().getActivityEmbeddingComponent();
                if (activityEmbeddingComponent == null) {
                    Object newProxyInstance = Proxy.newProxyInstance(EmbeddingCompat.class.getClassLoader(), new Class[]{ActivityEmbeddingComponent.class}, new InvocationHandler() { // from class: androidx.window.embedding.a
                        @Override // java.lang.reflect.InvocationHandler
                        public final Object invoke(Object obj, Method method, Object[] objArr) {
                            q d10;
                            d10 = EmbeddingCompat.Companion.d(obj, method, objArr);
                            return d10;
                        }
                    });
                    if (newProxyInstance != null) {
                        return (ActivityEmbeddingComponent) newProxyInstance;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.window.extensions.embedding.ActivityEmbeddingComponent");
                }
                return activityEmbeddingComponent;
            }
            Object newProxyInstance2 = Proxy.newProxyInstance(EmbeddingCompat.class.getClassLoader(), new Class[]{ActivityEmbeddingComponent.class}, new InvocationHandler() { // from class: androidx.window.embedding.b
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method, Object[] objArr) {
                    q e10;
                    e10 = EmbeddingCompat.Companion.e(obj, method, objArr);
                    return e10;
                }
            });
            if (newProxyInstance2 != null) {
                return (ActivityEmbeddingComponent) newProxyInstance2;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.window.extensions.embedding.ActivityEmbeddingComponent");
        }

        public final Integer f() {
            try {
                return Integer.valueOf(WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel());
            } catch (NoClassDefFoundError unused) {
                Log.d("EmbeddingCompat", "Embedding extension version not found");
                return null;
            } catch (UnsupportedOperationException unused2) {
                Log.d("EmbeddingCompat", "Stub Extension");
                return null;
            }
        }

        public final boolean g() {
            try {
                if (WindowExtensionsProvider.getWindowExtensions().getActivityEmbeddingComponent() == null) {
                    return false;
                }
                return true;
            } catch (NoClassDefFoundError unused) {
                Log.d("EmbeddingCompat", "Embedding extension version not found");
                return false;
            } catch (UnsupportedOperationException unused2) {
                Log.d("EmbeddingCompat", "Stub Extension");
                return false;
            }
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public EmbeddingCompat(ActivityEmbeddingComponent embeddingExtension, EmbeddingAdapter adapter, ConsumerAdapter consumerAdapter) {
        i.f(embeddingExtension, "embeddingExtension");
        i.f(adapter, "adapter");
        i.f(consumerAdapter, "consumerAdapter");
        this.f11942a = embeddingExtension;
        this.f11943b = adapter;
        this.f11944c = consumerAdapter;
    }

    @Override // androidx.window.embedding.EmbeddingInterfaceCompat
    public void a(final EmbeddingInterfaceCompat.EmbeddingCallbackInterface embeddingCallback) {
        i.f(embeddingCallback, "embeddingCallback");
        this.f11944c.a(this.f11942a, k.b(List.class), "setSplitInfoCallback", new l<List<?>, q>() { // from class: androidx.window.embedding.EmbeddingCompat$setEmbeddingCallback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(List<?> values) {
                EmbeddingAdapter embeddingAdapter;
                i.f(values, "values");
                ArrayList arrayList = new ArrayList();
                for (Object obj : values) {
                    if (obj instanceof androidx.window.extensions.embedding.SplitInfo) {
                        arrayList.add(obj);
                    }
                }
                EmbeddingInterfaceCompat.EmbeddingCallbackInterface embeddingCallbackInterface = EmbeddingInterfaceCompat.EmbeddingCallbackInterface.this;
                embeddingAdapter = this.f11943b;
                embeddingCallbackInterface.a(embeddingAdapter.b(arrayList));
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(List<?> list) {
                b(list);
                return q.f35511a;
            }
        });
    }
}
