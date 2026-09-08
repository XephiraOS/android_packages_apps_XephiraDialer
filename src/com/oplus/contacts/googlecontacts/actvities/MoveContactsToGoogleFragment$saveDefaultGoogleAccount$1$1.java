package com.oplus.contacts.googlecontacts.actvities;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: MoveContactsToGoogleFragment.kt */
@InterfaceC1470d(c = "com.oplus.contacts.googlecontacts.actvities.MoveContactsToGoogleFragment$saveDefaultGoogleAccount$1$1", f = "MoveContactsToGoogleFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class MoveContactsToGoogleFragment$saveDefaultGoogleAccount$1$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ String $accountName;
    final /* synthetic */ Context $baseContext;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoveContactsToGoogleFragment$saveDefaultGoogleAccount$1$1(String str, Context context, kotlin.coroutines.c<? super MoveContactsToGoogleFragment$saveDefaultGoogleAccount$1$1> cVar) {
        super(2, cVar);
        this.$accountName = str;
        this.$baseContext = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new MoveContactsToGoogleFragment$saveDefaultGoogleAccount$1$1(this.$accountName, this.$baseContext, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b10;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            String str = this.$accountName;
            Context context = this.$baseContext;
            try {
                Result.a aVar = Result.f34166a;
                Bundle bundle = new Bundle();
                bundle.putString("account_name", str);
                bundle.putString("account_type", "com.google");
                b10 = Result.b(context.getContentResolver().call(ContactsContract.AUTHORITY_URI, "setDefaultAccount", (String) null, bundle));
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("MoveContactsToGoogleFragment", "saveDefaultGoogleAccount error: " + d10);
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((MoveContactsToGoogleFragment$saveDefaultGoogleAccount$1$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
