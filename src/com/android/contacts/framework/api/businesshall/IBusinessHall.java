package com.android.contacts.framework.api.businesshall;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import java.util.List;
import m9.d;
import v9.InterfaceC1637a;
import v9.l;

/* compiled from: IBusinessHall.kt */
/* loaded from: classes.dex */
public interface IBusinessHall {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f15562a = Companion.f15563a;

    /* compiled from: IBusinessHall.kt */
    /* loaded from: classes.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f15563a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final d<IBusinessHall> f15564b;

        static {
            d<IBusinessHall> b10;
            b10 = kotlin.a.b(new InterfaceC1637a<IBusinessHall>() { // from class: com.android.contacts.framework.api.businesshall.IBusinessHall$Companion$instance$2
                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final IBusinessHall invoke() {
                    return (IBusinessHall) A8.a.f202a.a(IBusinessHall.class);
                }
            });
            f15564b = b10;
        }

        public final IBusinessHall a() {
            return f15564b.getValue();
        }
    }

    List<I.d<String, List<String>>> a();

    void b(l<? super View, Boolean> lVar);

    void c(InterfaceC1637a<Boolean> interfaceC1637a);

    void d(boolean z10);

    void e(Context context);

    int f();

    LiveData<Boolean> g();

    boolean h(String str);

    ArrayList<I.d<String, Boolean>> i();

    LiveData<Boolean> j();

    Class<? extends Fragment> k();

    void l(Resources.Theme theme, int i10, boolean z10);

    void m(Context context);

    boolean n(String str);
}
