package com.customize.contacts.util;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import kotlin.Result;

/* compiled from: AssistantScreenCardHelper.kt */
/* renamed from: com.customize.contacts.util.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0793d {

    /* renamed from: a, reason: collision with root package name */
    public static final C0793d f22060a = new C0793d();

    public static final void a(Context context) {
        Object b10;
        Context applicationContext;
        ContentResolver contentResolver;
        try {
            Result.a aVar = Result.f34166a;
            if (context != null && (applicationContext = context.getApplicationContext()) != null && (contentResolver = applicationContext.getContentResolver()) != null) {
                contentResolver.call("com.android.contacts.assistantscreen.card.ContactCardWidgetProvider", "method_update_contact_data", (String) null, (Bundle) null);
            }
            b10 = Result.b(m9.q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.e("ExceptionUtils", "Exception when invoke block : " + d10);
        }
    }
}
