package com.android.contacts.framework.api.appstore.simcard;

import android.content.Context;
import com.android.contacts.model.Account;
import java.util.ArrayList;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: ISimCardApi.kt */
/* loaded from: classes.dex */
public interface ISimCardApi {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f15550a = Companion.f15551a;

    /* compiled from: ISimCardApi.kt */
    /* loaded from: classes.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f15551a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final d<ISimCardApi> f15552b;

        static {
            d<ISimCardApi> b10;
            b10 = kotlin.a.b(new InterfaceC1637a<ISimCardApi>() { // from class: com.android.contacts.framework.api.appstore.simcard.ISimCardApi$Companion$instance$2
                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final ISimCardApi invoke() {
                    return (ISimCardApi) A8.a.f202a.a(ISimCardApi.class);
                }
            });
            f15552b = b10;
        }

        public final ISimCardApi a() {
            return f15552b.getValue();
        }
    }

    boolean a(Context context);

    boolean b(Context context);

    int c(Context context, String str);

    String d(Context context, int i10);

    ArrayList<Account> e(Context context);

    boolean f(Context context, int i10);
}
