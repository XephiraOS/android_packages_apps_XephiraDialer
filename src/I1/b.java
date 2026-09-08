package I1;

import A2.l;
import android.app.Application;
import android.telecom.CallAudioState;
import androidx.lifecycle.LiveData;
import com.android.incallui.AudioModeProvider;
import com.android.incallui.Call;
import com.android.incallui.OplusCallList;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.TelecomAdapter;
import d2.InterfaceC0949b;

/* compiled from: ICallAudioRepository.kt */
/* loaded from: classes.dex */
public interface b extends InterfaceC0949b {

    /* compiled from: ICallAudioRepository.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public static Application a(b bVar) {
            return InterfaceC0949b.a.b(bVar);
        }

        public static AudioModeProvider b(b bVar) {
            return InterfaceC0949b.a.c(bVar);
        }

        public static OplusCallList c(b bVar) {
            return InterfaceC0949b.a.e(bVar);
        }

        public static l d(b bVar) {
            return InterfaceC0949b.a.i(bVar);
        }

        public static OplusInCallPresenter e(b bVar) {
            return InterfaceC0949b.a.j(bVar);
        }

        public static TelecomAdapter f(b bVar) {
            return InterfaceC0949b.a.l(bVar);
        }

        public static void g(b bVar) {
            InterfaceC0949b.a.m(bVar);
        }
    }

    void D0(Integer num);

    boolean F(int i10);

    void b();

    LiveData<CallAudioState> b1();

    void c();

    int g1();

    void j();

    void k(Call call, boolean z10);

    boolean l0(int i10);

    boolean p0();

    boolean s0(int i10);

    boolean u1(CallAudioState callAudioState);

    LiveData<Boolean> z();
}
