package A1;

import D1.b;
import android.os.Bundle;
import t1.k;

/* compiled from: StatusMessage.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f73a;

    /* renamed from: b, reason: collision with root package name */
    public final String f74b;

    /* renamed from: c, reason: collision with root package name */
    public final String f75c;

    /* renamed from: d, reason: collision with root package name */
    public final String f76d;

    /* renamed from: e, reason: collision with root package name */
    public final String f77e;

    /* renamed from: f, reason: collision with root package name */
    public final String f78f;

    /* renamed from: g, reason: collision with root package name */
    public final String f79g;

    /* renamed from: h, reason: collision with root package name */
    public final String f80h;

    /* renamed from: i, reason: collision with root package name */
    public final String f81i;

    /* renamed from: j, reason: collision with root package name */
    public final String f82j;

    /* renamed from: k, reason: collision with root package name */
    public final String f83k;

    /* renamed from: l, reason: collision with root package name */
    public final String f84l;

    /* renamed from: m, reason: collision with root package name */
    public final String f85m;

    public e(Bundle bundle) {
        this.f73a = j(g(bundle, "st"));
        this.f74b = g(bundle, "rc");
        this.f75c = g(bundle, "rs");
        this.f76d = g(bundle, "srv");
        this.f77e = g(bundle, "tui");
        this.f78f = g(bundle, "dn");
        this.f79g = g(bundle, "ipt");
        this.f80h = g(bundle, "u");
        this.f81i = g(bundle, "pw");
        this.f82j = g(bundle, "spt");
        this.f83k = g(bundle, "smtp_u");
        this.f84l = g(bundle, "smtp_pw");
        this.f85m = g(bundle, "pw_len");
    }

    public static String g(Bundle bundle, String str) {
        String str2;
        if (bundle != null) {
            str2 = bundle.getString(str);
        } else {
            str2 = null;
        }
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public static String j(String str) {
        if (str.length() < 2) {
            return str;
        }
        if (str.startsWith("\"") && str.endsWith("\"")) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

    public String a() {
        return this.f81i;
    }

    public String b() {
        return this.f79g;
    }

    public String c() {
        return this.f80h;
    }

    public String d() {
        return this.f73a;
    }

    public String e() {
        return this.f74b;
    }

    public String f() {
        return this.f76d;
    }

    public String getClientSmsDestinationNumber() {
        return this.f78f;
    }

    public String getSmtpPassword() {
        return this.f84l;
    }

    public String getSmtpPort() {
        return this.f82j;
    }

    public String getSmtpUserName() {
        return this.f83k;
    }

    public String getSubscriptionUrl() {
        return this.f75c;
    }

    public String getTuiAccessNumber() {
        return this.f77e;
    }

    public String h() {
        return this.f85m;
    }

    public b.a i(b.a aVar) {
        return aVar.c("ipt", b()).c("srv", f()).c("u", c()).c("pw", a()).c("pw_len", h());
    }

    public String toString() {
        return "StatusMessage [mProvisioningStatus=" + this.f73a + ", mStatusReturnCode=" + this.f74b + ", mSubscriptionUrl=" + this.f75c + ", mServerAddress=" + this.f76d + ", mTuiAccessNumber=" + this.f77e + ", mClientSmsDestinationNumber=" + this.f78f + ", mImapPort=" + this.f79g + ", mImapUserName=" + this.f80h + ", mImapPassword=" + k.c(this.f81i) + ", mSmtpPort=" + this.f82j + ", mSmtpUserName=" + this.f83k + ", mSmtpPassword=" + k.c(this.f84l) + ", mTuiPasswordLength=" + this.f85m + "]";
    }
}
