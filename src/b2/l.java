package b2;

import A2.z;
import android.os.Handler;
import android.os.Looper;
import com.android.incallui.Call;
import com.android.incallui.CallList;
import com.android.incallui.CallUtils;
import com.android.incallui.InCallPresenter;
import com.android.incallui.OplusInCallApp;
import com.android.oplus.brand.BrandCenter;

/* compiled from: InCallFragmentPresenter.java */
/* loaded from: classes.dex */
public class l implements b, InCallPresenter.InCallStateListener, InCallPresenter.IncomingCallListener {

    /* renamed from: a, reason: collision with root package name */
    public Handler f12101a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public a f12102b;

    /* renamed from: c, reason: collision with root package name */
    public int f12103c;

    /* compiled from: InCallFragmentPresenter.java */
    /* loaded from: classes.dex */
    public interface a {
        void q(int i10);
    }

    @Override // b2.b
    public void a(a aVar) {
        if (aVar == null) {
            this.f12103c = 0;
        }
        this.f12102b = aVar;
    }

    @Override // b2.b
    public void b() {
        h(this.f12103c);
    }

    public final void d(int i10) {
        this.f12103c = i10 | this.f12103c;
    }

    public final void e(InCallPresenter.InCallState inCallState, CallList callList) {
        Call outgoingCall;
        boolean z10;
        boolean z11 = true;
        boolean z12 = false;
        if (inCallState == InCallPresenter.InCallState.INCOMING) {
            outgoingCall = callList.getIncomingCall();
            z10 = true;
        } else {
            if (inCallState != InCallPresenter.InCallState.PENDING_OUTGOING && inCallState != InCallPresenter.InCallState.OUTGOING) {
                outgoingCall = null;
            } else {
                outgoingCall = callList.getOutgoingCall();
            }
            z10 = false;
        }
        if (inCallState != InCallPresenter.InCallState.INCALL || (outgoingCall = callList.getActiveCall()) == null || !outgoingCall.can(128)) {
            z11 = false;
        }
        if (outgoingCall != null) {
            z12 = CallUtils.isVideoCallorAudioCallRingtone(OplusInCallApp.getAppContext(), outgoingCall);
        }
        BrandCenter.f19187a.a().b(inCallState);
        f(z10, z11, z12);
    }

    public final void f(boolean z10, boolean z11, boolean z12) {
        d(2);
        d(4);
        if (z10) {
            d(8);
        }
        if (z11) {
            d(32);
        }
        if (z12) {
            d(1);
        }
        h(this.f12103c);
    }

    public final void h(final int i10) {
        if (z.b()) {
            g(i10);
        } else {
            this.f12101a.post(new Runnable() { // from class: b2.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.g(i10);
                }
            });
        }
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final void g(int i10) {
        a aVar = this.f12102b;
        if (aVar != null) {
            aVar.q(i10);
        }
    }

    @Override // com.android.incallui.InCallPresenter.IncomingCallListener
    public void onIncomingCall(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, Call call) {
        e(inCallState2, CallList.getInstance());
    }

    @Override // com.android.incallui.InCallPresenter.InCallStateListener
    public void onStateChange(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, CallList callList) {
        e(inCallState2, callList);
    }
}
