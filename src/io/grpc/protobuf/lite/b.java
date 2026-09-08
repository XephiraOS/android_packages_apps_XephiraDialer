package io.grpc.protobuf.lite;

import com.google.common.base.k;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import io.grpc.MethodDescriptor;
import java.io.InputStream;
import java.lang.ref.Reference;

/* compiled from: ProtoLiteUtils.java */
/* loaded from: classes4.dex */
public final class b {
    static final int DEFAULT_MAX_MESSAGE_SIZE = 4194304;

    /* renamed from: a, reason: collision with root package name */
    public static volatile ExtensionRegistryLite f33429a = ExtensionRegistryLite.getEmptyRegistry();

    /* compiled from: ProtoLiteUtils.java */
    /* loaded from: classes4.dex */
    public static final class a<T extends MessageLite> implements MethodDescriptor.c {

        /* renamed from: d, reason: collision with root package name */
        public static final ThreadLocal<Reference<byte[]>> f33430d = new ThreadLocal<>();

        /* renamed from: a, reason: collision with root package name */
        public final Parser<T> f33431a;

        /* renamed from: b, reason: collision with root package name */
        public final T f33432b;

        /* renamed from: c, reason: collision with root package name */
        public final int f33433c;

        public a(T t10, int i10) {
            this.f33432b = (T) k.p(t10, "defaultInstance cannot be null");
            this.f33431a = (Parser<T>) t10.getParserForType();
            this.f33433c = i10;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x004b A[Catch: IOException -> 0x003b, TryCatch #2 {IOException -> 0x003b, blocks: (B:12:0x0017, B:14:0x001b, B:18:0x0025, B:20:0x002f, B:22:0x0037, B:27:0x004b, B:29:0x0055, B:33:0x0059, B:46:0x005f, B:47:0x007f, B:49:0x003e, B:51:0x0082), top: B:11:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0059 A[Catch: IOException -> 0x003b, TryCatch #2 {IOException -> 0x003b, blocks: (B:12:0x0017, B:14:0x001b, B:18:0x0025, B:20:0x002f, B:22:0x0037, B:27:0x004b, B:29:0x0055, B:33:0x0059, B:46:0x005f, B:47:0x007f, B:49:0x003e, B:51:0x0082), top: B:11:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x005f A[Catch: IOException -> 0x003b, TryCatch #2 {IOException -> 0x003b, blocks: (B:12:0x0017, B:14:0x001b, B:18:0x0025, B:20:0x002f, B:22:0x0037, B:27:0x004b, B:29:0x0055, B:33:0x0059, B:46:0x005f, B:47:0x007f, B:49:0x003e, B:51:0x0082), top: B:11:0x0017 }] */
        @Override // io.grpc.MethodDescriptor.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public T a(java.io.InputStream r6) {
            /*
                r5 = this;
                boolean r0 = r6 instanceof io.grpc.protobuf.lite.a
                if (r0 == 0) goto L17
                r0 = r6
                io.grpc.protobuf.lite.a r0 = (io.grpc.protobuf.lite.a) r0
                com.google.protobuf.Parser r0 = r0.c()
                com.google.protobuf.Parser<T extends com.google.protobuf.MessageLite> r1 = r5.f33431a
                if (r0 != r1) goto L17
                r0 = r6
                io.grpc.protobuf.lite.a r0 = (io.grpc.protobuf.lite.a) r0     // Catch: java.lang.IllegalStateException -> L17
                com.google.protobuf.MessageLite r5 = r0.a()     // Catch: java.lang.IllegalStateException -> L17
                return r5
            L17:
                boolean r0 = r6 instanceof j9.InterfaceC1189A     // Catch: java.io.IOException -> L3b
                if (r0 == 0) goto L85
                int r0 = r6.available()     // Catch: java.io.IOException -> L3b
                if (r0 <= 0) goto L80
                r1 = 4194304(0x400000, float:5.877472E-39)
                if (r0 > r1) goto L80
                java.lang.ThreadLocal<java.lang.ref.Reference<byte[]>> r1 = io.grpc.protobuf.lite.b.a.f33430d     // Catch: java.io.IOException -> L3b
                java.lang.Object r2 = r1.get()     // Catch: java.io.IOException -> L3b
                java.lang.ref.Reference r2 = (java.lang.ref.Reference) r2     // Catch: java.io.IOException -> L3b
                if (r2 == 0) goto L3e
                java.lang.Object r2 = r2.get()     // Catch: java.io.IOException -> L3b
                byte[] r2 = (byte[]) r2     // Catch: java.io.IOException -> L3b
                if (r2 == 0) goto L3e
                int r3 = r2.length     // Catch: java.io.IOException -> L3b
                if (r3 >= r0) goto L48
                goto L3e
            L3b:
                r5 = move-exception
                goto Lb0
            L3e:
                byte[] r2 = new byte[r0]     // Catch: java.io.IOException -> L3b
                java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference     // Catch: java.io.IOException -> L3b
                r3.<init>(r2)     // Catch: java.io.IOException -> L3b
                r1.set(r3)     // Catch: java.io.IOException -> L3b
            L48:
                r1 = r0
            L49:
                if (r1 <= 0) goto L57
                int r3 = r0 - r1
                int r3 = r6.read(r2, r3, r1)     // Catch: java.io.IOException -> L3b
                r4 = -1
                if (r3 != r4) goto L55
                goto L57
            L55:
                int r1 = r1 - r3
                goto L49
            L57:
                if (r1 != 0) goto L5f
                r1 = 0
                com.google.protobuf.CodedInputStream r0 = com.google.protobuf.CodedInputStream.newInstance(r2, r1, r0)     // Catch: java.io.IOException -> L3b
                goto L86
            L5f:
                int r5 = r0 - r1
                java.lang.RuntimeException r6 = new java.lang.RuntimeException     // Catch: java.io.IOException -> L3b
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L3b
                r1.<init>()     // Catch: java.io.IOException -> L3b
                java.lang.String r2 = "size inaccurate: "
                r1.append(r2)     // Catch: java.io.IOException -> L3b
                r1.append(r0)     // Catch: java.io.IOException -> L3b
                java.lang.String r0 = " != "
                r1.append(r0)     // Catch: java.io.IOException -> L3b
                r1.append(r5)     // Catch: java.io.IOException -> L3b
                java.lang.String r5 = r1.toString()     // Catch: java.io.IOException -> L3b
                r6.<init>(r5)     // Catch: java.io.IOException -> L3b
                throw r6     // Catch: java.io.IOException -> L3b
            L80:
                if (r0 != 0) goto L85
                T extends com.google.protobuf.MessageLite r5 = r5.f33432b     // Catch: java.io.IOException -> L3b
                return r5
            L85:
                r0 = 0
            L86:
                if (r0 != 0) goto L8c
                com.google.protobuf.CodedInputStream r0 = com.google.protobuf.CodedInputStream.newInstance(r6)
            L8c:
                r6 = 2147483647(0x7fffffff, float:NaN)
                r0.setSizeLimit(r6)
                int r6 = r5.f33433c
                if (r6 < 0) goto L99
                r0.setRecursionLimit(r6)
            L99:
                com.google.protobuf.MessageLite r5 = r5.d(r0)     // Catch: com.google.protobuf.InvalidProtocolBufferException -> L9e
                return r5
            L9e:
                r5 = move-exception
                io.grpc.Status r6 = io.grpc.Status.f32382s
                java.lang.String r0 = "Invalid protobuf byte sequence"
                io.grpc.Status r6 = r6.r(r0)
                io.grpc.Status r5 = r6.q(r5)
                io.grpc.StatusRuntimeException r5 = r5.c()
                throw r5
            Lb0:
                java.lang.RuntimeException r6 = new java.lang.RuntimeException
                r6.<init>(r5)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.protobuf.lite.b.a.a(java.io.InputStream):com.google.protobuf.MessageLite");
        }

        public final T d(CodedInputStream codedInputStream) {
            T parseFrom = this.f33431a.parseFrom(codedInputStream, b.f33429a);
            try {
                codedInputStream.checkLastTagWas(0);
                return parseFrom;
            } catch (InvalidProtocolBufferException e10) {
                e10.setUnfinishedMessage(parseFrom);
                throw e10;
            }
        }

        @Override // io.grpc.MethodDescriptor.c
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public InputStream b(T t10) {
            return new io.grpc.protobuf.lite.a(t10, this.f33431a);
        }
    }

    public static <T extends MessageLite> MethodDescriptor.c<T> a(T t10) {
        return new a(t10, -1);
    }
}
