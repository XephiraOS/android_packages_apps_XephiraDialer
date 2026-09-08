package com.android.contacts.model;

import android.content.ContentValues;
import android.content.Context;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.b;
import com.customize.contacts.util.K;
import com.google.common.collect.n;
import com.oplus.dialer.R;
import java.util.ArrayList;

/* compiled from: ExchangeAccountType.java */
/* loaded from: classes.dex */
public class e extends b {
    public e(Context context, String str, String str2) {
        this.f16944a = str2;
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
            a0(context);
            N(context);
            v(context);
            G(context);
            I(context);
            H(context);
            M(context);
            this.f16950g = true;
        } catch (AccountType.DefinitionException e10) {
            H7.b.c("ExchangeAccountType", "Problem building account type" + e10);
        }
    }

    public static boolean b0(String str) {
        if (!"com.android.exchange".equals(str) && !"com.google.android.exchange".equals(str) && !"com.google.android.gm.exchange".equals(str)) {
            return false;
        }
        return true;
    }

    @Override // com.android.contacts.model.b
    public c A(Context context) {
        c A10 = super.A(context);
        ArrayList f10 = n.f();
        A10.f17018q = f10;
        f10.add(new AccountType.b("data1", R.string.label_notes, 147457));
        return A10;
    }

    @Override // com.android.contacts.model.b
    public c B(Context context) {
        c B10 = super.B(context);
        B10.f17016o = 1;
        ArrayList f10 = n.f();
        B10.f17018q = f10;
        f10.add(new AccountType.b("data1", R.string.ghostData_company, 8193));
        B10.f17018q.add(new AccountType.b("data4", R.string.ghostData_title, 8193));
        return B10;
    }

    @Override // com.android.contacts.model.b
    public c C(Context context) {
        c C10 = super.C(context);
        C10.f17015n = "data2";
        ArrayList f10 = n.f();
        C10.f17017p = f10;
        f10.add(b.T(2).c(2));
        C10.f17017p.add(b.T(3).c(2));
        C10.f17017p.add(b.T(1).c(2));
        C10.f17017p.add(b.T(12));
        C10.f17017p.add(b.T(4).b(true).c(1));
        C10.f17017p.add(b.T(5).b(true).c(1));
        C10.f17017p.add(b.T(6).b(true).c(1));
        C10.f17017p.add(b.T(7));
        C10.f17017p.add(b.T(0).b(true).a("data3"));
        ArrayList f11 = n.f();
        C10.f17018q = f11;
        f11.add(new AccountType.b("data1", R.string.phoneLabelsGroup, 3));
        return C10;
    }

    @Override // com.android.contacts.model.b
    public c D(Context context) {
        c a10 = a(new c("#phoneticName", R.string.name_phonetic, -1, true, R.layout.phonetic_name_editor_view, R.string.oplus_add_name_phonetic));
        a10.f17011j = new b.v(R.string.nameLabelsGroup);
        a10.f17013l = new b.v("data1");
        a10.f17016o = 1;
        ArrayList f10 = n.f();
        a10.f17018q = f10;
        f10.add(new AccountType.b("data9", R.string.name_phonetic_family, 193));
        a10.f17018q.add(new AccountType.b("data7", R.string.name_phonetic_given, 193));
        return a10;
    }

    @Override // com.android.contacts.model.b
    public c E(Context context) {
        c E10 = super.E(context);
        E10.f17016o = 1;
        ArrayList f10 = n.f();
        E10.f17018q = f10;
        f10.add(new AccountType.b("data15", -1, -1));
        return E10;
    }

    @Override // com.android.contacts.model.b
    public c J(Context context) {
        c a10 = a(new c("vnd.android.cursor.item/name", R.string.nameLabelsGroup, -1, true, R.layout.structured_name_editor_view, R.string.oplus_add_nameLabelsGroup));
        a10.f17011j = new b.v(R.string.nameLabelsGroup);
        a10.f17013l = new b.v("data1");
        a10.f17016o = 1;
        ArrayList f10 = n.f();
        a10.f17018q = f10;
        f10.add(new AccountType.b("data4", R.string.name_prefix, 8289).b(true));
        a10.f17018q.add(new AccountType.b("data3", R.string.name_family, 8289));
        a10.f17018q.add(new AccountType.b("data5", R.string.name_middle, 8289));
        a10.f17018q.add(new AccountType.b("data2", R.string.name_given, 8289));
        a10.f17018q.add(new AccountType.b("data6", R.string.name_suffix, 8289));
        a10.f17018q.add(new AccountType.b("data9", R.string.name_phonetic_family, 193));
        a10.f17018q.add(new AccountType.b("data7", R.string.name_phonetic_given, 193));
        return a10;
    }

    @Override // com.android.contacts.model.b
    public c K(Context context) {
        c K10 = super.K(context);
        boolean c10 = K.c();
        K10.f17015n = "data2";
        ArrayList f10 = n.f();
        K10.f17017p = f10;
        f10.add(b.U(2));
        K10.f17017p.add(b.U(1));
        K10.f17017p.add(b.U(3));
        K10.f17017p.add(b.U(0).b(true).a("data3"));
        ArrayList f11 = n.f();
        K10.f17018q = f11;
        if (c10) {
            f11.add(new AccountType.b("data10", R.string.postal_country, 139377).b(true));
            K10.f17018q.add(new AccountType.b("data9", R.string.postal_postcode, 139377));
            K10.f17018q.add(new AccountType.b("data8", R.string.postal_region, 139377));
            K10.f17018q.add(new AccountType.b("data7", R.string.postal_city, 139377));
            K10.f17018q.add(new AccountType.b("data4", R.string.postal_street, 139377));
        } else {
            f11.add(new AccountType.b("data4", R.string.postal_street, 139377));
            K10.f17018q.add(new AccountType.b("data7", R.string.postal_city, 139377));
            K10.f17018q.add(new AccountType.b("data8", R.string.postal_region, 139377));
            K10.f17018q.add(new AccountType.b("data9", R.string.postal_postcode, 139377));
            K10.f17018q.add(new AccountType.b("data10", R.string.postal_country, 139377).b(true));
        }
        return K10;
    }

    @Override // com.android.contacts.model.b
    public c N(Context context) {
        c N10 = super.N(context);
        ArrayList f10 = n.f();
        N10.f17018q = f10;
        f10.add(new AccountType.b("data1", R.string.websiteLabelsGroup, 17));
        return N10;
    }

    public c a0(Context context) {
        c a10 = a(new c("vnd.android.cursor.item/contact_event", R.string.eventLabelsGroup, 17, true, R.layout.event_field_editor_view, R.string.oplus_add_eventLabelsGroup));
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

    @Override // com.android.contacts.model.b, com.android.contacts.model.AccountType
    public boolean p() {
        return true;
    }

    @Override // com.android.contacts.model.b
    public c u(Context context) {
        c u10 = super.u(context);
        ArrayList f10 = n.f();
        u10.f17018q = f10;
        f10.add(new AccountType.b("data1", R.string.emailLabelsGroup, 33));
        return u10;
    }

    @Override // com.android.contacts.model.b
    public c w(Context context) {
        c w10 = super.w(context);
        ContentValues contentValues = new ContentValues();
        w10.f17019r = contentValues;
        contentValues.put("data2", (Integer) 3);
        ArrayList f10 = n.f();
        w10.f17018q = f10;
        f10.add(new AccountType.b("data1", R.string.imLabelsGroup, 33));
        return w10;
    }

    @Override // com.android.contacts.model.b
    public c z(Context context) {
        c z10 = super.z(context);
        z10.f17016o = 1;
        ArrayList f10 = n.f();
        z10.f17018q = f10;
        f10.add(new AccountType.b("data1", R.string.nicknameLabelsGroup, 8289));
        return z10;
    }
}
