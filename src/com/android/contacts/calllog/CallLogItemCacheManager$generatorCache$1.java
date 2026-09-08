package com.android.contacts.calllog;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC1470d;

/* compiled from: CallLogItemCacheManager.kt */
@InterfaceC1470d(c = "com.android.contacts.calllog.CallLogItemCacheManager$generatorCache$1", f = "CallLogItemCacheManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class CallLogItemCacheManager$generatorCache$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $json;
    int label;
    final /* synthetic */ CallLogItemCacheManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallLogItemCacheManager$generatorCache$1(Context context, CallLogItemCacheManager callLogItemCacheManager, String str, kotlin.coroutines.c<? super CallLogItemCacheManager$generatorCache$1> cVar) {
        super(2, cVar);
        this.$context = context;
        this.this$0 = callLogItemCacheManager;
        this.$json = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new CallLogItemCacheManager$generatorCache$1(this.$context, this.this$0, this.$json, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b10;
        CopyOnWriteArrayList copyOnWriteArrayList;
        String str;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            Context context = this.$context;
            CallLogItemCacheManager callLogItemCacheManager = this.this$0;
            String str2 = this.$json;
            try {
                Result.a aVar = Result.f34166a;
                SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("calllog_cache", 0).edit();
                copyOnWriteArrayList = callLogItemCacheManager.f13739a;
                H7.b.b("CallLogItemCacheManager", "mCache size " + copyOnWriteArrayList.size());
                if (str2 != null) {
                    if (str2.length() > 0) {
                        str = str2;
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        edit.putString("CALL_LOG_ITEM_CACHE", str2);
                        edit.commit();
                    }
                }
                b10 = Result.b(m9.q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                Log.e("ExceptionUtils", "Exception when invoke block : " + d10);
            }
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((CallLogItemCacheManager$generatorCache$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
