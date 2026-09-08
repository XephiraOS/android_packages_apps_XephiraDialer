package o2;

import D2.b;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import com.android.incallui.Call;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import r2.InterfaceC1505b;
import w2.InterfaceC1646a;

/* compiled from: ContactInfoRepository.kt */
/* loaded from: classes.dex */
public final class h implements InterfaceC1505b, b.a, InterfaceC1646a {

    /* renamed from: i, reason: collision with root package name */
    public static final a f35712i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Handler f35713a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public final ObservableBoolean f35714b = new ObservableBoolean();

    /* renamed from: c, reason: collision with root package name */
    public final ObservableInt f35715c = new ObservableInt(-1);

    /* renamed from: d, reason: collision with root package name */
    public final LocalObservableField<String> f35716d = new LocalObservableField<>(null, null, null, null, 15, null);

    /* renamed from: e, reason: collision with root package name */
    public final LocalObservableField<String> f35717e = new LocalObservableField<>(null, null, null, null, 15, null);

    /* renamed from: f, reason: collision with root package name */
    public final LocalObservableField<String> f35718f = new LocalObservableField<>(null, null, null, null, 15, null);

    /* renamed from: g, reason: collision with root package name */
    public final LocalObservableField<String> f35719g = new LocalObservableField<>(null, null, null, null, 15, null);

    /* renamed from: h, reason: collision with root package name */
    public final LocalObservableField<String> f35720h = new LocalObservableField<>(null, null, null, null, 15, null);

    /* compiled from: ContactInfoRepository.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public static final void G1(h this$0, String content, Integer num) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(content, "$content");
        Toast makeText = Toast.makeText(this$0.F1(), content, 1);
        if (num != null) {
            makeText.setGravity(80, 0, num.intValue());
        }
        makeText.show();
    }

    @Override // d2.InterfaceC0949b
    public OplusInCallPresenter C0() {
        return InterfaceC1505b.a.c(this);
    }

    @Override // r2.InterfaceC1505b
    public ObservableBoolean D() {
        return this.f35714b;
    }

    public A2.j E1() {
        return InterfaceC1505b.a.a(this);
    }

    public Context F1() {
        return InterfaceC1505b.a.b(this);
    }

    @Override // r2.InterfaceC1505b
    public LocalObservableField<String> M0() {
        return this.f35718f;
    }

    @Override // r2.InterfaceC1505b
    public void N() {
        E1().n(this);
    }

    @Override // D2.b.a
    public void N0(String str) {
        x().x0(str);
    }

    @Override // r2.InterfaceC1505b
    public ObservableInt O0() {
        return this.f35715c;
    }

    @Override // r2.InterfaceC1505b
    public void Y(Call call) {
        D2.b.o(F1(), call, this, true);
    }

    @Override // w2.InterfaceC1646a
    public void c0() {
        D().t0(!D().s0());
    }

    @Override // D2.b.a
    public void e0(String str, int i10, boolean z10, boolean z11) {
        q0().x0(str);
        O0().t0(i10);
    }

    @Override // d2.InterfaceC0949b
    public void f() {
        InterfaceC1505b.a.d(this);
    }

    @Override // D2.b.a
    public void h1(String str, boolean z10) {
        w1().x0(str);
    }

    @Override // D2.b.a
    public void k0(String str, String str2, String str3, int i10) {
        M0().x0(str);
    }

    @Override // r2.InterfaceC1505b
    public LocalObservableField<String> n1() {
        return this.f35720h;
    }

    @Override // r2.InterfaceC1505b
    public LocalObservableField<String> q0() {
        return this.f35717e;
    }

    @Override // r2.InterfaceC1505b
    public void q1(final String content, final Integer num) {
        kotlin.jvm.internal.i.f(content, "content");
        this.f35713a.post(new Runnable() { // from class: o2.g
            @Override // java.lang.Runnable
            public final void run() {
                h.G1(h.this, content, num);
            }
        });
    }

    @Override // D2.b.a
    public void r1(String str) {
        n1().x0(str);
    }

    @Override // r2.InterfaceC1505b
    public LocalObservableField<String> w1() {
        return this.f35716d;
    }

    @Override // r2.InterfaceC1505b
    public LocalObservableField<String> x() {
        return this.f35719g;
    }

    @Override // r2.InterfaceC1505b
    public void y() {
        E1().n(null);
        O0().t0(-1);
        w1().x0(null);
        q0().x0(null);
        M0().x0(null);
        x().x0(null);
        n1().x0(null);
    }
}
