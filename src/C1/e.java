package C1;

import android.util.ArrayMap;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: XmlUtils.java */
/* loaded from: classes.dex */
public class e {

    /* compiled from: XmlUtils.java */
    /* loaded from: classes.dex */
    public interface a {
        Object a(XmlPullParser xmlPullParser, String str);
    }

    public static final void a(XmlPullParser xmlPullParser, String str) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            if (xmlPullParser.getName().equals(str)) {
                return;
            }
            throw new XmlPullParserException("Unexpected start tag: found " + xmlPullParser.getName() + ", expected " + str);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static final void b(XmlPullParser xmlPullParser) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                return;
            }
        } while (next != 1);
    }

    public static final ArrayMap<String, ?> c(XmlPullParser xmlPullParser, String str, String[] strArr, a aVar) {
        ArrayMap<String, ?> arrayMap = new ArrayMap<>();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                arrayMap.put(strArr[0], g(xmlPullParser, strArr, aVar, true));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return arrayMap;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    public static final ArrayList d(XmlPullParser xmlPullParser, String str, String[] strArr, a aVar, boolean z10) {
        ArrayList arrayList = new ArrayList();
        try {
            int eventType = xmlPullParser.getEventType();
            do {
                if (eventType == 2) {
                    arrayList.add(g(xmlPullParser, strArr, aVar, z10));
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return arrayList;
                    }
                    throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new XmlPullParserException("Document ended before " + str + " end tag");
        } catch (Exception e10) {
            C1.a.b("XmlUtils", e10.toString());
            throw new XmlPullParserException(" xmlParse error cannot get eventType");
        }
    }

    public static final Object e(XmlPullParser xmlPullParser, String str) {
        try {
            if (str.equals("int")) {
                return Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, "value")));
            }
            if (str.equals("long")) {
                return Long.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            }
            if (str.equals("float")) {
                return Float.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            }
            if (str.equals("double")) {
                return Double.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            }
            if (!str.equals("boolean")) {
                return null;
            }
            return Boolean.valueOf(xmlPullParser.getAttributeValue(null, "value"));
        } catch (NullPointerException unused) {
            throw new XmlPullParserException("Need value attribute in <" + str + ">");
        } catch (NumberFormatException unused2) {
            throw new XmlPullParserException("Not a number in value attribute in <" + str + ">");
        }
    }

    public static String[] f(XmlPullParser xmlPullParser, String str, String[] strArr) {
        xmlPullParser.next();
        ArrayList arrayList = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("item")) {
                    try {
                        arrayList.add(xmlPullParser.getAttributeValue(null, "value"));
                    } catch (NullPointerException unused) {
                        throw new XmlPullParserException("Need value attribute in item");
                    } catch (NumberFormatException unused2) {
                        throw new XmlPullParserException("Not a number in value attribute in item");
                    }
                } else {
                    throw new XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                }
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return (String[]) arrayList.toArray(new String[0]);
                }
                if (!xmlPullParser.getName().equals("item")) {
                    throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                }
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    public static Object g(XmlPullParser xmlPullParser, String[] strArr, a aVar, boolean z10) {
        int next;
        Object obj = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        String name = xmlPullParser.getName();
        if (!name.equals("null")) {
            if (name.equals("string")) {
                String str = "";
                while (true) {
                    int next2 = xmlPullParser.next();
                    if (next2 != 1) {
                        if (next2 == 3) {
                            if (xmlPullParser.getName().equals("string")) {
                                strArr[0] = attributeValue;
                                return str;
                            }
                            throw new XmlPullParserException("Unexpected end tag in <string>: " + xmlPullParser.getName());
                        }
                        if (next2 == 4) {
                            str = str + xmlPullParser.getText();
                        } else if (next2 == 2) {
                            throw new XmlPullParserException("Unexpected start tag in <string>: " + xmlPullParser.getName());
                        }
                    } else {
                        throw new XmlPullParserException("Unexpected end of document in <string>");
                    }
                }
            } else {
                obj = e(xmlPullParser, name);
                if (obj == null) {
                    if (name.equals("string-array")) {
                        String[] f10 = f(xmlPullParser, "string-array", strArr);
                        strArr[0] = attributeValue;
                        return f10;
                    }
                    if (name.equals("list")) {
                        xmlPullParser.next();
                        ArrayList d10 = d(xmlPullParser, "list", strArr, aVar, z10);
                        strArr[0] = attributeValue;
                        return d10;
                    }
                    if (aVar != null) {
                        Object a10 = aVar.a(xmlPullParser, name);
                        strArr[0] = attributeValue;
                        return a10;
                    }
                    throw new XmlPullParserException("Unknown tag: " + name);
                }
            }
        }
        do {
            next = xmlPullParser.next();
            if (next != 1) {
                if (next == 3) {
                    if (xmlPullParser.getName().equals(name)) {
                        strArr[0] = attributeValue;
                        return obj;
                    }
                    throw new XmlPullParserException("Unexpected end tag in <" + name + ">: " + xmlPullParser.getName());
                }
                if (next == 4) {
                    throw new XmlPullParserException("Unexpected text in <" + name + ">: " + xmlPullParser.getName());
                }
            } else {
                throw new XmlPullParserException("Unexpected end of document in <" + name + ">");
            }
        } while (next != 2);
        throw new XmlPullParserException("Unexpected start tag in <" + name + ">: " + xmlPullParser.getName());
    }
}
