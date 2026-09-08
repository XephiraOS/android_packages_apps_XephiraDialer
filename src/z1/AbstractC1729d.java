package z1;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import com.android.contacts.voicemail.impl.ActivationTask;
import com.android.contacts.voicemail.impl.OmtpEvents;
import com.android.contacts.voicemail.impl.c;

/* compiled from: VisualVoicemailProtocol.java */
/* renamed from: z1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1729d {
    public abstract A1.c a(Context context, PhoneAccountHandle phoneAccountHandle, short s10, String str);

    public void c(Context context, com.android.contacts.voicemail.impl.b bVar, c.b bVar2, OmtpEvents omtpEvents) {
        com.android.contacts.voicemail.impl.a.c(context, bVar, bVar2, omtpEvents);
    }

    public void d(com.android.contacts.voicemail.impl.b bVar, PendingIntent pendingIntent) {
        A1.c a10 = C1728c.a(this, bVar);
        if (a10 != null) {
            a10.d(pendingIntent);
        }
    }

    public void e(com.android.contacts.voicemail.impl.b bVar, PendingIntent pendingIntent) {
        A1.c a10 = C1728c.a(this, bVar);
        if (a10 != null) {
            a10.b(pendingIntent);
        }
    }

    public void f(com.android.contacts.voicemail.impl.b bVar) {
        A1.c a10 = C1728c.a(this, bVar);
        if (a10 != null) {
            a10.c(null);
        }
    }

    public boolean h() {
        return false;
    }

    public Bundle i(com.android.contacts.voicemail.impl.b bVar, String str, Bundle bundle) {
        return null;
    }

    public String b(String str) {
        return str;
    }

    public void g(ActivationTask activationTask, PhoneAccountHandle phoneAccountHandle, com.android.contacts.voicemail.impl.b bVar, c.b bVar2, A1.e eVar, Bundle bundle) {
    }
}
