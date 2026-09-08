package com.customize.contacts.backupandrestore.plugin;

import H7.b;
import android.text.TextUtils;
import android.util.Xml;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusAutoRedialNotificationUI;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes3.dex */
public class CallLogXMLComposer {
    private static final String TAG = "CallLogXMLComposer";
    private XmlSerializer mSerializer = null;
    private StringWriter mStringWriter = null;

    public boolean addOneCallLog(CallLogInfor callLogInfor) {
        try {
            this.mSerializer.startTag("", "CALL_RECORDS");
            this.mSerializer.attribute("", BreenoCallContract.BaseColumns._ID, Long.toString(callLogInfor.getId()));
            this.mSerializer.attribute("", "number", callLogInfor.getNumber());
            this.mSerializer.attribute("", "duration", Integer.toString(callLogInfor.getDuration()));
            this.mSerializer.attribute("", OplusAutoRedialNotificationUI.TYPE, Byte.toString(callLogInfor.getType()));
            this.mSerializer.attribute("", BreenoCallContract.BaseColumns.DATE, Long.toString(callLogInfor.getDate()));
            this.mSerializer.attribute("", "name", callLogInfor.getName());
            this.mSerializer.attribute("", "numbertype", Byte.toString(callLogInfor.getNumbertype()));
            this.mSerializer.attribute("", "numberlabel", callLogInfor.getNumberlabel());
            this.mSerializer.attribute("", "ring_time", Integer.toString(callLogInfor.getRingTime()));
            this.mSerializer.attribute("", "new", Byte.toString(callLogInfor.getIsNew()));
            this.mSerializer.attribute("", "features", Integer.toString(callLogInfor.getFeatures()));
            if (!TextUtils.isEmpty(callLogInfor.getVirtualCallId())) {
                this.mSerializer.attribute("", "virtual_call_id", callLogInfor.getVirtualCallId());
            }
            this.mSerializer.attribute("", "virtual_call_type", Integer.toString(callLogInfor.getVirtualCallType()));
            if (!TextUtils.isEmpty(callLogInfor.getCountryIso())) {
                this.mSerializer.attribute("", "countryiso", callLogInfor.getCountryIso());
            }
            if (callLogInfor.getTedMarkType() != null) {
                this.mSerializer.attribute("", "classify", callLogInfor.getTedMarkType());
            }
            if (callLogInfor.getTedIsManual() != null) {
                this.mSerializer.attribute("", "is_manual", callLogInfor.getTedIsManual());
            }
            if (callLogInfor.getTedDataType() != null) {
                this.mSerializer.attribute("", "data_type", callLogInfor.getTedDataType());
            }
            if (callLogInfor.getTedOperationType() != null) {
                this.mSerializer.attribute("", "operation_type", callLogInfor.getTedOperationType());
            }
            if (callLogInfor.getTedUploaded() != null) {
                this.mSerializer.attribute("", "uploaded", callLogInfor.getTedUploaded());
            }
            if (callLogInfor.getmTedQueryNumber() != null) {
                this.mSerializer.attribute("", "ted_query_number", callLogInfor.getmTedQueryNumber());
            }
            this.mSerializer.endTag("", "CALL_RECORDS");
            return true;
        } catch (IOException e10) {
            b.c(TAG, "Exception e: " + e10);
            return false;
        } catch (IllegalArgumentException e11) {
            b.c(TAG, "Exception e: " + e11);
            return false;
        } catch (IllegalStateException e12) {
            b.c(TAG, "Exception e: " + e12);
            return false;
        } catch (Exception e13) {
            b.c(TAG, "Exception e: " + e13);
            return false;
        }
    }

    public boolean endCompose() {
        try {
            this.mSerializer.endTag("", "CallLog");
            this.mSerializer.endDocument();
            return true;
        } catch (IOException e10) {
            b.c(TAG, "Exception e: " + e10);
            return false;
        } catch (IllegalArgumentException e11) {
            b.c(TAG, "Exception e: " + e11);
            return false;
        } catch (IllegalStateException e12) {
            b.c(TAG, "Exception e: " + e12);
            return false;
        }
    }

    public String getXmlInfo() {
        StringWriter stringWriter = this.mStringWriter;
        if (stringWriter != null) {
            return stringWriter.toString();
        }
        return null;
    }

    public boolean startCompose() {
        this.mSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        this.mStringWriter = stringWriter;
        try {
            this.mSerializer.setOutput(stringWriter);
            this.mSerializer.startDocument(null, Boolean.FALSE);
            this.mSerializer.startTag("", "CallLog");
            return true;
        } catch (IOException e10) {
            b.c(TAG, "Exception e: " + e10);
            return false;
        } catch (IllegalArgumentException e11) {
            b.c(TAG, "Exception e: " + e11);
            return false;
        } catch (IllegalStateException e12) {
            b.c(TAG, "Exception e: " + e12);
            return false;
        }
    }
}
