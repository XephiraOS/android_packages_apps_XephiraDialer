package t1;

import android.content.Context;
import android.telecom.PhoneAccountHandle;
import android.telephony.TelephonyManager;
import java.util.List;
import s1.o;

/* compiled from: VoicemailClientImpl.java */
/* loaded from: classes.dex */
public class h implements o {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f37149a = {"com.android.phone"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f37150b = {"vvm_type_omtp", "vvm_type_cvvm", "vvm_type_vvm3"};

    public h() {
        C1580a.a(true);
    }

    @Override // s1.o
    public boolean a() {
        return true;
    }

    @Override // s1.o
    public void b(Context context, StringBuilder sb, List<String> list) {
        String visualVoicemailPackageName = ((TelephonyManager) context.getSystemService(TelephonyManager.class)).getVisualVoicemailPackageName();
        if (sb.length() != 0) {
            sb.append(" AND ");
        }
        sb.append("(");
        sb.append("(");
        sb.append("source_package");
        sb.append(" = ? ");
        list.add(visualVoicemailPackageName);
        sb.append(")");
        sb.append(" OR NOT (");
        int i10 = 0;
        while (true) {
            String[] strArr = f37150b;
            if (i10 >= strArr.length) {
                break;
            }
            if (i10 != 0) {
                sb.append(" OR ");
            }
            sb.append(" (");
            sb.append("source_type");
            sb.append(" IS ?");
            list.add(strArr[i10]);
            sb.append(")");
            i10++;
        }
        sb.append(")");
        for (String str : f37149a) {
            sb.append("AND (");
            sb.append("source_package");
            sb.append("!= ?");
            list.add(str);
            sb.append(")");
        }
        sb.append(")");
    }

    @Override // s1.o
    public boolean c(Context context) {
        if (!s1.d.a(context).a("allow_voicemail_archive", false)) {
            C1.a.d("VoicemailClientImpl.isVoicemailArchiveAllowed", "feature disabled by config: allow_voicemail_archive");
            return false;
        }
        return true;
    }

    @Override // s1.o
    public boolean d(Context context, PhoneAccountHandle phoneAccountHandle) {
        return B1.b.e(context, phoneAccountHandle);
    }
}
