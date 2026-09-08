package I4;

import com.google.gson.JsonSyntaxException;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.stream.JsonToken;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: SqlTimeTypeAdapter.java */
/* loaded from: classes3.dex */
public final class b extends r<Time> {

    /* renamed from: b, reason: collision with root package name */
    public static final s f1336b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final DateFormat f1337a;

    /* compiled from: SqlTimeTypeAdapter.java */
    /* loaded from: classes3.dex */
    public class a implements s {
        @Override // com.google.gson.s
        public <T> r<T> a(com.google.gson.d dVar, J4.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            a aVar2 = null;
            if (rawType != Time.class) {
                return null;
            }
            return new b(aVar2);
        }
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    @Override // com.google.gson.r
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Time b(K4.a aVar) {
        Time time;
        if (aVar.f0() == JsonToken.NULL) {
            aVar.X();
            return null;
        }
        String a02 = aVar.a0();
        try {
            synchronized (this) {
                time = new Time(this.f1337a.parse(a02).getTime());
            }
            return time;
        } catch (ParseException e10) {
            throw new JsonSyntaxException("Failed parsing '" + a02 + "' as SQL Time; at path " + aVar.u(), e10);
        }
    }

    @Override // com.google.gson.r
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(K4.b bVar, Time time) {
        String format;
        if (time == null) {
            bVar.I();
            return;
        }
        synchronized (this) {
            format = this.f1337a.format((Date) time);
        }
        bVar.i0(format);
    }

    public b() {
        this.f1337a = new SimpleDateFormat("hh:mm:ss a");
    }
}
