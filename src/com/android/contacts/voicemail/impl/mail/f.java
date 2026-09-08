package com.android.contacts.voicemail.impl.mail;

import java.util.Date;
import java.util.HashSet;

/* compiled from: Message.java */
/* loaded from: classes.dex */
public abstract class f implements h, a {

    /* renamed from: d, reason: collision with root package name */
    public static final f[] f18092d = new f[0];

    /* renamed from: a, reason: collision with root package name */
    public String f18093a;

    /* renamed from: b, reason: collision with root package name */
    public HashSet<String> f18094b = null;

    /* renamed from: c, reason: collision with root package name */
    public Date f18095c;

    public abstract Long i();

    public final HashSet<String> j() {
        if (this.f18094b == null) {
            this.f18094b = new HashSet<>();
        }
        return this.f18094b;
    }

    public String[] k() {
        return (String[]) j().toArray(new String[0]);
    }

    public abstract Address[] l();

    public abstract Date m();

    public String n() {
        return this.f18093a;
    }

    public void o(String str, boolean z10) {
        p(str, z10);
    }

    public final void p(String str, boolean z10) {
        if (z10) {
            j().add(str);
        } else {
            j().remove(str);
        }
    }

    public void q(Date date) {
        this.f18095c = date;
    }

    public void r(String str) {
        this.f18093a = str;
    }

    public String toString() {
        return getClass().getSimpleName() + ':' + this.f18093a;
    }
}
