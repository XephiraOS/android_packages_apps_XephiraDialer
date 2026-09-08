package com.oplus.ocs.icdf.grpcchannel.inner;

import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import io.grpc.internal.u0;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class i implements u0.a {

    /* renamed from: a, reason: collision with root package name */
    private InputStream f28681a;

    public i(InputStream inputStream) {
        if (inputStream == null) {
            ICDFLog.i("ICDF.GrpcMessageProducer", "construct OAFMessageProducer for empty message.");
        }
        this.f28681a = inputStream;
    }

    @Override // io.grpc.internal.u0.a
    public InputStream next() {
        InputStream inputStream = this.f28681a;
        this.f28681a = null;
        return inputStream;
    }
}
