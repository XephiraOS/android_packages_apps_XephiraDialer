package com.customize.contacts.model;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.provider.ContactsContract;
import com.android.contacts.model.Account;
import com.android.contacts.model.EntityDelta;
import com.customize.contacts.model.GroupValueDelta;
import com.customize.contacts.util.C0811w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: GroupEntityDelta.java */
/* loaded from: classes3.dex */
public class d implements GroupValueDelta.a {

    /* renamed from: a, reason: collision with root package name */
    public EntityDelta.ValuesDelta f21739a = null;

    /* renamed from: b, reason: collision with root package name */
    public List<GroupValueDelta> f21740b = null;

    /* renamed from: c, reason: collision with root package name */
    public List<GroupValueDelta> f21741c = null;

    public static d d(Account account) {
        if (H7.a.b()) {
            H7.b.b("GroupEntityDelta", "fromAfter");
        }
        d dVar = new d();
        EntityDelta.ValuesDelta m10 = EntityDelta.ValuesDelta.m(new ContentValues(3));
        dVar.f21739a = m10;
        m10.e0("account_name", account.f16941a);
        dVar.f21739a.e0("account_type", account.f16942b);
        dVar.f21740b = new ArrayList();
        dVar.f21741c = new ArrayList();
        return dVar;
    }

    @Override // com.customize.contacts.model.GroupValueDelta.a
    public void a(GroupValueDelta groupValueDelta) {
        boolean K10 = this.f21739a.K();
        Iterator<GroupValueDelta> it = this.f21740b.iterator();
        while (it.hasNext()) {
            GroupValueDelta next = it.next();
            if (next.equals(groupValueDelta)) {
                if (!K10 && !this.f21741c.contains(next)) {
                    this.f21741c.add(next);
                }
                it.remove();
                return;
            }
        }
    }

    public void b(Context context, ArrayList<ContentProviderOperation> arrayList, long j10) {
        boolean K10 = this.f21739a.K();
        HashMap<Long, ArrayList<Long>> k10 = k(context, this.f21740b);
        for (GroupValueDelta groupValueDelta : this.f21740b) {
            List<ContentProviderOperation.Builder> v02 = groupValueDelta.v0(ContactsContract.Data.CONTENT_URI, k10.get(groupValueDelta.x0()));
            if (!C0811w.g(v02)) {
                for (ContentProviderOperation.Builder builder : v02) {
                    if (builder != null) {
                        builder.withValue("data1", Long.valueOf(j10));
                        l(arrayList, builder);
                    }
                }
            }
        }
        if (!K10) {
            k10.clear();
            HashMap<Long, ArrayList<Long>> k11 = k(context, this.f21741c);
            for (GroupValueDelta groupValueDelta2 : this.f21741c) {
                List<ContentProviderOperation.Builder> v03 = groupValueDelta2.v0(ContactsContract.Data.CONTENT_URI, k11.get(groupValueDelta2.x0()));
                if (!C0811w.g(v03)) {
                    Iterator<ContentProviderOperation.Builder> it = v03.iterator();
                    while (it.hasNext()) {
                        l(arrayList, it.next());
                    }
                }
            }
        }
    }

    public void c(ArrayList<ContentProviderOperation> arrayList) {
        l(arrayList, this.f21739a.i(ContactsContract.Groups.CONTENT_URI));
    }

    public final String e() {
        return this.f21739a.z("account_name");
    }

    public final String f() {
        return this.f21739a.z("account_type");
    }

    public List<GroupValueDelta> g() {
        return this.f21741c;
    }

    public EntityDelta.ValuesDelta h() {
        return this.f21739a;
    }

    public String i() {
        return this.f21739a.z("title");
    }

    public List<GroupValueDelta> j() {
        return this.f21740b;
    }

    public final HashMap<Long, ArrayList<Long>> k(Context context, List<GroupValueDelta> list) {
        int size = list.size();
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < size; i10++) {
            sb.append(list.get(i10).x0());
            sb.append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            return N3.b.p(context.getContentResolver(), sb.toString(), e(), f(), size);
        }
        return new HashMap<>();
    }

    public final void l(ArrayList<ContentProviderOperation> arrayList, ContentProviderOperation.Builder builder) {
        if (builder != null) {
            if (H7.a.b()) {
                H7.b.b("GroupEntityDelta", "possibleAdd()");
            }
            arrayList.add(builder.build());
        }
    }
}
