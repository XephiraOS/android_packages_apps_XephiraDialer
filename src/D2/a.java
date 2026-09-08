package D2;

/* compiled from: AudioMode.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f420a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static int f421b = 2;

    /* renamed from: c, reason: collision with root package name */
    public static int f422c = 4;

    /* renamed from: d, reason: collision with root package name */
    public static int f423d = 8;

    /* renamed from: e, reason: collision with root package name */
    public static int f424e = 64;

    /* renamed from: f, reason: collision with root package name */
    public static int f425f = (1 | 2) | 76;

    public static void a(StringBuffer stringBuffer, String str) {
        if (stringBuffer.length() > 0) {
            stringBuffer.append(", ");
        }
        stringBuffer.append(str);
    }

    public static String b(int i10) {
        if (((~f425f) & i10) != 0) {
            return "UNKNOWN";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i11 = f420a;
        if ((i10 & i11) == i11) {
            a(stringBuffer, "EARPIECE");
        }
        int i12 = f421b;
        if ((i10 & i12) == i12) {
            a(stringBuffer, "BLUETOOTH");
        }
        int i13 = f422c;
        if ((i10 & i13) == i13) {
            a(stringBuffer, "WIRED_HEADSET");
        }
        int i14 = f423d;
        if ((i10 & i14) == i14) {
            a(stringBuffer, "SPEAKER");
        }
        int i15 = f424e;
        if ((i10 & i15) == i15) {
            a(stringBuffer, "CAR");
        }
        return stringBuffer.toString();
    }
}
