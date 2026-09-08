package S3;

import S3.a;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.customize.contacts.camera.CameraSurfaceView;
import com.customize.contacts.widget.ScrollTabLayout;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.FeatureUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CameraMenuController.java */
/* loaded from: classes3.dex */
public final class a implements View.OnTouchListener {

    /* renamed from: b, reason: collision with root package name */
    public ScrollTabLayout f3408b;

    /* renamed from: c, reason: collision with root package name */
    public ScrollTabLayout f3409c;

    /* renamed from: d, reason: collision with root package name */
    public View f3410d;

    /* renamed from: e, reason: collision with root package name */
    public f f3411e;

    /* renamed from: f, reason: collision with root package name */
    public ViewGroup f3412f;

    /* renamed from: g, reason: collision with root package name */
    public View f3413g;

    /* renamed from: h, reason: collision with root package name */
    public View f3414h;

    /* renamed from: i, reason: collision with root package name */
    public Activity f3415i;

    /* renamed from: j, reason: collision with root package name */
    public final int f3416j;

    /* renamed from: k, reason: collision with root package name */
    public e f3417k;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3420n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3421o;

    /* renamed from: p, reason: collision with root package name */
    public Rect f3422p;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3424r;

    /* renamed from: x, reason: collision with root package name */
    public CameraSurfaceView f3425x;

    /* renamed from: y, reason: collision with root package name */
    public RelativeLayout f3426y;

    /* renamed from: a, reason: collision with root package name */
    public final List<TextView> f3407a = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public int f3418l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f3419m = 0;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3423q = true;

    /* compiled from: CameraMenuController.java */
    /* renamed from: S3.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class ViewTreeObserverOnGlobalLayoutListenerC0064a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f3427a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f3428b;

        public ViewTreeObserverOnGlobalLayoutListenerC0064a(View view, int i10) {
            this.f3427a = view;
            this.f3428b = i10;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f3427a.getWidth() > 0 && this.f3427a.getHeight() > 0) {
                this.f3427a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                a.this.u(this.f3428b);
            }
        }
    }

    /* compiled from: CameraMenuController.java */
    /* loaded from: classes3.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            a.this.f3425x.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            a.this.f3425x.getLocationOnScreen(iArr);
            a.this.f3408b.getLocationOnScreen(iArr2);
            if (FeatureUtil.N() && iArr[1] + a.this.f3425x.getHeight() > iArr2[1] + a.this.f3408b.getHeight()) {
                a.this.f3410d.setBackground(a.this.f3415i.getDrawable(R.drawable.pb_bg_menu_line_tablet));
            } else {
                a.this.f3410d.setBackground(a.this.f3415i.getDrawable(R.drawable.pb_bg_menu_line));
            }
            if (iArr[1] + a.this.f3425x.getHeight() > iArr2[1] && iArr[1] + a.this.f3425x.getHeight() < iArr2[1] + a.this.f3408b.getHeight()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) a.this.f3426y.getLayoutParams();
                layoutParams.bottomMargin = (iArr2[1] + a.this.f3408b.getHeight()) - (iArr[1] + a.this.f3425x.getHeight());
                a.this.f3426y.setLayoutParams(layoutParams);
                a.this.f3410d.setBackground(a.this.f3415i.getDrawable(R.drawable.pb_bg_menu_line_tablet));
            }
        }
    }

    /* compiled from: CameraMenuController.java */
    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f3431a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ScrollTabLayout f3432b;

        public c(int i10, ScrollTabLayout scrollTabLayout) {
            this.f3431a = i10;
            this.f3432b = scrollTabLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.x(this.f3431a, true);
            a.this.f3420n = true;
            if (a.this.f3421o) {
                this.f3432b.setVisibility(0);
            }
        }
    }

    /* compiled from: CameraMenuController.java */
    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f3434a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3435b;

        public d(int i10, int i11) {
            this.f3434a = i10;
            this.f3435b = i11;
        }
    }

    /* compiled from: CameraMenuController.java */
    /* loaded from: classes3.dex */
    public interface e {
        void x(int i10);
    }

    /* compiled from: CameraMenuController.java */
    /* loaded from: classes3.dex */
    public class f {

        /* renamed from: a, reason: collision with root package name */
        public View f3436a;

        public f(View view) {
            this.f3436a = view;
        }

        public final /* synthetic */ void b(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                this.f3436a.getLayoutParams().width = Math.round(((Float) animatedValue).floatValue());
                this.f3436a.requestLayout();
            }
        }

        public void c(int i10) {
            if (this.f3436a != null) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(r0.getWidth(), i10);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: S3.b
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        a.f.this.b(valueAnimator);
                    }
                });
                ofFloat.setDuration(100L);
                ofFloat.start();
            }
        }
    }

    public a(Activity activity, int i10, e eVar, boolean z10) {
        this.f3415i = activity;
        this.f3416j = i10;
        this.f3417k = eVar;
        this.f3424r = z10;
        p(activity);
    }

    public void A(int i10) {
        H7.b.b("CameraMenuController", "switchMenuItem");
        if (this.f3420n) {
            x(i10, false);
        }
    }

    public final void B() {
        this.f3425x.getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    public final void C(View view, int i10) {
        if (view.getWidth() > 0 && view.getHeight() > 0) {
            u(i10);
        } else {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0064a(view, i10));
        }
    }

    public boolean j(int i10, int i11) {
        r();
        return !this.f3422p.contains(i10, i11);
    }

    public int k(int i10, int i11, int i12) {
        TextView textView;
        Rect rect;
        if (this.f3420n && this.f3407a.size() >= 2) {
            for (int i13 = 0; i13 < this.f3407a.size() && (textView = this.f3407a.get(i13)) != null; i13++) {
                int[] iArr = new int[2];
                textView.getLocationOnScreen(iArr);
                if (this.f3424r) {
                    int i14 = iArr[0];
                    rect = new Rect(i14, iArr[1], textView.getWidth() + i14, iArr[1] + textView.getHeight());
                } else if (i12 != 90) {
                    if (i12 != 180) {
                        if (i12 != 270) {
                            int i15 = iArr[0];
                            rect = new Rect(i15, iArr[1], textView.getWidth() + i15, iArr[1] + textView.getHeight());
                        } else {
                            int height = iArr[0] - textView.getHeight();
                            int i16 = iArr[1];
                            rect = new Rect(height, i16, iArr[0], textView.getWidth() + i16);
                        }
                    } else {
                        rect = new Rect(iArr[0] - textView.getWidth(), iArr[1] - textView.getHeight(), iArr[0], iArr[1]);
                    }
                } else {
                    rect = new Rect(iArr[0], iArr[1] - textView.getWidth(), iArr[0] + textView.getHeight(), iArr[1]);
                }
                if (rect.contains(i10, i11)) {
                    return i13;
                }
            }
            return -1;
        }
        return -1;
    }

    public int l() {
        return this.f3419m;
    }

    public final int m(int i10) {
        TextView textView = this.f3407a.get(i10);
        if (textView != null) {
            return ((Integer) textView.getTag()).intValue();
        }
        return 0;
    }

    public final int n(int i10) {
        TextView textView = this.f3407a.get(i10);
        if (textView != null) {
            return textView.getWidth();
        }
        return 0;
    }

    public void o(MotionEvent motionEvent, int i10) {
        int k10 = k((int) motionEvent.getRawX(), (int) motionEvent.getRawY(), i10);
        s(false);
        H7.b.b("CameraMenuController", "handleClickEvent " + k10);
        A(k10);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }

    public void p(Activity activity) {
        if (this.f3424r) {
            this.f3408b = (ScrollTabLayout) activity.findViewById(R.id.menu_panel);
            this.f3426y = (RelativeLayout) activity.findViewById(R.id.control_panel);
            this.f3425x = (CameraSurfaceView) activity.findViewById(R.id.surface_view);
            this.f3408b.setVisibility(0);
            this.f3412f = this.f3408b.getContainerView();
            this.f3408b.setOnTouchListener(this);
        } else {
            ScrollTabLayout scrollTabLayout = (ScrollTabLayout) activity.findViewById(R.id.widescreen_menu_panel);
            this.f3409c = scrollTabLayout;
            scrollTabLayout.setVisibility(0);
            this.f3412f = this.f3409c.getContainerView();
            this.f3409c.setOnTouchListener(this);
        }
        View findViewById = activity.findViewById(R.id.menu_line);
        this.f3410d = findViewById;
        findViewById.setVisibility(4);
        this.f3411e = new f(this.f3410d);
        this.f3413g = new View(this.f3412f.getContext());
        this.f3414h = new View(this.f3412f.getContext());
        this.f3412f.addView(this.f3413g, new ViewGroup.LayoutParams(-2, -1));
        this.f3412f.addView(this.f3414h, new ViewGroup.LayoutParams(-2, -1));
    }

    public void q(int i10) {
        d[] dVarArr = {new d(R.string.business_card, 0), new d(R.string.oplus_qr_code, -1)};
        int i11 = 0;
        for (int i12 = 0; i12 < 2; i12++) {
            TextView textView = (TextView) View.inflate(this.f3415i, this.f3416j, null);
            textView.setText(this.f3415i.getString(dVarArr[i12].f3434a));
            textView.setTag(Integer.valueOf(dVarArr[i12].f3435b));
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            if (dVarArr[i12].f3435b == i10) {
                i11 = i12;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
            ViewGroup viewGroup = this.f3412f;
            viewGroup.addView(textView, viewGroup.getChildCount() - 1, layoutParams);
            this.f3407a.add(textView);
        }
        if (this.f3424r) {
            C(this.f3408b, i11);
        } else {
            C(this.f3409c, i11);
        }
        if (this.f3420n) {
            if (this.f3424r) {
                this.f3408b.setVisibility(0);
                return;
            } else {
                this.f3409c.setVisibility(0);
                return;
            }
        }
        this.f3421o = true;
    }

    public final void r() {
        if (this.f3422p == null) {
            Rect rect = new Rect();
            this.f3422p = rect;
            rect.set(0, 0, this.f3412f.getWidth(), this.f3412f.getHeight());
            H7.b.b("CameraMenuController", "innerGetNoFocusArea mNoFocusArea:" + this.f3422p);
        }
    }

    public void s(boolean z10) {
        this.f3423q = z10;
    }

    public final void t(ScrollTabLayout scrollTabLayout, int i10) {
        int i11;
        int i12;
        if (this.f3407a.size() == 0) {
            return;
        }
        int width = scrollTabLayout.getWidth() / 2;
        int n10 = n(0) / 2;
        if (width >= n10) {
            i11 = width - n10;
        } else {
            i11 = 0;
        }
        ViewGroup.LayoutParams layoutParams = this.f3413g.getLayoutParams();
        layoutParams.width = i11;
        layoutParams.height = -1;
        this.f3413g.requestLayout();
        int n11 = n(this.f3407a.size() - 1) / 2;
        if (width >= n11) {
            i12 = width - n11;
        } else {
            i12 = 0;
        }
        ViewGroup.LayoutParams layoutParams2 = this.f3414h.getLayoutParams();
        layoutParams2.width = i12;
        layoutParams2.height = -1;
        this.f3414h.requestLayout();
        if (i10 == 0) {
            int[] iArr = new int[2];
            this.f3412f.getLocationOnScreen(iArr);
            if (iArr[0] < 0) {
                scrollTabLayout.scrollTo(0, 0);
            }
            w(0, true);
            this.f3418l = i10;
            this.f3420n = true;
            if (this.f3421o) {
                scrollTabLayout.setVisibility(0);
                return;
            }
            return;
        }
        scrollTabLayout.post(new c(i10, scrollTabLayout));
    }

    public final void u(int i10) {
        if (this.f3424r) {
            t(this.f3408b, i10);
            B();
        } else {
            t(this.f3409c, i10);
        }
    }

    public void v(int i10) {
        this.f3419m = i10;
    }

    public final void w(int i10, boolean z10) {
        TextView textView = this.f3407a.get(i10);
        if (textView != null) {
            if (this.f3420n && z10) {
                textView.playSoundEffect(0);
            }
            if (z10) {
                textView.setTextColor(-1);
                textView.setShadowLayer(0.0f, 0.0f, 0.0f, -1);
                if (this.f3424r) {
                    this.f3411e.c(textView.getWidth() - this.f3415i.getResources().getDimensionPixelOffset(R.dimen.camera_scroll_tab_text_bg_width));
                } else {
                    this.f3411e.c(textView.getWidth() + this.f3415i.getResources().getDimensionPixelOffset(R.dimen.camera_ver_scroll_tab_text_bg_width));
                }
            }
            textView.setSelected(z10);
        }
        if (z10) {
            for (int i11 = 0; i11 < this.f3407a.size(); i11++) {
                if (i11 != i10) {
                    this.f3407a.get(i11).setShadowLayer(4.0f, 0.0f, 0.0f, this.f3415i.getColor(R.color.pb_color_menu_line_tablet));
                    this.f3407a.get(i11).setTextColor(-1);
                }
            }
        }
    }

    public final void x(int i10, boolean z10) {
        int i11;
        e eVar;
        if (i10 < this.f3407a.size() && i10 >= 0 && i10 != (i11 = this.f3418l)) {
            if (i11 >= 0) {
                w(i11, false);
            }
            this.f3418l = i10;
            w(i10, true);
            View childAt = this.f3412f.getChildAt(0);
            if (childAt == null) {
                return;
            }
            if (this.f3424r) {
                int width = childAt.getWidth();
                for (int i12 = 0; i12 < i10; i12++) {
                    width += n(i12);
                }
                int n10 = (width + (n(i10) / 2)) - (this.f3408b.getWidth() / 2);
                if (z10) {
                    this.f3408b.scrollTo(n10, 0);
                } else {
                    this.f3408b.smoothScrollTo(n10, 0);
                }
            } else {
                int width2 = childAt.getWidth();
                for (int i13 = 0; i13 < i10; i13++) {
                    width2 += n(i13);
                }
                int n11 = (width2 + (n(i10) / 2)) - (this.f3409c.getWidth() / 2);
                if (z10) {
                    this.f3409c.scrollTo(n11, 0);
                } else {
                    this.f3409c.smoothScrollTo(n11, 0);
                }
            }
            if (!z10 && (eVar = this.f3417k) != null) {
                eVar.x(m(this.f3418l));
            }
        }
    }

    public void y() {
        H7.b.b("CameraMenuController", "slideToNext");
        if (this.f3420n && this.f3418l < this.f3407a.size() - 1) {
            x(this.f3418l + 1, false);
        }
    }

    public void z() {
        int i10;
        H7.b.b("CameraMenuController", "slideToPrevious");
        if (this.f3420n && (i10 = this.f3418l) > 0) {
            x(i10 - 1, false);
        }
    }
}
