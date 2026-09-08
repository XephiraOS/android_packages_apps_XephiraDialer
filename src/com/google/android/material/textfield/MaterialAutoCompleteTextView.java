package com.google.android.material.textfield;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.view.K;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import e4.C0977c;
import e4.C0979e;
import java.util.List;
import l4.C1292a;
import u4.C1607c;

/* loaded from: classes3.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {

    /* renamed from: a, reason: collision with root package name */
    public final ListPopupWindow f23956a;

    /* renamed from: b, reason: collision with root package name */
    public final AccessibilityManager f23957b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f23958c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23959d;

    /* renamed from: e, reason: collision with root package name */
    public final float f23960e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f23961f;

    /* renamed from: g, reason: collision with root package name */
    public int f23962g;

    /* renamed from: h, reason: collision with root package name */
    public ColorStateList f23963h;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            Object item;
            MaterialAutoCompleteTextView materialAutoCompleteTextView = MaterialAutoCompleteTextView.this;
            if (i10 < 0) {
                item = materialAutoCompleteTextView.f23956a.q();
            } else {
                item = materialAutoCompleteTextView.getAdapter().getItem(i10);
            }
            MaterialAutoCompleteTextView.this.k(item);
            AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i10 < 0) {
                    view = MaterialAutoCompleteTextView.this.f23956a.t();
                    i10 = MaterialAutoCompleteTextView.this.f23956a.s();
                    j10 = MaterialAutoCompleteTextView.this.f23956a.r();
                }
                onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.f23956a.getListView(), view, i10, j10);
            }
            MaterialAutoCompleteTextView.this.f23956a.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class b<T> extends ArrayAdapter<String> {

        /* renamed from: a, reason: collision with root package name */
        public ColorStateList f23965a;

        /* renamed from: b, reason: collision with root package name */
        public ColorStateList f23966b;

        public b(Context context, int i10, String[] strArr) {
            super(context, i10, strArr);
            f();
        }

        public final ColorStateList a() {
            if (c() && d()) {
                int[] iArr = {16843623, -16842919};
                int[] iArr2 = {16842913, -16842919};
                return new ColorStateList(new int[][]{iArr2, iArr, new int[0]}, new int[]{C1292a.i(MaterialAutoCompleteTextView.this.f23962g, MaterialAutoCompleteTextView.this.f23963h.getColorForState(iArr2, 0)), C1292a.i(MaterialAutoCompleteTextView.this.f23962g, MaterialAutoCompleteTextView.this.f23963h.getColorForState(iArr, 0)), MaterialAutoCompleteTextView.this.f23962g});
            }
            return null;
        }

        public final Drawable b() {
            if (!c()) {
                return null;
            }
            ColorDrawable colorDrawable = new ColorDrawable(MaterialAutoCompleteTextView.this.f23962g);
            if (this.f23966b != null) {
                C.a.o(colorDrawable, this.f23965a);
                return new RippleDrawable(this.f23966b, colorDrawable, null);
            }
            return colorDrawable;
        }

        public final boolean c() {
            if (MaterialAutoCompleteTextView.this.f23962g != 0) {
                return true;
            }
            return false;
        }

        public final boolean d() {
            if (MaterialAutoCompleteTextView.this.f23963h != null) {
                return true;
            }
            return false;
        }

        public final ColorStateList e() {
            if (!d()) {
                return null;
            }
            int[] iArr = {16842919};
            return new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{MaterialAutoCompleteTextView.this.f23963h.getColorForState(iArr, 0), 0});
        }

        public void f() {
            this.f23966b = e();
            this.f23965a = a();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            Drawable drawable;
            View view2 = super.getView(i10, view, viewGroup);
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                if (MaterialAutoCompleteTextView.this.getText().toString().contentEquals(textView.getText())) {
                    drawable = b();
                } else {
                    drawable = null;
                }
                K.n0(textView, drawable);
            }
            return view2;
        }
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30657b);
    }

    @Override // android.widget.AutoCompleteTextView
    public void dismissDropDown() {
        if (f()) {
            this.f23956a.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    public final TextInputLayout e() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public final boolean f() {
        if (!h() && !g()) {
            return false;
        }
        return true;
    }

    public final boolean g() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = this.f23957b;
        if (accessibilityManager != null && accessibilityManager.isEnabled() && (enabledAccessibilityServiceList = this.f23957b.getEnabledAccessibilityServiceList(16)) != null) {
            for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                if (accessibilityServiceInfo.getSettingsActivityName() != null && accessibilityServiceInfo.getSettingsActivityName().contains("SwitchAccess")) {
                    return true;
                }
            }
        }
        return false;
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.f23961f;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout e10 = e();
        if (e10 != null && e10.R()) {
            return e10.getHint();
        }
        return super.getHint();
    }

    public float getPopupElevation() {
        return this.f23960e;
    }

    public int getSimpleItemSelectedColor() {
        return this.f23962g;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f23963h;
    }

    public final boolean h() {
        AccessibilityManager accessibilityManager = this.f23957b;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            return true;
        }
        return false;
    }

    public final int i() {
        ListAdapter adapter = getAdapter();
        TextInputLayout e10 = e();
        int i10 = 0;
        if (adapter == null || e10 == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int min = Math.min(adapter.getCount(), Math.max(0, this.f23956a.s()) + 15);
        View view = null;
        int i11 = 0;
        for (int max = Math.max(0, min - 15); max < min; max++) {
            int itemViewType = adapter.getItemViewType(max);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = adapter.getView(max, view, e10);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i11 = Math.max(i11, view.getMeasuredWidth());
        }
        Drawable e11 = this.f23956a.e();
        if (e11 != null) {
            e11.getPadding(this.f23958c);
            Rect rect = this.f23958c;
            i11 += rect.left + rect.right;
        }
        return i11 + e10.getEndIconView().getMeasuredWidth();
    }

    public final void j() {
        TextInputLayout e10 = e();
        if (e10 != null) {
            e10.r0();
        }
    }

    public final <T extends ListAdapter & Filterable> void k(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout e10 = e();
        if (e10 != null && e10.R() && super.getHint() == null && ManufacturerUtils.isMeizuDevice()) {
            setHint("");
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f23956a.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), i()), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z10) {
        if (f()) {
            return;
        }
        super.onWindowFocusChanged(z10);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t10) {
        super.setAdapter(t10);
        this.f23956a.k(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        ListPopupWindow listPopupWindow = this.f23956a;
        if (listPopupWindow != null) {
            listPopupWindow.a(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i10) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i10));
    }

    public void setDropDownBackgroundTintList(ColorStateList colorStateList) {
        this.f23961f = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof x4.i) {
            ((x4.i) dropDownBackground).setFillColor(this.f23961f);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f23956a.I(getOnItemSelectedListener());
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i10) {
        super.setRawInputType(i10);
        j();
    }

    public void setSimpleItemSelectedColor(int i10) {
        this.f23962g = i10;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.f23963h = colorStateList;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItems(int i10) {
        setSimpleItems(getResources().getStringArray(i10));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        if (f()) {
            this.f23956a.show();
        } else {
            super.showDropDown();
        }
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet, int i10) {
        super(B4.a.c(context, attributeSet, i10, 0), attributeSet, i10);
        this.f23958c = new Rect();
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, e4.m.f31575w4, i10, e4.l.f31025h, new int[0]);
        int i11 = e4.m.f31586x4;
        if (obtainStyledAttributes.hasValue(i11) && obtainStyledAttributes.getInt(i11, 0) == 0) {
            setKeyListener(null);
        }
        this.f23959d = obtainStyledAttributes.getResourceId(e4.m.f31049A4, e4.i.f30939s);
        this.f23960e = obtainStyledAttributes.getDimensionPixelOffset(e4.m.f31597y4, C0979e.f30819x0);
        int i12 = e4.m.f31608z4;
        if (obtainStyledAttributes.hasValue(i12)) {
            this.f23961f = ColorStateList.valueOf(obtainStyledAttributes.getColor(i12, 0));
        }
        this.f23962g = obtainStyledAttributes.getColor(e4.m.f31060B4, 0);
        this.f23963h = C1607c.a(context2, obtainStyledAttributes, e4.m.f31071C4);
        this.f23957b = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.f23956a = listPopupWindow;
        listPopupWindow.F(true);
        listPopupWindow.y(this);
        listPopupWindow.E(2);
        listPopupWindow.k(getAdapter());
        listPopupWindow.H(new a());
        int i13 = e4.m.f31082D4;
        if (obtainStyledAttributes.hasValue(i13)) {
            setSimpleItems(obtainStyledAttributes.getResourceId(i13, 0));
        }
        obtainStyledAttributes.recycle();
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new b(getContext(), this.f23959d, strArr));
    }
}
