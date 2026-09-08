package com.android.contacts.framework.vcard;

import android.content.ContentResolver;
import com.android.contacts.model.Account;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: VCardEntryConstructor.java */
/* loaded from: classes.dex */
public class i implements l {

    /* renamed from: a, reason: collision with root package name */
    public final List<VCardEntry> f16523a;

    /* renamed from: b, reason: collision with root package name */
    public VCardEntry f16524b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16525c;

    /* renamed from: d, reason: collision with root package name */
    public final Account f16526d;

    /* renamed from: e, reason: collision with root package name */
    public ContentResolver f16527e;

    /* renamed from: f, reason: collision with root package name */
    public int f16528f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f16529g;

    /* renamed from: h, reason: collision with root package name */
    public final List<k> f16530h;

    public i() {
        this(-1073741824, null, null);
    }

    @Override // com.android.contacts.framework.vcard.l
    public void a() {
        this.f16524b.E();
        if (this.f16529g) {
            int i10 = this.f16528f + 1;
            this.f16528f = i10;
            if (i10 != 1) {
                Iterator<k> it = this.f16530h.iterator();
                while (it.hasNext()) {
                    it.next().onEntryCreated(this.f16524b);
                }
            }
        } else {
            Iterator<k> it2 = this.f16530h.iterator();
            while (it2.hasNext()) {
                it2.next().onEntryCreated(this.f16524b);
            }
        }
        int size = this.f16523a.size();
        if (size > 1) {
            VCardEntry vCardEntry = this.f16523a.get(size - 2);
            vCardEntry.d(this.f16524b);
            this.f16524b = vCardEntry;
        } else {
            this.f16524b = null;
        }
        this.f16523a.remove(size - 1);
    }

    @Override // com.android.contacts.framework.vcard.l
    public void b() {
        Iterator<k> it = this.f16530h.iterator();
        while (it.hasNext()) {
            it.next().onStart();
        }
    }

    @Override // com.android.contacts.framework.vcard.l
    public void c() {
        Iterator<k> it = this.f16530h.iterator();
        while (it.hasNext()) {
            it.next().onEnd();
        }
    }

    @Override // com.android.contacts.framework.vcard.l
    public void d(u uVar) {
        this.f16524b.x(uVar);
    }

    @Override // com.android.contacts.framework.vcard.l
    public void e() {
        VCardEntry vCardEntry = new VCardEntry(this.f16525c, this.f16526d);
        this.f16524b = vCardEntry;
        vCardEntry.o0(this.f16527e);
        this.f16523a.add(this.f16524b);
    }

    public void f(k kVar) {
        this.f16530h.add(kVar);
    }

    public void g() {
        this.f16524b = null;
        this.f16523a.clear();
    }

    public void h(ContentResolver contentResolver) {
        this.f16527e = contentResolver;
    }

    public i(int i10, Account account) {
        this(i10, account, null);
    }

    public i(int i10, Account account, String str, boolean z10) {
        this(i10, account, str);
        this.f16529g = z10;
    }

    @Deprecated
    public i(int i10, Account account, String str) {
        this.f16523a = new ArrayList();
        this.f16528f = 0;
        this.f16529g = false;
        this.f16530h = new ArrayList();
        this.f16525c = i10;
        this.f16526d = account;
    }
}
