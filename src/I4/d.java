package I4;

import F4.d;
import com.google.gson.s;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: SqlTypesSupport.java */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f1340a;

    /* renamed from: b, reason: collision with root package name */
    public static final d.b<? extends Date> f1341b;

    /* renamed from: c, reason: collision with root package name */
    public static final d.b<? extends Date> f1342c;

    /* renamed from: d, reason: collision with root package name */
    public static final s f1343d;

    /* renamed from: e, reason: collision with root package name */
    public static final s f1344e;

    /* renamed from: f, reason: collision with root package name */
    public static final s f1345f;

    /* compiled from: SqlTypesSupport.java */
    /* loaded from: classes3.dex */
    public class a extends d.b<java.sql.Date> {
        public a(Class cls) {
            super(cls);
        }

        @Override // F4.d.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public java.sql.Date d(Date date) {
            return new java.sql.Date(date.getTime());
        }
    }

    /* compiled from: SqlTypesSupport.java */
    /* loaded from: classes3.dex */
    public class b extends d.b<Timestamp> {
        public b(Class cls) {
            super(cls);
        }

        @Override // F4.d.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Timestamp d(Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z10;
        try {
            Class.forName("java.sql.Date");
            z10 = true;
        } catch (ClassNotFoundException unused) {
            z10 = false;
        }
        f1340a = z10;
        if (z10) {
            f1341b = new a(java.sql.Date.class);
            f1342c = new b(Timestamp.class);
            f1343d = I4.a.f1334b;
            f1344e = I4.b.f1336b;
            f1345f = c.f1338b;
            return;
        }
        f1341b = null;
        f1342c = null;
        f1343d = null;
        f1344e = null;
        f1345f = null;
    }
}
