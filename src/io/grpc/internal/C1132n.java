package io.grpc.internal;

import io.grpc.ConnectivityState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: ConnectivityStateManager.java */
/* renamed from: io.grpc.internal.n, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1132n {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<a> f33263a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public volatile ConnectivityState f33264b = ConnectivityState.IDLE;

    /* compiled from: ConnectivityStateManager.java */
    /* renamed from: io.grpc.internal.n$a */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f33265a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f33266b;

        public void a() {
            this.f33266b.execute(this.f33265a);
        }
    }

    public void a(ConnectivityState connectivityState) {
        com.google.common.base.k.p(connectivityState, "newState");
        if (this.f33264b != connectivityState && this.f33264b != ConnectivityState.SHUTDOWN) {
            this.f33264b = connectivityState;
            if (this.f33263a.isEmpty()) {
                return;
            }
            ArrayList<a> arrayList = this.f33263a;
            this.f33263a = new ArrayList<>();
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }
}
