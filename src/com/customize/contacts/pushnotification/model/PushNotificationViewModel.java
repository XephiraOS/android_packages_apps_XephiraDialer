package com.customize.contacts.pushnotification.model;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.J;
import androidx.lifecycle.v;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.InterfaceC1265l0;
import kotlinx.coroutines.J0;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: PushNotificationViewModel.kt */
/* loaded from: classes3.dex */
public final class PushNotificationViewModel extends AndroidViewModel {

    /* renamed from: m, reason: collision with root package name */
    public static final a f21751m = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public final Application f21752e;

    /* renamed from: f, reason: collision with root package name */
    public v<c> f21753f;

    /* renamed from: g, reason: collision with root package name */
    public final h f21754g;

    /* renamed from: h, reason: collision with root package name */
    public final b f21755h;

    /* renamed from: i, reason: collision with root package name */
    public final ExecutorCoroutineDispatcher f21756i;

    /* renamed from: j, reason: collision with root package name */
    public final PushNotificationScheduler f21757j;

    /* renamed from: k, reason: collision with root package name */
    public final com.customize.contacts.pushnotification.model.a f21758k;

    /* renamed from: l, reason: collision with root package name */
    public InterfaceC1265l0 f21759l;

    /* compiled from: PushNotificationViewModel.kt */
    @InterfaceC1470d(c = "com.customize.contacts.pushnotification.model.PushNotificationViewModel$1", f = "PushNotificationViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.customize.contacts.pushnotification.model.PushNotificationViewModel$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
        int label;

        public AnonymousClass1(kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                Process.setThreadPriority(10);
                return q.f35511a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(q.f35511a);
        }
    }

    /* compiled from: PushNotificationViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushNotificationViewModel(Application context) {
        super(context);
        kotlin.jvm.internal.i.f(context, "context");
        this.f21752e = context;
        this.f21753f = new v<>();
        h a10 = h.f21786b.a();
        kotlin.jvm.internal.i.c(a10);
        this.f21754g = a10;
        this.f21755h = new b();
        ExecutorCoroutineDispatcher b10 = J0.b("PushNotificationViewModel");
        this.f21756i = b10;
        this.f21757j = new PushNotificationScheduler(this);
        this.f21758k = new com.customize.contacts.pushnotification.model.a();
        C1248i.d(J.a(this), b10, null, new AnonymousClass1(null), 2, null);
    }

    public static final void q(PushNotificationViewModel this$0, boolean z10) {
        InterfaceC1265l0 d10;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        InterfaceC1265l0 interfaceC1265l0 = this$0.f21759l;
        if (interfaceC1265l0 != null) {
            InterfaceC1265l0.a.a(interfaceC1265l0, null, 1, null);
        }
        d10 = C1248i.d(J.a(this$0), this$0.f21756i, null, new PushNotificationViewModel$refreshCurrentNeedShowNotification$1$1(this$0, z10, null), 2, null);
        this$0.f21759l = d10;
    }

    @Override // androidx.lifecycle.I
    public void e() {
        super.e();
        InterfaceC1265l0 interfaceC1265l0 = this.f21759l;
        if (interfaceC1265l0 != null) {
            InterfaceC1265l0.a.a(interfaceC1265l0, null, 1, null);
        }
        this.f21757j.i();
        this.f21756i.close();
    }

    public final void i(String id) {
        kotlin.jvm.internal.i.f(id, "id");
        this.f21757j.c(id);
    }

    public final Application j() {
        return this.f21752e;
    }

    public final v<c> k() {
        return this.f21753f;
    }

    public final h l() {
        return this.f21754g;
    }

    public final b m() {
        return this.f21755h;
    }

    public final void n(Context context, c notification) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(notification, "notification");
        H7.b.b("PushNotificationViewModel", "first button click for notification : " + notification.h());
        this.f21758k.a(context, notification);
        C1248i.d(J.a(this), this.f21756i, null, new PushNotificationViewModel$onFirstActionClick$1(this, notification, null), 2, null);
    }

    public final void o(Context context, c notification) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(notification, "notification");
        H7.b.b("PushNotificationViewModel", "ignore button click for notification : " + notification.h());
        this.f21758k.b(context, notification);
        C1248i.d(J.a(this), this.f21756i, null, new PushNotificationViewModel$onIgnoreClick$1(this, notification, null), 2, null);
    }

    public final void p(final boolean z10) {
        com.android.contacts.framework.api.cloudsync.a.a("PushNotificationViewModel refreshCurrentNeedShowNotification", J.a(this), new Runnable() { // from class: com.customize.contacts.pushnotification.model.k
            @Override // java.lang.Runnable
            public final void run() {
                PushNotificationViewModel.q(PushNotificationViewModel.this, z10);
            }
        });
    }

    public final void r(String id) {
        kotlin.jvm.internal.i.f(id, "id");
        this.f21757j.k(id);
    }
}
