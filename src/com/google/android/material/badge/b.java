package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.ParcelableSparseArray;

/* compiled from: BadgeUtils.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f22709a = false;

    public static void a(a aVar, View view, FrameLayout frameLayout) {
        e(aVar, view, frameLayout);
        if (aVar.i() != null) {
            aVar.i().setForeground(aVar);
        } else {
            if (!f22709a) {
                view.getOverlay().add(aVar);
                return;
            }
            throw new IllegalArgumentException("Trying to reference null customBadgeParent");
        }
    }

    public static SparseArray<a> b(Context context, ParcelableSparseArray parcelableSparseArray) {
        a aVar;
        SparseArray<a> sparseArray = new SparseArray<>(parcelableSparseArray.size());
        for (int i10 = 0; i10 < parcelableSparseArray.size(); i10++) {
            int keyAt = parcelableSparseArray.keyAt(i10);
            BadgeState.State state = (BadgeState.State) parcelableSparseArray.valueAt(i10);
            if (state != null) {
                aVar = a.d(context, state);
            } else {
                aVar = null;
            }
            sparseArray.put(keyAt, aVar);
        }
        return sparseArray;
    }

    public static ParcelableSparseArray c(SparseArray<a> sparseArray) {
        BadgeState.State state;
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            int keyAt = sparseArray.keyAt(i10);
            a valueAt = sparseArray.valueAt(i10);
            if (valueAt != null) {
                state = valueAt.s();
            } else {
                state = null;
            }
            parcelableSparseArray.put(keyAt, state);
        }
        return parcelableSparseArray;
    }

    public static void d(a aVar, View view) {
        if (aVar == null) {
            return;
        }
        if (!f22709a && aVar.i() == null) {
            view.getOverlay().remove(aVar);
        } else {
            aVar.i().setForeground(null);
        }
    }

    public static void e(a aVar, View view, FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        aVar.setBounds(rect);
        aVar.P(view, frameLayout);
    }

    public static void f(Rect rect, float f10, float f11, float f12, float f13) {
        rect.set((int) (f10 - f12), (int) (f11 - f13), (int) (f10 + f12), (int) (f11 + f13));
    }
}
