package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: AnimateLayoutChangeDetector.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final ViewGroup.MarginLayoutParams f11859b;

    /* renamed from: a, reason: collision with root package name */
    public LinearLayoutManager f11860a;

    /* compiled from: AnimateLayoutChangeDetector.java */
    /* renamed from: androidx.viewpager2.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0143a implements Comparator<int[]> {
        public C0143a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(int[] iArr, int[] iArr2) {
            return iArr[0] - iArr2[0];
        }
    }

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f11859b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    public a(LinearLayoutManager linearLayoutManager) {
        this.f11860a = linearLayoutManager;
    }

    public static boolean c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (c(viewGroup.getChildAt(i10))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean a() {
        boolean z10;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int top;
        int i10;
        int bottom;
        int i11;
        int childCount = this.f11860a.getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (this.f11860a.getOrientation() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, childCount, 2);
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = this.f11860a.getChildAt(i12);
            if (childAt != null) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams = f11859b;
                }
                int[] iArr2 = iArr[i12];
                if (z10) {
                    top = childAt.getLeft();
                    i10 = marginLayoutParams.leftMargin;
                } else {
                    top = childAt.getTop();
                    i10 = marginLayoutParams.topMargin;
                }
                iArr2[0] = top - i10;
                int[] iArr3 = iArr[i12];
                if (z10) {
                    bottom = childAt.getRight();
                    i11 = marginLayoutParams.rightMargin;
                } else {
                    bottom = childAt.getBottom();
                    i11 = marginLayoutParams.bottomMargin;
                }
                iArr3[1] = bottom + i11;
            } else {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
        }
        Arrays.sort(iArr, new C0143a());
        for (int i13 = 1; i13 < childCount; i13++) {
            if (iArr[i13 - 1][1] != iArr[i13][0]) {
                return false;
            }
        }
        int[] iArr4 = iArr[0];
        int i14 = iArr4[1];
        int i15 = iArr4[0];
        int i16 = i14 - i15;
        if (i15 <= 0 && iArr[childCount - 1][1] >= i16) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        int childCount = this.f11860a.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (c(this.f11860a.getChildAt(i10))) {
                return true;
            }
        }
        return false;
    }

    public boolean d() {
        if ((!a() || this.f11860a.getChildCount() <= 1) && b()) {
            return true;
        }
        return false;
    }
}
