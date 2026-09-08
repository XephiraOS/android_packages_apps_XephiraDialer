package r2;

import A2.j;
import android.content.Context;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import com.android.incallui.Call;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import d2.InterfaceC0949b;

/* compiled from: IContactInfoRepository.kt */
/* renamed from: r2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC1505b extends InterfaceC0949b {

    /* compiled from: IContactInfoRepository.kt */
    /* renamed from: r2.b$a */
    /* loaded from: classes.dex */
    public static final class a {
        public static j a(InterfaceC1505b interfaceC1505b) {
            return InterfaceC0949b.a.g(interfaceC1505b);
        }

        public static Context b(InterfaceC1505b interfaceC1505b) {
            return InterfaceC0949b.a.h(interfaceC1505b);
        }

        public static OplusInCallPresenter c(InterfaceC1505b interfaceC1505b) {
            return InterfaceC0949b.a.j(interfaceC1505b);
        }

        public static void d(InterfaceC1505b interfaceC1505b) {
            InterfaceC0949b.a.m(interfaceC1505b);
        }
    }

    ObservableBoolean D();

    LocalObservableField<String> M0();

    void N();

    ObservableInt O0();

    void Y(Call call);

    LocalObservableField<String> n1();

    LocalObservableField<String> q0();

    void q1(String str, Integer num);

    LocalObservableField<String> w1();

    LocalObservableField<String> x();

    void y();
}
