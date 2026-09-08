package com.customize.contacts.util;

import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import com.customize.contacts.SimContactsOrderHelper;
import com.customize.contacts.activities.ContactsTabActivity;
import com.customize.contacts.activities.SimContactsListActivity;
import com.customize.contacts.model.IdRecord;
import java.util.HashMap;

/* compiled from: ContactsActionModeHandler.java */
/* renamed from: com.customize.contacts.util.q, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0806q {

    /* renamed from: b, reason: collision with root package name */
    public b f22168b;

    /* renamed from: c, reason: collision with root package name */
    public AppCompatActivity f22169c;

    /* renamed from: d, reason: collision with root package name */
    public a f22170d;

    /* renamed from: f, reason: collision with root package name */
    public P3.c f22172f;

    /* renamed from: g, reason: collision with root package name */
    public P3.b f22173g;

    /* renamed from: j, reason: collision with root package name */
    public Z3.h f22176j;

    /* renamed from: a, reason: collision with root package name */
    public final String f22167a = "ContactsActionModeHandler";

    /* renamed from: e, reason: collision with root package name */
    public boolean f22171e = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f22174h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f22175i = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f22177k = false;

    /* compiled from: ContactsActionModeHandler.java */
    /* renamed from: com.customize.contacts.util.q$a */
    /* loaded from: classes3.dex */
    public interface a {
        void D(boolean z10);

        boolean m();
    }

    /* compiled from: ContactsActionModeHandler.java */
    /* renamed from: com.customize.contacts.util.q$b */
    /* loaded from: classes3.dex */
    public class b extends DataSetObserver {
        @Override // android.database.DataSetObserver
        public void onChanged() {
            C0806q.this.t();
            if (!C0806q.this.f22170d.m()) {
                C0806q.this.f22170d.D(true);
            }
        }

        public b() {
        }
    }

    public C0806q(AppCompatActivity appCompatActivity, a aVar, Z3.h hVar) {
        this.f22168b = null;
        this.f22172f = null;
        this.f22173g = null;
        this.f22169c = appCompatActivity;
        this.f22170d = aVar;
        P3.c cVar = new P3.c();
        this.f22172f = cVar;
        this.f22173g = new P3.b(cVar, this.f22169c);
        b bVar = new b();
        this.f22168b = bVar;
        this.f22172f.z(bVar);
        this.f22176j = hVar;
    }

    public void b() {
        boolean z10 = true;
        this.f22177k = true;
        Z3.h hVar = this.f22176j;
        if (hVar != null) {
            hVar.b();
            if (this.f22174h) {
                Z3.h hVar2 = this.f22176j;
                if (SimContactsOrderHelper.b().size() <= 0) {
                    z10 = false;
                }
                hVar2.f(z10);
            }
        }
    }

    public final int c() {
        return this.f22172f.g();
    }

    public final int d() {
        return this.f22172f.h();
    }

    public int e() {
        return this.f22172f.i();
    }

    public P3.c f() {
        return this.f22172f;
    }

    public int g() {
        return this.f22172f.l();
    }

    public void h(Cursor cursor) {
        this.f22172f.s(cursor);
    }

    public boolean i() {
        return this.f22177k;
    }

    public boolean j() {
        return this.f22171e;
    }

    public void k(CheckBox checkBox) {
        this.f22173g.a(checkBox);
    }

    public void l() {
        if (this.f22169c instanceof ContactsTabActivity) {
            boolean z10 = !this.f22171e;
            this.f22171e = z10;
            this.f22172f.w(z10);
        } else {
            this.f22172f.C(!this.f22171e);
        }
        AppCompatActivity appCompatActivity = this.f22169c;
        if (appCompatActivity instanceof SimContactsListActivity) {
            HashMap hashMap = new HashMap();
            hashMap.put("state", Boolean.valueOf(this.f22171e));
            com.android.contacts.framework.baseui.util.A.a(this.f22169c.getBaseContext(), 2000315, 200030146, hashMap, false);
        } else if (appCompatActivity instanceof ContactsTabActivity) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("state", Boolean.valueOf(this.f22171e));
            com.android.contacts.framework.baseui.util.A.a(this.f22169c.getBaseContext(), 2000321, 200030254, hashMap2, false);
        }
    }

    public void m(HashMap<Long, IdRecord> hashMap) {
        if (!hashMap.isEmpty() && this.f22172f != null) {
            if (H7.a.b()) {
                H7.b.b("ContactsActionModeHandler", "onRestoreInstanceState selectedContactRecords is not empty, and need to reset selectedContactRecords");
            }
            this.f22172f.L(hashMap);
        }
    }

    public void n(Bundle bundle) {
        HashMap<Long, IdRecord> j10;
        P3.c cVar = this.f22172f;
        if (cVar != null && (j10 = cVar.j()) != null && !j10.isEmpty()) {
            if (H7.a.b()) {
                H7.b.b("ContactsActionModeHandler", "onSaveInstanceState selectedContactRecords is not empty, and need to store it");
            }
            bundle.putSerializable("selected_contact_records", j10);
        }
    }

    public void o() {
        this.f22177k = false;
        if (!this.f22174h && !this.f22175i) {
            if (this.f22169c instanceof ContactsTabActivity) {
                this.f22172f.x();
            } else {
                this.f22172f.C(false);
            }
            this.f22171e = false;
        }
        Z3.h hVar = this.f22176j;
        if (hVar != null) {
            hVar.c();
        }
    }

    public void p(boolean z10) {
        this.f22174h = z10;
    }

    public void q(boolean z10) {
        this.f22171e = z10;
    }

    public void r(boolean z10) {
        this.f22175i = z10;
    }

    public void s(Cursor cursor, boolean z10) {
        this.f22172f.P(cursor, z10);
    }

    public final void t() {
        if (this.f22177k) {
            int e10 = e();
            int g10 = g();
            if ((c() == d() && d() != 0) || (e10 == g10 && g10 != 0)) {
                this.f22171e = true;
                this.f22172f.c();
            } else {
                this.f22171e = false;
            }
            this.f22176j.d();
        }
    }
}
