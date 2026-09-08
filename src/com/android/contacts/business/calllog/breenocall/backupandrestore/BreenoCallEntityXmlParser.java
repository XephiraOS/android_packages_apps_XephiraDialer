package com.android.contacts.business.calllog.breenocall.backupandrestore;

import H7.b;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.business.calllog.breenocall.BreenoCallLogEntity;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: BreenoCallEntityXmlParser.kt */
/* loaded from: classes.dex */
public final class BreenoCallEntityXmlParser {
    private static final boolean DEBUG = false;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "BreenoCallEntityXmlParser";

    /* compiled from: BreenoCallEntityXmlParser.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        private final long parseLong(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Long.parseLong(str);
                } catch (Exception e10) {
                    b.c(BreenoCallEntityXmlParser.TAG, "parseLong: Exception: " + e10);
                    return 0L;
                }
            }
            return 0L;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:30:0x00bf. Please report as an issue. */
        public final List<BreenoCallLogEntity> parse(String content) {
            i.f(content, "content");
            ArrayList arrayList = new ArrayList();
            try {
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                newPullParser.setInput(new StringReader(content));
                String str = "";
                String str2 = null;
                String str3 = null;
                String str4 = null;
                String str5 = null;
                long j10 = 0;
                String str6 = null;
                String str7 = null;
                String str8 = null;
                String str9 = null;
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                    if (eventType != 0) {
                        if (eventType != 1) {
                            if (eventType != 2) {
                                if (eventType == 3) {
                                    if (i.b(newPullParser.getName(), BreenoCallEntityXMLComposer.XML_BREENO_CALL_TAG)) {
                                        arrayList.add(new BreenoCallLogEntity(0L, str, str2, str3, str4, str5, j10, str6, str7, str8, str9));
                                        str2 = null;
                                        str3 = null;
                                        str4 = null;
                                        str5 = null;
                                        j10 = 0;
                                        str6 = null;
                                        str7 = null;
                                        str8 = null;
                                        str9 = null;
                                        str = "";
                                    }
                                }
                            } else {
                                String name = newPullParser.getName();
                                i.e(name, "parser.name");
                                if (i.b(name, BreenoCallEntityXMLComposer.XML_BREENO_CALL_TAG)) {
                                    int attributeCount = newPullParser.getAttributeCount();
                                    for (int i10 = 0; i10 < attributeCount; i10++) {
                                        String attributeName = newPullParser.getAttributeName(i10);
                                        String attrValue = newPullParser.getAttributeValue(i10);
                                        if (BreenoCallEntityXmlParser.DEBUG) {
                                            b.b(BreenoCallEntityXmlParser.TAG, "index: " + i10 + ", attrName: " + attributeName + ", attrValue: " + attrValue);
                                        }
                                        if (attributeName != null) {
                                            switch (attributeName.hashCode()) {
                                                case -1034364087:
                                                    if (attributeName.equals("number")) {
                                                        i.e(attrValue, "attrValue");
                                                        str = attrValue;
                                                        break;
                                                    } else {
                                                        b.b(BreenoCallEntityXmlParser.TAG, "unknown attr name " + attributeName);
                                                        break;
                                                    }
                                                case 94650:
                                                    if (attributeName.equals(BreenoCallContract.BaseColumns._ID)) {
                                                        b.b(BreenoCallEntityXmlParser.TAG, "_ID: " + attrValue);
                                                        break;
                                                    }
                                                    b.b(BreenoCallEntityXmlParser.TAG, "unknown attr name " + attributeName);
                                                    break;
                                                case 3076014:
                                                    if (attributeName.equals(BreenoCallContract.BaseColumns.DATE)) {
                                                        j10 = parseLong(attrValue);
                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                                case 96965011:
                                                    if (attributeName.equals(BreenoCallContract.BaseColumns.EXT_1)) {
                                                        str6 = attrValue;
                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                                case 96965012:
                                                    if (attributeName.equals(BreenoCallContract.BaseColumns.EXT_2)) {
                                                        str7 = attrValue;
                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                                case 96965013:
                                                    if (attributeName.equals(BreenoCallContract.BaseColumns.EXT_3)) {
                                                        str8 = attrValue;
                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                                case 96965014:
                                                    if (attributeName.equals(BreenoCallContract.BaseColumns.EXT_4)) {
                                                        str9 = attrValue;
                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                                case 580902733:
                                                    if (attributeName.equals(BreenoCallContract.CallColumns.PERSONAL_INFO)) {
                                                        str4 = attrValue;
                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                                case 948134289:
                                                    if (attributeName.equals(BreenoCallContract.BaseColumns.NORMALIZED_NUMBER)) {
                                                        str2 = attrValue;
                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                                case 1233551842:
                                                    if (attributeName.equals(BreenoCallContract.CallColumns.NAME_INFO)) {
                                                        str3 = attrValue;
                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                                case 1780651227:
                                                    if (attributeName.equals(BreenoCallContract.CallColumns.NOTE_INFO)) {
                                                        str5 = attrValue;
                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                            }
                                        }
                                        b.b(BreenoCallEntityXmlParser.TAG, "unknown attr name " + attributeName);
                                    }
                                }
                            }
                        } else {
                            b.b(BreenoCallEntityXmlParser.TAG, "XmlPullParser.END_DOCUMENT");
                        }
                    } else {
                        b.b(BreenoCallEntityXmlParser.TAG, "XmlPullParser.START_DOCUMENT");
                    }
                }
            } catch (Exception e10) {
                b.c(BreenoCallEntityXmlParser.TAG, "Exception when parse " + e10);
            }
            return arrayList;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public static final List<BreenoCallLogEntity> parse(String str) {
        return Companion.parse(str);
    }
}
