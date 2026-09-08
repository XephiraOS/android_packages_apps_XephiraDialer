package com.customize.contacts.startupspeed;

import android.database.Cursor;
import androidx.lifecycle.C0490m;
import androidx.lifecycle.Lifecycle;
import com.android.contacts.ViewOnClickListenerC0694u0;
import com.customize.contacts.activities.ContactsTabActivity;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;
import m9.q;

/* compiled from: CallLogPreload.kt */
/* loaded from: classes3.dex */
public final class CallLogPreload {

    /* renamed from: a, reason: collision with root package name */
    public final ContactsTabActivity f21814a;

    /* renamed from: b, reason: collision with root package name */
    public ViewOnClickListenerC0694u0 f21815b;

    /* renamed from: c, reason: collision with root package name */
    public Cursor f21816c;

    /* renamed from: d, reason: collision with root package name */
    public com.android.contacts.framework.baseui.calllog.b f21817d;

    public CallLogPreload(ContactsTabActivity activity) {
        i.f(activity, "activity");
        this.f21814a = activity;
    }

    public final void b(Cursor cursor, com.android.contacts.framework.baseui.calllog.b bVar) {
        this.f21816c = cursor;
        this.f21817d = bVar;
    }

    public final void c(Cursor cursor, com.android.contacts.framework.baseui.calllog.b bVar) {
        q qVar;
        ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0 = this.f21815b;
        if (viewOnClickListenerC0694u0 != null) {
            viewOnClickListenerC0694u0.d6(cursor, bVar, true);
            qVar = q.f35511a;
        } else {
            qVar = null;
        }
        if (qVar == null) {
            b(cursor, bVar);
        }
    }

    public final void d() {
        Lifecycle lifecycle = this.f21814a.getLifecycle();
        i.e(lifecycle, "activity.lifecycle");
        C1248i.d(C0490m.a(lifecycle), S.a(), null, new CallLogPreload$cacheDialCallLog$1(this, null), 2, null);
    }

    public final void e(ViewOnClickListenerC0694u0 fragment) {
        i.f(fragment, "fragment");
        Cursor cursor = this.f21816c;
        if (cursor != null) {
            fragment.d6(cursor, this.f21817d, true);
        } else {
            this.f21815b = fragment;
        }
    }

    public final ContactsTabActivity f() {
        return this.f21814a;
    }
}
