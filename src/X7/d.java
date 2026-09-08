package X7;

import com.google.i18n.phonenumbers.Phonenumber$PhoneNumber;
import com.oplus.backup.sdk.common.utils.Constants;
import com.oplus.google.i18n.phonenumbers.prefixmapper.MappingFileProvider;
import com.oplus.google.i18n.phonenumbers.prefixmapper.PhonePrefixMap;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: PrefixFileReader.java */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    public static final Logger f4317d = Logger.getLogger(d.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final String f4318a;

    /* renamed from: b, reason: collision with root package name */
    public MappingFileProvider f4319b = new MappingFileProvider();

    /* renamed from: c, reason: collision with root package name */
    public Map<String, PhonePrefixMap> f4320c = new HashMap();

    public d(String str) {
        this.f4318a = str;
        g();
    }

    public static void b(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                f4317d.log(Level.WARNING, e10.toString());
            }
        }
    }

    public void a() {
        this.f4320c.clear();
    }

    public String c(Phonenumber$PhoneNumber phonenumber$PhoneNumber, String str, String str2, String str3) {
        String str4;
        int f10 = phonenumber$PhoneNumber.f();
        if (f10 == 1) {
            f10 = ((int) (phonenumber$PhoneNumber.i() / 10000000)) + 1000;
        }
        PhonePrefixMap d10 = d(f10, str, str2, str3);
        if (d10 != null) {
            str4 = d10.c(phonenumber$PhoneNumber);
        } else {
            str4 = null;
        }
        if ((str4 == null || str4.length() == 0) && j(str)) {
            PhonePrefixMap d11 = d(f10, "en", "", "");
            if (d11 == null) {
                return "";
            }
            str4 = d11.c(phonenumber$PhoneNumber);
        }
        if (str4 == null) {
            return "";
        }
        return str4;
    }

    public final PhonePrefixMap d(int i10, String str, String str2, String str3) {
        if (str3.equals("IN") && !str.equals("hi")) {
            str = "en";
        }
        String d10 = this.f4319b.d(i10, str, str2, str3);
        if (d10.length() == 0) {
            if (!str.equals("hi")) {
                return null;
            }
            d10 = "91_hi";
        }
        return e(d10);
    }

    public final PhonePrefixMap e(String str) {
        PhonePrefixMap phonePrefixMap = this.f4320c.get(str);
        if (phonePrefixMap == null) {
            PhonePrefixMap f10 = f(str);
            this.f4320c.put(str, f10);
            return f10;
        }
        return phonePrefixMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.oplus.google.i18n.phonenumbers.prefixmapper.PhonePrefixMap f(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.oplus.phonenoareainquire.PhoneNoInquireProvider.r()
            r0.append(r1)
            java.lang.String r1 = "carrier_data"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = java.io.File.separator
            r1.append(r0)
            r1.append(r4)
            java.lang.String r0 = r1.toString()
            int r1 = com.oplus.phonenoareainquire.utils.d.c()
            r2 = 2
            if (r1 <= r2) goto L57
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            boolean r1 = r1.exists()
            if (r1 == 0) goto L57
            com.oplus.google.i18n.phonenumbers.prefixmapper.PhonePrefixMap r0 = r3.h(r0)     // Catch: java.lang.Exception -> L40
            goto L58
        L40:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "e = "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "PrefixFileReader"
            android.util.Log.e(r1, r0)
        L57:
            r0 = 0
        L58:
            if (r0 != 0) goto L5e
            com.oplus.google.i18n.phonenumbers.prefixmapper.PhonePrefixMap r0 = r3.i(r4)
        L5e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: X7.d.f(java.lang.String):com.oplus.google.i18n.phonenumbers.prefixmapper.PhonePrefixMap");
    }

    public final void g() {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                objectInputStream = new ObjectInputStream(d.class.getResourceAsStream(this.f4318a + Constants.MessagerConstants.CONFIG_KEY));
            } catch (IOException e10) {
                e = e10;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f4319b.readExternal(objectInputStream);
            b(objectInputStream);
        } catch (IOException e11) {
            e = e11;
            objectInputStream2 = objectInputStream;
            f4317d.log(Level.WARNING, e.toString());
            b(objectInputStream2);
        } catch (Throwable th2) {
            th = th2;
            objectInputStream2 = objectInputStream;
            b(objectInputStream2);
            throw th;
        }
    }

    public final PhonePrefixMap h(String str) {
        ObjectInputStream objectInputStream;
        InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream(str);
        ObjectInputStream objectInputStream2 = null;
        try {
            objectInputStream = new ObjectInputStream(systemResourceAsStream);
            try {
                try {
                    PhonePrefixMap phonePrefixMap = new PhonePrefixMap();
                    phonePrefixMap.readExternal(objectInputStream);
                    b(objectInputStream);
                    return phonePrefixMap;
                } catch (IOException e10) {
                    e = e10;
                    f4317d.log(Level.WARNING, e.toString());
                    b(objectInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                objectInputStream2 = objectInputStream;
                b(objectInputStream2);
                throw th;
            }
        } catch (IOException e11) {
            e = e11;
            objectInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            b(objectInputStream2);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v4 */
    public final PhonePrefixMap i(String str) {
        ObjectInputStream objectInputStream;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4318a);
        sb.append(str);
        ?? r42 = 0;
        try {
            try {
                objectInputStream = new ObjectInputStream(d.class.getResourceAsStream(sb.toString()));
                try {
                    PhonePrefixMap phonePrefixMap = new PhonePrefixMap();
                    phonePrefixMap.readExternal(objectInputStream);
                    b(objectInputStream);
                    return phonePrefixMap;
                } catch (IOException e10) {
                    e = e10;
                    f4317d.log(Level.WARNING, e.toString());
                    b(objectInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r42 = sb;
                b(r42);
                throw th;
            }
        } catch (IOException e11) {
            e = e11;
            objectInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            b(r42);
            throw th;
        }
    }

    public final boolean j(String str) {
        if (!str.equals("zh") && !str.equals("ja") && !str.equals("ko")) {
            return true;
        }
        return false;
    }
}
