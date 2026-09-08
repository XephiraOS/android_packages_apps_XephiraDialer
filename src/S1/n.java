package s1;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.telecom.CallAudioState;
import com.android.contacts.voicemail.VoicemailPlaybackPresenter;
import com.oplus.foundation.util.OsUtils;
import java.util.concurrent.RejectedExecutionException;
import s1.v;
import w0.C1643c;

/* compiled from: VoicemailAudioManager.java */
/* loaded from: classes.dex */
public final class n implements AudioManager.OnAudioFocusChangeListener, v.a {

    /* renamed from: a, reason: collision with root package name */
    public AudioManager f36660a;

    /* renamed from: b, reason: collision with root package name */
    public VoicemailPlaybackPresenter f36661b;

    /* renamed from: c, reason: collision with root package name */
    public v f36662c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f36663d;

    /* renamed from: e, reason: collision with root package name */
    public CallAudioState f36664e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f36665f;

    public n(Context context, VoicemailPlaybackPresenter voicemailPlaybackPresenter) {
        this.f36660a = (AudioManager) context.getSystemService("audio");
        this.f36661b = voicemailPlaybackPresenter;
        v vVar = new v(context);
        this.f36662c = vVar;
        vVar.f(this);
        this.f36664e = e();
        C1.a.d("VoicemailAudioManager.VoicemailAudioManager", "Initial audioState = " + this.f36664e);
    }

    @Override // s1.v.a
    public void a(boolean z10, boolean z11) {
        int i10;
        C1.a.d("VoicemailAudioManager.onWiredHeadsetPluggedInChanged", "wired headset was plugged in changed: " + z10 + " -> " + z11);
        if (z10 == z11) {
            return;
        }
        this.f36664e.getRoute();
        boolean z12 = true;
        if (z11) {
            i10 = 4;
        } else if (this.f36663d) {
            i10 = 8;
        } else {
            i10 = 1;
        }
        VoicemailPlaybackPresenter voicemailPlaybackPresenter = this.f36661b;
        if (i10 != 8) {
            z12 = false;
        }
        voicemailPlaybackPresenter.E(z12);
        n(new CallAudioState(false, i10, d()));
    }

    public void b() {
        q(false);
        this.f36660a.abandonAudioFocus(this);
    }

    public final void c() {
        if (this.f36665f) {
            this.f36660a.startBluetoothSco();
            this.f36660a.setBluetoothScoOn(true);
        } else {
            this.f36660a.setBluetoothScoOn(false);
            this.f36660a.stopBluetoothSco();
        }
    }

    public final int d() {
        if (this.f36662c.c()) {
            return 12;
        }
        return 9;
    }

    public final CallAudioState e() {
        int d10 = d();
        return new CallAudioState(false, j(5, d10), d10);
    }

    public final boolean f() {
        for (AudioDeviceInfo audioDeviceInfo : this.f36660a.getDevices(2)) {
            if (audioDeviceInfo.getType() == 8) {
                return true;
            }
        }
        return false;
    }

    public boolean g() {
        return this.f36662c.c();
    }

    public void h() {
        this.f36662c.e();
    }

    public void i() {
        if (this.f36660a.requestAudioFocus(this, 0, 2) == 1) {
            q(true);
            return;
        }
        throw new RejectedExecutionException("Could not capture audio focus.");
    }

    public final int j(int i10, int i11) {
        if (i10 == 5) {
            int i12 = i11 & 5;
            if (i12 == 0) {
                C1.a.b("VoicemailAudioManager.selectWiredOrEarpiece", "One of wired headset or earpiece should always be valid.");
                return 1;
            }
            return i12;
        }
        return i10;
    }

    public void k(int i10) {
        this.f36660a.setMode(i10);
    }

    public void l(int i10) {
        boolean z10;
        C1.a.e("VoicemailAudioManager.setAudioRoute", "route: " + CallAudioState.audioRouteToString(i10));
        int j10 = j(i10, this.f36664e.getSupportedRouteMask());
        if ((this.f36664e.getSupportedRouteMask() | j10) == 0) {
            C1.a.f("VoicemailAudioManager.setAudioRoute", "Asking to set to a route that is unsupported: " + j10);
            return;
        }
        if (j10 == 8) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f36663d = z10;
        n(new CallAudioState(false, j10, this.f36664e.getSupportedRouteMask()));
    }

    public void m(boolean z10) {
        int i10;
        if (z10) {
            i10 = 8;
        } else {
            i10 = 5;
        }
        l(i10);
    }

    public final void n(CallAudioState callAudioState) {
        CallAudioState callAudioState2 = this.f36664e;
        this.f36664e = callAudioState;
        C1.a.d("VoicemailAudioManager.setSystemAudioState", "changing from " + callAudioState2 + " to " + this.f36664e);
        if (this.f36664e.getRoute() == 8) {
            o(true);
        } else if (this.f36664e.getRoute() == 1 || this.f36664e.getRoute() == 4) {
            o(false);
            c();
        }
    }

    public final void o(boolean z10) {
        if (this.f36660a.isSpeakerphoneOn() != z10 || (!OsUtils.f28275a.j() && this.f36660a.isBluetoothScoOn())) {
            C1.a.d("VoicemailAudioManager.turnOnSpeaker", "turning speaker phone on: " + z10);
            if (C1643c.w()) {
                k(3);
            }
            this.f36660a.setSpeakerphoneOn(z10);
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i10) {
        C1.a.a("VoicemailAudioManager.onAudioFocusChange", "focusChange=" + i10);
        VoicemailPlaybackPresenter voicemailPlaybackPresenter = this.f36661b;
        boolean z10 = true;
        if (i10 != 1) {
            z10 = false;
        }
        voicemailPlaybackPresenter.o(z10);
    }

    public void p() {
        this.f36662c.g();
    }

    public final void q(boolean z10) {
        if (z10) {
            if (f()) {
                this.f36665f = false;
            } else {
                this.f36665f = true;
                C1.a.d("VoicemailAudioManager.updateBluetoothScoState", "bluetooth device doesn't support media, using SCO instead");
            }
        } else {
            this.f36665f = false;
        }
        c();
    }
}
