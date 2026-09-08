package s1;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: VoicemailPermissionHelper.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f36666a = {"com.android.voicemail.permission.ADD_VOICEMAIL", "com.android.voicemail.permission.WRITE_VOICEMAIL", "com.android.voicemail.permission.READ_VOICEMAIL", "android.permission.READ_PHONE_STATE", "android.permission.SEND_SMS"};

    public static List<String> a(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : f36666a) {
            if (context.checkSelfPermission(str) != 0) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static boolean b(Context context) {
        return a(context).isEmpty();
    }
}
