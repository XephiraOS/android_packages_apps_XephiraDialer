package Z3;

import android.content.Context;
import android.os.PowerManager;

/* compiled from: ContactsWakeLock.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static PowerManager.WakeLock f5902a;

    public static synchronized void a(Context context) {
        synchronized (c.class) {
            if (f5902a != null) {
                return;
            }
            PowerManager.WakeLock newWakeLock = ((PowerManager) context.getApplicationContext().getSystemService("power")).newWakeLock(536870918, "Contacts:ContactsWakeLock");
            f5902a = newWakeLock;
            newWakeLock.acquire();
        }
    }

    public static synchronized void b() {
        synchronized (c.class) {
            PowerManager.WakeLock wakeLock = f5902a;
            if (wakeLock != null) {
                wakeLock.release();
                f5902a = null;
            }
        }
    }
}
