package f0;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import android.util.Pair;
import e0.C0962a;
import e0.C0963b;
import e0.g;
import e0.j;
import e0.k;
import java.util.List;

/* compiled from: FrameworkSQLiteDatabase.java */
/* renamed from: f0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0992a implements g {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f31654b = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f31655c = new String[0];

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f31656a;

    /* compiled from: FrameworkSQLiteDatabase.java */
    /* renamed from: f0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0296a implements SQLiteDatabase.CursorFactory {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f31657a;

        public C0296a(j jVar) {
            this.f31657a = jVar;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f31657a.a(new d(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    /* compiled from: FrameworkSQLiteDatabase.java */
    /* renamed from: f0.a$b */
    /* loaded from: classes.dex */
    public class b implements SQLiteDatabase.CursorFactory {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f31659a;

        public b(j jVar) {
            this.f31659a = jVar;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f31659a.a(new d(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    public C0992a(SQLiteDatabase sQLiteDatabase) {
        this.f31656a = sQLiteDatabase;
    }

    @Override // e0.g
    public void D() {
        this.f31656a.setTransactionSuccessful();
    }

    @Override // e0.g
    public void F() {
        this.f31656a.beginTransactionNonExclusive();
    }

    @Override // e0.g
    public void P() {
        this.f31656a.endTransaction();
    }

    public boolean a(SQLiteDatabase sQLiteDatabase) {
        if (this.f31656a == sQLiteDatabase) {
            return true;
        }
        return false;
    }

    @Override // e0.g
    public Cursor b(String str) {
        return j(new C0962a(str));
    }

    @Override // e0.g
    public Cursor b0(j jVar, CancellationSignal cancellationSignal) {
        return C0963b.c(this.f31656a, jVar.c(), f31655c, null, cancellationSignal, new b(jVar));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f31656a.close();
    }

    @Override // e0.g
    public String d() {
        return this.f31656a.getPath();
    }

    @Override // e0.g
    public boolean e0() {
        return this.f31656a.inTransaction();
    }

    @Override // e0.g
    public void h() {
        this.f31656a.beginTransaction();
    }

    @Override // e0.g
    public List<Pair<String, String>> i() {
        return this.f31656a.getAttachedDbs();
    }

    @Override // e0.g
    public boolean isOpen() {
        return this.f31656a.isOpen();
    }

    @Override // e0.g
    public Cursor j(j jVar) {
        return this.f31656a.rawQueryWithFactory(new C0296a(jVar), jVar.c(), f31655c, null);
    }

    @Override // e0.g
    public boolean k0() {
        return C0963b.b(this.f31656a);
    }

    @Override // e0.g
    public void m(String str) {
        this.f31656a.execSQL(str);
    }

    @Override // e0.g
    public k q(String str) {
        return new e(this.f31656a.compileStatement(str));
    }
}
