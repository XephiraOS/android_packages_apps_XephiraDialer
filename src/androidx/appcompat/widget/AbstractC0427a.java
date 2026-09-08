package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import e.C0961a;

/* compiled from: AbsActionBarView.java */
/* renamed from: androidx.appcompat.widget.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0427a extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final C0101a f7826a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f7827b;

    /* renamed from: c, reason: collision with root package name */
    public ActionMenuView f7828c;

    /* renamed from: d, reason: collision with root package name */
    public ActionMenuPresenter f7829d;

    /* renamed from: e, reason: collision with root package name */
    public int f7830e;

    /* renamed from: f, reason: collision with root package name */
    public androidx.core.view.Q f7831f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7832g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7833h;

    /* compiled from: AbsActionBarView.java */
    /* renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0101a implements androidx.core.view.S {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7834a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f7835b;

        public C0101a() {
        }

        @Override // androidx.core.view.S
        public void a(View view) {
            this.f7834a = true;
        }

        @Override // androidx.core.view.S
        public void b(View view) {
            if (this.f7834a) {
                return;
            }
            AbstractC0427a abstractC0427a = AbstractC0427a.this;
            abstractC0427a.f7831f = null;
            AbstractC0427a.super.setVisibility(this.f7835b);
        }

        @Override // androidx.core.view.S
        public void c(View view) {
            AbstractC0427a.super.setVisibility(0);
            this.f7834a = false;
        }

        public C0101a d(androidx.core.view.Q q10, int i10) {
            AbstractC0427a.this.f7831f = q10;
            this.f7835b = i10;
            return this;
        }
    }

    public AbstractC0427a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static int d(int i10, int i11, boolean z10) {
        if (z10) {
            return i10 - i11;
        }
        return i10 + i11;
    }

    public int c(View view, int i10, int i11, int i12) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), i11);
        return Math.max(0, (i10 - view.getMeasuredWidth()) - i12);
    }

    public int e(View view, int i10, int i11, int i12, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i13 = i11 + ((i12 - measuredHeight) / 2);
        if (z10) {
            view.layout(i10 - measuredWidth, i13, i10, measuredHeight + i13);
        } else {
            view.layout(i10, i13, i10 + measuredWidth, measuredHeight + i13);
        }
        if (z10) {
            return -measuredWidth;
        }
        return measuredWidth;
    }

    public androidx.core.view.Q f(int i10, long j10) {
        androidx.core.view.Q q10 = this.f7831f;
        if (q10 != null) {
            q10.c();
        }
        if (i10 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            androidx.core.view.Q b10 = androidx.core.view.K.d(this).b(1.0f);
            b10.g(j10);
            b10.i(this.f7826a.d(b10, i10));
            return b10;
        }
        androidx.core.view.Q b11 = androidx.core.view.K.d(this).b(0.0f);
        b11.g(j10);
        b11.i(this.f7826a.d(b11, i10));
        return b11;
    }

    public int getAnimatedVisibility() {
        if (this.f7831f != null) {
            return this.f7826a.f7835b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f7830e;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, e.j.f30412a, C0961a.f30104c, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(e.j.f30460j, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f7829d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.p(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f7833h = false;
        }
        if (!this.f7833h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f7833h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f7833h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f7832g = false;
        }
        if (!this.f7832g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f7832g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f7832g = false;
        }
        return true;
    }

    public void setContentHeight(int i10) {
        this.f7830e = i10;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        if (i10 != getVisibility()) {
            androidx.core.view.Q q10 = this.f7831f;
            if (q10 != null) {
                q10.c();
            }
            super.setVisibility(i10);
        }
    }

    public AbstractC0427a(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7826a = new C0101a();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(C0961a.f30102a, typedValue, true) && typedValue.resourceId != 0) {
            this.f7827b = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.f7827b = context;
        }
    }
}
