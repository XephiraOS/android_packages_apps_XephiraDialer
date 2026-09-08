package com.android.contacts.business.calllog.breenocall;

import P7.a;
import R7.d;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.InterfaceC1637a;
import v9.p;

/* compiled from: FeatureOpt.kt */
@InterfaceC1470d(c = "com.android.contacts.business.calllog.breenocall.FeatureOpt$updateBreenoCallSupport$1", f = "FeatureOpt.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class FeatureOpt$updateBreenoCallSupport$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ Runnable $runnable;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeatureOpt$updateBreenoCallSupport$1(Runnable runnable, c<? super FeatureOpt$updateBreenoCallSupport$1> cVar) {
        super(2, cVar);
        this.$runnable = runnable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new FeatureOpt$updateBreenoCallSupport$1(this.$runnable, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b10;
        Object obj2;
        Uri uri;
        Uri uri2;
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            Runnable runnable = this.$runnable;
            try {
                Result.a aVar = Result.f34166a;
                a aVar2 = a.f2961a;
                SharedPreferences b11 = R7.b.b(aVar2.a(), "ai_call", 0);
                int e10 = d.e(b11, "ai_call_support", -1);
                int d10 = G0.c.d(aVar2.a(), 1, "is_support_ai_call", -1);
                H7.b.e("FeatureOpt", "updateBreenoCallSupport support: " + d10 + ";oldValue: " + e10);
                if (d10 == 0) {
                    FeatureOpt.INSTANCE.checkUpdateBreenoCallSupport(false, e10, runnable, b11);
                    obj2 = q.f35511a;
                } else if (d10 == 1) {
                    FeatureOpt.INSTANCE.checkUpdateBreenoCallSupport(true, e10, runnable, b11);
                    obj2 = q.f35511a;
                } else {
                    ContentResolver contentResolver = aVar2.a().getContentResolver();
                    if (contentResolver != null) {
                        uri = FeatureOpt.AI_CALL_URI;
                        ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                        if (acquireUnstableContentProviderClient != null) {
                            uri2 = FeatureOpt.AI_CALL_URI;
                            String authority = uri2.getAuthority();
                            if (authority == null) {
                                authority = "";
                            }
                            Bundle call = acquireUnstableContentProviderClient.call(authority, "setting.isSupportAiCall", null, null);
                            if (call != null) {
                                if (call.containsKey("supportAiCall")) {
                                    FeatureOpt.INSTANCE.checkUpdateBreenoCallSupport(call.getBoolean("supportAiCall"), e10, runnable, b11);
                                } else {
                                    H7.b.e("FeatureOpt", "isBreenoCallSupport not containsKey");
                                }
                                obj2 = q.f35511a;
                            }
                        }
                    }
                    obj2 = new InterfaceC1637a<q>() { // from class: com.android.contacts.business.calllog.breenocall.FeatureOpt$updateBreenoCallSupport$1$1$2
                        @Override // v9.InterfaceC1637a
                        public /* bridge */ /* synthetic */ q invoke() {
                            invoke2();
                            return q.f35511a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            H7.b.e("FeatureOpt", "isBreenoCallSupport null");
                        }
                    };
                }
                b10 = Result.b(obj2);
            } catch (Throwable th) {
                Result.a aVar3 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d11 = Result.d(b10);
            if (d11 != null) {
                H7.b.c("FeatureOpt", "isBreenoCallSupport error: " + d11);
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((FeatureOpt$updateBreenoCallSupport$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
