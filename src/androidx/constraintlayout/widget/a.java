package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ConstraintLayoutStates.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f8673a;

    /* renamed from: b, reason: collision with root package name */
    public androidx.constraintlayout.widget.b f8674b;

    /* renamed from: c, reason: collision with root package name */
    public int f8675c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f8676d = -1;

    /* renamed from: e, reason: collision with root package name */
    public SparseArray<C0105a> f8677e = new SparseArray<>();

    /* renamed from: f, reason: collision with root package name */
    public SparseArray<androidx.constraintlayout.widget.b> f8678f = new SparseArray<>();

    /* compiled from: ConstraintLayoutStates.java */
    /* renamed from: androidx.constraintlayout.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0105a {

        /* renamed from: a, reason: collision with root package name */
        public int f8679a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<b> f8680b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        public int f8681c;

        /* renamed from: d, reason: collision with root package name */
        public androidx.constraintlayout.widget.b f8682d;

        public C0105a(Context context, XmlPullParser xmlPullParser) {
            this.f8681c = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), e.f9245w7);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == e.f9254x7) {
                    this.f8679a = obtainStyledAttributes.getResourceId(index, this.f8679a);
                } else if (index == e.f9263y7) {
                    this.f8681c = obtainStyledAttributes.getResourceId(index, this.f8681c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f8681c);
                    context.getResources().getResourceName(this.f8681c);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
                        this.f8682d = bVar;
                        bVar.h(context, this.f8681c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void a(b bVar) {
            this.f8680b.add(bVar);
        }

        public int b(float f10, float f11) {
            for (int i10 = 0; i10 < this.f8680b.size(); i10++) {
                if (this.f8680b.get(i10).a(f10, f11)) {
                    return i10;
                }
            }
            return -1;
        }
    }

    /* compiled from: ConstraintLayoutStates.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public float f8683a;

        /* renamed from: b, reason: collision with root package name */
        public float f8684b;

        /* renamed from: c, reason: collision with root package name */
        public float f8685c;

        /* renamed from: d, reason: collision with root package name */
        public float f8686d;

        /* renamed from: e, reason: collision with root package name */
        public int f8687e;

        /* renamed from: f, reason: collision with root package name */
        public androidx.constraintlayout.widget.b f8688f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.f8683a = Float.NaN;
            this.f8684b = Float.NaN;
            this.f8685c = Float.NaN;
            this.f8686d = Float.NaN;
            this.f8687e = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), e.f9075e8);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == e.f9085f8) {
                    this.f8687e = obtainStyledAttributes.getResourceId(index, this.f8687e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f8687e);
                    context.getResources().getResourceName(this.f8687e);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
                        this.f8688f = bVar;
                        bVar.h(context, this.f8687e);
                    }
                } else if (index == e.f9095g8) {
                    this.f8686d = obtainStyledAttributes.getDimension(index, this.f8686d);
                } else if (index == e.f9105h8) {
                    this.f8684b = obtainStyledAttributes.getDimension(index, this.f8684b);
                } else if (index == e.f9115i8) {
                    this.f8685c = obtainStyledAttributes.getDimension(index, this.f8685c);
                } else if (index == e.f9125j8) {
                    this.f8683a = obtainStyledAttributes.getDimension(index, this.f8683a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        public boolean a(float f10, float f11) {
            if (!Float.isNaN(this.f8683a) && f10 < this.f8683a) {
                return false;
            }
            if (!Float.isNaN(this.f8684b) && f11 < this.f8684b) {
                return false;
            }
            if (!Float.isNaN(this.f8685c) && f10 > this.f8685c) {
                return false;
            }
            if (!Float.isNaN(this.f8686d) && f11 > this.f8686d) {
                return false;
            }
            return true;
        }
    }

    public a(Context context, ConstraintLayout constraintLayout, int i10) {
        this.f8673a = constraintLayout;
        a(context, i10);
    }

    public final void a(Context context, int i10) {
        char c10;
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            C0105a c0105a = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType != 0) {
                    if (eventType == 2) {
                        String name = xml.getName();
                        switch (name.hashCode()) {
                            case -1349929691:
                                if (name.equals("ConstraintSet")) {
                                    c10 = 4;
                                    break;
                                }
                                break;
                            case 80204913:
                                if (name.equals("State")) {
                                    c10 = 2;
                                    break;
                                }
                                break;
                            case 1382829617:
                                if (name.equals("StateSet")) {
                                    c10 = 1;
                                    break;
                                }
                                break;
                            case 1657696882:
                                if (name.equals("layoutDescription")) {
                                    c10 = 0;
                                    break;
                                }
                                break;
                            case 1901439077:
                                if (name.equals("Variant")) {
                                    c10 = 3;
                                    break;
                                }
                                break;
                        }
                        c10 = 65535;
                        if (c10 != 0 && c10 != 1) {
                            if (c10 != 2) {
                                if (c10 != 3) {
                                    if (c10 != 4) {
                                        Log.v("ConstraintLayoutStates", "unknown tag " + name);
                                    } else {
                                        b(context, xml);
                                    }
                                } else {
                                    b bVar = new b(context, xml);
                                    if (c0105a != null) {
                                        c0105a.a(bVar);
                                    }
                                }
                            } else {
                                c0105a = new C0105a(context, xml);
                                this.f8677e.put(c0105a.f8679a, c0105a);
                            }
                        }
                    }
                } else {
                    xml.getName();
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    public final void b(Context context, XmlPullParser xmlPullParser) {
        int i10;
        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i11 = 0; i11 < attributeCount; i11++) {
            if ("id".equals(xmlPullParser.getAttributeName(i11))) {
                String attributeValue = xmlPullParser.getAttributeValue(i11);
                if (attributeValue.contains("/")) {
                    i10 = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                } else {
                    i10 = -1;
                }
                if (i10 == -1) {
                    if (attributeValue.length() > 1) {
                        i10 = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                bVar.x(context, xmlPullParser);
                this.f8678f.put(i10, bVar);
                return;
            }
        }
    }

    public void d(int i10, float f10, float f11) {
        androidx.constraintlayout.widget.b bVar;
        C0105a c0105a;
        int b10;
        androidx.constraintlayout.widget.b bVar2;
        int i11 = this.f8675c;
        if (i11 == i10) {
            if (i10 == -1) {
                c0105a = this.f8677e.valueAt(0);
            } else {
                c0105a = this.f8677e.get(i11);
            }
            int i12 = this.f8676d;
            if ((i12 != -1 && c0105a.f8680b.get(i12).a(f10, f11)) || this.f8676d == (b10 = c0105a.b(f10, f11))) {
                return;
            }
            if (b10 == -1) {
                bVar2 = this.f8674b;
            } else {
                bVar2 = c0105a.f8680b.get(b10).f8688f;
            }
            if (b10 != -1) {
                int i13 = c0105a.f8680b.get(b10).f8687e;
            }
            if (bVar2 == null) {
                return;
            }
            this.f8676d = b10;
            bVar2.d(this.f8673a);
            return;
        }
        this.f8675c = i10;
        C0105a c0105a2 = this.f8677e.get(i10);
        int b11 = c0105a2.b(f10, f11);
        if (b11 == -1) {
            bVar = c0105a2.f8682d;
        } else {
            bVar = c0105a2.f8680b.get(b11).f8688f;
        }
        if (b11 != -1) {
            int i14 = c0105a2.f8680b.get(b11).f8687e;
        }
        if (bVar == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i10 + ", dim =" + f10 + ", " + f11);
            return;
        }
        this.f8676d = b11;
        bVar.d(this.f8673a);
    }

    public void c(c cVar) {
    }
}
