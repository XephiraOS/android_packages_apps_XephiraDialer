package S9;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.stream.EntityState;
import org.apache.james.mime4j.stream.RecursionMode;

/* compiled from: MimeTokenStream.java */
/* loaded from: classes4.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public final k f3659a;

    /* renamed from: b, reason: collision with root package name */
    public final K9.c f3660b;

    /* renamed from: c, reason: collision with root package name */
    public final j f3661c;

    /* renamed from: d, reason: collision with root package name */
    public final c f3662d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedList<f> f3663e;

    /* renamed from: f, reason: collision with root package name */
    public EntityState f3664f;

    /* renamed from: g, reason: collision with root package name */
    public f f3665g;

    /* renamed from: h, reason: collision with root package name */
    public RecursionMode f3666h;

    /* renamed from: i, reason: collision with root package name */
    public l f3667i;

    public m(k kVar, K9.c cVar, c cVar2) {
        this(kVar, cVar, null, cVar2);
    }

    public final void a(InputStream inputStream, EntityState entityState) {
        InputStream inputStream2;
        P9.d dVar;
        if (this.f3659a.g()) {
            dVar = new P9.d(inputStream);
            inputStream2 = dVar;
        } else {
            inputStream2 = inputStream;
            dVar = null;
        }
        l lVar = new l(dVar, inputStream2, this.f3659a, entityState, EntityState.T_END_MESSAGE, this.f3660b, this.f3661c, this.f3662d);
        this.f3667i = lVar;
        lVar.e(this.f3666h);
        this.f3665g = this.f3667i;
        this.f3663e.clear();
        this.f3663e.add(this.f3665g);
        this.f3664f = this.f3665g.getState();
    }

    public b b() {
        return this.f3665g.c();
    }

    public k c() {
        return this.f3659a;
    }

    public InputStream d() {
        return this.f3665g.f();
    }

    public i e() {
        return this.f3665g.b();
    }

    public InputStream f() {
        return this.f3665g.d();
    }

    public EntityState g() {
        return this.f3664f;
    }

    public EntityState h() {
        if (this.f3664f == EntityState.T_END_OF_STREAM || this.f3665g == null) {
            throw new IllegalStateException("No more tokens are available.");
        }
        while (true) {
            f fVar = this.f3665g;
            if (fVar != null) {
                f a10 = fVar.a();
                if (a10 != null) {
                    this.f3663e.add(a10);
                    this.f3665g = a10;
                }
                EntityState state = this.f3665g.getState();
                this.f3664f = state;
                if (state != EntityState.T_END_OF_STREAM) {
                    return state;
                }
                this.f3663e.removeLast();
                if (this.f3663e.isEmpty()) {
                    this.f3665g = null;
                } else {
                    f last = this.f3663e.getLast();
                    this.f3665g = last;
                    last.e(this.f3666h);
                }
            } else {
                EntityState entityState = EntityState.T_END_OF_STREAM;
                this.f3664f = entityState;
                return entityState;
            }
        }
    }

    public void i(InputStream inputStream) {
        a(inputStream, EntityState.T_START_MESSAGE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [S9.i] */
    public i j(InputStream inputStream, String str) {
        if (str != null) {
            try {
                r rVar = new r("Content-Type", str);
                ?? a10 = this.f3662d.a(rVar);
                if (a10 != 0) {
                    rVar = a10;
                }
                a(inputStream, EntityState.T_END_HEADER);
                try {
                    h();
                    return rVar;
                } catch (IOException e10) {
                    throw new IllegalStateException(e10);
                } catch (MimeException e11) {
                    throw new IllegalStateException(e11);
                }
            } catch (MimeException e12) {
                throw new IllegalArgumentException(e12.getMessage());
            }
        }
        throw new IllegalArgumentException("Content type may not be null");
    }

    public m(k kVar, K9.c cVar, j jVar, c cVar2) {
        this.f3663e = new LinkedList<>();
        this.f3664f = EntityState.T_END_OF_STREAM;
        this.f3666h = RecursionMode.M_RECURSE;
        kVar = kVar == null ? new k() : kVar;
        this.f3659a = kVar;
        this.f3661c = jVar == null ? new e(kVar.e()) : jVar;
        this.f3660b = cVar == null ? kVar.i() ? K9.c.f1689a : K9.c.f1690b : cVar;
        this.f3662d = cVar2 == null ? new h() : cVar2;
    }
}
