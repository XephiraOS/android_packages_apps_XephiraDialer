package j9;

import java.util.concurrent.Executor;

/* compiled from: ServerCallExecutorSupplier.java */
/* loaded from: classes4.dex */
public interface G {
    <ReqT, RespT> Executor a(io.grpc.A<ReqT, RespT> a10, io.grpc.u uVar);
}
