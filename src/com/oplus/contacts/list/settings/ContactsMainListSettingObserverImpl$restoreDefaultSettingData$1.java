package com.oplus.contacts.list.settings;

import android.content.SharedPreferences;
import com.android.contacts.list.ContactListFilter;
import com.customize.contacts.util.U;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import kotlinx.coroutines.flow.i;
import m9.q;
import o1.C1393c;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: ContactsMainListSettingObserverImpl.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.settings.ContactsMainListSettingObserverImpl$restoreDefaultSettingData$1", f = "ContactsMainListSettingObserverImpl.kt", l = {188}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ContactsMainListSettingObserverImpl$restoreDefaultSettingData$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    int label;
    final /* synthetic */ ContactsMainListSettingObserverImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsMainListSettingObserverImpl$restoreDefaultSettingData$1(ContactsMainListSettingObserverImpl contactsMainListSettingObserverImpl, kotlin.coroutines.c<? super ContactsMainListSettingObserverImpl$restoreDefaultSettingData$1> cVar) {
        super(2, cVar);
        this.this$0 = contactsMainListSettingObserverImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ContactsMainListSettingObserverImpl$restoreDefaultSettingData$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        i iVar;
        Object value;
        SharedPreferences sharedPreferences;
        C1393c c1393c;
        C1393c c1393c2;
        C1393c c1393c3;
        a a10;
        i iVar2;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                kotlin.b.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            iVar = this.this$0.f28048f;
            ContactsMainListSettingObserverImpl contactsMainListSettingObserverImpl = this.this$0;
            do {
                value = iVar.getValue();
                a aVar = (a) value;
                sharedPreferences = contactsMainListSettingObserverImpl.f28045c;
                C1393c c1393c4 = null;
                if (sharedPreferences == null) {
                    kotlin.jvm.internal.i.q("sharedPref");
                    sharedPreferences = null;
                }
                ContactListFilter n10 = ContactListFilter.n(sharedPreferences);
                int i11 = n10.f16738b;
                String str = n10.f16740d;
                String str2 = n10.f16739c;
                String str3 = n10.f16741e;
                boolean z10 = n10.f16744h;
                String str4 = n10.f16743g;
                c1393c = contactsMainListSettingObserverImpl.f28043a;
                if (c1393c == null) {
                    kotlin.jvm.internal.i.q("contactsPreferences");
                    c1393c = null;
                }
                int g10 = c1393c.g();
                c1393c2 = contactsMainListSettingObserverImpl.f28043a;
                if (c1393c2 == null) {
                    kotlin.jvm.internal.i.q("contactsPreferences");
                    c1393c2 = null;
                }
                int h10 = c1393c2.h();
                c1393c3 = contactsMainListSettingObserverImpl.f28043a;
                if (c1393c3 == null) {
                    kotlin.jvm.internal.i.q("contactsPreferences");
                } else {
                    c1393c4 = c1393c3;
                }
                a10 = aVar.a(i11, str, str2, str3, z10, str4, h10, g10, c1393c4.j());
                H7.b.b("ContactsMainListSettingObserverImpl", "restore default setting data:" + a10);
            } while (!iVar.c(value, a10));
            iVar2 = this.this$0.f28049g;
            Boolean a11 = C1467a.a(U.e(this.this$0.m()));
            this.label = 1;
            if (iVar2.emit(a11, this) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((ContactsMainListSettingObserverImpl$restoreDefaultSettingData$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
