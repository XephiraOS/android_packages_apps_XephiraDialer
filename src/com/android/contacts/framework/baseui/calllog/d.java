package com.android.contacts.framework.baseui.calllog;

import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.oplus.foundation.util.feature.CommonOSPublicFeature;
import com.oplus.foundation.util.feature.VirtualSupportUtils;

/* compiled from: CallLogQuery.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f15785a = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE, "duration", OplusAutoRedialNotificationUI.TYPE, "voicemail_uri", "geocoded_location", "name", "lookup_uri", BreenoCallContract.BaseColumns.NORMALIZED_NUMBER, "photo_id", "formatted_number", "simid", "ring_time", "transcription", "features", "countryiso", "hasRecog", "cnip_name"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f15786b = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE, "duration", OplusAutoRedialNotificationUI.TYPE, "voicemail_uri", "geocoded_location", "name", "lookup_uri", BreenoCallContract.BaseColumns.NORMALIZED_NUMBER, "photo_id", "formatted_number", "simid", "ring_time", "transcription", "features", "countryiso", "hasRecog", "cnip_name", "virtual_call_id"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f15787c = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE, "duration", OplusAutoRedialNotificationUI.TYPE, "voicemail_uri", "geocoded_location", "name", "lookup_uri", BreenoCallContract.BaseColumns.NORMALIZED_NUMBER, "photo_id", "formatted_number", "simid", "ring_time", "transcription", "features", "countryiso", "hasRecog", "cnip_name", "virtual_call_id", "identify_name", "oplus_data1"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f15788d = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE, "duration", OplusAutoRedialNotificationUI.TYPE, "voicemail_uri", "geocoded_location", "name", "lookup_uri", BreenoCallContract.BaseColumns.NORMALIZED_NUMBER, "photo_id", "formatted_number", "simid", "ring_time", "transcription", "features", "countryiso", "hasRecog", "cnip_name", "roam_call_type"};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f15789e = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE, "duration", OplusAutoRedialNotificationUI.TYPE, "voicemail_uri", "geocoded_location", "name", "lookup_uri", BreenoCallContract.BaseColumns.NORMALIZED_NUMBER, "photo_id", "formatted_number", "simid", "ring_time", "transcription", "features", "countryiso", "hasRecog", "cnip_name", "roam_call_type", "virtual_call_id"};

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f15790f = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE, "duration", OplusAutoRedialNotificationUI.TYPE, "voicemail_uri", "geocoded_location", "name", "lookup_uri", BreenoCallContract.BaseColumns.NORMALIZED_NUMBER, "photo_id", "formatted_number", "simid", "ring_time", "transcription", "features", "countryiso", "hasRecog", "cnip_name", "roam_call_type", "virtual_call_id", "identify_name", "oplus_data1"};

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f15791g = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE, "duration", OplusAutoRedialNotificationUI.TYPE, "voicemail_uri", "geocoded_location", "name", "lookup_uri", BreenoCallContract.BaseColumns.NORMALIZED_NUMBER, "photo_id", "formatted_number", "simid", "ring_time", "transcription", "features", "countryiso", "unread_count"};

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f15792h;

    static {
        String[] strArr = new String[a().length + 1];
        f15792h = strArr;
        System.arraycopy(a(), 0, strArr, 0, a().length);
        strArr[a().length] = "section";
    }

    public static String[] a() {
        if (CommonOSPublicFeature.h()) {
            if (CommonOSPublicFeature.e()) {
                return f15790f;
            }
            if (VirtualSupportUtils.p()) {
                return f15789e;
            }
            return f15788d;
        }
        if (CommonOSPublicFeature.e()) {
            return f15787c;
        }
        if (VirtualSupportUtils.p()) {
            return f15786b;
        }
        return f15785a;
    }
}
