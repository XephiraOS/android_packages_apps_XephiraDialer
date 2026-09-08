package K5;

import android.database.Cursor;
import androidx.room.B;
import androidx.room.RoomDatabase;
import androidx.room.p;
import androidx.room.y;
import c0.C0546b;
import com.heytap.accessory.constant.AFConstants;
import e0.k;

/* compiled from: AuthenticationDao_Impl.java */
/* loaded from: classes3.dex */
public final class b implements K5.a {

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f1656a;

    /* renamed from: b, reason: collision with root package name */
    public final p<K5.c> f1657b;

    /* renamed from: c, reason: collision with root package name */
    public final B f1658c;

    /* renamed from: d, reason: collision with root package name */
    public final B f1659d;

    /* compiled from: AuthenticationDao_Impl.java */
    /* loaded from: classes3.dex */
    public class a extends p<K5.c> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.B
        public String d() {
            return "INSERT OR REPLACE INTO `a_e` (`id`,`auth_code`,`is_enable`,`uid`,`packageName`,`capability_name`,`expiration`,`permission`,`last_update_time`,`cache_time`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.p
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(k kVar, K5.c cVar) {
            kVar.C(1, cVar.e());
            if (cVar.a() == null) {
                kVar.Y(2);
            } else {
                kVar.n(2, cVar.a());
            }
            kVar.C(3, cVar.j() ? 1L : 0L);
            kVar.C(4, cVar.i());
            if (cVar.g() == null) {
                kVar.Y(5);
            } else {
                kVar.n(5, cVar.g());
            }
            if (cVar.c() == null) {
                kVar.Y(6);
            } else {
                kVar.n(6, cVar.c());
            }
            kVar.C(7, cVar.d());
            if (cVar.h() == null) {
                kVar.Y(8);
            } else {
                kVar.H(8, cVar.h());
            }
            kVar.C(9, cVar.f());
            kVar.C(10, cVar.b());
        }
    }

    /* compiled from: AuthenticationDao_Impl.java */
    /* renamed from: K5.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0037b extends B {
        public C0037b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.B
        public String d() {
            return "DELETE from a_e WHERE a_e.uid = (?)AND a_e.capability_name = (?)AND a_e.auth_code = (?)";
        }
    }

    /* compiled from: AuthenticationDao_Impl.java */
    /* loaded from: classes3.dex */
    public class c extends B {
        public c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.B
        public String d() {
            return "DELETE from a_e";
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.f1656a = roomDatabase;
        this.f1657b = new a(roomDatabase);
        this.f1658c = new C0037b(roomDatabase);
        this.f1659d = new c(roomDatabase);
    }

    @Override // K5.a
    public K5.c a(int i10, String str, String str2, String str3) {
        boolean z10;
        y e10 = y.e("SELECT * FROM a_e WHERE a_e.uid = (?)AND a_e.packageName = (?)AND a_e.capability_name = (?)AND a_e.auth_code = (?)", 4);
        e10.C(1, i10);
        if (str == null) {
            e10.Y(2);
        } else {
            e10.n(2, str);
        }
        if (str2 == null) {
            e10.Y(3);
        } else {
            e10.n(3, str2);
        }
        if (str3 == null) {
            e10.Y(4);
        } else {
            e10.n(4, str3);
        }
        this.f1656a.d();
        K5.c cVar = null;
        Cursor b10 = c0.c.b(this.f1656a, e10, false, null);
        try {
            int d10 = C0546b.d(b10, "id");
            int d11 = C0546b.d(b10, "auth_code");
            int d12 = C0546b.d(b10, "is_enable");
            int d13 = C0546b.d(b10, "uid");
            int d14 = C0546b.d(b10, AFConstants.EXTRA_PACKAGE_NAME);
            int d15 = C0546b.d(b10, "capability_name");
            int d16 = C0546b.d(b10, "expiration");
            int d17 = C0546b.d(b10, "permission");
            int d18 = C0546b.d(b10, "last_update_time");
            int d19 = C0546b.d(b10, "cache_time");
            if (b10.moveToFirst()) {
                String string = b10.getString(d11);
                if (b10.getInt(d12) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                cVar = new K5.c(string, z10, b10.getInt(d13), b10.getString(d14), b10.getString(d15), b10.getLong(d16), b10.getBlob(d17), b10.getLong(d18), b10.getLong(d19));
                cVar.k(b10.getInt(d10));
            }
            return cVar;
        } finally {
            b10.close();
            e10.l();
        }
    }

    @Override // K5.a
    public void b(K5.c cVar) {
        this.f1656a.d();
        this.f1656a.e();
        try {
            this.f1657b.h(cVar);
            this.f1656a.A();
        } finally {
            this.f1656a.i();
        }
    }
}
