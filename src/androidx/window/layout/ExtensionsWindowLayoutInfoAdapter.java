package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import androidx.window.core.Bounds;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.HardwareFoldingFeature;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.i;

/* compiled from: ExtensionsWindowLayoutInfoAdapter.kt */
/* loaded from: classes.dex */
public final class ExtensionsWindowLayoutInfoAdapter {

    /* renamed from: a, reason: collision with root package name */
    public static final ExtensionsWindowLayoutInfoAdapter f12000a = new ExtensionsWindowLayoutInfoAdapter();

    private ExtensionsWindowLayoutInfoAdapter() {
    }

    public final FoldingFeature a(Activity activity, androidx.window.extensions.layout.FoldingFeature oemFeature) {
        HardwareFoldingFeature.Type a10;
        FoldingFeature.State state;
        i.f(activity, "activity");
        i.f(oemFeature, "oemFeature");
        int type = oemFeature.getType();
        if (type != 1) {
            if (type != 2) {
                return null;
            }
            a10 = HardwareFoldingFeature.Type.f12017b.b();
        } else {
            a10 = HardwareFoldingFeature.Type.f12017b.a();
        }
        int state2 = oemFeature.getState();
        if (state2 != 1) {
            if (state2 != 2) {
                return null;
            }
            state = FoldingFeature.State.f12011d;
        } else {
            state = FoldingFeature.State.f12010c;
        }
        Rect bounds = oemFeature.getBounds();
        i.e(bounds, "oemFeature.bounds");
        if (!c(activity, new Bounds(bounds))) {
            return null;
        }
        Rect bounds2 = oemFeature.getBounds();
        i.e(bounds2, "oemFeature.bounds");
        return new HardwareFoldingFeature(new Bounds(bounds2), a10, state);
    }

    public final WindowLayoutInfo b(Activity activity, androidx.window.extensions.layout.WindowLayoutInfo info) {
        FoldingFeature foldingFeature;
        i.f(activity, "activity");
        i.f(info, "info");
        List<androidx.window.extensions.layout.FoldingFeature> displayFeatures = info.getDisplayFeatures();
        i.e(displayFeatures, "info.displayFeatures");
        ArrayList arrayList = new ArrayList();
        for (androidx.window.extensions.layout.FoldingFeature feature : displayFeatures) {
            if (feature instanceof androidx.window.extensions.layout.FoldingFeature) {
                ExtensionsWindowLayoutInfoAdapter extensionsWindowLayoutInfoAdapter = f12000a;
                i.e(feature, "feature");
                foldingFeature = extensionsWindowLayoutInfoAdapter.a(activity, feature);
            } else {
                foldingFeature = null;
            }
            if (foldingFeature != null) {
                arrayList.add(foldingFeature);
            }
        }
        return new WindowLayoutInfo(arrayList);
    }

    public final boolean c(Activity activity, Bounds bounds) {
        Rect a10 = WindowMetricsCalculatorCompat.f12075a.a(activity).a();
        if (bounds.e()) {
            return false;
        }
        if (bounds.d() != a10.width() && bounds.a() != a10.height()) {
            return false;
        }
        if (bounds.d() < a10.width() && bounds.a() < a10.height()) {
            return false;
        }
        if (bounds.d() == a10.width() && bounds.a() == a10.height()) {
            return false;
        }
        return true;
    }
}
