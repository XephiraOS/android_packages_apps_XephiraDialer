package com.customize.contacts.util;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.C1467a;
import p9.InterfaceC1470d;

/* compiled from: ContactDataUtils.kt */
@InterfaceC1470d(c = "com.customize.contacts.util.ContactDataUtils$setStarred$1", f = "ContactDataUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ContactDataUtils$setStarred$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ Uri $contactUri;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $starred;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactDataUtils$setStarred$1(boolean z10, Context context, Uri uri, kotlin.coroutines.c<? super ContactDataUtils$setStarred$1> cVar) {
        super(2, cVar);
        this.$starred = z10;
        this.$context = context;
        this.$contactUri = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ContactDataUtils$setStarred$1(this.$starred, this.$context, this.$contactUri, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("starred", C1467a.a(this.$starred));
            G7.c.g(this.$context.getContentResolver(), R0.d.a(this.$contactUri), contentValues, null, null);
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((ContactDataUtils$setStarred$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
