package A1;

import android.app.PendingIntent;
import android.content.Context;
import android.telecom.PhoneAccountHandle;

/* compiled from: OmtpCvvmMessageSender.java */
/* loaded from: classes.dex */
public class b extends c {
    public b(Context context, PhoneAccountHandle phoneAccountHandle, short s10, String str) {
        super(context, phoneAccountHandle, s10, str);
    }

    @Override // A1.c
    public void b(PendingIntent pendingIntent) {
        f("Activate", pendingIntent);
    }

    @Override // A1.c
    public void c(PendingIntent pendingIntent) {
        f("Deactivate", pendingIntent);
    }

    @Override // A1.c
    public void d(PendingIntent pendingIntent) {
        f("Status", pendingIntent);
    }

    public final void f(String str, PendingIntent pendingIntent) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(":");
        a(sb, "dt", "15");
        e(sb.toString(), pendingIntent);
    }
}
