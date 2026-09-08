package androidx.transition;

import android.view.View;

/* compiled from: VisibilityPropagation.java */
/* loaded from: classes.dex */
public abstract class N extends z {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f11630a = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    public static int d(C c10, int i10) {
        int[] iArr;
        if (c10 == null || (iArr = (int[]) c10.f11527a.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i10];
    }

    @Override // androidx.transition.z
    public void a(C c10) {
        View view = c10.f11528b;
        Integer num = (Integer) c10.f11527a.get("android:visibility:visibility");
        if (num == null) {
            num = Integer.valueOf(view.getVisibility());
        }
        c10.f11527a.put("android:visibilityPropagation:visibility", num);
        view.getLocationOnScreen(r1);
        int round = r1[0] + Math.round(view.getTranslationX());
        int[] iArr = {round};
        iArr[0] = round + (view.getWidth() / 2);
        int round2 = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = round2;
        iArr[1] = round2 + (view.getHeight() / 2);
        c10.f11527a.put("android:visibilityPropagation:center", iArr);
    }

    @Override // androidx.transition.z
    public String[] b() {
        return f11630a;
    }

    public int e(C c10) {
        Integer num;
        if (c10 == null || (num = (Integer) c10.f11527a.get("android:visibilityPropagation:visibility")) == null) {
            return 8;
        }
        return num.intValue();
    }

    public int f(C c10) {
        return d(c10, 0);
    }

    public int g(C c10) {
        return d(c10, 1);
    }
}
