package com.android.contacts.framework.baseui.calllog;

import android.net.Uri;
import android.os.Environment;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.oplus.backup.sdk.common.utils.Constants;
import java.io.File;

/* compiled from: CallLogContract.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f15766a = Uri.parse("content://com.oplus.contacts.CallRecordingProvider/call_recording");

    /* renamed from: b, reason: collision with root package name */
    public static final String f15767b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f15768c;

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f15769d;

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f15770e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.DIRECTORY_MUSIC);
        String str = File.separator;
        sb.append(str);
        sb.append("Recordings");
        sb.append(str);
        sb.append("Call Recordings");
        String sb2 = sb.toString();
        f15767b = sb2;
        f15768c = "/storage/emulated/0/" + sb2 + str;
        f15769d = new String[]{BreenoCallContract.BaseColumns._ID, "number", "call_log_mapping"};
        f15770e = new String[]{BreenoCallContract.BaseColumns._ID, "number", "call_log_mapping", Constants.MessagerConstants.PATH_KEY, "sec_record", "data1", "data2", "data3", "data4"};
    }
}
