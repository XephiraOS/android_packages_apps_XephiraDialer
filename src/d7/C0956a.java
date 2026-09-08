package d7;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.oplus.epona.d;
import com.oplus.epona.k;
import com.oplus.utils.C0864z;
import h7.c;

/* compiled from: CompatController.java */
/* renamed from: d7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0956a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final c f30066a = d.f28141k;

    /* renamed from: b, reason: collision with root package name */
    public final f7.d f30067b = f7.d.c();

    public C0956a(Context context) {
        if (!k.a()) {
            com.heytap.epona.c.i(context);
        }
    }

    @Override // h7.c
    public IBinder a(String str) {
        if (k.a()) {
            return this.f30066a.a(str);
        }
        IBinder b10 = this.f30067b.b(str);
        if (b10 == null) {
            Bundle a10 = H5.b.a(com.heytap.epona.c.f(), str);
            if (a10 != null) {
                b10 = a10.getBinder("com.heytap.epona.Dispatcher.TRANSFER_VALUE");
            }
            if (b10 != null) {
                this.f30067b.e(str, b10);
            } else {
                C0864z.d("Epona->CompatRegister", "Get remote binder null. ComponentName : %s", str);
            }
        }
        return b10;
    }
}
