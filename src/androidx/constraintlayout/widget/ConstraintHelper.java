package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.b;
import java.util.Arrays;
import java.util.HashMap;
import v.C1616b;
import v.InterfaceC1615a;

/* loaded from: classes.dex */
public abstract class ConstraintHelper extends View {

    /* renamed from: a, reason: collision with root package name */
    public int[] f8635a;

    /* renamed from: b, reason: collision with root package name */
    public int f8636b;

    /* renamed from: c, reason: collision with root package name */
    public Context f8637c;

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC1615a f8638d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8639e;

    /* renamed from: f, reason: collision with root package name */
    public String f8640f;

    /* renamed from: g, reason: collision with root package name */
    public String f8641g;

    /* renamed from: h, reason: collision with root package name */
    public View[] f8642h;

    /* renamed from: i, reason: collision with root package name */
    public HashMap<Integer, String> f8643i;

    public ConstraintHelper(Context context) {
        super(context);
        this.f8635a = new int[32];
        this.f8639e = false;
        this.f8642h = null;
        this.f8643i = new HashMap<>();
        this.f8637c = context;
        n(null);
    }

    public final void e(String str) {
        if (str == null || str.length() == 0 || this.f8637c == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int l10 = l(trim);
        if (l10 != 0) {
            this.f8643i.put(Integer.valueOf(l10), trim);
            f(l10);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    public final void f(int i10) {
        if (i10 == getId()) {
            return;
        }
        int i11 = this.f8636b + 1;
        int[] iArr = this.f8635a;
        if (i11 > iArr.length) {
            this.f8635a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f8635a;
        int i12 = this.f8636b;
        iArr2[i12] = i10;
        this.f8636b = i12 + 1;
    }

    public final void g(String str) {
        ConstraintLayout constraintLayout;
        if (str == null || str.length() == 0 || this.f8637c == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout) getParent();
        } else {
            constraintLayout = null;
        }
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.LayoutParams) && trim.equals(((ConstraintLayout.LayoutParams) layoutParams).constraintTag)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    f(childAt.getId());
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f8635a, this.f8636b);
    }

    public void h() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            i((ConstraintLayout) parent);
        }
    }

    public void i(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i10 = 0; i10 < this.f8636b; i10++) {
            View viewById = constraintLayout.getViewById(this.f8635a[i10]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    public final int[] j(View view, String str) {
        String[] split = str.split(",");
        view.getContext();
        int[] iArr = new int[split.length];
        int i10 = 0;
        for (String str2 : split) {
            int l10 = l(str2.trim());
            if (l10 != 0) {
                iArr[i10] = l10;
                i10++;
            }
        }
        if (i10 != split.length) {
            return Arrays.copyOf(iArr, i10);
        }
        return iArr;
    }

    public final int k(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String str2;
        if (str == null || constraintLayout == null || (resources = this.f8637c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            if (childAt.getId() != -1) {
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    str2 = null;
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public final int l(String str) {
        ConstraintLayout constraintLayout;
        if (getParent() instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout) getParent();
        } else {
            constraintLayout = null;
        }
        int i10 = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                i10 = ((Integer) designInformation).intValue();
            }
        }
        if (i10 == 0 && constraintLayout != null) {
            i10 = k(constraintLayout, str);
        }
        if (i10 == 0) {
            try {
                i10 = d.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        if (i10 == 0) {
            return this.f8637c.getResources().getIdentifier(str, "id", this.f8637c.getPackageName());
        }
        return i10;
    }

    public View[] m(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f8642h;
        if (viewArr == null || viewArr.length != this.f8636b) {
            this.f8642h = new View[this.f8636b];
        }
        for (int i10 = 0; i10 < this.f8636b; i10++) {
            this.f8642h[i10] = constraintLayout.getViewById(this.f8635a[i10]);
        }
        return this.f8642h;
    }

    public void n(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, e.f9028a1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == e.f9212t1) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f8640f = string;
                    setIds(string);
                } else if (index == e.f9221u1) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f8641g = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void o(b.a aVar, C1616b c1616b, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        b.C0106b c0106b = aVar.f8698d;
        int[] iArr = c0106b.f8737e0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = c0106b.f8739f0;
            if (str != null && str.length() > 0) {
                b.C0106b c0106b2 = aVar.f8698d;
                c0106b2.f8737e0 = j(this, c0106b2.f8739f0);
            }
        }
        c1616b.b();
        if (aVar.f8698d.f8737e0 != null) {
            int i10 = 0;
            while (true) {
                int[] iArr2 = aVar.f8698d.f8737e0;
                if (i10 < iArr2.length) {
                    ConstraintWidget constraintWidget = sparseArray.get(iArr2[i10]);
                    if (constraintWidget != null) {
                        c1616b.a(constraintWidget);
                    }
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f8640f;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f8641g;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f8639e) {
            super.onMeasure(i10, i11);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setIds(String str) {
        this.f8640f = str;
        if (str == null) {
            return;
        }
        int i10 = 0;
        this.f8636b = 0;
        while (true) {
            int indexOf = str.indexOf(44, i10);
            if (indexOf == -1) {
                e(str.substring(i10));
                return;
            } else {
                e(str.substring(i10, indexOf));
                i10 = indexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        this.f8641g = str;
        if (str == null) {
            return;
        }
        int i10 = 0;
        this.f8636b = 0;
        while (true) {
            int indexOf = str.indexOf(44, i10);
            if (indexOf == -1) {
                g(str.substring(i10));
                return;
            } else {
                g(str.substring(i10, indexOf));
                i10 = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f8640f = null;
        this.f8636b = 0;
        for (int i10 : iArr) {
            f(i10);
        }
    }

    @Override // android.view.View
    public void setTag(int i10, Object obj) {
        super.setTag(i10, obj);
        if (obj == null && this.f8640f == null) {
            f(i10);
        }
    }

    public void t(androidx.constraintlayout.solver.widgets.d dVar, InterfaceC1615a interfaceC1615a, SparseArray<ConstraintWidget> sparseArray) {
        interfaceC1615a.b();
        for (int i10 = 0; i10 < this.f8636b; i10++) {
            interfaceC1615a.a(sparseArray.get(this.f8635a[i10]));
        }
    }

    public void u(ConstraintLayout constraintLayout) {
        String str;
        int k10;
        if (isInEditMode()) {
            setIds(this.f8640f);
        }
        InterfaceC1615a interfaceC1615a = this.f8638d;
        if (interfaceC1615a == null) {
            return;
        }
        interfaceC1615a.b();
        for (int i10 = 0; i10 < this.f8636b; i10++) {
            int i11 = this.f8635a[i10];
            View viewById = constraintLayout.getViewById(i11);
            if (viewById == null && (k10 = k(constraintLayout, (str = this.f8643i.get(Integer.valueOf(i11))))) != 0) {
                this.f8635a[i10] = k10;
                this.f8643i.put(Integer.valueOf(k10), str);
                viewById = constraintLayout.getViewById(k10);
            }
            if (viewById != null) {
                this.f8638d.a(constraintLayout.getViewWidget(viewById));
            }
        }
        this.f8638d.c(constraintLayout.mLayoutWidget);
    }

    public void v() {
        if (this.f8638d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).widget = (ConstraintWidget) this.f8638d;
        }
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8635a = new int[32];
        this.f8639e = false;
        this.f8642h = null;
        this.f8643i = new HashMap<>();
        this.f8637c = context;
        n(attributeSet);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    public void q(ConstraintLayout constraintLayout) {
    }

    public void r(ConstraintLayout constraintLayout) {
    }

    public void s(ConstraintLayout constraintLayout) {
    }

    public void p(ConstraintWidget constraintWidget, boolean z10) {
    }
}
