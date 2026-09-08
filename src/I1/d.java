package I1;

import androidx.lifecycle.LiveData;
import com.android.incallui.OplusInCallPresenter;
import d2.InterfaceC0949b;

/* compiled from: IConfigRepository.kt */
/* loaded from: classes.dex */
public interface d extends InterfaceC0949b {

    /* compiled from: IConfigRepository.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public static OplusInCallPresenter a(d dVar) {
            return InterfaceC0949b.a.j(dVar);
        }

        public static void b(d dVar) {
            InterfaceC0949b.a.m(dVar);
        }
    }

    LiveData<Boolean> L0();
}
