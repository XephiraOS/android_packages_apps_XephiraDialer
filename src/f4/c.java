package F4;

import com.google.gson.JsonSyntaxException;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.stream.JsonToken;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: DateTypeAdapter.java */
/* loaded from: classes3.dex */
public final class c extends r<Date> {

    /* renamed from: b, reason: collision with root package name */
    public static final s f853b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final List<DateFormat> f854a;

    /* compiled from: DateTypeAdapter.java */
    /* loaded from: classes3.dex */
    public class a implements s {
        @Override // com.google.gson.s
        public <T> r<T> a(com.google.gson.d dVar, J4.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f854a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (com.google.gson.internal.d.d()) {
            arrayList.add(com.google.gson.internal.g.c(2, 2));
        }
    }

    public final Date e(K4.a aVar) {
        String a02 = aVar.a0();
        synchronized (this.f854a) {
            try {
                Iterator<DateFormat> it = this.f854a.iterator();
                while (it.hasNext()) {
                    try {
                        return it.next().parse(a02);
                    } catch (ParseException unused) {
                    }
                }
                try {
                    return G4.a.c(a02, new ParsePosition(0));
                } catch (ParseException e10) {
                    throw new JsonSyntaxException("Failed parsing '" + a02 + "' as Date; at path " + aVar.u(), e10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.gson.r
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Date b(K4.a aVar) {
        if (aVar.f0() == JsonToken.NULL) {
            aVar.X();
            return null;
        }
        return e(aVar);
    }

    @Override // com.google.gson.r
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(K4.b bVar, Date date) {
        String format;
        if (date == null) {
            bVar.I();
            return;
        }
        DateFormat dateFormat = this.f854a.get(0);
        synchronized (this.f854a) {
            format = dateFormat.format(date);
        }
        bVar.i0(format);
    }
}
