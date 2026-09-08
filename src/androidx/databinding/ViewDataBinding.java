package androidx.databinding;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.c;
import androidx.databinding.i;
import androidx.databinding.j;
import androidx.databinding.k;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.InterfaceC0491n;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.w;
import androidx.lifecycle.x;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class ViewDataBinding extends androidx.databinding.a {

    /* renamed from: x, reason: collision with root package name */
    public static final int f9618x = 8;

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f9621b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9622c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9623d;

    /* renamed from: e, reason: collision with root package name */
    public p[] f9624e;

    /* renamed from: f, reason: collision with root package name */
    public final View f9625f;

    /* renamed from: g, reason: collision with root package name */
    public androidx.databinding.c<androidx.databinding.m, ViewDataBinding, Void> f9626g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f9627h;

    /* renamed from: i, reason: collision with root package name */
    public Choreographer f9628i;

    /* renamed from: j, reason: collision with root package name */
    public final Choreographer.FrameCallback f9629j;

    /* renamed from: k, reason: collision with root package name */
    public Handler f9630k;

    /* renamed from: l, reason: collision with root package name */
    public final androidx.databinding.f f9631l;

    /* renamed from: m, reason: collision with root package name */
    public ViewDataBinding f9632m;

    /* renamed from: n, reason: collision with root package name */
    public InterfaceC0492o f9633n;

    /* renamed from: o, reason: collision with root package name */
    public OnStartListener f9634o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f9635p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f9636q;

    /* renamed from: r, reason: collision with root package name */
    public static int f9617r = Build.VERSION.SDK_INT;

    /* renamed from: y, reason: collision with root package name */
    public static final boolean f9619y = true;

    /* renamed from: z, reason: collision with root package name */
    public static final androidx.databinding.d f9620z = new a();

    /* renamed from: A, reason: collision with root package name */
    public static final androidx.databinding.d f9611A = new b();

    /* renamed from: B, reason: collision with root package name */
    public static final androidx.databinding.d f9612B = new c();

    /* renamed from: C, reason: collision with root package name */
    public static final androidx.databinding.d f9613C = new d();

    /* renamed from: D, reason: collision with root package name */
    public static final c.a<androidx.databinding.m, ViewDataBinding, Void> f9614D = new e();

    /* renamed from: E, reason: collision with root package name */
    public static final ReferenceQueue<ViewDataBinding> f9615E = new ReferenceQueue<>();

    /* renamed from: F, reason: collision with root package name */
    public static final View.OnAttachStateChangeListener f9616F = new f();

    /* loaded from: classes.dex */
    public static class OnStartListener implements InterfaceC0491n {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<ViewDataBinding> f9637a;

        public /* synthetic */ OnStartListener(ViewDataBinding viewDataBinding, a aVar) {
            this(viewDataBinding);
        }

        @x(Lifecycle.Event.ON_START)
        public void onStart() {
            ViewDataBinding viewDataBinding = this.f9637a.get();
            if (viewDataBinding != null) {
                viewDataBinding.D0();
            }
        }

        public OnStartListener(ViewDataBinding viewDataBinding) {
            this.f9637a = new WeakReference<>(viewDataBinding);
        }
    }

    /* loaded from: classes.dex */
    public class a implements androidx.databinding.d {
        @Override // androidx.databinding.d
        public p a(ViewDataBinding viewDataBinding, int i10, ReferenceQueue<ViewDataBinding> referenceQueue) {
            return new m(viewDataBinding, i10, referenceQueue).f();
        }
    }

    /* loaded from: classes.dex */
    public class b implements androidx.databinding.d {
        @Override // androidx.databinding.d
        public p a(ViewDataBinding viewDataBinding, int i10, ReferenceQueue<ViewDataBinding> referenceQueue) {
            return new k(viewDataBinding, i10, referenceQueue).e();
        }
    }

    /* loaded from: classes.dex */
    public class c implements androidx.databinding.d {
        @Override // androidx.databinding.d
        public p a(ViewDataBinding viewDataBinding, int i10, ReferenceQueue<ViewDataBinding> referenceQueue) {
            return new l(viewDataBinding, i10, referenceQueue).e();
        }
    }

    /* loaded from: classes.dex */
    public class d implements androidx.databinding.d {
        @Override // androidx.databinding.d
        public p a(ViewDataBinding viewDataBinding, int i10, ReferenceQueue<ViewDataBinding> referenceQueue) {
            return new j(viewDataBinding, i10, referenceQueue).f();
        }
    }

    /* loaded from: classes.dex */
    public class e extends c.a<androidx.databinding.m, ViewDataBinding, Void> {
        @Override // androidx.databinding.c.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(androidx.databinding.m mVar, ViewDataBinding viewDataBinding, int i10, Void r42) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        mVar.a(viewDataBinding);
                        return;
                    }
                    return;
                }
                mVar.b(viewDataBinding);
                return;
            }
            if (!mVar.c(viewDataBinding)) {
                viewDataBinding.f9623d = true;
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                ViewDataBinding.this.f9622c = false;
            }
            ViewDataBinding.U0();
            if (!ViewDataBinding.this.f9625f.isAttachedToWindow()) {
                ViewDataBinding.this.f9625f.removeOnAttachStateChangeListener(ViewDataBinding.f9616F);
                ViewDataBinding.this.f9625f.addOnAttachStateChangeListener(ViewDataBinding.f9616F);
            } else {
                ViewDataBinding.this.D0();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements Choreographer.FrameCallback {
        public h() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j10) {
            ViewDataBinding.this.f9621b.run();
        }
    }

    /* loaded from: classes.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public final String[][] f9640a;

        /* renamed from: b, reason: collision with root package name */
        public final int[][] f9641b;

        /* renamed from: c, reason: collision with root package name */
        public final int[][] f9642c;

        public i(int i10) {
            this.f9640a = new String[i10];
            this.f9641b = new int[i10];
            this.f9642c = new int[i10];
        }

        public void a(int i10, String[] strArr, int[] iArr, int[] iArr2) {
            this.f9640a[i10] = strArr;
            this.f9641b[i10] = iArr;
            this.f9642c[i10] = iArr2;
        }
    }

    /* loaded from: classes.dex */
    public static class j implements w, androidx.databinding.l<LiveData<?>> {

        /* renamed from: a, reason: collision with root package name */
        public final p<LiveData<?>> f9643a;

        /* renamed from: b, reason: collision with root package name */
        public WeakReference<InterfaceC0492o> f9644b = null;

        public j(ViewDataBinding viewDataBinding, int i10, ReferenceQueue<ViewDataBinding> referenceQueue) {
            this.f9643a = new p<>(viewDataBinding, i10, this, referenceQueue);
        }

        @Override // androidx.databinding.l
        public void a(InterfaceC0492o interfaceC0492o) {
            InterfaceC0492o e10 = e();
            LiveData<?> b10 = this.f9643a.b();
            if (b10 != null) {
                if (e10 != null) {
                    b10.n(this);
                }
                if (interfaceC0492o != null) {
                    b10.i(interfaceC0492o, this);
                }
            }
            if (interfaceC0492o != null) {
                this.f9644b = new WeakReference<>(interfaceC0492o);
            }
        }

        @Override // androidx.databinding.l
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void c(LiveData<?> liveData) {
            InterfaceC0492o e10 = e();
            if (e10 != null) {
                liveData.i(e10, this);
            }
        }

        public final InterfaceC0492o e() {
            WeakReference<InterfaceC0492o> weakReference = this.f9644b;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }

        public p<LiveData<?>> f() {
            return this.f9643a;
        }

        @Override // androidx.databinding.l
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void b(LiveData<?> liveData) {
            liveData.n(this);
        }

        @Override // androidx.lifecycle.w
        public void onChanged(Object obj) {
            ViewDataBinding a10 = this.f9643a.a();
            if (a10 != null) {
                p<LiveData<?>> pVar = this.f9643a;
                a10.L0(pVar.f9668b, pVar.b(), 0);
            }
        }
    }

    public ViewDataBinding(androidx.databinding.f fVar, View view, int i10) {
        this.f9621b = new g();
        this.f9622c = false;
        this.f9623d = false;
        this.f9631l = fVar;
        this.f9624e = new p[i10];
        this.f9625f = view;
        if (Looper.myLooper() != null) {
            if (f9619y) {
                this.f9628i = Choreographer.getInstance();
                this.f9629j = new h();
                return;
            } else {
                this.f9629j = null;
                this.f9630k = new Handler(Looper.myLooper());
                return;
            }
        }
        throw new IllegalStateException("DataBinding must be created in view's UI Thread");
    }

    public static void C0(ViewDataBinding viewDataBinding) {
        viewDataBinding.B0();
    }

    public static int E0(String str, int i10, i iVar, int i11) {
        CharSequence subSequence = str.subSequence(str.indexOf(47) + 1, str.length() - 2);
        String[] strArr = iVar.f9640a[i11];
        int length = strArr.length;
        while (i10 < length) {
            if (TextUtils.equals(subSequence, strArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static int F0(ViewGroup viewGroup, int i10) {
        String str;
        String str2 = (String) viewGroup.getChildAt(i10).getTag();
        String substring = str2.substring(0, str2.length() - 1);
        int length = substring.length();
        int childCount = viewGroup.getChildCount();
        for (int i11 = i10 + 1; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt.getTag() instanceof String) {
                str = (String) childAt.getTag();
            } else {
                str = null;
            }
            if (str != null && str.startsWith(substring)) {
                if (str.length() == str2.length() && str.charAt(str.length() - 1) == '0') {
                    return i10;
                }
                if (P0(str, length)) {
                    i10 = i11;
                }
            }
        }
        return i10;
    }

    public static ViewDataBinding H0(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(M.a.f1737a);
        }
        return null;
    }

    public static int I0() {
        return f9617r;
    }

    public static int J0(View view, int i10) {
        return view.getContext().getColor(i10);
    }

    public static <T extends ViewDataBinding> T N0(LayoutInflater layoutInflater, int i10, ViewGroup viewGroup, boolean z10, Object obj) {
        return (T) androidx.databinding.g.i(layoutInflater, i10, viewGroup, z10, z0(obj));
    }

    public static boolean P0(String str, int i10) {
        int length = str.length();
        if (length == i10) {
            return false;
        }
        while (i10 < length) {
            if (!Character.isDigit(str.charAt(i10))) {
                return false;
            }
            i10++;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0113 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void Q0(androidx.databinding.f r17, android.view.View r18, java.lang.Object[] r19, androidx.databinding.ViewDataBinding.i r20, android.util.SparseIntArray r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.ViewDataBinding.Q0(androidx.databinding.f, android.view.View, java.lang.Object[], androidx.databinding.ViewDataBinding$i, android.util.SparseIntArray, boolean):void");
    }

    public static Object[] R0(androidx.databinding.f fVar, View view, int i10, i iVar, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i10];
        Q0(fVar, view, objArr, iVar, sparseIntArray, true);
        return objArr;
    }

    public static int T0(String str, int i10) {
        int i11 = 0;
        while (i10 < str.length()) {
            i11 = (i11 * 10) + (str.charAt(i10) - '0');
            i10++;
        }
        return i11;
    }

    public static void U0() {
        while (true) {
            Reference<? extends ViewDataBinding> poll = f9615E.poll();
            if (poll != null) {
                if (poll instanceof p) {
                    ((p) poll).e();
                }
            } else {
                return;
            }
        }
    }

    public static float X0(Float f10) {
        if (f10 == null) {
            return 0.0f;
        }
        return f10.floatValue();
    }

    public static int Y0(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static boolean Z0(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static ViewDataBinding y0(Object obj, View view, int i10) {
        return androidx.databinding.g.c(z0(obj), view, i10);
    }

    public static androidx.databinding.f z0(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof androidx.databinding.f) {
            return (androidx.databinding.f) obj;
        }
        throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
    }

    public abstract void A0();

    public final void B0() {
        if (this.f9627h) {
            W0();
            return;
        }
        if (!M0()) {
            return;
        }
        this.f9627h = true;
        this.f9623d = false;
        androidx.databinding.c<androidx.databinding.m, ViewDataBinding, Void> cVar = this.f9626g;
        if (cVar != null) {
            cVar.d(this, 1, null);
            if (this.f9623d) {
                this.f9626g.d(this, 2, null);
            }
        }
        if (!this.f9623d) {
            A0();
            androidx.databinding.c<androidx.databinding.m, ViewDataBinding, Void> cVar2 = this.f9626g;
            if (cVar2 != null) {
                cVar2.d(this, 3, null);
            }
        }
        this.f9627h = false;
    }

    public void D0() {
        ViewDataBinding viewDataBinding = this.f9632m;
        if (viewDataBinding == null) {
            B0();
        } else {
            viewDataBinding.D0();
        }
    }

    public void G0() {
        A0();
    }

    public View K0() {
        return this.f9625f;
    }

    public void L0(int i10, Object obj, int i11) {
        if (!this.f9635p && !this.f9636q && S0(i10, obj, i11)) {
            W0();
        }
    }

    public abstract boolean M0();

    public abstract void O0();

    public abstract boolean S0(int i10, Object obj, int i11);

    public void V0(int i10, Object obj, androidx.databinding.d dVar) {
        if (obj == null) {
            return;
        }
        p pVar = this.f9624e[i10];
        if (pVar == null) {
            pVar = dVar.a(this, i10, f9615E);
            this.f9624e[i10] = pVar;
            InterfaceC0492o interfaceC0492o = this.f9633n;
            if (interfaceC0492o != null) {
                pVar.c(interfaceC0492o);
            }
        }
        pVar.d(obj);
    }

    public void W0() {
        ViewDataBinding viewDataBinding = this.f9632m;
        if (viewDataBinding != null) {
            viewDataBinding.W0();
            return;
        }
        InterfaceC0492o interfaceC0492o = this.f9633n;
        if (interfaceC0492o != null && !interfaceC0492o.getLifecycle().b().b(Lifecycle.State.STARTED)) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f9622c) {
                    return;
                }
                this.f9622c = true;
                if (f9619y) {
                    this.f9628i.postFrameCallback(this.f9629j);
                } else {
                    this.f9630k.post(this.f9621b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a1(ViewDataBinding viewDataBinding) {
        if (viewDataBinding != null) {
            viewDataBinding.f9632m = this;
        }
    }

    public void b1(InterfaceC0492o interfaceC0492o) {
        if (interfaceC0492o instanceof Fragment) {
            Log.w("DataBinding", "Setting the fragment as the LifecycleOwner might cause memory leaks because views lives shorter than the Fragment. Consider using Fragment's view lifecycle");
        }
        InterfaceC0492o interfaceC0492o2 = this.f9633n;
        if (interfaceC0492o2 == interfaceC0492o) {
            return;
        }
        if (interfaceC0492o2 != null) {
            interfaceC0492o2.getLifecycle().d(this.f9634o);
        }
        this.f9633n = interfaceC0492o;
        if (interfaceC0492o != null) {
            if (this.f9634o == null) {
                this.f9634o = new OnStartListener(this, null);
            }
            interfaceC0492o.getLifecycle().a(this.f9634o);
        }
        for (p pVar : this.f9624e) {
            if (pVar != null) {
                pVar.c(interfaceC0492o);
            }
        }
    }

    public void c1(View view) {
        view.setTag(M.a.f1737a, this);
    }

    public abstract boolean d1(int i10, Object obj);

    public boolean e1(int i10) {
        p pVar = this.f9624e[i10];
        if (pVar != null) {
            return pVar.e();
        }
        return false;
    }

    public boolean f1(int i10, LiveData<?> liveData) {
        this.f9635p = true;
        try {
            return h1(i10, liveData, f9613C);
        } finally {
            this.f9635p = false;
        }
    }

    public boolean g1(int i10, androidx.databinding.i iVar) {
        return h1(i10, iVar, f9620z);
    }

    public boolean h1(int i10, Object obj, androidx.databinding.d dVar) {
        if (obj == null) {
            return e1(i10);
        }
        p pVar = this.f9624e[i10];
        if (pVar == null) {
            V0(i10, obj, dVar);
            return true;
        }
        if (pVar.b() == obj) {
            return false;
        }
        e1(i10);
        V0(i10, obj, dVar);
        return true;
    }

    public ViewDataBinding(Object obj, View view, int i10) {
        this(z0(obj), view, i10);
    }

    /* loaded from: classes.dex */
    public class f implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            ViewDataBinding.H0(view).f9621b.run();
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* loaded from: classes.dex */
    public static class k extends j.a implements androidx.databinding.l<androidx.databinding.j> {

        /* renamed from: a, reason: collision with root package name */
        public final p<androidx.databinding.j> f9645a;

        public k(ViewDataBinding viewDataBinding, int i10, ReferenceQueue<ViewDataBinding> referenceQueue) {
            this.f9645a = new p<>(viewDataBinding, i10, this, referenceQueue);
        }

        @Override // androidx.databinding.l
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void c(androidx.databinding.j jVar) {
            jVar.f(this);
        }

        public p<androidx.databinding.j> e() {
            return this.f9645a;
        }

        @Override // androidx.databinding.l
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(androidx.databinding.j jVar) {
            jVar.b(this);
        }

        @Override // androidx.databinding.l
        public void a(InterfaceC0492o interfaceC0492o) {
        }
    }

    /* loaded from: classes.dex */
    public static class l extends k.a implements androidx.databinding.l<androidx.databinding.k> {

        /* renamed from: a, reason: collision with root package name */
        public final p<androidx.databinding.k> f9646a;

        public l(ViewDataBinding viewDataBinding, int i10, ReferenceQueue<ViewDataBinding> referenceQueue) {
            this.f9646a = new p<>(viewDataBinding, i10, this, referenceQueue);
        }

        @Override // androidx.databinding.l
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void c(androidx.databinding.k kVar) {
            kVar.a(this);
        }

        public p<androidx.databinding.k> e() {
            return this.f9646a;
        }

        @Override // androidx.databinding.l
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(androidx.databinding.k kVar) {
            kVar.c(this);
        }

        @Override // androidx.databinding.l
        public void a(InterfaceC0492o interfaceC0492o) {
        }
    }

    /* loaded from: classes.dex */
    public static class m extends i.a implements androidx.databinding.l<androidx.databinding.i> {

        /* renamed from: a, reason: collision with root package name */
        public final p<androidx.databinding.i> f9647a;

        public m(ViewDataBinding viewDataBinding, int i10, ReferenceQueue<ViewDataBinding> referenceQueue) {
            this.f9647a = new p<>(viewDataBinding, i10, this, referenceQueue);
        }

        @Override // androidx.databinding.i.a
        public void d(androidx.databinding.i iVar, int i10) {
            ViewDataBinding a10 = this.f9647a.a();
            if (a10 == null || this.f9647a.b() != iVar) {
                return;
            }
            a10.L0(this.f9647a.f9668b, iVar, i10);
        }

        @Override // androidx.databinding.l
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(androidx.databinding.i iVar) {
            iVar.f(this);
        }

        public p<androidx.databinding.i> f() {
            return this.f9647a;
        }

        @Override // androidx.databinding.l
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void b(androidx.databinding.i iVar) {
            iVar.l0(this);
        }

        @Override // androidx.databinding.l
        public void a(InterfaceC0492o interfaceC0492o) {
        }
    }
}
