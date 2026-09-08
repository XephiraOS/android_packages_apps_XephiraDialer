package A1;

import android.app.PendingIntent;
import android.content.Context;
import android.telecom.PhoneAccountHandle;
import android.text.TextUtils;
import com.oplus.backup.sdk.common.utils.Constants;

/* compiled from: OmtpStandardMessageSender.java */
/* loaded from: classes.dex */
public class d extends c {

    /* renamed from: e, reason: collision with root package name */
    public final String f70e;

    /* renamed from: f, reason: collision with root package name */
    public final String f71f;

    /* renamed from: g, reason: collision with root package name */
    public final String f72g;

    public d(Context context, PhoneAccountHandle phoneAccountHandle, short s10, String str, String str2, String str3, String str4) {
        super(context, phoneAccountHandle, s10, str);
        this.f70e = str2;
        this.f71f = str3;
        this.f72g = str4;
    }

    @Override // A1.c
    public void b(PendingIntent pendingIntent) {
        StringBuilder sb = new StringBuilder();
        sb.append("Activate");
        h(sb);
        if (TextUtils.equals(this.f71f, "12") || TextUtils.equals(this.f71f, "13")) {
            f(sb);
            g(sb);
        }
        H7.b.b("OmtpMessageSender", "requestVvmActivation " + sb.toString());
        e(sb.toString(), pendingIntent);
    }

    @Override // A1.c
    public void c(PendingIntent pendingIntent) {
        StringBuilder sb = new StringBuilder();
        sb.append("Deactivate");
        h(sb);
        e(sb.toString(), pendingIntent);
    }

    @Override // A1.c
    public void d(PendingIntent pendingIntent) {
        StringBuilder sb = new StringBuilder();
        sb.append("Status");
        if (TextUtils.equals(this.f71f, "13")) {
            h(sb);
            f(sb);
            g(sb);
        }
        e(sb.toString(), pendingIntent);
    }

    public final void f(StringBuilder sb) {
        sb.append(Constants.DataMigration.SPLIT_TAG);
        a(sb, "pt", Short.valueOf(this.f68c));
    }

    public final void g(StringBuilder sb) {
        sb.append(Constants.DataMigration.SPLIT_TAG);
        sb.append(this.f72g);
    }

    public final void h(StringBuilder sb) {
        sb.append(":");
        a(sb, "pv", this.f71f);
        sb.append(Constants.DataMigration.SPLIT_TAG);
        a(sb, "ct", this.f70e);
    }
}
