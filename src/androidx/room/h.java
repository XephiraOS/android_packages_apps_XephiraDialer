package androidx.room;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.room.h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import m.InterfaceC1301a;

/* compiled from: AutoClosingRoomOpenHelper.java */
/* loaded from: classes.dex */
public final class h implements e0.h, n {

    /* renamed from: a, reason: collision with root package name */
    public final e0.h f11323a;

    /* renamed from: b, reason: collision with root package name */
    public final a f11324b;

    /* renamed from: c, reason: collision with root package name */
    public final C0495a f11325c;

    /* compiled from: AutoClosingRoomOpenHelper.java */
    /* loaded from: classes.dex */
    public static final class a implements e0.g {

        /* renamed from: a, reason: collision with root package name */
        public final C0495a f11326a;

        public a(C0495a c0495a) {
            this.f11326a = c0495a;
        }

        public static /* synthetic */ Object f(String str, e0.g gVar) {
            gVar.m(str);
            return null;
        }

        public static /* synthetic */ Boolean g(e0.g gVar) {
            return Boolean.valueOf(gVar.k0());
        }

        public static /* synthetic */ Object l(e0.g gVar) {
            return null;
        }

        @Override // e0.g
        public void D() {
            e0.g d10 = this.f11326a.d();
            if (d10 != null) {
                d10.D();
                return;
            }
            throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
        }

        @Override // e0.g
        public void F() {
            try {
                this.f11326a.e().F();
            } catch (Throwable th) {
                this.f11326a.b();
                throw th;
            }
        }

        @Override // e0.g
        public void P() {
            if (this.f11326a.d() != null) {
                try {
                    this.f11326a.d().P();
                    return;
                } finally {
                    this.f11326a.b();
                }
            }
            throw new IllegalStateException("End transaction called but delegateDb is null");
        }

        @Override // e0.g
        public Cursor b(String str) {
            try {
                return new c(this.f11326a.e().b(str), this.f11326a);
            } catch (Throwable th) {
                this.f11326a.b();
                throw th;
            }
        }

        @Override // e0.g
        public Cursor b0(e0.j jVar, CancellationSignal cancellationSignal) {
            try {
                return new c(this.f11326a.e().b0(jVar, cancellationSignal), this.f11326a);
            } catch (Throwable th) {
                this.f11326a.b();
                throw th;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f11326a.a();
        }

        @Override // e0.g
        public String d() {
            return (String) this.f11326a.c(new InterfaceC1301a() { // from class: androidx.room.f
                @Override // m.InterfaceC1301a
                public final Object apply(Object obj) {
                    return ((e0.g) obj).d();
                }
            });
        }

        @Override // e0.g
        public boolean e0() {
            if (this.f11326a.d() == null) {
                return false;
            }
            return ((Boolean) this.f11326a.c(new InterfaceC1301a() { // from class: androidx.room.c
                @Override // m.InterfaceC1301a
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((e0.g) obj).e0());
                }
            })).booleanValue();
        }

        @Override // e0.g
        public void h() {
            try {
                this.f11326a.e().h();
            } catch (Throwable th) {
                this.f11326a.b();
                throw th;
            }
        }

        @Override // e0.g
        public List<Pair<String, String>> i() {
            return (List) this.f11326a.c(new InterfaceC1301a() { // from class: androidx.room.d
                @Override // m.InterfaceC1301a
                public final Object apply(Object obj) {
                    return ((e0.g) obj).i();
                }
            });
        }

        @Override // e0.g
        public boolean isOpen() {
            e0.g d10 = this.f11326a.d();
            if (d10 == null) {
                return false;
            }
            return d10.isOpen();
        }

        @Override // e0.g
        public Cursor j(e0.j jVar) {
            try {
                return new c(this.f11326a.e().j(jVar), this.f11326a);
            } catch (Throwable th) {
                this.f11326a.b();
                throw th;
            }
        }

        @Override // e0.g
        public boolean k0() {
            return ((Boolean) this.f11326a.c(new InterfaceC1301a() { // from class: androidx.room.e
                @Override // m.InterfaceC1301a
                public final Object apply(Object obj) {
                    Boolean g10;
                    g10 = h.a.g((e0.g) obj);
                    return g10;
                }
            })).booleanValue();
        }

        @Override // e0.g
        public void m(final String str) {
            this.f11326a.c(new InterfaceC1301a() { // from class: androidx.room.b
                @Override // m.InterfaceC1301a
                public final Object apply(Object obj) {
                    Object f10;
                    f10 = h.a.f(str, (e0.g) obj);
                    return f10;
                }
            });
        }

        public void o() {
            this.f11326a.c(new InterfaceC1301a() { // from class: androidx.room.g
                @Override // m.InterfaceC1301a
                public final Object apply(Object obj) {
                    Object l10;
                    l10 = h.a.l((e0.g) obj);
                    return l10;
                }
            });
        }

        @Override // e0.g
        public e0.k q(String str) {
            return new b(str, this.f11326a);
        }
    }

    /* compiled from: AutoClosingRoomOpenHelper.java */
    /* loaded from: classes.dex */
    public static final class c implements Cursor {

        /* renamed from: a, reason: collision with root package name */
        public final Cursor f11330a;

        /* renamed from: b, reason: collision with root package name */
        public final C0495a f11331b;

        public c(Cursor cursor, C0495a c0495a) {
            this.f11330a = cursor;
            this.f11331b = c0495a;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f11330a.close();
            this.f11331b.b();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int i10, CharArrayBuffer charArrayBuffer) {
            this.f11330a.copyStringToBuffer(i10, charArrayBuffer);
        }

        @Override // android.database.Cursor
        @Deprecated
        public void deactivate() {
            this.f11330a.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int i10) {
            return this.f11330a.getBlob(i10);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.f11330a.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String str) {
            return this.f11330a.getColumnIndex(str);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String str) {
            return this.f11330a.getColumnIndexOrThrow(str);
        }

        @Override // android.database.Cursor
        public String getColumnName(int i10) {
            return this.f11330a.getColumnName(i10);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.f11330a.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.f11330a.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int i10) {
            return this.f11330a.getDouble(i10);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.f11330a.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int i10) {
            return this.f11330a.getFloat(i10);
        }

        @Override // android.database.Cursor
        public int getInt(int i10) {
            return this.f11330a.getInt(i10);
        }

        @Override // android.database.Cursor
        public long getLong(int i10) {
            return this.f11330a.getLong(i10);
        }

        @Override // android.database.Cursor
        public Uri getNotificationUri() {
            return e0.c.a(this.f11330a);
        }

        @Override // android.database.Cursor
        public List<Uri> getNotificationUris() {
            return e0.f.a(this.f11330a);
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.f11330a.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int i10) {
            return this.f11330a.getShort(i10);
        }

        @Override // android.database.Cursor
        public String getString(int i10) {
            return this.f11330a.getString(i10);
        }

        @Override // android.database.Cursor
        public int getType(int i10) {
            return this.f11330a.getType(i10);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.f11330a.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.f11330a.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.f11330a.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.f11330a.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.f11330a.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.f11330a.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int i10) {
            return this.f11330a.isNull(i10);
        }

        @Override // android.database.Cursor
        public boolean move(int i10) {
            return this.f11330a.move(i10);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.f11330a.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.f11330a.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.f11330a.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int i10) {
            return this.f11330a.moveToPosition(i10);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.f11330a.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver contentObserver) {
            this.f11330a.registerContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f11330a.registerDataSetObserver(dataSetObserver);
        }

        @Override // android.database.Cursor
        @Deprecated
        public boolean requery() {
            return this.f11330a.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle bundle) {
            return this.f11330a.respond(bundle);
        }

        @Override // android.database.Cursor
        public void setExtras(Bundle bundle) {
            e0.e.a(this.f11330a, bundle);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.f11330a.setNotificationUri(contentResolver, uri);
        }

        @Override // android.database.Cursor
        public void setNotificationUris(ContentResolver contentResolver, List<Uri> list) {
            e0.f.b(this.f11330a, contentResolver, list);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.f11330a.unregisterContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f11330a.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public h(e0.h hVar, C0495a c0495a) {
        this.f11323a = hVar;
        this.f11325c = c0495a;
        c0495a.f(hVar);
        this.f11324b = new a(c0495a);
    }

    @Override // e0.h
    public e0.g M() {
        this.f11324b.o();
        return this.f11324b;
    }

    @Override // androidx.room.n
    public e0.h a() {
        return this.f11323a;
    }

    public C0495a c() {
        return this.f11325c;
    }

    @Override // e0.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f11324b.close();
        } catch (IOException e10) {
            c0.e.a(e10);
        }
    }

    @Override // e0.h
    public String getDatabaseName() {
        return this.f11323a.getDatabaseName();
    }

    @Override // e0.h
    public void setWriteAheadLoggingEnabled(boolean z10) {
        this.f11323a.setWriteAheadLoggingEnabled(z10);
    }

    /* compiled from: AutoClosingRoomOpenHelper.java */
    /* loaded from: classes.dex */
    public static class b implements e0.k {

        /* renamed from: a, reason: collision with root package name */
        public final String f11327a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<Object> f11328b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        public final C0495a f11329c;

        public b(String str, C0495a c0495a) {
            this.f11327a = str;
            this.f11329c = c0495a;
        }

        @Override // e0.i
        public void C(int i10, long j10) {
            g(i10, Long.valueOf(j10));
        }

        @Override // e0.i
        public void H(int i10, byte[] bArr) {
            g(i10, bArr);
        }

        @Override // e0.i
        public void Y(int i10) {
            g(i10, null);
        }

        public final void c(e0.k kVar) {
            int i10 = 0;
            while (i10 < this.f11328b.size()) {
                int i11 = i10 + 1;
                Object obj = this.f11328b.get(i10);
                if (obj == null) {
                    kVar.Y(i11);
                } else if (obj instanceof Long) {
                    kVar.C(i11, ((Long) obj).longValue());
                } else if (obj instanceof Double) {
                    kVar.t(i11, ((Double) obj).doubleValue());
                } else if (obj instanceof String) {
                    kVar.n(i11, (String) obj);
                } else if (obj instanceof byte[]) {
                    kVar.H(i11, (byte[]) obj);
                }
                i10 = i11;
            }
        }

        public final <T> T e(final InterfaceC1301a<e0.k, T> interfaceC1301a) {
            return (T) this.f11329c.c(new InterfaceC1301a() { // from class: androidx.room.j
                @Override // m.InterfaceC1301a
                public final Object apply(Object obj) {
                    Object f10;
                    f10 = h.b.this.f(interfaceC1301a, (e0.g) obj);
                    return f10;
                }
            });
        }

        public final /* synthetic */ Object f(InterfaceC1301a interfaceC1301a, e0.g gVar) {
            e0.k q10 = gVar.q(this.f11327a);
            c(q10);
            return interfaceC1301a.apply(q10);
        }

        public final void g(int i10, Object obj) {
            int i11 = i10 - 1;
            if (i11 >= this.f11328b.size()) {
                for (int size = this.f11328b.size(); size <= i11; size++) {
                    this.f11328b.add(null);
                }
            }
            this.f11328b.set(i11, obj);
        }

        @Override // e0.i
        public void n(int i10, String str) {
            g(i10, str);
        }

        @Override // e0.k
        public long n0() {
            return ((Long) e(new InterfaceC1301a() { // from class: androidx.room.k
                @Override // m.InterfaceC1301a
                public final Object apply(Object obj) {
                    return Long.valueOf(((e0.k) obj).n0());
                }
            })).longValue();
        }

        @Override // e0.k
        public int p() {
            return ((Integer) e(new InterfaceC1301a() { // from class: androidx.room.i
                @Override // m.InterfaceC1301a
                public final Object apply(Object obj) {
                    return Integer.valueOf(((e0.k) obj).p());
                }
            })).intValue();
        }

        @Override // e0.i
        public void t(int i10, double d10) {
            g(i10, Double.valueOf(d10));
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }
}
