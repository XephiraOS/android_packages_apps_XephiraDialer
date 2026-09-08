package com.customize.contacts.pushnotification.model;

import android.util.Log;
import androidx.room.RoomDatabase;
import androidx.room.t;
import com.android.contacts.ContactsApplication;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import m9.q;

/* compiled from: PushNotificationRepo.kt */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static final a f21786b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static h f21787c;

    /* renamed from: a, reason: collision with root package name */
    public final PushNotificationDatabase f21788a;

    /* compiled from: PushNotificationRepo.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final h a() {
            if (h.f21787c == null) {
                synchronized (h.class) {
                    try {
                        if (h.f21787c == null) {
                            h.f21787c = new h(null);
                        }
                        q qVar = q.f35511a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return h.f21787c;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public /* synthetic */ h(kotlin.jvm.internal.f fVar) {
        this();
    }

    public static final h d() {
        return f21786b.a();
    }

    public final List<c> c() {
        try {
            Result.a aVar = Result.f34166a;
            return this.f21788a.C().d();
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Throwable d10 = Result.d(Result.b(kotlin.b.a(th)));
            if (d10 != null) {
                Log.e("ExceptionUtils", "Exception when invoke block : " + d10);
            }
            return new ArrayList();
        }
    }

    public final c e(String notificationStringId) {
        kotlin.jvm.internal.i.f(notificationStringId, "notificationStringId");
        return this.f21788a.C().a(notificationStringId);
    }

    public final void f(c notification) {
        Object b10;
        kotlin.jvm.internal.i.f(notification, "notification");
        try {
            Result.a aVar = Result.f34166a;
            if (notification.n() != 8) {
                this.f21788a.C().c(notification);
            } else {
                this.f21788a.C().b(notification);
            }
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.e("PushNotificationRepo", "Exception when updateNotification : " + d10);
        }
    }

    public final void g(List<c> notifications) {
        Object b10;
        kotlin.jvm.internal.i.f(notifications, "notifications");
        try {
            Result.a aVar = Result.f34166a;
            for (c cVar : notifications) {
                if (cVar.n() != 8) {
                    this.f21788a.C().c(cVar);
                } else {
                    this.f21788a.C().b(cVar);
                }
            }
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.e("PushNotificationRepo", "Exception when updateNotifications : " + d10);
        }
    }

    public h() {
        ContactsApplication h10 = ContactsApplication.h();
        kotlin.jvm.internal.i.d(h10, "null cannot be cast to non-null type android.content.Context");
        RoomDatabase c10 = t.a(h10, PushNotificationDatabase.class, "push_notification").a(Q3.c.f3122a.f()).c();
        kotlin.jvm.internal.i.e(c10, "databaseBuilder(Contacts…ACK)\n            .build()");
        this.f21788a = (PushNotificationDatabase) c10;
    }
}
