package D1;

import android.content.Context;
import android.content.SharedPreferences;
import android.telecom.PhoneAccountHandle;
import t1.C1580a;

/* compiled from: PerAccountSharedPreferences.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f415a;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f416b;

    /* renamed from: c, reason: collision with root package name */
    public final PhoneAccountHandle f417c;

    /* compiled from: PerAccountSharedPreferences.java */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public final SharedPreferences.Editor f418a;

        public void a() {
            this.f418a.apply();
        }

        public a b(String str, boolean z10) {
            this.f418a.putBoolean(b.this.f(str), z10);
            return this;
        }

        public a c(String str, String str2) {
            this.f418a.putString(b.this.f(str), str2);
            return this;
        }

        public a() {
            this.f418a = b.this.f416b.edit();
        }
    }

    public b(Context context, PhoneAccountHandle phoneAccountHandle, SharedPreferences sharedPreferences) {
        this.f416b = sharedPreferences;
        this.f417c = phoneAccountHandle;
        this.f415a = "phone_account_dependent_";
    }

    public boolean c(String str) {
        return this.f416b.contains(f(str));
    }

    public a d() {
        return new a();
    }

    public boolean e(String str, boolean z10) {
        return ((Boolean) i(str, Boolean.valueOf(z10))).booleanValue();
    }

    public final String f(String str) {
        return this.f415a + str + "_" + this.f417c.getId();
    }

    public String g(String str) {
        return (String) i(str, null);
    }

    public String h(String str, String str2) {
        return (String) i(str, str2);
    }

    public final <T> T i(String str, T t10) {
        if (!c(str)) {
            return t10;
        }
        T t11 = (T) this.f416b.getAll().get(f(str));
        if (t11 == null) {
            return t10;
        }
        return t11;
    }

    public b(Context context, PhoneAccountHandle phoneAccountHandle, SharedPreferences sharedPreferences, String str) {
        C1580a.a(str.equals("visual_voicemail_"));
        this.f416b = sharedPreferences;
        this.f417c = phoneAccountHandle;
        this.f415a = str;
    }
}
