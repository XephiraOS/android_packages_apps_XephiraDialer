package i2;

import android.net.Uri;
import android.provider.MediaStore;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.ConfigurationConstants;

/* compiled from: OplusAudioRecordConstants.java */
/* renamed from: i2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1091a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f32142a;

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f32143b;

    /* renamed from: c, reason: collision with root package name */
    public static final Uri f32144c;

    /* renamed from: d, reason: collision with root package name */
    public static final Uri f32145d;

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f32146e;

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f32147f;

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f32148g;

    static {
        String blackListAuthority = ConfigurationConstants.getBlackListAuthority();
        f32142a = blackListAuthority;
        Uri parse = Uri.parse("content://" + blackListAuthority);
        f32143b = parse;
        f32144c = Uri.withAppendedPath(parse, "call_record_custom_list/number/");
        f32145d = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        f32146e = new String[]{BreenoCallContract.BaseColumns._ID, "_display_name", "date_added", "_size", "_data", "duration", "date_modified"};
        f32147f = new String[]{"audio/amr", "audio/amr-wb", "audio/mpeg"};
        f32148g = new String[]{"audio/amr", "audio/amr-wb", "audio/mpeg", "audio/aac-adts"};
    }
}
