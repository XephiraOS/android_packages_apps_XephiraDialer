package androidx.window.layout;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.i;

/* compiled from: WindowLayoutInfo.kt */
/* loaded from: classes.dex */
public final class WindowLayoutInfo {

    /* renamed from: a, reason: collision with root package name */
    public final List<DisplayFeature> f12069a;

    /* JADX WARN: Multi-variable type inference failed */
    public WindowLayoutInfo(List<? extends DisplayFeature> displayFeatures) {
        i.f(displayFeatures, "displayFeatures");
        this.f12069a = displayFeatures;
    }

    public final List<DisplayFeature> a() {
        return this.f12069a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.b(WindowLayoutInfo.class, obj.getClass())) {
            return i.b(this.f12069a, ((WindowLayoutInfo) obj).f12069a);
        }
        return false;
    }

    public int hashCode() {
        return this.f12069a.hashCode();
    }

    public String toString() {
        String D10;
        D10 = CollectionsKt___CollectionsKt.D(this.f12069a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, null, null, 56, null);
        return D10;
    }
}
