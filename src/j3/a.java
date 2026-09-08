package J3;

import android.os.PersistableBundle;
import com.oplus.wrapper.telephony.CarrierConfigManager;

/* compiled from: CarrierConfigManagerCustomize.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1576a = new a();

    public static final PersistableBundle a() {
        PersistableBundle a10;
        try {
            if (C7.b.a(30, 1)) {
                a10 = CarrierConfigManager.getDefaultConfig();
            } else {
                a10 = Q6.a.a();
            }
            return a10;
        } catch (Exception e10) {
            H7.b.c("CarrierConfigManagerCustomize", "getDefaultConfig error :" + e10);
            return null;
        }
    }
}
