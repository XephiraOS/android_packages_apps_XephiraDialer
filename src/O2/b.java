package O2;

import android.content.Context;
import com.android.incallui.InCallPresenter;
import com.android.incallui.OplusCall;

/* compiled from: ICallCastScreen.kt */
/* loaded from: classes.dex */
public interface b extends InCallPresenter.InCallStateListener, InCallPresenter.IncomingCallListener, c {
    void B(OplusCall oplusCall);

    void G(Context context);

    void c0(OplusCall oplusCall);

    void e0(int i10);

    boolean k0();

    void o(int i10, String str, String str2);

    void setMute(boolean z10);
}
