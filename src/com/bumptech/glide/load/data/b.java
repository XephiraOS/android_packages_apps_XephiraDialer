package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import java.io.IOException;

/* compiled from: AssetPathFetcher.java */
/* loaded from: classes.dex */
public abstract class b<T> implements d<T> {

    /* renamed from: a, reason: collision with root package name */
    public final String f19410a;

    /* renamed from: b, reason: collision with root package name */
    public final AssetManager f19411b;

    /* renamed from: c, reason: collision with root package name */
    public T f19412c;

    public b(AssetManager assetManager, String str) {
        this.f19411b = assetManager;
        this.f19410a = str;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        T t10 = this.f19412c;
        if (t10 == null) {
            return;
        }
        try {
            c(t10);
        } catch (IOException unused) {
        }
    }

    public abstract void c(T t10);

    @Override // com.bumptech.glide.load.data.d
    public DataSource d() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public void e(Priority priority, d.a<? super T> aVar) {
        try {
            T f10 = f(this.f19411b, this.f19410a);
            this.f19412c = f10;
            aVar.f(f10);
        } catch (IOException e10) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e10);
            }
            aVar.c(e10);
        }
    }

    public abstract T f(AssetManager assetManager, String str);

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }
}
