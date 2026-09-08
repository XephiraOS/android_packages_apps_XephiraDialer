package com.android.contacts;

import com.android.contacts.DynamicShortcuts;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC1470d;

/* compiled from: ContactShortcuts.kt */
@InterfaceC1470d(c = "com.android.contacts.ContactShortcuts$createViewContactPinShortcut$2", f = "ContactShortcuts.kt", l = {51}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ContactShortcuts$createViewContactPinShortcut$2 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ long $contactId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactShortcuts$createViewContactPinShortcut$2(long j10, kotlin.coroutines.c<? super ContactShortcuts$createViewContactPinShortcut$2> cVar) {
        super(2, cVar);
        this.$contactId = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ContactShortcuts$createViewContactPinShortcut$2(this.$contactId, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        Object A10;
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
            ContactShortcuts contactShortcuts = ContactShortcuts.f13087j;
            long j10 = this.$contactId;
            DynamicShortcuts.ShortcutType shortcutType = DynamicShortcuts.ShortcutType.DETAIL;
            this.label = 1;
            A10 = contactShortcuts.A(j10, shortcutType, this);
            if (A10 == c10) {
                return c10;
            }
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((ContactShortcuts$createViewContactPinShortcut$2) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
