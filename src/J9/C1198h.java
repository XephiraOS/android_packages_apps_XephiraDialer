package j9;

import io.grpc.Context;
import j9.AbstractC1193c;
import java.util.concurrent.Executor;

/* compiled from: CompositeCallCredentials.java */
/* renamed from: j9.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1198h extends AbstractC1193c {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC1193c f34016a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC1193c f34017b;

    /* compiled from: CompositeCallCredentials.java */
    /* renamed from: j9.h$a */
    /* loaded from: classes4.dex */
    public final class a extends AbstractC1193c.a {

        /* renamed from: a, reason: collision with root package name */
        public final AbstractC1193c.b f34018a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f34019b;

        /* renamed from: c, reason: collision with root package name */
        public final AbstractC1193c.a f34020c;

        /* renamed from: d, reason: collision with root package name */
        public final Context f34021d;

        public a(AbstractC1193c.b bVar, Executor executor, AbstractC1193c.a aVar, Context context) {
            this.f34018a = bVar;
            this.f34019b = executor;
            this.f34020c = (AbstractC1193c.a) com.google.common.base.k.p(aVar, "delegate");
            this.f34021d = (Context) com.google.common.base.k.p(context, "context");
        }
    }

    public C1198h(AbstractC1193c abstractC1193c, AbstractC1193c abstractC1193c2) {
        this.f34016a = (AbstractC1193c) com.google.common.base.k.p(abstractC1193c, "creds1");
        this.f34017b = (AbstractC1193c) com.google.common.base.k.p(abstractC1193c2, "creds2");
    }

    @Override // j9.AbstractC1193c
    public void a(AbstractC1193c.b bVar, Executor executor, AbstractC1193c.a aVar) {
        this.f34016a.a(bVar, executor, new a(bVar, executor, aVar, Context.l()));
    }
}
