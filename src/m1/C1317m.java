package m1;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.android.contacts.list.ContactListFilter;
import com.android.contacts.model.AccountWithDataSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m1.AbstractC1316l;
import n1.AbstractC1362a;

/* compiled from: ContactListFilterControllerImpl.java */
/* renamed from: m1.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1317m extends AbstractC1316l {

    /* renamed from: a, reason: collision with root package name */
    public final Context f35005a;

    /* renamed from: b, reason: collision with root package name */
    public final List<AbstractC1316l.a> f35006b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public ContactListFilter f35007c = ContactListFilter.n(k());

    public C1317m(Context context) {
        this.f35005a = context;
        b(true);
    }

    @Override // m1.AbstractC1316l
    public void a(AbstractC1316l.a aVar) {
        this.f35006b.add(aVar);
    }

    @Override // m1.AbstractC1316l
    public void b(boolean z10) {
        ContactListFilter contactListFilter = this.f35007c;
        if (contactListFilter == null) {
            return;
        }
        int i10 = contactListFilter.f16738b;
        if (i10 != -6) {
            if (i10 != 0 || TextUtils.equals(R0.a.f3166b, contactListFilter.f16739c)) {
                return;
            }
            if (TextUtils.isEmpty(this.f35007c.f16740d) || TextUtils.isEmpty(this.f35007c.f16739c) || (!"com.android.oplus.sim".equals(this.f35007c.f16739c) && !j())) {
                m(ContactListFilter.h(-2), true, z10);
                return;
            }
            return;
        }
        m(ContactListFilter.n(k()), false, z10);
    }

    @Override // m1.AbstractC1316l
    public void c(boolean z10) {
        ContactListFilter contactListFilter = this.f35007c;
        if (contactListFilter != null && "com.android.oplus.sim".equals(contactListFilter.f16739c)) {
            m(ContactListFilter.h(-2), true, z10);
        }
    }

    @Override // m1.AbstractC1316l
    public ContactListFilter e() {
        return this.f35007c;
    }

    @Override // m1.AbstractC1316l
    public void g(AbstractC1316l.a aVar) {
        this.f35006b.remove(aVar);
    }

    @Override // m1.AbstractC1316l
    public void h(boolean z10) {
        i(ContactListFilter.i(-3, z10), true);
    }

    @Override // m1.AbstractC1316l
    public void i(ContactListFilter contactListFilter, boolean z10) {
        m(contactListFilter, z10, true);
    }

    public final boolean j() {
        AbstractC1362a h10 = AbstractC1362a.h(this.f35005a);
        ContactListFilter contactListFilter = this.f35007c;
        return h10.a(new AccountWithDataSet(contactListFilter.f16740d, contactListFilter.f16739c, contactListFilter.f16741e), false);
    }

    public final SharedPreferences k() {
        return PreferenceManager.getDefaultSharedPreferences(this.f35005a);
    }

    public final void l() {
        Iterator<AbstractC1316l.a> it = this.f35006b.iterator();
        while (it.hasNext()) {
            it.next().M0();
        }
    }

    public void m(ContactListFilter contactListFilter, boolean z10, boolean z11) {
        ContactListFilter n10 = ContactListFilter.n(k());
        this.f35007c = n10;
        if (!contactListFilter.equals(n10)) {
            this.f35007c = contactListFilter;
            if (z10) {
                ContactListFilter.t(k(), this.f35007c);
            }
            if (z11 && !this.f35006b.isEmpty()) {
                l();
            }
        }
    }
}
