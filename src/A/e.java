package A;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import com.coui.appcompat.vibrateutil.VibrateUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import z.C1720c;

/* compiled from: FontResourcesParserCompat.java */
/* loaded from: classes.dex */
public class e {

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public static class a {
        public static int a(TypedArray typedArray, int i10) {
            return typedArray.getType(i10);
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public interface b {
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        public final d[] f18a;

        public c(d[] dVarArr) {
            this.f18a = dVarArr;
        }

        public d[] a() {
            return this.f18a;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f19a;

        /* renamed from: b, reason: collision with root package name */
        public final int f20b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f21c;

        /* renamed from: d, reason: collision with root package name */
        public final String f22d;

        /* renamed from: e, reason: collision with root package name */
        public final int f23e;

        /* renamed from: f, reason: collision with root package name */
        public final int f24f;

        public d(String str, int i10, boolean z10, String str2, int i11, int i12) {
            this.f19a = str;
            this.f20b = i10;
            this.f21c = z10;
            this.f22d = str2;
            this.f23e = i11;
            this.f24f = i12;
        }

        public int a() {
            return this.f24f;
        }

        public int b() {
            return this.f23e;
        }

        public String c() {
            return this.f22d;
        }

        public int d() {
            return this.f20b;
        }

        public boolean e() {
            return this.f21c;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: A.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0000e implements b {

        /* renamed from: a, reason: collision with root package name */
        public final G.e f25a;

        /* renamed from: b, reason: collision with root package name */
        public final G.e f26b;

        /* renamed from: c, reason: collision with root package name */
        public final int f27c;

        /* renamed from: d, reason: collision with root package name */
        public final int f28d;

        /* renamed from: e, reason: collision with root package name */
        public final String f29e;

        public C0000e(G.e eVar, G.e eVar2, int i10, int i11, String str) {
            this.f25a = eVar;
            this.f26b = eVar2;
            this.f28d = i10;
            this.f27c = i11;
            this.f29e = str;
        }

        public G.e a() {
            return this.f26b;
        }

        public int b() {
            return this.f28d;
        }

        public G.e c() {
            return this.f25a;
        }

        public String d() {
            return this.f29e;
        }

        public int e() {
            return this.f27c;
        }
    }

    public static int a(TypedArray typedArray, int i10) {
        return a.a(typedArray, i10);
    }

    public static b b(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> c(Resources resources, int i10) {
        if (i10 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i10);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i11 = 0; i11 < obtainTypedArray.length(); i11++) {
                    int resourceId = obtainTypedArray.getResourceId(i11, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i10)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    public static b d(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    public static b e(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C1720c.f38226h);
        String string = obtainAttributes.getString(C1720c.f38227i);
        String string2 = obtainAttributes.getString(C1720c.f38232n);
        String string3 = obtainAttributes.getString(C1720c.f38233o);
        String string4 = obtainAttributes.getString(C1720c.f38229k);
        int resourceId = obtainAttributes.getResourceId(C1720c.f38228j, 0);
        int integer = obtainAttributes.getInteger(C1720c.f38230l, 1);
        int integer2 = obtainAttributes.getInteger(C1720c.f38231m, 500);
        String string5 = obtainAttributes.getString(C1720c.f38234p);
        obtainAttributes.recycle();
        G.e eVar = null;
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            List<List<byte[]>> c10 = c(resources, resourceId);
            if (string4 != null) {
                eVar = new G.e(string, string2, string4, c10);
            }
            return new C0000e(new G.e(string, string2, string3, c10), eVar, integer, integer2, string5);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new c((d[]) arrayList.toArray(new d[0]));
    }

    public static d f(XmlPullParser xmlPullParser, Resources resources) {
        boolean z10;
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C1720c.f38235q);
        int i10 = C1720c.f38244z;
        if (!obtainAttributes.hasValue(i10)) {
            i10 = C1720c.f38237s;
        }
        int i11 = obtainAttributes.getInt(i10, VibrateUtils.STRENGTH_OFFSET);
        int i12 = C1720c.f38242x;
        if (!obtainAttributes.hasValue(i12)) {
            i12 = C1720c.f38238t;
        }
        if (1 == obtainAttributes.getInt(i12, 0)) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i13 = C1720c.f38202A;
        if (!obtainAttributes.hasValue(i13)) {
            i13 = C1720c.f38239u;
        }
        int i14 = C1720c.f38243y;
        if (!obtainAttributes.hasValue(i14)) {
            i14 = C1720c.f38240v;
        }
        String string = obtainAttributes.getString(i14);
        int i15 = obtainAttributes.getInt(i13, 0);
        int i16 = C1720c.f38241w;
        if (!obtainAttributes.hasValue(i16)) {
            i16 = C1720c.f38236r;
        }
        int resourceId = obtainAttributes.getResourceId(i16, 0);
        String string2 = obtainAttributes.getString(i16);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new d(string2, i11, z10, string, i15, resourceId);
    }

    public static void g(XmlPullParser xmlPullParser) {
        int i10 = 1;
        while (i10 > 0) {
            int next = xmlPullParser.next();
            if (next != 2) {
                if (next == 3) {
                    i10--;
                }
            } else {
                i10++;
            }
        }
    }

    public static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
