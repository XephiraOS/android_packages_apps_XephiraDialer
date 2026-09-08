package t1;

import C1.e;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.ArrayMap;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: TelephonyVvmConfigManager.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, PersistableBundle> f37147b;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, PersistableBundle> f37148a;

    /* compiled from: TelephonyVvmConfigManager.java */
    /* loaded from: classes.dex */
    public static class a implements e.a {
        @Override // C1.e.a
        public Object a(XmlPullParser xmlPullParser, String str) {
            if ("pbundle_as_map".equals(str)) {
                return e.d(xmlPullParser);
            }
            throw new XmlPullParserException("Unknown tag=" + str);
        }
    }

    public e(Context context) {
        if (f37147b == null) {
            f37147b = b(context, context.getResources().getXml(R.xml.vvm_config));
        }
        this.f37148a = f37147b;
    }

    public static Map<String, PersistableBundle> b(Context context, XmlPullParser xmlPullParser) {
        ArrayMap arrayMap = new ArrayMap();
        try {
            ArrayList c10 = c(xmlPullParser);
            if (c10 != null) {
                Iterator it = c10.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof PersistableBundle) {
                        PersistableBundle persistableBundle = (PersistableBundle) next;
                        if (!persistableBundle.containsKey("feature_flag_name") || s1.d.a(context).a(persistableBundle.getString("feature_flag_name"), false)) {
                            String[] stringArray = persistableBundle.getStringArray("mccmnc");
                            if (stringArray != null) {
                                for (String str : stringArray) {
                                    arrayMap.put(str, persistableBundle);
                                }
                            } else {
                                throw new IllegalArgumentException("MCCMNC is null");
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("PersistableBundle expected, got " + next);
                    }
                }
            }
        } catch (Exception e10) {
            C1.a.b("TelephonyVvmCfgMgr", "error loadConfigs " + e10);
        }
        return arrayMap;
    }

    public static ArrayList c(XmlPullParser xmlPullParser) {
        int next;
        int depth = xmlPullParser.getDepth();
        do {
            next = xmlPullParser.next();
            if (next != 1) {
                if (next == 3 && xmlPullParser.getDepth() >= depth) {
                    return null;
                }
            } else {
                return null;
            }
        } while (next != 2);
        xmlPullParser.next();
        return C1.e.d(xmlPullParser, xmlPullParser.getName(), new String[1], new a(), false);
    }

    public static PersistableBundle d(XmlPullParser xmlPullParser) {
        int next;
        int depth = xmlPullParser.getDepth();
        String name = xmlPullParser.getName();
        String[] strArr = new String[1];
        do {
            next = xmlPullParser.next();
            if (next == 1 || (next == 3 && xmlPullParser.getDepth() >= depth)) {
                return PersistableBundle.EMPTY;
            }
        } while (next != 2);
        ArrayMap<String, ?> c10 = C1.e.c(xmlPullParser, name, strArr, new a());
        PersistableBundle persistableBundle = new PersistableBundle();
        for (Map.Entry<String, ?> entry : c10.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Integer) {
                persistableBundle.putInt(entry.getKey(), ((Integer) value).intValue());
            } else if (value instanceof Boolean) {
                persistableBundle.putBoolean(entry.getKey(), ((Boolean) value).booleanValue());
            } else if (value instanceof String) {
                persistableBundle.putString(entry.getKey(), (String) value);
            } else if (value instanceof String[]) {
                persistableBundle.putStringArray(entry.getKey(), (String[]) value);
            } else if (value instanceof PersistableBundle) {
                persistableBundle.putPersistableBundle(entry.getKey(), (PersistableBundle) value);
            }
        }
        return persistableBundle;
    }

    public PersistableBundle a(String str) {
        return this.f37148a.get(str);
    }
}
