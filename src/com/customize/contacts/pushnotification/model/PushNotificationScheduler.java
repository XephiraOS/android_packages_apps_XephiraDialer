package com.customize.contacts.pushnotification.model;

import android.text.TextUtils;
import android.util.Log;
import com.android.contacts.model.Account;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.feature.CommonOSPublicFeature;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import v9.l;

/* compiled from: PushNotificationScheduler.kt */
/* loaded from: classes3.dex */
public final class PushNotificationScheduler {

    /* renamed from: c, reason: collision with root package name */
    public static final a f21747c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final PushNotificationViewModel f21748a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<String> f21749b;

    /* compiled from: PushNotificationScheduler.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: PushNotificationScheduler.kt */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f21750a = new a(null);

        /* compiled from: PushNotificationScheduler.kt */
        /* loaded from: classes3.dex */
        public static final class a {
            public a() {
            }

            public final void a(c notification, int i10, int i11) {
                kotlin.jvm.internal.i.f(notification, "notification");
                Log.i("PushNotificationScheduler", "changeState: " + notification.h());
                if (i10 != notification.n()) {
                    Log.i("PushNotificationScheduler", "the state " + i10 + " not equal the state of notification " + notification.n());
                    return;
                }
                if (i10 == i11) {
                    Log.i("PushNotificationScheduler", "from state  equal to state : " + i10);
                    return;
                }
                String str = i10 + "->" + i11;
                notification.r(i11);
                switch (str.hashCode()) {
                    case 1504977:
                        if (str.equals("1->3")) {
                            return;
                        }
                        break;
                    case 1504978:
                        if (str.equals("1->4")) {
                            notification.p(System.currentTimeMillis() / 1000);
                            notification.o(notification.b() + 1);
                            if (notification.g() != -1 && notification.b() >= notification.g()) {
                                notification.r(7);
                                return;
                            } else {
                                notification.r(6);
                                return;
                            }
                        }
                        break;
                    case 1504979:
                        if (str.equals("1->5")) {
                            return;
                        }
                        break;
                    case 1534766:
                        if (str.equals("2->1")) {
                            notification.p(System.currentTimeMillis() / 1000);
                            return;
                        }
                        break;
                    case 1624140:
                        if (str.equals("5->2")) {
                            return;
                        }
                        break;
                    case 1653931:
                        if (str.equals("6->2")) {
                            return;
                        }
                        break;
                }
                Log.i("PushNotificationScheduler", "unknown state path " + i10 + " -> " + i11);
            }

            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        public static final void a(c cVar, int i10, int i11) {
            f21750a.a(cVar, i10, i11);
        }
    }

    public PushNotificationScheduler(PushNotificationViewModel viewModel) {
        kotlin.jvm.internal.i.f(viewModel, "viewModel");
        this.f21748a = viewModel;
        this.f21749b = new LinkedHashSet();
    }

    public static final boolean g(l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    public final void c(String id) {
        kotlin.jvm.internal.i.f(id, "id");
        this.f21749b.add(id);
    }

    public final boolean d() {
        boolean z10;
        if (com.android.contacts.framework.api.togoogle.a.f15622a.b()) {
            if (com.android.contacts.framework.api.cloudsync.a.g()) {
                com.android.contacts.framework.api.cloudsync.a.e();
            }
            H7.b.b("PushNotificationScheduler", "MoveToGoogleManager isNeedMoveToGoogle isCloudSyncOpen : false");
            if (M3.c.i(this.f21748a.j(), new Account(R0.a.f3165a, R0.a.f3166b)) > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            H7.b.b("PushNotificationScheduler", "MoveToGoogleManager isNeedMoveToGoogle hasLocalContacts : " + z10);
            if (z10) {
                this.f21748a.k().m(new c(0L, 0L, 0L, 0, 0, 0, "move to google", false, false, false, null, null, 0, 0L, 16319, null));
                return true;
            }
        }
        return false;
    }

    public final void e(boolean z10) {
        f(z10);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x05db, code lost:
    
        if (r0.equals(r3) == false) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x03d5, code lost:
    
        if (r14.equals(r8) == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x03d7, code lost:
    
        r20 = r5;
        r17 = r6;
        r24 = r10;
        r5 = r22;
        r15 = r23;
        r23 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x03e5, code lost:
    
        r20 = r5;
        r17 = r6;
        r24 = r10;
        r5 = r22;
        r15 = r23;
        r23 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x03f8, code lost:
    
        if (r14.equals(r5) == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0436, code lost:
    
        if (r14.equals(r5) == false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0492, code lost:
    
        if (r14.equals(r3) == false) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x011f, code lost:
    
        if (r0.equals("6->2") == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0129, code lost:
    
        if (r0.equals("5->2") == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x013f, code lost:
    
        if (r0.equals("1->5") == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x017b, code lost:
    
        if (r0.equals("1->3") == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0253, code lost:
    
        if (r8.equals(r10) == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0256, code lost:
    
        r24 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0263, code lost:
    
        if (r8.equals("5->2") == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0281, code lost:
    
        if (r8.equals(r14) == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x02ca, code lost:
    
        if (r8.equals(r3) == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0578, code lost:
    
        if (r0.equals(r8) == false) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0581, code lost:
    
        if (r0.equals(r20) == false) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x059a, code lost:
    
        if (r0.equals(r5) == false) goto L192;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:144:0x03bc. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:182:0x0117. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:43:0x0244. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:131:0x033d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(boolean r29) {
        /*
            Method dump skipped, instructions count: 1698
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.pushnotification.model.PushNotificationScheduler.f(boolean):void");
    }

    public final boolean h(c cVar) {
        String h10 = cVar.h();
        if (kotlin.jvm.internal.i.b("duplicate contacts", h10) && R0.a.f3166b == null && !com.android.contacts.framework.api.appstore.appinfo.a.o()) {
            return true;
        }
        if (kotlin.jvm.internal.i.b("cloud sync", h10) && (!com.android.contacts.framework.api.cloudsync.a.g() || OsUtils.h())) {
            return true;
        }
        if (kotlin.jvm.internal.i.b("cloud recommend", h10)) {
            if (!OsUtils.h() || !CommonOSPublicFeature.f()) {
                return true;
            }
            com.android.contacts.framework.api.cloudsync.a.c();
        }
        return this.f21749b.contains(h10);
    }

    public final void i() {
        this.f21749b.clear();
    }

    public final void j(List<c> list) {
        com.customize.contacts.pushnotification.model.b m10 = this.f21748a.m();
        for (c cVar : list) {
            if (cVar.n() == 6) {
                b.a aVar = b.f21750a;
                int n10 = cVar.n();
                Log.i("PushNotificationScheduler", "changeState: " + cVar.h());
                if (n10 != cVar.n()) {
                    Log.i("PushNotificationScheduler", "the state " + n10 + " not equal the state of notification " + cVar.n());
                } else if (n10 == 2) {
                    Log.i("PushNotificationScheduler", "from state  equal to state : " + n10);
                } else {
                    String str = n10 + "->2";
                    cVar.r(2);
                    switch (str.hashCode()) {
                        case 1504977:
                            if (str.equals("1->3")) {
                                break;
                            }
                            break;
                        case 1504978:
                            if (str.equals("1->4")) {
                                cVar.p(System.currentTimeMillis() / 1000);
                                cVar.o(cVar.b() + 1);
                                if (cVar.g() != -1 && cVar.b() >= cVar.g()) {
                                    cVar.r(7);
                                    break;
                                } else {
                                    cVar.r(6);
                                    break;
                                }
                            }
                            break;
                        case 1504979:
                            if (str.equals("1->5")) {
                                break;
                            }
                            break;
                        case 1534766:
                            if (str.equals("2->1")) {
                                cVar.p(System.currentTimeMillis() / 1000);
                                break;
                            }
                            break;
                        case 1624140:
                            if (str.equals("5->2")) {
                                break;
                            }
                            break;
                        case 1653931:
                            if (str.equals("6->2")) {
                                break;
                            }
                            break;
                    }
                    Log.i("PushNotificationScheduler", "unknown state path " + n10 + " -> 2");
                }
            }
            m10.a(this.f21748a.j(), cVar);
        }
        if (list.size() > 1 && TextUtils.equals(list.get(0).h(), "duplicate contacts") && list.get(0).n() == 6) {
            this.f21748a.l().f(list.get(0));
            list.remove(0);
        }
    }

    public final void k(String id) {
        kotlin.jvm.internal.i.f(id, "id");
        this.f21749b.remove(id);
    }
}
