package q0;

import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Locale;
import java.util.Optional;

/* compiled from: LocationDetector.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final TelephonyManager f36127a;

    /* renamed from: b, reason: collision with root package name */
    public final String f36128b;

    public g(TelephonyManager telephonyManager, String str) {
        if (telephonyManager != null) {
            this.f36127a = telephonyManager;
            this.f36128b = str;
            return;
        }
        throw new NullPointerException("Provided TelephonyManager was null");
    }

    public Optional<String> a() {
        if (!TextUtils.isEmpty(this.f36128b)) {
            H7.b.e("LocationDetector", "getUpperCaseUserHomeCountry: user provided home country code");
            return Optional.of(this.f36128b.toUpperCase(Locale.US));
        }
        if (this.f36127a.getSimCountryIso() != null) {
            H7.b.e("LocationDetector", "getUpperCaseUserHomeCountry: using sim country iso");
            return Optional.of(this.f36127a.getSimCountryIso().toUpperCase(Locale.US));
        }
        H7.b.e("LocationDetector", "getUpperCaseUserHomeCountry: user home country was null");
        return Optional.empty();
    }

    public Optional<String> b() {
        if (this.f36127a.getNetworkCountryIso() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("getUpperCaseUserRoamingCountry: ");
            String networkCountryIso = this.f36127a.getNetworkCountryIso();
            Locale locale = Locale.US;
            sb.append(networkCountryIso.toUpperCase(locale));
            H7.b.b("LocationDetector", sb.toString());
            return Optional.of(this.f36127a.getNetworkCountryIso().toUpperCase(locale));
        }
        H7.b.e("LocationDetector", "getUpperCaseUserRoamingCountry: user roaming country was null");
        return Optional.empty();
    }
}
