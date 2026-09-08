package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import com.oplus.backup.sdk.common.utils.Constants;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: PreferenceInflater.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: e, reason: collision with root package name */
    public static final Class<?>[] f10600e = {Context.class, AttributeSet.class};

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap<String, Constructor<?>> f10601f = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    public final Context f10602a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f10603b = new Object[2];

    /* renamed from: c, reason: collision with root package name */
    public j f10604c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f10605d;

    public i(Context context, j jVar) {
        this.f10602a = context;
        f(jVar);
    }

    public static void k(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                if (next == 3 && xmlPullParser.getDepth() <= depth) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final Preference a(String str, String[] strArr, AttributeSet attributeSet) {
        Class<?> cls;
        Constructor<?> constructor = f10601f.get(str);
        if (constructor == null) {
            try {
                try {
                    ClassLoader classLoader = this.f10602a.getClassLoader();
                    if (strArr != null && strArr.length != 0) {
                        cls = null;
                        ClassNotFoundException e10 = null;
                        for (String str2 : strArr) {
                            try {
                                cls = Class.forName(str2 + str, false, classLoader);
                                break;
                            } catch (ClassNotFoundException e11) {
                                e10 = e11;
                            }
                        }
                        if (cls == null) {
                            if (e10 == null) {
                                throw new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                            }
                            throw e10;
                        }
                        constructor = cls.getConstructor(f10600e);
                        constructor.setAccessible(true);
                        f10601f.put(str, constructor);
                    }
                    cls = Class.forName(str, false, classLoader);
                    constructor = cls.getConstructor(f10600e);
                    constructor.setAccessible(true);
                    f10601f.put(str, constructor);
                } catch (Exception e12) {
                    InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                    inflateException.initCause(e12);
                    throw inflateException;
                }
            } catch (ClassNotFoundException e13) {
                throw e13;
            }
        }
        Object[] objArr = this.f10603b;
        objArr[1] = attributeSet;
        return (Preference) constructor.newInstance(objArr);
    }

    public final Preference b(String str, AttributeSet attributeSet) {
        try {
            if (-1 == str.indexOf(46)) {
                return g(str, attributeSet);
            }
            return a(str, null, attributeSet);
        } catch (InflateException e10) {
            throw e10;
        } catch (ClassNotFoundException e11) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class (not found)" + str);
            inflateException.initCause(e11);
            throw inflateException;
        } catch (Exception e12) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e12);
            throw inflateException2;
        }
    }

    public Context c() {
        return this.f10602a;
    }

    public Preference d(int i10, PreferenceGroup preferenceGroup) {
        XmlResourceParser xml = c().getResources().getXml(i10);
        try {
            return e(xml, preferenceGroup);
        } finally {
            xml.close();
        }
    }

    public Preference e(XmlPullParser xmlPullParser, PreferenceGroup preferenceGroup) {
        int next;
        PreferenceGroup h10;
        synchronized (this.f10603b) {
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            this.f10603b[0] = this.f10602a;
            do {
                try {
                    next = xmlPullParser.next();
                    if (next == 2) {
                        break;
                    }
                } catch (InflateException e10) {
                    throw e10;
                } catch (IOException e11) {
                    InflateException inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": " + e11.getMessage());
                    inflateException.initCause(e11);
                    throw inflateException;
                } catch (XmlPullParserException e12) {
                    InflateException inflateException2 = new InflateException(e12.getMessage());
                    inflateException2.initCause(e12);
                    throw inflateException2;
                }
            } while (next != 1);
            if (next == 2) {
                h10 = h(preferenceGroup, (PreferenceGroup) b(xmlPullParser.getName(), asAttributeSet));
                i(xmlPullParser, h10, asAttributeSet);
            } else {
                throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
            }
        }
        return h10;
    }

    public final void f(j jVar) {
        this.f10604c = jVar;
        j(new String[]{Preference.class.getPackage().getName() + ".", SwitchPreference.class.getPackage().getName() + "."});
    }

    public Preference g(String str, AttributeSet attributeSet) {
        return a(str, this.f10605d, attributeSet);
    }

    public final PreferenceGroup h(PreferenceGroup preferenceGroup, PreferenceGroup preferenceGroup2) {
        if (preferenceGroup == null) {
            preferenceGroup2.onAttachedToHierarchy(this.f10604c);
            return preferenceGroup2;
        }
        return preferenceGroup;
    }

    public final void i(XmlPullParser xmlPullParser, Preference preference, AttributeSet attributeSet) {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (Constants.MessagerConstants.INTENT_KEY.equals(name)) {
                        try {
                            preference.setIntent(Intent.parseIntent(c().getResources(), xmlPullParser, attributeSet));
                        } catch (IOException e10) {
                            XmlPullParserException xmlPullParserException = new XmlPullParserException("Error parsing preference");
                            xmlPullParserException.initCause(e10);
                            throw xmlPullParserException;
                        }
                    } else if ("extra".equals(name)) {
                        c().getResources().parseBundleExtra("extra", attributeSet, preference.getExtras());
                        try {
                            k(xmlPullParser);
                        } catch (IOException e11) {
                            XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Error parsing preference");
                            xmlPullParserException2.initCause(e11);
                            throw xmlPullParserException2;
                        }
                    } else {
                        Preference b10 = b(name, attributeSet);
                        ((PreferenceGroup) preference).addItemFromInflater(b10);
                        i(xmlPullParser, b10, attributeSet);
                    }
                }
            } else {
                return;
            }
        }
    }

    public void j(String[] strArr) {
        this.f10605d = strArr;
    }
}
