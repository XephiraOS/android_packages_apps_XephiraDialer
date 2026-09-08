package com.android.contacts.voicemail.impl.sync;

import B1.e;
import android.net.Network;
import android.telecom.PhoneAccountHandle;
import com.android.contacts.voicemail.impl.c;
import java.io.Closeable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class VvmNetworkRequest {

    /* loaded from: classes.dex */
    public static class RequestFailedException extends Exception {
        public RequestFailedException(Throwable th) {
            super(th);
        }
    }

    /* loaded from: classes.dex */
    public static class a extends e {

        /* renamed from: i, reason: collision with root package name */
        public final CompletableFuture<b> f18199i;

        public a(com.android.contacts.voicemail.impl.b bVar, PhoneAccountHandle phoneAccountHandle, c.b bVar2) {
            super(bVar, phoneAccountHandle, bVar2);
            this.f18199i = new CompletableFuture<>();
        }

        @Override // B1.e
        public void f(String str) {
            super.f(str);
            this.f18199i.complete(null);
        }

        public Future<b> i() {
            return this.f18199i;
        }

        @Override // B1.e, android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            this.f18199i.complete(new b(network, this));
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Closeable {

        /* renamed from: a, reason: collision with root package name */
        public final Network f18200a;

        /* renamed from: b, reason: collision with root package name */
        public final e f18201b;

        public Network a() {
            return this.f18200a;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f18201b.g();
        }

        public b(Network network, e eVar) {
            this.f18200a = network;
            this.f18201b = eVar;
        }
    }

    public static b a(com.android.contacts.voicemail.impl.b bVar, PhoneAccountHandle phoneAccountHandle, c.b bVar2) {
        a aVar = new a(bVar, phoneAccountHandle, bVar2);
        aVar.h();
        try {
            return aVar.i().get();
        } catch (InterruptedException | ExecutionException e10) {
            aVar.g();
            H7.b.c("VvmNetworkRequest", "can't get future network" + e10);
            throw new RequestFailedException(e10);
        }
    }
}
