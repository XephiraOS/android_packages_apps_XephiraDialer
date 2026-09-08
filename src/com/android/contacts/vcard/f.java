package com.android.contacts.vcard;

import android.net.Uri;
import com.android.contacts.model.Account;

/* compiled from: ExportRequest.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f17750a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17751b;

    /* renamed from: c, reason: collision with root package name */
    public final Account f17752c;

    /* renamed from: d, reason: collision with root package name */
    public final String f17753d;

    /* renamed from: e, reason: collision with root package name */
    public String f17754e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f17755f;

    public f(Uri uri) {
        this(uri, null);
    }

    public f(Uri uri, String str) {
        this(uri, str, null);
    }

    public f(Uri uri, String str, Account account) {
        this(uri, str, null, account, false);
    }

    public f(Uri uri, String str, Account account, boolean z10) {
        this(uri, str, null, account, z10);
    }

    public f(Uri uri, String str, String str2, Account account, boolean z10) {
        this.f17754e = null;
        this.f17750a = uri;
        this.f17751b = str;
        this.f17753d = str2;
        this.f17752c = account;
        this.f17755f = z10;
    }
}
