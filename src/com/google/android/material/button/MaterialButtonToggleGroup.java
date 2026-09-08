package com.google.android.material.button;

import J.d;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import androidx.core.view.C0446a;
import androidx.core.view.C0458m;
import androidx.core.view.K;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ViewUtils;
import e4.C0977c;
import e4.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import x4.C1679a;
import x4.n;

/* loaded from: classes3.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: k, reason: collision with root package name */
    public static final int f22869k = l.f31008J;

    /* renamed from: a, reason: collision with root package name */
    public final List<c> f22870a;

    /* renamed from: b, reason: collision with root package name */
    public final e f22871b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashSet<d> f22872c;

    /* renamed from: d, reason: collision with root package name */
    public final Comparator<MaterialButton> f22873d;

    /* renamed from: e, reason: collision with root package name */
    public Integer[] f22874e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f22875f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f22876g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f22877h;

    /* renamed from: i, reason: collision with root package name */
    public final int f22878i;

    /* renamed from: j, reason: collision with root package name */
    public Set<Integer> f22879j;

    /* loaded from: classes3.dex */
    public class a implements Comparator<MaterialButton> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            if (compareTo2 != 0) {
                return compareTo2;
            }
            return Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    /* loaded from: classes3.dex */
    public class b extends C0446a {
        public b() {
        }

        @Override // androidx.core.view.C0446a
        public void onInitializeAccessibilityNodeInfo(View view, J.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            dVar.k0(d.f.a(0, 1, MaterialButtonToggleGroup.this.i(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: e, reason: collision with root package name */
        public static final x4.d f22882e = new C1679a(0.0f);

        /* renamed from: a, reason: collision with root package name */
        public x4.d f22883a;

        /* renamed from: b, reason: collision with root package name */
        public x4.d f22884b;

        /* renamed from: c, reason: collision with root package name */
        public x4.d f22885c;

        /* renamed from: d, reason: collision with root package name */
        public x4.d f22886d;

        public c(x4.d dVar, x4.d dVar2, x4.d dVar3, x4.d dVar4) {
            this.f22883a = dVar;
            this.f22884b = dVar3;
            this.f22885c = dVar4;
            this.f22886d = dVar2;
        }

        public static c a(c cVar) {
            x4.d dVar = f22882e;
            return new c(dVar, cVar.f22886d, dVar, cVar.f22885c);
        }

        public static c b(c cVar, View view) {
            if (ViewUtils.isLayoutRtl(view)) {
                return c(cVar);
            }
            return d(cVar);
        }

        public static c c(c cVar) {
            x4.d dVar = cVar.f22883a;
            x4.d dVar2 = cVar.f22886d;
            x4.d dVar3 = f22882e;
            return new c(dVar, dVar2, dVar3, dVar3);
        }

        public static c d(c cVar) {
            x4.d dVar = f22882e;
            return new c(dVar, dVar, cVar.f22884b, cVar.f22885c);
        }

        public static c e(c cVar, View view) {
            if (ViewUtils.isLayoutRtl(view)) {
                return d(cVar);
            }
            return c(cVar);
        }

        public static c f(c cVar) {
            x4.d dVar = cVar.f22883a;
            x4.d dVar2 = f22882e;
            return new c(dVar, dVar2, cVar.f22884b, dVar2);
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i10, boolean z10);
    }

    /* loaded from: classes3.dex */
    public class e implements MaterialButton.b {
        public e() {
        }

        @Override // com.google.android.material.button.MaterialButton.b
        public void a(MaterialButton materialButton, boolean z10) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        public /* synthetic */ e(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30637I);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (k(i10)) {
                return i10;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (k(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if ((getChildAt(i11) instanceof MaterialButton) && k(i11)) {
                i10++;
            }
        }
        return i10;
    }

    public static void p(n.b bVar, c cVar) {
        if (cVar == null) {
            bVar.o(0.0f);
        } else {
            bVar.I(cVar.f22883a).x(cVar.f22886d).N(cVar.f22884b).C(cVar.f22885c);
        }
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(K.i());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f22871b);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i10, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        e(materialButton.getId(), materialButton.isChecked());
        n shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f22870a.add(new c(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
        materialButton.setEnabled(isEnabled());
        K.j0(materialButton, new b());
    }

    public void b(d dVar) {
        this.f22872c.add(dVar);
    }

    public final void c() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i10 = firstVisibleChildIndex + 1; i10 < getChildCount(); i10++) {
            MaterialButton h10 = h(i10);
            int min = Math.min(h10.getStrokeWidth(), h(i10 - 1).getStrokeWidth());
            LinearLayout.LayoutParams d10 = d(h10);
            if (getOrientation() == 0) {
                C0458m.c(d10, 0);
                C0458m.d(d10, -min);
                d10.topMargin = 0;
            } else {
                d10.bottomMargin = 0;
                d10.topMargin = -min;
                C0458m.d(d10, 0);
            }
            h10.setLayoutParams(d10);
        }
        n(firstVisibleChildIndex);
    }

    public final LinearLayout.LayoutParams d(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        r();
        super.dispatchDraw(canvas);
    }

    public final void e(int i10, boolean z10) {
        if (i10 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i10);
            return;
        }
        HashSet hashSet = new HashSet(this.f22879j);
        if (z10 && !hashSet.contains(Integer.valueOf(i10))) {
            if (this.f22876g && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i10));
        } else if (!z10 && hashSet.contains(Integer.valueOf(i10))) {
            if (!this.f22877h || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i10));
            }
        } else {
            return;
        }
        q(hashSet);
    }

    public void f() {
        q(new HashSet());
    }

    public final void g(int i10, boolean z10) {
        Iterator<d> it = this.f22872c.iterator();
        while (it.hasNext()) {
            it.next().a(this, i10, z10);
        }
    }

    public int getCheckedButtonId() {
        if (this.f22876g && !this.f22879j.isEmpty()) {
            return this.f22879j.iterator().next().intValue();
        }
        return -1;
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id = h(i10).getId();
            if (this.f22879j.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        Integer[] numArr = this.f22874e;
        if (numArr != null && i11 < numArr.length) {
            return numArr[i11].intValue();
        }
        Log.w("MButtonToggleGroup", "Child order wasn't updated");
        return i11;
    }

    public final MaterialButton h(int i10) {
        return (MaterialButton) getChildAt(i10);
    }

    public final int i(View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) == view) {
                return i10;
            }
            if ((getChildAt(i11) instanceof MaterialButton) && k(i11)) {
                i10++;
            }
        }
        return -1;
    }

    public final c j(int i10, int i11, int i12) {
        boolean z10;
        c cVar = this.f22870a.get(i10);
        if (i11 == i12) {
            return cVar;
        }
        if (getOrientation() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (i10 == i11) {
            if (z10) {
                return c.e(cVar, this);
            }
            return c.f(cVar);
        }
        if (i10 == i12) {
            if (z10) {
                return c.b(cVar, this);
            }
            return c.a(cVar);
        }
        return null;
    }

    public final boolean k(int i10) {
        if (getChildAt(i10).getVisibility() != 8) {
            return true;
        }
        return false;
    }

    public boolean l() {
        return this.f22876g;
    }

    public void m(MaterialButton materialButton, boolean z10) {
        if (this.f22875f) {
            return;
        }
        e(materialButton.getId(), z10);
    }

    public final void n(int i10) {
        if (getChildCount() != 0 && i10 != -1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) h(i10).getLayoutParams();
            if (getOrientation() == 1) {
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
            } else {
                C0458m.c(layoutParams, 0);
                C0458m.d(layoutParams, 0);
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
            }
        }
    }

    public final void o(int i10, boolean z10) {
        View findViewById = findViewById(i10);
        if (findViewById instanceof MaterialButton) {
            this.f22875f = true;
            ((MaterialButton) findViewById).setChecked(z10);
            this.f22875f = false;
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i10 = this.f22878i;
        if (i10 != -1) {
            q(Collections.singleton(Integer.valueOf(i10)));
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i10;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        J.d O02 = J.d.O0(accessibilityNodeInfo);
        int visibleButtonCount = getVisibleButtonCount();
        if (l()) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        O02.j0(d.e.b(1, visibleButtonCount, false, i10));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        s();
        c();
        super.onMeasure(i10, i11);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f22870a.remove(indexOfChild);
        }
        s();
        c();
    }

    public final void q(Set<Integer> set) {
        Set<Integer> set2 = this.f22879j;
        this.f22879j = new HashSet(set);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id = h(i10).getId();
            o(id, set.contains(Integer.valueOf(id)));
            if (set2.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                g(id, set.contains(Integer.valueOf(id)));
            }
        }
        invalidate();
    }

    public final void r() {
        TreeMap treeMap = new TreeMap(this.f22873d);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            treeMap.put(h(i10), Integer.valueOf(i10));
        }
        this.f22874e = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    public void s() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i10 = 0; i10 < childCount; i10++) {
            MaterialButton h10 = h(i10);
            if (h10.getVisibility() != 8) {
                n.b v10 = h10.getShapeAppearanceModel().v();
                p(v10, j(i10, firstVisibleChildIndex, lastVisibleChildIndex));
                h10.setShapeAppearanceModel(v10.m());
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            h(i10).setEnabled(z10);
        }
    }

    public void setSelectionRequired(boolean z10) {
        this.f22877h = z10;
    }

    public void setSingleSelection(boolean z10) {
        if (this.f22876g != z10) {
            this.f22876g = z10;
            f();
        }
        t();
    }

    public final void t() {
        Class cls;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            if (this.f22876g) {
                cls = RadioButton.class;
            } else {
                cls = ToggleButton.class;
            }
            h(i10).setA11yClassName(cls.getName());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialButtonToggleGroup(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.button.MaterialButtonToggleGroup.f22869k
            android.content.Context r7 = B4.a.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r6.f22870a = r7
            com.google.android.material.button.MaterialButtonToggleGroup$e r7 = new com.google.android.material.button.MaterialButtonToggleGroup$e
            r0 = 0
            r7.<init>(r6, r0)
            r6.f22871b = r7
            java.util.LinkedHashSet r7 = new java.util.LinkedHashSet
            r7.<init>()
            r6.f22872c = r7
            com.google.android.material.button.MaterialButtonToggleGroup$a r7 = new com.google.android.material.button.MaterialButtonToggleGroup$a
            r7.<init>()
            r6.f22873d = r7
            r7 = 0
            r6.f22875f = r7
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r6.f22879j = r0
            android.content.Context r0 = r6.getContext()
            int[] r2 = e4.m.f31323Z4
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r9 = e4.m.f31367d5
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setSingleSelection(r9)
            int r9 = e4.m.f31345b5
            r0 = -1
            int r9 = r8.getResourceId(r9, r0)
            r6.f22878i = r9
            int r9 = e4.m.f31356c5
            boolean r7 = r8.getBoolean(r9, r7)
            r6.f22877h = r7
            r7 = 1
            r6.setChildrenDrawingOrderEnabled(r7)
            int r9 = e4.m.f31334a5
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setEnabled(r9)
            r8.recycle()
            androidx.core.view.K.t0(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonToggleGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setSingleSelection(int i10) {
        setSingleSelection(getResources().getBoolean(i10));
    }
}
