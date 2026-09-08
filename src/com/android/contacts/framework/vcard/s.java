package com.android.contacts.framework.vcard;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: VCardParser_V40.java */
/* loaded from: classes.dex */
public class s extends m {

    /* renamed from: b, reason: collision with root package name */
    public static final Set<String> f16553b = Collections.unmodifiableSet(new HashSet(Arrays.asList("BEGIN", "END", "VERSION", "SOURCE", "KIND", "FN", "N", "NICKNAME", "PHOTO", "BDAY", "ANNIVERSARY", "GENDER", "ADR", "TEL", "EMAIL", "IMPP", "LANG", "TZ", "GEO", "TITLE", "ROLE", "LOGO", "ORG", "MEMBER", "RELATED", "CATEGORIES", "NOTE", "PRODID", "REV", "SOUND", "UID", "CLIENTPIDMAP", "URL", "KEY", "FBURL", "CALENDRURI", "CALURI", "XML")));

    /* renamed from: c, reason: collision with root package name */
    public static final Set<String> f16554c = Collections.unmodifiableSet(new HashSet(Arrays.asList("8BIT", "B")));

    /* renamed from: a, reason: collision with root package name */
    public final p f16555a = new p();

    @Override // com.android.contacts.framework.vcard.m
    public void a(l lVar) {
        this.f16555a.a(lVar);
    }

    @Override // com.android.contacts.framework.vcard.m
    public void b() {
        this.f16555a.b();
    }

    @Override // com.android.contacts.framework.vcard.m
    public void c(InputStream inputStream) {
        this.f16555a.E(inputStream);
    }
}
