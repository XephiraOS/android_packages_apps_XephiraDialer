package io.grpc.util;

import com.google.common.base.k;
import io.grpc.C1107a;
import io.grpc.q;
import j9.C1201k;

/* loaded from: classes4.dex */
public final class HealthProducerHelper extends c {

    /* renamed from: a, reason: collision with root package name */
    public final q.e f33513a;

    /* loaded from: classes4.dex */
    public static final class HealthProducerSubchannel extends d {

        /* renamed from: a, reason: collision with root package name */
        public final q.i f33514a;

        /* renamed from: b, reason: collision with root package name */
        public final q.k f33515b;

        /* loaded from: classes4.dex */
        public class a implements q.k {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ q.k f33516a;

            public a(q.k kVar) {
                this.f33516a = kVar;
            }

            @Override // io.grpc.q.k
            public void a(C1201k c1201k) {
                this.f33516a.a(c1201k);
                HealthProducerSubchannel.this.f33515b.a(c1201k);
            }
        }

        public HealthProducerSubchannel(q.i iVar, q.k kVar) {
            this.f33514a = (q.i) k.p(iVar, "delegate");
            this.f33515b = (q.k) k.p(kVar, "healthListener");
        }

        @Override // io.grpc.util.d, io.grpc.q.i
        public C1107a c() {
            return super.c().d().d(q.f33436d, Boolean.TRUE).a();
        }

        @Override // io.grpc.util.d, io.grpc.q.i
        public void h(q.k kVar) {
            this.f33514a.h(new a(kVar));
        }

        @Override // io.grpc.util.d
        public q.i j() {
            return this.f33514a;
        }
    }

    public HealthProducerHelper(q.e eVar) {
        this.f33513a = (q.e) k.p(eVar, "helper");
    }

    @Override // io.grpc.util.c, io.grpc.q.e
    public q.i a(q.b bVar) {
        q.k kVar = (q.k) bVar.c(q.f33435c);
        q.i a10 = super.a(bVar);
        if (kVar != null && a10.c().b(q.f33436d) == null) {
            return new HealthProducerSubchannel(a10, kVar);
        }
        return a10;
    }

    @Override // io.grpc.util.c
    public q.e g() {
        return this.f33513a;
    }
}
