package com.customize.contacts.importcontact;

import android.content.Context;
import com.oplus.dialer.R;

/* compiled from: ImportContactsCounter.java */
/* loaded from: classes3.dex */
public class g implements n {

    /* renamed from: f, reason: collision with root package name */
    public final Context f21432f;

    /* renamed from: g, reason: collision with root package name */
    public int f21433g;

    /* renamed from: h, reason: collision with root package name */
    public int f21434h;

    /* renamed from: i, reason: collision with root package name */
    public int f21435i;

    /* renamed from: j, reason: collision with root package name */
    public String f21436j;

    /* renamed from: k, reason: collision with root package name */
    public String f21437k;

    /* renamed from: l, reason: collision with root package name */
    public int f21438l;

    /* renamed from: m, reason: collision with root package name */
    public int f21439m = 666;

    public g(Context context) {
        this.f21432f = context;
        n();
    }

    @Override // com.customize.contacts.importcontact.n
    public int a() {
        return this.f21435i;
    }

    @Override // com.customize.contacts.importcontact.n
    public int b() {
        return this.f21434h;
    }

    @Override // com.customize.contacts.importcontact.n
    public int c() {
        return this.f21439m;
    }

    @Override // com.customize.contacts.importcontact.n
    public int d() {
        return this.f21433g;
    }

    public void e() {
        this.f21439m = 777;
    }

    public int f() {
        return this.f21438l;
    }

    public void g() {
        this.f21439m = 666;
    }

    public void h() {
        this.f21439m = 666;
    }

    public void i(int i10) {
        this.f21438l = i10;
    }

    public void j(int i10) {
        this.f21435i = i10;
        this.f21439m = 888;
    }

    public void k(int i10) {
        this.f21433g += i10;
    }

    public void l(String str, int i10) {
        this.f21439m = 888;
        this.f21434h += i10;
        this.f21437k = str;
    }

    public void m() {
        n();
    }

    public void n() {
        this.f21434h = 0;
        this.f21435i = 0;
        this.f21433g = 0;
        this.f21438l = 888;
        this.f21436j = this.f21432f.getString(R.string.oplus_title_import_phonebook);
        this.f21437k = this.f21432f.getString(R.string.in_processing);
    }

    public void o(int i10) {
        this.f21439m = i10;
    }
}
