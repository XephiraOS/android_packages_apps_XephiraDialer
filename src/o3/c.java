package O3;

import android.content.Context;
import com.android.contacts.model.Account;
import com.customize.contacts.model.IdRecord;
import com.customize.contacts.util.b0;
import com.customize.contacts.util.c0;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* compiled from: ContactsProcessThreadsHelper.java */
/* loaded from: classes3.dex */
public class c extends g {

    /* renamed from: o, reason: collision with root package name */
    public final Account f2682o;

    /* renamed from: p, reason: collision with root package name */
    public final Account f2683p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f2684q;

    public c(Context context, Account account, Account account2, boolean z10) {
        super(context);
        this.f2682o = account;
        this.f2683p = account2;
        this.f2684q = z10;
    }

    @Override // O3.g
    public void l() {
        r(this.f2682o, this.f2683p);
    }

    public final void r(Account account, Account account2) {
        ArrayList<IdRecord> q10 = c0.q(this.f2696a, account);
        if (q10 != null && !q10.isEmpty()) {
            int size = q10.size();
            q(size);
            boolean z10 = true;
            this.f2702g.I(1, null, null);
            int[] iArr = new int[2];
            boolean P02 = b0.P0(this.f2696a, account2.f16941a);
            if (M3.c.t(account2)) {
                try {
                    this.f2703h.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Exception e10) {
                    H7.b.c("ContactsProcessThread", "Exception in copyContactsFromSim when await the query sim status thread complete " + e10);
                }
                int i10 = 0;
                while (i10 != size && !isInterrupted() && !this.f2700e) {
                    m(i10);
                    int[] iArr2 = iArr;
                    boolean z11 = z10;
                    if (c0.a(this.f2696a, q10.get(i10).b(), account, account2, this.f2684q, iArr, P02)) {
                        a(iArr2[z11 ? 1 : 0]);
                        this.f2702g.I(2, null, null);
                        iArr2[z11 ? 1 : 0] = 0;
                        i10++;
                        iArr = iArr2;
                        z10 = z11 ? 1 : 0;
                    } else {
                        a(iArr2[z11 ? 1 : 0]);
                        if (c0.k() == 0) {
                            n(4);
                        } else if (c0.k() == 1) {
                            n(14);
                        } else {
                            n(8);
                        }
                        this.f2702g.I(4, null, null);
                        iArr2[z11 ? 1 : 0] = 0;
                        return;
                    }
                }
                return;
            }
            com.customize.contacts.model.a.f();
            int i11 = 0;
            while (true) {
                if (i11 != size && !isInterrupted()) {
                    if (this.f2700e) {
                        return;
                    }
                    m(i11);
                    if (com.customize.contacts.model.a.h(this.f2696a, q10.get(i11).b(), this.f2682o, this.f2683p, this.f2684q, iArr)) {
                        a(iArr[1]);
                        this.f2702g.I(2, null, null);
                        iArr[1] = 0;
                        i11++;
                    } else {
                        n(9);
                        this.f2702g.I(4, null, null);
                        break;
                    }
                } else {
                    break;
                }
            }
            com.customize.contacts.model.a.e(this.f2696a);
            return;
        }
        n(2);
        this.f2702g.I(4, null, null);
    }
}
