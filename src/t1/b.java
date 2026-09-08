package t1;

import android.os.Build;
import com.android.contacts.util.o;
import com.android.incallui.OplusPhoneUtils;
import s1.v;

/* compiled from: OmtpConstants.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f37143a = {"NM", "MBU", "GU"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f37144b = {v.f36673e, o.f17586f, "f", "i", "e"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f37145c = {"N", "R", "P", "U", "B"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f37146d = {OplusPhoneUtils.DeviceState.UNLOCK_DEVICE, OplusPhoneUtils.DeviceState.LOCK_DEVICE, "2", "3", "4", "5", "6", "7"};

    public static String a() {
        String b10 = b(Build.MANUFACTURER.replace('=', '_').replace(';', '_').replace('.', '_').replace(' ', '_'), 12);
        String b11 = b(Build.VERSION.RELEASE.replace('=', '_').replace(';', '_').replace('.', '_').replace(' ', '_'), 8);
        return String.format("%s.%s.%s", b10, b(Build.MODEL.replace('=', '_').replace(';', '_').replace('.', '_').replace(' ', '_'), (28 - b10.length()) - b11.length()), b11);
    }

    public static final String b(String str, int i10) {
        return str.substring(0, Math.min(i10, str.length()));
    }
}
