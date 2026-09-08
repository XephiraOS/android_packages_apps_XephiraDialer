package com.customize.contacts.pushnotification.model;

import androidx.room.RoomDatabase;
import b0.InterfaceC0514a;

/* compiled from: PushNotificationDatabase.kt */
/* loaded from: classes3.dex */
public abstract class PushNotificationDatabase extends RoomDatabase {

    /* renamed from: o, reason: collision with root package name */
    public static final c f21744o = new c(null);

    /* compiled from: PushNotificationDatabase.kt */
    /* loaded from: classes3.dex */
    public static final class a implements InterfaceC0514a {
    }

    /* compiled from: PushNotificationDatabase.kt */
    /* loaded from: classes3.dex */
    public static final class b implements InterfaceC0514a {
        @Override // b0.InterfaceC0514a
        public void a(e0.g db) {
            kotlin.jvm.internal.i.f(db, "db");
            super.a(db);
            H7.b.e("PushNotificationDatabase", "onPostMigrate: 2->3.");
            Q3.c.c(db);
        }
    }

    /* compiled from: PushNotificationDatabase.kt */
    /* loaded from: classes3.dex */
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public abstract d C();
}
