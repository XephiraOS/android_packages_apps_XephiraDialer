package androidx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: DataBindingUtil.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static e f9654a = new DataBinderMapperImpl();

    /* renamed from: b, reason: collision with root package name */
    public static f f9655b = null;

    public static <T extends ViewDataBinding> T a(View view) {
        return (T) b(view, f9655b);
    }

    public static <T extends ViewDataBinding> T b(View view, f fVar) {
        T t10 = (T) f(view);
        if (t10 != null) {
            return t10;
        }
        Object tag = view.getTag();
        if (tag instanceof String) {
            int layoutId = f9654a.getLayoutId((String) tag);
            if (layoutId != 0) {
                return (T) f9654a.getDataBinder(fVar, view, layoutId);
            }
            throw new IllegalArgumentException("View is not a binding layout. Tag: " + tag);
        }
        throw new IllegalArgumentException("View is not a binding layout");
    }

    public static <T extends ViewDataBinding> T c(f fVar, View view, int i10) {
        return (T) f9654a.getDataBinder(fVar, view, i10);
    }

    public static <T extends ViewDataBinding> T d(f fVar, View[] viewArr, int i10) {
        return (T) f9654a.getDataBinder(fVar, viewArr, i10);
    }

    public static <T extends ViewDataBinding> T e(f fVar, ViewGroup viewGroup, int i10, int i11) {
        int childCount = viewGroup.getChildCount();
        int i12 = childCount - i10;
        if (i12 == 1) {
            return (T) c(fVar, viewGroup.getChildAt(childCount - 1), i11);
        }
        View[] viewArr = new View[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            viewArr[i13] = viewGroup.getChildAt(i13 + i10);
        }
        return (T) d(fVar, viewArr, i11);
    }

    public static <T extends ViewDataBinding> T f(View view) {
        return (T) ViewDataBinding.H0(view);
    }

    public static f g() {
        return f9655b;
    }

    public static <T extends ViewDataBinding> T h(LayoutInflater layoutInflater, int i10, ViewGroup viewGroup, boolean z10) {
        return (T) i(layoutInflater, i10, viewGroup, z10, f9655b);
    }

    public static <T extends ViewDataBinding> T i(LayoutInflater layoutInflater, int i10, ViewGroup viewGroup, boolean z10, f fVar) {
        boolean z11;
        int i11 = 0;
        if (viewGroup != null && z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i11 = viewGroup.getChildCount();
        }
        View inflate = layoutInflater.inflate(i10, viewGroup, z10);
        if (z11) {
            return (T) e(fVar, viewGroup, i11, i10);
        }
        return (T) c(fVar, inflate, i10);
    }
}
