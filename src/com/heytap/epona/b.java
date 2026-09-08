package com.heytap.epona;

/* compiled from: DynamicProvider.java */
/* loaded from: classes3.dex */
public interface b {
    Response a(Request request);

    default void b(Request request, a aVar) {
        aVar.O(a(request));
    }
}
