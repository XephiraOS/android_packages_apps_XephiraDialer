package io.grpc;

import io.grpc.u;
import java.nio.charset.Charset;

/* compiled from: InternalMetadata.java */
/* loaded from: classes4.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f33419a = Charset.forName("US-ASCII");

    /* renamed from: b, reason: collision with root package name */
    public static final com.google.common.io.a f33420b = u.f33500f;

    /* compiled from: InternalMetadata.java */
    /* loaded from: classes4.dex */
    public interface a<T> extends u.j<T> {
    }

    public static <T> u.g<T> a(String str, a<T> aVar) {
        boolean z10 = false;
        if (str != null && !str.isEmpty() && str.charAt(0) == ':') {
            z10 = true;
        }
        return u.g.e(str, z10, aVar);
    }

    public static u b(byte[]... bArr) {
        return new u(bArr);
    }

    public static byte[][] c(u uVar) {
        return uVar.p();
    }
}
