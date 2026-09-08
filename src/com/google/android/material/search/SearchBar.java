package com.google.android.material.search;

import J.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.C0458m;
import androidx.core.view.K;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.ToolbarUtils;
import e4.C0977c;
import e4.C0979e;
import l4.C1292a;

/* loaded from: classes3.dex */
public class SearchBar extends Toolbar {

    /* renamed from: p, reason: collision with root package name */
    public static final int f23547p = e4.l.f31038u;

    /* renamed from: a, reason: collision with root package name */
    public final TextView f23548a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f23549b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f23550c;

    /* renamed from: d, reason: collision with root package name */
    public final b f23551d;

    /* renamed from: e, reason: collision with root package name */
    public final Drawable f23552e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f23553f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f23554g;

    /* renamed from: h, reason: collision with root package name */
    public View f23555h;

    /* renamed from: i, reason: collision with root package name */
    public Integer f23556i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f23557j;

    /* renamed from: k, reason: collision with root package name */
    public int f23558k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f23559l;

    /* renamed from: m, reason: collision with root package name */
    public x4.i f23560m;

    /* renamed from: n, reason: collision with root package name */
    public final AccessibilityManager f23561n;

    /* renamed from: o, reason: collision with root package name */
    public final c.a f23562o;

    /* loaded from: classes3.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public String f23563a;

        /* loaded from: classes3.dex */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
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

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f23563a);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f23563a = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            J.c.a(SearchBar.this.f23561n, SearchBar.this.f23562o);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            J.c.c(SearchBar.this.f23561n, SearchBar.this.f23562o);
        }
    }

    public SearchBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30644P);
    }

    private Drawable maybeTintNavigationIcon(Drawable drawable) {
        int i10;
        int d10;
        if (this.f23553f && drawable != null) {
            Integer num = this.f23556i;
            if (num != null) {
                d10 = num.intValue();
            } else {
                if (drawable == this.f23552e) {
                    i10 = C0977c.f30691s;
                } else {
                    i10 = C0977c.f30689r;
                }
                d10 = C1292a.d(this, i10);
            }
            Drawable r10 = C.a.r(drawable.mutate());
            C.a.n(r10, d10);
            return r10;
        }
        return drawable;
    }

    private void setNavigationIconDecorative(boolean z10) {
        Drawable drawable;
        ImageButton navigationIconButton = ToolbarUtils.getNavigationIconButton(this);
        if (navigationIconButton == null) {
            return;
        }
        navigationIconButton.setClickable(!z10);
        navigationIconButton.setFocusable(!z10);
        Drawable background = navigationIconButton.getBackground();
        if (background != null) {
            this.f23557j = background;
        }
        if (z10) {
            drawable = null;
        } else {
            drawable = this.f23557j;
        }
        navigationIconButton.setBackgroundDrawable(drawable);
        m();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (this.f23549b && this.f23555h == null && !(view instanceof ActionMenuView)) {
            this.f23555h = view;
            view.setAlpha(0.0f);
        }
        super.addView(view, i10, layoutParams);
    }

    public final int d(int i10, int i11) {
        if (i10 == 0) {
            return i11;
        }
        return i10;
    }

    public final void e(x4.n nVar, int i10, float f10, float f11, int i11) {
        x4.i iVar = new x4.i(nVar);
        this.f23560m = iVar;
        iVar.initializeElevationOverlay(getContext());
        this.f23560m.setElevation(f10);
        if (f11 >= 0.0f) {
            this.f23560m.setStroke(f11, i11);
        }
        int d10 = C1292a.d(this, C0977c.f30683o);
        this.f23560m.setFillColor(ColorStateList.valueOf(i10));
        ColorStateList valueOf = ColorStateList.valueOf(d10);
        x4.i iVar2 = this.f23560m;
        K.n0(this, new RippleDrawable(valueOf, iVar2, iVar2));
    }

    public final void f() {
        Drawable navigationIcon;
        if (getNavigationIcon() == null) {
            navigationIcon = this.f23552e;
        } else {
            navigationIcon = getNavigationIcon();
        }
        setNavigationIcon(navigationIcon);
        setNavigationIconDecorative(true);
    }

    public final void g(int i10, String str, String str2) {
        if (i10 != -1) {
            androidx.core.widget.k.p(this.f23548a, i10);
        }
        setText(str);
        setHint(str2);
        if (getNavigationIcon() == null) {
            C0458m.d((ViewGroup.MarginLayoutParams) this.f23548a.getLayoutParams(), getResources().getDimensionPixelSize(C0979e.f30749N));
        }
    }

    public View getCenterView() {
        return this.f23555h;
    }

    public float getCompatElevation() {
        x4.i iVar = this.f23560m;
        if (iVar != null) {
            return iVar.getElevation();
        }
        return K.r(this);
    }

    public float getCornerSize() {
        return this.f23560m.getTopLeftCornerResolvedSize();
    }

    public int getDefaultMarginVerticalResource() {
        return C0979e.f30747M;
    }

    public int getDefaultNavigationIconResource() {
        return e4.f.f30826c;
    }

    public CharSequence getHint() {
        return this.f23548a.getHint();
    }

    public int getMenuResId() {
        return this.f23558k;
    }

    public int getStrokeColor() {
        return this.f23560m.getStrokeColor().getDefaultColor();
    }

    public float getStrokeWidth() {
        return this.f23560m.getStrokeWidth();
    }

    public CharSequence getText() {
        return this.f23548a.getText();
    }

    public TextView getTextView() {
        return this.f23548a;
    }

    public final /* synthetic */ void h(boolean z10) {
        setFocusableInTouchMode(z10);
    }

    public final void i() {
        View view = this.f23555h;
        if (view == null) {
            return;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredWidth2 = (getMeasuredWidth() / 2) - (measuredWidth / 2);
        int i10 = measuredWidth2 + measuredWidth;
        int measuredHeight = this.f23555h.getMeasuredHeight();
        int measuredHeight2 = (getMeasuredHeight() / 2) - (measuredHeight / 2);
        j(this.f23555h, measuredWidth2, measuredHeight2, i10, measuredHeight2 + measuredHeight);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void inflateMenu(int i10) {
        Menu menu = getMenu();
        boolean z10 = menu instanceof MenuBuilder;
        if (z10) {
            ((MenuBuilder) menu).stopDispatchingItemsChanged();
        }
        super.inflateMenu(i10);
        this.f23558k = i10;
        if (z10) {
            ((MenuBuilder) menu).startDispatchingItemsChanged();
        }
    }

    public final void j(View view, int i10, int i11, int i12, int i13) {
        if (K.v(this) == 1) {
            view.layout(getMeasuredWidth() - i12, i11, getMeasuredWidth() - i10, i13);
        } else {
            view.layout(i10, i11, i12, i13);
        }
    }

    public final void k(int i10, int i11) {
        View view = this.f23555h;
        if (view != null) {
            view.measure(i10, i11);
        }
    }

    public final void l() {
        if (this.f23550c && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            Resources resources = getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(C0979e.f30745L);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(getDefaultMarginVerticalResource());
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.leftMargin = d(marginLayoutParams.leftMargin, dimensionPixelSize);
            marginLayoutParams.topMargin = d(marginLayoutParams.topMargin, dimensionPixelSize2);
            marginLayoutParams.rightMargin = d(marginLayoutParams.rightMargin, dimensionPixelSize);
            marginLayoutParams.bottomMargin = d(marginLayoutParams.bottomMargin, dimensionPixelSize2);
        }
    }

    public final void m() {
        int i10;
        int i11;
        boolean z10 = true;
        int i12 = 0;
        if (getLayoutDirection() != 1) {
            z10 = false;
        }
        ImageButton navigationIconButton = ToolbarUtils.getNavigationIconButton(this);
        if (navigationIconButton != null && navigationIconButton.isClickable()) {
            if (z10) {
                i10 = getWidth() - navigationIconButton.getLeft();
            } else {
                i10 = navigationIconButton.getRight();
            }
        } else {
            i10 = 0;
        }
        ActionMenuView actionMenuView = ToolbarUtils.getActionMenuView(this);
        if (actionMenuView != null) {
            if (z10) {
                i12 = actionMenuView.getRight();
            } else {
                i12 = getWidth() - actionMenuView.getLeft();
            }
        }
        if (z10) {
            i11 = i12;
        } else {
            i11 = i10;
        }
        float f10 = -i11;
        if (!z10) {
            i10 = i12;
        }
        setHandwritingBoundsOffsets(f10, 0.0f, -i10, 0.0f);
    }

    public final void n() {
        if (getLayoutParams() instanceof AppBarLayout.LayoutParams) {
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) getLayoutParams();
            if (this.f23559l) {
                if (layoutParams.getScrollFlags() == 0) {
                    layoutParams.setScrollFlags(53);
                }
            } else if (layoutParams.getScrollFlags() == 53) {
                layoutParams.setScrollFlags(0);
            }
        }
    }

    public final void o() {
        AccessibilityManager accessibilityManager = this.f23561n;
        if (accessibilityManager != null) {
            if (accessibilityManager.isEnabled() && this.f23561n.isTouchExplorationEnabled()) {
                setFocusableInTouchMode(true);
            }
            addOnAttachStateChangeListener(new a());
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        x4.j.f(this, this.f23560m);
        l();
        n();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EditText.class.getCanonicalName());
        accessibilityNodeInfo.setEditable(isEnabled());
        CharSequence text = getText();
        boolean isEmpty = TextUtils.isEmpty(text);
        accessibilityNodeInfo.setHintText(getHint());
        accessibilityNodeInfo.setShowingHintText(isEmpty);
        if (isEmpty) {
            text = getHint();
        }
        accessibilityNodeInfo.setText(text);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        i();
        m();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        k(i10, i11);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setText(savedState.f23563a);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        String charSequence;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        CharSequence text = getText();
        if (text == null) {
            charSequence = null;
        } else {
            charSequence = text.toString();
        }
        savedState.f23563a = charSequence;
        return savedState;
    }

    public void p() {
        this.f23551d.b(this);
    }

    public final void q(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "title") == null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "subtitle") == null) {
                return;
            } else {
                throw new UnsupportedOperationException("SearchBar does not support subtitle. Use hint or text instead.");
            }
        }
        throw new UnsupportedOperationException("SearchBar does not support title. Use hint or text instead.");
    }

    public void setCenterView(View view) {
        View view2 = this.f23555h;
        if (view2 != null) {
            removeView(view2);
            this.f23555h = null;
        }
        if (view != null) {
            addView(view);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean z10) {
        this.f23559l = z10;
        n();
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        x4.i iVar = this.f23560m;
        if (iVar != null) {
            iVar.setElevation(f10);
        }
    }

    public void setHint(CharSequence charSequence) {
        this.f23548a.setHint(charSequence);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(maybeTintNavigationIcon(drawable));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        boolean z10;
        if (this.f23554g) {
            return;
        }
        super.setNavigationOnClickListener(onClickListener);
        if (onClickListener == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        setNavigationIconDecorative(z10);
    }

    public void setOnLoadAnimationFadeInEnabled(boolean z10) {
        this.f23551d.a(z10);
    }

    public void setStrokeColor(int i10) {
        if (getStrokeColor() != i10) {
            this.f23560m.setStrokeColor(ColorStateList.valueOf(i10));
        }
    }

    public void setStrokeWidth(float f10) {
        if (getStrokeWidth() != f10) {
            this.f23560m.setStrokeWidth(f10);
        }
    }

    public void setText(CharSequence charSequence) {
        this.f23548a.setText(charSequence);
    }

    /* loaded from: classes3.dex */
    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

        /* renamed from: a, reason: collision with root package name */
        public boolean f23564a;

        public ScrollingViewBehavior() {
            this.f23564a = false;
        }

        public final void a(AppBarLayout appBarLayout) {
            appBarLayout.setBackgroundColor(0);
            appBarLayout.setTargetElevation(0.0f);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            boolean onDependentViewChanged = super.onDependentViewChanged(coordinatorLayout, view, view2);
            if (!this.f23564a && (view2 instanceof AppBarLayout)) {
                this.f23564a = true;
                a((AppBarLayout) view2);
            }
            return onDependentViewChanged;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public boolean shouldHeaderOverlapScrollingChild() {
            return true;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f23564a = false;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SearchBar(android.content.Context r11, android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r6 = com.google.android.material.search.SearchBar.f23547p
            android.content.Context r11 = B4.a.c(r11, r12, r13, r6)
            r10.<init>(r11, r12, r13)
            r11 = -1
            r10.f23558k = r11
            com.google.android.material.search.a r0 = new com.google.android.material.search.a
            r0.<init>()
            r10.f23562o = r0
            android.content.Context r7 = r10.getContext()
            r10.q(r12)
            int r0 = r10.getDefaultNavigationIconResource()
            android.graphics.drawable.Drawable r0 = f.C0991a.b(r7, r0)
            r10.f23552e = r0
            com.google.android.material.search.b r0 = new com.google.android.material.search.b
            r0.<init>()
            r10.f23551d = r0
            int[] r2 = e4.m.f31513q8
            r8 = 0
            int[] r5 = new int[r8]
            r0 = r7
            r1 = r12
            r3 = r13
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            x4.n$b r12 = x4.n.e(r7, r12, r13, r6)
            x4.n r2 = r12.m()
            int r12 = e4.m.f31557u8
            int r3 = r0.getColor(r12, r8)
            int r12 = e4.m.f31590x8
            r13 = 0
            float r4 = r0.getDimension(r12, r13)
            int r12 = e4.m.f31568v8
            r13 = 1
            boolean r12 = r0.getBoolean(r12, r13)
            r10.f23550c = r12
            int r12 = e4.m.f31579w8
            boolean r12 = r0.getBoolean(r12, r13)
            r10.f23559l = r12
            int r12 = e4.m.f31612z8
            boolean r12 = r0.getBoolean(r12, r8)
            int r1 = e4.m.f31601y8
            boolean r1 = r0.getBoolean(r1, r8)
            r10.f23554g = r1
            int r1 = e4.m.f31086D8
            boolean r1 = r0.getBoolean(r1, r13)
            r10.f23553f = r1
            int r1 = e4.m.f31053A8
            boolean r5 = r0.hasValue(r1)
            if (r5 == 0) goto L86
            int r1 = r0.getColor(r1, r11)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.f23556i = r1
        L86:
            int r1 = e4.m.f31524r8
            int r11 = r0.getResourceId(r1, r11)
            int r1 = e4.m.f31535s8
            java.lang.String r1 = r0.getString(r1)
            int r5 = e4.m.f31546t8
            java.lang.String r5 = r0.getString(r5)
            int r6 = e4.m.f31075C8
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r6 = r0.getDimension(r6, r9)
            int r9 = e4.m.f31064B8
            int r8 = r0.getColor(r9, r8)
            r0.recycle()
            if (r12 != 0) goto Lae
            r10.f()
        Lae:
            r10.setClickable(r13)
            r10.setFocusable(r13)
            android.view.LayoutInflater r12 = android.view.LayoutInflater.from(r7)
            int r0 = e4.i.f30919E
            r12.inflate(r0, r10)
            r10.f23549b = r13
            int r12 = e4.g.f30857T
            android.view.View r12 = r10.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r10.f23548a = r12
            androidx.core.view.K.r0(r10, r4)
            r10.g(r11, r1, r5)
            r1 = r10
            r5 = r6
            r6 = r8
            r1.e(r2, r3, r4, r5, r6)
            android.content.Context r11 = r10.getContext()
            java.lang.String r12 = "accessibility"
            java.lang.Object r11 = r11.getSystemService(r12)
            android.view.accessibility.AccessibilityManager r11 = (android.view.accessibility.AccessibilityManager) r11
            r10.f23561n = r11
            r10.o()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.search.SearchBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setHint(int i10) {
        this.f23548a.setHint(i10);
    }

    public void setText(int i10) {
        this.f23548a.setText(i10);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }
}
