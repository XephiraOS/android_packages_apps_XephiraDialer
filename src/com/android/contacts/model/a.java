package com.android.contacts.model;

import android.content.Context;
import com.android.contacts.model.AccountType;
import com.oplus.dialer.R;

/* compiled from: AutoSyncSimAccountType.java */
/* loaded from: classes.dex */
public class a extends b {
    public a(Context context, String str) {
        this.f16944a = "com.android.oplus.sim";
        this.f16945b = null;
        this.f16948e = R.string.account_phone_tablet;
        this.f16949f = N0.g.f1905e;
        this.f16946c = str;
        this.f16947d = str;
        try {
            J(context);
            y(context);
            C(context);
            u(context);
            E(context);
            this.f16950g = true;
        } catch (AccountType.DefinitionException e10) {
            H7.b.c("AutoSyncSimAccountType", "Problem building account type e = " + e10);
        }
        if (H7.a.b()) {
            H7.b.b("AutoSyncSimAccountType", "SimAccountType");
        }
    }

    @Override // com.android.contacts.model.AccountType
    public boolean b() {
        return true;
    }

    public a(Context context) {
        this(context, null);
    }
}
