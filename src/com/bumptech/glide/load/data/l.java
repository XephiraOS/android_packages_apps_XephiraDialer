package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: LocalUriFetcher.java */
/* loaded from: classes.dex */
public abstract class l<T> implements d<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f19434a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentResolver f19435b;

    /* renamed from: c, reason: collision with root package name */
    public T f19436c;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f19435b = contentResolver;
        this.f19434a = uri;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        T t10 = this.f19436c;
        if (t10 != null) {
            try {
                c(t10);
            } catch (IOException unused) {
            }
        }
    }

    public abstract void c(T t10);

    @Override // com.bumptech.glide.load.data.d
    public DataSource d() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void e(Priority priority, d.a<? super T> aVar) {
        try {
            T f10 = f(this.f19434a, this.f19435b);
            this.f19436c = f10;
            aVar.f(f10);
        } catch (FileNotFoundException e10) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e10);
            }
            aVar.c(e10);
        }
    }

    public abstract T f(Uri uri, ContentResolver contentResolver);

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }
}
