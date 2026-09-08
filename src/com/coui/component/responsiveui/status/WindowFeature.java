package com.coui.component.responsiveui.status;

import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import java.util.List;
import kotlin.collections.o;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: WindowFeature.kt */
/* loaded from: classes3.dex */
public final class WindowFeature {

    /* renamed from: a, reason: collision with root package name */
    public final List<DisplayFeature> f20022a;

    /* renamed from: b, reason: collision with root package name */
    public final List<FoldingFeature> f20023b;

    /* JADX WARN: Multi-variable type inference failed */
    public WindowFeature() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WindowFeature copy$default(WindowFeature windowFeature, List list, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = windowFeature.f20022a;
        }
        if ((i10 & 2) != 0) {
            list2 = windowFeature.f20023b;
        }
        return windowFeature.copy(list, list2);
    }

    public final List<DisplayFeature> component1() {
        return this.f20022a;
    }

    public final List<FoldingFeature> component2() {
        return this.f20023b;
    }

    public final WindowFeature copy(List<? extends DisplayFeature> displayFeatureList, List<? extends FoldingFeature> foldingFeatureList) {
        i.f(displayFeatureList, "displayFeatureList");
        i.f(foldingFeatureList, "foldingFeatureList");
        return new WindowFeature(displayFeatureList, foldingFeatureList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowFeature)) {
            return false;
        }
        WindowFeature windowFeature = (WindowFeature) obj;
        if (i.b(this.f20022a, windowFeature.f20022a) && i.b(this.f20023b, windowFeature.f20023b)) {
            return true;
        }
        return false;
    }

    public final List<DisplayFeature> getDisplayFeatureList() {
        return this.f20022a;
    }

    public final List<FoldingFeature> getFoldingFeatureList() {
        return this.f20023b;
    }

    public int hashCode() {
        return (this.f20022a.hashCode() * 31) + this.f20023b.hashCode();
    }

    public String toString() {
        return "WindowFeature { displayFeature = " + this.f20022a + ", foldingFeature = " + this.f20023b + " }";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WindowFeature(List<? extends DisplayFeature> displayFeatureList, List<? extends FoldingFeature> foldingFeatureList) {
        i.f(displayFeatureList, "displayFeatureList");
        i.f(foldingFeatureList, "foldingFeatureList");
        this.f20022a = displayFeatureList;
        this.f20023b = foldingFeatureList;
    }

    public /* synthetic */ WindowFeature(List list, List list2, int i10, f fVar) {
        this((i10 & 1) != 0 ? o.h() : list, (i10 & 2) != 0 ? o.h() : list2);
    }
}
