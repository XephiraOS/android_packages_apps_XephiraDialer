package com.google.android.material.checkbox;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.K;
import com.google.android.material.internal.ViewUtils;
import e4.C0977c;
import e4.g;
import e4.k;
import e4.l;
import e4.m;
import f.C0991a;
import j0.AbstractC1152b;
import j0.C1153c;
import java.util.Iterator;
import java.util.LinkedHashSet;
import l4.C1292a;
import n4.C1370a;

/* loaded from: classes3.dex */
public class MaterialCheckBox extends AppCompatCheckBox {

    /* renamed from: B, reason: collision with root package name */
    public static final int[] f22976B;

    /* renamed from: C, reason: collision with root package name */
    public static final int[][] f22977C;

    /* renamed from: D, reason: collision with root package name */
    public static final int f22978D;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<c> f22980a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<b> f22981b;

    /* renamed from: c, reason: collision with root package name */
    public ColorStateList f22982c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f22983d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f22984e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f22985f;

    /* renamed from: g, reason: collision with root package name */
    public CharSequence f22986g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f22987h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f22988i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f22989j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f22990k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f22991l;

    /* renamed from: m, reason: collision with root package name */
    public PorterDuff.Mode f22992m;

    /* renamed from: n, reason: collision with root package name */
    public int f22993n;

    /* renamed from: o, reason: collision with root package name */
    public int[] f22994o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f22995p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f22996q;

    /* renamed from: r, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f22997r;

    /* renamed from: x, reason: collision with root package name */
    public final C1153c f22998x;

    /* renamed from: y, reason: collision with root package name */
    public final AbstractC1152b f22999y;

    /* renamed from: z, reason: collision with root package name */
    public static final int f22979z = l.f31003E;

    /* renamed from: A, reason: collision with root package name */
    public static final int[] f22975A = {C0977c.f30692s0};

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f23000a;

        /* loaded from: classes3.dex */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        public final String b() {
            int i10 = this.f23000a;
            if (i10 != 1) {
                if (i10 != 2) {
                    return "unchecked";
                }
                return "indeterminate";
            }
            return "checked";
        }

        public String toString() {
            return "MaterialCheckBox.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " CheckedState=" + b() + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Integer.valueOf(this.f23000a));
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f23000a = ((Integer) parcel.readValue(getClass().getClassLoader())).intValue();
        }
    }

    /* loaded from: classes3.dex */
    public class a extends AbstractC1152b {
        public a() {
        }

        @Override // j0.AbstractC1152b
        public void b(Drawable drawable) {
            super.b(drawable);
            ColorStateList colorStateList = MaterialCheckBox.this.f22990k;
            if (colorStateList != null) {
                C.a.o(drawable, colorStateList);
            }
        }

        @Override // j0.AbstractC1152b
        public void c(Drawable drawable) {
            super.c(drawable);
            MaterialCheckBox materialCheckBox = MaterialCheckBox.this;
            ColorStateList colorStateList = materialCheckBox.f22990k;
            if (colorStateList != null) {
                C.a.n(drawable, colorStateList.getColorForState(materialCheckBox.f22994o, MaterialCheckBox.this.f22990k.getDefaultColor()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(MaterialCheckBox materialCheckBox, int i10);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(MaterialCheckBox materialCheckBox, boolean z10);
    }

    static {
        int i10 = C0977c.f30690r0;
        f22976B = new int[]{i10};
        f22977C = new int[][]{new int[]{16842910, i10}, new int[]{16842910, R.attr.state_checked}, new int[]{16842910, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
        f22978D = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30671i);
    }

    private String getButtonStateDescription() {
        int i10 = this.f22993n;
        if (i10 == 1) {
            return getResources().getString(k.f30989q);
        }
        if (i10 == 0) {
            return getResources().getString(k.f30991s);
        }
        return getResources().getString(k.f30990r);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f22982c == null) {
            int[][] iArr = f22977C;
            int[] iArr2 = new int[iArr.length];
            int d10 = C1292a.d(this, C0977c.f30681n);
            int d11 = C1292a.d(this, C0977c.f30685p);
            int d12 = C1292a.d(this, C0977c.f30697v);
            int d13 = C1292a.d(this, C0977c.f30689r);
            iArr2[0] = C1292a.j(d12, d11, 1.0f);
            iArr2[1] = C1292a.j(d12, d10, 1.0f);
            iArr2[2] = C1292a.j(d12, d13, 0.54f);
            iArr2[3] = C1292a.j(d12, d13, 0.38f);
            iArr2[4] = C1292a.j(d12, d13, 0.38f);
            this.f22982c = new ColorStateList(iArr, iArr2);
        }
        return this.f22982c;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f22990k;
        if (colorStateList != null) {
            return colorStateList;
        }
        if (super.getButtonTintList() != null) {
            return super.getButtonTintList();
        }
        return getSupportButtonTintList();
    }

    public final boolean b(K k10) {
        int n10 = k10.n(m.f31171L5, 0);
        int n11 = k10.n(m.f31182M5, 0);
        if (n10 != f22978D || n11 != 0) {
            return false;
        }
        return true;
    }

    public boolean c() {
        return this.f22985f;
    }

    public final void d() {
        this.f22987h = C1370a.d(this.f22987h, this.f22990k, androidx.core.widget.c.c(this));
        this.f22988i = C1370a.d(this.f22988i, this.f22991l, this.f22992m);
        f();
        g();
        super.setButtonDrawable(C1370a.a(this.f22987h, this.f22988i));
        refreshDrawableState();
    }

    public final void e() {
        if (this.f22996q == null) {
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public final void f() {
        C1153c c1153c;
        if (!this.f22989j) {
            return;
        }
        C1153c c1153c2 = this.f22998x;
        if (c1153c2 != null) {
            c1153c2.f(this.f22999y);
            this.f22998x.b(this.f22999y);
        }
        Drawable drawable = this.f22987h;
        if ((drawable instanceof AnimatedStateListDrawable) && (c1153c = this.f22998x) != null) {
            int i10 = g.f30866b;
            int i11 = g.f30905u0;
            ((AnimatedStateListDrawable) drawable).addTransition(i10, i11, c1153c, false);
            ((AnimatedStateListDrawable) this.f22987h).addTransition(g.f30882j, i11, this.f22998x, false);
        }
    }

    public final void g() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable = this.f22987h;
        if (drawable != null && (colorStateList2 = this.f22990k) != null) {
            C.a.o(drawable, colorStateList2);
        }
        Drawable drawable2 = this.f22988i;
        if (drawable2 != null && (colorStateList = this.f22991l) != null) {
            C.a.o(drawable2, colorStateList);
        }
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.f22987h;
    }

    public Drawable getButtonIconDrawable() {
        return this.f22988i;
    }

    public ColorStateList getButtonIconTintList() {
        return this.f22991l;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f22992m;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.f22990k;
    }

    public int getCheckedState() {
        return this.f22993n;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f22986g;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        if (this.f22993n == 1) {
            return true;
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f22983d && this.f22990k == null && this.f22991l == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(onCreateDrawableState, f22975A);
        }
        if (c()) {
            View.mergeDrawableStates(onCreateDrawableState, f22976B);
        }
        this.f22994o = C1370a.f(onCreateDrawableState);
        h();
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable a10;
        int i10;
        if (this.f22984e && TextUtils.isEmpty(getText()) && (a10 = androidx.core.widget.c.a(this)) != null) {
            if (ViewUtils.isLayoutRtl(this)) {
                i10 = -1;
            } else {
                i10 = 1;
            }
            int width = ((getWidth() - a10.getIntrinsicWidth()) / 2) * i10;
            int save = canvas.save();
            canvas.translate(width, 0.0f);
            super.onDraw(canvas);
            canvas.restoreToCount(save);
            if (getBackground() != null) {
                Rect bounds = a10.getBounds();
                C.a.l(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
                return;
            }
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && c()) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f22986g));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCheckedState(savedState.f23000a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f23000a = getCheckedState();
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(int i10) {
        setButtonDrawable(C0991a.b(getContext(), i10));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.f22988i = drawable;
        d();
    }

    public void setButtonIconDrawableResource(int i10) {
        setButtonIconDrawable(C0991a.b(getContext(), i10));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.f22991l == colorStateList) {
            return;
        }
        this.f22991l = colorStateList;
        d();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.f22992m == mode) {
            return;
        }
        this.f22992m = mode;
        d();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.f22990k == colorStateList) {
            return;
        }
        this.f22990k = colorStateList;
        d();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        d();
    }

    public void setCenterIfNoTextEnabled(boolean z10) {
        this.f22984e = z10;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        setCheckedState(z10 ? 1 : 0);
    }

    public void setCheckedState(int i10) {
        boolean z10;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f22993n != i10) {
            this.f22993n = i10;
            if (i10 == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            super.setChecked(z10);
            refreshDrawableState();
            e();
            if (this.f22995p) {
                return;
            }
            this.f22995p = true;
            LinkedHashSet<b> linkedHashSet = this.f22981b;
            if (linkedHashSet != null) {
                Iterator<b> it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    it.next().a(this, this.f22993n);
                }
            }
            if (this.f22993n != 2 && (onCheckedChangeListener = this.f22997r) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            AutofillManager autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class);
            if (autofillManager != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.f22995p = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        h();
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f22986g = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i10) {
        CharSequence charSequence;
        if (i10 != 0) {
            charSequence = getResources().getText(i10);
        } else {
            charSequence = null;
        }
        setErrorAccessibilityLabel(charSequence);
    }

    public void setErrorShown(boolean z10) {
        if (this.f22985f == z10) {
            return;
        }
        this.f22985f = z10;
        refreshDrawableState();
        Iterator<c> it = this.f22980a.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.f22985f);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f22997r = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.f22996q = charSequence;
        if (charSequence == null) {
            e();
        } else {
            super.setStateDescription(charSequence);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f22983d = z10;
        if (z10) {
            androidx.core.widget.c.d(this, getMaterialThemeColorsTintList());
        } else {
            androidx.core.widget.c.d(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialCheckBox(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r4 = com.google.android.material.checkbox.MaterialCheckBox.f22979z
            android.content.Context r9 = B4.a.c(r9, r10, r11, r4)
            r8.<init>(r9, r10, r11)
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.f22980a = r9
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.f22981b = r9
            android.content.Context r9 = r8.getContext()
            int r0 = e4.f.f30831h
            j0.c r9 = j0.C1153c.a(r9, r0)
            r8.f22998x = r9
            com.google.android.material.checkbox.MaterialCheckBox$a r9 = new com.google.android.material.checkbox.MaterialCheckBox$a
            r9.<init>()
            r8.f22999y = r9
            android.content.Context r9 = r8.getContext()
            android.graphics.drawable.Drawable r0 = androidx.core.widget.c.a(r8)
            r8.f22987h = r0
            android.content.res.ColorStateList r0 = r8.getSuperButtonTintList()
            r8.f22990k = r0
            r6 = 0
            r8.setSupportButtonTintList(r6)
            int[] r2 = e4.m.f31160K5
            r7 = 0
            int[] r5 = new int[r7]
            r0 = r9
            r1 = r10
            r3 = r11
            androidx.appcompat.widget.K r10 = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r11 = e4.m.f31193N5
            android.graphics.drawable.Drawable r11 = r10.g(r11)
            r8.f22988i = r11
            android.graphics.drawable.Drawable r11 = r8.f22987h
            r0 = 1
            if (r11 == 0) goto L7c
            boolean r11 = com.google.android.material.internal.ThemeEnforcement.isMaterial3Theme(r9)
            if (r11 == 0) goto L7c
            boolean r11 = r8.b(r10)
            if (r11 == 0) goto L7c
            super.setButtonDrawable(r6)
            int r11 = e4.f.f30830g
            android.graphics.drawable.Drawable r11 = f.C0991a.b(r9, r11)
            r8.f22987h = r11
            r8.f22989j = r0
            android.graphics.drawable.Drawable r11 = r8.f22988i
            if (r11 != 0) goto L7c
            int r11 = e4.f.f30832i
            android.graphics.drawable.Drawable r11 = f.C0991a.b(r9, r11)
            r8.f22988i = r11
        L7c:
            int r11 = e4.m.f31204O5
            android.content.res.ColorStateList r9 = u4.C1607c.b(r9, r10, r11)
            r8.f22991l = r9
            int r9 = e4.m.f31215P5
            r11 = -1
            int r9 = r10.k(r9, r11)
            android.graphics.PorterDuff$Mode r11 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r9 = com.google.android.material.internal.ViewUtils.parseTintMode(r9, r11)
            r8.f22992m = r9
            int r9 = e4.m.f31270U5
            boolean r9 = r10.a(r9, r7)
            r8.f22983d = r9
            int r9 = e4.m.f31226Q5
            boolean r9 = r10.a(r9, r0)
            r8.f22984e = r9
            int r9 = e4.m.f31259T5
            boolean r9 = r10.a(r9, r7)
            r8.f22985f = r9
            int r9 = e4.m.f31248S5
            java.lang.CharSequence r9 = r10.p(r9)
            r8.f22986g = r9
            int r9 = e4.m.f31237R5
            boolean r11 = r10.s(r9)
            if (r11 == 0) goto Lc2
            int r9 = r10.k(r9, r7)
            r8.setCheckedState(r9)
        Lc2:
            r10.y()
            r8.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.checkbox.MaterialCheckBox.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.f22987h = drawable;
        this.f22989j = false;
        d();
    }

    public final void h() {
    }
}
