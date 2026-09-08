package com.customize.contacts.backupandrestore.plugin;

import H7.b;
import android.text.TextUtils;
import com.customize.contacts.backupandrestore.plugin.SpeedDialRestorePlugin;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import kotlin.collections.E;
import kotlin.jvm.internal.i;
import m9.g;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: SpeedDialXmlParser.kt */
/* loaded from: classes3.dex */
public final class SpeedDialXmlParser {
    private static final String ATT_KEY = "key";
    private static final String ATT_NAME = "name";
    private static final String ATT_PHONE = "phone";
    public static final SpeedDialXmlParser INSTANCE = new SpeedDialXmlParser();
    private static final String NODE_TAG = "SpeedDialSet";
    private static final String TAG = "SpeedDialXmlParser";

    private SpeedDialXmlParser() {
    }

    private final String getXmlInfo(FileDescriptor fileDescriptor) {
        StringBuilder sb;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(fileDescriptor);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e10) {
            e = e10;
        } catch (IndexOutOfBoundsException e11) {
            e = e11;
        } catch (NullPointerException e12) {
            e = e12;
        } catch (Exception e13) {
            e = e13;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[512];
            for (int read = fileInputStream.read(bArr, 0, 512); read != -1; read = fileInputStream.read(bArr, 0, 512)) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            i.e(byteArrayOutputStream2, "byteArrayOutputStream.toString()");
            try {
                fileInputStream.close();
            } catch (Exception e14) {
                b.b(TAG, "Exception : " + e14);
            }
            return byteArrayOutputStream2;
        } catch (IOException e15) {
            e = e15;
            fileInputStream2 = fileInputStream;
            b.b(TAG, "IO Exception : " + e);
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                    return "";
                } catch (Exception e16) {
                    e = e16;
                    sb = new StringBuilder();
                    sb.append("Exception : ");
                    sb.append(e);
                    b.b(TAG, sb.toString());
                    return "";
                }
            }
            return "";
        } catch (IndexOutOfBoundsException e17) {
            e = e17;
            fileInputStream2 = fileInputStream;
            b.b(TAG, "Index Out Of Bounds Exception : " + e);
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                    return "";
                } catch (Exception e18) {
                    e = e18;
                    sb = new StringBuilder();
                    sb.append("Exception : ");
                    sb.append(e);
                    b.b(TAG, sb.toString());
                    return "";
                }
            }
            return "";
        } catch (NullPointerException e19) {
            e = e19;
            fileInputStream2 = fileInputStream;
            b.b(TAG, "Null Pointer Exception : " + e);
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                    return "";
                } catch (Exception e20) {
                    e = e20;
                    sb = new StringBuilder();
                    sb.append("Exception : ");
                    sb.append(e);
                    b.b(TAG, sb.toString());
                    return "";
                }
            }
            return "";
        } catch (Exception e21) {
            e = e21;
            fileInputStream2 = fileInputStream;
            b.b(TAG, "Exception : " + e);
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                    return "";
                } catch (Exception e22) {
                    e = e22;
                    sb = new StringBuilder();
                    sb.append("Exception : ");
                    sb.append(e);
                    b.b(TAG, sb.toString());
                    return "";
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e23) {
                    b.b(TAG, "Exception : " + e23);
                }
            }
            throw th;
        }
    }

    public final void parse(FileDescriptor fileName) {
        Map<String, String[]> f10;
        char c10;
        int i10;
        i.f(fileName, "fileName");
        String xmlInfo = getXmlInfo(fileName);
        if (TextUtils.isEmpty(xmlInfo)) {
            return;
        }
        char c11 = '\n';
        String[] strArr = new String[10];
        int i11 = 0;
        strArr[0] = "";
        int i12 = 1;
        strArr[1] = "";
        int i13 = 2;
        strArr[2] = "";
        strArr[3] = "";
        strArr[4] = "";
        strArr[5] = "";
        strArr[6] = "";
        strArr[7] = "";
        strArr[8] = "";
        strArr[9] = "";
        String[] strArr2 = new String[10];
        strArr2[0] = "";
        strArr2[1] = "";
        strArr2[2] = "";
        strArr2[3] = "";
        strArr2[4] = "";
        strArr2[5] = "";
        strArr2[6] = "";
        strArr2[7] = "";
        strArr2[8] = "";
        strArr2[9] = "";
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(new StringReader(xmlInfo));
            for (int eventType = newPullParser.getEventType(); eventType != i12; eventType = newPullParser.next()) {
                if (eventType != i13 || !i.b(newPullParser.getName(), NODE_TAG)) {
                    c10 = c11;
                } else {
                    int attributeCount = newPullParser.getAttributeCount();
                    int i14 = -1;
                    int i15 = i11;
                    String str = "";
                    String str2 = str;
                    while (i15 < attributeCount) {
                        String attributeName = newPullParser.getAttributeName(i15);
                        String value = newPullParser.getAttributeValue(i15);
                        if (attributeName != null) {
                            int hashCode = attributeName.hashCode();
                            if (hashCode != 106079) {
                                i10 = attributeCount;
                                if (hashCode != 3373707) {
                                    if (hashCode == 106642798 && attributeName.equals(ATT_PHONE)) {
                                        i.e(value, "value");
                                        str = value;
                                    }
                                } else if (attributeName.equals("name")) {
                                    i.e(value, "value");
                                    str2 = value;
                                }
                            } else {
                                i10 = attributeCount;
                                if (attributeName.equals(ATT_KEY)) {
                                    i14 = Integer.parseInt(value);
                                }
                            }
                        } else {
                            i10 = attributeCount;
                        }
                        i15++;
                        attributeCount = i10;
                    }
                    c10 = '\n';
                    if (i14 > 0 && i14 < 10) {
                        strArr[i14] = str;
                        strArr2[i14] = str2;
                    }
                }
                i11 = 0;
                i12 = 1;
                i13 = 2;
                c11 = c10;
            }
        } catch (IOException e10) {
            b.b(TAG, "IO Exception : " + e10);
        } catch (XmlPullParserException e11) {
            b.b(TAG, "Xml Pull Parser Exception : " + e11);
        } catch (Exception e12) {
            b.b(TAG, "Exception : " + e12);
        }
        SpeedDialRestorePlugin.Companion companion = SpeedDialRestorePlugin.Companion;
        f10 = E.f(g.a("name", strArr2), g.a(ATT_PHONE, strArr));
        companion.setMap(f10);
    }
}
