package s1;

import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: VoicemailStatusQuery.java */
/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f36670a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f36671b;

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f36672c;

    static {
        String[] strArr = {"source_package", "settings_uri", "voicemail_access_uri", "configuration_state", "data_channel_state", "notification_channel_state"};
        f36670a = strArr;
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        arrayList.add("quota_occupied");
        arrayList.add("quota_total");
        f36671b = (String[]) arrayList.toArray(new String[arrayList.size()]);
        arrayList.add("phone_account_component_name");
        arrayList.add("phone_account_id");
        arrayList.add("source_type");
        f36672c = (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] a() {
        return f36672c;
    }
}
