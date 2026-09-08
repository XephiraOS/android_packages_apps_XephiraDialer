package f0;

import android.database.sqlite.SQLiteProgram;
import e0.i;

/* compiled from: FrameworkSQLiteProgram.java */
/* loaded from: classes.dex */
public class d implements i {

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteProgram f31673a;

    public d(SQLiteProgram sQLiteProgram) {
        this.f31673a = sQLiteProgram;
    }

    @Override // e0.i
    public void C(int i10, long j10) {
        this.f31673a.bindLong(i10, j10);
    }

    @Override // e0.i
    public void H(int i10, byte[] bArr) {
        this.f31673a.bindBlob(i10, bArr);
    }

    @Override // e0.i
    public void Y(int i10) {
        this.f31673a.bindNull(i10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f31673a.close();
    }

    @Override // e0.i
    public void n(int i10, String str) {
        this.f31673a.bindString(i10, str);
    }

    @Override // e0.i
    public void t(int i10, double d10) {
        this.f31673a.bindDouble(i10, d10);
    }
}
