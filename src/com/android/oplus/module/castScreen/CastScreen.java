package com.android.oplus.module.castScreen;

import O2.b;
import android.content.Context;
import com.android.incallui.Call;
import com.android.incallui.CallList;
import com.android.incallui.InCallPresenter;
import com.android.incallui.OplusCall;
import com.android.oplus.module.ModuleCenter;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: CastScreen.kt */
/* loaded from: classes.dex */
public final class CastScreen implements b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f19196a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final d<CastScreen> f19197b;

    /* renamed from: c, reason: collision with root package name */
    public static final b f19198c;

    /* compiled from: CastScreen.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final CastScreen a() {
            return (CastScreen) CastScreen.f19197b.getValue();
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        d<CastScreen> a10;
        a10 = kotlin.a.a(LazyThreadSafetyMode.f34161a, new InterfaceC1637a<CastScreen>() { // from class: com.android.oplus.module.castScreen.CastScreen$Companion$sInstance$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CastScreen invoke() {
                return new CastScreen();
            }
        });
        f19197b = a10;
        f19198c = ModuleCenter.f19192b.a().b();
    }

    @Override // O2.b
    public void B(OplusCall call) {
        i.f(call, "call");
        b bVar = f19198c;
        if (bVar != null) {
            bVar.B(call);
        }
    }

    @Override // O2.b
    public void G(Context context) {
        i.f(context, "context");
        b bVar = f19198c;
        if (bVar != null) {
            bVar.G(context);
        }
    }

    @Override // O2.c
    public void a(int i10) {
        b bVar = f19198c;
        if (bVar != null) {
            bVar.a(i10);
        }
    }

    @Override // O2.c
    public void b(O2.a castScreenAudioListener) {
        i.f(castScreenAudioListener, "castScreenAudioListener");
        b bVar = f19198c;
        if (bVar != null) {
            bVar.b(castScreenAudioListener);
        }
    }

    @Override // O2.b
    public void c0(OplusCall call) {
        i.f(call, "call");
        b bVar = f19198c;
        if (bVar != null) {
            bVar.c0(call);
        }
    }

    @Override // O2.b
    public void e0(int i10) {
        b bVar = f19198c;
        if (bVar != null) {
            bVar.e0(i10);
        }
    }

    @Override // O2.b
    public boolean k0() {
        b bVar = f19198c;
        if (bVar != null) {
            return bVar.k0();
        }
        return false;
    }

    @Override // O2.b
    public void o(int i10, String callId, String ext) {
        i.f(callId, "callId");
        i.f(ext, "ext");
        b bVar = f19198c;
        if (bVar != null) {
            bVar.o(i10, callId, ext);
        }
    }

    @Override // com.android.incallui.InCallPresenter.IncomingCallListener
    public void onIncomingCall(InCallPresenter.InCallState oldState, InCallPresenter.InCallState newState, Call call) {
        i.f(oldState, "oldState");
        i.f(newState, "newState");
        b bVar = f19198c;
        if (bVar != null) {
            bVar.onIncomingCall(oldState, newState, call);
        }
    }

    @Override // com.android.incallui.InCallPresenter.InCallStateListener
    public void onStateChange(InCallPresenter.InCallState oldState, InCallPresenter.InCallState newState, CallList callList) {
        i.f(oldState, "oldState");
        i.f(newState, "newState");
        b bVar = f19198c;
        if (bVar != null) {
            bVar.onStateChange(oldState, newState, callList);
        }
    }

    @Override // O2.b
    public void setMute(boolean z10) {
        b bVar = f19198c;
        if (bVar != null) {
            bVar.setMute(z10);
        }
    }
}
