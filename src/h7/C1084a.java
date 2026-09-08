package h7;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.oplus.utils.C0864z;
import f7.d;
import k7.C1217b;

/* compiled from: DefaultTransferController.java */
/* renamed from: h7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1084a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final d f32102a = d.c();

    @Override // h7.c
    public IBinder a(String str) {
        IBinder b10 = this.f32102a.b(str);
        if (b10 == null) {
            Context g10 = com.oplus.epona.d.g();
            if ("com.oplus.appplatform".equals(g10.getPackageName())) {
                b10 = i7.b.e().d(str);
            } else {
                Bundle a10 = C1217b.a(g10, str);
                if (a10 != null) {
                    b10 = a10.getBinder("com.oplus.epona.Dispatcher.TRANSFER_VALUE");
                }
            }
            if (b10 != null) {
                this.f32102a.e(str, b10);
            } else {
                C0864z.d("Epona->DefaultTransferController", "Get remote binder null. ComponentName : %s", str);
            }
        }
        return b10;
    }
}
