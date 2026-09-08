package io.grpc;

import io.grpc.AbstractC1109c;
import j9.AbstractC1194d;
import j9.InterfaceC1196f;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: ClientInterceptors.java */
/* renamed from: io.grpc.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1111e {

    /* renamed from: a, reason: collision with root package name */
    public static final AbstractC1109c<Object, Object> f32439a = new a();

    /* compiled from: ClientInterceptors.java */
    /* renamed from: io.grpc.e$b */
    /* loaded from: classes4.dex */
    public static class b extends AbstractC1194d {

        /* renamed from: a, reason: collision with root package name */
        public final AbstractC1194d f32440a;

        /* renamed from: b, reason: collision with root package name */
        public final InterfaceC1196f f32441b;

        public /* synthetic */ b(AbstractC1194d abstractC1194d, InterfaceC1196f interfaceC1196f, C1110d c1110d) {
            this(abstractC1194d, interfaceC1196f);
        }

        @Override // j9.AbstractC1194d
        public String a() {
            return this.f32440a.a();
        }

        @Override // j9.AbstractC1194d
        public <ReqT, RespT> AbstractC1109c<ReqT, RespT> b(MethodDescriptor<ReqT, RespT> methodDescriptor, C1108b c1108b) {
            return this.f32441b.a(methodDescriptor, c1108b, this.f32440a);
        }

        public b(AbstractC1194d abstractC1194d, InterfaceC1196f interfaceC1196f) {
            this.f32440a = abstractC1194d;
            this.f32441b = (InterfaceC1196f) com.google.common.base.k.p(interfaceC1196f, "interceptor");
        }
    }

    public static AbstractC1194d a(AbstractC1194d abstractC1194d, List<? extends InterfaceC1196f> list) {
        com.google.common.base.k.p(abstractC1194d, "channel");
        Iterator<? extends InterfaceC1196f> it = list.iterator();
        while (it.hasNext()) {
            abstractC1194d = new b(abstractC1194d, it.next(), null);
        }
        return abstractC1194d;
    }

    public static AbstractC1194d b(AbstractC1194d abstractC1194d, InterfaceC1196f... interfaceC1196fArr) {
        return a(abstractC1194d, Arrays.asList(interfaceC1196fArr));
    }

    /* compiled from: ClientInterceptors.java */
    /* renamed from: io.grpc.e$a */
    /* loaded from: classes4.dex */
    public class a extends AbstractC1109c<Object, Object> {
        @Override // io.grpc.AbstractC1109c
        public void c(int i10) {
        }

        @Override // io.grpc.AbstractC1109c
        public void d(Object obj) {
        }

        @Override // io.grpc.AbstractC1109c
        public void b() {
        }

        @Override // io.grpc.AbstractC1109c
        public void a(String str, Throwable th) {
        }

        @Override // io.grpc.AbstractC1109c
        public void e(AbstractC1109c.a<Object> aVar, u uVar) {
        }
    }
}
