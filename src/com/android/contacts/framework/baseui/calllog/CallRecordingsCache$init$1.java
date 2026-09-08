package com.android.contacts.framework.baseui.calllog;

import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.provider.CallLog;
import androidx.lifecycle.v;
import com.android.contacts.framework.baseui.calllog.CallRecordingsCache;
import java.util.HashSet;
import java.util.Set;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: CallRecordingsCache.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.baseui.calllog.CallRecordingsCache$init$1", f = "CallRecordingsCache.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class CallRecordingsCache$init$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallRecordingsCache$init$1(Context context, kotlin.coroutines.c<? super CallRecordingsCache$init$1> cVar) {
        super(2, cVar);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new CallRecordingsCache$init$1(this.$context, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        boolean z10;
        Object b10;
        Set set;
        boolean z11;
        boolean z12;
        Context context;
        Set set2;
        boolean z13;
        v vVar;
        Set set3;
        Set set4;
        boolean z14;
        Set set5;
        boolean z15;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            if (H7.a.b()) {
                String name = Thread.currentThread().getName();
                z15 = CallRecordingsCache.f15756c;
                H7.b.b("CallRecordingsCache", "Launch: [" + name + "] inited: " + z15);
            }
            obj2 = CallRecordingsCache.f15760g;
            Context context2 = this.$context;
            synchronized (obj2) {
                try {
                    z10 = CallRecordingsCache.f15756c;
                    if (!z10) {
                        CallRecordingsCache.f15757d = false;
                        HashSet hashSet = new HashSet();
                        for (Q0.c cVar : Q0.c.f3102l.b(context2, false)) {
                            hashSet.add(C1467a.e(cVar.b()));
                            z14 = CallRecordingsCache.f15757d;
                            if (!z14) {
                                set5 = CallRecordingsCache.f15755b;
                                if (!set5.contains(C1467a.e(cVar.b()))) {
                                    CallRecordingsCache.f15757d = true;
                                }
                            }
                        }
                        int size = hashSet.size();
                        set2 = CallRecordingsCache.f15755b;
                        if (size != set2.size()) {
                            CallRecordingsCache.f15757d = true;
                        }
                        z13 = CallRecordingsCache.f15757d;
                        if (z13) {
                            set3 = CallRecordingsCache.f15755b;
                            set3.clear();
                            set4 = CallRecordingsCache.f15755b;
                            set4.addAll(hashSet);
                        }
                        vVar = CallRecordingsCache.f15763j;
                        vVar.m(C1467a.a(true));
                        CallRecordingsCache.f15756c = true;
                    }
                    try {
                        Result.a aVar = Result.f34166a;
                        z12 = CallRecordingsCache.f15758e;
                        if (!z12) {
                            context = CallRecordingsCache.f15762i;
                            if (context != null) {
                                IntentFilter intentFilter = new IntentFilter();
                                intentFilter.addAction("com.android.contacts.local.ACTION_CALLLOGS_RESTORE_FINISHED");
                                X.a.b(context).c(CallRecordingsCache.a.f15764a, intentFilter);
                                CallRecordingsCache.f15759f = M7.a.h(context, "com.android.providers.contacts", "recording_data_change_notify", "true");
                                H7.b.b("CallRecordingsCache", "recordingChangeNotify: " + CallRecordingsCache.f15759f);
                                if (CallRecordingsCache.f15759f) {
                                    ContentResolver contentResolver = context.getContentResolver();
                                    if (contentResolver != null) {
                                        contentResolver.registerContentObserver(a.f15766a, true, CallRecordingsCache.contentObserver.f15765a);
                                    }
                                } else {
                                    ContentResolver contentResolver2 = context.getContentResolver();
                                    if (contentResolver2 != null) {
                                        contentResolver2.registerContentObserver(CallLog.Calls.CONTENT_URI, true, CallRecordingsCache.contentObserver.f15765a);
                                    }
                                }
                            }
                            CallRecordingsCache.f15758e = true;
                        }
                        b10 = Result.b(q.f35511a);
                    } catch (Throwable th) {
                        Result.a aVar2 = Result.f34166a;
                        b10 = Result.b(kotlin.b.a(th));
                    }
                    Throwable d10 = Result.d(b10);
                    if (d10 != null) {
                        H7.b.c("CallRecordingsCache", "registerContentObserver: exception: " + d10);
                    }
                    String name2 = Thread.currentThread().getName();
                    set = CallRecordingsCache.f15755b;
                    int size2 = set.size();
                    z11 = CallRecordingsCache.f15757d;
                    H7.b.b("CallRecordingsCache", "[" + name2 + "]: load: count: " + size2 + ", changed: " + z11);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((CallRecordingsCache$init$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
