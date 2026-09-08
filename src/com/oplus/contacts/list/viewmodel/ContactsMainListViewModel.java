package com.oplus.contacts.list.viewmodel;

import android.content.Context;
import android.database.Cursor;
import androidx.lifecycle.I;
import androidx.lifecycle.J;
import com.android.contacts.util.w;
import com.customize.contacts.model.IdRecord;
import com.oplus.contacts.list.selectmanager.ContactsMainListSelectManager;
import com.oplus.contacts.list.settings.ContactsMainListSettingObserverImpl;
import java.util.List;
import kotlin.coroutines.c;
import kotlin.jvm.internal.f;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.J0;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.m;
import kotlinx.coroutines.flow.n;
import m1.AbstractC1316l;
import m1.U;
import m9.d;
import m9.q;
import o1.C1393c;
import o7.C1408a;
import p7.C1463d;
import v9.InterfaceC1637a;

/* compiled from: ContactsMainListViewModel.kt */
/* loaded from: classes3.dex */
public class ContactsMainListViewModel extends I {

    /* renamed from: m, reason: collision with root package name */
    public static final a f28081m = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ContactsMainListSelectManager f28082d = new ContactsMainListSelectManager();

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C1408a f28083e = new C1408a();

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ContactsMainListSettingObserverImpl f28084f = new ContactsMainListSettingObserverImpl();

    /* renamed from: g, reason: collision with root package name */
    public final d f28085g;

    /* renamed from: h, reason: collision with root package name */
    public final ExecutorCoroutineDispatcher f28086h;

    /* renamed from: i, reason: collision with root package name */
    public U f28087i;

    /* renamed from: j, reason: collision with root package name */
    public final i<Integer> f28088j;

    /* renamed from: k, reason: collision with root package name */
    public final i<Integer> f28089k;

    /* renamed from: l, reason: collision with root package name */
    public final U.c f28090l;

    /* compiled from: ContactsMainListViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public ContactsMainListViewModel() {
        d b10;
        b10 = kotlin.a.b(new InterfaceC1637a<Context>() { // from class: com.oplus.contacts.list.viewmodel.ContactsMainListViewModel$appContext$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Context invoke() {
                return P7.a.f2961a.a();
            }
        });
        this.f28085g = b10;
        this.f28086h = J0.b("ContactsListViewModel");
        i<Integer> a10 = n.a(-1);
        this.f28088j = a10;
        this.f28089k = a10;
        this.f28090l = new U.c() { // from class: com.oplus.contacts.list.viewmodel.a
            @Override // m1.U.c
            public final void a() {
                ContactsMainListViewModel.z(ContactsMainListViewModel.this);
            }
        };
        H7.b.e("ContactsMainListViewModel", "init");
        s();
        A(J.a(this));
    }

    public static final void z(ContactsMainListViewModel this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        U u10 = this$0.f28087i;
        if (u10 != null) {
            C1248i.d(J.a(this$0), null, null, new ContactsMainListViewModel$providerStatusListener$1$1$1(u10, this$0, null), 3, null);
        }
    }

    public void A(E scope) {
        kotlin.jvm.internal.i.f(scope, "scope");
        this.f28084f.s(scope);
    }

    public void B() {
        this.f28082d.f();
    }

    public void C(com.oplus.contacts.list.f itemData) {
        kotlin.jvm.internal.i.f(itemData, "itemData");
        this.f28082d.p(itemData);
    }

    public void D() {
        this.f28084f.v();
    }

    public void E(boolean z10) {
        this.f28083e.b(z10);
    }

    @Override // androidx.lifecycle.I
    public void e() {
        U u10;
        H7.b.b("ContactsMainListViewModel", "onCleared");
        if (w.j(j()) && (u10 = this.f28087i) != null) {
            u10.p();
        }
        U u11 = this.f28087i;
        if (u11 != null) {
            u11.l(this.f28090l);
        }
        D();
    }

    public boolean i() {
        return this.f28082d.j();
    }

    public final Context j() {
        return (Context) this.f28085g.getValue();
    }

    public m<com.oplus.contacts.list.settings.a> k() {
        return this.f28084f.n();
    }

    public Object l(AbstractC1316l abstractC1316l, C1393c c1393c, c<? super com.oplus.contacts.list.settings.a> cVar) {
        return this.f28084f.o(abstractC1316l, c1393c, cVar);
    }

    public final i<Integer> m() {
        return this.f28089k;
    }

    public m<Boolean> n() {
        return this.f28083e.a();
    }

    public m<Boolean> o() {
        return this.f28084f.p();
    }

    public List<IdRecord> p() {
        return this.f28082d.l();
    }

    public m<C1463d<com.oplus.contacts.list.f>> q() {
        return this.f28082d.h();
    }

    public boolean r() {
        return this.f28082d.m();
    }

    public final void s() {
        U u10;
        U h10 = U.h(j());
        this.f28087i = h10;
        if (h10 != null) {
            h10.g(this.f28090l);
        }
        if (w.j(j()) && (u10 = this.f28087i) != null) {
            u10.m();
        }
    }

    public void t(boolean z10) {
        this.f28082d.d(z10);
    }

    public Object u(Cursor cursor, c<? super q> cVar) {
        return this.f28082d.n(cursor, cVar);
    }

    public final void v(Cursor cursor) {
        C1248i.d(J.a(this), this.f28086h, null, new ContactsMainListViewModel$onLoadComplete$1(this, cursor, null), 2, null);
    }

    public Object w(c<? super q> cVar) {
        return this.f28082d.o(cVar);
    }

    public final boolean x() {
        if (this.f28089k.getValue().intValue() == 0) {
            return true;
        }
        return false;
    }

    public final boolean y() {
        if (this.f28088j.getValue().intValue() != -1) {
            return true;
        }
        return false;
    }
}
