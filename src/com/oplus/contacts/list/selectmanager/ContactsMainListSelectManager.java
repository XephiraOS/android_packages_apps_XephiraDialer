package com.oplus.contacts.list.selectmanager;

import android.database.Cursor;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.customize.contacts.model.IdRecord;
import com.oplus.contacts.list.f;
import com.oplus.foundation.util.io.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.collections.p;
import kotlin.coroutines.c;
import kotlin.jvm.internal.i;
import m9.q;
import p7.AbstractC1460a;

/* compiled from: ContactsMainListSelectManager.kt */
/* loaded from: classes3.dex */
public final class ContactsMainListSelectManager extends AbstractC1460a<f> {

    /* renamed from: s, reason: collision with root package name */
    public static final a f28025s = new a(null);

    /* renamed from: k, reason: collision with root package name */
    public final Set<f> f28026k;

    /* renamed from: l, reason: collision with root package name */
    public final Set<f> f28027l;

    /* renamed from: m, reason: collision with root package name */
    public final com.oplus.foundation.util.io.a f28028m;

    /* renamed from: n, reason: collision with root package name */
    public final com.oplus.foundation.util.io.a f28029n;

    /* renamed from: o, reason: collision with root package name */
    public final com.oplus.foundation.util.io.a f28030o;

    /* renamed from: p, reason: collision with root package name */
    public final com.oplus.foundation.util.io.a f28031p;

    /* renamed from: q, reason: collision with root package name */
    public final com.oplus.foundation.util.io.a f28032q;

    /* renamed from: r, reason: collision with root package name */
    public final com.oplus.foundation.util.io.a f28033r;

    /* compiled from: ContactsMainListSelectManager.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContactsMainListSelectManager() {
        super(null, 1, 0 == true ? 1 : 0);
        this.f28026k = Collections.synchronizedSet(new LinkedHashSet());
        this.f28027l = Collections.synchronizedSet(new LinkedHashSet());
        this.f28028m = new com.oplus.foundation.util.io.a(BreenoCallContract.BaseColumns._ID, -1);
        this.f28029n = new com.oplus.foundation.util.io.a("photo_id", -1);
        this.f28030o = new com.oplus.foundation.util.io.a("lookup", -1);
        this.f28031p = new com.oplus.foundation.util.io.a("starred", -1);
        this.f28032q = new com.oplus.foundation.util.io.a("account_type", -1);
        this.f28033r = new com.oplus.foundation.util.io.a("account_name", -1);
    }

    @Override // p7.C1462c
    public void d(boolean z10) {
        this.f28026k.clear();
        this.f28027l.clear();
        super.d(z10);
    }

    @Override // p7.C1462c
    public void f() {
        this.f28027l.clear();
        this.f28026k.clear();
        super.f();
    }

    public boolean j() {
        int size = this.f28027l.size();
        if (size > 0 && size == c().size()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.oplus.contacts.list.f k(android.database.Cursor r31) {
        /*
            Method dump skipped, instructions count: 972
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.contacts.list.selectmanager.ContactsMainListSelectManager.k(android.database.Cursor):com.oplus.contacts.list.f");
    }

    public List<IdRecord> l() {
        int p10;
        Set<f> c10 = c();
        p10 = p.p(c10, 10);
        ArrayList arrayList = new ArrayList(p10);
        for (f fVar : c10) {
            arrayList.add(new IdRecord(fVar.d(), -1L, true, fVar.p()));
        }
        return arrayList;
    }

    public boolean m() {
        Set<f> selectedOtherAccountContacts = this.f28026k;
        i.e(selectedOtherAccountContacts, "selectedOtherAccountContacts");
        return !selectedOtherAccountContacts.isEmpty();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object n(android.database.Cursor r9, kotlin.coroutines.c<? super m9.q> r10) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.contacts.list.selectmanager.ContactsMainListSelectManager.n(android.database.Cursor, kotlin.coroutines.c):java.lang.Object");
    }

    public Object o(c<? super q> cVar) {
        Object b10;
        if (!a()) {
            return q.f35511a;
        }
        Cursor f10 = h().getValue().f();
        if (b.b(f10)) {
            return q.f35511a;
        }
        c().clear();
        this.f28026k.clear();
        this.f28027l.clear();
        if (f10 != null) {
            try {
                Result.a aVar = Result.f34166a;
                int position = f10.getPosition();
                f10.moveToPosition(-1);
                while (!f10.isClosed() && f10.moveToNext()) {
                    f k10 = k(f10);
                    if (!b().contains(k10)) {
                        if (!c().contains(k10)) {
                            c().add(k10);
                        }
                        if (k10.o() && !this.f28026k.contains(k10)) {
                            this.f28026k.add(k10);
                        }
                        if (k10.p() && !this.f28027l.contains(k10)) {
                            this.f28027l.add(k10);
                        }
                    }
                }
                if (!f10.isClosed()) {
                    f10.moveToPosition(position);
                }
                b10 = Result.b(q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("ContactsMainListSelectManager", "processSelectItemsWhenMarkAll it = " + d10);
            }
            Result.a(b10);
        }
        return q.f35511a;
    }

    public void p(f itemData) {
        i.f(itemData, "itemData");
        if (a()) {
            if (b().contains(itemData)) {
                b().remove(itemData);
            } else {
                b().add(itemData);
            }
        } else {
            if (c().contains(itemData)) {
                c().remove(itemData);
            } else {
                c().add(itemData);
            }
            if (this.f28026k.contains(itemData)) {
                this.f28026k.remove(itemData);
            } else if (itemData.o()) {
                this.f28026k.add(itemData);
            }
            if (this.f28027l.contains(itemData)) {
                this.f28027l.remove(itemData);
            } else if (itemData.p()) {
                this.f28027l.add(itemData);
            }
        }
        e();
    }
}
