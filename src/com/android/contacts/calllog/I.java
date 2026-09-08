package com.android.contacts.calllog;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.telecom.PhoneAccountHandle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SubscriptionInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.contacts.ContactsApplication;
import com.android.incallui.OplusPhoneUtils;
import com.google.common.base.Optional;
import com.oplus.dialer.R;
import h1.C1072a;
import java.util.Iterator;
import java.util.List;

/* compiled from: PhoneNumberHelper.java */
/* loaded from: classes.dex */
public class I {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f13851a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f13852b;

    /* renamed from: c, reason: collision with root package name */
    public String f13853c;

    /* renamed from: d, reason: collision with root package name */
    public String f13854d;

    public I(Context context) {
        this.f13852b = context;
        this.f13851a = context.getResources();
        l(context);
    }

    public static boolean a(CharSequence charSequence) {
        if (!B3.a.f0()) {
            if (TextUtils.isEmpty(charSequence) || charSequence.equals(OplusPhoneUtils.DeviceState.INVALID_STATUS) || charSequence.equals("-2") || charSequence.equals("-3")) {
                return false;
            }
            return true;
        }
        if (TextUtils.isEmpty(charSequence) || charSequence.equals(OplusPhoneUtils.DeviceState.INVALID_STATUS) || charSequence.equals("-2") || charSequence.equals("-3") || i(charSequence)) {
            return false;
        }
        return true;
    }

    public static boolean b(CharSequence charSequence) {
        if (a(charSequence) && !g(charSequence)) {
            return true;
        }
        return false;
    }

    public static boolean f(Context context, String str) {
        List<PhoneAccountHandle> a10 = s1.g.a(context);
        if (a10.size() <= 1) {
            return PhoneNumberUtils.isLocalEmergencyNumber(context, str);
        }
        Iterator<PhoneAccountHandle> it = a10.iterator();
        while (it.hasNext()) {
            Optional<SubscriptionInfo> e10 = s1.i.e(context, it.next());
            if (e10.c() && C1072a.d(context, e10.b().getSubscriptionId(), str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean g(CharSequence charSequence) {
        if (charSequence != null && C1072a.f(charSequence.toString())) {
            return true;
        }
        return false;
    }

    public static boolean h(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, OplusPhoneUtils.DeviceState.INVALID_STATUS) && !TextUtils.equals(charSequence, "-2") && !TextUtils.equals(charSequence, "-3")) {
            return false;
        }
        return true;
    }

    public static boolean i(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, "-100") && !TextUtils.equals(charSequence, "-101") && !TextUtils.equals(charSequence, "-102")) {
            return false;
        }
        return true;
    }

    public Uri c(String str) {
        if (k(str)) {
            return Uri.fromParts("tel", str, null);
        }
        if (g(str)) {
            return Uri.fromParts("sip", str, null);
        }
        return Uri.fromParts("tel", str, null);
    }

    public CharSequence d(CharSequence charSequence, CharSequence charSequence2, int i10) {
        if (TextUtils.isEmpty(charSequence)) {
            return this.f13851a.getString(R.string.unknown_number);
        }
        if (charSequence.equals(OplusPhoneUtils.DeviceState.INVALID_STATUS)) {
            return this.f13851a.getString(R.string.unknown_number);
        }
        if (charSequence.equals("-2")) {
            return this.f13851a.getString(R.string.private_num);
        }
        if (charSequence.equals("-3")) {
            return this.f13851a.getString(R.string.payphone);
        }
        if (B3.a.f0()) {
            if (charSequence.equals("-100")) {
                return this.f13851a.getString(R.string.anonymous_number);
            }
            if (charSequence.equals("-101")) {
                return this.f13851a.getString(R.string.unrecognized_number);
            }
            if (charSequence.equals("-102")) {
                return this.f13851a.getString(R.string.payphone_number);
            }
        }
        if (TextUtils.isEmpty(charSequence2)) {
            return e(charSequence, i10);
        }
        return e(charSequence2, i10);
    }

    public CharSequence e(CharSequence charSequence, int i10) {
        if (!ContactsApplication.f13094j) {
            if (i10 > 1) {
                return ((Object) charSequence) + " (" + i10 + ")";
            }
            return charSequence;
        }
        if (i10 > 1) {
            return "(" + i10 + ") " + ((Object) charSequence);
        }
        return charSequence;
    }

    public boolean j(long j10, String str, long j11, long j12) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String a10 = C1072a.a(str);
        if (TextUtils.isEmpty(a10)) {
            if (H7.a.b()) {
                H7.b.b("PhoneNumberHelper", "isVoiceMailNumber: number is empty after stripping");
            }
            return false;
        }
        if (j10 == j11) {
            return PhoneNumberUtils.compare(a10, this.f13853c);
        }
        if (j10 != j12) {
            return false;
        }
        return PhoneNumberUtils.compare(a10, this.f13854d);
    }

    public boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String a10 = C1072a.a(str);
        if (TextUtils.isEmpty(a10)) {
            if (H7.a.b()) {
                H7.b.b("PhoneNumberHelper", "isVoiceMailNumber: number is empty after stripping");
            }
            return false;
        }
        if (B3.a.i()) {
            if (!PhoneNumberUtils.compare(a10, this.f13853c) && !PhoneNumberUtils.compare(a10, this.f13854d)) {
                return false;
            }
            return true;
        }
        return PhoneNumberUtils.compare(a10, this.f13853c);
    }

    public boolean l(Context context) {
        String str = this.f13853c;
        String str2 = this.f13854d;
        if (B3.a.i()) {
            try {
                this.f13853c = D7.c.e(0);
                this.f13854d = D7.c.e(1);
            } catch (Throwable th) {
                H7.b.c("PhoneNumberHelper", "e = " + th);
            }
        } else {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(TelephonyManager.class);
            if (telephonyManager != null) {
                this.f13853c = telephonyManager.getVoiceMailNumber();
            }
            this.f13854d = "";
        }
        if (H7.a.b()) {
            H7.b.b("PhoneNumberHelper", "[updateVoicemailNumber]mVoiceMailNumber0 = " + this.f13853c + ", mVoiceMailNumber1 = " + this.f13854d);
        }
        if (!TextUtils.equals(str, this.f13853c) || !TextUtils.equals(str2, this.f13854d)) {
            return true;
        }
        return false;
    }
}
