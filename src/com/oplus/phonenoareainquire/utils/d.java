package com.oplus.phonenoareainquire.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber$PhoneNumber;
import com.oplus.phonenoareainquire.PhoneNoInquireProvider;
import com.oplus.phonenoareainquire.k;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.i;
import kotlin.text.n;

/* compiled from: PhoneNumberCarrierUtil.kt */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public static Pattern f28896b;

    /* renamed from: a, reason: collision with root package name */
    public static final d f28895a = new d();

    /* renamed from: c, reason: collision with root package name */
    public static int f28897c = -1;

    public static final boolean a(Context context, String phoneNumber, String str) {
        i.f(phoneNumber, "phoneNumber");
        if (phoneNumber.length() > 17) {
            phoneNumber = phoneNumber.substring(0, 17);
            i.e(phoneNumber, "substring(...)");
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = com.oplus.phonenoareainquire.a.b(context).a();
            }
            Phonenumber$PhoneNumber r02 = PhoneNumberUtil.C().r0(phoneNumber, str);
            if (r02 != null) {
                if (String.valueOf(r02.i()).length() >= 7) {
                    return true;
                }
            }
        } catch (NumberParseException e10) {
            Log.e("PhoneNumberCarrierUtil", "e=" + e10);
        }
        return false;
    }

    public static final void b(int i10) {
        f28896b = null;
        f28897c = i10;
        V7.a.b().a();
    }

    public static final int c() {
        if (f28897c == -1) {
            f28897c = k.d(k.e(PhoneNoInquireProvider.r() + "carrier_data"));
        }
        return f28897c;
    }

    public static final String d(long j10) {
        String valueOf = String.valueOf(j10);
        int length = 11 - valueOf.length();
        if (valueOf.length() >= 7 && length > 0) {
            StringBuilder sb = new StringBuilder(valueOf);
            char[] cArr = new char[length];
            Arrays.fill(cArr, '0');
            sb.append(new String(cArr));
            String sb2 = sb.toString();
            i.e(sb2, "toString(...)");
            return sb2;
        }
        if (length < 0) {
            String substring = valueOf.substring(0, 11);
            i.e(substring, "substring(...)");
            return substring;
        }
        return valueOf;
    }

    public static final void e() {
        String str;
        if (f28896b == null) {
            if (c() > 2) {
                str = com.oplus.phonenoareainquire.b.d();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                f28896b = Pattern.compile(str);
            } else {
                f28896b = Pattern.compile("192\\d{8}");
            }
        }
    }

    public static final boolean f(int i10, String str) {
        boolean q10;
        Matcher matcher;
        if (i10 == 86 && str != null) {
            q10 = n.q(str);
            if (!(!q10)) {
                return false;
            }
            e();
            Pattern pattern = f28896b;
            if (pattern != null) {
                matcher = pattern.matcher(str);
            } else {
                matcher = null;
            }
            if (matcher == null) {
                return false;
            }
            return matcher.lookingAt();
        }
        return false;
    }

    public static final String g(String carrierName, String location, boolean z10, Context context, String phoneNumber, String str) {
        i.f(carrierName, "carrierName");
        i.f(location, "location");
        i.f(phoneNumber, "phoneNumber");
        if (z10) {
            if (!TextUtils.isEmpty(carrierName)) {
                return location + " " + carrierName;
            }
        } else if (a(context, phoneNumber, str)) {
            return carrierName;
        }
        return location;
    }
}
