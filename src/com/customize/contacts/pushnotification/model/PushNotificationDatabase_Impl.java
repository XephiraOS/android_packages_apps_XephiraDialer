package com.customize.contacts.pushnotification.model;

import androidx.room.RoomDatabase;
import androidx.room.m;
import androidx.room.s;
import androidx.room.x;
import b0.AbstractC0515b;
import b0.InterfaceC0514a;
import c0.f;
import com.android.incallui.OplusPhoneUtils;
import com.heytap.accessory.constant.AFConstants;
import e0.h;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class PushNotificationDatabase_Impl extends PushNotificationDatabase {

    /* renamed from: p, reason: collision with root package name */
    public volatile d f21745p;

    @Override // com.customize.contacts.pushnotification.model.PushNotificationDatabase
    public d C() {
        d dVar;
        if (this.f21745p != null) {
            return this.f21745p;
        }
        synchronized (this) {
            try {
                if (this.f21745p == null) {
                    this.f21745p = new e(this);
                }
                dVar = this.f21745p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    @Override // androidx.room.RoomDatabase
    public s g() {
        return new s(this, new HashMap(0), new HashMap(0), "notification");
    }

    @Override // androidx.room.RoomDatabase
    public e0.h h(m mVar) {
        return mVar.f11336a.a(h.b.a(mVar.f11337b).c(mVar.f11338c).b(new x(mVar, new a(3), "901c36edc8c85ef11012f154e8170ce1", "9b4a0a32fa4be716179d58234c5cd350")).a());
    }

    @Override // androidx.room.RoomDatabase
    public List<AbstractC0515b> j(Map<Class<? extends InterfaceC0514a>, InterfaceC0514a> map) {
        return Arrays.asList(new f(), new g());
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends InterfaceC0514a>> n() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> o() {
        HashMap hashMap = new HashMap();
        hashMap.put(d.class, e.e());
        return hashMap;
    }

    /* loaded from: classes3.dex */
    public class a extends x.a {
        public a(int i10) {
            super(i10);
        }

        @Override // androidx.room.x.a
        public void a(e0.g gVar) {
            gVar.m("CREATE TABLE IF NOT EXISTS `notification` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `last_display_time` INTEGER NOT NULL DEFAULT -1, `display_period` INTEGER NOT NULL DEFAULT 0, `has_ignored_time` INTEGER NOT NULL DEFAULT 0, `max_ignore_time` INTEGER NOT NULL DEFAULT 1, `priority` INTEGER NOT NULL DEFAULT 2147483647, `notification_string_id` TEXT NOT NULL DEFAULT '', `show_ignore_button` INTEGER NOT NULL DEFAULT false, `show_first_action_button` INTEGER NOT NULL DEFAULT false, `show_second_action_button` INTEGER NOT NULL DEFAULT false, `language_restrict` TEXT NOT NULL DEFAULT '', `region_restrict` TEXT NOT NULL DEFAULT '', `state` INTEGER NOT NULL DEFAULT 0, `last_query_time` INTEGER NOT NULL DEFAULT 0)");
            gVar.m("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            gVar.m("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '901c36edc8c85ef11012f154e8170ce1')");
        }

        @Override // androidx.room.x.a
        public void b(e0.g gVar) {
            gVar.m("DROP TABLE IF EXISTS `notification`");
            if (PushNotificationDatabase_Impl.this.f11274h != null) {
                int size = PushNotificationDatabase_Impl.this.f11274h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) PushNotificationDatabase_Impl.this.f11274h.get(i10)).b(gVar);
                }
            }
        }

        @Override // androidx.room.x.a
        public void c(e0.g gVar) {
            if (PushNotificationDatabase_Impl.this.f11274h != null) {
                int size = PushNotificationDatabase_Impl.this.f11274h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) PushNotificationDatabase_Impl.this.f11274h.get(i10)).a(gVar);
                }
            }
        }

        @Override // androidx.room.x.a
        public void d(e0.g gVar) {
            PushNotificationDatabase_Impl.this.f11267a = gVar;
            PushNotificationDatabase_Impl.this.t(gVar);
            if (PushNotificationDatabase_Impl.this.f11274h != null) {
                int size = PushNotificationDatabase_Impl.this.f11274h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) PushNotificationDatabase_Impl.this.f11274h.get(i10)).c(gVar);
                }
            }
        }

        @Override // androidx.room.x.a
        public void f(e0.g gVar) {
            c0.c.a(gVar);
        }

        @Override // androidx.room.x.a
        public x.b g(e0.g gVar) {
            HashMap hashMap = new HashMap(14);
            hashMap.put("id", new f.a("id", "INTEGER", true, 1, null, 1));
            hashMap.put("last_display_time", new f.a("last_display_time", "INTEGER", true, 0, OplusPhoneUtils.DeviceState.INVALID_STATUS, 1));
            hashMap.put("display_period", new f.a("display_period", "INTEGER", true, 0, OplusPhoneUtils.DeviceState.UNLOCK_DEVICE, 1));
            hashMap.put("has_ignored_time", new f.a("has_ignored_time", "INTEGER", true, 0, OplusPhoneUtils.DeviceState.UNLOCK_DEVICE, 1));
            hashMap.put("max_ignore_time", new f.a("max_ignore_time", "INTEGER", true, 0, OplusPhoneUtils.DeviceState.LOCK_DEVICE, 1));
            hashMap.put(AFConstants.EXTRA_PRIORITY, new f.a(AFConstants.EXTRA_PRIORITY, "INTEGER", true, 0, "2147483647", 1));
            hashMap.put("notification_string_id", new f.a("notification_string_id", "TEXT", true, 0, "''", 1));
            hashMap.put("show_ignore_button", new f.a("show_ignore_button", "INTEGER", true, 0, "false", 1));
            hashMap.put("show_first_action_button", new f.a("show_first_action_button", "INTEGER", true, 0, "false", 1));
            hashMap.put("show_second_action_button", new f.a("show_second_action_button", "INTEGER", true, 0, "false", 1));
            hashMap.put("language_restrict", new f.a("language_restrict", "TEXT", true, 0, "''", 1));
            hashMap.put("region_restrict", new f.a("region_restrict", "TEXT", true, 0, "''", 1));
            hashMap.put("state", new f.a("state", "INTEGER", true, 0, OplusPhoneUtils.DeviceState.UNLOCK_DEVICE, 1));
            hashMap.put("last_query_time", new f.a("last_query_time", "INTEGER", true, 0, OplusPhoneUtils.DeviceState.UNLOCK_DEVICE, 1));
            c0.f fVar = new c0.f("notification", hashMap, new HashSet(0), new HashSet(0));
            c0.f a10 = c0.f.a(gVar, "notification");
            if (!fVar.equals(a10)) {
                return new x.b(false, "notification(com.customize.contacts.pushnotification.model.PushNotificationBean).\n Expected:\n" + fVar + "\n Found:\n" + a10);
            }
            return new x.b(true, null);
        }

        @Override // androidx.room.x.a
        public void e(e0.g gVar) {
        }
    }
}
