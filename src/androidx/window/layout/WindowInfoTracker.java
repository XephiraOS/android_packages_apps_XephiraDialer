package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.layout.WindowInfoTracker;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.k;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: WindowInfoTracker.kt */
/* loaded from: classes.dex */
public interface WindowInfoTracker {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f12059a = Companion.f12060a;

    /* compiled from: WindowInfoTracker.kt */
    /* loaded from: classes.dex */
    public static final class Companion {

        /* renamed from: b, reason: collision with root package name */
        public static final boolean f12061b = false;

        /* renamed from: d, reason: collision with root package name */
        public static final d<ExtensionWindowLayoutInfoBackend> f12063d;

        /* renamed from: e, reason: collision with root package name */
        public static WindowInfoTrackerDecorator f12064e;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f12060a = new Companion();

        /* renamed from: c, reason: collision with root package name */
        public static final String f12062c = k.b(WindowInfoTracker.class).c();

        static {
            d<ExtensionWindowLayoutInfoBackend> b10;
            b10 = kotlin.a.b(new InterfaceC1637a<ExtensionWindowLayoutInfoBackend>() { // from class: androidx.window.layout.WindowInfoTracker$Companion$extensionBackend$2
                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final ExtensionWindowLayoutInfoBackend invoke() {
                    boolean z10;
                    String str;
                    SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider;
                    WindowLayoutComponent o10;
                    try {
                        ClassLoader loader = WindowInfoTracker.class.getClassLoader();
                        if (loader != null) {
                            safeWindowLayoutComponentProvider = new SafeWindowLayoutComponentProvider(loader, new ConsumerAdapter(loader));
                        } else {
                            safeWindowLayoutComponentProvider = null;
                        }
                        if (safeWindowLayoutComponentProvider == null || (o10 = safeWindowLayoutComponentProvider.o()) == null) {
                            return null;
                        }
                        i.e(loader, "loader");
                        return new ExtensionWindowLayoutInfoBackend(o10, new ConsumerAdapter(loader));
                    } catch (Throwable unused) {
                        z10 = WindowInfoTracker.Companion.f12061b;
                        if (z10) {
                            str = WindowInfoTracker.Companion.f12062c;
                            Log.d(str, "Failed to load WindowExtensions");
                            return null;
                        }
                        return null;
                    }
                }
            });
            f12063d = b10;
            f12064e = EmptyDecorator.f11989a;
        }

        private Companion() {
        }

        public final WindowBackend c() {
            return f12063d.getValue();
        }

        public final WindowInfoTracker d(Context context) {
            i.f(context, "context");
            WindowBackend c10 = c();
            if (c10 == null) {
                c10 = SidecarWindowBackend.f12049c.a(context);
            }
            return f12064e.a(new WindowInfoTrackerImpl(WindowMetricsCalculatorCompat.f12075a, c10));
        }
    }

    static WindowInfoTracker a(Context context) {
        return f12059a.d(context);
    }

    kotlinx.coroutines.flow.a<WindowLayoutInfo> b(Activity activity);
}
