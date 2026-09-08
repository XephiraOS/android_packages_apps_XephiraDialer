package t;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: KeyFrames.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<String, Constructor<? extends AbstractC1575c>> f36976b;

    /* renamed from: a, reason: collision with root package name */
    public HashMap<Integer, ArrayList<AbstractC1575c>> f36977a = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends AbstractC1575c>> hashMap = new HashMap<>();
        f36976b = hashMap;
        try {
            hashMap.put("KeyAttribute", C1576d.class.getConstructor(null));
            f36976b.put("KeyPosition", i.class.getConstructor(null));
            f36976b.put("KeyCycle", f.class.getConstructor(null));
            f36976b.put("KeyTimeCycle", k.class.getConstructor(null));
            f36976b.put("KeyTrigger", l.class.getConstructor(null));
        } catch (NoSuchMethodException e10) {
            Log.e("KeyFrames", "unable to load", e10);
        }
    }

    public h(Context context, XmlPullParser xmlPullParser) {
        Exception e10;
        AbstractC1575c abstractC1575c;
        HashMap<String, ConstraintAttribute> hashMap;
        try {
            int eventType = xmlPullParser.getEventType();
            AbstractC1575c abstractC1575c2 = null;
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3 && "KeyFrameSet".equals(xmlPullParser.getName())) {
                        return;
                    }
                } else {
                    String name = xmlPullParser.getName();
                    if (f36976b.containsKey(name)) {
                        try {
                            abstractC1575c = f36976b.get(name).newInstance(null);
                        } catch (Exception e11) {
                            AbstractC1575c abstractC1575c3 = abstractC1575c2;
                            e10 = e11;
                            abstractC1575c = abstractC1575c3;
                        }
                        try {
                            abstractC1575c.c(context, Xml.asAttributeSet(xmlPullParser));
                            b(abstractC1575c);
                        } catch (Exception e12) {
                            e10 = e12;
                            Log.e("KeyFrames", "unable to create ", e10);
                            abstractC1575c2 = abstractC1575c;
                            eventType = xmlPullParser.next();
                        }
                        abstractC1575c2 = abstractC1575c;
                    } else if (name.equalsIgnoreCase("CustomAttribute") && abstractC1575c2 != null && (hashMap = abstractC1575c2.f36910e) != null) {
                        ConstraintAttribute.g(context, xmlPullParser, hashMap);
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e13) {
            e13.printStackTrace();
        } catch (XmlPullParserException e14) {
            e14.printStackTrace();
        }
    }

    public void a(n nVar) {
        ArrayList<AbstractC1575c> arrayList = this.f36977a.get(Integer.valueOf(nVar.f37063b));
        if (arrayList != null) {
            nVar.b(arrayList);
        }
        ArrayList<AbstractC1575c> arrayList2 = this.f36977a.get(-1);
        if (arrayList2 != null) {
            Iterator<AbstractC1575c> it = arrayList2.iterator();
            while (it.hasNext()) {
                AbstractC1575c next = it.next();
                if (next.d(((ConstraintLayout.LayoutParams) nVar.f37062a.getLayoutParams()).constraintTag)) {
                    nVar.a(next);
                }
            }
        }
    }

    public final void b(AbstractC1575c abstractC1575c) {
        if (!this.f36977a.containsKey(Integer.valueOf(abstractC1575c.f36907b))) {
            this.f36977a.put(Integer.valueOf(abstractC1575c.f36907b), new ArrayList<>());
        }
        this.f36977a.get(Integer.valueOf(abstractC1575c.f36907b)).add(abstractC1575c);
    }
}
