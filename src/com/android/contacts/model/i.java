package com.android.contacts.model;

import android.content.Context;
import com.android.contacts.model.AccountType;
import com.oplus.dialer.R;

/* compiled from: SimAccountType.java */
/* loaded from: classes.dex */
public class i extends b {
    public i(Context context, String str) {
        this.f16944a = "com.oplus.contacts.sim";
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
            H7.b.c("FallbackAccountType", "Problem building account type" + e10);
        }
        if (H7.a.b()) {
            H7.b.b("FallbackAccountType", "SimAccountType");
        }
    }

    @Override // com.android.contacts.model.AccountType
    public boolean b() {
        return true;
    }

    public i(Context context) {
        this(context, null);
    }
}
