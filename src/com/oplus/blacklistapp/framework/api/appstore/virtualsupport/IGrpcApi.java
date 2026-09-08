package com.oplus.blacklistapp.framework.api.appstore.virtualsupport;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: IGrpcApi.kt */
/* loaded from: classes3.dex */
public interface IGrpcApi {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f27218a = Companion.f27219a;

    /* compiled from: IGrpcApi.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f27219a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final d<IGrpcApi> f27220b;

        static {
            d<IGrpcApi> b10;
            b10 = kotlin.a.b(new InterfaceC1637a<IGrpcApi>() { // from class: com.oplus.blacklistapp.framework.api.appstore.virtualsupport.IGrpcApi$Companion$instance$2
                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final IGrpcApi invoke() {
                    return (IGrpcApi) A8.a.f202a.a(IGrpcApi.class);
                }
            });
            f27220b = b10;
        }

        public final IGrpcApi a() {
            return f27220b.getValue();
        }
    }

    /* compiled from: IGrpcApi.kt */
    /* loaded from: classes3.dex */
    public interface a {
    }

    boolean a(String str);

    void b(Context context, a aVar);

    Cursor c(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    a d();
}
