package com.google.android.material.navigation;

import J.d;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.P;
import androidx.core.view.C;
import androidx.core.view.K;
import androidx.core.widget.k;
import e4.C0977c;
import e4.C0979e;
import e4.h;
import f4.C1001b;
import s4.C1550i;
import u4.C1607c;

/* compiled from: NavigationBarItemView.java */
/* loaded from: classes3.dex */
public abstract class c extends FrameLayout implements MenuView.ItemView {
    private static final d ACTIVE_INDICATOR_LABELED_TRANSFORM;
    private static final d ACTIVE_INDICATOR_UNLABELED_TRANSFORM;
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int INVALID_ITEM_POSITION = -1;
    private ValueAnimator activeIndicatorAnimator;
    private int activeIndicatorDesiredHeight;
    private int activeIndicatorDesiredWidth;
    private boolean activeIndicatorEnabled;
    private int activeIndicatorLabelPadding;
    private int activeIndicatorMarginHorizontal;
    private float activeIndicatorProgress;
    private boolean activeIndicatorResizeable;
    private d activeIndicatorTransform;
    private final View activeIndicatorView;
    private int activeTextAppearance;
    private com.google.android.material.badge.a badgeDrawable;
    private final ImageView icon;
    private final FrameLayout iconContainer;
    private ColorStateList iconTint;
    private boolean initialized;
    private boolean isShifting;
    Drawable itemBackground;
    private MenuItemImpl itemData;
    private int itemPaddingBottom;
    private int itemPaddingTop;
    private int itemPosition;
    private ColorStateList itemRippleColor;
    private final ViewGroup labelGroup;
    private int labelVisibilityMode;
    private final TextView largeLabel;
    private Drawable originalIconDrawable;
    private float scaleDownFactor;
    private float scaleUpFactor;
    private float shiftAmount;
    private final TextView smallLabel;
    private Drawable wrappedIconDrawable;

    /* compiled from: NavigationBarItemView.java */
    /* loaded from: classes3.dex */
    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            if (c.this.icon.getVisibility() == 0) {
                c cVar = c.this;
                cVar.tryUpdateBadgeBounds(cVar.icon);
            }
        }
    }

    /* compiled from: NavigationBarItemView.java */
    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f23505a;

        public b(int i10) {
            this.f23505a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.updateActiveIndicatorLayoutParams(this.f23505a);
        }
    }

    /* compiled from: NavigationBarItemView.java */
    /* renamed from: com.google.android.material.navigation.c$c, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0215c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f23507a;

        public C0215c(float f10) {
            this.f23507a = f10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c.this.setActiveIndicatorProgress(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f23507a);
        }
    }

    /* compiled from: NavigationBarItemView.java */
    /* loaded from: classes3.dex */
    public static class d {
        public d() {
        }

        public float a(float f10, float f11) {
            float f12;
            float f13;
            if (f11 == 0.0f) {
                f12 = 0.8f;
            } else {
                f12 = 0.0f;
            }
            if (f11 == 0.0f) {
                f13 = 1.0f;
            } else {
                f13 = 0.2f;
            }
            return C1001b.b(0.0f, 1.0f, f12, f13, f10);
        }

        public float b(float f10, float f11) {
            return C1001b.a(0.4f, 1.0f, f10);
        }

        public float c(float f10, float f11) {
            return 1.0f;
        }

        public void d(float f10, float f11, View view) {
            view.setScaleX(b(f10, f11));
            view.setScaleY(c(f10, f11));
            view.setAlpha(a(f10, f11));
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* compiled from: NavigationBarItemView.java */
    /* loaded from: classes3.dex */
    public static class e extends d {
        public e() {
            super(null);
        }

        @Override // com.google.android.material.navigation.c.d
        public float c(float f10, float f11) {
            return b(f10, f11);
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    static {
        a aVar = null;
        ACTIVE_INDICATOR_LABELED_TRANSFORM = new d(aVar);
        ACTIVE_INDICATOR_UNLABELED_TRANSFORM = new e(aVar);
    }

    public c(Context context) {
        super(context);
        this.initialized = false;
        this.itemPosition = -1;
        this.activeTextAppearance = 0;
        this.activeIndicatorTransform = ACTIVE_INDICATOR_LABELED_TRANSFORM;
        this.activeIndicatorProgress = 0.0f;
        this.activeIndicatorEnabled = false;
        this.activeIndicatorDesiredWidth = 0;
        this.activeIndicatorDesiredHeight = 0;
        this.activeIndicatorResizeable = false;
        this.activeIndicatorMarginHorizontal = 0;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.iconContainer = (FrameLayout) findViewById(e4.g.f30852O);
        this.activeIndicatorView = findViewById(e4.g.f30851N);
        ImageView imageView = (ImageView) findViewById(e4.g.f30853P);
        this.icon = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(e4.g.f30854Q);
        this.labelGroup = viewGroup;
        TextView textView = (TextView) findViewById(e4.g.f30856S);
        this.smallLabel = textView;
        TextView textView2 = (TextView) findViewById(e4.g.f30855R);
        this.largeLabel = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.itemPaddingTop = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.itemPaddingBottom = viewGroup.getPaddingBottom();
        this.activeIndicatorLabelPadding = getResources().getDimensionPixelSize(C0979e.f30739I);
        K.t0(textView, 2);
        K.t0(textView2, 2);
        setFocusable(true);
        calculateTextScaleFactors(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new a());
        }
    }

    private void calculateTextScaleFactors(float f10, float f11) {
        this.shiftAmount = f10 - f11;
        this.scaleUpFactor = (f11 * 1.0f) / f10;
        this.scaleDownFactor = (f10 * 1.0f) / f11;
    }

    private static Drawable createItemBackgroundCompat(ColorStateList colorStateList) {
        return new RippleDrawable(v4.b.a(colorStateList), null, null);
    }

    private FrameLayout getCustomParentForBadge(View view) {
        ImageView imageView = this.icon;
        if (view != imageView || !com.google.android.material.badge.b.f22709a) {
            return null;
        }
        return (FrameLayout) imageView.getParent();
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout = this.iconContainer;
        if (frameLayout == null) {
            return this.icon;
        }
        return frameLayout;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i10 = 0;
        for (int i11 = 0; i11 < indexOfChild; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if ((childAt instanceof c) && childAt.getVisibility() == 0) {
                i10++;
            }
        }
        return i10;
    }

    private int getSuggestedIconHeight() {
        return ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin + getIconOrContainer().getMeasuredHeight();
    }

    private int getSuggestedIconWidth() {
        int minimumWidth;
        com.google.android.material.badge.a aVar = this.badgeDrawable;
        if (aVar == null) {
            minimumWidth = 0;
        } else {
            minimumWidth = aVar.getMinimumWidth() - this.badgeDrawable.k();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return Math.max(minimumWidth, layoutParams.leftMargin) + this.icon.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.rightMargin);
    }

    private boolean hasBadge() {
        if (this.badgeDrawable != null) {
            return true;
        }
        return false;
    }

    private boolean isActiveIndicatorResizeableAndUnlabeled() {
        if (this.activeIndicatorResizeable && this.labelVisibilityMode == 2) {
            return true;
        }
        return false;
    }

    private void maybeAnimateActiveIndicatorToProgress(float f10) {
        if (this.activeIndicatorEnabled && this.initialized && K.N(this)) {
            ValueAnimator valueAnimator = this.activeIndicatorAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.activeIndicatorAnimator = null;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.activeIndicatorProgress, f10);
            this.activeIndicatorAnimator = ofFloat;
            ofFloat.addUpdateListener(new C0215c(f10));
            this.activeIndicatorAnimator.setInterpolator(C1550i.g(getContext(), C0977c.f30662d0, C1001b.f31703b));
            this.activeIndicatorAnimator.setDuration(C1550i.f(getContext(), C0977c.f30648T, getResources().getInteger(h.f30913b)));
            this.activeIndicatorAnimator.start();
            return;
        }
        setActiveIndicatorProgress(f10, f10);
    }

    private void refreshChecked() {
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl != null) {
            setChecked(menuItemImpl.isChecked());
        }
    }

    private void refreshItemBackground() {
        Drawable drawable = this.itemBackground;
        RippleDrawable rippleDrawable = null;
        boolean z10 = true;
        if (this.itemRippleColor != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.activeIndicatorEnabled && getActiveIndicatorDrawable() != null && this.iconContainer != null && activeIndicatorDrawable != null) {
                rippleDrawable = new RippleDrawable(v4.b.d(this.itemRippleColor), null, activeIndicatorDrawable);
                z10 = false;
            } else if (drawable == null) {
                drawable = createItemBackgroundCompat(this.itemRippleColor);
            }
        }
        FrameLayout frameLayout = this.iconContainer;
        if (frameLayout != null) {
            frameLayout.setPadding(0, 0, 0, 0);
            this.iconContainer.setForeground(rippleDrawable);
        }
        K.n0(this, drawable);
        setDefaultFocusHighlightEnabled(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActiveIndicatorProgress(float f10, float f11) {
        View view = this.activeIndicatorView;
        if (view != null) {
            this.activeIndicatorTransform.d(f10, f11, view);
        }
        this.activeIndicatorProgress = f10;
    }

    private static void setTextAppearanceWithoutFontScaling(TextView textView, int i10) {
        k.p(textView, i10);
        int i11 = C1607c.i(textView.getContext(), i10, 0);
        if (i11 != 0) {
            textView.setTextSize(0, i11);
        }
    }

    private static void setViewScaleValues(View view, float f10, float f11, int i10) {
        view.setScaleX(f10);
        view.setScaleY(f11);
        view.setVisibility(i10);
    }

    private static void setViewTopMarginAndGravity(View view, int i10, int i11) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i10;
        layoutParams.bottomMargin = i10;
        layoutParams.gravity = i11;
        view.setLayoutParams(layoutParams);
    }

    private void tryAttachBadgeToAnchor(View view) {
        if (hasBadge() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            com.google.android.material.badge.b.a(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    private void tryRemoveBadgeFromAnchor(View view) {
        if (!hasBadge()) {
            return;
        }
        if (view != null) {
            setClipChildren(true);
            setClipToPadding(true);
            com.google.android.material.badge.b.d(this.badgeDrawable, view);
        }
        this.badgeDrawable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryUpdateBadgeBounds(View view) {
        if (!hasBadge()) {
            return;
        }
        com.google.android.material.badge.b.e(this.badgeDrawable, view, getCustomParentForBadge(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateActiveIndicatorLayoutParams(int i10) {
        int i11;
        if (this.activeIndicatorView != null && i10 > 0) {
            int min = Math.min(this.activeIndicatorDesiredWidth, i10 - (this.activeIndicatorMarginHorizontal * 2));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.activeIndicatorView.getLayoutParams();
            if (isActiveIndicatorResizeableAndUnlabeled()) {
                i11 = min;
            } else {
                i11 = this.activeIndicatorDesiredHeight;
            }
            layoutParams.height = i11;
            layoutParams.width = min;
            this.activeIndicatorView.setLayoutParams(layoutParams);
        }
    }

    private void updateActiveIndicatorTransform() {
        if (isActiveIndicatorResizeableAndUnlabeled()) {
            this.activeIndicatorTransform = ACTIVE_INDICATOR_UNLABELED_TRANSFORM;
        } else {
            this.activeIndicatorTransform = ACTIVE_INDICATOR_LABELED_TRANSFORM;
        }
    }

    private static void updateViewPaddingBottom(View view, int i10) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i10);
    }

    public void clear() {
        removeBadge();
        this.itemData = null;
        this.activeIndicatorProgress = 0.0f;
        this.initialized = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        FrameLayout frameLayout = this.iconContainer;
        if (frameLayout != null && this.activeIndicatorEnabled) {
            frameLayout.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public Drawable getActiveIndicatorDrawable() {
        View view = this.activeIndicatorView;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    public com.google.android.material.badge.a getBadge() {
        return this.badgeDrawable;
    }

    public int getItemBackgroundResId() {
        return e4.f.f30836m;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    public int getItemDefaultMarginResId() {
        return C0979e.f30728C0;
    }

    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.itemPosition;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        int i10;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.labelGroup.getLayoutParams();
        int suggestedIconHeight = getSuggestedIconHeight();
        if (this.labelGroup.getVisibility() == 0) {
            i10 = this.activeIndicatorLabelPadding;
        } else {
            i10 = 0;
        }
        return suggestedIconHeight + i10 + layoutParams.topMargin + this.labelGroup.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.labelGroup.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams.leftMargin + this.labelGroup.getMeasuredWidth() + layoutParams.rightMargin);
    }

    public void initialize(MenuItemImpl menuItemImpl, int i10) {
        CharSequence title;
        int i11;
        this.itemData = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        if (!TextUtils.isEmpty(menuItemImpl.getTooltipText())) {
            title = menuItemImpl.getTooltipText();
        } else {
            title = menuItemImpl.getTitle();
        }
        P.a(this, title);
        if (menuItemImpl.isVisible()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        setVisibility(i11);
        this.initialized = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.itemData.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        com.google.android.material.badge.a aVar = this.badgeDrawable;
        if (aVar != null && aVar.isVisible()) {
            CharSequence title = this.itemData.getTitle();
            if (!TextUtils.isEmpty(this.itemData.getContentDescription())) {
                title = this.itemData.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.badgeDrawable.h()));
        }
        J.d O02 = J.d.O0(accessibilityNodeInfo);
        O02.k0(d.f.a(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            O02.i0(false);
            O02.a0(d.a.f1394i);
        }
        O02.C0(getResources().getString(e4.k.f30983k));
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        post(new b(i10));
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void removeBadge() {
        tryRemoveBadgeFromAnchor(this.icon);
    }

    public void setActiveIndicatorDrawable(Drawable drawable) {
        View view = this.activeIndicatorView;
        if (view == null) {
            return;
        }
        view.setBackgroundDrawable(drawable);
        refreshItemBackground();
    }

    public void setActiveIndicatorEnabled(boolean z10) {
        int i10;
        this.activeIndicatorEnabled = z10;
        refreshItemBackground();
        View view = this.activeIndicatorView;
        if (view != null) {
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            view.setVisibility(i10);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i10) {
        this.activeIndicatorDesiredHeight = i10;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorLabelPadding(int i10) {
        if (this.activeIndicatorLabelPadding != i10) {
            this.activeIndicatorLabelPadding = i10;
            refreshChecked();
        }
    }

    public void setActiveIndicatorMarginHorizontal(int i10) {
        this.activeIndicatorMarginHorizontal = i10;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z10) {
        this.activeIndicatorResizeable = z10;
    }

    public void setActiveIndicatorWidth(int i10) {
        this.activeIndicatorDesiredWidth = i10;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setBadge(com.google.android.material.badge.a aVar) {
        if (this.badgeDrawable == aVar) {
            return;
        }
        if (hasBadge() && this.icon != null) {
            Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
            tryRemoveBadgeFromAnchor(this.icon);
        }
        this.badgeDrawable = aVar;
        ImageView imageView = this.icon;
        if (imageView != null) {
            tryAttachBadgeToAnchor(imageView);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z10) {
        refreshDrawableState();
    }

    public void setChecked(boolean z10) {
        float f10;
        this.largeLabel.setPivotX(r0.getWidth() / 2);
        this.largeLabel.setPivotY(r0.getBaseline());
        this.smallLabel.setPivotX(r0.getWidth() / 2);
        this.smallLabel.setPivotY(r0.getBaseline());
        if (z10) {
            f10 = 1.0f;
        } else {
            f10 = 0.0f;
        }
        maybeAnimateActiveIndicatorToProgress(f10);
        int i10 = this.labelVisibilityMode;
        if (i10 != -1) {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 17);
                        this.largeLabel.setVisibility(8);
                        this.smallLabel.setVisibility(8);
                    }
                } else {
                    updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
                    if (z10) {
                        setViewTopMarginAndGravity(getIconOrContainer(), (int) (this.itemPaddingTop + this.shiftAmount), 49);
                        setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
                        TextView textView = this.smallLabel;
                        float f11 = this.scaleUpFactor;
                        setViewScaleValues(textView, f11, f11, 4);
                    } else {
                        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
                        TextView textView2 = this.largeLabel;
                        float f12 = this.scaleDownFactor;
                        setViewScaleValues(textView2, f12, f12, 4);
                        setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
                    }
                }
            } else {
                if (z10) {
                    setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
                    updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
                    this.largeLabel.setVisibility(0);
                } else {
                    setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 17);
                    updateViewPaddingBottom(this.labelGroup, 0);
                    this.largeLabel.setVisibility(4);
                }
                this.smallLabel.setVisibility(4);
            }
        } else if (this.isShifting) {
            if (z10) {
                setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
                updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
                this.largeLabel.setVisibility(0);
            } else {
                setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 17);
                updateViewPaddingBottom(this.labelGroup, 0);
                this.largeLabel.setVisibility(4);
            }
            this.smallLabel.setVisibility(4);
        } else {
            updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
            if (z10) {
                setViewTopMarginAndGravity(getIconOrContainer(), (int) (this.itemPaddingTop + this.shiftAmount), 49);
                setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
                TextView textView3 = this.smallLabel;
                float f13 = this.scaleUpFactor;
                setViewScaleValues(textView3, f13, f13, 4);
            } else {
                setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
                TextView textView4 = this.largeLabel;
                float f14 = this.scaleDownFactor;
                setViewScaleValues(textView4, f14, f14, 4);
                setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z10);
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.smallLabel.setEnabled(z10);
        this.largeLabel.setEnabled(z10);
        this.icon.setEnabled(z10);
        if (z10) {
            K.B0(this, C.b(getContext(), 1002));
        } else {
            K.B0(this, null);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable drawable) {
        if (drawable == this.originalIconDrawable) {
            return;
        }
        this.originalIconDrawable = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = C.a.r(drawable).mutate();
            this.wrappedIconDrawable = drawable;
            ColorStateList colorStateList = this.iconTint;
            if (colorStateList != null) {
                C.a.o(drawable, colorStateList);
            }
        }
        this.icon.setImageDrawable(drawable);
    }

    public void setIconSize(int i10) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.icon.getLayoutParams();
        layoutParams.width = i10;
        layoutParams.height = i10;
        this.icon.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.iconTint = colorStateList;
        if (this.itemData != null && (drawable = this.wrappedIconDrawable) != null) {
            C.a.o(drawable, colorStateList);
            this.wrappedIconDrawable.invalidateSelf();
        }
    }

    public void setItemBackground(int i10) {
        setItemBackground(i10 == 0 ? null : androidx.core.content.b.e(getContext(), i10));
    }

    public void setItemPaddingBottom(int i10) {
        if (this.itemPaddingBottom != i10) {
            this.itemPaddingBottom = i10;
            refreshChecked();
        }
    }

    public void setItemPaddingTop(int i10) {
        if (this.itemPaddingTop != i10) {
            this.itemPaddingTop = i10;
            refreshChecked();
        }
    }

    public void setItemPosition(int i10) {
        this.itemPosition = i10;
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.itemRippleColor = colorStateList;
        refreshItemBackground();
    }

    public void setLabelVisibilityMode(int i10) {
        if (this.labelVisibilityMode != i10) {
            this.labelVisibilityMode = i10;
            updateActiveIndicatorTransform();
            updateActiveIndicatorLayoutParams(getWidth());
            refreshChecked();
        }
    }

    public void setShifting(boolean z10) {
        if (this.isShifting != z10) {
            this.isShifting = z10;
            refreshChecked();
        }
    }

    public void setTextAppearanceActive(int i10) {
        this.activeTextAppearance = i10;
        setTextAppearanceWithoutFontScaling(this.largeLabel, i10);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceActiveBoldEnabled(boolean z10) {
        setTextAppearanceActive(this.activeTextAppearance);
        TextView textView = this.largeLabel;
        textView.setTypeface(textView.getTypeface(), z10 ? 1 : 0);
    }

    public void setTextAppearanceInactive(int i10) {
        setTextAppearanceWithoutFontScaling(this.smallLabel, i10);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.smallLabel.setTextColor(colorStateList);
            this.largeLabel.setTextColor(colorStateList);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.smallLabel.setText(charSequence);
        this.largeLabel.setText(charSequence);
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
        MenuItemImpl menuItemImpl2 = this.itemData;
        if (menuItemImpl2 != null && !TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
            charSequence = this.itemData.getTooltipText();
        }
        P.a(this, charSequence);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.itemBackground = drawable;
        refreshItemBackground();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z10, char c10) {
    }
}
