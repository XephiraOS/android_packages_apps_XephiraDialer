package com.android.contacts.framework.baseui.widget;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.N;
import com.android.contacts.framework.baseui.util.C0640e;
import com.android.contacts.framework.baseui.util.C0641f;
import com.android.contacts.framework.baseui.widget.FloatingTabView;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import v9.InterfaceC1637a;

/* compiled from: FloatingTabView.kt */
/* loaded from: classes.dex */
public final class FloatingTabView extends LinearLayout {

    /* renamed from: I, reason: collision with root package name */
    public static final a f16037I = new a(null);

    /* renamed from: J, reason: collision with root package name */
    public static final PathInterpolator f16038J = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: A, reason: collision with root package name */
    public int f16039A;

    /* renamed from: B, reason: collision with root package name */
    public int f16040B;

    /* renamed from: C, reason: collision with root package name */
    public int f16041C;

    /* renamed from: D, reason: collision with root package name */
    public int f16042D;

    /* renamed from: E, reason: collision with root package name */
    public int f16043E;

    /* renamed from: F, reason: collision with root package name */
    public C0640e f16044F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f16045G;

    /* renamed from: H, reason: collision with root package name */
    public final m9.d f16046H;

    /* renamed from: a, reason: collision with root package name */
    public final m9.d f16047a;

    /* renamed from: b, reason: collision with root package name */
    public final m9.d f16048b;

    /* renamed from: c, reason: collision with root package name */
    public final m9.d f16049c;

    /* renamed from: d, reason: collision with root package name */
    public final m9.d f16050d;

    /* renamed from: e, reason: collision with root package name */
    public final m9.d f16051e;

    /* renamed from: f, reason: collision with root package name */
    public final m9.d f16052f;

    /* renamed from: g, reason: collision with root package name */
    public final m9.d f16053g;

    /* renamed from: h, reason: collision with root package name */
    public final m9.d f16054h;

    /* renamed from: i, reason: collision with root package name */
    public final m9.d f16055i;

    /* renamed from: j, reason: collision with root package name */
    public final m9.d f16056j;

    /* renamed from: k, reason: collision with root package name */
    public final int f16057k;

    /* renamed from: l, reason: collision with root package name */
    public final long f16058l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList<e> f16059m;

    /* renamed from: n, reason: collision with root package name */
    public final b f16060n;

    /* renamed from: o, reason: collision with root package name */
    public final b f16061o;

    /* renamed from: p, reason: collision with root package name */
    public final b f16062p;

    /* renamed from: q, reason: collision with root package name */
    public c f16063q;

    /* renamed from: r, reason: collision with root package name */
    public Integer f16064r;

    /* renamed from: x, reason: collision with root package name */
    public Integer f16065x;

    /* renamed from: y, reason: collision with root package name */
    public float f16066y;

    /* renamed from: z, reason: collision with root package name */
    public int f16067z;

    /* compiled from: FloatingTabView.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: FloatingTabView.kt */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f16068a;

        /* renamed from: b, reason: collision with root package name */
        public int f16069b;

        /* renamed from: c, reason: collision with root package name */
        public int f16070c;

        /* renamed from: d, reason: collision with root package name */
        public int f16071d;

        /* renamed from: e, reason: collision with root package name */
        public float f16072e;

        public b() {
            this(0, 0, 0, 0, 0.0f, 31, null);
        }

        public final int a() {
            return this.f16071d;
        }

        public final int b() {
            return this.f16068a;
        }

        public final float c() {
            return this.f16072e;
        }

        public final int d() {
            return this.f16069b;
        }

        public final int e() {
            return this.f16070c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f16068a == bVar.f16068a && this.f16069b == bVar.f16069b && this.f16070c == bVar.f16070c && this.f16071d == bVar.f16071d && Float.compare(this.f16072e, bVar.f16072e) == 0) {
                return true;
            }
            return false;
        }

        public final void f(int i10) {
            this.f16071d = i10;
        }

        public final void g(int i10) {
            this.f16068a = i10;
        }

        public final void h(int i10) {
            this.f16069b = i10;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.f16068a) * 31) + Integer.hashCode(this.f16069b)) * 31) + Integer.hashCode(this.f16070c)) * 31) + Integer.hashCode(this.f16071d)) * 31) + Float.hashCode(this.f16072e);
        }

        public final void i(int i10) {
            this.f16070c = i10;
        }

        public String toString() {
            return "IndicatorPosition(left=" + this.f16068a + ", right=" + this.f16069b + ", top=" + this.f16070c + ", bottom=" + this.f16071d + ", progress=" + this.f16072e + ")";
        }

        public b(int i10, int i11, int i12, int i13, float f10) {
            this.f16068a = i10;
            this.f16069b = i11;
            this.f16070c = i12;
            this.f16071d = i13;
            this.f16072e = f10;
        }

        public /* synthetic */ b(int i10, int i11, int i12, int i13, float f10, int i14, kotlin.jvm.internal.f fVar) {
            this((i14 & 1) != 0 ? 0 : i10, (i14 & 2) != 0 ? 0 : i11, (i14 & 4) != 0 ? 0 : i12, (i14 & 8) != 0 ? 0 : i13, (i14 & 16) != 0 ? 0.0f : f10);
        }
    }

    /* compiled from: FloatingTabView.kt */
    /* loaded from: classes.dex */
    public interface c {

        /* compiled from: FloatingTabView.kt */
        /* loaded from: classes.dex */
        public static final class a {
            public static /* synthetic */ boolean a(c cVar, int i10, boolean z10, int i11, Object obj) {
                if (obj == null) {
                    if ((i11 & 2) != 0) {
                        z10 = false;
                    }
                    return cVar.a(i10, z10);
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onTabSelected");
            }
        }

        boolean a(int i10, boolean z10);

        void b();
    }

    /* compiled from: FloatingTabView.kt */
    /* loaded from: classes.dex */
    public static final class d implements TypeEvaluator<b> {
        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b evaluate(float f10, b startValue, b endValue) {
            kotlin.jvm.internal.i.f(startValue, "startValue");
            kotlin.jvm.internal.i.f(endValue, "endValue");
            return new b((int) (startValue.b() + ((endValue.b() - startValue.b()) * f10)), (int) (startValue.d() + ((endValue.d() - startValue.d()) * f10)), endValue.e(), endValue.a(), f10);
        }
    }

    /* compiled from: FloatingTabView.kt */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public int f16073a;

        /* renamed from: b, reason: collision with root package name */
        public String f16074b;

        public e(int i10, String title) {
            kotlin.jvm.internal.i.f(title, "title");
            this.f16073a = i10;
            this.f16074b = title;
        }

        public final int a() {
            return this.f16073a;
        }

        public final String b() {
            return this.f16074b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (this.f16073a == eVar.f16073a && kotlin.jvm.internal.i.b(this.f16074b, eVar.f16074b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f16073a) * 31) + this.f16074b.hashCode();
        }

        public String toString() {
            return "TabItem(id=" + this.f16073a + ", title=" + this.f16074b + ")";
        }
    }

    /* compiled from: FloatingTabView.kt */
    /* loaded from: classes.dex */
    public static final class f implements C0640e.b {
        public f() {
        }

        @Override // com.android.contacts.framework.baseui.util.C0640e.b
        public void a(float f10) {
            FloatingTabView.this.f16066y = f10;
            FloatingTabView.this.postInvalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FloatingTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    private final Drawable getBackgroundDrawable() {
        return (Drawable) this.f16052f.getValue();
    }

    private final Drawable getIndicatorDrawable() {
        return (Drawable) this.f16051e.getValue();
    }

    private final int getIndicatorMinWidth() {
        return ((Number) this.f16056j.getValue()).intValue();
    }

    private final int getIndicatorPadding() {
        return ((Number) this.f16055i.getValue()).intValue();
    }

    private final ValueAnimator getSwitchAnimator() {
        Object value = this.f16046H.getValue();
        kotlin.jvm.internal.i.e(value, "<get-switchAnimator>(...)");
        return (ValueAnimator) value;
    }

    private final int getTextHorizontalPadding() {
        return ((Number) this.f16053g.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTextSelectedColor() {
        return ((Number) this.f16049c.getValue()).intValue();
    }

    private final int getTextSelectedDisEnabledColor() {
        return ((Number) this.f16048b.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTextUnselectedColor() {
        return ((Number) this.f16050d.getValue()).intValue();
    }

    private final int getTextUnselectedDisEnabledColor() {
        return ((Number) this.f16047a.getValue()).intValue();
    }

    private final int getTextVerticalPadding() {
        return ((Number) this.f16054h.getValue()).intValue();
    }

    public static final void p(FloatingTabView this$0, e tabItem, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(tabItem, "$tabItem");
        if (this$0.isEnabled()) {
            int a10 = tabItem.a();
            Integer num = this$0.f16064r;
            if (num == null || a10 != num.intValue()) {
                c cVar = this$0.f16063q;
                if (cVar != null && c.a.a(cVar, tabItem.a(), false, 2, null)) {
                    this$0.t(tabItem.a(), true);
                    return;
                }
                return;
            }
            c cVar2 = this$0.f16063q;
            if (cVar2 != null) {
                cVar2.b();
            }
        }
    }

    public static final boolean q(e tabItem, FloatingTabView this$0, TextView this_apply, View view, MotionEvent event) {
        kotlin.jvm.internal.i.f(tabItem, "$tabItem");
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(this_apply, "$this_apply");
        int a10 = tabItem.a();
        Integer num = this$0.f16064r;
        if (num != null && a10 == num.intValue()) {
            if (event.getAction() == 0) {
                this$0.f16044F = new C0640e(this_apply, 0);
            }
            C0640e c0640e = this$0.f16044F;
            if (c0640e != null) {
                kotlin.jvm.internal.i.e(event, "event");
                C0641f.a(c0640e, event);
            }
            C0640e c0640e2 = this$0.f16044F;
            if (c0640e2 != null) {
                c0640e2.k(new f());
            }
        }
        this$0.postInvalidate();
        return false;
    }

    public final void o() {
        Object b10;
        Drawable backgroundDrawable;
        removeAllViews();
        if (!com.android.contacts.framework.baseui.util.o.e(getContext()) && (backgroundDrawable = getBackgroundDrawable()) != null) {
            backgroundDrawable.setAlpha(this.f16057k);
        }
        for (final e eVar : this.f16059m) {
            final TextView textView = new TextView(getContext());
            textView.setId(eVar.a());
            textView.setText(eVar.b());
            try {
                Result.a aVar = Result.f34166a;
                b10 = Result.b(Typeface.create(COUIChangeTextUtil.MEDIUM_FONT, 0));
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            if (Result.d(b10) != null) {
                b10 = Typeface.DEFAULT;
            }
            textView.setTypeface((Typeface) b10);
            textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setForceDarkAllowed(false);
            textView.setGravity(17);
            textView.setSingleLine(true);
            textView.setIncludeFontPadding(false);
            textView.setImportantForAccessibility(1);
            textView.setFocusable(true);
            textView.setEnabled(true);
            textView.setTextSize(1, 12.0f);
            textView.setPaddingRelative(getTextHorizontalPadding(), getTextVerticalPadding(), getTextHorizontalPadding(), getTextVerticalPadding());
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.android.contacts.framework.baseui.widget.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FloatingTabView.p(FloatingTabView.this, eVar, view);
                }
            });
            if (this.f16045G) {
                textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.android.contacts.framework.baseui.widget.j
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        boolean q10;
                        q10 = FloatingTabView.q(FloatingTabView.e.this, this, textView, view, motionEvent);
                        return q10;
                    }
                });
            }
            addView(textView);
        }
        r();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getSwitchAnimator().cancel();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        TextView textView;
        kotlin.jvm.internal.i.f(canvas, "canvas");
        if (!getSwitchAnimator().isRunning()) {
            if (this.f16064r == null) {
                this.f16064r = Integer.valueOf(this.f16059m.get(0).a());
            }
            Integer num = this.f16064r;
            if (num != null && (textView = (TextView) findViewById(num.intValue())) != null) {
                kotlin.jvm.internal.i.e(textView, "findViewById<TextView>(currentSelectedId)");
                this.f16060n.g(textView.getLeft());
                this.f16060n.h(textView.getRight());
                this.f16060n.i(textView.getTop());
                this.f16060n.f(textView.getBottom());
            }
        }
        if (this.f16066y == 1.0f) {
            this.f16067z = this.f16060n.b();
            this.f16039A = this.f16060n.e();
            this.f16040B = this.f16060n.d();
            int a10 = this.f16060n.a();
            this.f16041C = a10;
            this.f16042D = this.f16040B - this.f16067z;
            this.f16043E = a10 - this.f16039A;
        }
        super.onDraw(canvas);
        Drawable backgroundDrawable = getBackgroundDrawable();
        if (backgroundDrawable != null) {
            backgroundDrawable.setBounds(getPaddingStart() - getIndicatorPadding(), this.f16039A - getIndicatorPadding(), (getWidth() - getPaddingEnd()) + getIndicatorPadding(), this.f16041C + getIndicatorPadding());
        }
        Drawable backgroundDrawable2 = getBackgroundDrawable();
        if (backgroundDrawable2 != null) {
            backgroundDrawable2.draw(canvas);
        }
        Drawable indicatorDrawable = getIndicatorDrawable();
        if (indicatorDrawable != null) {
            float f10 = this.f16067z;
            int i10 = this.f16042D;
            float f11 = 1;
            float f12 = this.f16066y;
            float f13 = this.f16039A;
            int i11 = this.f16043E;
            indicatorDrawable.setBounds((int) (f10 + (i10 * (f11 - f12))), (int) (f13 + (i11 * (f11 - f12))), (int) (this.f16040B - (i10 * (f11 - f12))), (int) (this.f16041C - (i11 * (f11 - f12))));
        }
        Drawable indicatorDrawable2 = getIndicatorDrawable();
        if (indicatorDrawable2 != null) {
            indicatorDrawable2.draw(canvas);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        LinearLayout.LayoutParams layoutParams;
        if (View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            int i12 = 0;
            for (View view : N.b(this)) {
                view.measure(i10, i11);
                i12 = Math.max(i12, view.getMeasuredWidth());
            }
            int size = View.MeasureSpec.getSize(i10) - (getIndicatorPadding() * 2);
            int max = Math.max(i12, getIndicatorMinWidth());
            if (getChildCount() * max >= size) {
                max = size / getChildCount();
            }
            Iterator<View> it = N.b(this).iterator();
            while (it.hasNext()) {
                ViewGroup.LayoutParams layoutParams2 = it.next().getLayoutParams();
                if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                    layoutParams = (LinearLayout.LayoutParams) layoutParams2;
                } else {
                    layoutParams = null;
                }
                if (layoutParams != null) {
                    layoutParams.weight = 0.0f;
                    layoutParams.width = max;
                }
            }
        }
        super.onMeasure(i10, i11);
    }

    public final void r() {
        boolean z10;
        if (this.f16064r == null) {
            this.f16064r = Integer.valueOf(this.f16059m.get(0).a());
        }
        for (e eVar : this.f16059m) {
            TextView textView = (TextView) findViewById(eVar.a());
            int a10 = eVar.a();
            Integer num = this.f16064r;
            if (num != null && a10 == num.intValue()) {
                z10 = true;
            } else {
                z10 = false;
            }
            u(textView, z10);
        }
    }

    public final void s() {
        TextView textView;
        TextView textView2;
        if (getSwitchAnimator().isRunning()) {
            getSwitchAnimator().cancel();
            this.f16062p.g(this.f16060n.b());
            this.f16062p.h(this.f16060n.d());
        } else {
            Integer num = this.f16065x;
            if (num != null && (textView = (TextView) findViewById(num.intValue())) != null) {
                kotlin.jvm.internal.i.e(textView, "findViewById<TextView>(it)");
                this.f16062p.g(textView.getLeft());
                this.f16062p.h(textView.getRight());
            }
        }
        Integer num2 = this.f16064r;
        if (num2 != null && (textView2 = (TextView) findViewById(num2.intValue())) != null) {
            kotlin.jvm.internal.i.e(textView2, "findViewById<TextView>(it)");
            this.f16061o.g(textView2.getLeft());
            this.f16061o.h(textView2.getRight());
        }
        getSwitchAnimator().start();
    }

    public final void setOnTabSelectedListener(c listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        this.f16063q = listener;
    }

    public final void setTabData(ArrayList<e> tabItemList) {
        kotlin.jvm.internal.i.f(tabItemList, "tabItemList");
        if (tabItemList.isEmpty()) {
            H7.b.i("FloatingTabView", "setTabData, tabItemList couldn't be empty.");
        }
        this.f16059m.clear();
        this.f16059m.addAll(tabItemList);
        o();
    }

    public final void setTabTouchAnimator(boolean z10) {
        this.f16045G = z10;
    }

    public final void t(int i10, boolean z10) {
        Integer num = this.f16064r;
        if (num != null && i10 == num.intValue()) {
            if (H7.a.b()) {
                H7.b.b("FloatingTabView", "switchTab selected tab is same " + i10 + " skip.");
                return;
            }
            return;
        }
        if (H7.a.b()) {
            H7.b.b("FloatingTabView", "switchTab id=" + i10 + " currentSelectedTab=" + this.f16064r);
        }
        this.f16065x = this.f16064r;
        this.f16064r = Integer.valueOf(i10);
        if (z10) {
            s();
        } else {
            r();
            invalidate();
        }
    }

    public final void u(TextView textView, boolean z10) {
        int textUnselectedColor;
        if (textView == null) {
            return;
        }
        if (z10 && textView.isEnabled()) {
            textUnselectedColor = getTextSelectedColor();
        } else if (z10 && !textView.isEnabled()) {
            textUnselectedColor = getTextSelectedDisEnabledColor();
        } else if (textView.isEnabled()) {
            textUnselectedColor = getTextUnselectedColor();
        } else if (!textView.isEnabled()) {
            textUnselectedColor = getTextUnselectedDisEnabledColor();
        } else {
            textUnselectedColor = getTextUnselectedColor();
        }
        textView.setTextColor(textUnselectedColor);
    }

    public /* synthetic */ FloatingTabView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingTabView(final Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m9.d a10;
        m9.d a11;
        m9.d a12;
        m9.d a13;
        m9.d a14;
        m9.d a15;
        m9.d a16;
        m9.d a17;
        m9.d a18;
        m9.d a19;
        m9.d b10;
        kotlin.jvm.internal.i.f(context, "context");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f34163c;
        a10 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Integer>() { // from class: com.android.contacts.framework.baseui.widget.FloatingTabView$textUnselectedDisEnabledColor$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                return Integer.valueOf(context.getColor(N0.e.f1854c));
            }
        });
        this.f16047a = a10;
        a11 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Integer>() { // from class: com.android.contacts.framework.baseui.widget.FloatingTabView$textSelectedDisEnabledColor$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                return Integer.valueOf(context.getColor(N0.e.f1852a));
            }
        });
        this.f16048b = a11;
        a12 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Integer>() { // from class: com.android.contacts.framework.baseui.widget.FloatingTabView$textSelectedColor$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                return Integer.valueOf(context.getColor(N0.e.f1852a));
            }
        });
        this.f16049c = a12;
        a13 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Integer>() { // from class: com.android.contacts.framework.baseui.widget.FloatingTabView$textUnselectedColor$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                return Integer.valueOf(context.getColor(N0.e.f1854c));
            }
        });
        this.f16050d = a13;
        a14 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Drawable>() { // from class: com.android.contacts.framework.baseui.widget.FloatingTabView$indicatorDrawable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Drawable invoke() {
                return A.h.f(FloatingTabView.this.getResources(), N0.g.f1904d, context.getTheme());
            }
        });
        this.f16051e = a14;
        a15 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Drawable>() { // from class: com.android.contacts.framework.baseui.widget.FloatingTabView$backgroundDrawable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Drawable invoke() {
                return A.h.f(FloatingTabView.this.getResources(), N0.g.f1903c, context.getTheme());
            }
        });
        this.f16052f = a15;
        a16 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Integer>() { // from class: com.android.contacts.framework.baseui.widget.FloatingTabView$textHorizontalPadding$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                return Integer.valueOf(context.getResources().getDimensionPixelSize(N0.f.f1892r));
            }
        });
        this.f16053g = a16;
        a17 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Integer>() { // from class: com.android.contacts.framework.baseui.widget.FloatingTabView$textVerticalPadding$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                return Integer.valueOf(context.getResources().getDimensionPixelSize(N0.f.f1893s));
            }
        });
        this.f16054h = a17;
        a18 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Integer>() { // from class: com.android.contacts.framework.baseui.widget.FloatingTabView$indicatorPadding$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                return Integer.valueOf(context.getResources().getDimensionPixelSize(N0.f.f1891q));
            }
        });
        this.f16055i = a18;
        a19 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Integer>() { // from class: com.android.contacts.framework.baseui.widget.FloatingTabView$indicatorMinWidth$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                return Integer.valueOf(context.getResources().getDimensionPixelSize(N0.f.f1890p));
            }
        });
        this.f16056j = a19;
        this.f16057k = 25;
        this.f16058l = 400L;
        this.f16059m = new ArrayList<>();
        int i11 = 31;
        kotlin.jvm.internal.f fVar = null;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        float f10 = 0.0f;
        this.f16060n = new b(i12, i13, i14, i15, f10, i11, fVar);
        this.f16061o = new b(0, 0, 0, 0, 0.0f, 31, null);
        this.f16062p = new b(i12, i13, i14, i15, f10, i11, fVar);
        this.f16066y = 1.0f;
        b10 = kotlin.a.b(new FloatingTabView$switchAnimator$2(this));
        this.f16046H = b10;
        setWillNotDraw(false);
        setForceDarkAllowed(false);
        setPaddingRelative(getPaddingStart() + getIndicatorPadding(), getPaddingTop(), getPaddingEnd() + getIndicatorPadding(), getPaddingBottom());
        setOrientation(0);
    }
}
