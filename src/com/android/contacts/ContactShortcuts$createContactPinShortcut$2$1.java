package com.android.contacts;

import com.oplus.dialer.R;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC1470d;

/* compiled from: ContactShortcuts.kt */
@InterfaceC1470d(c = "com.android.contacts.ContactShortcuts$createContactPinShortcut$2$1", f = "ContactShortcuts.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ContactShortcuts$createContactPinShortcut$2$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ ContactShortcuts $this_runCatching;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactShortcuts$createContactPinShortcut$2$1(ContactShortcuts contactShortcuts, kotlin.coroutines.c<? super ContactShortcuts$createContactPinShortcut$2$1> cVar) {
        super(2, cVar);
        this.$this_runCatching = contactShortcuts;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ContactShortcuts$createContactPinShortcut$2$1(this.$this_runCatching, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            com.oplus.foundation.util.ui.c.d(this.$this_runCatching.f13112a, R.string.contact_shortcut_success);
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((ContactShortcuts$createContactPinShortcut$2$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
