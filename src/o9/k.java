package O9;

import java.util.HashMap;
import java.util.Map;

/* compiled from: ContentTypeFieldImpl.java */
/* loaded from: classes4.dex */
public class k extends O9.a implements N9.j {

    /* renamed from: h, reason: collision with root package name */
    public static final L9.a<N9.j> f2760h = new a();

    /* renamed from: c, reason: collision with root package name */
    public boolean f2761c;

    /* renamed from: d, reason: collision with root package name */
    public String f2762d;

    /* renamed from: e, reason: collision with root package name */
    public String f2763e;

    /* renamed from: f, reason: collision with root package name */
    public String f2764f;

    /* renamed from: g, reason: collision with root package name */
    public Map<String, String> f2765g;

    /* compiled from: ContentTypeFieldImpl.java */
    /* loaded from: classes4.dex */
    public static class a implements L9.a<N9.j> {
        @Override // L9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public N9.j a(S9.i iVar, K9.c cVar) {
            return new k(iVar, cVar);
        }
    }

    public k(S9.i iVar, K9.c cVar) {
        super(iVar, cVar);
        this.f2761c = false;
        this.f2762d = null;
        this.f2763e = null;
        this.f2764f = null;
        this.f2765g = new HashMap();
    }
}
