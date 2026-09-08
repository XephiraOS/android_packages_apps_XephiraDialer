package z1;

import android.content.res.Resources;

/* compiled from: VisualVoicemailProtocolFactory.java */
/* loaded from: classes.dex */
public class e {
    public static AbstractC1729d a(Resources resources, String str) {
        if (str == null) {
            return null;
        }
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1479165891:
                if (str.equals("vvm_type_cvvm")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1478817107:
                if (str.equals("vvm_type_omtp")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1478600199:
                if (str.equals("vvm_type_vvm3")) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return new C1726a();
            case 1:
                return new C1727b();
            case 2:
                return new g();
            default:
                H7.b.c("VvmProtocolFactory", "Unexpected visual voicemail type: " + str);
                return null;
        }
    }
}
