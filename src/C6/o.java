package c6;

import com.oplus.anim.model.DocumentData;
import java.util.List;
import m6.C1335a;
import m6.C1336b;
import m6.C1337c;

/* compiled from: TextKeyframeAnimation.java */
/* loaded from: classes3.dex */
public class o extends AbstractC0564g<DocumentData> {

    /* compiled from: TextKeyframeAnimation.java */
    /* loaded from: classes3.dex */
    public class a extends C1336b<DocumentData> {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ C1335a f12841d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ C1336b f12842e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ DocumentData f12843f;

        public a(C1335a c1335a, C1336b c1336b, DocumentData documentData) {
            this.f12841d = c1335a;
            this.f12842e = c1336b;
            this.f12843f = documentData;
        }

        @Override // m6.C1336b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public DocumentData a(C1335a<DocumentData> c1335a) {
            DocumentData g10;
            this.f12841d.h(c1335a.f(), c1335a.a(), c1335a.g().f25946a, c1335a.b().f25946a, c1335a.d(), c1335a.c(), c1335a.e());
            String str = (String) this.f12842e.a(this.f12841d);
            if (c1335a.c() == 1.0f) {
                g10 = c1335a.b();
            } else {
                g10 = c1335a.g();
            }
            DocumentData documentData = g10;
            this.f12843f.a(str, documentData.f25947b, documentData.f25948c, documentData.f25949d, documentData.f25950e, documentData.f25951f, documentData.f25952g, documentData.f25953h, documentData.f25954i, documentData.f25955j, documentData.f25956k, documentData.f25957l, documentData.f25958m);
            return this.f12843f;
        }
    }

    public o(List<C1337c<DocumentData>> list) {
        super(list);
    }

    @Override // c6.AbstractC0558a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public DocumentData i(C1337c<DocumentData> c1337c, float f10) {
        DocumentData documentData;
        float floatValue;
        DocumentData documentData2;
        C1336b<A> c1336b = this.f12801e;
        if (c1336b != 0) {
            float f11 = c1337c.f35160g;
            Float f12 = c1337c.f35161h;
            if (f12 == null) {
                floatValue = Float.MAX_VALUE;
            } else {
                floatValue = f12.floatValue();
            }
            DocumentData documentData3 = c1337c.f35155b;
            DocumentData documentData4 = documentData3;
            DocumentData documentData5 = c1337c.f35156c;
            if (documentData5 == null) {
                documentData2 = documentData3;
            } else {
                documentData2 = documentData5;
            }
            return (DocumentData) c1336b.b(f11, floatValue, documentData4, documentData2, f10, d(), f());
        }
        if (f10 == 1.0f && (documentData = c1337c.f35156c) != null) {
            return documentData;
        }
        return c1337c.f35155b;
    }

    public void q(C1336b<String> c1336b) {
        super.n(new a(new C1335a(), c1336b, new DocumentData()));
    }
}
