package C5;

import com.heytap.epona.Request;
import com.heytap.epona.Response;
import com.heytap.epona.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RealInterceptorChain.java */
/* loaded from: classes3.dex */
public class f implements d.a {

    /* renamed from: a, reason: collision with root package name */
    public final List<com.heytap.epona.d> f374a;

    /* renamed from: b, reason: collision with root package name */
    public final int f375b;

    /* renamed from: c, reason: collision with root package name */
    public final Request f376c;

    /* renamed from: d, reason: collision with root package name */
    public final com.heytap.epona.a f377d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f378e;

    public f(List<com.heytap.epona.d> list, int i10, Request request, com.heytap.epona.a aVar, boolean z10) {
        ArrayList arrayList = new ArrayList();
        this.f374a = arrayList;
        arrayList.addAll(list);
        this.f375b = i10;
        this.f376c = request;
        this.f377d = aVar;
        this.f378e = z10;
    }

    @Override // com.heytap.epona.d.a
    public com.heytap.epona.a a() {
        return this.f377d;
    }

    @Override // com.heytap.epona.d.a
    public void b() {
        if (this.f375b < this.f374a.size()) {
            this.f374a.get(this.f375b).a(e(this.f375b + 1));
        } else {
            this.f377d.O(Response.d());
        }
    }

    @Override // com.heytap.epona.d.a
    public boolean c() {
        return this.f378e;
    }

    @Override // com.heytap.epona.d.a
    public Request d() {
        return this.f376c;
    }

    public final f e(int i10) {
        return new f(this.f374a, i10, this.f376c, this.f377d, this.f378e);
    }
}
