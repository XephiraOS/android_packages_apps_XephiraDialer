package f0;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import e0.C0963b;
import e0.g;
import e0.h;
import java.io.File;

/* compiled from: FrameworkSQLiteOpenHelper.java */
/* renamed from: f0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0993b implements h {

    /* renamed from: a, reason: collision with root package name */
    public final Context f31661a;

    /* renamed from: b, reason: collision with root package name */
    public final String f31662b;

    /* renamed from: c, reason: collision with root package name */
    public final h.a f31663c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f31664d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f31665e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public a f31666f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f31667g;

    /* compiled from: FrameworkSQLiteOpenHelper.java */
    /* renamed from: f0.b$a */
    /* loaded from: classes.dex */
    public static class a extends SQLiteOpenHelper {

        /* renamed from: a, reason: collision with root package name */
        public final C0992a[] f31668a;

        /* renamed from: b, reason: collision with root package name */
        public final h.a f31669b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f31670c;

        /* compiled from: FrameworkSQLiteOpenHelper.java */
        /* renamed from: f0.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0297a implements DatabaseErrorHandler {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h.a f31671a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C0992a[] f31672b;

            public C0297a(h.a aVar, C0992a[] c0992aArr) {
                this.f31671a = aVar;
                this.f31672b = c0992aArr;
            }

            @Override // android.database.DatabaseErrorHandler
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                this.f31671a.c(a.c(this.f31672b, sQLiteDatabase));
            }
        }

        public a(Context context, String str, C0992a[] c0992aArr, h.a aVar) {
            super(context, str, null, aVar.f30547a, new C0297a(aVar, c0992aArr));
            this.f31669b = aVar;
            this.f31668a = c0992aArr;
        }

        public static C0992a c(C0992a[] c0992aArr, SQLiteDatabase sQLiteDatabase) {
            C0992a c0992a = c0992aArr[0];
            if (c0992a == null || !c0992a.a(sQLiteDatabase)) {
                c0992aArr[0] = new C0992a(sQLiteDatabase);
            }
            return c0992aArr[0];
        }

        public C0992a a(SQLiteDatabase sQLiteDatabase) {
            return c(this.f31668a, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.f31668a[0] = null;
        }

        public synchronized g e() {
            this.f31670c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.f31670c) {
                close();
                return e();
            }
            return a(writableDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f31669b.b(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f31669b.d(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            this.f31670c = true;
            this.f31669b.e(a(sQLiteDatabase), i10, i11);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.f31670c) {
                this.f31669b.f(a(sQLiteDatabase));
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            this.f31670c = true;
            this.f31669b.g(a(sQLiteDatabase), i10, i11);
        }
    }

    public C0993b(Context context, String str, h.a aVar, boolean z10) {
        this.f31661a = context;
        this.f31662b = str;
        this.f31663c = aVar;
        this.f31664d = z10;
    }

    @Override // e0.h
    public g M() {
        return a().e();
    }

    public final a a() {
        a aVar;
        synchronized (this.f31665e) {
            try {
                if (this.f31666f == null) {
                    C0992a[] c0992aArr = new C0992a[1];
                    if (this.f31662b != null && this.f31664d) {
                        this.f31666f = new a(this.f31661a, new File(e0.d.a(this.f31661a), this.f31662b).getAbsolutePath(), c0992aArr, this.f31663c);
                    } else {
                        this.f31666f = new a(this.f31661a, this.f31662b, c0992aArr, this.f31663c);
                    }
                    C0963b.d(this.f31666f, this.f31667g);
                }
                aVar = this.f31666f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    @Override // e0.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a().close();
    }

    @Override // e0.h
    public String getDatabaseName() {
        return this.f31662b;
    }

    @Override // e0.h
    public void setWriteAheadLoggingEnabled(boolean z10) {
        synchronized (this.f31665e) {
            try {
                a aVar = this.f31666f;
                if (aVar != null) {
                    C0963b.d(aVar, z10);
                }
                this.f31667g = z10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
