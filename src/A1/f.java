package A1;

import android.os.Bundle;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: SyncMessage.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f86a;

    /* renamed from: b, reason: collision with root package name */
    public final int f87b;

    /* renamed from: c, reason: collision with root package name */
    public final String f88c;

    /* renamed from: d, reason: collision with root package name */
    public final int f89d;

    /* renamed from: e, reason: collision with root package name */
    public final String f90e;

    /* renamed from: f, reason: collision with root package name */
    public final String f91f;

    /* renamed from: g, reason: collision with root package name */
    public final long f92g;

    public f(Bundle bundle) {
        this.f86a = e(bundle, "ev");
        this.f88c = e(bundle, "id");
        this.f89d = b(bundle, "l");
        this.f90e = e(bundle, "t");
        this.f91f = e(bundle, "s");
        this.f87b = b(bundle, "c");
        this.f92g = h(bundle.getString("dt"));
    }

    public static int b(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return 0;
        }
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static String e(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return "";
        }
        return string;
    }

    public static long h(String str) {
        if (str == null) {
            return 0L;
        }
        try {
            return new SimpleDateFormat("dd/MM/yyyy HH:mm Z", Locale.US).parse(str).getTime();
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public String a() {
        return this.f88c;
    }

    public int c() {
        return this.f89d;
    }

    public String d() {
        return this.f91f;
    }

    public String f() {
        return this.f86a;
    }

    public long g() {
        return this.f92g;
    }

    public String getContentType() {
        return this.f90e;
    }

    public int getNewMessageCount() {
        return this.f87b;
    }

    public String toString() {
        return "SyncMessage [mSyncTriggerEvent=" + this.f86a + ", mNewMessageCount=" + this.f87b + ", mMessageId=" + this.f88c + ", mMessageLength=" + this.f89d + ", mContentType=" + this.f90e + ", mSender=" + this.f91f + ", mMsgTimeMillis=" + this.f92g + "]";
    }
}
