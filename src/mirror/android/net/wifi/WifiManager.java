package mirror.android.net.wifi;

import android.net.wifi.IWifiManager;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefObject;

/* loaded from: classes4.dex */
public class WifiManager {
    public static RefObject<IWifiManager> mService;

    static {
        RefClass.load((Class<?>) WifiManager.class, "android.net.wifi.WifiManager");
    }
}
