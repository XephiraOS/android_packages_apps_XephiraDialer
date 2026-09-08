package D7;

import android.content.Context;

/* compiled from: AddonLinearMotorVibrator.kt */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public com.heytap.addon.os.a f463a;

    public b(Context context) {
        this.f463a = new com.heytap.addon.os.a(context);
    }

    public final boolean a() {
        com.heytap.addon.os.a aVar = this.f463a;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    public final void b(com.heytap.addon.os.d dVar) {
        com.heytap.addon.os.a aVar;
        if (dVar != null && (aVar = this.f463a) != null) {
            aVar.b(dVar);
        }
    }
}
