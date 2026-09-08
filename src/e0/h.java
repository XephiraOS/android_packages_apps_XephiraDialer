package e0;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* compiled from: SupportSQLiteOpenHelper.java */
/* loaded from: classes.dex */
public interface h extends Closeable {

    /* compiled from: SupportSQLiteOpenHelper.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Context f30548a;

        /* renamed from: b, reason: collision with root package name */
        public final String f30549b;

        /* renamed from: c, reason: collision with root package name */
        public final a f30550c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f30551d;

        /* compiled from: SupportSQLiteOpenHelper.java */
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public Context f30552a;

            /* renamed from: b, reason: collision with root package name */
            public String f30553b;

            /* renamed from: c, reason: collision with root package name */
            public a f30554c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f30555d;

            public a(Context context) {
                this.f30552a = context;
            }

            public b a() {
                if (this.f30554c != null) {
                    if (this.f30552a != null) {
                        if (this.f30555d && TextUtils.isEmpty(this.f30553b)) {
                            throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                        }
                        return new b(this.f30552a, this.f30553b, this.f30554c, this.f30555d);
                    }
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                }
                throw new IllegalArgumentException("Must set a callback to create the configuration.");
            }

            public a b(a aVar) {
                this.f30554c = aVar;
                return this;
            }

            public a c(String str) {
                this.f30553b = str;
                return this;
            }
        }

        public b(Context context, String str, a aVar, boolean z10) {
            this.f30548a = context;
            this.f30549b = str;
            this.f30550c = aVar;
            this.f30551d = z10;
        }

        public static a a(Context context) {
            return new a(context);
        }
    }

    /* compiled from: SupportSQLiteOpenHelper.java */
    /* loaded from: classes.dex */
    public interface c {
        h a(b bVar);
    }

    g M();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    void setWriteAheadLoggingEnabled(boolean z10);

    /* compiled from: SupportSQLiteOpenHelper.java */
    /* loaded from: classes.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f30547a;

        public a(int i10) {
            this.f30547a = i10;
        }

        public final void a(String str) {
            if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
                Log.w("SupportSQLite", "deleting the database file: " + str);
                try {
                    C0963b.a(new File(str));
                } catch (Exception e10) {
                    Log.w("SupportSQLite", "delete failed: ", e10);
                }
            }
        }

        public void c(g gVar) {
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + gVar.d());
            if (!gVar.isOpen()) {
                a(gVar.d());
                return;
            }
            List<Pair<String, String>> list = null;
            try {
                try {
                    list = gVar.i();
                } catch (SQLiteException unused) {
                }
                try {
                    gVar.close();
                } catch (IOException unused2) {
                }
            } finally {
                if (list != null) {
                    Iterator<Pair<String, String>> it = list.iterator();
                    while (it.hasNext()) {
                        a((String) it.next().second);
                    }
                } else {
                    a(gVar.d());
                }
            }
        }

        public abstract void d(g gVar);

        public abstract void e(g gVar, int i10, int i11);

        public abstract void g(g gVar, int i10, int i11);

        public void b(g gVar) {
        }

        public void f(g gVar) {
        }
    }
}
