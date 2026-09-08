package com.customize.contacts.pushnotification.model;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.o;
import androidx.room.p;
import androidx.room.y;
import c0.C0546b;
import com.heytap.accessory.constant.AFConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: PushNotificationDao_Impl.java */
/* loaded from: classes3.dex */
public final class e implements d {

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f21777a;

    /* renamed from: b, reason: collision with root package name */
    public final p<com.customize.contacts.pushnotification.model.c> f21778b;

    /* renamed from: c, reason: collision with root package name */
    public final o<com.customize.contacts.pushnotification.model.c> f21779c;

    /* renamed from: d, reason: collision with root package name */
    public final o<com.customize.contacts.pushnotification.model.c> f21780d;

    /* compiled from: PushNotificationDao_Impl.java */
    /* loaded from: classes3.dex */
    public class a extends p<com.customize.contacts.pushnotification.model.c> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.B
        public String d() {
            return "INSERT OR ABORT INTO `notification` (`id`,`last_display_time`,`display_period`,`has_ignored_time`,`max_ignore_time`,`priority`,`notification_string_id`,`show_ignore_button`,`show_first_action_button`,`show_second_action_button`,`language_restrict`,`region_restrict`,`state`,`last_query_time`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.p
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(e0.k kVar, com.customize.contacts.pushnotification.model.c cVar) {
            kVar.C(1, cVar.c());
            kVar.C(2, cVar.e());
            kVar.C(3, cVar.a());
            kVar.C(4, cVar.b());
            kVar.C(5, cVar.g());
            kVar.C(6, cVar.i());
            if (cVar.h() == null) {
                kVar.Y(7);
            } else {
                kVar.n(7, cVar.h());
            }
            kVar.C(8, cVar.l() ? 1L : 0L);
            kVar.C(9, cVar.k() ? 1L : 0L);
            kVar.C(10, cVar.m() ? 1L : 0L);
            if (cVar.d() == null) {
                kVar.Y(11);
            } else {
                kVar.n(11, cVar.d());
            }
            if (cVar.j() == null) {
                kVar.Y(12);
            } else {
                kVar.n(12, cVar.j());
            }
            kVar.C(13, cVar.n());
            kVar.C(14, cVar.f());
        }
    }

    /* compiled from: PushNotificationDao_Impl.java */
    /* loaded from: classes3.dex */
    public class b extends o<com.customize.contacts.pushnotification.model.c> {
        public b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.B
        public String d() {
            return "DELETE FROM `notification` WHERE `id` = ?";
        }

        @Override // androidx.room.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(e0.k kVar, com.customize.contacts.pushnotification.model.c cVar) {
            kVar.C(1, cVar.c());
        }
    }

    /* compiled from: PushNotificationDao_Impl.java */
    /* loaded from: classes3.dex */
    public class c extends o<com.customize.contacts.pushnotification.model.c> {
        public c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.B
        public String d() {
            return "UPDATE OR ABORT `notification` SET `id` = ?,`last_display_time` = ?,`display_period` = ?,`has_ignored_time` = ?,`max_ignore_time` = ?,`priority` = ?,`notification_string_id` = ?,`show_ignore_button` = ?,`show_first_action_button` = ?,`show_second_action_button` = ?,`language_restrict` = ?,`region_restrict` = ?,`state` = ?,`last_query_time` = ? WHERE `id` = ?";
        }

        @Override // androidx.room.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(e0.k kVar, com.customize.contacts.pushnotification.model.c cVar) {
            kVar.C(1, cVar.c());
            kVar.C(2, cVar.e());
            kVar.C(3, cVar.a());
            kVar.C(4, cVar.b());
            kVar.C(5, cVar.g());
            kVar.C(6, cVar.i());
            if (cVar.h() == null) {
                kVar.Y(7);
            } else {
                kVar.n(7, cVar.h());
            }
            kVar.C(8, cVar.l() ? 1L : 0L);
            kVar.C(9, cVar.k() ? 1L : 0L);
            kVar.C(10, cVar.m() ? 1L : 0L);
            if (cVar.d() == null) {
                kVar.Y(11);
            } else {
                kVar.n(11, cVar.d());
            }
            if (cVar.j() == null) {
                kVar.Y(12);
            } else {
                kVar.n(12, cVar.j());
            }
            kVar.C(13, cVar.n());
            kVar.C(14, cVar.f());
            kVar.C(15, cVar.c());
        }
    }

    public e(RoomDatabase roomDatabase) {
        this.f21777a = roomDatabase;
        this.f21778b = new a(roomDatabase);
        this.f21779c = new b(roomDatabase);
        this.f21780d = new c(roomDatabase);
    }

    public static List<Class<?>> e() {
        return Collections.emptyList();
    }

    @Override // com.customize.contacts.pushnotification.model.d
    public com.customize.contacts.pushnotification.model.c a(String str) {
        com.customize.contacts.pushnotification.model.c cVar;
        String string;
        boolean z10;
        boolean z11;
        boolean z12;
        String string2;
        String string3;
        y e10 = y.e("SELECT * FROM notification WHERE notification_string_id = ?", 1);
        if (str == null) {
            e10.Y(1);
        } else {
            e10.n(1, str);
        }
        this.f21777a.d();
        Cursor b10 = c0.c.b(this.f21777a, e10, false, null);
        try {
            int d10 = C0546b.d(b10, "id");
            int d11 = C0546b.d(b10, "last_display_time");
            int d12 = C0546b.d(b10, "display_period");
            int d13 = C0546b.d(b10, "has_ignored_time");
            int d14 = C0546b.d(b10, "max_ignore_time");
            int d15 = C0546b.d(b10, AFConstants.EXTRA_PRIORITY);
            int d16 = C0546b.d(b10, "notification_string_id");
            int d17 = C0546b.d(b10, "show_ignore_button");
            int d18 = C0546b.d(b10, "show_first_action_button");
            int d19 = C0546b.d(b10, "show_second_action_button");
            int d20 = C0546b.d(b10, "language_restrict");
            int d21 = C0546b.d(b10, "region_restrict");
            int d22 = C0546b.d(b10, "state");
            int d23 = C0546b.d(b10, "last_query_time");
            if (b10.moveToFirst()) {
                long j10 = b10.getLong(d10);
                long j11 = b10.getLong(d11);
                long j12 = b10.getLong(d12);
                int i10 = b10.getInt(d13);
                int i11 = b10.getInt(d14);
                int i12 = b10.getInt(d15);
                if (b10.isNull(d16)) {
                    string = null;
                } else {
                    string = b10.getString(d16);
                }
                if (b10.getInt(d17) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (b10.getInt(d18) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (b10.getInt(d19) != 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (b10.isNull(d20)) {
                    string2 = null;
                } else {
                    string2 = b10.getString(d20);
                }
                if (b10.isNull(d21)) {
                    string3 = null;
                } else {
                    string3 = b10.getString(d21);
                }
                cVar = new com.customize.contacts.pushnotification.model.c(j10, j11, j12, i10, i11, i12, string, z10, z11, z12, string2, string3, b10.getInt(d22), b10.getLong(d23));
            } else {
                cVar = null;
            }
            return cVar;
        } finally {
            b10.close();
            e10.l();
        }
    }

    @Override // com.customize.contacts.pushnotification.model.d
    public void b(com.customize.contacts.pushnotification.model.c cVar) {
        this.f21777a.d();
        this.f21777a.e();
        try {
            this.f21779c.h(cVar);
            this.f21777a.A();
        } finally {
            this.f21777a.i();
        }
    }

    @Override // com.customize.contacts.pushnotification.model.d
    public void c(com.customize.contacts.pushnotification.model.c cVar) {
        this.f21777a.d();
        this.f21777a.e();
        try {
            this.f21780d.h(cVar);
            this.f21777a.A();
        } finally {
            this.f21777a.i();
        }
    }

    @Override // com.customize.contacts.pushnotification.model.d
    public List<com.customize.contacts.pushnotification.model.c> d() {
        y yVar;
        String string;
        boolean z10;
        boolean z11;
        boolean z12;
        String string2;
        String string3;
        y e10 = y.e("SELECT * FROM notification WHERE (state IN (1,2,5) OR (state == 6 AND (last_display_time + display_period) - strftime('%s','now') <= 0)) AND CASE WHEN max_ignore_time = -1 THEN 1 ELSE has_ignored_time < max_ignore_time END ORDER BY priority ASC", 0);
        this.f21777a.d();
        Cursor b10 = c0.c.b(this.f21777a, e10, false, null);
        try {
            int d10 = C0546b.d(b10, "id");
            int d11 = C0546b.d(b10, "last_display_time");
            int d12 = C0546b.d(b10, "display_period");
            int d13 = C0546b.d(b10, "has_ignored_time");
            int d14 = C0546b.d(b10, "max_ignore_time");
            int d15 = C0546b.d(b10, AFConstants.EXTRA_PRIORITY);
            int d16 = C0546b.d(b10, "notification_string_id");
            int d17 = C0546b.d(b10, "show_ignore_button");
            int d18 = C0546b.d(b10, "show_first_action_button");
            int d19 = C0546b.d(b10, "show_second_action_button");
            int d20 = C0546b.d(b10, "language_restrict");
            int d21 = C0546b.d(b10, "region_restrict");
            int d22 = C0546b.d(b10, "state");
            yVar = e10;
            try {
                int d23 = C0546b.d(b10, "last_query_time");
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    long j10 = b10.getLong(d10);
                    long j11 = b10.getLong(d11);
                    long j12 = b10.getLong(d12);
                    int i10 = b10.getInt(d13);
                    int i11 = b10.getInt(d14);
                    int i12 = b10.getInt(d15);
                    if (b10.isNull(d16)) {
                        string = null;
                    } else {
                        string = b10.getString(d16);
                    }
                    if (b10.getInt(d17) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (b10.getInt(d18) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (b10.getInt(d19) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (b10.isNull(d20)) {
                        string2 = null;
                    } else {
                        string2 = b10.getString(d20);
                    }
                    if (b10.isNull(d21)) {
                        string3 = null;
                    } else {
                        string3 = b10.getString(d21);
                    }
                    int i13 = d23;
                    int i14 = d10;
                    arrayList.add(new com.customize.contacts.pushnotification.model.c(j10, j11, j12, i10, i11, i12, string, z10, z11, z12, string2, string3, b10.getInt(d22), b10.getLong(i13)));
                    d10 = i14;
                    d23 = i13;
                }
                b10.close();
                yVar.l();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b10.close();
                yVar.l();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            yVar = e10;
        }
    }
}
