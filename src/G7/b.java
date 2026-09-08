package G7;

/* compiled from: SQLUtils.java */
/* loaded from: classes3.dex */
public class b {
    public static String a(long[] jArr) {
        if (jArr != null && jArr.length != 0) {
            StringBuilder sb = new StringBuilder("(");
            for (long j10 : jArr) {
                sb.append(j10);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
            return sb.toString();
        }
        return "(-1)";
    }
}
