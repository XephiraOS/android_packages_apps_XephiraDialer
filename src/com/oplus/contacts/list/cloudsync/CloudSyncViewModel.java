package com.oplus.contacts.list.cloudsync;

import android.app.Activity;
import androidx.lifecycle.I;
import androidx.lifecycle.J;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import com.android.contacts.framework.api.cloudsync.ICloudSyncApi;
import com.oplus.contacts.list.cloudsync.CloudSyncPauseType;
import com.oplus.contacts.list.cloudsync.CloudSyncState;
import com.oplus.contacts.list.cloudsync.CloudSyncViewModel$cloudActivationObserver$2;
import com.oplus.contacts.list.cloudsync.CloudSyncViewModel$cloudSyncListener$2;
import com.oplus.contacts.list.cloudsync.CloudSyncViewModel$switchObserver$2;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.InterfaceC1265l0;
import kotlinx.coroutines.J0;
import kotlinx.coroutines.S;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: CloudSyncViewModel.kt */
/* loaded from: classes3.dex */
public final class CloudSyncViewModel extends I {

    /* renamed from: q, reason: collision with root package name */
    public static final a f27871q = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public final m9.d f27872d;

    /* renamed from: e, reason: collision with root package name */
    public final v<CloudSyncState> f27873e;

    /* renamed from: f, reason: collision with root package name */
    public final LiveData<CloudSyncState> f27874f;

    /* renamed from: g, reason: collision with root package name */
    public final v<Boolean> f27875g;

    /* renamed from: h, reason: collision with root package name */
    public final LiveData<Boolean> f27876h;

    /* renamed from: i, reason: collision with root package name */
    public final v<Boolean> f27877i;

    /* renamed from: j, reason: collision with root package name */
    public final LiveData<Boolean> f27878j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f27879k;

    /* renamed from: l, reason: collision with root package name */
    public InterfaceC1265l0 f27880l;

    /* renamed from: m, reason: collision with root package name */
    public final m9.d f27881m;

    /* renamed from: n, reason: collision with root package name */
    public final m9.d f27882n;

    /* renamed from: o, reason: collision with root package name */
    public final m9.d f27883o;

    /* renamed from: p, reason: collision with root package name */
    public final InterfaceC1637a<q> f27884p;

    /* compiled from: CloudSyncViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public CloudSyncViewModel() {
        m9.d b10;
        m9.d b11;
        m9.d b12;
        m9.d b13;
        b10 = kotlin.a.b(new InterfaceC1637a<ExecutorCoroutineDispatcher>() { // from class: com.oplus.contacts.list.cloudsync.CloudSyncViewModel$cloudSyncSingleThreadDispatcher$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ExecutorCoroutineDispatcher invoke() {
                return J0.b("cloudSyncThread");
            }
        });
        this.f27872d = b10;
        v<CloudSyncState> vVar = new v<>(CloudSyncState.d.f27869a);
        this.f27873e = vVar;
        this.f27874f = vVar;
        v<Boolean> vVar2 = new v<>();
        this.f27875g = vVar2;
        this.f27876h = vVar2;
        v<Boolean> vVar3 = new v<>();
        this.f27877i = vVar3;
        this.f27878j = vVar3;
        b11 = kotlin.a.b(new InterfaceC1637a<CloudSyncViewModel$switchObserver$2.a>() { // from class: com.oplus.contacts.list.cloudsync.CloudSyncViewModel$switchObserver$2

            /* compiled from: CloudSyncViewModel.kt */
            /* loaded from: classes3.dex */
            public static final class a {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ CloudSyncViewModel f27888a;

                public a(CloudSyncViewModel cloudSyncViewModel) {
                    this.f27888a = cloudSyncViewModel;
                }
            }

            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final a invoke() {
                return new a(CloudSyncViewModel.this);
            }
        });
        this.f27881m = b11;
        b12 = kotlin.a.b(new InterfaceC1637a<CloudSyncViewModel$cloudActivationObserver$2.a>() { // from class: com.oplus.contacts.list.cloudsync.CloudSyncViewModel$cloudActivationObserver$2

            /* compiled from: CloudSyncViewModel.kt */
            /* loaded from: classes3.dex */
            public static final class a {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ CloudSyncViewModel f27885a;

                public a(CloudSyncViewModel cloudSyncViewModel) {
                    this.f27885a = cloudSyncViewModel;
                }
            }

            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final a invoke() {
                return new a(CloudSyncViewModel.this);
            }
        });
        this.f27882n = b12;
        b13 = kotlin.a.b(new InterfaceC1637a<CloudSyncViewModel$cloudSyncListener$2.a>() { // from class: com.oplus.contacts.list.cloudsync.CloudSyncViewModel$cloudSyncListener$2

            /* compiled from: CloudSyncViewModel.kt */
            /* loaded from: classes3.dex */
            public static final class a implements ICloudSyncApi.d {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ CloudSyncViewModel f27886a;

                public a(CloudSyncViewModel cloudSyncViewModel) {
                    this.f27886a = cloudSyncViewModel;
                }
            }

            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final a invoke() {
                return new a(CloudSyncViewModel.this);
            }
        });
        this.f27883o = b13;
        this.f27884p = new InterfaceC1637a<q>() { // from class: com.oplus.contacts.list.cloudsync.CloudSyncViewModel$onRetry$1
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            public /* bridge */ /* synthetic */ q invoke() {
                invoke2();
                return q.f35511a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                H7.b.b("CloudSyncViewModel", "onRetry");
                CloudSyncViewModel.this.z(true);
            }
        };
        com.android.contacts.framework.api.cloudsync.a.a("CloudSyncViewModel init", J.a(this), new Runnable() { // from class: com.oplus.contacts.list.cloudsync.b
            @Override // java.lang.Runnable
            public final void run() {
                CloudSyncViewModel.j(CloudSyncViewModel.this);
            }
        });
    }

    public static final void j(CloudSyncViewModel this$0) {
        i.f(this$0, "this$0");
        v<Boolean> vVar = this$0.f27875g;
        com.android.contacts.framework.api.cloudsync.a.e();
        vVar.o(null);
        com.android.contacts.framework.api.cloudsync.a.e();
        v<Boolean> vVar2 = this$0.f27877i;
        com.android.contacts.framework.api.cloudsync.a.b();
        vVar2.o(null);
        com.android.contacts.framework.api.cloudsync.a.b();
        com.android.contacts.framework.api.cloudsync.a.j(this$0.r());
    }

    public static final void p() {
        com.android.contacts.framework.api.cloudsync.a.e();
    }

    public static final void y(CloudSyncViewModel this$0, Activity activity) {
        i.f(this$0, "this$0");
        i.f(activity, "$activity");
        if (this$0.v()) {
            com.android.contacts.framework.api.cloudsync.a.e();
        } else {
            this$0.z(false);
            this$0.f27873e.m(new CloudSyncState.b(this$0.f27879k, new CloudSyncPauseType.CloudAppDisable(this$0.f27884p)));
        }
    }

    public final void A(InterfaceC1637a<q> interfaceC1637a) {
        C1248i.d(J.a(this), s(), null, new CloudSyncViewModel$updateCloudSyncNotification$1(this, interfaceC1637a, null), 2, null);
    }

    @Override // androidx.lifecycle.I
    public void e() {
        super.e();
        com.android.contacts.framework.api.cloudsync.a.e();
        com.android.contacts.framework.api.cloudsync.a.b();
        com.android.contacts.framework.api.cloudsync.a.m(r());
        InterfaceC1265l0 interfaceC1265l0 = this.f27880l;
        if (interfaceC1265l0 != null) {
            InterfaceC1265l0.a.a(interfaceC1265l0, null, 1, null);
        }
        this.f27880l = null;
    }

    public final void o() {
        com.android.contacts.framework.api.cloudsync.a.a("CloudSyncViewModel asyncUpdateSyncSwitch", J.a(this), new Runnable() { // from class: com.oplus.contacts.list.cloudsync.d
            @Override // java.lang.Runnable
            public final void run() {
                CloudSyncViewModel.p();
            }
        });
    }

    public final LiveData<Boolean> q() {
        return this.f27878j;
    }

    public final CloudSyncViewModel$cloudSyncListener$2.a r() {
        return (CloudSyncViewModel$cloudSyncListener$2.a) this.f27883o.getValue();
    }

    public final ExecutorCoroutineDispatcher s() {
        return (ExecutorCoroutineDispatcher) this.f27872d.getValue();
    }

    public final LiveData<CloudSyncState> t() {
        return this.f27874f;
    }

    public final LiveData<Boolean> u() {
        return this.f27876h;
    }

    public final boolean v() {
        com.android.contacts.framework.api.cloudsync.a.b();
        return true;
    }

    public final boolean w() {
        Boolean value = this.f27876h.getValue();
        if (value == null) {
            return false;
        }
        return value.booleanValue();
    }

    public final void x(final Activity activity) {
        i.f(activity, "activity");
        com.android.contacts.framework.api.cloudsync.a.a("CloudSyncViewModel openSwitch", J.a(this), new Runnable() { // from class: com.oplus.contacts.list.cloudsync.c
            @Override // java.lang.Runnable
            public final void run() {
                CloudSyncViewModel.y(CloudSyncViewModel.this, activity);
            }
        });
    }

    public final void z(boolean z10) {
        InterfaceC1265l0 d10;
        H7.b.b("CloudSyncViewModel", "setShowRetrying: show = " + z10 + " , current show = " + this.f27879k);
        if (this.f27879k == z10) {
            return;
        }
        this.f27879k = z10;
        InterfaceC1265l0 interfaceC1265l0 = this.f27880l;
        if (interfaceC1265l0 != null) {
            InterfaceC1265l0.a.a(interfaceC1265l0, null, 1, null);
        }
        if (z10) {
            d10 = C1248i.d(C1241e0.f34422a, S.a(), null, new CloudSyncViewModel$setShowRetrying$1(this, null), 2, null);
            this.f27880l = d10;
        } else {
            this.f27880l = null;
        }
    }
}
