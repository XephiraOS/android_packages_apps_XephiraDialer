package io.grpc;

import com.android.incallui.OplusAutoRedialNotificationUI;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes4.dex */
public final class MethodDescriptor<ReqT, RespT> {

    /* renamed from: a, reason: collision with root package name */
    public final MethodType f32339a;

    /* renamed from: b, reason: collision with root package name */
    public final String f32340b;

    /* renamed from: c, reason: collision with root package name */
    public final String f32341c;

    /* renamed from: d, reason: collision with root package name */
    public final c<ReqT> f32342d;

    /* renamed from: e, reason: collision with root package name */
    public final c<RespT> f32343e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f32344f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f32345g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f32346h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f32347i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicReferenceArray<Object> f32348j;

    /* loaded from: classes4.dex */
    public enum MethodType {
        UNARY,
        CLIENT_STREAMING,
        SERVER_STREAMING,
        BIDI_STREAMING,
        UNKNOWN;

        public final boolean a() {
            if (this != UNARY && this != SERVER_STREAMING) {
                return false;
            }
            return true;
        }

        public final boolean b() {
            if (this != UNARY && this != CLIENT_STREAMING) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public static final class b<ReqT, RespT> {

        /* renamed from: a, reason: collision with root package name */
        public c<ReqT> f32355a;

        /* renamed from: b, reason: collision with root package name */
        public c<RespT> f32356b;

        /* renamed from: c, reason: collision with root package name */
        public MethodType f32357c;

        /* renamed from: d, reason: collision with root package name */
        public String f32358d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f32359e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f32360f;

        /* renamed from: g, reason: collision with root package name */
        public Object f32361g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f32362h;

        public b() {
        }

        public MethodDescriptor<ReqT, RespT> a() {
            return new MethodDescriptor<>(this.f32357c, this.f32358d, this.f32355a, this.f32356b, this.f32361g, this.f32359e, this.f32360f, this.f32362h);
        }

        public b<ReqT, RespT> b(String str) {
            this.f32358d = str;
            return this;
        }

        public b<ReqT, RespT> c(c<ReqT> cVar) {
            this.f32355a = cVar;
            return this;
        }

        public b<ReqT, RespT> d(c<RespT> cVar) {
            this.f32356b = cVar;
            return this;
        }

        public b<ReqT, RespT> e(boolean z10) {
            this.f32362h = z10;
            return this;
        }

        public b<ReqT, RespT> f(Object obj) {
            this.f32361g = obj;
            return this;
        }

        public b<ReqT, RespT> g(MethodType methodType) {
            this.f32357c = methodType;
            return this;
        }
    }

    /* loaded from: classes4.dex */
    public interface c<T> {
        T a(InputStream inputStream);

        InputStream b(T t10);
    }

    public static String a(String str) {
        int lastIndexOf = ((String) com.google.common.base.k.p(str, "fullMethodName")).lastIndexOf(47);
        if (lastIndexOf == -1) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static String b(String str, String str2) {
        return ((String) com.google.common.base.k.p(str, "fullServiceName")) + "/" + ((String) com.google.common.base.k.p(str2, "methodName"));
    }

    public static <ReqT, RespT> b<ReqT, RespT> f() {
        return g(null, null);
    }

    public static <ReqT, RespT> b<ReqT, RespT> g(c<ReqT> cVar, c<RespT> cVar2) {
        return new b().c(cVar).d(cVar2);
    }

    public String c() {
        return this.f32340b;
    }

    public String d() {
        return this.f32341c;
    }

    public MethodType e() {
        return this.f32339a;
    }

    public ReqT h(InputStream inputStream) {
        return this.f32342d.a(inputStream);
    }

    public RespT i(InputStream inputStream) {
        return this.f32343e.a(inputStream);
    }

    public InputStream j(ReqT reqt) {
        return this.f32342d.b(reqt);
    }

    public InputStream k(RespT respt) {
        return this.f32343e.b(respt);
    }

    public String toString() {
        return com.google.common.base.f.c(this).d("fullMethodName", this.f32340b).d(OplusAutoRedialNotificationUI.TYPE, this.f32339a).e("idempotent", this.f32345g).e("safe", this.f32346h).e("sampledToLocalTracing", this.f32347i).d("requestMarshaller", this.f32342d).d("responseMarshaller", this.f32343e).d("schemaDescriptor", this.f32344f).m().toString();
    }

    public MethodDescriptor(MethodType methodType, String str, c<ReqT> cVar, c<RespT> cVar2, Object obj, boolean z10, boolean z11, boolean z12) {
        this.f32348j = new AtomicReferenceArray<>(2);
        this.f32339a = (MethodType) com.google.common.base.k.p(methodType, OplusAutoRedialNotificationUI.TYPE);
        this.f32340b = (String) com.google.common.base.k.p(str, "fullMethodName");
        this.f32341c = a(str);
        this.f32342d = (c) com.google.common.base.k.p(cVar, "requestMarshaller");
        this.f32343e = (c) com.google.common.base.k.p(cVar2, "responseMarshaller");
        this.f32344f = obj;
        this.f32345g = z10;
        this.f32346h = z11;
        this.f32347i = z12;
    }
}
