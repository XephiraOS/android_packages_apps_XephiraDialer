package com.oplus.epona;

/* compiled from: DynamicProvider.java */
/* loaded from: classes3.dex */
public interface c {
    Response a(Request request);

    default void b(Request request, Call$Callback call$Callback) {
        call$Callback.onReceive(a(request));
    }

    String getName();
}
