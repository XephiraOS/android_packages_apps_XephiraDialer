package com.customize.contacts.cleaner;

import android.app.job.JobParameters;
import android.content.SharedPreferences;
import androidx.preference.j;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import kotlinx.coroutines.w0;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: RawCleanerJobService.kt */
@InterfaceC1470d(c = "com.customize.contacts.cleaner.RawCleanerJobService$onStartJob$1", f = "RawCleanerJobService.kt", l = {135}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class RawCleanerJobService$onStartJob$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ RawCleanerJobService $context;
    final /* synthetic */ JobParameters $params;
    int label;
    final /* synthetic */ RawCleanerJobService this$0;

    /* compiled from: RawCleanerJobService.kt */
    @InterfaceC1470d(c = "com.customize.contacts.cleaner.RawCleanerJobService$onStartJob$1$1", f = "RawCleanerJobService.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.customize.contacts.cleaner.RawCleanerJobService$onStartJob$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<E, c<? super q>, Object> {
        final /* synthetic */ JobParameters $params;
        int label;
        final /* synthetic */ RawCleanerJobService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(RawCleanerJobService rawCleanerJobService, JobParameters jobParameters, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = rawCleanerJobService;
            this.$params = jobParameters;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<q> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.this$0, this.$params, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                H7.b.b("RawCleanerJobService", "notify jobFinished");
                this.this$0.jobFinished(this.$params, false);
                this.this$0.f20876a = false;
                return q.f35511a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(E e10, c<? super q> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(q.f35511a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawCleanerJobService$onStartJob$1(JobParameters jobParameters, RawCleanerJobService rawCleanerJobService, RawCleanerJobService rawCleanerJobService2, c<? super RawCleanerJobService$onStartJob$1> cVar) {
        super(2, cVar);
        this.$params = jobParameters;
        this.$context = rawCleanerJobService;
        this.this$0 = rawCleanerJobService2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new RawCleanerJobService$onStartJob$1(this.$params, this.$context, this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        c10 = b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                kotlin.b.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            long currentTimeMillis = System.currentTimeMillis();
            boolean z10 = this.$params.getExtras().getBoolean("synced", false);
            boolean b10 = a.b(this.$context, z10);
            H7.b.b("RawCleanerJobService", "onStartJob: synced: " + z10 + ", success: " + b10 + ", cost: " + (System.currentTimeMillis() - currentTimeMillis));
            if (b10) {
                SharedPreferences b11 = j.b(this.this$0.getApplicationContext());
                if (z10) {
                    b11.edit().putInt("clean_times", b11.getInt("clean_times", 0) + 1).putLong("last_clean_time_stamp", System.currentTimeMillis()).apply();
                } else {
                    b11.edit().putInt("once_cleaned", b11.getInt("once_cleaned", 0) + 1).apply();
                }
            }
            w0 c11 = S.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$params, null);
            this.label = 1;
            if (C1244g.g(c11, anonymousClass1, this) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((RawCleanerJobService$onStartJob$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
