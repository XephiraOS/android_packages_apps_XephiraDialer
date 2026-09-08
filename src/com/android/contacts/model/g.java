package com.android.contacts.model;

import android.content.ContentValues;
import android.content.Context;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.b;
import com.customize.contacts.FeatureOption;
import com.google.common.collect.n;
import com.oplus.dialer.R;
import java.util.ArrayList;

/* compiled from: FallbackAccountType.java */
/* loaded from: classes.dex */
public class g extends b {
    public g(Context context, String str) {
        this.f16944a = null;
        this.f16945b = null;
        this.f16948e = R.string.account_phone_tablet;
        this.f16949f = N0.g.f1905e;
        this.f16946c = str;
        this.f16947d = str;
        try {
            if (FeatureOption.o()) {
                F(context);
                x(context);
                L(context);
            }
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
            H7.b.c("FallbackAccountType", "Problem building account type" + e10);
        }
    }

    @Override // com.android.contacts.model.b
    public c A(Context context) {
        c A10 = super.A(context);
        A10.f17016o = 20;
        return A10;
    }

    @Override // com.android.contacts.model.b
    public c J(Context context) {
        c a10 = a(new c("vnd.android.cursor.item/name", R.string.nameLabelsGroup, -1, true, R.layout.structured_name_editor_view, R.string.oplus_add_nameLabelsGroup));
        a10.f17011j = new b.v(R.string.nameLabelsGroup);
        a10.f17013l = new b.v("data1");
        a10.f17016o = 1;
        ArrayList f10 = n.f();
        a10.f17018q = f10;
        f10.add(new AccountType.b("data4", R.string.name_prefix, 8289).a(true));
        a10.f17018q.add(new AccountType.b("data3", R.string.name_family, 8289).a(true));
        a10.f17018q.add(new AccountType.b("data5", R.string.name_middle, 8289).a(true));
        a10.f17018q.add(new AccountType.b("data2", R.string.name_given, 8289).a(true));
        a10.f17018q.add(new AccountType.b("data6", R.string.name_suffix, 8289).a(true));
        a10.f17018q.add(new AccountType.b("data9", R.string.name_phonetic_family, 193));
        a10.f17018q.add(new AccountType.b("data8", R.string.name_phonetic_middle, 193));
        a10.f17018q.add(new AccountType.b("data7", R.string.name_phonetic_given, 193));
        return a10;
    }

    public c a0(Context context) {
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

    @Override // com.android.contacts.model.AccountType
    public boolean b() {
        return true;
    }

    @Override // com.android.contacts.model.b
    public c v(Context context) {
        c a10 = a(new c("vnd.android.cursor.item/group_membership", R.string.groupsLabel, 20, true, -1, R.string.oplus_add_groupsLabel));
        a10.f17016o = 1;
        ArrayList f10 = n.f();
        a10.f17018q = f10;
        f10.add(new AccountType.b("data1", -1, -1));
        return a10;
    }

    @Override // com.android.contacts.model.b
    public c w(Context context) {
        c a10 = a(new c("vnd.android.cursor.item/im", R.string.imLabelsGroup, 32, true, R.layout.text_fields_editor_view, R.string.oplus_add_imLabelsGroup));
        a10.f17011j = new b.g();
        a10.f17013l = new b.v("data1");
        ContentValues contentValues = new ContentValues();
        a10.f17019r = contentValues;
        contentValues.put("data2", (Integer) 3);
        a10.f17015n = "data5";
        a10.f17017p = n.f();
        if (H7.a.b()) {
            H7.b.b("FallbackAccountType", "FeatureOption.isCNVersion() = " + FeatureOption.i());
        }
        if (FeatureOption.i()) {
            a10.f17017p.add(b.Q(4));
            a10.f17017p.add(b.Q(15));
            a10.f17017p.add(b.Q(-1).b(true).a("data6"));
        } else {
            a10.f17017p.add(b.Q(4));
            a10.f17017p.add(b.Q(5));
            a10.f17017p.add(b.Q(3));
            a10.f17017p.add(b.Q(1));
            a10.f17017p.add(b.Q(2));
            a10.f17017p.add(b.Q(0));
            a10.f17017p.add(b.Q(6));
            a10.f17017p.add(b.Q(7));
            a10.f17017p.add(b.Q(-1).b(true).a("data6"));
        }
        ArrayList f10 = n.f();
        a10.f17018q = f10;
        f10.add(new AccountType.b("data1", R.string.imLabelsGroup, 33));
        return a10;
    }

    public g(Context context) {
        this(context, null);
    }
}
