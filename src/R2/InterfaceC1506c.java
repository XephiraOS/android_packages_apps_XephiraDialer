package r2;

import android.app.Application;
import android.content.Context;
import com.android.incallui.Call;
import com.android.incallui.InCallPresenter;
import com.android.incallui.OplusCallList;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.OplusProximitySensor;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import d2.InterfaceC0949b;

/* compiled from: INavigationRepository.kt */
/* renamed from: r2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC1506c extends InterfaceC0949b {

    /* compiled from: INavigationRepository.kt */
    /* renamed from: r2.c$a */
    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ void a(InterfaceC1506c interfaceC1506c, boolean z10, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    z10 = false;
                }
                interfaceC1506c.Z0(z10);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateWindowTypeForMO");
        }

        public static /* synthetic */ void b(InterfaceC1506c interfaceC1506c, boolean z10, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    z10 = false;
                }
                interfaceC1506c.m0(z10);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateWindowTypeForMT");
        }

        public static Application c(InterfaceC1506c interfaceC1506c) {
            return InterfaceC0949b.a.b(interfaceC1506c);
        }

        public static OplusCallList d(InterfaceC1506c interfaceC1506c) {
            return InterfaceC0949b.a.e(interfaceC1506c);
        }

        public static Context e(InterfaceC1506c interfaceC1506c) {
            return InterfaceC0949b.a.h(interfaceC1506c);
        }

        public static OplusInCallPresenter f(InterfaceC1506c interfaceC1506c) {
            return InterfaceC0949b.a.j(interfaceC1506c);
        }

        public static OplusProximitySensor g(InterfaceC1506c interfaceC1506c) {
            return InterfaceC0949b.a.k(interfaceC1506c);
        }

        public static boolean h(InterfaceC1506c interfaceC1506c) {
            if (interfaceC1506c.W0().s0() != null) {
                return true;
            }
            return false;
        }
    }

    boolean I0();

    void K0();

    boolean V();

    void V0();

    LocalObservableField<Integer> W0();

    void Z0(boolean z10);

    void d1(InCallPresenter.InCallState inCallState);

    boolean g0(Integer num, boolean z10);

    void i0(Call call);

    void m0(boolean z10);

    boolean r0();

    void t0();

    void t1();

    boolean w();

    void w0(Integer num);

    boolean x0();
}
