package androidx.room;

import android.database.Cursor;
import b0.AbstractC0515b;
import e0.C0962a;
import e0.h;
import java.util.Iterator;
import java.util.List;

/* compiled from: RoomOpenHelper.java */
/* loaded from: classes.dex */
public class x extends h.a {

    /* renamed from: b, reason: collision with root package name */
    public m f11385b;

    /* renamed from: c, reason: collision with root package name */
    public final a f11386c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11387d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11388e;

    /* compiled from: RoomOpenHelper.java */
    /* loaded from: classes.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f11389a;

        public a(int i10) {
            this.f11389a = i10;
        }

        public abstract void a(e0.g gVar);

        public abstract void b(e0.g gVar);

        public abstract void c(e0.g gVar);

        public abstract void d(e0.g gVar);

        public abstract void e(e0.g gVar);

        public abstract void f(e0.g gVar);

        public abstract b g(e0.g gVar);
    }

    /* compiled from: RoomOpenHelper.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f11390a;

        /* renamed from: b, reason: collision with root package name */
        public final String f11391b;

        public b(boolean z10, String str) {
            this.f11390a = z10;
            this.f11391b = str;
        }
    }

    public x(m mVar, a aVar, String str, String str2) {
        super(aVar.f11389a);
        this.f11385b = mVar;
        this.f11386c = aVar;
        this.f11387d = str;
        this.f11388e = str2;
    }

    public static boolean j(e0.g gVar) {
        Cursor b10 = gVar.b("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z10 = false;
            if (b10.moveToFirst()) {
                if (b10.getInt(0) == 0) {
                    z10 = true;
                }
            }
            return z10;
        } finally {
            b10.close();
        }
    }

    public static boolean k(e0.g gVar) {
        Cursor b10 = gVar.b("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z10 = false;
            if (b10.moveToFirst()) {
                if (b10.getInt(0) != 0) {
                    z10 = true;
                }
            }
            return z10;
        } finally {
            b10.close();
        }
    }

    @Override // e0.h.a
    public void b(e0.g gVar) {
        super.b(gVar);
    }

    @Override // e0.h.a
    public void d(e0.g gVar) {
        boolean j10 = j(gVar);
        this.f11386c.a(gVar);
        if (!j10) {
            b g10 = this.f11386c.g(gVar);
            if (!g10.f11390a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g10.f11391b);
            }
        }
        l(gVar);
        this.f11386c.c(gVar);
    }

    @Override // e0.h.a
    public void e(e0.g gVar, int i10, int i11) {
        g(gVar, i10, i11);
    }

    @Override // e0.h.a
    public void f(e0.g gVar) {
        super.f(gVar);
        h(gVar);
        this.f11386c.d(gVar);
        this.f11385b = null;
    }

    @Override // e0.h.a
    public void g(e0.g gVar, int i10, int i11) {
        List<AbstractC0515b> c10;
        m mVar = this.f11385b;
        if (mVar != null && (c10 = mVar.f11339d.c(i10, i11)) != null) {
            this.f11386c.f(gVar);
            Iterator<AbstractC0515b> it = c10.iterator();
            while (it.hasNext()) {
                it.next().a(gVar);
            }
            b g10 = this.f11386c.g(gVar);
            if (g10.f11390a) {
                this.f11386c.e(gVar);
                l(gVar);
                return;
            } else {
                throw new IllegalStateException("Migration didn't properly handle: " + g10.f11391b);
            }
        }
        m mVar2 = this.f11385b;
        if (mVar2 != null && !mVar2.a(i10, i11)) {
            this.f11386c.b(gVar);
            this.f11386c.a(gVar);
            return;
        }
        throw new IllegalStateException("A migration from " + i10 + " to " + i11 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }

    public final void h(e0.g gVar) {
        String str;
        if (k(gVar)) {
            Cursor j10 = gVar.j(new C0962a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try {
                if (j10.moveToFirst()) {
                    str = j10.getString(0);
                } else {
                    str = null;
                }
                j10.close();
                if (!this.f11387d.equals(str) && !this.f11388e.equals(str)) {
                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                }
                return;
            } catch (Throwable th) {
                j10.close();
                throw th;
            }
        }
        b g10 = this.f11386c.g(gVar);
        if (g10.f11390a) {
            this.f11386c.e(gVar);
            l(gVar);
        } else {
            throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g10.f11391b);
        }
    }

    public final void i(e0.g gVar) {
        gVar.m("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    public final void l(e0.g gVar) {
        i(gVar);
        gVar.m(w.a(this.f11387d));
    }
}
