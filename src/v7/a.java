package V7;

import X7.d;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber$PhoneNumber;
import java.util.Locale;

/* compiled from: PhoneNumberToCarrierMapper.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static a f4093c;

    /* renamed from: a, reason: collision with root package name */
    public d f4094a;

    /* renamed from: b, reason: collision with root package name */
    public final PhoneNumberUtil f4095b = PhoneNumberUtil.C();

    public a(String str) {
        this.f4094a = null;
        this.f4094a = new d(str);
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f4093c == null) {
                    f4093c = new a("/assets/com/oplus/google/i18n/phonenumbers/carrier/data/");
                }
                aVar = f4093c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public void a() {
        this.f4094a.a();
    }

    public String c(Phonenumber$PhoneNumber phonenumber$PhoneNumber, Locale locale) {
        if (e(this.f4095b.J(phonenumber$PhoneNumber))) {
            return d(phonenumber$PhoneNumber, locale);
        }
        if (com.oplus.phonenoareainquire.utils.d.f(phonenumber$PhoneNumber.f(), this.f4095b.G(phonenumber$PhoneNumber))) {
            return d(phonenumber$PhoneNumber, locale);
        }
        return "";
    }

    public String d(Phonenumber$PhoneNumber phonenumber$PhoneNumber, Locale locale) {
        return this.f4094a.c(phonenumber$PhoneNumber, locale.getLanguage(), "", locale.getCountry());
    }

    public final boolean e(PhoneNumberUtil.PhoneNumberType phoneNumberType) {
        if (phoneNumberType != PhoneNumberUtil.PhoneNumberType.MOBILE && phoneNumberType != PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE && phoneNumberType != PhoneNumberUtil.PhoneNumberType.PAGER) {
            return false;
        }
        return true;
    }
}
