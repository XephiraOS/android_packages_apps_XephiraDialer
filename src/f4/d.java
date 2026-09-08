package F4;

import com.google.gson.JsonSyntaxException;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.stream.JsonToken;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* compiled from: DefaultDateTypeAdapter.java */
/* loaded from: classes3.dex */
public final class d<T extends Date> extends r<T> {

    /* renamed from: a, reason: collision with root package name */
    public final b<T> f855a;

    /* renamed from: b, reason: collision with root package name */
    public final List<DateFormat> f856b;

    private Date e(K4.a aVar) {
        String a02 = aVar.a0();
        synchronized (this.f856b) {
            try {
                Iterator<DateFormat> it = this.f856b.iterator();
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
    public T b(K4.a aVar) {
        if (aVar.f0() == JsonToken.NULL) {
            aVar.X();
            return null;
        }
        return this.f855a.d(e(aVar));
    }

    @Override // com.google.gson.r
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(K4.b bVar, Date date) {
        String format;
        if (date == null) {
            bVar.I();
            return;
        }
        DateFormat dateFormat = this.f856b.get(0);
        synchronized (this.f856b) {
            format = dateFormat.format(date);
        }
        bVar.i0(format);
    }

    public String toString() {
        DateFormat dateFormat = this.f856b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    public d(b<T> bVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.f856b = arrayList;
        Objects.requireNonNull(bVar);
        this.f855a = bVar;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    public d(b<T> bVar, int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        this.f856b = arrayList;
        Objects.requireNonNull(bVar);
        this.f855a = bVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i10, i11, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i10, i11));
        }
        if (com.google.gson.internal.d.d()) {
            arrayList.add(com.google.gson.internal.g.c(i10, i11));
        }
    }

    /* compiled from: DefaultDateTypeAdapter.java */
    /* loaded from: classes3.dex */
    public static abstract class b<T extends Date> {

        /* renamed from: b, reason: collision with root package name */
        public static final b<Date> f857b = new a(Date.class);

        /* renamed from: a, reason: collision with root package name */
        public final Class<T> f858a;

        public b(Class<T> cls) {
            this.f858a = cls;
        }

        public final s a(int i10, int i11) {
            return c(new d<>(this, i10, i11));
        }

        public final s b(String str) {
            return c(new d<>(this, str));
        }

        public final s c(d<T> dVar) {
            return o.a(this.f858a, dVar);
        }

        public abstract T d(Date date);

        /* compiled from: DefaultDateTypeAdapter.java */
        /* loaded from: classes3.dex */
        public class a extends b<Date> {
            public a(Class cls) {
                super(cls);
            }

            @Override // F4.d.b
            public Date d(Date date) {
                return date;
            }
        }
    }
}
