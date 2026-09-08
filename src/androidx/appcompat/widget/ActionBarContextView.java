package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import e.C0961a;
import j.AbstractC1145b;

/* loaded from: classes.dex */
public class ActionBarContextView extends AbstractC0427a {

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f7475i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f7476j;

    /* renamed from: k, reason: collision with root package name */
    public View f7477k;

    /* renamed from: l, reason: collision with root package name */
    public View f7478l;

    /* renamed from: m, reason: collision with root package name */
    public View f7479m;

    /* renamed from: n, reason: collision with root package name */
    public LinearLayout f7480n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f7481o;

    /* renamed from: p, reason: collision with root package name */
    public TextView f7482p;

    /* renamed from: q, reason: collision with root package name */
    public int f7483q;

    /* renamed from: r, reason: collision with root package name */
    public int f7484r;

    /* renamed from: x, reason: collision with root package name */
    public boolean f7485x;

    /* renamed from: y, reason: collision with root package name */
    public int f7486y;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC1145b f7487a;

        public a(AbstractC1145b abstractC1145b) {
            this.f7487a = abstractC1145b;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f7487a.a();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.AbstractC0427a
    public /* bridge */ /* synthetic */ androidx.core.view.Q f(int i10, long j10) {
        return super.f(i10, j10);
    }

    public void g() {
        if (this.f7477k == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.AbstractC0427a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbstractC0427a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f7476j;
    }

    public CharSequence getTitle() {
        return this.f7475i;
    }

    public void h(AbstractC1145b abstractC1145b) {
        View view = this.f7477k;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f7486y, (ViewGroup) this, false);
            this.f7477k = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f7477k);
        }
        View findViewById = this.f7477k.findViewById(e.f.f30222i);
        this.f7478l = findViewById;
        findViewById.setOnClickListener(new a(abstractC1145b));
        MenuBuilder menuBuilder = (MenuBuilder) abstractC1145b.c();
        ActionMenuPresenter actionMenuPresenter = this.f7829d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.i();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f7829d = actionMenuPresenter2;
        actionMenuPresenter2.t(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuBuilder.addMenuPresenter(this.f7829d, this.f7827b);
        ActionMenuView actionMenuView = (ActionMenuView) this.f7829d.getMenuView(this);
        this.f7828c = actionMenuView;
        actionMenuView.setBackground(null);
        addView(this.f7828c, layoutParams);
    }

    public final void i() {
        int i10;
        if (this.f7480n == null) {
            LayoutInflater.from(getContext()).inflate(e.g.f30240a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f7480n = linearLayout;
            this.f7481o = (TextView) linearLayout.findViewById(e.f.f30218e);
            this.f7482p = (TextView) this.f7480n.findViewById(e.f.f30217d);
            if (this.f7483q != 0) {
                this.f7481o.setTextAppearance(getContext(), this.f7483q);
            }
            if (this.f7484r != 0) {
                this.f7482p.setTextAppearance(getContext(), this.f7484r);
            }
        }
        this.f7481o.setText(this.f7475i);
        this.f7482p.setText(this.f7476j);
        boolean z10 = !TextUtils.isEmpty(this.f7475i);
        boolean z11 = !TextUtils.isEmpty(this.f7476j);
        TextView textView = this.f7482p;
        int i11 = 8;
        if (z11) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        textView.setVisibility(i10);
        LinearLayout linearLayout2 = this.f7480n;
        if (z10 || z11) {
            i11 = 0;
        }
        linearLayout2.setVisibility(i11);
        if (this.f7480n.getParent() == null) {
            addView(this.f7480n);
        }
    }

    public boolean j() {
        return this.f7485x;
    }

    public void k() {
        removeAllViews();
        this.f7479m = null;
        this.f7828c = null;
        this.f7829d = null;
        View view = this.f7478l;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public boolean l() {
        ActionMenuPresenter actionMenuPresenter = this.f7829d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.u();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f7829d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.l();
            this.f7829d.m();
        }
    }

    @Override // androidx.appcompat.widget.AbstractC0427a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int paddingLeft;
        int paddingRight;
        int i14;
        int i15;
        boolean b10 = S.b(this);
        if (b10) {
            paddingLeft = (i12 - i10) - getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
        View view = this.f7477k;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f7477k.getLayoutParams();
            if (b10) {
                i14 = marginLayoutParams.rightMargin;
            } else {
                i14 = marginLayoutParams.leftMargin;
            }
            if (b10) {
                i15 = marginLayoutParams.leftMargin;
            } else {
                i15 = marginLayoutParams.rightMargin;
            }
            int d10 = AbstractC0427a.d(paddingLeft, i14, b10);
            paddingLeft = AbstractC0427a.d(d10 + e(this.f7477k, d10, paddingTop, paddingTop2, b10), i15, b10);
        }
        int i16 = paddingLeft;
        LinearLayout linearLayout = this.f7480n;
        if (linearLayout != null && this.f7479m == null && linearLayout.getVisibility() != 8) {
            i16 += e(this.f7480n, i16, paddingTop, paddingTop2, b10);
        }
        int i17 = i16;
        View view2 = this.f7479m;
        if (view2 != null) {
            e(view2, i17, paddingTop, paddingTop2, b10);
        }
        if (b10) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = (i12 - i10) - getPaddingRight();
        }
        ActionMenuView actionMenuView = this.f7828c;
        if (actionMenuView != null) {
            e(actionMenuView, paddingRight, paddingTop, paddingTop2, !b10);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        boolean z10;
        int i13;
        int i14 = 1073741824;
        if (View.MeasureSpec.getMode(i10) == 1073741824) {
            if (View.MeasureSpec.getMode(i11) != 0) {
                int size = View.MeasureSpec.getSize(i10);
                int i15 = this.f7830e;
                if (i15 <= 0) {
                    i15 = View.MeasureSpec.getSize(i11);
                }
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                int i16 = i15 - paddingTop;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16, Integer.MIN_VALUE);
                View view = this.f7477k;
                if (view != null) {
                    int c10 = c(view, paddingLeft, makeMeasureSpec, 0);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f7477k.getLayoutParams();
                    paddingLeft = c10 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                }
                ActionMenuView actionMenuView = this.f7828c;
                if (actionMenuView != null && actionMenuView.getParent() == this) {
                    paddingLeft = c(this.f7828c, paddingLeft, makeMeasureSpec, 0);
                }
                LinearLayout linearLayout = this.f7480n;
                if (linearLayout != null && this.f7479m == null) {
                    if (this.f7485x) {
                        this.f7480n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                        int measuredWidth = this.f7480n.getMeasuredWidth();
                        if (measuredWidth <= paddingLeft) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (z10) {
                            paddingLeft -= measuredWidth;
                        }
                        LinearLayout linearLayout2 = this.f7480n;
                        if (z10) {
                            i13 = 0;
                        } else {
                            i13 = 8;
                        }
                        linearLayout2.setVisibility(i13);
                    } else {
                        paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
                    }
                }
                View view2 = this.f7479m;
                if (view2 != null) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    int i17 = layoutParams.width;
                    if (i17 != -2) {
                        i12 = 1073741824;
                    } else {
                        i12 = Integer.MIN_VALUE;
                    }
                    if (i17 >= 0) {
                        paddingLeft = Math.min(i17, paddingLeft);
                    }
                    int i18 = layoutParams.height;
                    if (i18 == -2) {
                        i14 = Integer.MIN_VALUE;
                    }
                    if (i18 >= 0) {
                        i16 = Math.min(i18, i16);
                    }
                    this.f7479m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i12), View.MeasureSpec.makeMeasureSpec(i16, i14));
                }
                if (this.f7830e <= 0) {
                    int childCount = getChildCount();
                    int i19 = 0;
                    for (int i20 = 0; i20 < childCount; i20++) {
                        int measuredHeight = getChildAt(i20).getMeasuredHeight() + paddingTop;
                        if (measuredHeight > i19) {
                            i19 = measuredHeight;
                        }
                    }
                    setMeasuredDimension(size, i19);
                    return;
                }
                setMeasuredDimension(size, i15);
                return;
            }
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    }

    @Override // androidx.appcompat.widget.AbstractC0427a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbstractC0427a
    public void setContentHeight(int i10) {
        this.f7830e = i10;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f7479m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f7479m = view;
        if (view != null && (linearLayout = this.f7480n) != null) {
            removeView(linearLayout);
            this.f7480n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f7476j = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f7475i = charSequence;
        i();
        androidx.core.view.K.m0(this, charSequence);
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.f7485x) {
            requestLayout();
        }
        this.f7485x = z10;
    }

    @Override // androidx.appcompat.widget.AbstractC0427a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0961a.f30111j);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        K w10 = K.w(context, attributeSet, e.j.f30535y, i10, 0);
        setBackground(w10.g(e.j.f30540z));
        this.f7483q = w10.n(e.j.f30297D, 0);
        this.f7484r = w10.n(e.j.f30292C, 0);
        this.f7830e = w10.m(e.j.f30287B, 0);
        this.f7486y = w10.n(e.j.f30282A, e.g.f30243d);
        w10.y();
    }
}
