package y2;

import D2.l;
import android.content.Context;
import android.telecom.VideoProfile;
import android.widget.Toast;
import com.android.incallui.Call;
import com.android.incallui.Log;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import com.internal_dependency.InternalSdkDepends;
import java.util.Arrays;
import java.util.List;

/* compiled from: OplusVideoCallExt.java */
/* renamed from: y2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1703b {

    /* renamed from: b, reason: collision with root package name */
    public static final List<String> f38131b = Arrays.asList("45502", "46003", "46011", "46012", "46013");

    /* renamed from: a, reason: collision with root package name */
    public Context f38132a;

    public C1703b(Context context) {
        this.f38132a = context;
    }

    public final boolean a() {
        boolean z10;
        if (!InternalSdkDepends.getSInstance().getStringSystemProperties("gsm.sim.ril.testsim", "").equals(OplusPhoneUtils.DeviceState.LOCK_DEVICE) && !InternalSdkDepends.getSInstance().getStringSystemProperties("gsm.sim.ril.testsim.2", "").equals(OplusPhoneUtils.DeviceState.LOCK_DEVICE) && !InternalSdkDepends.getSInstance().getStringSystemProperties("gsm.sim.ril.testsim.3", "").equals(OplusPhoneUtils.DeviceState.LOCK_DEVICE) && !InternalSdkDepends.getSInstance().getStringSystemProperties("gsm.sim.ril.testsim.4", "").equals(OplusPhoneUtils.DeviceState.LOCK_DEVICE)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (Log.sDebug) {
            Log.d("OP09VideoCallExt", "isTestSim :" + z10);
        }
        return z10;
    }

    public void b(Call call, int i10) {
        android.telecom.Call telecommCall;
        Log.d("OP09VideoCallExt", "[onCallSessionEvent]downgrade due to insufficient bandwidth event" + i10);
        if (call != null && (telecommCall = call.getTelecommCall()) != null && telecommCall.getVideoCall() != null && i10 == 4008) {
            if (f38131b.contains(l.c(this.f38132a, call.getSlotId(), call.getSubId())) || a() || OplusPhoneUtils.isUstOplusExport()) {
                Log.d("OP09VideoCallExt", "[onCallSessionEvent]downgrade to audio for CT requirement");
                telecommCall.getVideoCall().sendSessionModifyRequest(new VideoProfile(0));
                Context context = this.f38132a;
                Toast.makeText(context, context.getString(R.string.video_call_downgrade_insufficient_bandwidth), 0).show();
            }
        }
    }
}
