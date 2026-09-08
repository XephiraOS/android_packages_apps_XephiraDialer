package com.oplus.blacklistapp.callintercept.policy;

import android.content.Context;
import com.oplus.blacklistapp.callintercept.policy.f;
import com.oplus.utils.C0846g;
import v6.C1627a;

/* compiled from: YellowPageQuery.java */
/* loaded from: classes3.dex */
public abstract class g {
    public abstract void a(f fVar, f.a aVar);

    public abstract void b();

    public abstract boolean c(f fVar);

    public abstract boolean d(Context context, String str, int i10, int i11);

    public final void e(Context context, String str, String str2, int i10, f.a aVar, int i11) {
        C1627a.m("YellowPageQuery", " startQueryInfo number = " + C0846g.f(str) + " type = " + i10);
        f fVar = new f();
        fVar.f26718a = str;
        fVar.f26719b = str2;
        fVar.f26727j = i11;
        d(context, str, i10, i11);
        int i12 = 3;
        if (c(fVar)) {
            if (C1627a.f37411c) {
                C1627a.c("YellowPageQuery", "Have local data  info = " + fVar);
            }
            if (fVar.f26725h == null) {
                i12 = 2;
            }
            fVar.f26726i = i12;
            aVar.a(fVar);
        } else if (l7.b.d()) {
            a(fVar, aVar);
        } else {
            if (C1627a.f37411c) {
                C1627a.c("YellowPageQuery", "region is exp");
            }
            fVar.f26726i = 3;
            aVar.a(fVar);
        }
        b();
    }
}
