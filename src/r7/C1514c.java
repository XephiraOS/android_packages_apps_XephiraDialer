package r7;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.COUICollapsableAppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: AppBarUtil.kt */
/* renamed from: r7.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1514c {

    /* renamed from: a, reason: collision with root package name */
    public static final C1514c f36543a = new C1514c();

    /* compiled from: AppBarUtil.kt */
    /* renamed from: r7.c$a */
    /* loaded from: classes3.dex */
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppBarLayout f36544a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f36545b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f36546c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1512a f36547d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1515d f36548e;

        public a(AppBarLayout appBarLayout, int i10, AppCompatActivity appCompatActivity, InterfaceC1512a interfaceC1512a, InterfaceC1515d interfaceC1515d) {
            this.f36544a = appBarLayout;
            this.f36545b = i10;
            this.f36546c = appCompatActivity;
            this.f36547d = interfaceC1512a;
            this.f36548e = interfaceC1515d;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0072  */
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onGlobalLayout() {
            /*
                r5 = this;
                com.google.android.material.appbar.AppBarLayout r0 = r5.f36544a
                int r0 = r0.getMeasuredHeight()
                int r1 = r5.f36545b
                r2 = 1
                if (r1 == r2) goto L2d
                r2 = 2
                if (r1 == r2) goto L13
                r2 = 3
                if (r1 == r2) goto L13
                r1 = 0
                goto L46
            L13:
                androidx.appcompat.app.AppCompatActivity r1 = r5.f36546c
                android.content.res.Resources r1 = r1.getResources()
                int r2 = m7.C1342c.f35176c
                int r1 = r1.getDimensionPixelSize(r2)
                androidx.appcompat.app.AppCompatActivity r2 = r5.f36546c
                android.content.res.Resources r2 = r2.getResources()
                int r3 = m7.C1342c.f35174a
                int r2 = r2.getDimensionPixelSize(r3)
            L2b:
                int r1 = r1 - r2
                goto L46
            L2d:
                androidx.appcompat.app.AppCompatActivity r1 = r5.f36546c
                android.content.res.Resources r1 = r1.getResources()
                int r2 = m7.C1342c.f35177d
                int r1 = r1.getDimensionPixelSize(r2)
                androidx.appcompat.app.AppCompatActivity r2 = r5.f36546c
                android.content.res.Resources r2 = r2.getResources()
                int r3 = m7.C1342c.f35174a
                int r2 = r2.getDimensionPixelSize(r3)
                goto L2b
            L46:
                int r0 = r0 + r1
                r7.a r1 = r5.f36547d
                int r1 = r1.J0()
                if (r1 <= 0) goto L6e
                androidx.appcompat.app.AppCompatActivity r1 = r5.f36546c
                r7.a r2 = r5.f36547d
                int r2 = r2.J0()
                android.view.View r1 = r1.findViewById(r2)
                android.view.ViewGroup r1 = (android.view.ViewGroup) r1
                if (r1 == 0) goto L6e
                int r2 = r1.getPaddingLeft()
                int r3 = r1.getPaddingRight()
                int r4 = r1.getPaddingBottom()
                r1.setPadding(r2, r0, r3, r4)
            L6e:
                r7.d r1 = r5.f36548e
                if (r1 == 0) goto L75
                r1.I0(r0)
            L75:
                com.google.android.material.appbar.AppBarLayout r0 = r5.f36544a
                android.view.ViewTreeObserver r0 = r0.getViewTreeObserver()
                r0.removeOnGlobalLayoutListener(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: r7.C1514c.a.onGlobalLayout():void");
        }
    }

    public static final void b(InterfaceC1512a interfaceC1512a) {
        COUIToolbar toolbar;
        if (interfaceC1512a != null && interfaceC1512a.S()) {
            AppBarLayout a12 = interfaceC1512a.a1();
            if ((a12 == null || a12.getVisibility() != 8) && (toolbar = interfaceC1512a.getToolbar()) != null) {
                toolbar.refresh();
                toolbar.setTitle(interfaceC1512a.C0());
            }
        }
    }

    public static final void c(AppCompatActivity appCompatActivity, InterfaceC1512a interfaceC1512a, int i10, InterfaceC1515d interfaceC1515d) {
        if (interfaceC1512a != null && interfaceC1512a.S()) {
            AppBarLayout a12 = interfaceC1512a.a1();
            if ((a12 == null || a12.getVisibility() != 8) && interfaceC1512a.getToolbar() != null) {
                d(interfaceC1512a);
                g(interfaceC1512a, interfaceC1512a.C0());
                ViewGroup X02 = interfaceC1512a.X0();
                if (X02 != null) {
                    X02.setTranslationZ(-1.0f);
                }
                h(interfaceC1512a, interfaceC1512a.n());
                AppBarLayout a13 = interfaceC1512a.a1();
                if (a13 != null) {
                    a13.getViewTreeObserver().addOnGlobalLayoutListener(new a(a13, i10, appCompatActivity, interfaceC1512a, interfaceC1515d));
                }
            }
        }
    }

    public static final void d(InterfaceC1512a interfaceC1512a) {
        COUIToolbar toolbar = interfaceC1512a.getToolbar();
        if (toolbar != null) {
            toolbar.setIsTitleCenterStyle(interfaceC1512a.V());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void e(AppCompatActivity activity, int i10, InterfaceC1515d interfaceC1515d) {
        InterfaceC1512a interfaceC1512a;
        i.f(activity, "activity");
        if (activity instanceof InterfaceC1512a) {
            interfaceC1512a = (InterfaceC1512a) activity;
        } else {
            interfaceC1512a = null;
        }
        c(activity, interfaceC1512a, i10, interfaceC1515d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void f(Fragment fragment, int i10, InterfaceC1515d interfaceC1515d) {
        InterfaceC1512a interfaceC1512a;
        i.f(fragment, "fragment");
        if (fragment instanceof InterfaceC1512a) {
            interfaceC1512a = (InterfaceC1512a) fragment;
        } else {
            interfaceC1512a = null;
        }
        FragmentActivity activity = fragment.getActivity();
        i.d(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        c((AppCompatActivity) activity, interfaceC1512a, i10, interfaceC1515d);
    }

    public static final void g(InterfaceC1512a interfaceC1512a, String str) {
        q qVar;
        COUIToolbar toolbar;
        if (interfaceC1512a != null && interfaceC1512a.a1() != null) {
            CollapsingToolbarLayout W02 = interfaceC1512a.W0();
            if (W02 != null) {
                W02.setTitle(str);
                COUIToolbar toolbar2 = interfaceC1512a.getToolbar();
                if (toolbar2 != null) {
                    toolbar2.setTitle(str);
                }
                qVar = q.f35511a;
            } else {
                qVar = null;
            }
            if (qVar == null && (toolbar = interfaceC1512a.getToolbar()) != null) {
                toolbar.setTitle(str);
            }
        }
    }

    public static final void h(InterfaceC1512a interfaceC1512a, CharSequence charSequence) {
        final AppBarLayout a12;
        TextView E02;
        boolean z10;
        int i10;
        if (interfaceC1512a != null && (a12 = interfaceC1512a.a1()) != null && (E02 = interfaceC1512a.E0()) != null) {
            boolean z11 = true;
            boolean z12 = !TextUtils.isEmpty(charSequence);
            if (E02.getVisibility() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z12 == z10) {
                z11 = false;
            }
            E02.setText(charSequence);
            if (z12) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            E02.setVisibility(i10);
            if (z11) {
                if (E02.getMeasuredHeight() == 0) {
                    E02.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                }
                if (a12 instanceof COUICollapsableAppBarLayout) {
                    a12.post(new Runnable() { // from class: r7.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            C1514c.i(AppBarLayout.this);
                        }
                    });
                }
            }
        }
    }

    public static final void i(AppBarLayout appBarLayout) {
        i.f(appBarLayout, "$appBarLayout");
        ((COUICollapsableAppBarLayout) appBarLayout).updateSubtitle();
    }
}
