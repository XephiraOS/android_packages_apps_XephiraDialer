package com.oplus.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import com.oplus.blacklistapp.n;
import com.oplus.blacklistapp.p;
import com.oplus.blacklistapp.r;
import com.oplus.blacklistapp.v;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0849j;
import com.oplus.widget.EmptyViewGroup;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: EmptyViewGroup.kt */
/* loaded from: classes4.dex */
public final class EmptyViewGroup extends ConstraintLayout {

    /* renamed from: x, reason: collision with root package name */
    public static final a f29257x = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public Boolean f29258a;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f29259b;

    /* renamed from: c, reason: collision with root package name */
    public int f29260c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f29261d;

    /* renamed from: e, reason: collision with root package name */
    public int f29262e;

    /* renamed from: f, reason: collision with root package name */
    public int f29263f;

    /* renamed from: g, reason: collision with root package name */
    public int f29264g;

    /* renamed from: h, reason: collision with root package name */
    public int f29265h;

    /* renamed from: i, reason: collision with root package name */
    public int f29266i;

    /* renamed from: j, reason: collision with root package name */
    public View f29267j;

    /* renamed from: k, reason: collision with root package name */
    public int f29268k;

    /* renamed from: l, reason: collision with root package name */
    public int f29269l;

    /* renamed from: m, reason: collision with root package name */
    public int f29270m;

    /* renamed from: n, reason: collision with root package name */
    public int f29271n;

    /* renamed from: o, reason: collision with root package name */
    public int f29272o;

    /* renamed from: p, reason: collision with root package name */
    public int f29273p;

    /* renamed from: q, reason: collision with root package name */
    public int f29274q;

    /* renamed from: r, reason: collision with root package name */
    public int f29275r;

    /* compiled from: EmptyViewGroup.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.f(context, "context");
        this.f29258a = Boolean.TRUE;
        this.f29259b = Boolean.FALSE;
        this.f29261d = true;
        k(attributeSet);
        l(context);
        Object systemService = context.getSystemService("layout_inflater");
        i.d(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(r.f27430B, this);
    }

    public static final void n(EmptyViewGroup this$0) {
        i.f(this$0, "this$0");
        View view = this$0.f29267j;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public static final void o(View it, ViewGroup.LayoutParams layoutParams) {
        i.f(it, "$it");
        it.setLayoutParams(layoutParams);
        it.setVisibility(0);
    }

    public static final void p(View it, ViewGroup.LayoutParams layoutParams) {
        i.f(it, "$it");
        it.setLayoutParams(layoutParams);
        it.setVisibility(0);
    }

    public final int j(int i10) {
        return (int) ((i10 / getResources().getDisplayMetrics().density) * 3.0f);
    }

    public final void k(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, v.f27726c);
        i.e(obtainStyledAttributes, "context.obtainStyledAttr…styleable.EmptyViewGroup)");
        this.f29258a = Boolean.valueOf(obtainStyledAttributes.getBoolean(v.f27729f, true));
        this.f29259b = Boolean.valueOf(obtainStyledAttributes.getBoolean(v.f27730g, false));
        this.f29265h = obtainStyledAttributes.getDimensionPixelSize(v.f27728e, 0);
        this.f29266i = obtainStyledAttributes.getDimensionPixelSize(v.f27727d, 0);
        this.f29260c = obtainStyledAttributes.getInt(v.f27731h, 0);
        obtainStyledAttributes.recycle();
    }

    public final void l(Context context) {
        this.f29262e = getResources().getDimensionPixelSize(n.f27293r);
        this.f29263f = getResources().getDimensionPixelSize(n.f27295t);
        this.f29270m = getResources().getDimensionPixelSize(n.f27292q);
        this.f29271n = getResources().getDimensionPixelSize(n.f27291p);
        this.f29272o = getResources().getDimensionPixelSize(n.f27277b);
        this.f29273p = getResources().getDimensionPixelSize(n.f27280e);
        this.f29274q = getResources().getDimensionPixelSize(n.f27279d);
        Boolean bool = this.f29259b;
        Boolean bool2 = Boolean.TRUE;
        if (i.b(bool, bool2)) {
            this.f29264g = C0849j.l(context);
        }
        if (i.b(this.f29258a, bool2)) {
            this.f29275r = C0849j.h(context);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f29267j = findViewById(p.f27391h0);
        TextView textView = (TextView) findViewById(p.f27393i0);
        if (textView != null) {
            COUIChangeTextUtil.adaptFontSize(textView, 4);
        }
        TextView textView2 = (TextView) findViewById(p.f27395j0);
        if (textView2 != null) {
            COUIChangeTextUtil.adaptFontSize(textView2, 4);
        }
        TextView textView3 = (TextView) findViewById(p.f27389g0);
        if (textView3 != null) {
            COUIChangeTextUtil.adaptFontSize(textView3, 4);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        double d10;
        int height;
        super.onLayout(z10, i10, i11, i12, i13);
        if (getHeight() > 0 && (getParent() instanceof ViewGroup)) {
            ViewParent parent = getParent();
            i.d(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            int height2 = ((ViewGroup) parent).getHeight();
            Boolean bool = this.f29258a;
            if (bool != null && bool.booleanValue()) {
                i14 = this.f29263f;
            } else {
                i14 = 0;
            }
            int i15 = i14 + this.f29264g + this.f29265h;
            int i16 = this.f29260c;
            if (i16 == 1) {
                height = this.f29262e;
            } else {
                if (i16 == 2) {
                    d10 = 0.44d;
                } else {
                    d10 = 0.45d;
                }
                height = (int) ((((height2 - i15) - this.f29266i) * d10) - (getHeight() / 2));
            }
            int i17 = height + i15;
            if (C0846g.c()) {
                C0846g.i("EmptyViewGroup", "height=" + getHeight() + " extraMargin=" + i15 + " fixMarginValue=" + this.f29262e + "  toolbarHeight=" + this.f29263f + " topMargin=" + i17 + " realEmptyViewHeight=" + height2 + "  statusbarHeight=" + this.f29264g + "  additionalTopMargin=" + this.f29265h + "  additionalBottomMargin=" + this.f29266i);
            }
            ViewParent parent2 = getParent();
            i.d(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
            int width = ((ViewGroup) parent2).getWidth();
            int i18 = ((height2 - i15) - this.f29266i) - this.f29275r;
            if (i18 != this.f29268k || width != this.f29269l) {
                if (i18 <= j(this.f29272o)) {
                    post(new Runnable() { // from class: S8.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            EmptyViewGroup.n(EmptyViewGroup.this);
                        }
                    });
                } else if (i18 >= j(this.f29273p) && width >= j(this.f29274q)) {
                    final View view = this.f29267j;
                    if (view != null) {
                        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        layoutParams.width = this.f29270m;
                        layoutParams.height = this.f29271n;
                        post(new Runnable() { // from class: S8.l
                            @Override // java.lang.Runnable
                            public final void run() {
                                EmptyViewGroup.p(view, layoutParams);
                            }
                        });
                    }
                } else {
                    final View view2 = this.f29267j;
                    if (view2 != null) {
                        final ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                        layoutParams2.width = (int) (this.f29270m * 0.6d);
                        layoutParams2.height = (int) (this.f29271n * 0.6d);
                        post(new Runnable() { // from class: S8.k
                            @Override // java.lang.Runnable
                            public final void run() {
                                EmptyViewGroup.o(view2, layoutParams2);
                            }
                        });
                    }
                }
                this.f29268k = i18;
                this.f29269l = width;
            }
            if ((this.f29261d || getTop() == 0) && i17 > 0) {
                this.f29261d = false;
                layout(getLeft(), i17, getRight(), getHeight() + i17);
            }
        }
    }

    public final void q() {
        this.f29261d = true;
        requestLayout();
    }

    public final void r(int i10) {
        this.f29265h = i10;
        q();
    }
}
