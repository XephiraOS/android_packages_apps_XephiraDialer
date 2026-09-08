package com.customize.contacts.util;

import android.content.Context;
import android.net.Uri;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1248i;

/* compiled from: ContactDataUtils.kt */
/* loaded from: classes3.dex */
public final class ContactDataUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final ContactDataUtils f21867a = new ContactDataUtils();

    /* compiled from: ContactDataUtils.kt */
    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public static final void a(Context context, Uri uri, String str, a aVar) {
        if (context == null) {
            return;
        }
        if (uri != null) {
            C1248i.d(C1241e0.f34422a, kotlinx.coroutines.S.b(), null, new ContactDataUtils$setRingtone$1(str, context, uri, aVar, null), 2, null);
        } else {
            H7.b.c("ContactDataUtils", "Invalid arguments for setRingtone");
        }
    }

    public static final void b(Context context, Uri uri, boolean z10) {
        if (context == null) {
            return;
        }
        if (uri != null) {
            C1248i.d(C1241e0.f34422a, kotlinx.coroutines.S.b(), null, new ContactDataUtils$setStarred$1(z10, context, uri, null), 2, null);
        } else {
            H7.b.c("ContactDataUtils", "Invalid arguments for setStarred request");
        }
    }

    public static final void c(Context context, Uri uri, String str, a aVar) {
        if (context == null) {
            return;
        }
        if (uri != null) {
            C1248i.d(C1241e0.f34422a, kotlinx.coroutines.S.b(), null, new ContactDataUtils$setVibration$1(str, context, uri, aVar, null), 2, null);
        } else {
            H7.b.c("ContactDataUtils", "Invalid arguments for setVibration");
        }
    }
}
