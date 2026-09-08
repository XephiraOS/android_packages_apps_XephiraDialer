package A1;

import android.app.PendingIntent;
import android.content.Context;
import android.telecom.PhoneAccountHandle;

/* compiled from: OmtpMessageSender.java */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f66a;

    /* renamed from: b, reason: collision with root package name */
    public final PhoneAccountHandle f67b;

    /* renamed from: c, reason: collision with root package name */
    public final short f68c;

    /* renamed from: d, reason: collision with root package name */
    public final String f69d;

    public c(Context context, PhoneAccountHandle phoneAccountHandle, short s10, String str) {
        this.f66a = context;
        this.f67b = phoneAccountHandle;
        this.f68c = s10;
        this.f69d = str;
    }

    public void a(StringBuilder sb, String str, Object obj) {
        sb.append(str);
        sb.append("=");
        sb.append(obj);
    }

    public abstract void b(PendingIntent pendingIntent);

    public abstract void c(PendingIntent pendingIntent);

    public abstract void d(PendingIntent pendingIntent);

    public void e(String str, PendingIntent pendingIntent) {
        t1.d.a(this.f66a, this.f67b, this.f69d, this.f68c, str, pendingIntent);
    }
}
