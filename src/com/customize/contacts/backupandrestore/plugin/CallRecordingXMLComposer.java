package com.customize.contacts.backupandrestore.plugin;

import Q0.c;
import android.util.Log;
import android.util.Xml;
import com.oplus.backup.sdk.common.utils.Constants;
import java.io.StringWriter;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: CallRecordingXMLComposer.kt */
/* loaded from: classes3.dex */
public final class CallRecordingXMLComposer {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "CallRecordingXMLComposer";
    private final XmlSerializer mSerializer = Xml.newSerializer();
    private final StringWriter mStringWriter = new StringWriter();

    /* compiled from: CallRecordingXMLComposer.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public final void addOneCallRecording(c callRecordingInfo) {
        Object b10;
        i.f(callRecordingInfo, "callRecordingInfo");
        try {
            Result.a aVar = Result.f34166a;
            this.mSerializer.startTag("", "call_recording");
            if (callRecordingInfo.h() != null) {
                this.mSerializer.attribute("", "number", callRecordingInfo.h());
            }
            XmlSerializer xmlSerializer = this.mSerializer;
            long b11 = callRecordingInfo.b();
            StringBuilder sb = new StringBuilder();
            sb.append(b11);
            xmlSerializer.attribute("", "call_log_mapping", sb.toString());
            if (callRecordingInfo.i() != null) {
                this.mSerializer.attribute("", Constants.MessagerConstants.PATH_KEY, callRecordingInfo.i());
            }
            XmlSerializer xmlSerializer2 = this.mSerializer;
            int j10 = callRecordingInfo.j();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(j10);
            xmlSerializer2.attribute("", "sec_record", sb2.toString());
            if (callRecordingInfo.c() != null) {
                this.mSerializer.attribute("", "data1", callRecordingInfo.c());
            }
            if (callRecordingInfo.d() != null) {
                this.mSerializer.attribute("", "data2", callRecordingInfo.d());
            }
            XmlSerializer xmlSerializer3 = this.mSerializer;
            long e10 = callRecordingInfo.e();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(e10);
            xmlSerializer3.attribute("", "data3", sb3.toString());
            XmlSerializer xmlSerializer4 = this.mSerializer;
            long f10 = callRecordingInfo.f();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(f10);
            xmlSerializer4.attribute("", "data4", sb4.toString());
            this.mSerializer.endTag("", "call_recording");
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.e(TAG, "Exception when addOneCallRecording : " + d10);
        }
    }

    public final void endCompose() {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            this.mSerializer.endTag("", TAG);
            this.mSerializer.endDocument();
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
        String stringWriter = this.mStringWriter.toString();
        i.e(stringWriter, "mStringWriter.toString()");
        return stringWriter;
    }

    public final void startCompose() {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            this.mSerializer.setOutput(this.mStringWriter);
            this.mSerializer.startDocument("UTF-8", Boolean.FALSE);
            this.mSerializer.startTag("", TAG);
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
