package androidx.slidingpanelayout.widget;

import android.app.Activity;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1239d0;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.F;
import kotlinx.coroutines.InterfaceC1265l0;

/* compiled from: FoldingFeatureObserver.kt */
/* loaded from: classes.dex */
public final class FoldingFeatureObserver {

    /* renamed from: a, reason: collision with root package name */
    public final WindowInfoTracker f11419a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f11420b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC1265l0 f11421c;

    /* renamed from: d, reason: collision with root package name */
    public a f11422d;

    /* compiled from: FoldingFeatureObserver.kt */
    /* loaded from: classes.dex */
    public interface a {
        void a(FoldingFeature foldingFeature);
    }

    public FoldingFeatureObserver(WindowInfoTracker windowInfoTracker, Executor executor) {
        i.f(windowInfoTracker, "windowInfoTracker");
        i.f(executor, "executor");
        this.f11419a = windowInfoTracker;
        this.f11420b = executor;
    }

    public final FoldingFeature d(WindowLayoutInfo windowLayoutInfo) {
        Object obj;
        Iterator<T> it = windowLayoutInfo.a().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((DisplayFeature) obj) instanceof FoldingFeature) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (!(obj instanceof FoldingFeature)) {
            return null;
        }
        return (FoldingFeature) obj;
    }

    public final void e(Activity activity) {
        InterfaceC1265l0 d10;
        i.f(activity, "activity");
        InterfaceC1265l0 interfaceC1265l0 = this.f11421c;
        if (interfaceC1265l0 != null) {
            InterfaceC1265l0.a.a(interfaceC1265l0, null, 1, null);
        }
        d10 = C1248i.d(F.a(C1239d0.a(this.f11420b)), null, null, new FoldingFeatureObserver$registerLayoutStateChangeCallback$1(this, activity, null), 3, null);
        this.f11421c = d10;
    }

    public final void f(a onFoldingFeatureChangeListener) {
        i.f(onFoldingFeatureChangeListener, "onFoldingFeatureChangeListener");
        this.f11422d = onFoldingFeatureChangeListener;
    }

    public final void g() {
        InterfaceC1265l0 interfaceC1265l0 = this.f11421c;
        if (interfaceC1265l0 != null) {
            InterfaceC1265l0.a.a(interfaceC1265l0, null, 1, null);
        }
    }
}
