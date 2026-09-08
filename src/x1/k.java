package x1;

/* compiled from: ImapUtility.java */
/* loaded from: classes.dex */
public class k {
    public static String a(String str) {
        return "\"" + str.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\"") + "\"";
    }
}
