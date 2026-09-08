package com.android.contacts;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import p9.InterfaceC1470d;

/* compiled from: ContactShortcuts.kt */
@InterfaceC1470d(c = "com.android.contacts.ContactShortcuts", f = "ContactShortcuts.kt", l = {36}, m = "checkPinnedShortcutsExist")
/* loaded from: classes.dex */
public final class ContactShortcuts$checkPinnedShortcutsExist$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ContactShortcuts this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactShortcuts$checkPinnedShortcutsExist$1(ContactShortcuts contactShortcuts, kotlin.coroutines.c<? super ContactShortcuts$checkPinnedShortcutsExist$1> cVar) {
        super(cVar);
        this.this$0 = contactShortcuts;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object y10;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        y10 = this.this$0.y(0L, null, this);
        return y10;
    }
}
