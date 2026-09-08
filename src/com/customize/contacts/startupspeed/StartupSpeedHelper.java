package com.customize.contacts.startupspeed;

import I.d;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.view.LayoutInflater;
import android.view.View;
import com.android.contacts.ViewOnClickListenerC0694u0;
import com.android.contacts.calllog.CallLogItemCacheManager;
import com.android.contacts.calllog.k;
import com.android.contacts.dialpad.view.DialpadView;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.activities.ContactsTabActivity;
import com.customize.contacts.fragment.DialtactsUnfoldFragment;
import com.customize.contacts.viewmodel.DialPadFragmentViewModel;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.FeatureUtil;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import w0.C1641a;

/* compiled from: StartupSpeedHelper.kt */
/* loaded from: classes3.dex */
public final class StartupSpeedHelper {

    /* renamed from: p, reason: collision with root package name */
    public static final a f21823p = new a(null);

    /* renamed from: q, reason: collision with root package name */
    public static StartupSpeedHelper f21824q;

    /* renamed from: a, reason: collision with root package name */
    public Thread f21825a;

    /* renamed from: f, reason: collision with root package name */
    public Integer f21830f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f21831g;

    /* renamed from: h, reason: collision with root package name */
    public Boolean f21832h;

    /* renamed from: i, reason: collision with root package name */
    public d<DialpadView, Integer> f21833i;

    /* renamed from: l, reason: collision with root package name */
    public DateFormat f21836l;

    /* renamed from: m, reason: collision with root package name */
    public Locale f21837m;

    /* renamed from: n, reason: collision with root package name */
    public Cursor f21838n;

    /* renamed from: o, reason: collision with root package name */
    public WeakReference<DialtactsUnfoldFragment> f21839o;

    /* renamed from: b, reason: collision with root package name */
    public CountDownLatch f21826b = new CountDownLatch(1);

    /* renamed from: c, reason: collision with root package name */
    public CountDownLatch f21827c = new CountDownLatch(1);

    /* renamed from: d, reason: collision with root package name */
    public CountDownLatch f21828d = new CountDownLatch(1);

    /* renamed from: e, reason: collision with root package name */
    public volatile int f21829e = -1;

    /* renamed from: j, reason: collision with root package name */
    public final ReentrantLock f21834j = new ReentrantLock();

    /* renamed from: k, reason: collision with root package name */
    public final com.customize.contacts.startupspeed.a f21835k = new com.customize.contacts.startupspeed.a();

    /* compiled from: StartupSpeedHelper.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final void a(DialtactsUnfoldFragment dialtactsUnfoldFragment) {
            StartupSpeedHelper d10 = d();
            if (d10 != null) {
                d10.s(dialtactsUnfoldFragment);
            }
        }

        public final DateFormat b() {
            StartupSpeedHelper d10 = d();
            if (d10 != null) {
                return d10.v();
            }
            return null;
        }

        public final d<DialpadView, Integer> c(Context context) {
            StartupSpeedHelper d10 = d();
            if (d10 != null) {
                return d10.x(context);
            }
            return null;
        }

        public final StartupSpeedHelper d() {
            return StartupSpeedHelper.f21824q;
        }

        public final Locale e() {
            StartupSpeedHelper d10 = d();
            if (d10 != null) {
                return d10.z();
            }
            return null;
        }

        public final Boolean f() {
            StartupSpeedHelper d10 = d();
            if (d10 != null) {
                return d10.C();
            }
            return null;
        }

        public final Boolean g() {
            StartupSpeedHelper d10 = d();
            if (d10 != null) {
                return d10.E();
            }
            return null;
        }

        public final Cursor h() {
            StartupSpeedHelper d10 = d();
            if (d10 != null) {
                return d10.H();
            }
            return null;
        }

        public final void i(StartupSpeedHelper startupSpeedHelper) {
            StartupSpeedHelper.f21824q = startupSpeedHelper;
        }

        public final void j() {
            StartupSpeedHelper d10 = d();
            if (d10 != null) {
                d10.J();
            }
            i(null);
        }

        public final void k(int i10) {
            StartupSpeedHelper d10 = d();
            if (d10 != null) {
                d10.L(i10);
            }
        }

        public final void l(ContactsTabActivity contactsTabActivity) {
            StartupSpeedHelper d10 = d();
            if (d10 != null) {
                d10.N(contactsTabActivity);
            }
        }

        public final void m(Context context, b bVar) {
            if (d() == null) {
                StartupSpeedHelper startupSpeedHelper = new StartupSpeedHelper();
                startupSpeedHelper.Q(context, bVar);
                i(startupSpeedHelper);
            }
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: StartupSpeedHelper.kt */
    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z10);
    }

    /* compiled from: StartupSpeedHelper.kt */
    /* loaded from: classes3.dex */
    public static final class c implements CallLogItemCacheManager.a {
        public c() {
        }

        @Override // com.android.contacts.calllog.CallLogItemCacheManager.a
        public void a(MatrixCursor matrixCursor) {
            StartupSpeedHelper.this.f21838n = matrixCursor;
        }
    }

    public static final Boolean B() {
        return f21823p.f();
    }

    public static final Boolean D() {
        return f21823p.g();
    }

    public static final Cursor G() {
        return f21823p.h();
    }

    public static final void I() {
        f21823p.j();
    }

    public static final void K(int i10) {
        f21823p.k(i10);
    }

    public static final void M(ContactsTabActivity contactsTabActivity) {
        f21823p.l(contactsTabActivity);
    }

    public static final void O(StartupSpeedHelper this$0, Context it) {
        DialtactsUnfoldFragment dialtactsUnfoldFragment;
        i.f(this$0, "this$0");
        i.f(it, "$it");
        this$0.f21834j.lock();
        this$0.f21833i = this$0.A(it, this$0.f21833i, true);
        this$0.f21834j.unlock();
        this$0.f21828d.await();
        WeakReference<DialtactsUnfoldFragment> weakReference = this$0.f21839o;
        if (weakReference != null) {
            dialtactsUnfoldFragment = weakReference.get();
        } else {
            dialtactsUnfoldFragment = null;
        }
        this$0.f21839o = null;
        if (dialtactsUnfoldFragment != null) {
            LayoutInflater from = LayoutInflater.from(it);
            boolean h10 = DisplayUtil.h(it);
            for (int i10 = 0; i10 < 12; i10++) {
                View e12 = k.e1(from, h10);
                if (e12 != null && !dialtactsUnfoldFragment.K8(e12)) {
                    return;
                }
            }
        }
    }

    public static final void P(Context context, b bVar) {
        f21823p.m(context, bVar);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:(2:28|29)|30|(1:32)|33|34|(12:36|(1:38)|39|40|(1:42)|43|44|45|(4:56|57|58|(1:60))|47|48|(2:50|51)(1:52))|68|(1:70)|39|40|(0)|43|44|45|(0)|47|48|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x017c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x017d, code lost:
    
        H7.b.c("StartupSpeedHelper", "init await = " + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x012b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x012c, code lost:
    
        H7.b.c("StartupSpeedHelper", "init await = " + r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void R(android.content.Context r16, com.customize.contacts.startupspeed.StartupSpeedHelper.b r17, com.customize.contacts.startupspeed.StartupSpeedHelper r18, android.content.Context r19) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.startupspeed.StartupSpeedHelper.R(android.content.Context, com.customize.contacts.startupspeed.StartupSpeedHelper$b, com.customize.contacts.startupspeed.StartupSpeedHelper, android.content.Context):void");
    }

    public static final void r(DialtactsUnfoldFragment dialtactsUnfoldFragment) {
        f21823p.a(dialtactsUnfoldFragment);
    }

    public static final DateFormat u() {
        return f21823p.b();
    }

    public static final Locale y() {
        return f21823p.e();
    }

    public final d<DialpadView, Integer> A(Context context, d<DialpadView, Integer> dVar, boolean z10) {
        DialpadView N42;
        if (context == null) {
            return null;
        }
        if (dVar == null) {
            Integer num = this.f21830f;
            if (num == null) {
                num = Integer.valueOf(DialPadFragmentViewModel.f22207e.a(context));
            }
            dVar = d.a(null, num);
        }
        DialpadView dialpadView = dVar.f1295a;
        if (z10) {
            Integer num2 = dVar.f1296b;
            i.e(num2, "pair.second");
            N42 = ViewOnClickListenerC0694u0.N4(context, dialpadView, num2.intValue(), this.f21835k);
        } else {
            Integer num3 = dVar.f1296b;
            i.e(num3, "pair.second");
            N42 = ViewOnClickListenerC0694u0.N4(context, dialpadView, num3.intValue(), null);
        }
        if (dialpadView == null) {
            return d.a(N42, dVar.f1296b);
        }
        return dVar;
    }

    public final Boolean C() {
        return (Boolean) t(this.f21831g);
    }

    public final Boolean E() {
        return (Boolean) w(this.f21832h);
    }

    public final void F(Context context) {
        B3.a.b0();
        E0.a.e();
        E0.a.c();
        E0.a.f();
        B3.a.K();
        B3.a.Q();
        B3.a.X();
        B3.a.f0();
        C1641a.l(context, FeatureOption.o());
        B3.a.W();
        FeatureUtil.O();
    }

    public final Cursor H() {
        return (Cursor) w(this.f21838n);
    }

    public final void J() {
        this.f21829e = 3;
        this.f21827c.countDown();
    }

    public final void L(int i10) {
        this.f21829e = i10;
        this.f21826b.countDown();
    }

    public final void N(final Context context) {
        if (context != null) {
            Thread thread = new Thread(new Runnable() { // from class: com.customize.contacts.startupspeed.c
                @Override // java.lang.Runnable
                public final void run() {
                    StartupSpeedHelper.O(StartupSpeedHelper.this, context);
                }
            }, "cache_dial");
            thread.setPriority(10);
            thread.start();
            this.f21825a = thread;
        }
    }

    public final void Q(final Context context, final b bVar) {
        if (context != null) {
            Thread thread = new Thread(new Runnable() { // from class: com.customize.contacts.startupspeed.b
                @Override // java.lang.Runnable
                public final void run() {
                    StartupSpeedHelper.R(context, bVar, this, context);
                }
            }, "startup_speed");
            thread.setPriority(10);
            thread.start();
            this.f21825a = thread;
        }
    }

    public final void q(Context context) {
        this.f21830f = Integer.valueOf(DialPadFragmentViewModel.f22207e.a(context));
        this.f21836l = android.text.format.DateFormat.getTimeFormat(context);
        this.f21837m = context.getResources().getConfiguration().locale;
        boolean z10 = false;
        if (B3.a.b0()) {
            CallLogItemCacheManager.f13737c.a().h(context, false, new c());
        }
        if (G0.c.d(context, 0, "not_requery_ted_mark_info", 0) == 1) {
            z10 = true;
        }
        this.f21832h = Boolean.valueOf(z10);
    }

    public final void s(DialtactsUnfoldFragment dialtactsUnfoldFragment) {
        this.f21839o = new WeakReference<>(dialtactsUnfoldFragment);
        this.f21828d.countDown();
    }

    public final <T> T t(T t10) {
        if (this.f21829e != 3) {
            return t10;
        }
        return null;
    }

    public final DateFormat v() {
        return (DateFormat) w(this.f21836l);
    }

    public final <T> T w(T t10) {
        if (this.f21829e == 0) {
            return t10;
        }
        return null;
    }

    public final d<DialpadView, Integer> x(Context context) {
        this.f21835k.b(true);
        this.f21834j.lock();
        d<DialpadView, Integer> dVar = this.f21833i;
        this.f21833i = null;
        this.f21834j.unlock();
        return A(context, dVar, false);
    }

    public final Locale z() {
        return (Locale) w(this.f21837m);
    }
}
