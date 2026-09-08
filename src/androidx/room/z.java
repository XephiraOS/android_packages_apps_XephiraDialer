package androidx.room;

import android.content.Context;
import android.util.Log;
import c0.C0545a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;

/* compiled from: SQLiteCopyOpenHelper.java */
/* loaded from: classes.dex */
public class z implements e0.h, n {

    /* renamed from: a, reason: collision with root package name */
    public final Context f11401a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11402b;

    /* renamed from: c, reason: collision with root package name */
    public final File f11403c;

    /* renamed from: d, reason: collision with root package name */
    public final Callable<InputStream> f11404d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11405e;

    /* renamed from: f, reason: collision with root package name */
    public final e0.h f11406f;

    /* renamed from: g, reason: collision with root package name */
    public m f11407g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f11408h;

    public z(Context context, String str, File file, Callable<InputStream> callable, int i10, e0.h hVar) {
        this.f11401a = context;
        this.f11402b = str;
        this.f11403c = file;
        this.f11404d = callable;
        this.f11405e = i10;
        this.f11406f = hVar;
    }

    @Override // e0.h
    public synchronized e0.g M() {
        try {
            if (!this.f11408h) {
                g(true);
                this.f11408h = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f11406f.M();
    }

    @Override // androidx.room.n
    public e0.h a() {
        return this.f11406f;
    }

    public final void c(File file, boolean z10) {
        ReadableByteChannel newChannel;
        if (this.f11402b != null) {
            newChannel = Channels.newChannel(this.f11401a.getAssets().open(this.f11402b));
        } else if (this.f11403c != null) {
            newChannel = new FileInputStream(this.f11403c).getChannel();
        } else {
            Callable<InputStream> callable = this.f11404d;
            if (callable != null) {
                try {
                    newChannel = Channels.newChannel(callable.call());
                } catch (Exception e10) {
                    throw new IOException("inputStreamCallable exception on call", e10);
                }
            } else {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f11401a.getCacheDir());
        createTempFile.deleteOnExit();
        c0.d.a(newChannel, new FileOutputStream(createTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        e(createTempFile, z10);
        if (createTempFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    @Override // e0.h, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f11406f.close();
        this.f11408h = false;
    }

    public final void e(File file, boolean z10) {
        m mVar = this.f11407g;
        if (mVar != null) {
            mVar.getClass();
        }
    }

    public void f(m mVar) {
        this.f11407g = mVar;
    }

    public final void g(boolean z10) {
        boolean z11;
        String databaseName = getDatabaseName();
        File databasePath = this.f11401a.getDatabasePath(databaseName);
        m mVar = this.f11407g;
        if (mVar != null && !mVar.f11347l) {
            z11 = false;
        } else {
            z11 = true;
        }
        C0545a c0545a = new C0545a(databaseName, this.f11401a.getFilesDir(), z11);
        try {
            c0545a.b();
            if (!databasePath.exists()) {
                try {
                    c(databasePath, z10);
                    c0545a.c();
                    return;
                } catch (IOException e10) {
                    throw new RuntimeException("Unable to copy database file.", e10);
                }
            }
            if (this.f11407g == null) {
                c0545a.c();
                return;
            }
            try {
                int c10 = c0.c.c(databasePath);
                int i10 = this.f11405e;
                if (c10 == i10) {
                    c0545a.c();
                    return;
                }
                if (this.f11407g.a(c10, i10)) {
                    c0545a.c();
                    return;
                }
                if (this.f11401a.deleteDatabase(databaseName)) {
                    try {
                        c(databasePath, z10);
                    } catch (IOException e11) {
                        Log.w("ROOM", "Unable to copy database file.", e11);
                    }
                } else {
                    Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                }
                c0545a.c();
                return;
            } catch (IOException e12) {
                Log.w("ROOM", "Unable to read database version.", e12);
                c0545a.c();
                return;
            }
        } catch (Throwable th) {
            c0545a.c();
            throw th;
        }
        c0545a.c();
        throw th;
    }

    @Override // e0.h
    public String getDatabaseName() {
        return this.f11406f.getDatabaseName();
    }

    @Override // e0.h
    public void setWriteAheadLoggingEnabled(boolean z10) {
        this.f11406f.setWriteAheadLoggingEnabled(z10);
    }
}
