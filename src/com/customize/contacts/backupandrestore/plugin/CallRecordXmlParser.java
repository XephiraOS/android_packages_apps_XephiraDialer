package com.customize.contacts.backupandrestore.plugin;

import C7.f;
import H7.b;
import Q0.c;
import android.util.Log;
import com.oplus.backup.sdk.common.utils.Constants;
import java.io.StringReader;
import java.util.LinkedList;
import kotlin.jvm.internal.i;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: CallRecordXmlParser.kt */
/* loaded from: classes3.dex */
public final class CallRecordXmlParser {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "CallRecordXmlParser";

    /* compiled from: CallRecordXmlParser.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:30:0x0081. Please report as an issue. */
        public final LinkedList<c> parse(String content) {
            i.f(content, "content");
            LinkedList<c> linkedList = new LinkedList<>();
            try {
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                newPullParser.setInput(new StringReader(content));
                c cVar = null;
                String str = null;
                long j10 = 0;
                String str2 = null;
                int i10 = 0;
                String str3 = null;
                String str4 = null;
                long j11 = 0;
                long j12 = 0;
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                    if (eventType != 0) {
                        if (eventType != 1) {
                            if (eventType != 2) {
                                if (eventType != 3) {
                                    continue;
                                } else if (i.b(newPullParser.getName(), "call_recording")) {
                                    if (cVar != null) {
                                        linkedList.add(cVar);
                                    }
                                    str = null;
                                    j10 = 0;
                                    str2 = null;
                                    i10 = 0;
                                    str3 = null;
                                    str4 = null;
                                    j11 = 0;
                                    j12 = 0;
                                }
                            } else {
                                String name = newPullParser.getName();
                                i.e(name, "parser.name");
                                if (i.b(name, "call_recording")) {
                                    int attributeCount = newPullParser.getAttributeCount();
                                    for (int i11 = 0; i11 < attributeCount; i11++) {
                                        String attributeName = newPullParser.getAttributeName(i11);
                                        String attributeValue = newPullParser.getAttributeValue(i11);
                                        if (attributeName != null) {
                                            switch (attributeName.hashCode()) {
                                                case -1034364087:
                                                    if (attributeName.equals("number")) {
                                                        str = attributeValue;
                                                        break;
                                                    } else {
                                                        Log.d(CallRecordXmlParser.TAG, "unknown attr name " + attributeName);
                                                        break;
                                                    }
                                                case -775397377:
                                                    if (attributeName.equals("sec_record")) {
                                                        i10 = f.c(attributeValue, 0);
                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                                case 3433509:
                                                    if (attributeName.equals(Constants.MessagerConstants.PATH_KEY)) {
                                                        str2 = attributeValue;
                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                                case 95356359:
                                                    if (attributeName.equals("data1")) {
                                                        str3 = attributeValue;
                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                                case 95356360:
                                                    if (attributeName.equals("data2")) {
                                                        str4 = attributeValue;
                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                                case 95356361:
                                                    if (attributeName.equals("data3")) {
                                                        j11 = f.d(attributeValue, 0L);
                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                                case 95356362:
                                                    if (attributeName.equals("data4")) {
                                                        j12 = f.d(attributeValue, 0L);
                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                                case 765991538:
                                                    if (attributeName.equals("call_log_mapping")) {
                                                        j10 = f.d(attributeValue, 0L);
                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                            }
                                        }
                                        Log.d(CallRecordXmlParser.TAG, "unknown attr name " + attributeName);
                                    }
                                    cVar = new c(0L, str, j10, str2, i10, str3, str4, j11, j12);
                                }
                            }
                        } else {
                            b.b(CallRecordXmlParser.TAG, "XmlPullParser.END_DOCUMENT");
                        }
                    } else {
                        b.b(CallRecordXmlParser.TAG, "XmlPullParser.START_DOCUMENT");
                    }
                }
            } catch (Exception e10) {
                Log.e(CallRecordXmlParser.TAG, "Exception when parse " + e10);
            }
            return linkedList;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public static final LinkedList<c> parse(String str) {
        return Companion.parse(str);
    }
}
