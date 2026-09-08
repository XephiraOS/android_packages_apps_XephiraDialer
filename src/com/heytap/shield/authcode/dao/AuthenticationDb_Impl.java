package com.heytap.shield.authcode.dao;

import K5.b;
import androidx.room.RoomDatabase;
import androidx.room.m;
import androidx.room.s;
import androidx.room.x;
import c0.c;
import c0.f;
import com.heytap.accessory.constant.AFConstants;
import e0.g;
import e0.h;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes3.dex */
public final class AuthenticationDb_Impl extends AuthenticationDb {

    /* renamed from: p, reason: collision with root package name */
    public volatile K5.a f25453p;

    @Override // com.heytap.shield.authcode.dao.AuthenticationDb
    public K5.a C() {
        K5.a aVar;
        if (this.f25453p != null) {
            return this.f25453p;
        }
        synchronized (this) {
            try {
                if (this.f25453p == null) {
                    this.f25453p = new b(this);
                }
                aVar = this.f25453p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    @Override // androidx.room.RoomDatabase
    public s g() {
        return new s(this, new HashMap(0), new HashMap(0), "a_e");
    }

    @Override // androidx.room.RoomDatabase
    public h h(m mVar) {
        return mVar.f11336a.a(h.b.a(mVar.f11337b).c(mVar.f11338c).b(new x(mVar, new a(1), "4900734c010240a846af4887983ab420", "bcb6b006fd96cb6cf4245dc2a4b99c48")).a());
    }

    /* loaded from: classes3.dex */
    public class a extends x.a {
        public a(int i10) {
            super(i10);
        }

        @Override // androidx.room.x.a
        public void a(g gVar) {
            gVar.m("CREATE TABLE IF NOT EXISTS `a_e` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `auth_code` TEXT, `is_enable` INTEGER NOT NULL, `uid` INTEGER NOT NULL, `packageName` TEXT, `capability_name` TEXT, `expiration` INTEGER NOT NULL, `permission` BLOB, `last_update_time` INTEGER NOT NULL, `cache_time` INTEGER NOT NULL)");
            gVar.m("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            gVar.m("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '4900734c010240a846af4887983ab420')");
        }

        @Override // androidx.room.x.a
        public void b(g gVar) {
            gVar.m("DROP TABLE IF EXISTS `a_e`");
            if (AuthenticationDb_Impl.this.f11274h != null) {
                int size = AuthenticationDb_Impl.this.f11274h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) AuthenticationDb_Impl.this.f11274h.get(i10)).b(gVar);
                }
            }
        }

        @Override // androidx.room.x.a
        public void c(g gVar) {
            if (AuthenticationDb_Impl.this.f11274h != null) {
                int size = AuthenticationDb_Impl.this.f11274h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) AuthenticationDb_Impl.this.f11274h.get(i10)).a(gVar);
                }
            }
        }

        @Override // androidx.room.x.a
        public void d(g gVar) {
            AuthenticationDb_Impl.this.f11267a = gVar;
            AuthenticationDb_Impl.this.t(gVar);
            if (AuthenticationDb_Impl.this.f11274h != null) {
                int size = AuthenticationDb_Impl.this.f11274h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) AuthenticationDb_Impl.this.f11274h.get(i10)).c(gVar);
                }
            }
        }

        @Override // androidx.room.x.a
        public void f(g gVar) {
            c.a(gVar);
        }

        @Override // androidx.room.x.a
        public x.b g(g gVar) {
            HashMap hashMap = new HashMap(10);
            hashMap.put("id", new f.a("id", "INTEGER", true, 1, null, 1));
            hashMap.put("auth_code", new f.a("auth_code", "TEXT", false, 0, null, 1));
            hashMap.put("is_enable", new f.a("is_enable", "INTEGER", true, 0, null, 1));
            hashMap.put("uid", new f.a("uid", "INTEGER", true, 0, null, 1));
            hashMap.put(AFConstants.EXTRA_PACKAGE_NAME, new f.a(AFConstants.EXTRA_PACKAGE_NAME, "TEXT", false, 0, null, 1));
            hashMap.put("capability_name", new f.a("capability_name", "TEXT", false, 0, null, 1));
            hashMap.put("expiration", new f.a("expiration", "INTEGER", true, 0, null, 1));
            hashMap.put("permission", new f.a("permission", "BLOB", false, 0, null, 1));
            hashMap.put("last_update_time", new f.a("last_update_time", "INTEGER", true, 0, null, 1));
            hashMap.put("cache_time", new f.a("cache_time", "INTEGER", true, 0, null, 1));
            f fVar = new f("a_e", hashMap, new HashSet(0), new HashSet(0));
            f a10 = f.a(gVar, "a_e");
            if (!fVar.equals(a10)) {
                return new x.b(false, "a_e(com.heytap.shield.authcode.dao.AuthenticationDbBean).\n Expected:\n" + fVar + "\n Found:\n" + a10);
            }
            return new x.b(true, null);
        }

        @Override // androidx.room.x.a
        public void e(g gVar) {
        }
    }
}
