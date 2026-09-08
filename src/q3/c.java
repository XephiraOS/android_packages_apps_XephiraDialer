package Q3;

import android.util.Log;
import androidx.room.RoomDatabase;
import e0.g;
import kotlin.Result;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: PushNotificationCreator.kt */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f3122a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final RoomDatabase.b f3123b = new a();

    /* compiled from: PushNotificationCreator.kt */
    /* loaded from: classes3.dex */
    public static final class a extends RoomDatabase.b {
        @Override // androidx.room.RoomDatabase.b
        public void a(g db) {
            i.f(db, "db");
            super.a(db);
            c cVar = c.f3122a;
            cVar.e(db);
            cVar.d(db);
            c.c(db);
            H7.b.e("PushNotificationCreator", "init database complete, insert duplicate, sync and recommend notifications");
        }
    }

    public static final void c(g database) {
        Object b10;
        i.f(database, "database");
        try {
            Result.a aVar = Result.f34166a;
            com.customize.contacts.pushnotification.model.c cVar = new com.customize.contacts.pushnotification.model.c(0L, 0L, 604800, 0, Integer.MAX_VALUE, 1000000, "cloud recommend", true, true, false, null, null, 2, 0L, 11787, null);
            H7.b.e("PushNotificationCreator", "generateCloudRecommendNotification.");
            g(database, cVar);
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("PushNotificationCreator", "generateCloudRecommendNotification: exception: " + d10);
        }
    }

    public static final void g(g gVar, com.customize.contacts.pushnotification.model.c cVar) {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            gVar.m("INSERT INTO notification (last_display_time,display_period,priority,notification_string_id,show_ignore_button,show_first_action_button,show_second_action_button,has_ignored_time,max_ignore_time,language_restrict,region_restrict,state,last_query_time) VALUES (" + cVar.e() + "," + cVar.a() + "," + cVar.i() + ",'" + cVar.h() + "'," + cVar.l() + "," + cVar.k() + "," + cVar.m() + "," + cVar.b() + "," + cVar.g() + ",'" + cVar.d() + "','" + cVar.j() + "'," + cVar.n() + "," + cVar.f() + ")");
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.e("PushNotificationCreator", "Exception when insertNotificationToDatabase : " + d10);
        }
    }

    public final void d(g gVar) {
        g(gVar, new com.customize.contacts.pushnotification.model.c(0L, 0L, 7776000L, 0, 2, 1000000, "cloud sync", true, true, false, null, null, 2, 0L, 11787, null));
    }

    public final void e(g gVar) {
        g(gVar, new com.customize.contacts.pushnotification.model.c(0L, 0L, 1209600, 0, 3, 1, "duplicate contacts", true, true, false, null, null, 2, 0L, 11787, null));
    }

    public final RoomDatabase.b f() {
        return f3123b;
    }
}
