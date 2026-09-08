package com.android.contacts.voicemail.impl.scheduling;

import android.content.Context;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import java.util.Objects;

/* compiled from: Task.java */
/* loaded from: classes.dex */
public interface e {

    /* compiled from: Task.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f18184a;

        /* renamed from: b, reason: collision with root package name */
        public final PhoneAccountHandle f18185b;

        public a(int i10, PhoneAccountHandle phoneAccountHandle) {
            this.f18184a = i10;
            this.f18185b = phoneAccountHandle;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f18184a != aVar.f18184a || !this.f18185b.equals(aVar.f18185b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f18184a), this.f18185b);
        }
    }

    void a();

    void b(e eVar);

    void c();

    long d();

    void e(Context context, Bundle bundle);

    Bundle f();

    a getId();

    void onCompleted();

    void onRestore(Bundle bundle);
}
