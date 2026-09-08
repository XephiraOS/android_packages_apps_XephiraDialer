package com.customize.contacts.backupandrestore.plugin;

import H7.b;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Xml;
import com.android.contacts.dialpad.SpeedDialManageActivity;
import java.io.IOException;
import java.io.StringWriter;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: SpeedDialXmlComposer.kt */
/* loaded from: classes3.dex */
public final class SpeedDialXmlComposer {
    private static final String ATT_KEY = "key";
    private static final String ATT_NAME = "name";
    private static final String ATT_PHONE = "phone";
    public static final Companion Companion = new Companion(null);
    private static final String NODE_TAG = "SpeedDialSet";
    private static final String START_END_TAG = "SpeedDial";
    private static final String TAG = "SpeedDialXmlComposer";
    private final Context context;
    private final String[] prefDataIdState;
    private final String[] prefDisplayNameState;
    private final String[] prefNumState;
    private XmlSerializer serializer;
    private StringWriter stringWriter;

    /* compiled from: SpeedDialXmlComposer.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public SpeedDialXmlComposer(Context context) {
        i.f(context, "context");
        this.context = context;
        this.prefDataIdState = new String[]{"", "", "", "", "", "", "", "", "", ""};
        this.prefNumState = new String[]{"", "", "", "", "", "", "", "", "", ""};
        this.prefDisplayNameState = new String[]{"", "", "", "", "", "", "", "", "", ""};
    }

    private final boolean addSpeedDialSet(String str, String str2, String str3) {
        try {
            XmlSerializer xmlSerializer = this.serializer;
            XmlSerializer xmlSerializer2 = null;
            if (xmlSerializer == null) {
                i.q("serializer");
                xmlSerializer = null;
            }
            xmlSerializer.startTag("", NODE_TAG);
            XmlSerializer xmlSerializer3 = this.serializer;
            if (xmlSerializer3 == null) {
                i.q("serializer");
                xmlSerializer3 = null;
            }
            xmlSerializer3.attribute("", ATT_KEY, str);
            XmlSerializer xmlSerializer4 = this.serializer;
            if (xmlSerializer4 == null) {
                i.q("serializer");
                xmlSerializer4 = null;
            }
            xmlSerializer4.attribute("", "name", str3);
            XmlSerializer xmlSerializer5 = this.serializer;
            if (xmlSerializer5 == null) {
                i.q("serializer");
                xmlSerializer5 = null;
            }
            xmlSerializer5.attribute("", ATT_PHONE, str2);
            XmlSerializer xmlSerializer6 = this.serializer;
            if (xmlSerializer6 == null) {
                i.q("serializer");
            } else {
                xmlSerializer2 = xmlSerializer6;
            }
            xmlSerializer2.endTag("", NODE_TAG);
            return true;
        } catch (IOException e10) {
            b.b(TAG, "IO Exception : " + e10);
            return false;
        }
    }

    private final boolean endCompose() {
        try {
            XmlSerializer xmlSerializer = this.serializer;
            XmlSerializer xmlSerializer2 = null;
            if (xmlSerializer == null) {
                i.q("serializer");
                xmlSerializer = null;
            }
            xmlSerializer.endTag("", START_END_TAG);
            XmlSerializer xmlSerializer3 = this.serializer;
            if (xmlSerializer3 == null) {
                i.q("serializer");
            } else {
                xmlSerializer2 = xmlSerializer3;
            }
            xmlSerializer2.endDocument();
            return true;
        } catch (IOException e10) {
            b.b(TAG, "IO Exception : " + e10);
            return false;
        } catch (IllegalArgumentException e11) {
            b.b(TAG, "Illegal Argument Exception : " + e11);
            return false;
        } catch (IllegalStateException e12) {
            b.b(TAG, "Illegal State Exception : " + e12);
            return false;
        }
    }

    private final void getPrefStatus() {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences("speed_dial", 0);
        for (int i10 = 2; i10 < 10; i10++) {
            String[] strArr = this.prefDataIdState;
            SpeedDialManageActivity.a aVar = SpeedDialManageActivity.f14891G;
            String string = sharedPreferences.getString(String.valueOf(aVar.a(i10)), "");
            i.c(string);
            strArr[i10] = string;
            String[] strArr2 = this.prefNumState;
            String string2 = sharedPreferences.getString(String.valueOf(i10), "");
            i.c(string2);
            strArr2[i10] = string2;
            String[] strArr3 = this.prefDisplayNameState;
            String string3 = sharedPreferences.getString(String.valueOf(aVar.b(i10)), "");
            i.c(string3);
            strArr3[i10] = string3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0063, code lost:
    
        if (r1.moveToFirst() != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0065, code lost:
    
        r0 = com.android.contacts.dialpad.ContactInfoForSpeedDial.c.f14863a;
        r3 = r1.getString(r0.c());
        r6 = r1.getString(r0.d());
        r0 = r1.getString(r0.b());
        r7 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0080, code lost:
    
        if (r7 >= 10) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008a, code lost:
    
        if (android.text.TextUtils.equals(r3, r12.prefDataIdState[r7]) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008c, code lost:
    
        r8 = r12.prefDisplayNameState;
        kotlin.jvm.internal.i.e(r6, "name");
        r8[r7] = r6;
        r8 = r12.prefNumState;
        kotlin.jvm.internal.i.e(r0, "number");
        r8[r7] = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a1, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a8, code lost:
    
        if (r1.moveToNext() != false) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void obtainLatestPref() {
        /*
            r12 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 1
            r2 = 2
            r3 = r2
        L8:
            java.lang.String r4 = ""
            r5 = 10
            if (r3 >= r5) goto L44
            java.lang.String[] r5 = r12.prefDisplayNameState
            r5[r3] = r4
            java.lang.String[] r5 = r12.prefNumState
            r5[r3] = r4
            java.lang.String[] r4 = r12.prefDataIdState
            r4 = r4[r3]
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L21
            goto L41
        L21:
            if (r1 != 0) goto L28
            java.lang.String r1 = " OR "
            r0.append(r1)
        L28:
            java.lang.String[] r1 = r12.prefDataIdState
            r1 = r1[r3]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Data._id = "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r0.append(r1)
            r1 = 0
        L41:
            int r3 = r3 + 1
            goto L8
        L44:
            r1 = 0
            android.content.Context r3 = r12.context     // Catch: java.lang.Throwable -> L9f
            android.content.ContentResolver r6 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L9f
            android.net.Uri r7 = android.provider.ContactsContract.Data.CONTENT_URI     // Catch: java.lang.Throwable -> L9f
            com.android.contacts.dialpad.ContactInfoForSpeedDial$c r3 = com.android.contacts.dialpad.ContactInfoForSpeedDial.c.f14863a     // Catch: java.lang.Throwable -> L9f
            java.lang.String[] r8 = r3.h()     // Catch: java.lang.Throwable -> L9f
            java.lang.String r9 = r0.toString()     // Catch: java.lang.Throwable -> L9f
            r10 = 0
            r11 = 0
            android.database.Cursor r1 = G7.c.e(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L9f
            if (r1 == 0) goto Laa
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L9f
            if (r0 == 0) goto Laa
        L65:
            com.android.contacts.dialpad.ContactInfoForSpeedDial$c r0 = com.android.contacts.dialpad.ContactInfoForSpeedDial.c.f14863a     // Catch: java.lang.Throwable -> L9f
            int r3 = r0.c()     // Catch: java.lang.Throwable -> L9f
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L9f
            int r6 = r0.d()     // Catch: java.lang.Throwable -> L9f
            java.lang.String r6 = r1.getString(r6)     // Catch: java.lang.Throwable -> L9f
            int r0 = r0.b()     // Catch: java.lang.Throwable -> L9f
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L9f
            r7 = r2
        L80:
            if (r7 >= r5) goto La4
            java.lang.String[] r8 = r12.prefDataIdState     // Catch: java.lang.Throwable -> L9f
            r8 = r8[r7]     // Catch: java.lang.Throwable -> L9f
            boolean r8 = android.text.TextUtils.equals(r3, r8)     // Catch: java.lang.Throwable -> L9f
            if (r8 == 0) goto La1
            java.lang.String[] r8 = r12.prefDisplayNameState     // Catch: java.lang.Throwable -> L9f
            java.lang.String r9 = "name"
            kotlin.jvm.internal.i.e(r6, r9)     // Catch: java.lang.Throwable -> L9f
            r8[r7] = r6     // Catch: java.lang.Throwable -> L9f
            java.lang.String[] r8 = r12.prefNumState     // Catch: java.lang.Throwable -> L9f
            java.lang.String r9 = "number"
            kotlin.jvm.internal.i.e(r0, r9)     // Catch: java.lang.Throwable -> L9f
            r8[r7] = r0     // Catch: java.lang.Throwable -> L9f
            goto La1
        L9f:
            r12 = move-exception
            goto Lcb
        La1:
            int r7 = r7 + 1
            goto L80
        La4:
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> L9f
            if (r0 != 0) goto L65
        Laa:
            com.oplus.foundation.util.io.e.a(r1)
        Lad:
            if (r2 >= r5) goto Lca
            java.lang.String[] r0 = r12.prefDisplayNameState
            r0 = r0[r2]
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto Lc7
            java.lang.String[] r0 = r12.prefNumState
            r0 = r0[r2]
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto Lc7
            java.lang.String[] r0 = r12.prefDataIdState
            r0[r2] = r4
        Lc7:
            int r2 = r2 + 1
            goto Lad
        Lca:
            return
        Lcb:
            com.oplus.foundation.util.io.e.a(r1)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.backupandrestore.plugin.SpeedDialXmlComposer.obtainLatestPref():void");
    }

    private final boolean startComposer() {
        XmlSerializer newSerializer = Xml.newSerializer();
        i.e(newSerializer, "newSerializer()");
        this.serializer = newSerializer;
        this.stringWriter = new StringWriter();
        try {
            XmlSerializer xmlSerializer = this.serializer;
            XmlSerializer xmlSerializer2 = null;
            if (xmlSerializer == null) {
                i.q("serializer");
                xmlSerializer = null;
            }
            StringWriter stringWriter = this.stringWriter;
            if (stringWriter == null) {
                i.q("stringWriter");
                stringWriter = null;
            }
            xmlSerializer.setOutput(stringWriter);
            XmlSerializer xmlSerializer3 = this.serializer;
            if (xmlSerializer3 == null) {
                i.q("serializer");
                xmlSerializer3 = null;
            }
            xmlSerializer3.startDocument(null, Boolean.FALSE);
            XmlSerializer xmlSerializer4 = this.serializer;
            if (xmlSerializer4 == null) {
                i.q("serializer");
            } else {
                xmlSerializer2 = xmlSerializer4;
            }
            xmlSerializer2.startTag("", START_END_TAG);
            return true;
        } catch (IOException e10) {
            b.b(TAG, "IO Exception : " + e10);
            return false;
        } catch (IllegalArgumentException e11) {
            b.b(TAG, "Illegal Argument Exception : " + e11);
            return false;
        } catch (IllegalStateException e12) {
            b.b(TAG, "Illegal State Exception : " + e12);
            return false;
        }
    }

    public final String getSpeedDialData() {
        startComposer();
        getPrefStatus();
        obtainLatestPref();
        for (int i10 = 2; i10 < 10; i10++) {
            if (!TextUtils.isEmpty(this.prefDisplayNameState[i10]) && !TextUtils.isEmpty(this.prefNumState[i10])) {
                addSpeedDialSet(String.valueOf(i10), this.prefNumState[i10], this.prefDisplayNameState[i10]);
            }
        }
        endCompose();
        StringWriter stringWriter = this.stringWriter;
        if (stringWriter == null) {
            i.q("stringWriter");
            stringWriter = null;
        }
        String stringWriter2 = stringWriter.toString();
        i.e(stringWriter2, "stringWriter.toString()");
        return stringWriter2;
    }

    public final void setSpeedDialData(String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null) {
            getPrefStatus();
            obtainLatestPref();
            SharedPreferences sharedPreferences = this.context.getSharedPreferences("speed_dial", 0);
            if (sharedPreferences == null) {
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            for (int i10 = 2; i10 < 10; i10++) {
                if (TextUtils.isEmpty(this.prefDisplayNameState[i10]) && TextUtils.isEmpty(this.prefNumState[i10])) {
                    SpeedDialManageActivity.a aVar = SpeedDialManageActivity.f14891G;
                    edit.putString(String.valueOf(aVar.a(i10)), "");
                    edit.putString(String.valueOf(i10), strArr[i10]);
                    edit.putString(String.valueOf(aVar.b(i10)), strArr2[i10]);
                }
            }
            edit.apply();
        }
    }
}
