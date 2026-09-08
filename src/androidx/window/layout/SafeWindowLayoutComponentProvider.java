package androidx.window.layout;

import C9.c;
import android.app.Activity;
import android.graphics.Rect;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.k;
import u9.C1614a;
import v9.InterfaceC1637a;

/* compiled from: SafeWindowLayoutComponentProvider.kt */
/* loaded from: classes.dex */
public final class SafeWindowLayoutComponentProvider {

    /* renamed from: a, reason: collision with root package name */
    public final ClassLoader f12021a;

    /* renamed from: b, reason: collision with root package name */
    public final ConsumerAdapter f12022b;

    public SafeWindowLayoutComponentProvider(ClassLoader loader, ConsumerAdapter consumerAdapter) {
        i.f(loader, "loader");
        i.f(consumerAdapter, "consumerAdapter");
        this.f12021a = loader;
        this.f12022b = consumerAdapter;
    }

    public final boolean i() {
        if (u() && s() && t() && q()) {
            return true;
        }
        return false;
    }

    public final boolean j(Method method, c<?> cVar) {
        return k(method, C1614a.a(cVar));
    }

    public final boolean k(Method method, Class<?> cls) {
        return method.getReturnType().equals(cls);
    }

    public final Class<?> l() {
        Class<?> loadClass = this.f12021a.loadClass("androidx.window.extensions.layout.FoldingFeature");
        i.e(loadClass, "loader.loadClass(\"androi…s.layout.FoldingFeature\")");
        return loadClass;
    }

    public final Class<?> m() {
        Class<?> loadClass = this.f12021a.loadClass("androidx.window.extensions.WindowExtensions");
        i.e(loadClass, "loader.loadClass(\"androi…nsions.WindowExtensions\")");
        return loadClass;
    }

    public final Class<?> n() {
        Class<?> loadClass = this.f12021a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
        i.e(loadClass, "loader.loadClass(\"androi…indowExtensionsProvider\")");
        return loadClass;
    }

    public final WindowLayoutComponent o() {
        if (i()) {
            try {
                return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
            } catch (UnsupportedOperationException unused) {
                return null;
            }
        }
        return null;
    }

    public final Class<?> p() {
        Class<?> loadClass = this.f12021a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
        i.e(loadClass, "loader.loadClass(\"androi…t.WindowLayoutComponent\")");
        return loadClass;
    }

    public final boolean q() {
        return v(new InterfaceC1637a<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Class l10;
                boolean j10;
                boolean z10;
                boolean r10;
                boolean j11;
                boolean r11;
                boolean j12;
                boolean r12;
                l10 = SafeWindowLayoutComponentProvider.this.l();
                Method getBoundsMethod = l10.getMethod("getBounds", null);
                Method getTypeMethod = l10.getMethod("getType", null);
                Method getStateMethod = l10.getMethod("getState", null);
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.this;
                i.e(getBoundsMethod, "getBoundsMethod");
                j10 = safeWindowLayoutComponentProvider.j(getBoundsMethod, k.b(Rect.class));
                if (j10) {
                    r10 = SafeWindowLayoutComponentProvider.this.r(getBoundsMethod);
                    if (r10) {
                        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider2 = SafeWindowLayoutComponentProvider.this;
                        i.e(getTypeMethod, "getTypeMethod");
                        Class cls = Integer.TYPE;
                        j11 = safeWindowLayoutComponentProvider2.j(getTypeMethod, k.b(cls));
                        if (j11) {
                            r11 = SafeWindowLayoutComponentProvider.this.r(getTypeMethod);
                            if (r11) {
                                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider3 = SafeWindowLayoutComponentProvider.this;
                                i.e(getStateMethod, "getStateMethod");
                                j12 = safeWindowLayoutComponentProvider3.j(getStateMethod, k.b(cls));
                                if (j12) {
                                    r12 = SafeWindowLayoutComponentProvider.this.r(getStateMethod);
                                    if (r12) {
                                        z10 = true;
                                        return Boolean.valueOf(z10);
                                    }
                                }
                            }
                        }
                    }
                }
                z10 = false;
                return Boolean.valueOf(z10);
            }
        });
    }

    public final boolean r(Method method) {
        return Modifier.isPublic(method.getModifiers());
    }

    public final boolean s() {
        return v(new InterfaceC1637a<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Class m10;
                Class p10;
                boolean r10;
                boolean z10;
                boolean k10;
                m10 = SafeWindowLayoutComponentProvider.this.m();
                Method getWindowLayoutComponentMethod = m10.getMethod("getWindowLayoutComponent", null);
                p10 = SafeWindowLayoutComponentProvider.this.p();
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.this;
                i.e(getWindowLayoutComponentMethod, "getWindowLayoutComponentMethod");
                r10 = safeWindowLayoutComponentProvider.r(getWindowLayoutComponentMethod);
                if (r10) {
                    k10 = SafeWindowLayoutComponentProvider.this.k(getWindowLayoutComponentMethod, p10);
                    if (k10) {
                        z10 = true;
                        return Boolean.valueOf(z10);
                    }
                }
                z10 = false;
                return Boolean.valueOf(z10);
            }
        });
    }

    public final boolean t() {
        return v(new InterfaceC1637a<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                ConsumerAdapter consumerAdapter;
                Class p10;
                boolean r10;
                boolean z10;
                boolean r11;
                consumerAdapter = SafeWindowLayoutComponentProvider.this.f12022b;
                Class<?> c10 = consumerAdapter.c();
                if (c10 == null) {
                    return Boolean.FALSE;
                }
                p10 = SafeWindowLayoutComponentProvider.this.p();
                Method addListenerMethod = p10.getMethod("addWindowLayoutInfoListener", Activity.class, c10);
                Method removeListenerMethod = p10.getMethod("removeWindowLayoutInfoListener", c10);
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.this;
                i.e(addListenerMethod, "addListenerMethod");
                r10 = safeWindowLayoutComponentProvider.r(addListenerMethod);
                if (r10) {
                    SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider2 = SafeWindowLayoutComponentProvider.this;
                    i.e(removeListenerMethod, "removeListenerMethod");
                    r11 = safeWindowLayoutComponentProvider2.r(removeListenerMethod);
                    if (r11) {
                        z10 = true;
                        return Boolean.valueOf(z10);
                    }
                }
                z10 = false;
                return Boolean.valueOf(z10);
            }
        });
    }

    public final boolean u() {
        return v(new InterfaceC1637a<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Class n10;
                Class m10;
                boolean k10;
                boolean z10;
                boolean r10;
                n10 = SafeWindowLayoutComponentProvider.this.n();
                Method getWindowExtensionsMethod = n10.getDeclaredMethod("getWindowExtensions", null);
                m10 = SafeWindowLayoutComponentProvider.this.m();
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.this;
                i.e(getWindowExtensionsMethod, "getWindowExtensionsMethod");
                k10 = safeWindowLayoutComponentProvider.k(getWindowExtensionsMethod, m10);
                if (k10) {
                    r10 = SafeWindowLayoutComponentProvider.this.r(getWindowExtensionsMethod);
                    if (r10) {
                        z10 = true;
                        return Boolean.valueOf(z10);
                    }
                }
                z10 = false;
                return Boolean.valueOf(z10);
            }
        });
    }

    public final boolean v(InterfaceC1637a<Boolean> interfaceC1637a) {
        try {
            return interfaceC1637a.invoke().booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return false;
        }
    }
}
