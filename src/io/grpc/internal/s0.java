package io.grpc.internal;

import io.grpc.AbstractC1112f;
import io.grpc.C1107a;
import io.grpc.Context;
import io.grpc.Status;
import j9.J;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: StatsTraceContext.java */
/* loaded from: classes4.dex */
public final class s0 {

    /* renamed from: c, reason: collision with root package name */
    public static final s0 f33394c = new s0(new j9.M[0]);

    /* renamed from: a, reason: collision with root package name */
    public final j9.M[] f33395a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f33396b = new AtomicBoolean(false);

    public s0(j9.M[] mArr) {
        this.f33395a = mArr;
    }

    public static s0 g(AbstractC1112f[] abstractC1112fArr, C1107a c1107a, io.grpc.u uVar) {
        s0 s0Var = new s0(abstractC1112fArr);
        for (AbstractC1112f abstractC1112f : abstractC1112fArr) {
            abstractC1112f.k(c1107a, uVar);
        }
        return s0Var;
    }

    public static s0 h(List<? extends J.a> list, String str, io.grpc.u uVar) {
        if (list.isEmpty()) {
            return f33394c;
        }
        int size = list.size();
        j9.M[] mArr = new j9.M[size];
        for (int i10 = 0; i10 < size; i10++) {
            mArr[i10] = list.get(i10).a(str, uVar);
        }
        return new s0(mArr);
    }

    public void a() {
        for (j9.M m10 : this.f33395a) {
            ((AbstractC1112f) m10).h();
        }
    }

    public void b(io.grpc.u uVar) {
        for (j9.M m10 : this.f33395a) {
            ((AbstractC1112f) m10).i(uVar);
        }
    }

    public void c() {
        for (j9.M m10 : this.f33395a) {
            ((AbstractC1112f) m10).j();
        }
    }

    public void d(int i10) {
        for (j9.M m10 : this.f33395a) {
            m10.a(i10);
        }
    }

    public void e(int i10, long j10, long j11) {
        for (j9.M m10 : this.f33395a) {
            m10.b(i10, j10, j11);
        }
    }

    public void f(long j10) {
        for (j9.M m10 : this.f33395a) {
            m10.c(j10);
        }
    }

    public List<j9.M> getTracersForTest() {
        return new ArrayList(Arrays.asList(this.f33395a));
    }

    public void i(int i10) {
        for (j9.M m10 : this.f33395a) {
            m10.d(i10);
        }
    }

    public void j(int i10, long j10, long j11) {
        for (j9.M m10 : this.f33395a) {
            m10.e(i10, j10, j11);
        }
    }

    public void k(J.c<?, ?> cVar) {
        for (j9.M m10 : this.f33395a) {
            ((j9.J) m10).i(cVar);
        }
    }

    public <ReqT, RespT> Context l(Context context) {
        Context context2 = (Context) com.google.common.base.k.p(context, "context");
        for (j9.M m10 : this.f33395a) {
            context2 = ((j9.J) m10).g(context2);
            com.google.common.base.k.q(context2, "%s returns null context", m10);
        }
        return context2;
    }

    public void m(Status status) {
        if (this.f33396b.compareAndSet(false, true)) {
            for (j9.M m10 : this.f33395a) {
                m10.f(status);
            }
        }
    }
}
