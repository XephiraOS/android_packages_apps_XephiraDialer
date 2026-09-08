package com.android.contacts.assisteddialing;

import H7.b;
import android.text.TextUtils;
import com.android.contacts.assisteddialing.TransformationInfo;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber$PhoneNumber;
import java.util.Optional;
import q0.e;

/* compiled from: NumberTransformer.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final PhoneNumberUtil f13681a = PhoneNumberUtil.C();

    /* renamed from: b, reason: collision with root package name */
    public final e f13682b;

    public a(e eVar) {
        this.f13682b = eVar;
    }

    public Optional<TransformationInfo> a(String str, String str2, String str3) {
        Phonenumber$PhoneNumber phonenumber$PhoneNumber;
        if (!this.f13682b.f(str, str2, str3)) {
            b.e("NumberTransformer", "doAssistedDialingTransformation; assisted dialing failed preconditions");
            return Optional.empty();
        }
        try {
            phonenumber$PhoneNumber = this.f13681a.p0(str, str2);
        } catch (NumberParseException unused) {
            b.e("NumberTransformer", "doAssistedDialingTransformation; number failed to parse");
            phonenumber$PhoneNumber = null;
        }
        if (phonenumber$PhoneNumber == null) {
            return Optional.empty();
        }
        String x10 = this.f13681a.x(phonenumber$PhoneNumber, str3, true);
        if (TextUtils.isEmpty(x10)) {
            b.e("NumberTransformer", "doAssistedDialingTransformation; formatNumberForMobileDialing returned an empty string");
            return Optional.empty();
        }
        return Optional.of(new TransformationInfo.b().g(str).h(x10).j(str2).k(str3).i(phonenumber$PhoneNumber.f()).f());
    }
}
