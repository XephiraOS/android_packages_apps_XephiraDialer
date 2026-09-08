package S9;

import java.io.InputStream;
import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.io.MaxHeaderLimitException;
import org.apache.james.mime4j.io.MaxLineLimitException;
import org.apache.james.mime4j.stream.EntityState;
import org.apache.james.mime4j.stream.MimeParseEventException;
import org.apache.james.mime4j.stream.RecursionMode;
import org.apache.james.mime4j.util.MimeUtil;

/* compiled from: MimeEntity.java */
/* loaded from: classes4.dex */
public class l implements f {

    /* renamed from: a, reason: collision with root package name */
    public final EntityState f3640a;

    /* renamed from: b, reason: collision with root package name */
    public final k f3641b;

    /* renamed from: c, reason: collision with root package name */
    public final K9.c f3642c;

    /* renamed from: d, reason: collision with root package name */
    public final j f3643d;

    /* renamed from: e, reason: collision with root package name */
    public final c f3644e;

    /* renamed from: g, reason: collision with root package name */
    public final P9.e f3646g;

    /* renamed from: h, reason: collision with root package name */
    public final P9.a f3647h;

    /* renamed from: i, reason: collision with root package name */
    public EntityState f3648i;

    /* renamed from: m, reason: collision with root package name */
    public i f3652m;

    /* renamed from: n, reason: collision with root package name */
    public b f3653n;

    /* renamed from: o, reason: collision with root package name */
    public RecursionMode f3654o;

    /* renamed from: p, reason: collision with root package name */
    public P9.h f3655p;

    /* renamed from: q, reason: collision with root package name */
    public P9.g f3656q;

    /* renamed from: r, reason: collision with root package name */
    public byte[] f3657r;

    /* renamed from: f, reason: collision with root package name */
    public final T9.a f3645f = new T9.a(64);

    /* renamed from: j, reason: collision with root package name */
    public int f3649j = 0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3650k = false;

    /* renamed from: l, reason: collision with root package name */
    public int f3651l = 0;

    /* compiled from: MimeEntity.java */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3658a;

        static {
            int[] iArr = new int[EntityState.values().length];
            f3658a = iArr;
            try {
                iArr[EntityState.T_START_MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3658a[EntityState.T_START_BODYPART.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3658a[EntityState.T_START_HEADER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3658a[EntityState.T_FIELD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3658a[EntityState.T_END_HEADER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3658a[EntityState.T_START_MULTIPART.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3658a[EntityState.T_PREAMBLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3658a[EntityState.T_EPILOGUE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3658a[EntityState.T_BODY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3658a[EntityState.T_END_MULTIPART.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3658a[EntityState.T_END_OF_STREAM.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3658a[EntityState.T_END_MESSAGE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f3658a[EntityState.T_RAW_ENTITY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f3658a[EntityState.T_END_BODYPART.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public l(P9.e eVar, InputStream inputStream, k kVar, EntityState entityState, EntityState entityState2, K9.c cVar, j jVar, c cVar2) {
        this.f3641b = kVar;
        this.f3648i = entityState;
        this.f3640a = entityState2;
        this.f3642c = cVar;
        this.f3643d = jVar;
        this.f3644e = cVar2;
        this.f3646g = eVar;
        P9.a aVar = new P9.a(inputStream, 4096, kVar.f());
        this.f3647h = aVar;
        this.f3656q = new P9.g(aVar, kVar.f());
    }

    public static final String u(EntityState entityState) {
        switch (a.f3658a[entityState.ordinal()]) {
            case 1:
                return "Start message";
            case 2:
                return "Start bodypart";
            case 3:
                return "Start header";
            case 4:
                return "Field";
            case 5:
                return "End header";
            case 6:
                return "Start multipart";
            case 7:
                return "Preamble";
            case 8:
                return "Epilogue";
            case 9:
                return "Body";
            case 10:
                return "End multipart";
            case 11:
                return "End of stream";
            case 12:
                return "End message";
            case 13:
                return "Raw entity";
            case 14:
                return "End bodypart";
            default:
                return "Unknown";
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // S9.f
    public f a() {
        EntityState entityState;
        switch (a.f3658a[this.f3648i.ordinal()]) {
            case 1:
                this.f3648i = EntityState.T_START_HEADER;
                return null;
            case 2:
                this.f3648i = EntityState.T_START_HEADER;
                return null;
            case 3:
                this.f3644e.reset();
            case 4:
                if (p()) {
                    entityState = EntityState.T_FIELD;
                } else {
                    entityState = EntityState.T_END_HEADER;
                }
                this.f3648i = entityState;
                return null;
            case 5:
                b build = this.f3644e.build();
                this.f3653n = build;
                String a10 = build.a();
                if (this.f3654o == RecursionMode.M_FLAT) {
                    this.f3648i = EntityState.T_BODY;
                    return null;
                }
                if (MimeUtil.c(a10)) {
                    this.f3648i = EntityState.T_START_MULTIPART;
                    h();
                    return null;
                }
                if (this.f3654o != RecursionMode.M_NO_RECURSE && MimeUtil.b(a10)) {
                    this.f3648i = EntityState.T_BODY;
                    return q();
                }
                this.f3648i = EntityState.T_BODY;
                return null;
            case 6:
                if (this.f3656q.g()) {
                    g();
                    this.f3648i = EntityState.T_END_MULTIPART;
                    return null;
                }
                i();
                this.f3648i = EntityState.T_PREAMBLE;
                if (!this.f3655p.r()) {
                    return null;
                }
            case 7:
                g();
                if (this.f3655p.g() && !this.f3655p.u()) {
                    o(g.f3618b);
                } else if (!this.f3655p.u()) {
                    h();
                    i();
                    return r();
                }
                boolean s10 = this.f3655p.s();
                h();
                this.f3648i = EntityState.T_EPILOGUE;
                if (!s10) {
                    return null;
                }
                break;
            case 8:
                this.f3648i = EntityState.T_END_MULTIPART;
                return null;
            case 9:
            case 10:
                this.f3648i = this.f3640a;
                return null;
            default:
                if (this.f3648i == this.f3640a) {
                    this.f3648i = EntityState.T_END_OF_STREAM;
                    return null;
                }
                throw new IllegalStateException("Invalid state: " + u(this.f3648i));
        }
    }

    @Override // S9.f
    public i b() {
        if (a.f3658a[getState().ordinal()] == 4) {
            return this.f3652m;
        }
        throw new IllegalStateException("Invalid state :" + u(this.f3648i));
    }

    @Override // S9.f
    public b c() {
        switch (a.f3658a[getState().ordinal()]) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 11:
                return this.f3653n;
            case 10:
            default:
                throw new IllegalStateException("Invalid state :" + u(this.f3648i));
        }
    }

    @Override // S9.f
    public InputStream d() {
        switch (a.f3658a[this.f3648i.ordinal()]) {
            case 6:
            case 7:
            case 8:
            case 9:
                return l();
            default:
                throw new IllegalStateException("Invalid state: " + u(this.f3648i));
        }
    }

    @Override // S9.f
    public void e(RecursionMode recursionMode) {
        this.f3654o = recursionMode;
    }

    @Override // S9.f
    public InputStream f() {
        return j(d());
    }

    public final void g() {
        if (!this.f3656q.f()) {
            if (this.f3657r == null) {
                this.f3657r = new byte[2048];
            }
            do {
            } while (l().read(this.f3657r) != -1);
        }
    }

    @Override // S9.f
    public EntityState getState() {
        return this.f3648i;
    }

    public final void h() {
        this.f3655p = null;
        this.f3656q = new P9.g(this.f3647h, this.f3641b.f());
    }

    public final void i() {
        try {
            this.f3655p = new P9.h(this.f3647h, this.f3653n.c(), this.f3641b.i());
            this.f3656q = new P9.g(this.f3655p, this.f3641b.f());
        } catch (IllegalArgumentException e10) {
            throw new MimeException(e10.getMessage(), e10);
        }
    }

    public final InputStream j(InputStream inputStream) {
        InputStream eVar;
        String b10 = this.f3653n.b();
        if (MimeUtil.a(b10)) {
            eVar = new K9.a(inputStream, this.f3642c);
        } else if (MimeUtil.d(b10)) {
            eVar = new K9.e(inputStream, this.f3642c);
        } else {
            return inputStream;
        }
        return eVar;
    }

    public final P9.f k() {
        return this.f3656q;
    }

    public final InputStream l() {
        long c10 = this.f3641b.c();
        if (c10 >= 0) {
            return new P9.c(this.f3656q, c10);
        }
        return this.f3656q;
    }

    public final int m() {
        P9.e eVar = this.f3646g;
        if (eVar == null) {
            return -1;
        }
        return eVar.getLineNumber();
    }

    public String n(g gVar) {
        String gVar2;
        if (gVar == null) {
            gVar2 = "Event is unexpectedly null.";
        } else {
            gVar2 = gVar.toString();
        }
        int m10 = m();
        if (m10 <= 0) {
            return gVar2;
        }
        return "Line " + m10 + ": " + gVar2;
    }

    public void o(g gVar) {
        if (this.f3642c.a()) {
            if (this.f3642c.b(n(gVar), "ignoring")) {
                throw new MimeParseEventException(gVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [S9.i] */
    public boolean p() {
        r build;
        int d10 = this.f3641b.d();
        while (!this.f3650k) {
            if (d10 > 0 && this.f3651l >= d10) {
                throw new MaxHeaderLimitException("Maximum header limit exceeded");
            }
            this.f3651l++;
            this.f3643d.reset();
            t();
            try {
                build = this.f3643d.build();
            } catch (MimeException unused) {
                g gVar = g.f3620d;
                o(gVar);
                if (this.f3641b.h()) {
                    P9.f k10 = k();
                    T9.a a10 = this.f3643d.a();
                    if (a10 != null && k10.c(a10)) {
                        return false;
                    }
                    throw new MimeParseEventException(gVar);
                }
            }
            if (build != null) {
                if (build.c() != build.getName().length()) {
                    o(g.f3621e);
                }
                ?? a11 = this.f3644e.a(build);
                if (a11 != 0) {
                    build = a11;
                }
                this.f3652m = build;
                return true;
            }
        }
        return false;
    }

    public final f q() {
        InputStream inputStream = this.f3655p;
        if (inputStream == null) {
            inputStream = this.f3647h;
        }
        return s(EntityState.T_START_MESSAGE, EntityState.T_END_MESSAGE, j(inputStream));
    }

    public final f r() {
        return s(EntityState.T_START_BODYPART, EntityState.T_END_BODYPART, this.f3655p);
    }

    public final f s(EntityState entityState, EntityState entityState2, InputStream inputStream) {
        if (this.f3654o == RecursionMode.M_RAW) {
            return new q(inputStream);
        }
        l lVar = new l(this.f3646g, inputStream, this.f3641b, entityState, entityState2, this.f3642c, this.f3643d, this.f3644e.b());
        lVar.e(this.f3654o);
        return lVar;
    }

    public final void t() {
        if (!this.f3650k) {
            P9.f k10 = k();
            while (true) {
                try {
                    if (this.f3645f.length() > 0) {
                        this.f3643d.b(this.f3645f);
                    }
                    this.f3645f.d();
                    if (k10.a(this.f3645f) == -1) {
                        o(g.f3619c);
                        this.f3650k = true;
                        return;
                    }
                    int length = this.f3645f.length();
                    if (length > 0 && this.f3645f.byteAt(length - 1) == 10) {
                        length--;
                    }
                    if (length > 0 && this.f3645f.byteAt(length - 1) == 13) {
                        length--;
                    }
                    if (length == 0) {
                        this.f3650k = true;
                        return;
                    }
                    int i10 = this.f3649j + 1;
                    this.f3649j = i10;
                    if (i10 > 1) {
                        byte byteAt = this.f3645f.byteAt(0);
                        if (byteAt != 32 && byteAt != 9) {
                            return;
                        }
                    }
                } catch (MaxLineLimitException e10) {
                    throw new MimeException(e10);
                }
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public String toString() {
        return getClass().getName() + " [" + u(this.f3648i) + "][" + this.f3653n.a() + "][" + this.f3653n.c() + "]";
    }
}
