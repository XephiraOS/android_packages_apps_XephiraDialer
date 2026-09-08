package q0;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.android.contacts.calllog.I;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber$PhoneNumber;
import java.util.Locale;
import java.util.Optional;

/* compiled from: Constraints.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final PhoneNumberUtil f36122a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f36123b;

    /* renamed from: c, reason: collision with root package name */
    public final f f36124c;

    public e(Context context, f fVar) {
        if (context != null) {
            this.f36123b = context;
            if (fVar != null) {
                this.f36124c = fVar;
                this.f36122a = PhoneNumberUtil.C();
                return;
            }
            throw new NullPointerException("Provided configProviderCountryCodes cannot be null");
        }
        throw new NullPointerException("Provided context cannot be null");
    }

    public final boolean a(Optional<Phonenumber$PhoneNumber> optional) {
        if (optional.get().o() && !TextUtils.isEmpty(optional.get().h())) {
            H7.b.e("Constraints", "doesNotHaveExtension: phone number has an extension");
            return false;
        }
        return true;
    }

    public final boolean b(String str, Context context) {
        boolean z10;
        if (!PhoneNumberUtils.isEmergencyNumber(str) && !I.f(context, str)) {
            z10 = true;
        } else {
            z10 = false;
        }
        H7.b.e("Constraints", "isNotEmergencyNumber: result = " + String.valueOf(z10));
        return z10;
    }

    public final boolean c(Optional<Phonenumber$PhoneNumber> optional) {
        if (optional.get().m() && optional.get().g() != Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            H7.b.e("Constraints", "isNotInternationalNumber: phone number already provided the country code");
            return false;
        }
        return true;
    }

    public final boolean d(String str, String str2) {
        boolean z10 = !str.equals(str2);
        H7.b.e("Constraints", "isUserRoaming: result = " + String.valueOf(z10));
        return z10;
    }

    public final boolean e(Optional<Phonenumber$PhoneNumber> optional) {
        boolean b02 = this.f36122a.b0(optional.get());
        H7.b.e("Constraints", "isValidNumber: result = " + String.valueOf(b02));
        return b02;
    }

    public boolean f(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            H7.b.e("Constraints", "meetsPreconditions: numberToCheck was empty");
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            H7.b.e("Constraints", "meetsPreconditions: userHomeCountryCode was empty");
            return false;
        }
        if (TextUtils.isEmpty(str3)) {
            H7.b.e("Constraints", "meetsPreconditions: userRoamingCountryCode was empty");
            return false;
        }
        Locale locale = Locale.US;
        String upperCase = str2.toUpperCase(locale);
        String upperCase2 = str3.toUpperCase(locale);
        Optional<Phonenumber$PhoneNumber> g10 = g(str, upperCase);
        if (!g10.isPresent()) {
            H7.b.e("Constraints", "meetsPreconditions: parsedPhoneNumber was empty");
            return false;
        }
        if (!d(upperCase, upperCase2) || !c(g10) || !b(str, this.f36123b) || !e(g10) || !a(g10)) {
            return false;
        }
        return true;
    }

    public final Optional<Phonenumber$PhoneNumber> g(String str, String str2) {
        try {
            return Optional.of(this.f36122a.r0(str, str2));
        } catch (NumberParseException unused) {
            H7.b.c("Constraints", "parsePhoneNumber: could not parse the number");
            return Optional.empty();
        } catch (Exception e10) {
            H7.b.c("Constraints", "parsePhoneNumber: error" + e10);
            return Optional.empty();
        }
    }
}
