package com.android.contacts;

import com.oplus.dialer.R;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC1470d;

/* compiled from: ContactShortcuts.kt */
@InterfaceC1470d(c = "com.android.contacts.ContactShortcuts$checkPinnedShortcutsExist$2", f = "ContactShortcuts.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ContactShortcuts$checkPinnedShortcutsExist$2 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    int label;

    public ContactShortcuts$checkPinnedShortcutsExist$2(kotlin.coroutines.c<? super ContactShortcuts$checkPinnedShortcutsExist$2> cVar) {
        super(2, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ContactShortcuts$checkPinnedShortcutsExist$2(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            com.oplus.foundation.util.ui.c.d(ContactShortcuts.f13087j.f13112a, R.string.contact_shortcut_already_exist);
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((ContactShortcuts$checkPinnedShortcutsExist$2) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
