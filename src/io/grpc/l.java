package io.grpc;

import com.heytap.accessory.constant.AFConstants;
import com.oplus.backup.sdk.common.utils.Constants;
import io.grpc.C1107a;
import io.grpc.q;
import j9.InterfaceC1196f;

/* compiled from: InternalConfigSelector.java */
/* loaded from: classes4.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final C1107a.c<l> f33413a = C1107a.c.a("internal:io.grpc.config-selector");

    /* compiled from: InternalConfigSelector.java */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Status f33414a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f33415b;

        /* renamed from: c, reason: collision with root package name */
        public InterfaceC1196f f33416c;

        /* compiled from: InternalConfigSelector.java */
        /* loaded from: classes4.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public Object f33417a;

            /* renamed from: b, reason: collision with root package name */
            public InterfaceC1196f f33418b;

            public a() {
            }

            public b a() {
                boolean z10;
                if (this.f33417a != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                com.google.common.base.k.v(z10, "config is not set");
                return new b(Status.f32368e, this.f33417a, this.f33418b);
            }

            public a b(Object obj) {
                this.f33417a = com.google.common.base.k.p(obj, Constants.MessagerConstants.CONFIG_KEY);
                return this;
            }
        }

        public static a d() {
            return new a();
        }

        public Object a() {
            return this.f33415b;
        }

        public InterfaceC1196f b() {
            return this.f33416c;
        }

        public Status c() {
            return this.f33414a;
        }

        public b(Status status, Object obj, InterfaceC1196f interfaceC1196f) {
            this.f33414a = (Status) com.google.common.base.k.p(status, AFConstants.EXTRA_STATUS);
            this.f33415b = obj;
            this.f33416c = interfaceC1196f;
        }
    }

    public abstract b a(q.g gVar);
}
