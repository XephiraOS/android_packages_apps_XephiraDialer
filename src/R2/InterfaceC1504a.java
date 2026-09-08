package r2;

import A2.l;
import android.app.Application;
import android.content.Context;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LiveData;
import com.android.incallui.Call;
import com.android.incallui.InCallPresenter;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.TelecomAdapter;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import com.android.incallui.clean.domain.interactor.NonNullObservableField;
import com.android.oplus.brand.BrandCenter;
import d2.InterfaceC0949b;
import kotlin.Pair;

/* compiled from: ICallStateRepository.kt */
/* renamed from: r2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC1504a extends InterfaceC0949b {

    /* compiled from: ICallStateRepository.kt */
    /* renamed from: r2.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0347a {
        public static Application a(InterfaceC1504a interfaceC1504a) {
            return InterfaceC0949b.a.b(interfaceC1504a);
        }

        public static BrandCenter b(InterfaceC1504a interfaceC1504a) {
            return InterfaceC0949b.a.d(interfaceC1504a);
        }

        public static A2.c c(InterfaceC1504a interfaceC1504a) {
            return InterfaceC0949b.a.f(interfaceC1504a);
        }

        public static Context d(InterfaceC1504a interfaceC1504a) {
            return InterfaceC0949b.a.h(interfaceC1504a);
        }

        public static l e(InterfaceC1504a interfaceC1504a) {
            return InterfaceC0949b.a.i(interfaceC1504a);
        }

        public static OplusInCallPresenter f(InterfaceC1504a interfaceC1504a) {
            return InterfaceC0949b.a.j(interfaceC1504a);
        }

        public static TelecomAdapter g(InterfaceC1504a interfaceC1504a) {
            return InterfaceC0949b.a.l(interfaceC1504a);
        }
    }

    void K(boolean z10);

    LocalObservableField<String> R();

    LiveData<Call> W();

    ObservableBoolean X0();

    void a();

    boolean d();

    void d0(Call call, int i10, String str);

    void e();

    ObservableBoolean g();

    Integer h(boolean z10);

    String h0(Call call);

    NonNullObservableField<InCallPresenter.InCallState> i();

    void i1();

    String l1();

    void m();

    void p();

    boolean p1(Call call, boolean z10, InCallPresenter.InCallState inCallState);

    Integer q();

    LiveData<Pair<Call, InCallPresenter.InCallState>> s1();

    boolean u(Call call, InCallPresenter.InCallState inCallState);

    void updateCallTime();

    Integer v1();

    String x1(Call call);
}
