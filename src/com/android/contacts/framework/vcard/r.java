package com.android.contacts.framework.vcard;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: VCardParser_V30.java */
/* loaded from: classes.dex */
public class r extends m {

    /* renamed from: b, reason: collision with root package name */
    public static final Set<String> f16550b = Collections.unmodifiableSet(new HashSet(Arrays.asList("BEGIN", "END", "LOGO", "PHOTO", "LABEL", "FN", "TITLE", "SOUND", "VERSION", "TEL", "EMAIL", "TZ", "GEO", "NOTE", "URL", "BDAY", "ROLE", "REV", "UID", "KEY", "MAILER", "NAME", "PROFILE", "SOURCE", "NICKNAME", "CLASS", "SORT-STRING", "CATEGORIES", "PRODID", "IMPP")));

    /* renamed from: c, reason: collision with root package name */
    public static final Set<String> f16551c = Collections.unmodifiableSet(new HashSet(Arrays.asList("7BIT", "8BIT", "BASE64", "B")));

    /* renamed from: a, reason: collision with root package name */
    public final o f16552a;

    public r() {
        this.f16552a = new o();
    }

    @Override // com.android.contacts.framework.vcard.m
    public void a(l lVar) {
        this.f16552a.a(lVar);
    }

    @Override // com.android.contacts.framework.vcard.m
    public void b() {
        this.f16552a.b();
    }

    @Override // com.android.contacts.framework.vcard.m
    public void c(InputStream inputStream) {
        this.f16552a.E(inputStream);
    }

    public r(int i10) {
        this.f16552a = new o(i10);
    }
}
