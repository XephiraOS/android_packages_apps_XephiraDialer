package com.oplus.contacts.list.settings;

import R0.c;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.net.Uri;
import android.preference.PreferenceManager;
import com.android.contacts.list.ContactListFilter;
import kotlin.jvm.internal.f;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.m;
import kotlinx.coroutines.flow.n;
import m1.AbstractC1316l;
import m9.d;
import o1.C1393c;
import v9.InterfaceC1637a;

/* compiled from: ContactsMainListSettingObserverImpl.kt */
/* loaded from: classes3.dex */
public final class ContactsMainListSettingObserverImpl {

    /* renamed from: l, reason: collision with root package name */
    public static final a f28042l = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public C1393c f28043a;

    /* renamed from: b, reason: collision with root package name */
    public AbstractC1316l f28044b;

    /* renamed from: c, reason: collision with root package name */
    public SharedPreferences f28045c;

    /* renamed from: d, reason: collision with root package name */
    public final d f28046d;

    /* renamed from: e, reason: collision with root package name */
    public final b f28047e;

    /* renamed from: f, reason: collision with root package name */
    public i<com.oplus.contacts.list.settings.a> f28048f;

    /* renamed from: g, reason: collision with root package name */
    public i<Boolean> f28049g;

    /* renamed from: h, reason: collision with root package name */
    public E f28050h;

    /* renamed from: i, reason: collision with root package name */
    public final c f28051i;

    /* renamed from: j, reason: collision with root package name */
    public final C1393c.b f28052j;

    /* renamed from: k, reason: collision with root package name */
    public final AbstractC1316l.a f28053k;

    /* compiled from: ContactsMainListSettingObserverImpl.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: ContactsMainListSettingObserverImpl.kt */
    /* loaded from: classes3.dex */
    public final class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            kotlin.jvm.internal.i.f(context, "context");
            kotlin.jvm.internal.i.f(intent, "intent");
            String action = intent.getAction();
            if (action != null && action.hashCode() == 362055431 && action.equals("oplus.intent.action.ACTION_RESTORE_FILTER")) {
                ContactsMainListSettingObserverImpl.this.u();
            }
        }
    }

    /* compiled from: ContactsMainListSettingObserverImpl.kt */
    /* loaded from: classes3.dex */
    public static final class c extends ContentObserver {
        public c() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            ContactsMainListSettingObserverImpl contactsMainListSettingObserverImpl = ContactsMainListSettingObserverImpl.this;
            contactsMainListSettingObserverImpl.y(contactsMainListSettingObserverImpl.m());
        }
    }

    public ContactsMainListSettingObserverImpl() {
        d b10;
        b10 = kotlin.a.b(new InterfaceC1637a<Context>() { // from class: com.oplus.contacts.list.settings.ContactsMainListSettingObserverImpl$appContext$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Context invoke() {
                return P7.a.f2961a.a();
            }
        });
        this.f28046d = b10;
        this.f28047e = new b();
        this.f28048f = n.a(new com.oplus.contacts.list.settings.a(0, null, null, null, false, null, 0, 0, false, 511, null));
        this.f28049g = n.a(Boolean.TRUE);
        this.f28051i = new c();
        this.f28052j = new C1393c.b() { // from class: com.oplus.contacts.list.settings.b
            @Override // o1.C1393c.b
            public final void onChange() {
                ContactsMainListSettingObserverImpl.l(ContactsMainListSettingObserverImpl.this);
            }
        };
        this.f28053k = new AbstractC1316l.a() { // from class: com.oplus.contacts.list.settings.c
            @Override // m1.AbstractC1316l.a
            public final void M0() {
                ContactsMainListSettingObserverImpl.k(ContactsMainListSettingObserverImpl.this);
            }
        };
    }

    public static final void k(ContactsMainListSettingObserverImpl this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.w();
    }

    public static final void l(ContactsMainListSettingObserverImpl this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.x();
    }

    public final Context m() {
        return (Context) this.f28046d.getValue();
    }

    public m<com.oplus.contacts.list.settings.a> n() {
        return this.f28048f;
    }

    public Object o(AbstractC1316l abstractC1316l, C1393c c1393c, kotlin.coroutines.c<? super com.oplus.contacts.list.settings.a> cVar) {
        ContactListFilter e10 = abstractC1316l.e();
        return new com.oplus.contacts.list.settings.a(e10.f16738b, e10.f16740d, e10.f16739c, e10.f16741e, e10.f16744h, e10.f16743g, c1393c.h(), c1393c.g(), c1393c.j());
    }

    public m<Boolean> p() {
        return this.f28049g;
    }

    public final void q(AbstractC1316l abstractC1316l, C1393c c1393c) {
        E e10 = this.f28050h;
        if (e10 != null) {
            C1248i.d(e10, S.b(), null, new ContactsMainListSettingObserverImpl$initSettingData$1(this, abstractC1316l, c1393c, null), 2, null);
        }
    }

    public final void r(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("oplus.intent.action.ACTION_RESTORE_FILTER");
        X.a.b(context).c(this.f28047e, intentFilter);
    }

    public void s(E scope) {
        kotlin.jvm.internal.i.f(scope, "scope");
        this.f28050h = scope;
        this.f28043a = new C1393c(m());
        AbstractC1316l f10 = AbstractC1316l.f(m());
        kotlin.jvm.internal.i.e(f10, "getInstance(appContext)");
        this.f28044b = f10;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(m());
        kotlin.jvm.internal.i.e(defaultSharedPreferences, "getDefaultSharedPreferences(appContext)");
        this.f28045c = defaultSharedPreferences;
        AbstractC1316l abstractC1316l = this.f28044b;
        AbstractC1316l abstractC1316l2 = null;
        if (abstractC1316l == null) {
            kotlin.jvm.internal.i.q("contactListFilterController");
            abstractC1316l = null;
        }
        C1393c c1393c = this.f28043a;
        if (c1393c == null) {
            kotlin.jvm.internal.i.q("contactsPreferences");
            c1393c = null;
        }
        q(abstractC1316l, c1393c);
        C1393c c1393c2 = this.f28043a;
        if (c1393c2 == null) {
            kotlin.jvm.internal.i.q("contactsPreferences");
            c1393c2 = null;
        }
        c1393c2.l(this.f28052j);
        AbstractC1316l abstractC1316l3 = this.f28044b;
        if (abstractC1316l3 == null) {
            kotlin.jvm.internal.i.q("contactListFilterController");
        } else {
            abstractC1316l2 = abstractC1316l3;
        }
        abstractC1316l2.a(this.f28053k);
        r(m());
        t(m());
    }

    public final void t(Context context) {
        Uri m10 = G0.c.m(0, c.a.f3197c, 2);
        if (m10 != null) {
            context.getContentResolver().registerContentObserver(m10, true, this.f28051i);
        }
    }

    public final void u() {
        E e10 = this.f28050h;
        if (e10 != null) {
            C1248i.d(e10, S.b(), null, new ContactsMainListSettingObserverImpl$restoreDefaultSettingData$1(this, null), 2, null);
        }
    }

    public void v() {
        AbstractC1316l abstractC1316l = this.f28044b;
        C1393c c1393c = null;
        if (abstractC1316l == null) {
            kotlin.jvm.internal.i.q("contactListFilterController");
            abstractC1316l = null;
        }
        abstractC1316l.g(this.f28053k);
        C1393c c1393c2 = this.f28043a;
        if (c1393c2 == null) {
            kotlin.jvm.internal.i.q("contactsPreferences");
        } else {
            c1393c = c1393c2;
        }
        c1393c.p();
        m().getContentResolver().unregisterContentObserver(this.f28051i);
        X.a.b(m()).e(this.f28047e);
    }

    public final void w() {
        E e10 = this.f28050h;
        if (e10 != null) {
            C1248i.d(e10, S.b(), null, new ContactsMainListSettingObserverImpl$updateContactListFilter$1(this, null), 2, null);
        }
    }

    public final void x() {
        E e10 = this.f28050h;
        if (e10 != null) {
            C1248i.d(e10, S.b(), null, new ContactsMainListSettingObserverImpl$updateOrderSetting$1(this, null), 2, null);
        }
    }

    public final void y(Context context) {
        E e10 = this.f28050h;
        if (e10 != null) {
            C1248i.d(e10, S.b(), null, new ContactsMainListSettingObserverImpl$updatePhotoVisibleState$1(this, context, null), 2, null);
        }
    }
}
