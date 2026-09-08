package com.android.contacts.voicemail.impl.mail;

import java.util.ArrayList;

/* compiled from: Multipart.java */
/* loaded from: classes.dex */
public abstract class g implements a {

    /* renamed from: a, reason: collision with root package name */
    public h f18096a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<b> f18097b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public String f18098c;

    public void a(b bVar) {
        this.f18097b.add(bVar);
    }

    public b b(int i10) {
        return this.f18097b.get(i10);
    }

    public String c() {
        return this.f18098c;
    }

    public int d() {
        return this.f18097b.size();
    }

    public void e(h hVar) {
        this.f18096a = hVar;
    }
}
