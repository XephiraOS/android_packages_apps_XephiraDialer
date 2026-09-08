package O9;

import java.util.HashMap;
import java.util.Map;

/* compiled from: ContentDispositionFieldImpl.java */
/* loaded from: classes4.dex */
public class d extends O9.a implements N9.c {

    /* renamed from: f, reason: collision with root package name */
    public static final L9.a<N9.c> f2744f = new a();

    /* renamed from: c, reason: collision with root package name */
    public boolean f2745c;

    /* renamed from: d, reason: collision with root package name */
    public String f2746d;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, String> f2747e;

    /* compiled from: ContentDispositionFieldImpl.java */
    /* loaded from: classes4.dex */
    public static class a implements L9.a<N9.c> {
        @Override // L9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public N9.c a(S9.i iVar, K9.c cVar) {
            return new d(iVar, cVar);
        }
    }

    public d(S9.i iVar, K9.c cVar) {
        super(iVar, cVar);
        this.f2745c = false;
        this.f2746d = "";
        this.f2747e = new HashMap();
    }
}
