package I4;

import com.google.gson.JsonSyntaxException;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.stream.JsonToken;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* compiled from: SqlDateTypeAdapter.java */
/* loaded from: classes3.dex */
public final class a extends r<Date> {

    /* renamed from: b, reason: collision with root package name */
    public static final s f1334b = new C0028a();

    /* renamed from: a, reason: collision with root package name */
    public final DateFormat f1335a;

    /* compiled from: SqlDateTypeAdapter.java */
    /* renamed from: I4.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0028a implements s {
        @Override // com.google.gson.s
        public <T> r<T> a(com.google.gson.d dVar, J4.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            C0028a c0028a = null;
            if (rawType != Date.class) {
                return null;
            }
            return new a(c0028a);
        }
    }

    public /* synthetic */ a(C0028a c0028a) {
        this();
    }

    @Override // com.google.gson.r
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Date b(K4.a aVar) {
        java.util.Date parse;
        if (aVar.f0() == JsonToken.NULL) {
            aVar.X();
            return null;
        }
        String a02 = aVar.a0();
        try {
            synchronized (this) {
                parse = this.f1335a.parse(a02);
            }
            return new Date(parse.getTime());
        } catch (ParseException e10) {
            throw new JsonSyntaxException("Failed parsing '" + a02 + "' as SQL Date; at path " + aVar.u(), e10);
        }
    }

    @Override // com.google.gson.r
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(K4.b bVar, Date date) {
        String format;
        if (date == null) {
            bVar.I();
            return;
        }
        synchronized (this) {
            format = this.f1335a.format((java.util.Date) date);
        }
        bVar.i0(format);
    }

    public a() {
        this.f1335a = new SimpleDateFormat("MMM d, yyyy");
    }
}
