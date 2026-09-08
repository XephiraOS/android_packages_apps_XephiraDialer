package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.K;
import androidx.core.widget.k;
import androidx.customview.view.AbsSavedState;
import e4.C0977c;
import e4.l;
import f.C0991a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import x4.j;
import x4.n;
import x4.r;

/* loaded from: classes3.dex */
public class MaterialButton extends AppCompatButton implements Checkable, r {

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f22851o = {R.attr.state_checkable};

    /* renamed from: p, reason: collision with root package name */
    public static final int[] f22852p = {R.attr.state_checked};

    /* renamed from: q, reason: collision with root package name */
    public static final int f22853q = l.f31043z;

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.material.button.a f22854a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<a> f22855b;

    /* renamed from: c, reason: collision with root package name */
    public b f22856c;

    /* renamed from: d, reason: collision with root package name */
    public PorterDuff.Mode f22857d;

    /* renamed from: e, reason: collision with root package name */
    public ColorStateList f22858e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f22859f;

    /* renamed from: g, reason: collision with root package name */
    public String f22860g;

    /* renamed from: h, reason: collision with root package name */
    public int f22861h;

    /* renamed from: i, reason: collision with root package name */
    public int f22862i;

    /* renamed from: j, reason: collision with root package name */
    public int f22863j;

    /* renamed from: k, reason: collision with root package name */
    public int f22864k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f22865l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f22866m;

    /* renamed from: n, reason: collision with root package name */
    public int f22867n;

    /* loaded from: classes3.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public boolean f22868a;

        /* loaded from: classes3.dex */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public final void readFromParcel(Parcel parcel) {
            boolean z10 = true;
            if (parcel.readInt() != 1) {
                z10 = false;
            }
            this.f22868a = z10;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f22868a ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            readFromParcel(parcel);
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a(MaterialButton materialButton, boolean z10);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(MaterialButton materialButton, boolean z10);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30636H);
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        if (textAlignment != 1) {
            if (textAlignment != 6 && textAlignment != 3) {
                if (textAlignment != 4) {
                    return Layout.Alignment.ALIGN_NORMAL;
                }
                return Layout.Alignment.ALIGN_CENTER;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        if (gravity != 1) {
            if (gravity != 5 && gravity != 8388613) {
                return Layout.Alignment.ALIGN_NORMAL;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float f10 = 0.0f;
        for (int i10 = 0; i10 < lineCount; i10++) {
            f10 = Math.max(f10, getLayout().getLineWidth(i10));
        }
        return (int) Math.ceil(f10);
    }

    private boolean isLayoutRTL() {
        if (K.v(this) == 1) {
            return true;
        }
        return false;
    }

    public boolean a() {
        com.google.android.material.button.a aVar = this.f22854a;
        if (aVar != null && aVar.p()) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        int i10 = this.f22867n;
        if (i10 != 3 && i10 != 4) {
            return false;
        }
        return true;
    }

    public final boolean d() {
        int i10 = this.f22867n;
        if (i10 == 1 || i10 == 2) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        int i10 = this.f22867n;
        if (i10 != 16 && i10 != 32) {
            return false;
        }
        return true;
    }

    public final boolean f() {
        com.google.android.material.button.a aVar = this.f22854a;
        if (aVar != null && !aVar.o()) {
            return true;
        }
        return false;
    }

    public final void g() {
        if (d()) {
            k.i(this, this.f22859f, null, null, null);
        } else if (b()) {
            k.i(this, null, null, this.f22859f, null);
        } else if (e()) {
            k.i(this, null, this.f22859f, null, null);
        }
    }

    public String getA11yClassName() {
        Class cls;
        if (!TextUtils.isEmpty(this.f22860g)) {
            return this.f22860g;
        }
        if (a()) {
            cls = CompoundButton.class;
        } else {
            cls = Button.class;
        }
        return cls.getName();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (f()) {
            return this.f22854a.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f22859f;
    }

    public int getIconGravity() {
        return this.f22867n;
    }

    public int getIconPadding() {
        return this.f22864k;
    }

    public int getIconSize() {
        return this.f22861h;
    }

    public ColorStateList getIconTint() {
        return this.f22858e;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f22857d;
    }

    public int getInsetBottom() {
        return this.f22854a.c();
    }

    public int getInsetTop() {
        return this.f22854a.d();
    }

    public ColorStateList getRippleColor() {
        if (f()) {
            return this.f22854a.h();
        }
        return null;
    }

    public n getShapeAppearanceModel() {
        if (f()) {
            return this.f22854a.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (f()) {
            return this.f22854a.j();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (f()) {
            return this.f22854a.k();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public ColorStateList getSupportBackgroundTintList() {
        if (f()) {
            return this.f22854a.l();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (f()) {
            return this.f22854a.m();
        }
        return super.getSupportBackgroundTintMode();
    }

    public final void h(boolean z10) {
        Drawable drawable = this.f22859f;
        if (drawable != null) {
            Drawable mutate = C.a.r(drawable).mutate();
            this.f22859f = mutate;
            C.a.o(mutate, this.f22858e);
            PorterDuff.Mode mode = this.f22857d;
            if (mode != null) {
                C.a.p(this.f22859f, mode);
            }
            int i10 = this.f22861h;
            if (i10 == 0) {
                i10 = this.f22859f.getIntrinsicWidth();
            }
            int i11 = this.f22861h;
            if (i11 == 0) {
                i11 = this.f22859f.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f22859f;
            int i12 = this.f22862i;
            int i13 = this.f22863j;
            drawable2.setBounds(i12, i13, i10 + i12, i11 + i13);
            this.f22859f.setVisible(true, z10);
        }
        if (z10) {
            g();
            return;
        }
        Drawable[] a10 = k.a(this);
        Drawable drawable3 = a10[0];
        Drawable drawable4 = a10[1];
        Drawable drawable5 = a10[2];
        if ((d() && drawable3 != this.f22859f) || ((b() && drawable5 != this.f22859f) || (e() && drawable4 != this.f22859f))) {
            g();
        }
    }

    public final void i(int i10, int i11) {
        if (this.f22859f != null && getLayout() != null) {
            if (!d() && !b()) {
                if (e()) {
                    this.f22862i = 0;
                    if (this.f22867n == 16) {
                        this.f22863j = 0;
                        h(false);
                        return;
                    }
                    int i12 = this.f22861h;
                    if (i12 == 0) {
                        i12 = this.f22859f.getIntrinsicHeight();
                    }
                    int max = Math.max(0, (((((i11 - getTextHeight()) - getPaddingTop()) - i12) - this.f22864k) - getPaddingBottom()) / 2);
                    if (this.f22863j != max) {
                        this.f22863j = max;
                        h(false);
                        return;
                    }
                    return;
                }
                return;
            }
            this.f22863j = 0;
            Layout.Alignment actualTextAlignment = getActualTextAlignment();
            int i13 = this.f22867n;
            boolean z10 = true;
            if (i13 != 1 && i13 != 3 && ((i13 != 2 || actualTextAlignment != Layout.Alignment.ALIGN_NORMAL) && (i13 != 4 || actualTextAlignment != Layout.Alignment.ALIGN_OPPOSITE))) {
                int i14 = this.f22861h;
                if (i14 == 0) {
                    i14 = this.f22859f.getIntrinsicWidth();
                }
                int textLayoutWidth = ((((i10 - getTextLayoutWidth()) - K.z(this)) - i14) - this.f22864k) - K.A(this);
                if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
                    textLayoutWidth /= 2;
                }
                boolean isLayoutRTL = isLayoutRTL();
                if (this.f22867n != 4) {
                    z10 = false;
                }
                if (isLayoutRTL != z10) {
                    textLayoutWidth = -textLayoutWidth;
                }
                if (this.f22862i != textLayoutWidth) {
                    this.f22862i = textLayoutWidth;
                    h(false);
                    return;
                }
                return;
            }
            this.f22862i = 0;
            h(false);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f22865l;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (f()) {
            j.f(this, this.f22854a.f());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (a()) {
            View.mergeDrawableStates(onCreateDrawableState, f22851o);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f22852p);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f22868a);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f22868a = this.f22865l;
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f22854a.q()) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f22859f != null) {
            if (this.f22859f.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setA11yClassName(String str) {
        this.f22860g = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        if (f()) {
            this.f22854a.s(i10);
        } else {
            super.setBackgroundColor(i10);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (f()) {
            if (drawable != getBackground()) {
                Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                this.f22854a.t();
                super.setBackgroundDrawable(drawable);
                return;
            }
            getBackground().setState(drawable.getState());
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = C0991a.b(getContext(), i10);
        } else {
            drawable = null;
        }
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z10) {
        if (f()) {
            this.f22854a.u(z10);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (a() && isEnabled() && this.f22865l != z10) {
            this.f22865l = z10;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                ((MaterialButtonToggleGroup) getParent()).m(this, this.f22865l);
            }
            if (this.f22866m) {
                return;
            }
            this.f22866m = true;
            Iterator<a> it = this.f22855b.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.f22865l);
            }
            this.f22866m = false;
        }
    }

    public void setCornerRadius(int i10) {
        if (f()) {
            this.f22854a.v(i10);
        }
    }

    public void setCornerRadiusResource(int i10) {
        if (f()) {
            setCornerRadius(getResources().getDimensionPixelSize(i10));
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        if (f()) {
            this.f22854a.f().setElevation(f10);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f22859f != drawable) {
            this.f22859f = drawable;
            h(true);
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i10) {
        if (this.f22867n != i10) {
            this.f22867n = i10;
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i10) {
        if (this.f22864k != i10) {
            this.f22864k = i10;
            setCompoundDrawablePadding(i10);
        }
    }

    public void setIconResource(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = C0991a.b(getContext(), i10);
        } else {
            drawable = null;
        }
        setIcon(drawable);
    }

    public void setIconSize(int i10) {
        if (i10 >= 0) {
            if (this.f22861h != i10) {
                this.f22861h = i10;
                h(true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f22858e != colorStateList) {
            this.f22858e = colorStateList;
            h(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f22857d != mode) {
            this.f22857d = mode;
            h(false);
        }
    }

    public void setIconTintResource(int i10) {
        setIconTint(C0991a.a(getContext(), i10));
    }

    public void setInsetBottom(int i10) {
        this.f22854a.w(i10);
    }

    public void setInsetTop(int i10) {
        this.f22854a.x(i10);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(b bVar) {
        this.f22856c = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        b bVar = this.f22856c;
        if (bVar != null) {
            bVar.a(this, z10);
        }
        super.setPressed(z10);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (f()) {
            this.f22854a.y(colorStateList);
        }
    }

    public void setRippleColorResource(int i10) {
        if (f()) {
            setRippleColor(C0991a.a(getContext(), i10));
        }
    }

    @Override // x4.r
    public void setShapeAppearanceModel(n nVar) {
        if (f()) {
            this.f22854a.z(nVar);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean z10) {
        if (f()) {
            this.f22854a.A(z10);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (f()) {
            this.f22854a.B(colorStateList);
        }
    }

    public void setStrokeColorResource(int i10) {
        if (f()) {
            setStrokeColor(C0991a.a(getContext(), i10));
        }
    }

    public void setStrokeWidth(int i10) {
        if (f()) {
            this.f22854a.C(i10);
        }
    }

    public void setStrokeWidthResource(int i10) {
        if (f()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i10));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (f()) {
            this.f22854a.D(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (f()) {
            this.f22854a.E(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i10) {
        super.setTextAlignment(i10);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z10) {
        this.f22854a.F(z10);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f22865l);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialButton(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r6 = com.google.android.material.button.MaterialButton.f22853q
            android.content.Context r9 = B4.a.c(r9, r10, r11, r6)
            r8.<init>(r9, r10, r11)
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.f22855b = r9
            r9 = 0
            r8.f22865l = r9
            r8.f22866m = r9
            android.content.Context r7 = r8.getContext()
            int[] r2 = e4.m.f31093E4
            int[] r5 = new int[r9]
            r0 = r7
            r1 = r10
            r3 = r11
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r1 = e4.m.f31236R4
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f22864k = r1
            int r1 = e4.m.f31269U4
            r2 = -1
            int r1 = r0.getInt(r1, r2)
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r1 = com.google.android.material.internal.ViewUtils.parseTintMode(r1, r2)
            r8.f22857d = r1
            android.content.Context r1 = r8.getContext()
            int r2 = e4.m.f31258T4
            android.content.res.ColorStateList r1 = u4.C1607c.a(r1, r0, r2)
            r8.f22858e = r1
            android.content.Context r1 = r8.getContext()
            int r2 = e4.m.f31214P4
            android.graphics.drawable.Drawable r1 = u4.C1607c.e(r1, r0, r2)
            r8.f22859f = r1
            int r1 = e4.m.f31225Q4
            r2 = 1
            int r1 = r0.getInteger(r1, r2)
            r8.f22867n = r1
            int r1 = e4.m.f31247S4
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f22861h = r1
            x4.n$b r10 = x4.n.e(r7, r10, r11, r6)
            x4.n r10 = r10.m()
            com.google.android.material.button.a r11 = new com.google.android.material.button.a
            r11.<init>(r8, r10)
            r8.f22854a = r11
            r11.r(r0)
            r0.recycle()
            int r10 = r8.f22864k
            r8.setCompoundDrawablePadding(r10)
            android.graphics.drawable.Drawable r10 = r8.f22859f
            if (r10 == 0) goto L84
            r9 = r2
        L84:
            r8.h(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
