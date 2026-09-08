package r5;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import com.heytap.accessory.utils.ResourceParserException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import n5.C1371a;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: XmlReader.java */
/* loaded from: classes3.dex */
public class k {
    public static int a(String str) {
        int i10 = 0;
        for (String str2 : str.split("\\|")) {
            if ("BLE".equalsIgnoreCase(str2)) {
                i10 |= 4;
            }
            if ("BT".equalsIgnoreCase(str2)) {
                i10 |= 2;
            }
            if ("WIFI".equalsIgnoreCase(str2)) {
                i10 |= 9;
            }
            if ("ALL".equalsIgnoreCase(str2)) {
                i10 = 255;
            }
        }
        return i10;
    }

    public static String b(Context context, String str, String str2) {
        Bundle bundle;
        String str3 = "Unable to fetch metadata: " + str2 + ", did you forget to add " + str2 + " in manifest?";
        try {
            bundle = context.getApplicationContext().getPackageManager().getApplicationInfo(str, 128).metaData;
        } catch (PackageManager.NameNotFoundException unused) {
            C1371a.d("XmlReader", str3);
            bundle = null;
        }
        if (bundle == null) {
            C1371a.d("XmlReader", str3);
            return null;
        }
        String string = bundle.getString(str2, null);
        if (string == null) {
            C1371a.d("XmlReader", "No meta data found with key: " + str2 + " in " + str);
        }
        return string;
    }

    public static Resources c(Context context, String str) {
        return context.getPackageManager().getResourcesForApplication(str);
    }

    public static synchronized byte[] d(XmlPullParser xmlPullParser) {
        byte[] bytes;
        synchronized (k.class) {
            try {
                StringBuilder sb = new StringBuilder();
                try {
                    int eventType = xmlPullParser.getEventType();
                    while (eventType != 1) {
                        if (eventType != 0) {
                            if (eventType != 2) {
                                if (eventType == 3) {
                                    sb.append(String.format("</%s>", xmlPullParser.getName()));
                                } else if (eventType == 4) {
                                    sb.append(xmlPullParser.getText().trim());
                                }
                            } else {
                                sb.append(String.format("<%s ", xmlPullParser.getName().trim()));
                                int attributeCount = xmlPullParser.getAttributeCount();
                                if (attributeCount > 0) {
                                    for (int i10 = 0; i10 < attributeCount; i10++) {
                                        sb.append(String.format("%s=\"%s\"", xmlPullParser.getAttributeName(i10).trim(), xmlPullParser.getAttributeValue(i10).trim()));
                                    }
                                }
                                sb.append(">");
                            }
                        }
                        if (sb.length() < 65529) {
                            eventType = xmlPullParser.next();
                        } else {
                            throw new ResourceParserException("Accessory Service XML is too long! Services XML cannot be more than 64k in size");
                        }
                    }
                    bytes = sb.toString().getBytes(h.f());
                } catch (IOException | XmlPullParserException e10) {
                    throw new ResourceParserException(e10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bytes;
    }

    public static synchronized byte[] e(Context context, String str, String str2) {
        byte[] bArr;
        synchronized (k.class) {
            if (str2.startsWith("/res")) {
                String substring = str2.substring(str2.lastIndexOf(File.separator) + 1, str2.lastIndexOf("."));
                C1371a.c("XmlReader", "Fetching xml from /res/xml/" + substring);
                XmlResourceParser xmlResourceParser = null;
                try {
                    try {
                        Resources c10 = c(context, str);
                        int identifier = c10.getIdentifier(substring, "xml", str);
                        if (identifier == 0) {
                            C1371a.k("XmlReader", "invalid id 0,return");
                            return null;
                        }
                        XmlResourceParser xml = c10.getXml(identifier);
                        bArr = d(xml);
                        if (xml != null) {
                            xml.close();
                        }
                        return bArr;
                    } catch (Throwable th) {
                        if (0 != 0) {
                            xmlResourceParser.close();
                        }
                        throw th;
                    }
                } catch (Resources.NotFoundException e10) {
                    throw new ResourceParserException("configuration XML file not found at:" + str2 + ", pkg:" + str, e10);
                } catch (Exception e11) {
                    throw new ResourceParserException("configuration XML file parse failed:" + str2 + ", pkg:" + str, e11);
                }
            }
            if (str2.startsWith("/assets/")) {
                C1371a.c("XmlReader", "Fetching xml from /assets");
                try {
                    InputStream open = context.getAssets().open(str2.substring(8));
                    try {
                        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
                        newInstance.setNamespaceAware(true);
                        XmlPullParser newPullParser = newInstance.newPullParser();
                        newPullParser.setInput(open, h.f());
                        byte[] d10 = d(newPullParser);
                        if (open != null) {
                            open.close();
                        }
                        bArr = d10;
                        return bArr;
                    } catch (Throwable th2) {
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                } catch (IOException | XmlPullParserException e12) {
                    throw new ResourceParserException("Parsing Accessory service configuration failed from:" + str2, e12);
                }
            }
            throw new ResourceParserException("Endpoint profile xml must be in /res or /assets directory.");
        }
    }
}
