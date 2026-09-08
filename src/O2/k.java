package o2;

import android.app.Application;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.OplusPhoneUserActionStatistics;
import com.android.incallui.OplusPhoneUtils;
import java.util.HashMap;
import r2.d;

/* compiled from: StatisticsRepository.kt */
/* loaded from: classes.dex */
public final class k implements r2.d {
    @Override // d2.InterfaceC0949b
    public OplusInCallPresenter C0() {
        return d.a.b(this);
    }

    @Override // r2.d
    public void c1(Integer num) {
        String str;
        HashMap hashMap = new HashMap();
        if (num != null && num.intValue() == 5) {
            str = OplusPhoneUtils.DeviceState.LOCK_DEVICE;
        } else {
            str = OplusPhoneUtils.DeviceState.UNLOCK_DEVICE;
        }
        hashMap.put("type:", str);
        OplusPhoneUserActionStatistics.onCommon(o(), OplusPhoneUserActionStatistics.TAG_FLOATING_WINDOW, OplusPhoneUserActionStatistics.USER_ACTION_FLOATING_WINDOW_DISPLAY_SCREEN, hashMap);
    }

    @Override // d2.InterfaceC0949b
    public void f() {
        d.a.c(this);
    }

    @Override // r2.d
    public void f0(Integer num, boolean z10) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("isVideo ", String.valueOf(z10));
        if (num != null && num.intValue() == 5) {
            str = OplusPhoneUtils.DeviceState.LOCK_DEVICE;
        } else {
            str = OplusPhoneUtils.DeviceState.UNLOCK_DEVICE;
        }
        hashMap.put("type:", str);
        OplusPhoneUserActionStatistics.onCommon(o(), OplusPhoneUserActionStatistics.TAG_FLOATING_WINDOW, OplusPhoneUserActionStatistics.USER_ACTION_FLOATING_WINDOW_ANSWER, hashMap);
    }

    @Override // r2.d
    public void n(Integer num, int i10) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("PRE_AUDIO_MODE", String.valueOf(i10));
        if (num != null && num.intValue() == 5) {
            str = OplusPhoneUtils.DeviceState.LOCK_DEVICE;
        } else {
            str = OplusPhoneUtils.DeviceState.UNLOCK_DEVICE;
        }
        hashMap.put("type:", str);
        OplusPhoneUserActionStatistics.onCommon(o(), OplusPhoneUserActionStatistics.TAG_FLOATING_WINDOW, OplusPhoneUserActionStatistics.USER_ACTION_FLOATING_WINDOW_TURN_ON_SPEAKER, hashMap);
    }

    public Application o() {
        return d.a.a(this);
    }

    @Override // r2.d
    public void s(int i10) {
        HashMap hashMap = new HashMap();
        hashMap.put("type:", String.valueOf(i10));
        OplusPhoneUserActionStatistics.onCommon(o(), OplusPhoneUserActionStatistics.TAG_FLOATING_WINDOW, OplusPhoneUserActionStatistics.USER_ACTION_FLOATING_WINDOW_SHOW, hashMap);
    }
}
