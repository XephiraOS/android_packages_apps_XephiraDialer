package W7;

import X7.d;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber$PhoneNumber;
import com.heytap.accessory.constant.FastPairConstants;
import com.oplus.phonenoareainquire.utils.LogUtil;
import java.util.List;
import java.util.Locale;

/* compiled from: PhoneNumberOfflineGeocoder.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static a f4218c;

    /* renamed from: a, reason: collision with root package name */
    public d f4219a;

    /* renamed from: b, reason: collision with root package name */
    public final PhoneNumberUtil f4220b = PhoneNumberUtil.C();

    public a(String str) {
        this.f4219a = null;
        this.f4219a = new d(str);
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f4218c == null) {
                    f4218c = new a("/assets/com/oplus/google/i18n/phonenumbers/geocoding/data/");
                }
                aVar = f4218c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public final String a(Phonenumber$PhoneNumber phonenumber$PhoneNumber, Locale locale) {
        List<String> O10 = this.f4220b.O(phonenumber$PhoneNumber.f());
        if (O10.size() == 1) {
            return e(O10.get(0), locale);
        }
        String str = "ZZ";
        for (String str2 : O10) {
            if (this.f4220b.c0(phonenumber$PhoneNumber, str2)) {
                if (!str.equals("ZZ")) {
                    return "";
                }
                str = str2;
            }
        }
        return e(str, locale);
    }

    public String b(Phonenumber$PhoneNumber phonenumber$PhoneNumber, Locale locale) {
        PhoneNumberUtil.PhoneNumberType J10 = this.f4220b.J(phonenumber$PhoneNumber);
        LogUtil.a("PhoneNumberOfflineGeocoder", "numberType = " + J10);
        if (J10 == PhoneNumberUtil.PhoneNumberType.UNKNOWN) {
            return "";
        }
        if (!this.f4220b.S(J10, phonenumber$PhoneNumber.f())) {
            return a(phonenumber$PhoneNumber, locale);
        }
        return c(phonenumber$PhoneNumber, locale);
    }

    public String c(Phonenumber$PhoneNumber phonenumber$PhoneNumber, Locale locale) {
        String c10;
        Phonenumber$PhoneNumber phonenumber$PhoneNumber2;
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String B10 = PhoneNumberUtil.B(phonenumber$PhoneNumber.f());
        String G10 = this.f4220b.G(phonenumber$PhoneNumber);
        if (!B10.equals("") && G10.startsWith(B10)) {
            try {
                phonenumber$PhoneNumber2 = this.f4220b.p0(G10.substring(B10.length()), this.f4220b.L(phonenumber$PhoneNumber.f()));
            } catch (NumberParseException unused) {
                phonenumber$PhoneNumber2 = phonenumber$PhoneNumber;
            }
            c10 = this.f4219a.c(phonenumber$PhoneNumber2, language, "", country);
        } else {
            c10 = this.f4219a.c(phonenumber$PhoneNumber, language, "", country);
        }
        if (c10.length() <= 0) {
            return a(phonenumber$PhoneNumber, locale);
        }
        return c10;
    }

    public final String e(String str, Locale locale) {
        if (str == null || str.equals("ZZ") || str.equals(FastPairConstants.STATUS_CONNECT_RESULT_FAIL)) {
            return "";
        }
        return new Locale("", str).getDisplayCountry(locale);
    }
}
