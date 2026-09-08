package com.internal_dependency;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
class OplusCountryDetector {
    private static final String TAG = "CountryDetector";
    private static OplusCountryDetector sInstance;
    private final String DEFAULT_COUNTRY_ISO;
    private final LocaleProvider mLocaleProvider;
    private final TelephonyManager mTelephonyManager;

    /* loaded from: classes3.dex */
    public static class LocaleProvider {
        public Locale getDefaultLocale() {
            return Locale.getDefault();
        }
    }

    private OplusCountryDetector(Context context) {
        this(context, (TelephonyManager) context.getSystemService("phone"), new LocaleProvider());
    }

    public static synchronized OplusCountryDetector getInstance(Context context) {
        OplusCountryDetector oplusCountryDetector;
        synchronized (OplusCountryDetector.class) {
            try {
                if (sInstance == null) {
                    sInstance = new OplusCountryDetector(context.getApplicationContext());
                }
                oplusCountryDetector = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return oplusCountryDetector;
    }

    private String getLocaleBasedCountryIso() {
        Locale defaultLocale = this.mLocaleProvider.getDefaultLocale();
        if (defaultLocale != null) {
            return defaultLocale.getCountry();
        }
        return null;
    }

    private String getNetworkBasedCountryIso() {
        return this.mTelephonyManager.getNetworkCountryIso();
    }

    private boolean isNetworkCountryCodeAvailable() {
        if (this.mTelephonyManager.getPhoneType() == 1) {
            return true;
        }
        return false;
    }

    public String getCurrentCountryIso() {
        String str;
        if (isNetworkCountryCodeAvailable()) {
            str = getNetworkBasedCountryIso();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = getSimBasedCountryIso();
        }
        if (TextUtils.isEmpty(str)) {
            str = getLocaleBasedCountryIso();
        }
        if (TextUtils.isEmpty(str) || isNumeric(str)) {
            str = "US";
        }
        return str.toUpperCase(Locale.US);
    }

    public OplusCountryDetector getInstanceForTest(Context context, TelephonyManager telephonyManager, LocaleProvider localeProvider) {
        return new OplusCountryDetector(context, telephonyManager, localeProvider);
    }

    public String getSimBasedCountryIso() {
        return this.mTelephonyManager.getSimCountryIso();
    }

    public boolean isNumeric(String str) {
        if (TextUtils.isEmpty(str) || !Pattern.compile("[0-9]*").matcher(str).matches()) {
            return false;
        }
        return true;
    }

    private OplusCountryDetector(Context context, TelephonyManager telephonyManager, LocaleProvider localeProvider) {
        this.DEFAULT_COUNTRY_ISO = "US";
        this.mTelephonyManager = telephonyManager;
        this.mLocaleProvider = localeProvider;
    }
}
