package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.K;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import e4.C0977c;
import e4.g;
import e4.k;
import e4.l;
import f4.C1001b;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import u4.C1607c;
import u4.C1608d;
import x4.i;
import x4.n;

/* compiled from: BadgeDrawable.java */
/* loaded from: classes3.dex */
public class a extends Drawable implements TextDrawableHelper.TextDrawableDelegate {

    /* renamed from: n, reason: collision with root package name */
    public static final int f22691n = l.f31041x;

    /* renamed from: o, reason: collision with root package name */
    public static final int f22692o = C0977c.f30659c;

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f22693a;

    /* renamed from: b, reason: collision with root package name */
    public final i f22694b;

    /* renamed from: c, reason: collision with root package name */
    public final TextDrawableHelper f22695c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f22696d;

    /* renamed from: e, reason: collision with root package name */
    public final BadgeState f22697e;

    /* renamed from: f, reason: collision with root package name */
    public float f22698f;

    /* renamed from: g, reason: collision with root package name */
    public float f22699g;

    /* renamed from: h, reason: collision with root package name */
    public int f22700h;

    /* renamed from: i, reason: collision with root package name */
    public float f22701i;

    /* renamed from: j, reason: collision with root package name */
    public float f22702j;

    /* renamed from: k, reason: collision with root package name */
    public float f22703k;

    /* renamed from: l, reason: collision with root package name */
    public WeakReference<View> f22704l;

    /* renamed from: m, reason: collision with root package name */
    public WeakReference<FrameLayout> f22705m;

    /* compiled from: BadgeDrawable.java */
    /* renamed from: com.google.android.material.badge.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0207a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f22706a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f22707b;

        public RunnableC0207a(View view, FrameLayout frameLayout) {
            this.f22706a = view;
            this.f22707b = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.P(this.f22706a, this.f22707b);
        }
    }

    public a(Context context, int i10, int i11, int i12, BadgeState.State state) {
        int i13;
        int h10;
        this.f22693a = new WeakReference<>(context);
        ThemeEnforcement.checkMaterialTheme(context);
        this.f22696d = new Rect();
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.f22695c = textDrawableHelper;
        textDrawableHelper.getTextPaint().setTextAlign(Paint.Align.CENTER);
        BadgeState badgeState = new BadgeState(context, i10, i11, i12, state);
        this.f22697e = badgeState;
        if (z()) {
            i13 = badgeState.m();
        } else {
            i13 = badgeState.i();
        }
        if (z()) {
            h10 = badgeState.l();
        } else {
            h10 = badgeState.h();
        }
        this.f22694b = new i(n.b(context, i13, h10).m());
        M();
    }

    public static void O(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    public static a c(Context context) {
        return new a(context, 0, f22692o, f22691n, null);
    }

    public static a d(Context context, BadgeState.State state) {
        return new a(context, 0, f22692o, f22691n, state);
    }

    public boolean A() {
        if (!this.f22697e.E() && this.f22697e.D()) {
            return true;
        }
        return false;
    }

    public boolean B() {
        return this.f22697e.E();
    }

    public final boolean C() {
        FrameLayout i10 = i();
        if (i10 != null && i10.getId() == g.f30909x) {
            return true;
        }
        return false;
    }

    public final void D() {
        this.f22695c.getTextPaint().setAlpha(getAlpha());
        invalidateSelf();
    }

    public final void E() {
        ColorStateList valueOf = ColorStateList.valueOf(this.f22697e.e());
        if (this.f22694b.getFillColor() != valueOf) {
            this.f22694b.setFillColor(valueOf);
            invalidateSelf();
        }
    }

    public final void F() {
        this.f22695c.setTextSizeDirty(true);
        H();
        Q();
        invalidateSelf();
    }

    public final void G() {
        FrameLayout frameLayout;
        WeakReference<View> weakReference = this.f22704l;
        if (weakReference != null && weakReference.get() != null) {
            View view = this.f22704l.get();
            WeakReference<FrameLayout> weakReference2 = this.f22705m;
            if (weakReference2 != null) {
                frameLayout = weakReference2.get();
            } else {
                frameLayout = null;
            }
            P(view, frameLayout);
        }
    }

    public final void H() {
        int i10;
        int h10;
        Context context = this.f22693a.get();
        if (context == null) {
            return;
        }
        i iVar = this.f22694b;
        if (z()) {
            i10 = this.f22697e.m();
        } else {
            i10 = this.f22697e.i();
        }
        if (z()) {
            h10 = this.f22697e.l();
        } else {
            h10 = this.f22697e.h();
        }
        iVar.setShapeAppearanceModel(n.b(context, i10, h10).m());
        invalidateSelf();
    }

    public final void I() {
        C1608d c1608d;
        Context context = this.f22693a.get();
        if (context == null || this.f22695c.getTextAppearance() == (c1608d = new C1608d(context, this.f22697e.A()))) {
            return;
        }
        this.f22695c.setTextAppearance(c1608d, context);
        J();
        Q();
        invalidateSelf();
    }

    public final void J() {
        this.f22695c.getTextPaint().setColor(this.f22697e.j());
        invalidateSelf();
    }

    public final void K() {
        R();
        this.f22695c.setTextSizeDirty(true);
        Q();
        invalidateSelf();
    }

    public final void L() {
        boolean G10 = this.f22697e.G();
        setVisible(G10, false);
        if (b.f22709a && i() != null && !G10) {
            ((ViewGroup) i().getParent()).invalidate();
        }
    }

    public final void M() {
        H();
        I();
        K();
        F();
        D();
        E();
        J();
        G();
        Q();
        L();
    }

    public final void N(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != g.f30909x) {
            WeakReference<FrameLayout> weakReference = this.f22705m;
            if (weakReference != null && weakReference.get() == viewGroup) {
                return;
            }
            O(view);
            FrameLayout frameLayout = new FrameLayout(view.getContext());
            frameLayout.setId(g.f30909x);
            frameLayout.setClipChildren(false);
            frameLayout.setClipToPadding(false);
            frameLayout.setLayoutParams(view.getLayoutParams());
            frameLayout.setMinimumWidth(view.getWidth());
            frameLayout.setMinimumHeight(view.getHeight());
            int indexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeViewAt(indexOfChild);
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(view);
            viewGroup.addView(frameLayout, indexOfChild);
            this.f22705m = new WeakReference<>(frameLayout);
            frameLayout.post(new RunnableC0207a(view, frameLayout));
        }
    }

    public void P(View view, FrameLayout frameLayout) {
        this.f22704l = new WeakReference<>(view);
        boolean z10 = b.f22709a;
        if (z10 && frameLayout == null) {
            N(view);
        } else {
            this.f22705m = new WeakReference<>(frameLayout);
        }
        if (!z10) {
            O(view);
        }
        Q();
        invalidateSelf();
    }

    public final void Q() {
        View view;
        Context context = this.f22693a.get();
        WeakReference<View> weakReference = this.f22704l;
        FrameLayout frameLayout = null;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.f22696d);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<FrameLayout> weakReference2 = this.f22705m;
            if (weakReference2 != null) {
                frameLayout = weakReference2.get();
            }
            if (frameLayout != null || b.f22709a) {
                if (frameLayout == null) {
                    frameLayout = (ViewGroup) view.getParent();
                }
                frameLayout.offsetDescendantRectToMyCoords(view, rect2);
            }
            b(rect2, view);
            b.f(this.f22696d, this.f22698f, this.f22699g, this.f22702j, this.f22703k);
            float f10 = this.f22701i;
            if (f10 != -1.0f) {
                this.f22694b.setCornerSize(f10);
            }
            if (!rect.equals(this.f22696d)) {
                this.f22694b.setBounds(this.f22696d);
            }
        }
    }

    public final void R() {
        if (m() != -2) {
            this.f22700h = ((int) Math.pow(10.0d, m() - 1.0d)) - 1;
        } else {
            this.f22700h = n();
        }
    }

    public final void a(View view) {
        float f10;
        float f11;
        View i10 = i();
        if (i10 == null) {
            if (!(view.getParent() instanceof View)) {
                return;
            }
            float y10 = view.getY();
            f11 = view.getX();
            i10 = (View) view.getParent();
            f10 = y10;
        } else if (C()) {
            if (!(i10.getParent() instanceof View)) {
                return;
            }
            f10 = i10.getY();
            f11 = i10.getX();
            i10 = (View) i10.getParent();
        } else {
            f10 = 0.0f;
            f11 = 0.0f;
        }
        float w10 = w(i10, f10);
        float l10 = l(i10, f11);
        float g10 = g(i10, f10);
        float r10 = r(i10, f11);
        if (w10 < 0.0f) {
            this.f22699g += Math.abs(w10);
        }
        if (l10 < 0.0f) {
            this.f22698f += Math.abs(l10);
        }
        if (g10 > 0.0f) {
            this.f22699g -= Math.abs(g10);
        }
        if (r10 > 0.0f) {
            this.f22698f -= Math.abs(r10);
        }
    }

    public final void b(Rect rect, View view) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        if (z()) {
            f10 = this.f22697e.f22653d;
        } else {
            f10 = this.f22697e.f22652c;
        }
        this.f22701i = f10;
        if (f10 != -1.0f) {
            this.f22702j = f10;
            this.f22703k = f10;
        } else {
            if (z()) {
                f11 = this.f22697e.f22656g;
            } else {
                f11 = this.f22697e.f22654e;
            }
            this.f22702j = Math.round(f11 / 2.0f);
            if (z()) {
                f12 = this.f22697e.f22657h;
            } else {
                f12 = this.f22697e.f22655f;
            }
            this.f22703k = Math.round(f12 / 2.0f);
        }
        if (z()) {
            String f15 = f();
            this.f22702j = Math.max(this.f22702j, (this.f22695c.getTextWidth(f15) / 2.0f) + this.f22697e.g());
            float max = Math.max(this.f22703k, (this.f22695c.getTextHeight(f15) / 2.0f) + this.f22697e.k());
            this.f22703k = max;
            this.f22702j = Math.max(this.f22702j, max);
        }
        int y10 = y();
        int f16 = this.f22697e.f();
        if (f16 != 8388691 && f16 != 8388693) {
            this.f22699g = rect.top + y10;
        } else {
            this.f22699g = rect.bottom - y10;
        }
        int x10 = x();
        int f17 = this.f22697e.f();
        if (f17 != 8388659 && f17 != 8388691) {
            if (K.v(view) == 0) {
                f14 = (rect.right + this.f22702j) - x10;
            } else {
                f14 = (rect.left - this.f22702j) + x10;
            }
            this.f22698f = f14;
        } else {
            if (K.v(view) == 0) {
                f13 = (rect.left - this.f22702j) + x10;
            } else {
                f13 = (rect.right + this.f22702j) - x10;
            }
            this.f22698f = f13;
        }
        if (this.f22697e.F()) {
            a(view);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.f22694b.draw(canvas);
            if (z()) {
                e(canvas);
            }
        }
    }

    public final void e(Canvas canvas) {
        int round;
        String f10 = f();
        if (f10 != null) {
            Rect rect = new Rect();
            this.f22695c.getTextPaint().getTextBounds(f10, 0, f10.length(), rect);
            float exactCenterY = this.f22699g - rect.exactCenterY();
            float f11 = this.f22698f;
            if (rect.bottom <= 0) {
                round = (int) exactCenterY;
            } else {
                round = Math.round(exactCenterY);
            }
            canvas.drawText(f10, f11, round, this.f22695c.getTextPaint());
        }
    }

    public final String f() {
        if (B()) {
            return u();
        }
        if (A()) {
            return p();
        }
        return null;
    }

    public final float g(View view, float f10) {
        if (view.getParent() instanceof View) {
            return ((this.f22699g + this.f22703k) - (((View) view.getParent()).getHeight() - view.getY())) + f10;
        }
        return 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f22697e.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f22696d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f22696d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public CharSequence h() {
        if (!isVisible()) {
            return null;
        }
        if (B()) {
            return v();
        }
        if (A()) {
            return q();
        }
        return j();
    }

    public FrameLayout i() {
        WeakReference<FrameLayout> weakReference = this.f22705m;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public final CharSequence j() {
        return this.f22697e.p();
    }

    public int k() {
        return this.f22697e.s();
    }

    public final float l(View view, float f10) {
        return (this.f22698f - this.f22702j) + view.getX() + f10;
    }

    public int m() {
        return this.f22697e.u();
    }

    public int n() {
        return this.f22697e.v();
    }

    public int o() {
        if (this.f22697e.D()) {
            return this.f22697e.w();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        invalidateSelf();
    }

    public final String p() {
        if (this.f22700h != -2 && o() > this.f22700h) {
            Context context = this.f22693a.get();
            if (context == null) {
                return "";
            }
            return String.format(this.f22697e.x(), context.getString(k.f30994v), Integer.valueOf(this.f22700h), "+");
        }
        return NumberFormat.getInstance(this.f22697e.x()).format(o());
    }

    public final String q() {
        Context context;
        if (this.f22697e.q() == 0 || (context = this.f22693a.get()) == null) {
            return null;
        }
        if (this.f22700h != -2 && o() > this.f22700h) {
            return context.getString(this.f22697e.n(), Integer.valueOf(this.f22700h));
        }
        return context.getResources().getQuantityString(this.f22697e.q(), o(), Integer.valueOf(o()));
    }

    public final float r(View view, float f10) {
        if (view.getParent() instanceof View) {
            return ((this.f22698f + this.f22702j) - (((View) view.getParent()).getWidth() - view.getX())) + f10;
        }
        return 0.0f;
    }

    public BadgeState.State s() {
        return this.f22697e.y();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f22697e.I(i10);
        D();
    }

    public String t() {
        return this.f22697e.z();
    }

    public final String u() {
        String t10 = t();
        int m10 = m();
        if (m10 == -2) {
            return t10;
        }
        if (t10 != null && t10.length() > m10) {
            Context context = this.f22693a.get();
            if (context == null) {
                return "";
            }
            return String.format(context.getString(k.f30984l), t10.substring(0, m10 - 1), "…");
        }
        return t10;
    }

    public final CharSequence v() {
        CharSequence o10 = this.f22697e.o();
        if (o10 != null) {
            return o10;
        }
        return t();
    }

    public final float w(View view, float f10) {
        return (this.f22699g - this.f22703k) + view.getY() + f10;
    }

    public final int x() {
        int s10;
        int i10;
        if (z()) {
            s10 = this.f22697e.r();
        } else {
            s10 = this.f22697e.s();
        }
        if (this.f22697e.f22660k == 1) {
            if (z()) {
                i10 = this.f22697e.f22659j;
            } else {
                i10 = this.f22697e.f22658i;
            }
            s10 += i10;
        }
        return s10 + this.f22697e.b();
    }

    public final int y() {
        int C10 = this.f22697e.C();
        if (z()) {
            C10 = this.f22697e.B();
            Context context = this.f22693a.get();
            if (context != null) {
                C10 = C1001b.c(C10, C10 - this.f22697e.t(), C1001b.b(0.0f, 1.0f, 0.3f, 1.0f, C1607c.f(context) - 1.0f));
            }
        }
        if (this.f22697e.f22660k == 0) {
            C10 -= Math.round(this.f22703k);
        }
        return C10 + this.f22697e.c();
    }

    public final boolean z() {
        if (!B() && !A()) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
