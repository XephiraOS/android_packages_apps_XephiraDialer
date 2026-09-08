package com.customize.contacts.importcontact;

import android.content.Context;
import com.android.contacts.model.Account;

/* compiled from: ContactImportRunnable.java */
/* loaded from: classes3.dex */
public abstract class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public final Account f21409a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f21410b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f21411c;

    /* renamed from: f, reason: collision with root package name */
    public String f21414f;

    /* renamed from: h, reason: collision with root package name */
    public a f21416h;

    /* renamed from: d, reason: collision with root package name */
    public boolean f21412d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f21413e = 60;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f21415g = false;

    public c(Context context, String str, Account account) {
        this.f21411c = M3.c.t(account);
        this.f21414f = str;
        this.f21409a = account;
        this.f21410b = context;
    }

    @Override // com.customize.contacts.importcontact.p
    public void a(String str, int i10) {
        a aVar = this.f21416h;
        if (aVar != null) {
            aVar.a(str, i10);
        }
    }

    @Override // com.customize.contacts.importcontact.a
    public void b(int i10) {
        a aVar = this.f21416h;
        if (aVar != null) {
            aVar.b(i10);
        }
    }

    @Override // com.customize.contacts.importcontact.p
    public void c(int i10) {
        a aVar = this.f21416h;
        if (aVar != null) {
            aVar.c(i10);
        }
    }

    public abstract void d();

    public boolean e() {
        return this.f21412d;
    }

    public abstract int f();

    public void g(boolean z10) {
        int i10;
        this.f21412d = z10;
        if (z10) {
            i10 = 20;
        } else {
            i10 = 60;
        }
        this.f21413e = i10;
    }

    public void h(a aVar) {
        this.f21416h = aVar;
    }
}
