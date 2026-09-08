package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;

/* compiled from: DataFetcherGenerator.java */
/* loaded from: classes.dex */
public interface c {

    /* compiled from: DataFetcherGenerator.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(X2.b bVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource);

        void b(X2.b bVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, X2.b bVar2);

        void c();
    }

    void cancel();

    boolean d();
}
