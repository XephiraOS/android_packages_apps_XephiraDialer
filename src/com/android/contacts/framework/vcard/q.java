package com.android.contacts.framework.vcard;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: VCardParser_V21.java */
/* loaded from: classes.dex */
public final class q extends m {

    /* renamed from: b, reason: collision with root package name */
    public static final Set<String> f16545b = Collections.unmodifiableSet(new HashSet(Arrays.asList("BEGIN", "END", "LOGO", "PHOTO", "LABEL", "FN", "TITLE", "SOUND", "VERSION", "TEL", "EMAIL", "TZ", "GEO", "NOTE", "URL", "BDAY", "ROLE", "REV", "UID", "KEY", "MAILER", "ADR", "ORG", "NICKNAME")));

    /* renamed from: c, reason: collision with root package name */
    public static final Set<String> f16546c = Collections.unmodifiableSet(new HashSet(Arrays.asList("DOM", "INTL", "POSTAL", "PARCEL", "HOME", "WORK", "PREF", "VOICE", "FAX", "MSG", "CELL", "PAGER", "BBS", "MODEM", "CAR", "ISDN", "VIDEO", "AOL", "APPLELINK", "ATTMAIL", "CIS", "EWORLD", "INTERNET", "IBMMAIL", "MCIMAIL", "POWERSHARE", "PRODIGY", "TLX", "X400", "GIF", "CGM", "WMF", "BMP", "MET", "PMB", "DIB", "PICT", "TIFF", "PDF", "PS", "JPEG", "QTIME", "MPEG", "MPEG2", "AVI", "WAVE", "AIFF", "PCM", "X509", "PGP")));

    /* renamed from: d, reason: collision with root package name */
    public static final Set<String> f16547d = Collections.unmodifiableSet(new HashSet(Arrays.asList("INLINE", "URL", "CONTENT-ID", "CID")));

    /* renamed from: e, reason: collision with root package name */
    public static final Set<String> f16548e = Collections.unmodifiableSet(new HashSet(Arrays.asList("7BIT", "8BIT", "QUOTED-PRINTABLE", "BASE64", "B")));

    /* renamed from: a, reason: collision with root package name */
    public final n f16549a;

    public q() {
        this.f16549a = new n();
    }

    @Override // com.android.contacts.framework.vcard.m
    public void a(l lVar) {
        this.f16549a.a(lVar);
    }

    @Override // com.android.contacts.framework.vcard.m
    public void b() {
        this.f16549a.b();
    }

    @Override // com.android.contacts.framework.vcard.m
    public void c(InputStream inputStream) {
        this.f16549a.E(inputStream);
    }

    public q(int i10) {
        this.f16549a = new n(i10);
    }
}
