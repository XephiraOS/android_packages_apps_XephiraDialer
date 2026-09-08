package N5;

import com.heytap.accessory.bean.BtDirectAdvertiseSetting;
import com.heytap.accessory.constant.FastPairConstants;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* compiled from: TimeUtils.java */
/* loaded from: classes3.dex */
public class i {
    public static Calendar a(byte[] bArr) {
        int i10 = (bArr[3] & FastPairConstants.GO_INTENT_NOT_SET) | ((bArr[0] << 24) & (-16777216)) | ((bArr[1] << BtDirectAdvertiseSetting.FLAG_DEVICE_BATTERY) & 16711680) | ((bArr[2] << 8) & 65280);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(i10 * 1000);
        return gregorianCalendar;
    }
}
