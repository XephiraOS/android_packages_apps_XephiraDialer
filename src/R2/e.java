package r2;

import android.content.Context;
import android.util.DisplayMetrics;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.mvvm.utils.h;
import com.android.incallui.mvvm.utils.y;
import d2.InterfaceC0949b;

/* compiled from: ISystemConfigRepository.kt */
/* loaded from: classes.dex */
public interface e extends InterfaceC0949b {

    /* compiled from: ISystemConfigRepository.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public static Context a(e eVar) {
            return InterfaceC0949b.a.h(eVar);
        }

        public static OplusInCallPresenter b(e eVar) {
            return InterfaceC0949b.a.j(eVar);
        }

        public static void c(e eVar) {
            InterfaceC0949b.a.m(eVar);
        }
    }

    int A();

    int B1();

    int C1();

    int G0();

    h<Integer> H0();

    int I();

    y<DisplayMetrics> L();

    int O();

    int T();

    int X();

    int Z();

    y<Boolean> a0();

    int b0();

    y<Integer> f1();

    int l();

    int u0();

    int v();

    boolean v0();

    int z0();

    int z1();
}
