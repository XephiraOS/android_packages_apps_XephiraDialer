package T6;

import S6.c;
import android.util.Log;
import android.view.OplusBaseLayoutParams;
import android.view.WindowManager;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;
import com.oplus.inner.view.WindowManagerWrapper;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefObject;

/* compiled from: WindowManagerNative.java */
/* loaded from: classes3.dex */
public class a {

    /* compiled from: WindowManagerNative.java */
    /* renamed from: T6.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0067a {

        /* renamed from: a, reason: collision with root package name */
        public static int f3757a;

        /* renamed from: b, reason: collision with root package name */
        public static int f3758b;

        /* renamed from: c, reason: collision with root package name */
        public static int f3759c;

        /* renamed from: d, reason: collision with root package name */
        public static int f3760d;

        /* renamed from: e, reason: collision with root package name */
        public static int f3761e;

        /* renamed from: f, reason: collision with root package name */
        public static int f3762f;

        /* renamed from: g, reason: collision with root package name */
        public static int f3763g;

        /* renamed from: h, reason: collision with root package name */
        public static int f3764h;

        /* renamed from: i, reason: collision with root package name */
        public static int f3765i;

        /* renamed from: j, reason: collision with root package name */
        public static int f3766j;

        /* renamed from: k, reason: collision with root package name */
        public static int f3767k;

        /* renamed from: l, reason: collision with root package name */
        public static int f3768l;

        /* renamed from: m, reason: collision with root package name */
        public static int f3769m;

        /* renamed from: n, reason: collision with root package name */
        public static int f3770n;

        /* renamed from: o, reason: collision with root package name */
        public static int f3771o;

        /* renamed from: p, reason: collision with root package name */
        public static int f3772p;

        /* renamed from: q, reason: collision with root package name */
        public static int f3773q;

        /* renamed from: r, reason: collision with root package name */
        public static int f3774r;

        /* renamed from: s, reason: collision with root package name */
        public static int f3775s;

        /* renamed from: t, reason: collision with root package name */
        public static int f3776t;

        /* renamed from: u, reason: collision with root package name */
        public static int f3777u;

        /* renamed from: v, reason: collision with root package name */
        public static int f3778v;

        /* renamed from: w, reason: collision with root package name */
        public static int f3779w;

        /* renamed from: x, reason: collision with root package name */
        public static int f3780x;

        /* compiled from: WindowManagerNative.java */
        /* renamed from: T6.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0068a {
            private static RefObject<Integer> DEFAULT_STATUS_BAR;
            private static RefObject<Integer> DISABLE_STATUS_BAR;
            private static RefObject<Integer> ENABLE_STATUS_BAR;
            private static RefObject<Integer> IGNORE_HOME_KEY;
            private static RefObject<Integer> IGNORE_HOME_MENU_KEY;
            private static RefObject<Integer> IGNORE_MENU_KEY;
            private static RefObject<Integer> UNSET_ANY_KEY;
            private static RefObject<Integer> ignoreHomeMenuKey;
            private static RefObject<Integer> isDisableStatusBar;

            static {
                RefClass.load((Class<?>) C0068a.class, (Class<?>) WindowManager.LayoutParams.class);
            }
        }

        static {
            try {
                if (c.l()) {
                    f3757a = ((Integer) a.c()).intValue();
                    f3758b = ((Integer) a.d()).intValue();
                    f3759c = ((Integer) a.e()).intValue();
                    f3760d = ((Integer) a.f()).intValue();
                    f3761e = ((Integer) a.g()).intValue();
                    f3762f = ((Integer) a.h()).intValue();
                    f3763g = ((Integer) a.i()).intValue();
                    f3764h = 2020;
                    f3765i = 16;
                    f3766j = 2024;
                    f3767k = 2019;
                    f3768l = 2032;
                    f3769m = 2039;
                    f3770n = 2026;
                    f3771o = 2016;
                    f3772p = 2004;
                    f3773q = 2009;
                    f3774r = 2027;
                    f3775s = 2036;
                    f3776t = 2015;
                    f3777u = 2000;
                    f3778v = 2014;
                    f3779w = 2017;
                    f3780x = 2038;
                    return;
                }
                if (c.f()) {
                    if (c.g()) {
                        f3758b = ((Integer) C0068a.IGNORE_HOME_MENU_KEY.get(null)).intValue();
                        f3757a = ((Integer) C0068a.UNSET_ANY_KEY.get(null)).intValue();
                        f3759c = ((Integer) C0068a.IGNORE_HOME_KEY.get(null)).intValue();
                        f3760d = ((Integer) C0068a.IGNORE_MENU_KEY.get(null)).intValue();
                    }
                    f3761e = ((Integer) C0068a.DEFAULT_STATUS_BAR.get(null)).intValue();
                    f3762f = ((Integer) C0068a.DISABLE_STATUS_BAR.get(null)).intValue();
                    f3763g = ((Integer) C0068a.ENABLE_STATUS_BAR.get(null)).intValue();
                    return;
                }
                throw new UnSupportedApiVersionException();
            } catch (Throwable th) {
                Log.e("WindowManagerNative", th.toString());
            }
        }

        public static void a(WindowManager.LayoutParams layoutParams, int i10) {
            if (c.n()) {
                try {
                    OplusBaseLayoutParams oplusBaseLayoutParams = (OplusBaseLayoutParams) R6.a.a(OplusBaseLayoutParams.class, layoutParams);
                    if (oplusBaseLayoutParams != null) {
                        oplusBaseLayoutParams.ignoreHomeMenuKey = i10;
                        return;
                    }
                    return;
                } catch (NoSuchFieldError e10) {
                    Log.e("WindowManagerNative", e10.toString());
                    throw new UnSupportedApiVersionException("no permission to access the blocked field:" + e10.toString());
                }
            }
            if (c.j()) {
                WindowManagerWrapper.LayoutParamsWrapper.setHomeAndMenuKeyState(layoutParams, i10);
            } else if (c.l()) {
                a.q(layoutParams, i10);
            } else {
                if (c.g()) {
                    C0068a.ignoreHomeMenuKey.set(layoutParams, Integer.valueOf(i10));
                    return;
                }
                throw new UnSupportedApiVersionException("not supported before N");
            }
        }

        public static void b(WindowManager.LayoutParams layoutParams, int i10) {
            if (c.n()) {
                try {
                    OplusBaseLayoutParams oplusBaseLayoutParams = (OplusBaseLayoutParams) R6.a.a(OplusBaseLayoutParams.class, layoutParams);
                    if (oplusBaseLayoutParams != null) {
                        oplusBaseLayoutParams.isDisableStatusBar = i10;
                        return;
                    }
                    return;
                } catch (NoSuchFieldError e10) {
                    Log.e("WindowManagerNative", e10.toString());
                    throw new UnSupportedApiVersionException("no permission to access the blocked field:" + e10.toString());
                }
            }
            if (c.j()) {
                WindowManagerWrapper.LayoutParamsWrapper.setStatusBarStateByWindowManager(layoutParams, i10);
            } else if (c.l()) {
                a.r(layoutParams, i10);
            } else {
                if (c.f()) {
                    C0068a.isDisableStatusBar.set(layoutParams, Integer.valueOf(i10));
                    return;
                }
                throw new UnSupportedApiVersionException("not supported before M");
            }
        }
    }

    public static /* synthetic */ Object c() {
        return p();
    }

    public static /* synthetic */ Object d() {
        return n();
    }

    public static /* synthetic */ Object e() {
        return m();
    }

    public static /* synthetic */ Object f() {
        return o();
    }

    public static /* synthetic */ Object g() {
        return j();
    }

    public static /* synthetic */ Object h() {
        return k();
    }

    public static /* synthetic */ Object i() {
        return l();
    }

    public static Object j() {
        if (c.n() || c.j()) {
            return 0;
        }
        return b.a();
    }

    public static Object k() {
        if (c.n() || c.j()) {
            return 1;
        }
        return b.b();
    }

    public static Object l() {
        if (c.n() || c.j()) {
            return 2;
        }
        return b.c();
    }

    public static Object m() {
        if (c.n() || c.j()) {
            return 2;
        }
        return b.d();
    }

    public static Object n() {
        if (c.n() || c.j()) {
            return 1;
        }
        return b.e();
    }

    public static Object o() {
        if (c.n() || c.j()) {
            return 3;
        }
        return b.f();
    }

    public static Object p() {
        if (c.n() || c.j()) {
            return 0;
        }
        return b.g();
    }

    public static void q(WindowManager.LayoutParams layoutParams, int i10) {
        b.h(layoutParams, i10);
    }

    public static void r(WindowManager.LayoutParams layoutParams, int i10) {
        b.i(layoutParams, i10);
    }
}
