package com.oplus.pseudobasestation;

import F6.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0863y;
import com.oplus.utils.P;
import l7.b;

/* loaded from: classes3.dex */
public class PseudoBaseStationReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !b.f34734b) {
            return;
        }
        int i10 = -1;
        try {
            if (z6.b.c(context, 1, "device_provisioned", -1) != 1) {
                return;
            }
        } catch (Exception unused) {
            Log.e("PseudoBaseStationReceiver", "get DEVICE_PROVISIONED state error");
        }
        String action = intent.getAction();
        try {
            i10 = C0863y.b(intent, "arfcn", -1);
        } catch (Exception e10) {
            Log.e("PseudoBaseStationReceiver", "Exception in getIntExtra: " + e10);
        }
        int i11 = i10;
        C0846g.i("PseudoBaseStationReceiver", "received broadcast action = " + action);
        if (a.o(action)) {
            int checkSelfPermission = context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION");
            int checkSelfPermission2 = context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION");
            if (C0846g.c()) {
                Log.d("PseudoBaseStationReceiver", "hasFineLocationPermission = " + checkSelfPermission + " ,hasCoarseLocationPermission = " + checkSelfPermission2);
            }
            if (checkSelfPermission != 0 && checkSelfPermission2 != 0) {
                P.d(context, i11, Double.MIN_NORMAL, Double.MIN_NORMAL);
                return;
            }
            Intent intent2 = new Intent(context, (Class<?>) PseudoBaseStationService.class);
            intent2.putExtra("arfcn", i11);
            context.startService(intent2);
        }
    }
}
