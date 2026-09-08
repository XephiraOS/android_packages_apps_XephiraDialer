package A1;

import android.app.PendingIntent;
import android.content.Context;
import android.telecom.PhoneAccountHandle;

/* compiled from: Vvm3MessageSender.java */
/* loaded from: classes.dex */
public class g extends c {
    public g(Context context, PhoneAccountHandle phoneAccountHandle, short s10, String str) {
        super(context, phoneAccountHandle, s10, str);
    }

    @Override // A1.c
    public void b(PendingIntent pendingIntent) {
        d(pendingIntent);
    }

    @Override // A1.c
    public void d(PendingIntent pendingIntent) {
        e("STATUS", pendingIntent);
    }

    @Override // A1.c
    public void c(PendingIntent pendingIntent) {
    }
}
