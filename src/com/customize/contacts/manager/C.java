package com.customize.contacts.manager;

import android.content.Context;
import android.net.Uri;
import android.os.CancellationSignal;
import android.provider.ContactsContract;

/* compiled from: SimpleNumberInfo.kt */
/* loaded from: classes3.dex */
public final class C {

    /* renamed from: e, reason: collision with root package name */
    public static final a f21496e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final Uri f21497f = ContactsContract.Data.CONTENT_URI;

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f21498g = {"data1", "data4", "data6", "contact_id", "display_name", "lookup", "photo_id"};

    /* renamed from: a, reason: collision with root package name */
    public String f21499a;

    /* renamed from: b, reason: collision with root package name */
    public String f21500b;

    /* renamed from: c, reason: collision with root package name */
    public String f21501c;

    /* renamed from: d, reason: collision with root package name */
    public C0787b f21502d;

    /* compiled from: SimpleNumberInfo.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:10:0x011f  */
        /* JADX WARN: Type inference failed for: r10v10 */
        /* JADX WARN: Type inference failed for: r10v15 */
        /* JADX WARN: Type inference failed for: r10v16 */
        /* JADX WARN: Type inference failed for: r10v19 */
        /* JADX WARN: Type inference failed for: r10v2, types: [int] */
        /* JADX WARN: Type inference failed for: r10v20 */
        /* JADX WARN: Type inference failed for: r10v7 */
        /* JADX WARN: Type inference failed for: r10v8, types: [int] */
        /* JADX WARN: Type inference failed for: r10v9 */
        /* JADX WARN: Type inference failed for: r11v10, types: [int] */
        /* JADX WARN: Type inference failed for: r11v14 */
        /* JADX WARN: Type inference failed for: r11v15 */
        /* JADX WARN: Type inference failed for: r11v2, types: [int] */
        /* JADX WARN: Type inference failed for: r11v7 */
        /* JADX WARN: Type inference failed for: r11v8, types: [int] */
        /* JADX WARN: Type inference failed for: r11v9 */
        /* JADX WARN: Type inference failed for: r12v18 */
        /* JADX WARN: Type inference failed for: r12v19 */
        /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r12v4 */
        /* JADX WARN: Type inference failed for: r12v5 */
        /* JADX WARN: Type inference failed for: r12v6 */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.StringBuilder] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.customize.contacts.manager.D a(android.content.Context r23, int r24, android.os.CancellationSignal r25) {
            /*
                Method dump skipped, instructions count: 381
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.manager.C.a.a(android.content.Context, int, android.os.CancellationSignal):com.customize.contacts.manager.D");
        }

        public final D b(Context context, CancellationSignal cancellationSignal) {
            kotlin.jvm.internal.i.f(context, "context");
            return a(context, 10000, cancellationSignal);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public final C0787b c() {
        return this.f21502d;
    }

    public final String d() {
        return this.f21501c;
    }

    public final String e() {
        return this.f21500b;
    }

    public final String f() {
        return this.f21499a;
    }

    public final void g(C0787b c0787b) {
        this.f21502d = c0787b;
    }

    public final void h(String str) {
        this.f21501c = str;
    }

    public final void i(String str) {
        this.f21500b = str;
    }

    public final void j(String str) {
        this.f21499a = str;
    }
}
