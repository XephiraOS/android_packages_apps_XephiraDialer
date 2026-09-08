package com.customize.contacts.util;

import android.app.Activity;
import android.widget.CheckBox;
import com.android.contacts.PhoneCallDetails;
import com.customize.contacts.activities.MoreCallLogActivity;
import com.oplus.dialer.R;
import java.util.HashSet;

/* compiled from: MoreCallLogActionModeUtils.java */
/* loaded from: classes3.dex */
public class O {

    /* renamed from: a, reason: collision with root package name */
    public MoreCallLogActivity f21923a;

    /* renamed from: b, reason: collision with root package name */
    public E3.n f21924b;

    /* renamed from: c, reason: collision with root package name */
    public Z3.h f21925c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f21926d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f21927e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f21928f = false;

    /* renamed from: g, reason: collision with root package name */
    public final HashSet<PhoneCallDetails> f21929g = new HashSet<>();

    /* renamed from: h, reason: collision with root package name */
    public String f21930h = null;

    public O(Activity activity, E3.n nVar, Z3.h hVar) {
        this.f21924b = null;
        this.f21923a = (MoreCallLogActivity) activity;
        this.f21924b = nVar;
        this.f21925c = hVar;
    }

    public int a() {
        return this.f21927e;
    }

    public HashSet<PhoneCallDetails> b() {
        return this.f21929g;
    }

    public String c() {
        int a10 = a();
        if (this.f21930h == null) {
            this.f21930h = this.f21923a.getString(R.string.select_items);
        }
        if (a10 == 0) {
            return this.f21923a.getString(R.string.select_item);
        }
        return String.format(this.f21930h, Integer.valueOf(U7.a.b(a10)));
    }

    public final int d() {
        if (this.f21924b.m() == null) {
            return 0;
        }
        return this.f21924b.getItemCount();
    }

    public boolean e(PhoneCallDetails phoneCallDetails) {
        return this.f21929g.contains(phoneCallDetails);
    }

    public boolean f() {
        return this.f21926d;
    }

    public boolean g() {
        return this.f21928f;
    }

    public void h() {
        if (!this.f21928f) {
            m(true);
            this.f21928f = true;
        } else {
            m(false);
            this.f21928f = false;
        }
    }

    public final void i() {
        p();
        this.f21924b.notifyDataSetChanged();
    }

    public void j(CheckBox checkBox, boolean z10) {
        if (f() && checkBox != null && checkBox.getTag() != null) {
            checkBox.setChecked(!checkBox.isChecked());
            n((PhoneCallDetails) checkBox.getTag(), !e(r1));
        }
    }

    public void k() {
        h();
    }

    public void l() {
        m(false);
        this.f21927e = 0;
        this.f21928f = false;
        this.f21926d = false;
    }

    public void m(boolean z10) {
        int itemCount;
        this.f21929g.clear();
        int i10 = 0;
        if (this.f21924b.m() == null) {
            itemCount = 0;
        } else {
            itemCount = this.f21924b.getItemCount();
        }
        if (itemCount == 0) {
            return;
        }
        if (z10) {
            for (int i11 = 0; i11 < this.f21924b.getItemCount(); i11++) {
                this.f21929g.add((PhoneCallDetails) this.f21924b.getItem(i11));
            }
        }
        if (z10) {
            i10 = itemCount;
        }
        this.f21927e = i10;
        i();
    }

    public final void n(PhoneCallDetails phoneCallDetails, boolean z10) {
        if (z10) {
            if (!this.f21929g.contains(phoneCallDetails)) {
                this.f21929g.add(phoneCallDetails);
                this.f21927e++;
            }
        } else if (this.f21929g.contains(phoneCallDetails)) {
            this.f21929g.remove(phoneCallDetails);
            this.f21927e--;
        }
        p();
    }

    public void o(boolean z10) {
        this.f21926d = z10;
    }

    public void p() {
        boolean z10;
        boolean z11 = false;
        if (a() == d()) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f21928f = z10;
        if (this.f21926d) {
            MoreCallLogActivity moreCallLogActivity = this.f21923a;
            if (a() != 0) {
                z11 = true;
            }
            moreCallLogActivity.f2(true, z11);
            this.f21925c.d();
        }
    }
}
