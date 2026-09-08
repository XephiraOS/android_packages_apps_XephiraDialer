package com.heytap.shield.authcode.dao;

import K5.a;
import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.t;

/* loaded from: classes3.dex */
public abstract class AuthenticationDb extends RoomDatabase {

    /* renamed from: o, reason: collision with root package name */
    public static volatile AuthenticationDb f25452o;

    public static AuthenticationDb D(Context context) {
        if (f25452o == null) {
            synchronized (AuthenticationDb.class) {
                try {
                    if (f25452o == null) {
                        f25452o = (AuthenticationDb) t.a(context.getApplicationContext(), AuthenticationDb.class, "authentication.db").b().c();
                    }
                } finally {
                }
            }
        }
        return f25452o;
    }

    public abstract a C();
}
