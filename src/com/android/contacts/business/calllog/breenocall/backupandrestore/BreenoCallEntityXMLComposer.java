package com.android.contacts.business.calllog.breenocall.backupandrestore;

import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.business.calllog.breenocall.BreenoCallLogEntity;
import java.io.StringWriter;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: BreenoCallEntityXMLComposer.kt */
/* loaded from: classes.dex */
public final class BreenoCallEntityXMLComposer {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "BreenoCallEntityXMLComposer";
    public static final String XML_BREENO_CALL_TAG = "breeno_call";
    private static final String XML_ROOT_TAG = "breeno_calls";
    private final XmlSerializer serializer = Xml.newSerializer();
    private final StringWriter stringWriter = new StringWriter();

    /* compiled from: BreenoCallEntityXMLComposer.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public final void addOne(BreenoCallLogEntity callInfo) {
        Object b10;
        i.f(callInfo, "callInfo");
        try {
            Result.a aVar = Result.f34166a;
            this.serializer.startTag("", XML_BREENO_CALL_TAG);
            this.serializer.attribute("", BreenoCallContract.BaseColumns._ID, String.valueOf(callInfo.get_id()));
            this.serializer.attribute("", "number", callInfo.getNumber());
            if (!TextUtils.isEmpty(callInfo.getNormalized_number())) {
                this.serializer.attribute("", BreenoCallContract.BaseColumns.NORMALIZED_NUMBER, callInfo.getNormalized_number());
            }
            if (!TextUtils.isEmpty(callInfo.getNameInfoListJson())) {
                this.serializer.attribute("", BreenoCallContract.CallColumns.NAME_INFO, callInfo.getNameInfoListJson());
            }
            if (!TextUtils.isEmpty(callInfo.getPersonInfoJson())) {
                this.serializer.attribute("", BreenoCallContract.CallColumns.PERSONAL_INFO, callInfo.getPersonInfoJson());
            }
            if (!TextUtils.isEmpty(callInfo.getNoteInfoListJson())) {
                this.serializer.attribute("", BreenoCallContract.CallColumns.NOTE_INFO, callInfo.getNoteInfoListJson());
            }
            this.serializer.attribute("", BreenoCallContract.BaseColumns.DATE, String.valueOf(callInfo.getDate()));
            if (!TextUtils.isEmpty(callInfo.getExt1())) {
                this.serializer.attribute("", BreenoCallContract.BaseColumns.EXT_1, callInfo.getExt1());
            }
            if (!TextUtils.isEmpty(callInfo.getExt2())) {
                this.serializer.attribute("", BreenoCallContract.BaseColumns.EXT_2, callInfo.getExt2());
            }
            if (!TextUtils.isEmpty(callInfo.getExt3())) {
                this.serializer.attribute("", BreenoCallContract.BaseColumns.EXT_3, callInfo.getExt3());
            }
            if (!TextUtils.isEmpty(callInfo.getExt4())) {
                this.serializer.attribute("", BreenoCallContract.BaseColumns.EXT_4, callInfo.getExt4());
            }
            this.serializer.endTag("", XML_BREENO_CALL_TAG);
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.e(TAG, "Exception when addOne : " + d10);
        }
    }

    public final void endCompose() {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            this.serializer.endTag("", XML_ROOT_TAG);
            this.serializer.endDocument();
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.e(TAG, "Exception when endCompose : " + d10);
        }
    }

    public final String getXmlInfo() {
        String stringWriter = this.stringWriter.toString();
        i.e(stringWriter, "stringWriter.toString()");
        return stringWriter;
    }

    public final void startCompose() {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            this.serializer.setOutput(this.stringWriter);
            this.serializer.startDocument("UTF-8", Boolean.FALSE);
            this.serializer.startTag("", XML_ROOT_TAG);
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.e(TAG, "Exception when startCompose : " + d10);
        }
    }
}
