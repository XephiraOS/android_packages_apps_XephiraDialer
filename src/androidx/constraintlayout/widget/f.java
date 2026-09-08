package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: StateSet.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public int f9273a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f9274b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f9275c = -1;

    /* renamed from: d, reason: collision with root package name */
    public SparseArray<a> f9276d = new SparseArray<>();

    /* renamed from: e, reason: collision with root package name */
    public SparseArray<androidx.constraintlayout.widget.b> f9277e = new SparseArray<>();

    /* compiled from: StateSet.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f9278a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<b> f9279b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        public int f9280c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f9281d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f9280c = -1;
            this.f9281d = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), e.f9245w7);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == e.f9254x7) {
                    this.f9278a = obtainStyledAttributes.getResourceId(index, this.f9278a);
                } else if (index == e.f9263y7) {
                    this.f9280c = obtainStyledAttributes.getResourceId(index, this.f9280c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f9280c);
                    context.getResources().getResourceName(this.f9280c);
                    if ("layout".equals(resourceTypeName)) {
                        this.f9281d = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void a(b bVar) {
            this.f9279b.add(bVar);
        }

        public int b(float f10, float f11) {
            for (int i10 = 0; i10 < this.f9279b.size(); i10++) {
                if (this.f9279b.get(i10).a(f10, f11)) {
                    return i10;
                }
            }
            return -1;
        }
    }

    /* compiled from: StateSet.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public float f9282a;

        /* renamed from: b, reason: collision with root package name */
        public float f9283b;

        /* renamed from: c, reason: collision with root package name */
        public float f9284c;

        /* renamed from: d, reason: collision with root package name */
        public float f9285d;

        /* renamed from: e, reason: collision with root package name */
        public int f9286e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f9287f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.f9282a = Float.NaN;
            this.f9283b = Float.NaN;
            this.f9284c = Float.NaN;
            this.f9285d = Float.NaN;
            this.f9286e = -1;
            this.f9287f = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), e.f9075e8);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == e.f9085f8) {
                    this.f9286e = obtainStyledAttributes.getResourceId(index, this.f9286e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f9286e);
                    context.getResources().getResourceName(this.f9286e);
                    if ("layout".equals(resourceTypeName)) {
                        this.f9287f = true;
                    }
                } else if (index == e.f9095g8) {
                    this.f9285d = obtainStyledAttributes.getDimension(index, this.f9285d);
                } else if (index == e.f9105h8) {
                    this.f9283b = obtainStyledAttributes.getDimension(index, this.f9283b);
                } else if (index == e.f9115i8) {
                    this.f9284c = obtainStyledAttributes.getDimension(index, this.f9284c);
                } else if (index == e.f9125j8) {
                    this.f9282a = obtainStyledAttributes.getDimension(index, this.f9282a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        public boolean a(float f10, float f11) {
            if (!Float.isNaN(this.f9282a) && f10 < this.f9282a) {
                return false;
            }
            if (!Float.isNaN(this.f9283b) && f11 < this.f9283b) {
                return false;
            }
            if (!Float.isNaN(this.f9284c) && f10 > this.f9284c) {
                return false;
            }
            if (!Float.isNaN(this.f9285d) && f11 > this.f9285d) {
                return false;
            }
            return true;
        }
    }

    public f(Context context, XmlPullParser xmlPullParser) {
        b(context, xmlPullParser);
    }

    public int a(int i10, int i11, float f10, float f11) {
        a aVar = this.f9276d.get(i11);
        if (aVar == null) {
            return i11;
        }
        if (f10 != -1.0f && f11 != -1.0f) {
            Iterator<b> it = aVar.f9279b.iterator();
            b bVar = null;
            while (it.hasNext()) {
                b next = it.next();
                if (next.a(f10, f11)) {
                    if (i10 == next.f9286e) {
                        return i10;
                    }
                    bVar = next;
                }
            }
            if (bVar != null) {
                return bVar.f9286e;
            }
            return aVar.f9280c;
        }
        if (aVar.f9280c == i10) {
            return i10;
        }
        Iterator<b> it2 = aVar.f9279b.iterator();
        while (it2.hasNext()) {
            if (i10 == it2.next().f9286e) {
                return i10;
            }
        }
        return aVar.f9280c;
    }

    public final void b(Context context, XmlPullParser xmlPullParser) {
        char c10;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), e.f8809B7);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == e.f8818C7) {
                this.f9273a = obtainStyledAttributes.getResourceId(index, this.f9273a);
            }
        }
        obtainStyledAttributes.recycle();
        try {
            int eventType = xmlPullParser.getEventType();
            a aVar = null;
            while (eventType != 1) {
                if (eventType != 0) {
                    if (eventType != 2) {
                        if (eventType != 3) {
                            continue;
                        } else if ("StateSet".equals(xmlPullParser.getName())) {
                            return;
                        }
                    } else {
                        String name = xmlPullParser.getName();
                        switch (name.hashCode()) {
                            case 80204913:
                                if (name.equals("State")) {
                                    c10 = 2;
                                    break;
                                }
                                break;
                            case 1301459538:
                                if (name.equals("LayoutDescription")) {
                                    c10 = 0;
                                    break;
                                }
                                break;
                            case 1382829617:
                                if (name.equals("StateSet")) {
                                    c10 = 1;
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
                                    Log.v("ConstraintLayoutStates", "unknown tag " + name);
                                } else {
                                    b bVar = new b(context, xmlPullParser);
                                    if (aVar != null) {
                                        aVar.a(bVar);
                                    }
                                }
                            } else {
                                aVar = new a(context, xmlPullParser);
                                this.f9276d.put(aVar.f9278a, aVar);
                            }
                        }
                    }
                } else {
                    xmlPullParser.getName();
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    public int c(int i10, int i11, int i12) {
        return d(-1, i10, i11, i12);
    }

    public int d(int i10, int i11, float f10, float f11) {
        a aVar;
        if (i10 == i11) {
            if (i11 == -1) {
                aVar = this.f9276d.valueAt(0);
            } else {
                aVar = this.f9276d.get(this.f9274b);
            }
            if (aVar == null) {
                return -1;
            }
            if (this.f9275c != -1 && aVar.f9279b.get(i10).a(f10, f11)) {
                return i10;
            }
            int b10 = aVar.b(f10, f11);
            if (i10 == b10) {
                return i10;
            }
            if (b10 == -1) {
                return aVar.f9280c;
            }
            return aVar.f9279b.get(b10).f9286e;
        }
        a aVar2 = this.f9276d.get(i11);
        if (aVar2 == null) {
            return -1;
        }
        int b11 = aVar2.b(f10, f11);
        if (b11 == -1) {
            return aVar2.f9280c;
        }
        return aVar2.f9279b.get(b11).f9286e;
    }
}
