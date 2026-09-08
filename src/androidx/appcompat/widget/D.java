package androidx.appcompat.widget;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.LinearLayoutCompat;
import e.C0961a;
import j.C1144a;

/* compiled from: ScrollingTabContainerView.java */
/* loaded from: classes.dex */
public class D extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: j, reason: collision with root package name */
    public static final Interpolator f7664j = new DecelerateInterpolator();

    /* renamed from: a, reason: collision with root package name */
    public Runnable f7665a;

    /* renamed from: b, reason: collision with root package name */
    public c f7666b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayoutCompat f7667c;

    /* renamed from: d, reason: collision with root package name */
    public Spinner f7668d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7669e;

    /* renamed from: f, reason: collision with root package name */
    public int f7670f;

    /* renamed from: g, reason: collision with root package name */
    public int f7671g;

    /* renamed from: h, reason: collision with root package name */
    public int f7672h;

    /* renamed from: i, reason: collision with root package name */
    public int f7673i;

    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f7674a;

        public a(View view) {
            this.f7674a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            D.this.smoothScrollTo(this.f7674a.getLeft() - ((D.this.getWidth() - this.f7674a.getWidth()) / 2), 0);
            D.this.f7665a = null;
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class b extends BaseAdapter {
        public b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return D.this.f7667c.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            return ((d) D.this.f7667c.getChildAt(i10)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                return D.this.c((ActionBar.b) getItem(i10), true);
            }
            ((d) view).a((ActionBar.b) getItem(i10));
            return view;
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z10;
            ((d) view).b().e();
            int childCount = D.this.f7667c.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = D.this.f7667c.getChildAt(i10);
                if (childAt == view) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                childAt.setSelected(z10);
            }
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class d extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f7678a;

        /* renamed from: b, reason: collision with root package name */
        public ActionBar.b f7679b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f7680c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f7681d;

        /* renamed from: e, reason: collision with root package name */
        public View f7682e;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public d(android.content.Context r4, androidx.appcompat.app.ActionBar.b r5, boolean r6) {
            /*
                r2 = this;
                androidx.appcompat.widget.D.this = r3
                int r3 = e.C0961a.f30105d
                r0 = 0
                r2.<init>(r4, r0, r3)
                r1 = 16842964(0x10100d4, float:2.3694152E-38)
                int[] r1 = new int[]{r1}
                r2.f7678a = r1
                r2.f7679b = r5
                r5 = 0
                androidx.appcompat.widget.K r3 = androidx.appcompat.widget.K.w(r4, r0, r1, r3, r5)
                boolean r4 = r3.s(r5)
                if (r4 == 0) goto L25
                android.graphics.drawable.Drawable r4 = r3.g(r5)
                r2.setBackgroundDrawable(r4)
            L25:
                r3.y()
                if (r6 == 0) goto L30
                r3 = 8388627(0x800013, float:1.175497E-38)
                r2.setGravity(r3)
            L30:
                r2.c()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.D.d.<init>(androidx.appcompat.widget.D, android.content.Context, androidx.appcompat.app.ActionBar$b, boolean):void");
        }

        public void a(ActionBar.b bVar) {
            this.f7679b = bVar;
            c();
        }

        public ActionBar.b b() {
            return this.f7679b;
        }

        public void c() {
            ActionBar.b bVar = this.f7679b;
            View b10 = bVar.b();
            CharSequence charSequence = null;
            if (b10 != null) {
                ViewParent parent = b10.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b10);
                    }
                    addView(b10);
                }
                this.f7682e = b10;
                TextView textView = this.f7680c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f7681d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f7681d.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f7682e;
            if (view != null) {
                removeView(view);
                this.f7682e = null;
            }
            Drawable c10 = bVar.c();
            CharSequence d10 = bVar.d();
            if (c10 != null) {
                if (this.f7681d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f7681d = appCompatImageView;
                }
                this.f7681d.setImageDrawable(c10);
                this.f7681d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f7681d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f7681d.setImageDrawable(null);
                }
            }
            boolean z10 = !TextUtils.isEmpty(d10);
            if (z10) {
                if (this.f7680c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, C0961a.f30106e);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f7680c = appCompatTextView;
                }
                this.f7680c.setText(d10);
                this.f7680c.setVisibility(0);
            } else {
                TextView textView2 = this.f7680c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f7680c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f7681d;
            if (imageView3 != null) {
                imageView3.setContentDescription(bVar.a());
            }
            if (!z10) {
                charSequence = bVar.a();
            }
            P.a(this, charSequence);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (D.this.f7670f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i12 = D.this.f7670f;
                if (measuredWidth > i12) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z10) {
            boolean z11;
            if (isSelected() != z10) {
                z11 = true;
            } else {
                z11 = false;
            }
            super.setSelected(z10);
            if (z11 && z10) {
                sendAccessibilityEvent(4);
            }
        }
    }

    public void a(int i10) {
        View childAt = this.f7667c.getChildAt(i10);
        Runnable runnable = this.f7665a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f7665a = aVar;
        post(aVar);
    }

    public final Spinner b() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, C0961a.f30109h);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    public d c(ActionBar.b bVar, boolean z10) {
        d dVar = new d(this, getContext(), bVar, z10);
        if (z10) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f7672h));
        } else {
            dVar.setFocusable(true);
            if (this.f7666b == null) {
                this.f7666b = new c();
            }
            dVar.setOnClickListener(this.f7666b);
        }
        return dVar;
    }

    public final boolean d() {
        Spinner spinner = this.f7668d;
        if (spinner != null && spinner.getParent() == this) {
            return true;
        }
        return false;
    }

    public final void e() {
        if (d()) {
            return;
        }
        if (this.f7668d == null) {
            this.f7668d = b();
        }
        removeView(this.f7667c);
        addView(this.f7668d, new ViewGroup.LayoutParams(-2, -1));
        if (this.f7668d.getAdapter() == null) {
            this.f7668d.setAdapter((SpinnerAdapter) new b());
        }
        Runnable runnable = this.f7665a;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f7665a = null;
        }
        this.f7668d.setSelection(this.f7673i);
    }

    public final boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.f7668d);
        addView(this.f7667c, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f7668d.getSelectedItemPosition());
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f7665a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C1144a b10 = C1144a.b(getContext());
        setContentHeight(b10.f());
        this.f7671g = b10.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f7665a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
        ((d) view).b().e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        boolean z10;
        int mode = View.MeasureSpec.getMode(i10);
        if (mode == 1073741824) {
            z10 = true;
        } else {
            z10 = false;
        }
        setFillViewport(z10);
        int childCount = this.f7667c.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.f7670f = (int) (View.MeasureSpec.getSize(i10) * 0.4f);
            } else {
                this.f7670f = View.MeasureSpec.getSize(i10) / 2;
            }
            this.f7670f = Math.min(this.f7670f, this.f7671g);
        } else {
            this.f7670f = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f7672h, 1073741824);
        if (!z10 && this.f7669e) {
            this.f7667c.measure(0, makeMeasureSpec);
            if (this.f7667c.getMeasuredWidth() > View.MeasureSpec.getSize(i10)) {
                e();
            } else {
                f();
            }
        } else {
            f();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i10, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z10 && measuredWidth != measuredWidth2) {
            setTabSelected(this.f7673i);
        }
    }

    public void setAllowCollapse(boolean z10) {
        this.f7669e = z10;
    }

    public void setContentHeight(int i10) {
        this.f7672h = i10;
        requestLayout();
    }

    public void setTabSelected(int i10) {
        boolean z10;
        this.f7673i = i10;
        int childCount = this.f7667c.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = this.f7667c.getChildAt(i11);
            if (i11 == i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            childAt.setSelected(z10);
            if (z10) {
                a(i10);
            }
        }
        Spinner spinner = this.f7668d;
        if (spinner != null && i10 >= 0) {
            spinner.setSelection(i10);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
