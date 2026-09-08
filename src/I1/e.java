package I1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import com.android.incallui.InCallPresenter;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.clean.domain.bean.CallUiType;
import com.android.incallui.clean.domain.interactor.NonNullObservableField;
import d2.InterfaceC0949b;

/* compiled from: IUIRepository.kt */
/* loaded from: classes.dex */
public interface e extends InterfaceC0949b {

    /* compiled from: IUIRepository.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public static OplusInCallPresenter a(e eVar) {
            return InterfaceC0949b.a.j(eVar);
        }
    }

    void B0();

    void F0();

    NonNullObservableField<CallUiType> Q();

    void S0();

    v<Boolean> U();

    void U0();

    LiveData<InCallPresenter.InCallState> i();
}
