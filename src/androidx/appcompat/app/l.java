package androidx.appcompat.app;

import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: LayoutIncludeDetector.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public final Deque<WeakReference<XmlPullParser>> f7389a = new ArrayDeque();

    public static boolean b(XmlPullParser xmlPullParser) {
        if (xmlPullParser == null) {
            return true;
        }
        try {
            if (xmlPullParser.getEventType() == 3) {
                return true;
            }
            if (xmlPullParser.getEventType() == 1) {
                return true;
            }
            return false;
        } catch (XmlPullParserException unused) {
            return true;
        }
    }

    public static XmlPullParser c(Deque<WeakReference<XmlPullParser>> deque) {
        while (!deque.isEmpty()) {
            XmlPullParser xmlPullParser = deque.peek().get();
            if (b(xmlPullParser)) {
                deque.pop();
            } else {
                return xmlPullParser;
            }
        }
        return null;
    }

    public static boolean d(XmlPullParser xmlPullParser, XmlPullParser xmlPullParser2) {
        if (xmlPullParser2 != null && xmlPullParser != xmlPullParser2) {
            try {
                if (xmlPullParser2.getEventType() == 2) {
                    return "include".equals(xmlPullParser2.getName());
                }
                return false;
            } catch (XmlPullParserException unused) {
                return false;
            }
        }
        return false;
    }

    public boolean a(AttributeSet attributeSet) {
        if (attributeSet instanceof XmlPullParser) {
            XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
            if (xmlPullParser.getDepth() == 1) {
                XmlPullParser c10 = c(this.f7389a);
                this.f7389a.push(new WeakReference<>(xmlPullParser));
                if (d(xmlPullParser, c10)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
