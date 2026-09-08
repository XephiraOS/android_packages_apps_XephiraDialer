package com.android.contacts.framework.api.numberidentify.interfaces;

import A8.a;
import F0.b;
import F0.c;
import android.content.Context;
import android.os.Bundle;
import java.util.List;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: INumberIdentifyApi.kt */
/* loaded from: classes.dex */
public interface INumberIdentifyApi {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f15587a = Companion.f15588a;

    /* compiled from: INumberIdentifyApi.kt */
    /* loaded from: classes.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f15588a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final d<INumberIdentifyApi> f15589b;

        static {
            d<INumberIdentifyApi> b10;
            b10 = kotlin.a.b(new InterfaceC1637a<INumberIdentifyApi>() { // from class: com.android.contacts.framework.api.numberidentify.interfaces.INumberIdentifyApi$Companion$instance$2
                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final INumberIdentifyApi invoke() {
                    return (INumberIdentifyApi) a.f202a.a(INumberIdentifyApi.class);
                }
            });
            f15589b = b10;
        }

        public final INumberIdentifyApi a() {
            return f15589b.getValue();
        }
    }

    /* compiled from: INumberIdentifyApi.kt */
    /* loaded from: classes.dex */
    public interface a {
    }

    IRecognitionNumber A(c cVar);

    IRecognitionNumber B(String str);

    String[] C(Context context);

    boolean D(String str, String str2, String str3, String str4, String str5, int i10);

    void a();

    void bindService();

    void clear();

    boolean d(String str);

    List<String> e();

    int f(String str);

    void g(String str);

    void h(b bVar, a aVar);

    void i(String str, IRecognitionNumber iRecognitionNumber);

    String j(Context context, IMarkerData iMarkerData);

    String k(Context context, String str);

    byte[] l(String str);

    int m();

    boolean n(c cVar);

    int o();

    Bundle p();

    String q(Context context, String str);

    String r(Context context, IMarkerData iMarkerData);

    void s();

    int t(String str);

    boolean u(String str);

    String v(String str);

    int w(Context context, String str);

    boolean x();

    void y(String str, String str2, String str3, String str4, int i10);

    IMarkerData z(String str);
}
