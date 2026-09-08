package com.android.contacts.model;

import android.content.Context;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.b;
import com.google.common.collect.n;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GoogleAccountType.java */
/* loaded from: classes.dex */
public class h extends b {

    /* renamed from: k, reason: collision with root package name */
    public static final List<String> f17043k = n.i("com.google.android.apps.plus");

    public h(Context context, String str) {
        this.f16944a = "com.google";
        this.f16946c = null;
        this.f16947d = str;
        try {
            J(context);
            y(context);
            D(context);
            z(context);
            C(context);
            u(context);
            K(context);
            w(context);
            B(context);
            E(context);
            A(context);
            N(context);
            I(context);
            v(context);
            G(context);
            a0(context);
            H(context);
            M(context);
            this.f16950g = true;
        } catch (AccountType.DefinitionException e10) {
            H7.b.c("GoogleAccountType", "Problem building account type" + e10);
        }
    }

    private c a0(Context context) {
        c a10 = a(new c("vnd.android.cursor.item/contact_event", R.string.eventLabelsGroup, 35, true, R.layout.event_field_editor_view, R.string.oplus_add_eventLabelsGroup));
        a10.f17011j = new b.d();
        a10.f17013l = new b.v("data1");
        a10.f17015n = "data2";
        ArrayList f10 = n.f();
        a10.f17017p = f10;
        f10.add(b.P(3, true).c(1));
        a10.f17017p.add(b.R(1000, true).c(1));
        a10.f17017p.add(b.P(1, true));
        a10.f17017p.add(b.P(2, true));
        a10.f17017p.add(b.P(0, true).b(true).a("data3"));
        a10.f17020x = F7.b.f1004b;
        a10.f17021y = F7.b.f1005c;
        ArrayList f11 = n.f();
        a10.f17018q = f11;
        f11.add(new AccountType.b("data1", R.string.eventLabelsGroup, 1));
        return a10;
    }

    @Override // com.android.contacts.model.b
    public c C(Context context) {
        c C10 = super.C(context);
        C10.f17015n = "data2";
        ArrayList f10 = n.f();
        C10.f17017p = f10;
        f10.add(b.T(2));
        C10.f17017p.add(b.T(3));
        C10.f17017p.add(b.T(1));
        C10.f17017p.add(b.T(12));
        C10.f17017p.add(b.T(4).b(true));
        C10.f17017p.add(b.T(5).b(true));
        C10.f17017p.add(b.T(6).b(true));
        C10.f17017p.add(b.T(7));
        C10.f17017p.add(b.T(0).b(true).a("data3"));
        ArrayList f11 = n.f();
        C10.f17018q = f11;
        f11.add(new AccountType.b("data1", R.string.phoneLabelsGroup, 3));
        return C10;
    }

    @Override // com.android.contacts.model.AccountType
    public boolean b() {
        return true;
    }

    @Override // com.android.contacts.model.AccountType
    public List<String> h() {
        return f17043k;
    }

    @Override // com.android.contacts.model.b, com.android.contacts.model.AccountType
    public boolean p() {
        return true;
    }

    @Override // com.android.contacts.model.b
    public c u(Context context) {
        c u10 = super.u(context);
        u10.f17015n = "data2";
        ArrayList f10 = n.f();
        u10.f17017p = f10;
        f10.add(b.O(1));
        u10.f17017p.add(b.O(2));
        u10.f17017p.add(b.O(3));
        u10.f17017p.add(b.O(0).b(true).a("data3"));
        ArrayList f11 = n.f();
        u10.f17018q = f11;
        f11.add(new AccountType.b("data1", R.string.emailLabelsGroup, 33));
        return u10;
    }
}
