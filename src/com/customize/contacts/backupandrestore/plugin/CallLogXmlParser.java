package com.customize.contacts.backupandrestore.plugin;

import H7.b;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusAutoRedialNotificationUI;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes3.dex */
public class CallLogXmlParser {
    private static final String TAG = "CallLogXmlParser";

    public static ArrayList<CallLogInfor> parse(String str) {
        byte b10;
        byte b11;
        ArrayList<CallLogInfor> arrayList = new ArrayList<>();
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(new StringReader(str));
            CallLogInfor callLogInfor = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType != 2) {
                    if (eventType != 3) {
                        continue;
                    } else if (newPullParser.getName().equals("CALL_RECORDS") && callLogInfor != null) {
                        String number = callLogInfor.getNumber();
                        if (number != null) {
                            number = number.trim();
                        }
                        if (!TextUtils.isEmpty(number)) {
                            arrayList.add(callLogInfor);
                        } else {
                            b.i(TAG, "Empty number, skip this call record, date: " + callLogInfor.getDate());
                        }
                    }
                } else {
                    CallLogInfor callLogInfor2 = new CallLogInfor();
                    if (newPullParser.getName().equals("CALL_RECORDS")) {
                        int attributeCount = newPullParser.getAttributeCount();
                        for (int i10 = 0; i10 < attributeCount; i10++) {
                            String attributeName = newPullParser.getAttributeName(i10);
                            String attributeValue = newPullParser.getAttributeValue(i10);
                            if (attributeName.equals(BreenoCallContract.BaseColumns._ID)) {
                                callLogInfor2.setId(Long.parseLong(attributeValue));
                            } else if (attributeName.equals("number")) {
                                callLogInfor2.setNumber(attributeValue);
                            } else if (attributeName.equals("duration")) {
                                callLogInfor2.setDuration(Integer.parseInt(attributeValue));
                            } else if (attributeName.equals(OplusAutoRedialNotificationUI.TYPE)) {
                                try {
                                    b10 = Byte.parseByte(attributeValue);
                                } catch (NumberFormatException e10) {
                                    b.c(TAG, "call type exception = " + e10);
                                    b10 = (byte) 1;
                                }
                                callLogInfor2.setType(b10);
                            } else if (attributeName.equals(BreenoCallContract.BaseColumns.DATE)) {
                                long currentTimeMillis = System.currentTimeMillis();
                                try {
                                    currentTimeMillis = Long.parseLong(attributeValue);
                                } catch (NumberFormatException e11) {
                                    b.c(TAG, "date exception = " + e11);
                                }
                                callLogInfor2.setDate(currentTimeMillis);
                            } else if (attributeName.equals("name")) {
                                callLogInfor2.setName(attributeValue);
                            } else if (attributeName.equals("numbertype")) {
                                try {
                                    b11 = Byte.parseByte(attributeValue);
                                } catch (NumberFormatException e12) {
                                    b.c(TAG, "NumberType exception = " + e12);
                                    b11 = -1;
                                }
                                callLogInfor2.setNumbertype(b11);
                            } else if (attributeName.equals("numberlabel")) {
                                callLogInfor2.setNumberlabel(attributeValue);
                            } else if (attributeName.equals("ring_time")) {
                                callLogInfor2.setRingTime(Integer.parseInt(attributeValue));
                            } else if (attributeName.equals("countryiso")) {
                                callLogInfor2.setCountryIso(attributeValue);
                            } else if (attributeName.equals("classify")) {
                                callLogInfor2.setTedMarkType(attributeValue);
                            } else if (attributeName.equals("is_manual")) {
                                callLogInfor2.setTedIsManual(attributeValue);
                            } else if (attributeName.equals("data_type")) {
                                callLogInfor2.setTedDataType(attributeValue);
                            } else if (attributeName.equals("operation_type")) {
                                callLogInfor2.setTedOperationType(attributeValue);
                            } else if (attributeName.equals("uploaded")) {
                                callLogInfor2.setTedUploaded(attributeValue);
                            } else if (attributeName.equals("ted_query_number")) {
                                callLogInfor2.setmTedQueryNumber(attributeValue);
                            } else if (attributeName.equals("new")) {
                                callLogInfor2.setIsNew(Byte.parseByte(attributeValue));
                            } else if (attributeName.equals("features")) {
                                callLogInfor2.setFeatures(Integer.parseInt(attributeValue));
                            } else if (attributeName.equals("virtual_call_id")) {
                                callLogInfor2.setVirtualCallId(attributeValue);
                            } else if (attributeName.equals("virtual_call_type")) {
                                callLogInfor2.setVirtualCallType(Integer.parseInt(attributeValue));
                            }
                        }
                    }
                    callLogInfor = callLogInfor2;
                }
            }
        } catch (IOException | NumberFormatException | XmlPullParserException e13) {
            b.c(TAG, "Exception e: " + e13);
        }
        return arrayList;
    }
}
