package q7;

import android.app.Activity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import q7.InterfaceC1492a;

/* compiled from: StatusBarClickControllerImpl.kt */
/* renamed from: q7.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1493b implements InterfaceC1492a, COUIStatusBarResponseUtil.StatusBarClickListener {

    /* renamed from: i, reason: collision with root package name */
    public static final a f36217i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public COUIStatusBarResponseUtil f36218a;

    /* renamed from: b, reason: collision with root package name */
    public int f36219b;

    /* renamed from: c, reason: collision with root package name */
    public RecyclerView f36220c;

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC1494c f36221d;

    /* renamed from: e, reason: collision with root package name */
    public RunnableC0346b f36222e;

    /* renamed from: f, reason: collision with root package name */
    public Activity f36223f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f36224g;

    /* renamed from: h, reason: collision with root package name */
    public final c f36225h = new c();

    /* compiled from: StatusBarClickControllerImpl.kt */
    /* renamed from: q7.b$a */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: StatusBarClickControllerImpl.kt */
    /* renamed from: q7.b$c */
    /* loaded from: classes3.dex */
    public static final class c extends RecyclerView.s {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            InterfaceC1494c interfaceC1494c;
            i.f(recyclerView, "recyclerView");
            if (i10 == 0) {
                if (C1493b.this.f36224g && !recyclerView.canScrollVertically(-1) && (interfaceC1494c = C1493b.this.f36221d) != null) {
                    interfaceC1494c.R0();
                }
                C1493b.this.f36224g = false;
            }
            C1493b.this.f36219b = i10;
        }
    }

    @Override // q7.InterfaceC1492a
    public void F() {
        RecyclerView recyclerView = this.f36220c;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this.f36225h);
        }
        this.f36223f = null;
    }

    @Override // q7.InterfaceC1492a
    public void H0() {
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = this.f36218a;
        if (cOUIStatusBarResponseUtil != null) {
            cOUIStatusBarResponseUtil.onResume();
        }
    }

    @Override // q7.InterfaceC1492a
    public void T0(Activity activity, RecyclerView recyclerView, InterfaceC1494c interfaceC1494c) {
        i.f(activity, "activity");
        if (recyclerView != null) {
            COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(activity);
            cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
            this.f36218a = cOUIStatusBarResponseUtil;
            this.f36223f = activity;
            this.f36220c = recyclerView;
            this.f36221d = interfaceC1494c;
            this.f36222e = new RunnableC0346b(this, recyclerView, 0, 0, 6, null);
            recyclerView.addOnScrollListener(this.f36225h);
        }
    }

    public boolean e() {
        return InterfaceC1492a.C0345a.a(this);
    }

    public final boolean f() {
        Activity activity = this.f36223f;
        if (activity != null && activity.hasWindowFocus()) {
            if (!this.f36224g) {
                return true;
            }
            H7.b.e("StatusBarClickControllerImpl", "canResponseStatusBarClickInner() isClickScrollRunning true");
            return false;
        }
        H7.b.e("StatusBarClickControllerImpl", "canResponseStatusBarClickInner() hasWindowFocus() false");
        return false;
    }

    @Override // com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        RecyclerView recyclerView;
        Activity activity;
        H7.b.e("StatusBarClickControllerImpl", "onStatusBarClicked() --------------");
        if (f() && e() && (recyclerView = this.f36220c) != null) {
            int i10 = this.f36219b;
            if (i10 != 1) {
                if (i10 == 2) {
                    if (!recyclerView.canScrollVertically(-1)) {
                        return;
                    } else {
                        recyclerView.stopScroll();
                    }
                }
            } else {
                recyclerView.stopScroll();
            }
            InterfaceC1494c interfaceC1494c = this.f36221d;
            if (interfaceC1494c != null) {
                interfaceC1494c.e0();
            }
            if (!recyclerView.canScrollVertically(-1) && (activity = this.f36223f) != null && !activity.isInMultiWindowMode()) {
                this.f36224g = false;
                InterfaceC1494c interfaceC1494c2 = this.f36221d;
                if (interfaceC1494c2 != null) {
                    interfaceC1494c2.R0();
                    return;
                }
                return;
            }
            RunnableC0346b runnableC0346b = this.f36222e;
            if (runnableC0346b != null) {
                this.f36224g = true;
                recyclerView.postOnAnimation(runnableC0346b);
            }
        }
    }

    @Override // q7.InterfaceC1492a
    public void p() {
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = this.f36218a;
        if (cOUIStatusBarResponseUtil != null) {
            cOUIStatusBarResponseUtil.onPause();
        }
        RecyclerView recyclerView = this.f36220c;
        if (recyclerView != null && recyclerView.getScrollState() == 0) {
            this.f36224g = false;
        }
    }

    /* compiled from: StatusBarClickControllerImpl.kt */
    /* renamed from: q7.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public final class RunnableC0346b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final RecyclerView f36226a;

        /* renamed from: b, reason: collision with root package name */
        public final int f36227b;

        /* renamed from: c, reason: collision with root package name */
        public final int f36228c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ C1493b f36229d;

        public RunnableC0346b(C1493b c1493b, RecyclerView recyclerView, int i10, int i11) {
            i.f(recyclerView, "recyclerView");
            this.f36229d = c1493b;
            this.f36226a = recyclerView;
            this.f36227b = i10;
            this.f36228c = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            LinearLayoutManager linearLayoutManager;
            RecyclerView.o layoutManager = this.f36226a.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                linearLayoutManager = (LinearLayoutManager) layoutManager;
            } else {
                linearLayoutManager = null;
            }
            if (linearLayoutManager != null) {
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                H7.b.e("StatusBarClickControllerImpl", "SmoothScrollToTopTask run()  -------------  ");
                int i10 = this.f36227b;
                if (findFirstVisibleItemPosition > i10) {
                    this.f36226a.scrollToPosition(i10);
                    this.f36226a.postOnAnimation(this);
                } else {
                    this.f36226a.smoothScrollToPosition(0);
                }
            }
        }

        public /* synthetic */ RunnableC0346b(C1493b c1493b, RecyclerView recyclerView, int i10, int i11, int i12, f fVar) {
            this(c1493b, recyclerView, (i12 & 2) != 0 ? 10 : i10, (i12 & 4) != 0 ? 600 : i11);
        }
    }
}
