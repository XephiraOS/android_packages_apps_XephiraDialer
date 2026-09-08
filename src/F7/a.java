package F7;

import com.android.incallui.OplusPhoneUtils;

/* compiled from: CustomizeDate.java */
/* loaded from: classes3.dex */
public class a {
    public static String a(int i10, int i11, int i12) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i10);
        if (i11 <= 9) {
            stringBuffer.append(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
            stringBuffer.append(i11);
        } else {
            stringBuffer.append(i11);
        }
        if (i12 <= 9) {
            stringBuffer.append(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
            stringBuffer.append(i12);
        } else {
            stringBuffer.append(i12);
        }
        return stringBuffer.toString();
    }
}
