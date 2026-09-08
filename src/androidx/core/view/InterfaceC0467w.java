package androidx.core.view;

import android.view.View;

/* compiled from: NestedScrollingParent2.java */
/* renamed from: androidx.core.view.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0467w {
    void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12);

    void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14);

    void onNestedScrollAccepted(View view, View view2, int i10, int i11);

    boolean onStartNestedScroll(View view, View view2, int i10, int i11);

    void onStopNestedScroll(View view, int i10);
}
