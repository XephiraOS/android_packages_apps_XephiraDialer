package com.android.contacts;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import p9.InterfaceC1470d;

/* compiled from: ContactShortcuts.kt */
@InterfaceC1470d(c = "com.android.contacts.ContactShortcuts", f = "ContactShortcuts.kt", l = {64, 79}, m = "createContactPinShortcut")
/* loaded from: classes.dex */
public final class ContactShortcuts$createContactPinShortcut$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ContactShortcuts this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactShortcuts$createContactPinShortcut$1(ContactShortcuts contactShortcuts, kotlin.coroutines.c<? super ContactShortcuts$createContactPinShortcut$1> cVar) {
        super(cVar);
        this.this$0 = contactShortcuts;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object A10;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        A10 = this.this$0.A(0L, null, this);
        return A10;
    }
}
