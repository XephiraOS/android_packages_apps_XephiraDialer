package f7;

import com.oplus.epona.Call$Callback;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.epona.f;
import java.util.List;

/* compiled from: RealInterceptorChain.java */
/* loaded from: classes3.dex */
public class g implements f.a {

    /* renamed from: a, reason: collision with root package name */
    public final List<com.oplus.epona.f> f31787a;

    /* renamed from: b, reason: collision with root package name */
    public final int f31788b;

    /* renamed from: c, reason: collision with root package name */
    public final Request f31789c;

    /* renamed from: d, reason: collision with root package name */
    public final Call$Callback f31790d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f31791e;

    public g(List<com.oplus.epona.f> list, int i10, Request request, Call$Callback call$Callback, boolean z10) {
        this.f31787a = list;
        this.f31788b = i10;
        this.f31789c = request;
        this.f31790d = call$Callback;
        this.f31791e = z10;
    }

    @Override // com.oplus.epona.f.a
    public Call$Callback a() {
        return this.f31790d;
    }

    @Override // com.oplus.epona.f.a
    public void b() {
        if (this.f31788b < this.f31787a.size()) {
            this.f31787a.get(this.f31788b).a(e(this.f31788b + 1));
            return;
        }
        this.f31790d.onReceive(Response.f(this.f31789c.getComponentName() + "#" + this.f31789c.getActionName() + " cannot be proceeded"));
    }

    @Override // com.oplus.epona.f.a
    public boolean c() {
        return this.f31791e;
    }

    @Override // com.oplus.epona.f.a
    public Request d() {
        return this.f31789c;
    }

    public final g e(int i10) {
        return new g(this.f31787a, i10, this.f31789c, this.f31790d, this.f31791e);
    }
}
