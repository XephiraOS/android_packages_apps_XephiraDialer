package s2;

import android.util.DisplayMetrics;
import com.android.incallui.mvvm.utils.h;
import com.android.incallui.mvvm.utils.y;
import kotlin.jvm.internal.i;

/* compiled from: SystemConfigUseCases.kt */
/* renamed from: s2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1529e extends J1.b {

    /* renamed from: b, reason: collision with root package name */
    public final r2.e f36743b;

    /* renamed from: c, reason: collision with root package name */
    public final y<Integer> f36744c;

    /* renamed from: d, reason: collision with root package name */
    public final h<Integer> f36745d;

    /* renamed from: e, reason: collision with root package name */
    public final y<DisplayMetrics> f36746e;

    /* renamed from: f, reason: collision with root package name */
    public final y<Boolean> f36747f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1529e(r2.e repository) {
        super(repository);
        i.f(repository, "repository");
        this.f36743b = repository;
        this.f36744c = repository.f1();
        this.f36745d = repository.H0();
        this.f36746e = repository.L();
        this.f36747f = repository.a0();
    }

    public final int b() {
        return this.f36743b.v();
    }

    public final int c() {
        return this.f36743b.G0();
    }

    public final int d() {
        return this.f36743b.A();
    }

    public final int e() {
        return this.f36743b.I();
    }

    public final y<DisplayMetrics> f() {
        return this.f36746e;
    }

    public final int g() {
        return this.f36743b.z1();
    }

    public final int h() {
        return this.f36743b.T();
    }

    public final int i() {
        return this.f36743b.C1();
    }

    public final int j() {
        return this.f36743b.B1();
    }

    public final int k() {
        return this.f36743b.l();
    }

    public final int l() {
        return this.f36743b.z0();
    }

    public final int m() {
        return this.f36743b.u0();
    }

    public final int n() {
        return this.f36743b.b0();
    }

    public final int o() {
        return this.f36743b.Z();
    }

    public final int p() {
        return this.f36743b.O();
    }

    public final int q() {
        return this.f36743b.X();
    }

    public final y<Integer> r() {
        return this.f36744c;
    }

    public final h<Integer> s() {
        return this.f36745d;
    }

    public final y<Boolean> t() {
        return this.f36747f;
    }

    public final boolean u() {
        return this.f36743b.v0();
    }
}
