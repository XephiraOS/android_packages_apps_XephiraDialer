package com.android.contacts.framework.omoji.viewmodel;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.android.contacts.framework.omoji.utils.OmojiUtils;
import com.google.gson.JsonParseException;
import com.google.gson.d;
import com.oplus.foundation.util.io.CloseableUtils;
import com.oplus.omoji.IOmojiCallBack;
import e1.C0964a;
import f1.b;
import java.util.List;
import kotlin.Result;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;

/* compiled from: OmojiRepository.kt */
/* loaded from: classes.dex */
public final class OmojiRepository {

    /* renamed from: a, reason: collision with root package name */
    public static final OmojiRepository f16303a = new OmojiRepository();

    /* renamed from: b, reason: collision with root package name */
    public static final a f16304b = new a(false, null);

    public static final void c(Context context, long j10, boolean z10, Bundle bundle) {
        C1248i.d(C1241e0.f34422a, S.a(), null, new OmojiRepository$saveOmojiPhotoForRawContactId$1(z10, j10, bundle, context, null), 2, null);
    }

    public final a a() {
        return f16304b;
    }

    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [T, android.content.ContentProviderClient] */
    /* JADX WARN: Type inference failed for: r3v8 */
    public final void b(Context context, boolean z10, final b bVar) {
        Object b10;
        String authority;
        ?? r32;
        ContentResolver contentResolver;
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        Bundle bundle = new Bundle();
        bundle.putBinder("callback", new IOmojiCallBack.Stub() { // from class: com.android.contacts.framework.omoji.viewmodel.OmojiRepository$getOmojiList$1

            /* compiled from: OmojiRepository.kt */
            /* loaded from: classes.dex */
            public static final class a extends J4.a<C0964a> {
            }

            @Override // com.oplus.omoji.IOmojiCallBack
            public void onCall(String result) {
                C0964a c0964a;
                Boolean bool;
                Integer num;
                List<C0964a.C0293a> a10;
                i.f(result, "result");
                List<C0964a.C0293a> list = null;
                try {
                    c0964a = (C0964a) new d().k(result, new a().getType());
                } catch (JsonParseException e10) {
                    H7.b.c("OmojiRepository", "JsonParseException: " + e10);
                    c0964a = null;
                }
                if (c0964a != null) {
                    bool = Boolean.valueOf(c0964a.b());
                } else {
                    bool = null;
                }
                if (c0964a != null && (a10 = c0964a.a()) != null) {
                    num = Integer.valueOf(a10.size());
                } else {
                    num = null;
                }
                H7.b.e("OmojiRepository", "isFull：" + bool + ", size = " + num);
                boolean z11 = false;
                if (c0964a != null && c0964a.b()) {
                    z11 = true;
                }
                if (c0964a != null) {
                    list = c0964a.a();
                }
                com.android.contacts.framework.omoji.viewmodel.a aVar = new com.android.contacts.framework.omoji.viewmodel.a(z11, list);
                b bVar2 = b.this;
                if (bVar2 != null) {
                    bVar2.a(aVar);
                }
                CloseableUtils.a(ref$ObjectRef.element);
            }
        });
        bundle.putBoolean("firstGetList", z10);
        try {
            Result.a aVar = Result.f34166a;
            OmojiUtils omojiUtils = OmojiUtils.f16197a;
            Uri c10 = omojiUtils.c();
            Bundle bundle2 = null;
            if (c10 != null && (authority = c10.getAuthority()) != null) {
                if (context != null && (contentResolver = context.getContentResolver()) != null) {
                    r32 = contentResolver.acquireUnstableContentProviderClient(omojiUtils.c());
                } else {
                    r32 = 0;
                }
                ref$ObjectRef.element = r32;
                if (r32 != 0) {
                    bundle2 = r32.call(authority, "getOmojiList", null, bundle);
                }
            }
            b10 = Result.b(bundle2);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("OmojiRepository", "getOmojiList: e = " + d10);
        }
    }
}
