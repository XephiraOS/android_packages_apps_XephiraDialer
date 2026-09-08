package f2;

import android.graphics.drawable.Drawable;
import android.telecom.VideoProfile;
import android.util.Log;
import com.android.incallui.Call;
import com.android.incallui.CallUtils;
import d2.C0950c;
import e2.C0968c;

/* compiled from: PrimaryCallInfoUseCase.kt */
/* loaded from: classes.dex */
public final class c extends C0950c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f31677a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final com.android.incallui.mvvm.utils.h<String> f31678b = new com.android.incallui.mvvm.utils.h<>(true);

    /* renamed from: c, reason: collision with root package name */
    public static final com.android.incallui.mvvm.utils.h<String> f31679c = new com.android.incallui.mvvm.utils.h<>(true);

    /* renamed from: d, reason: collision with root package name */
    public static final com.android.incallui.mvvm.utils.h<Integer> f31680d = new com.android.incallui.mvvm.utils.h<>(0, true);

    /* renamed from: e, reason: collision with root package name */
    public static final com.android.incallui.mvvm.utils.h<Integer> f31681e = new com.android.incallui.mvvm.utils.h<>(0, true);

    /* renamed from: f, reason: collision with root package name */
    public static final com.android.incallui.mvvm.utils.h<Drawable> f31682f = new com.android.incallui.mvvm.utils.h<>(true);

    /* renamed from: g, reason: collision with root package name */
    public static final com.android.incallui.mvvm.utils.h<Boolean> f31683g = new com.android.incallui.mvvm.utils.h<>(Boolean.FALSE, true);

    /* renamed from: h, reason: collision with root package name */
    public static final com.android.incallui.mvvm.utils.h<C0968c> f31684h = new com.android.incallui.mvvm.utils.h<>(true);

    public final com.android.incallui.mvvm.utils.h<Drawable> b() {
        return f31682f;
    }

    public final com.android.incallui.mvvm.utils.h<String> c() {
        return f31678b;
    }

    public final com.android.incallui.mvvm.utils.h<Integer> d() {
        return f31680d;
    }

    public final com.android.incallui.mvvm.utils.h<C0968c> e() {
        return f31684h;
    }

    public final com.android.incallui.mvvm.utils.h<Integer> f() {
        return f31681e;
    }

    public final com.android.incallui.mvvm.utils.h<Boolean> g() {
        return f31683g;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(com.android.incallui.Call r9) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.c.h(com.android.incallui.Call):void");
    }

    public final void i(Call call) {
        boolean z10;
        int i10;
        int i11 = 0;
        r3 = false;
        boolean z11 = false;
        if (call != null) {
            int state = call.getState();
            i10 = call.getVideoState();
            if (VideoProfile.isReceptionEnabled(i10)) {
                if (Call.State.isInComming(state)) {
                    z11 = CallUtils.isInCommingCallRingtone(f31677a.a(), call);
                } else if (Call.State.isConnectingOrDialing(state)) {
                    z11 = call.getIsVideoRingTone();
                }
            }
            z10 = z11;
            i11 = state;
        } else {
            z10 = false;
            i10 = 0;
        }
        Log.d("PrimaryCallInfoUseCase", "updateCallState: callState=" + Call.State.toString(i11) + " videoState=" + VideoProfile.videoStateToString(i10) + " isPlayingVideoRingtone=" + z10 + ' ');
        f31680d.o(Integer.valueOf(i11));
        f31681e.o(Integer.valueOf(i10));
        f31683g.o(Boolean.valueOf(z10));
    }

    public final void j(Call call) {
        h(call);
        i(call);
    }
}
