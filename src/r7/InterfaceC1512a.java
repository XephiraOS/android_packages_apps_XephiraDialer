package r7;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.TextView;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import m7.e;

/* compiled from: AppBarConfig.kt */
/* renamed from: r7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC1512a {

    /* compiled from: AppBarConfig.kt */
    /* renamed from: r7.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0349a {
        public static CollapsingToolbarLayout a(InterfaceC1512a interfaceC1512a) {
            return null;
        }

        public static boolean b(InterfaceC1512a interfaceC1512a) {
            return true;
        }

        public static String c(InterfaceC1512a interfaceC1512a) {
            return null;
        }

        public static int d(InterfaceC1512a interfaceC1512a) {
            return -1;
        }

        public static int e(InterfaceC1512a interfaceC1512a) {
            return e.f35185g;
        }

        public static int f(InterfaceC1512a interfaceC1512a) {
            return e.f35186h;
        }

        public static boolean g(InterfaceC1512a interfaceC1512a) {
            return true;
        }

        public static String h(InterfaceC1512a interfaceC1512a) {
            return null;
        }

        public static ViewGroup i(InterfaceC1512a interfaceC1512a) {
            AppBarLayout a12 = interfaceC1512a.a1();
            if (a12 != null) {
                return (ViewGroup) a12.findViewById(e.f35181c);
            }
            return null;
        }

        public static TextView j(InterfaceC1512a interfaceC1512a) {
            AppBarLayout a12 = interfaceC1512a.a1();
            if (a12 != null) {
                return (TextView) a12.findViewById(e.f35182d);
            }
            return null;
        }

        public static COUIToolbar k(InterfaceC1512a interfaceC1512a) {
            AppBarLayout a12 = interfaceC1512a.a1();
            if (a12 != null) {
                return (COUIToolbar) a12.findViewById(e.f35183e);
            }
            return null;
        }

        public static int l(InterfaceC1512a interfaceC1512a) {
            return 1;
        }

        public static boolean m(InterfaceC1512a interfaceC1512a) {
            return false;
        }
    }

    String C0();

    TextView E0();

    int J();

    int J0();

    boolean S();

    boolean V();

    CollapsingToolbarLayout W0();

    ViewGroup X0();

    Drawable Y();

    int a0();

    AppBarLayout a1();

    COUIToolbar getToolbar();

    boolean i0();

    String n();

    boolean w();
}
