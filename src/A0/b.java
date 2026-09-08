package A0;

import android.content.res.Resources;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.android.contacts.dialerui.dialer.SatelliteDialer;
import com.android.contacts.dialerui.dialer.c;
import com.android.contacts.dialerui.dialer.e;
import com.android.contacts.dialerui.dialer.l;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: DialerManager.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: k, reason: collision with root package name */
    public static final a f55k = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Fragment f56a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewGroup f57b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f58c;

    /* renamed from: d, reason: collision with root package name */
    public com.android.contacts.dialerui.dialer.b f59d;

    /* renamed from: e, reason: collision with root package name */
    public e f60e;

    /* renamed from: f, reason: collision with root package name */
    public c f61f;

    /* renamed from: g, reason: collision with root package name */
    public l f62g;

    /* renamed from: h, reason: collision with root package name */
    public SatelliteDialer f63h;

    /* renamed from: i, reason: collision with root package name */
    public String f64i;

    /* renamed from: j, reason: collision with root package name */
    public A0.a f65j;

    /* compiled from: DialerManager.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public b(Fragment fragment, ViewGroup root, boolean z10) {
        i.f(fragment, "fragment");
        i.f(root, "root");
        this.f56a = fragment;
        this.f57b = root;
        this.f58c = z10;
        H7.b.e("DialerManager", "isSupportUstVideoView : " + z10);
    }

    public final void a(String text) {
        i.f(text, "text");
        this.f64i = text;
        com.android.contacts.dialerui.dialer.b bVar = this.f59d;
        if (bVar != null) {
            bVar.b(text);
        }
    }

    public final com.android.contacts.dialerui.dialer.b b(boolean z10, int i10, int i11) {
        H7.b.e("DialerManager", "get: " + z10 + ", " + i10 + ", " + i11);
        if (z10 && i10 > 0) {
            if (this.f63h == null) {
                this.f63h = new SatelliteDialer(this.f56a, this.f57b, 4);
            }
            return this.f63h;
        }
        if (i10 <= 1) {
            if (this.f60e == null) {
                this.f60e = new e(this.f56a, this.f57b, 1, this.f58c);
            }
            return this.f60e;
        }
        if (i10 == 2) {
            if (i11 != 0 && i11 != 1) {
                if (this.f61f == null) {
                    this.f61f = new c(this.f56a, this.f57b, 2);
                }
                return this.f61f;
            }
            if (this.f62g == null) {
                this.f62g = new l(this.f56a, this.f57b, 3);
            }
            return this.f62g;
        }
        H7.b.i("DialerManager", " Should not reach here ");
        if (this.f60e == null) {
            this.f60e = new e(this.f56a, this.f57b, 1, this.f58c);
        }
        return this.f60e;
    }

    public final int c() {
        com.android.contacts.dialerui.dialer.b bVar = this.f59d;
        if (bVar != null) {
            return bVar.c();
        }
        return -1;
    }

    public final boolean d() {
        com.android.contacts.dialerui.dialer.b bVar = this.f59d;
        if (bVar != null) {
            return bVar.n();
        }
        return true;
    }

    public final void e(A0.a aVar) {
        this.f65j = aVar;
    }

    public final void f(boolean z10, int i10, int i11, boolean z11, boolean z12, boolean z13) {
        int i12;
        com.android.contacts.dialerui.dialer.b b10 = b(z10, i10, i11);
        String str = null;
        if (this.f59d == null) {
            if (b10 != null) {
                b10.m(i11, z11, z12, z13);
                b10.x(this.f64i);
                b10.D();
            } else {
                b10 = null;
            }
            this.f59d = b10;
        } else {
            if (b10 != null) {
                i12 = b10.i();
            } else {
                i12 = -1;
            }
            com.android.contacts.dialerui.dialer.b bVar = this.f59d;
            i.c(bVar);
            int i13 = bVar.i();
            H7.b.e("DialerManager", "update: type: " + i12 + ", " + i13);
            if (i13 != i12) {
                if (b10 != null) {
                    com.android.contacts.dialerui.dialer.b bVar2 = this.f59d;
                    if (bVar2 != null) {
                        bVar2.k();
                    }
                    this.f59d = b10;
                    b10.m(i11, z11, z12, z13);
                    b10.x(this.f64i);
                    b10.D();
                }
            } else {
                com.android.contacts.dialerui.dialer.b bVar3 = this.f59d;
                if (bVar3 != null) {
                    bVar3.E(i11, z11, z12, z13);
                    bVar3.x(this.f64i);
                    bVar3.D();
                }
            }
        }
        com.android.contacts.dialerui.dialer.b bVar4 = this.f59d;
        if (bVar4 != null) {
            bVar4.y(this.f65j);
        }
        com.android.contacts.dialerui.dialer.b bVar5 = this.f59d;
        if (bVar5 != null) {
            str = bVar5.getClass().getSimpleName();
        }
        H7.b.e("DialerManager", "update: show: " + str);
    }

    public final void g(Resources resources, int i10) {
        i.f(resources, "resources");
        com.android.contacts.dialerui.dialer.b bVar = this.f59d;
        if (bVar != null) {
            bVar.F(resources, i10);
        }
    }
}
