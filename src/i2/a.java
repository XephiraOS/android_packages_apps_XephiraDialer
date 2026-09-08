package I2;

import A2.l;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.ContentResolver;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.content.b;
import com.android.incallui.Log;
import com.android.incallui.OplusInCallApp;
import com.android.incallui.OplusPhoneUtils;
import com.internal_dependency.SettingsUtils;
import java.util.Set;
import kotlin.jvm.internal.i;

/* compiled from: OplusInCallUIUtils.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1304a = new a();

    public static final boolean a(ContentResolver contentResolver) {
        if (contentResolver == null) {
            return false;
        }
        SettingsUtils settingsUtils = SettingsUtils.INSTANCE;
        if (!i.b(settingsUtils.getGlobalSettingsString(contentResolver, "debug_gamemode_value", ""), OplusPhoneUtils.DeviceState.LOCK_DEVICE)) {
            Log.d("OplusInCallUIUtils", "inGameMode, not in GameMode.");
            return false;
        }
        if (TextUtils.isEmpty(settingsUtils.getGlobalSettingsString(contentResolver, "debug_gamemode_savegame", ""))) {
            Log.d("OplusInCallUIUtils", "inGameMode, SaveGame is null.");
            return false;
        }
        return true;
    }

    public static final boolean b(Context context) {
        i.f(context, "context");
        return c(context, "com.heytap.health");
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0018 A[Catch: all -> 0x002e, TRY_LEAVE, TryCatch #0 {all -> 0x002e, blocks: (B:13:0x000a, B:15:0x0010, B:5:0x0018), top: B:12:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean c(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "packageName"
            kotlin.jvm.internal.i.f(r4, r0)
            r0 = 0
            java.lang.String r1 = "OplusInCallUIUtils"
            if (r3 == 0) goto L15
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch: java.lang.Throwable -> L2e
            if (r3 == 0) goto L15
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r4, r0)     // Catch: java.lang.Throwable -> L2e
            goto L16
        L15:
            r3 = 0
        L16:
            if (r3 == 0) goto L42
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r3.<init>()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r2 = "isPackageInstalled: found package: "
            r3.append(r2)     // Catch: java.lang.Throwable -> L2e
            r3.append(r4)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L2e
            com.android.incallui.Log.d(r1, r3)     // Catch: java.lang.Throwable -> L2e
            r3 = 1
            return r3
        L2e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r2 = "isPackageInstalled: NameNotFoundException: "
            r3.append(r2)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.android.incallui.Log.w(r1, r3)
        L42:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r2 = "isPackageInstalled: not installed: "
            r3.append(r2)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.android.incallui.Log.d(r1, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: I2.a.c(android.content.Context, java.lang.String):boolean");
    }

    public static final boolean d() {
        Set<BluetoothDevice> bondedDevices;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && defaultAdapter.isEnabled()) {
            try {
                if (b.a(OplusInCallApp.getAppContext(), "android.permission.BLUETOOTH_CONNECT") != 0) {
                    bondedDevices = null;
                } else {
                    bondedDevices = defaultAdapter.getBondedDevices();
                }
            } catch (Throwable th) {
                Log.w("OplusInCallUIUtils", "isValidWatchDevice, exception: " + th.getMessage());
            }
            if (bondedDevices != null && !bondedDevices.isEmpty()) {
                for (BluetoothDevice bluetoothDevice : bondedDevices) {
                    if (bluetoothDevice != null && l.d().g(bluetoothDevice.getAddress())) {
                        return true;
                    }
                }
                return false;
            }
            Log.d("OplusInCallUIUtils", "isValidWatchDevice, bondedDevices is null or empty.");
            return false;
        }
        Log.d("OplusInCallUIUtils", "isValidWatchDevice, BluetoothAdapter is null or not enabled.");
        return false;
    }

    public static final boolean e(ContentResolver contentResolver) {
        boolean a10 = a(contentResolver);
        Log.i("OplusInCallUIUtils", "inGameMode: " + a10);
        if (a10) {
            boolean d10 = d();
            Log.i("OplusInCallUIUtils", "validWatchDevice: " + d10);
            return d10;
        }
        return false;
    }
}
