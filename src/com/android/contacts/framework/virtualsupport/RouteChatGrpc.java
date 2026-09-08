package com.android.contacts.framework.virtualsupport;

import com.google.protobuf.Any;
import com.google.protobuf.Descriptors;
import io.grpc.C1108b;
import io.grpc.MethodDescriptor;
import io.grpc.stub.g;
import io.grpc.stub.h;
import j9.AbstractC1194d;
import j9.I;
import j9.InterfaceC1192b;
import j9.L;
import k9.C1219a;

/* loaded from: classes.dex */
public final class RouteChatGrpc {
    private static final int METHODID_CHAT = 0;
    public static final String SERVICE_NAME = "RouteChat";
    private static volatile MethodDescriptor<Any, Any> getChatMethod;
    private static volatile L serviceDescriptor;

    /* loaded from: classes.dex */
    public static final class MethodHandlers<Req, Resp> implements g.d, g.a<Req, Resp> {
        private final int methodId;
        private final RouteChatImplBase serviceImpl;

        public MethodHandlers(RouteChatImplBase routeChatImplBase, int i10) {
            this.serviceImpl = routeChatImplBase;
            this.methodId = i10;
        }

        public void invoke(Req req, h<Resp> hVar) {
            throw new AssertionError();
        }

        @Override // io.grpc.stub.g.d
        public h<Req> invoke(h<Resp> hVar) {
            if (this.methodId == 0) {
                return (h<Req>) this.serviceImpl.chat(hVar);
            }
            throw new AssertionError();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class RouteChatBaseDescriptorSupplier {
        public Descriptors.FileDescriptor getFileDescriptor() {
            return GrpcInfo.getDescriptor();
        }

        public Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName(RouteChatGrpc.SERVICE_NAME);
        }
    }

    /* loaded from: classes.dex */
    public static final class RouteChatBlockingStub extends io.grpc.stub.a<RouteChatBlockingStub> {
        private RouteChatBlockingStub(AbstractC1194d abstractC1194d) {
            super(abstractC1194d);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.stub.a
        public RouteChatBlockingStub build(AbstractC1194d abstractC1194d, C1108b c1108b) {
            return new RouteChatBlockingStub(abstractC1194d, c1108b);
        }

        private RouteChatBlockingStub(AbstractC1194d abstractC1194d, C1108b c1108b) {
            super(abstractC1194d, c1108b);
        }
    }

    /* loaded from: classes.dex */
    public static final class RouteChatFileDescriptorSupplier extends RouteChatBaseDescriptorSupplier {
    }

    /* loaded from: classes.dex */
    public static final class RouteChatFutureStub extends io.grpc.stub.a<RouteChatFutureStub> {
        private RouteChatFutureStub(AbstractC1194d abstractC1194d) {
            super(abstractC1194d);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.stub.a
        public RouteChatFutureStub build(AbstractC1194d abstractC1194d, C1108b c1108b) {
            return new RouteChatFutureStub(abstractC1194d, c1108b);
        }

        private RouteChatFutureStub(AbstractC1194d abstractC1194d, C1108b c1108b) {
            super(abstractC1194d, c1108b);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class RouteChatImplBase implements InterfaceC1192b {
        @Override // j9.InterfaceC1192b
        public final I bindService() {
            return I.a(RouteChatGrpc.getServiceDescriptor()).a(RouteChatGrpc.getChatMethod(), io.grpc.stub.g.a(new MethodHandlers(this, 0))).c();
        }

        public h<Any> chat(h<Any> hVar) {
            return io.grpc.stub.g.b(RouteChatGrpc.getChatMethod(), hVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class RouteChatMethodDescriptorSupplier extends RouteChatBaseDescriptorSupplier {
        private final String methodName;

        public RouteChatMethodDescriptorSupplier(String str) {
            this.methodName = str;
        }

        public Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(this.methodName);
        }
    }

    /* loaded from: classes.dex */
    public static final class RouteChatStub extends io.grpc.stub.a<RouteChatStub> {
        public h<Any> chat(h<Any> hVar) {
            return io.grpc.stub.d.a(getChannel().b(RouteChatGrpc.getChatMethod(), getCallOptions()), hVar);
        }

        private RouteChatStub(AbstractC1194d abstractC1194d) {
            super(abstractC1194d);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.stub.a
        public RouteChatStub build(AbstractC1194d abstractC1194d, C1108b c1108b) {
            return new RouteChatStub(abstractC1194d, c1108b);
        }

        private RouteChatStub(AbstractC1194d abstractC1194d, C1108b c1108b) {
            super(abstractC1194d, c1108b);
        }
    }

    private RouteChatGrpc() {
    }

    public static MethodDescriptor<Any, Any> getChatMethod() {
        MethodDescriptor<Any, Any> methodDescriptor = getChatMethod;
        if (methodDescriptor == null) {
            synchronized (RouteChatGrpc.class) {
                try {
                    methodDescriptor = getChatMethod;
                    if (methodDescriptor == null) {
                        methodDescriptor = MethodDescriptor.f().g(MethodDescriptor.MethodType.BIDI_STREAMING).b(MethodDescriptor.b(SERVICE_NAME, "chat")).e(true).c(C1219a.a(Any.getDefaultInstance())).d(C1219a.a(Any.getDefaultInstance())).f(new RouteChatMethodDescriptorSupplier("chat")).a();
                        getChatMethod = methodDescriptor;
                    }
                } finally {
                }
            }
        }
        return methodDescriptor;
    }

    public static L getServiceDescriptor() {
        L l10 = serviceDescriptor;
        if (l10 == null) {
            synchronized (RouteChatGrpc.class) {
                try {
                    l10 = serviceDescriptor;
                    if (l10 == null) {
                        l10 = L.c(SERVICE_NAME).i(new RouteChatFileDescriptorSupplier()).f(getChatMethod()).g();
                        serviceDescriptor = l10;
                    }
                } finally {
                }
            }
        }
        return l10;
    }

    public static RouteChatBlockingStub newBlockingStub(AbstractC1194d abstractC1194d) {
        return new RouteChatBlockingStub(abstractC1194d);
    }

    public static RouteChatFutureStub newFutureStub(AbstractC1194d abstractC1194d) {
        return new RouteChatFutureStub(abstractC1194d);
    }

    public static RouteChatStub newStub(AbstractC1194d abstractC1194d) {
        return new RouteChatStub(abstractC1194d);
    }
}
