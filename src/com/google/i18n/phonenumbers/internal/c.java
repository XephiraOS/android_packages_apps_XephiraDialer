package com.google.i18n.phonenumbers.internal;

import com.google.i18n.phonenumbers.Phonemetadata$PhoneNumberDesc;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: RegexBasedMatcher.java */
/* loaded from: classes3.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name */
    public final RegexCache f24951a = new RegexCache(100);

    public static b b() {
        return new c();
    }

    public static boolean c(CharSequence charSequence, Pattern pattern, boolean z10) {
        Matcher matcher = pattern.matcher(charSequence);
        if (!matcher.lookingAt()) {
            return false;
        }
        if (matcher.matches()) {
            return true;
        }
        return z10;
    }

    @Override // com.google.i18n.phonenumbers.internal.b
    public boolean a(CharSequence charSequence, Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc, boolean z10) {
        String a10 = phonemetadata$PhoneNumberDesc.a();
        if (a10.length() == 0) {
            return false;
        }
        return c(charSequence, this.f24951a.a(a10), z10);
    }
}
