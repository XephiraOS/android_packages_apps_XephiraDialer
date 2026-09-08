package I4;

import com.google.gson.r;
import com.google.gson.s;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: SqlTimestampTypeAdapter.java */
/* loaded from: classes3.dex */
public class c extends r<Timestamp> {

    /* renamed from: b, reason: collision with root package name */
    public static final s f1338b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final r<Date> f1339a;

    /* compiled from: SqlTimestampTypeAdapter.java */
    /* loaded from: classes3.dex */
    public class a implements s {
        @Override // com.google.gson.s
        public <T> r<T> a(com.google.gson.d dVar, J4.a<T> aVar) {
            a aVar2 = null;
            if (aVar.getRawType() != Timestamp.class) {
                return null;
            }
            return new c(dVar.m(Date.class), aVar2);
        }
    }

    public /* synthetic */ c(r rVar, a aVar) {
        this(rVar);
    }

    @Override // com.google.gson.r
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Timestamp b(K4.a aVar) {
        Date b10 = this.f1339a.b(aVar);
        if (b10 != null) {
            return new Timestamp(b10.getTime());
        }
        return null;
    }

    @Override // com.google.gson.r
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(K4.b bVar, Timestamp timestamp) {
        this.f1339a.d(bVar, timestamp);
    }

    public c(r<Date> rVar) {
        this.f1339a = rVar;
    }
}
