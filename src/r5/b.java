package r5;

import android.content.Intent;
import com.android.incallui.OplusPhoneCapabilities;
import com.heytap.accessory.BaseJobAgent;

/* compiled from: BroadcastUtils.java */
/* loaded from: classes3.dex */
public class b {
    public static Intent a(String str) {
        Intent intent = new Intent(BaseJobAgent.ACTION_REGISTRATION_REQUIRED);
        intent.setPackage(str);
        intent.addFlags(32);
        intent.addFlags(OplusPhoneCapabilities.MTK_CAPABILITY_VIDEO_RINGTONE);
        return intent;
    }
}
