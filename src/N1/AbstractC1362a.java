package n1;

import android.content.Context;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountWithDataSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: AccountTypeManager.java */
/* renamed from: n1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1362a {
    public static synchronized AbstractC1362a b(Context context) {
        b bVar;
        synchronized (AbstractC1362a.class) {
            bVar = new b(context);
        }
        return bVar;
    }

    public static AbstractC1362a h(Context context) {
        AbstractC1362a abstractC1362a;
        Context context2 = P7.a.f2962b;
        AbstractC1362a abstractC1362a2 = null;
        try {
            abstractC1362a = (AbstractC1362a) context2.getSystemService("contactAccountTypes");
        } catch (Throwable th) {
            th = th;
        }
        if (abstractC1362a == null) {
            try {
                abstractC1362a2 = b(context2);
                H7.b.c("AccountTypeManager", "No account type service in context: " + context2);
            } catch (Throwable th2) {
                th = th2;
                abstractC1362a2 = abstractC1362a;
                H7.b.c("AccountTypeManager", "th = " + th);
                return abstractC1362a2;
            }
            return abstractC1362a2;
        }
        return abstractC1362a;
    }

    public boolean a(AccountWithDataSet accountWithDataSet, boolean z10) {
        Iterator<AccountWithDataSet> it = g(false).iterator();
        while (it.hasNext()) {
            if (accountWithDataSet.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public final AccountType c(String str, String str2) {
        return d(d.a(str, str2));
    }

    public abstract AccountType d(d dVar);

    public final AccountType e(AccountWithDataSet accountWithDataSet) {
        return d(accountWithDataSet.h());
    }

    public abstract List<AccountType> f(boolean z10);

    public abstract List<AccountWithDataSet> g(boolean z10);

    public com.android.contacts.model.c i(String str, String str2, String str3) {
        AccountType c10 = c(str, str2);
        if (c10 == null) {
            return null;
        }
        return c10.j(str3);
    }
}
