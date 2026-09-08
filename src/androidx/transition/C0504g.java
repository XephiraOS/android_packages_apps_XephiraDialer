package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;

/* compiled from: GhostViewHolder.java */
/* renamed from: androidx.transition.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0504g extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f11715a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11716b;

    /* compiled from: GhostViewHolder.java */
    /* renamed from: androidx.transition.g$a */
    /* loaded from: classes.dex */
    public static class a {
        public static float a(View view) {
            return view.getZ();
        }
    }

    public C0504g(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.f11715a = viewGroup;
        viewGroup.setTag(C0511n.f11726b, this);
        this.f11715a.getOverlay().add(this);
        this.f11716b = true;
    }

    public static C0504g b(ViewGroup viewGroup) {
        return (C0504g) viewGroup.getTag(C0511n.f11726b);
    }

    public static void d(View view, ArrayList<View> arrayList) {
        Object parent = view.getParent();
        if (parent instanceof ViewGroup) {
            d((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    public static boolean e(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        if (a.a(view) != a.a(view2)) {
            if (a.a(view) <= a.a(view2)) {
                return false;
            }
            return true;
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(G.a(viewGroup, i10));
            if (childAt == view) {
                return false;
            }
            if (childAt == view2) {
                break;
            }
        }
        return true;
    }

    public static boolean f(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int min = Math.min(arrayList.size(), arrayList2.size());
        for (int i10 = 1; i10 < min; i10++) {
            View view = arrayList.get(i10);
            View view2 = arrayList2.get(i10);
            if (view != view2) {
                return e(view, view2);
            }
        }
        if (arrayList2.size() == min) {
            return true;
        }
        return false;
    }

    public void a(C0505h c0505h) {
        ArrayList<View> arrayList = new ArrayList<>();
        d(c0505h.f11719c, arrayList);
        int c10 = c(arrayList);
        if (c10 >= 0 && c10 < getChildCount()) {
            addView(c0505h, c10);
        } else {
            addView(c0505h);
        }
    }

    public final int c(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i10 = 0;
        while (i10 <= childCount) {
            int i11 = (i10 + childCount) / 2;
            d(((C0505h) getChildAt(i11)).f11719c, arrayList2);
            if (f(arrayList, arrayList2)) {
                i10 = i11 + 1;
            } else {
                childCount = i11 - 1;
            }
            arrayList2.clear();
        }
        return i10;
    }

    public void g() {
        if (this.f11716b) {
            this.f11715a.getOverlay().remove(this);
            this.f11715a.getOverlay().add(this);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (this.f11716b) {
            super.onViewAdded(view);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.f11715a.setTag(C0511n.f11726b, null);
            this.f11715a.getOverlay().remove(this);
            this.f11716b = false;
        }
    }
}
