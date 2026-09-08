package O9;

import java.io.StringReader;
import java.util.Date;
import org.apache.james.mime4j.field.datetime.parser.ParseException;
import org.apache.james.mime4j.field.datetime.parser.TokenMgrError;

/* compiled from: DateTimeFieldImpl.java */
/* loaded from: classes4.dex */
public class l extends O9.a implements N9.k {

    /* renamed from: f, reason: collision with root package name */
    public static final L9.a<N9.k> f2766f = new a();

    /* renamed from: c, reason: collision with root package name */
    public boolean f2767c;

    /* renamed from: d, reason: collision with root package name */
    public Date f2768d;

    /* renamed from: e, reason: collision with root package name */
    public ParseException f2769e;

    /* compiled from: DateTimeFieldImpl.java */
    /* loaded from: classes4.dex */
    public static class a implements L9.a<N9.k> {
        @Override // L9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public N9.k a(S9.i iVar, K9.c cVar) {
            return new l(iVar, cVar);
        }
    }

    public l(S9.i iVar, K9.c cVar) {
        super(iVar, cVar);
        this.f2767c = false;
    }

    public final void c() {
        try {
            this.f2768d = new org.apache.james.mime4j.field.datetime.parser.a(new StringReader(b())).o().c();
        } catch (ParseException e10) {
            this.f2769e = e10;
        } catch (TokenMgrError e11) {
            this.f2769e = new ParseException(e11.getMessage());
        }
        this.f2767c = true;
    }

    @Override // N9.k
    public Date getDate() {
        if (!this.f2767c) {
            c();
        }
        return this.f2768d;
    }
}
