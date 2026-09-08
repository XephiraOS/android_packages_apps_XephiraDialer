package com.android.contacts.framework.api.infocollection;

import android.content.Context;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: IUserInfoCollectionManager.kt */
/* loaded from: classes.dex */
public interface IUserInfoCollectionManager {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f15577a = Companion.f15578a;

    /* compiled from: IUserInfoCollectionManager.kt */
    /* loaded from: classes.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f15578a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final d<IUserInfoCollectionManager> f15579b;

        static {
            d<IUserInfoCollectionManager> b10;
            b10 = kotlin.a.b(new InterfaceC1637a<IUserInfoCollectionManager>() { // from class: com.android.contacts.framework.api.infocollection.IUserInfoCollectionManager$Companion$instance$2
                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final IUserInfoCollectionManager invoke() {
                    if (PrimaryUserUtils.a()) {
                        return (IUserInfoCollectionManager) A8.a.f202a.a(IUserInfoCollectionManager.class);
                    }
                    return null;
                }
            });
            f15579b = b10;
        }

        public final IUserInfoCollectionManager a() {
            return f15579b.getValue();
        }
    }

    void a(Context context);

    void b();

    void c(int i10, String str);

    void d(int i10);
}
