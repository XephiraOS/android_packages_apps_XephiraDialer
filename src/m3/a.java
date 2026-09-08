package M3;

import android.accounts.Account;
import android.content.ContentResolver;
import android.os.Bundle;
import android.provider.ContactsContract;
import kotlin.Result;

/* compiled from: AccountAdapter.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1746a = new a();

    public static final Account a(ContentResolver resolver) {
        kotlin.jvm.internal.i.f(resolver, "resolver");
        Bundle call = resolver.call(ContactsContract.AUTHORITY_URI, "queryDefaultAccount", (String) null, (Bundle) null);
        if (call == null) {
            return null;
        }
        return (Account) call.getParcelable("key_default_account");
    }

    public static final void b(ContentResolver resolver, Account account) {
        Object b10;
        kotlin.jvm.internal.i.f(resolver, "resolver");
        try {
            Result.a aVar = Result.f34166a;
            Bundle bundle = new Bundle();
            if (account != null) {
                bundle.putString("account_name", account.name);
                bundle.putString("account_type", account.type);
            }
            b10 = Result.b(resolver.call(ContactsContract.AUTHORITY_URI, "setDefaultAccount", (String) null, bundle));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("AccountAdapter", "setDefaultAccount " + d10.getMessage());
        }
    }
}
