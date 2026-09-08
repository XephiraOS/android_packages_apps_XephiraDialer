package I1;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import com.android.incallui.Call;
import com.android.incallui.OplusCallList;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.TelecomAdapter;
import com.android.oplus.brand.BrandCenter;
import d2.InterfaceC0949b;
import java.util.ArrayList;

/* compiled from: ICallRepository.kt */
/* loaded from: classes.dex */
public interface c extends InterfaceC0949b {

    /* compiled from: ICallRepository.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public static Application a(c cVar) {
            return InterfaceC0949b.a.b(cVar);
        }

        public static BrandCenter b(c cVar) {
            return InterfaceC0949b.a.d(cVar);
        }

        public static OplusCallList c(c cVar) {
            return InterfaceC0949b.a.e(cVar);
        }

        public static OplusInCallPresenter d(c cVar) {
            return InterfaceC0949b.a.j(cVar);
        }

        public static TelecomAdapter e(c cVar) {
            return InterfaceC0949b.a.l(cVar);
        }
    }

    void A0(long j10);

    boolean A1();

    void C(int i10);

    void E(String str);

    Call E0();

    Call H(int i10, int i11);

    Call J();

    void J0();

    void M(int i10);

    long P();

    boolean P0();

    v<Boolean> Q0();

    void S(String str);

    boolean T0();

    void Y0();

    void a1(String str, boolean z10, String str2);

    void b();

    Call e1();

    LiveData<Boolean> g();

    Call j0();

    Call j1();

    ArrayList<String> k1();

    void n0();

    v<Boolean> o0();

    void r(boolean z10);

    boolean t();

    void y0(String str);

    Call y1();
}
