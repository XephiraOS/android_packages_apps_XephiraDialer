package J5;

import com.heytap.accessory.CommonStatusCodes;

/* compiled from: CommonStatusCodes.java */
/* loaded from: classes3.dex */
public class d {
    public static String a(int i10) {
        switch (i10) {
            case 1001:
                return "AUTHENTICATE_SUCCESS";
            case 1002:
                return "AUTHENTICATE_FAIL";
            case 1003:
                return "TIME_EXPIRED";
            case 1004:
                return "AUTHCODE_EXPECTED";
            case 1005:
                return "VERSION_INCOMPATIBLE";
            case 1006:
                return "AUTHCODE_RECYCLE";
            case 1007:
                return "AUTHCODE_INVALID";
            case 1008:
                return "CAPABILITY_EXCEPTION";
            case 1009:
                return "INTERNAL_EXCEPTION";
            case CommonStatusCodes.PERMISSION_DENIAL /* 1010 */:
                return "NONE_PERMISSION";
            default:
                return "unknown status code: " + i10;
        }
    }
}
