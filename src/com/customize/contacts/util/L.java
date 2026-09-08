package com.customize.contacts.util;

import com.oplus.backup.sdk.common.utils.Constants;
import java.util.Locale;

/* compiled from: LocaleSet.java */
/* loaded from: classes3.dex */
public class L {

    /* renamed from: a, reason: collision with root package name */
    public final a f21910a;

    /* renamed from: b, reason: collision with root package name */
    public final a f21911b;

    /* compiled from: LocaleSet.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Locale f21912a;

        public a(Locale locale) {
            this.f21912a = locale;
        }

        public Locale a() {
            return this.f21912a;
        }

        public boolean b() {
            if (this.f21912a != null) {
                return true;
            }
            return false;
        }

        public boolean c(Locale locale) {
            Locale locale2 = this.f21912a;
            if (locale2 == null) {
                if (locale == null) {
                    return true;
                }
                return false;
            }
            return locale2.equals(locale);
        }

        public String toString() {
            Locale locale = this.f21912a;
            if (locale != null) {
                return locale.toLanguageTag();
            }
            return "(null)";
        }
    }

    public L(Locale locale) {
        this(locale, null);
    }

    public static L a() {
        return new L(Locale.getDefault());
    }

    public Locale b() {
        return this.f21910a.a();
    }

    public Locale c() {
        return this.f21911b.a();
    }

    public boolean d() {
        return this.f21911b.b();
    }

    public boolean e(Locale locale) {
        return this.f21910a.c(locale);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof L)) {
            return false;
        }
        L l10 = (L) obj;
        if (l10.e(this.f21910a.a()) && l10.f(this.f21911b.a())) {
            return true;
        }
        return false;
    }

    public boolean f(Locale locale) {
        return this.f21911b.c(locale);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f21910a.toString());
        if (d()) {
            sb.append(Constants.DataMigration.SPLIT_TAG);
            sb.append(this.f21911b.toString());
        }
        return sb.toString();
    }

    public L(Locale locale, Locale locale2) {
        this.f21910a = new a(locale);
        this.f21911b = new a(locale.equals(locale2) ? null : locale2);
    }
}
