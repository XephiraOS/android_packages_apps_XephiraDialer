package z7;

import android.text.TextUtils;
import java.util.Locale;

/* compiled from: WordQuery.java */
/* loaded from: classes3.dex */
public class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static int f38361a = 12295;

    /* renamed from: b, reason: collision with root package name */
    public static int f38362b = 63865;

    /* renamed from: c, reason: collision with root package name */
    public static String f38363c = " ";

    /* renamed from: d, reason: collision with root package name */
    public static Object[] f38364d = {-1, null, null};

    /* renamed from: e, reason: collision with root package name */
    public static int[][] f38365e = {new int[]{12295, 20385}, new int[]{20386, 20801}, new int[]{20802, 21224}, new int[]{21225, 21642}, new int[]{21643, 22063}, new int[]{22064, 22480}, new int[]{22481, 22897}, new int[]{22898, 23313}, new int[]{23314, 23729}, new int[]{23730, 24146}, new int[]{24147, 24562}, new int[]{24563, 24979}, new int[]{24980, 25395}, new int[]{25396, 25811}, new int[]{25812, 26228}, new int[]{26229, 26649}, new int[]{26650, 27067}, new int[]{27068, 27483}, new int[]{27484, 27900}, new int[]{27901, 28316}, new int[]{28317, 28732}, new int[]{28733, 29149}, new int[]{29150, 29566}, new int[]{29567, 29989}, new int[]{29990, 30406}, new int[]{30407, 30823}, new int[]{30824, 31240}, new int[]{31241, 31657}, new int[]{31658, 32073}, new int[]{32074, 32490}, new int[]{32491, 32907}, new int[]{32908, 33324}, new int[]{33325, 33741}, new int[]{33742, 34158}, new int[]{34159, 34576}, new int[]{34577, 34993}, new int[]{34994, 35410}, new int[]{35411, 35826}, new int[]{35827, 36242}, new int[]{36243, 36658}, new int[]{36659, 37075}, new int[]{37076, 37491}, new int[]{37492, 37908}, new int[]{37909, 38325}, new int[]{38326, 38744}, new int[]{38745, 39160}, new int[]{39161, 39576}, new int[]{39577, 39992}, new int[]{39993, 40408}, new int[]{40409, 40824}, new int[]{40825, 63865}};

    public static char[] a(String str) {
        if (TextUtils.equals(str.toUpperCase(), Locale.TAIWAN.getCountry().toUpperCase())) {
            return a0.f38329a;
        }
        return null;
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i10 = 0;
        while (i10 < str.length()) {
            int i11 = i10 + 1;
            Object obj = f(str.substring(i10, i11))[2];
            if (obj == null) {
                break;
            }
            sb.append(obj);
            i10 = i11;
        }
        return sb.toString();
    }

    public static String c(String str) {
        Object[] f10;
        try {
            if (!TextUtils.isEmpty(str) && str.length() >= 1) {
                String substring = str.substring(0, 1);
                if (f38363c.equals(substring) || (f10 = f(substring)) == f38364d) {
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(f10[1]);
                return sb.toString();
            }
            return null;
        } catch (Exception e10) {
            H7.b.c("WordQuery", "Exception e: " + e10);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public static String d(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i10 = 0;
        while (i10 < str.length()) {
            int i11 = i10 + 1;
            String substring = str.substring(i10, i11);
            if (!f38363c.equals(substring)) {
                ?? r32 = f(substring)[1];
                if (r32 != 0) {
                    substring = r32;
                }
                sb.append((Object) substring);
            }
            i10 = i11;
        }
        return sb.toString();
    }

    public static Object[] e(int i10, Object[][] objArr) {
        int length = objArr.length - 1;
        int i11 = 0;
        while (i11 <= length) {
            int i12 = (i11 + length) >> 1;
            Object[] objArr2 = objArr[i12];
            int intValue = ((Integer) objArr2[0]).intValue();
            if (i10 == intValue) {
                return objArr2;
            }
            if (i10 < intValue) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return f38364d;
    }

    public static Object[] f(String str) {
        int g10 = g(str);
        if (g10 >= f38361a && g10 <= f38362b) {
            int i10 = 0;
            while (true) {
                int[][] iArr = f38365e;
                if (i10 < iArr.length) {
                    int[] iArr2 = iArr[i10];
                    if (g10 >= iArr2[0] && g10 <= iArr2[1]) {
                        break;
                    }
                    i10++;
                } else {
                    i10 = -1;
                    break;
                }
            }
            switch (i10) {
                case 0:
                    return e(g10, C1739a.f38328a);
                case 1:
                    return e(g10, C1750l.f38371a);
                case 2:
                    return e(g10, C1760w.f38382a);
                case 3:
                    return e(g10, H.f38310a);
                case 4:
                    return e(g10, T.f38321a);
                case 5:
                    return e(g10, V.f38323a);
                case 6:
                    return e(g10, W.f38324a);
                case 7:
                    return e(g10, X.f38325a);
                case 8:
                    return e(g10, Y.f38326a);
                case 9:
                    return e(g10, Z.f38327a);
                case 10:
                    return e(g10, C1740b.f38330a);
                case 11:
                    return e(g10, C1741c.f38339a);
                case 12:
                    return e(g10, C1742d.f38346a);
                case 13:
                    return e(g10, C1743e.f38357a);
                case 14:
                    return e(g10, C1744f.f38360a);
                case 15:
                    return e(g10, C1745g.f38366a);
                case 16:
                    return e(g10, C1746h.f38367a);
                case 17:
                    return e(g10, C1747i.f38368a);
                case 18:
                    return e(g10, C1748j.f38369a);
                case 19:
                    return e(g10, C1749k.f38370a);
                case 20:
                    return e(g10, C1751m.f38372a);
                case 21:
                    return e(g10, C1752n.f38373a);
                case 22:
                    return e(g10, C1753o.f38374a);
                case 23:
                    return e(g10, C1754p.f38375a);
                case 24:
                    return e(g10, C1755q.f38376a);
                case 25:
                    return e(g10, r.f38377a);
                case 26:
                    return e(g10, C1756s.f38378a);
                case 27:
                    return e(g10, C1757t.f38379a);
                case 28:
                    return e(g10, C1758u.f38380a);
                case 29:
                    return e(g10, C1759v.f38381a);
                case 30:
                    return e(g10, C1761x.f38383a);
                case 31:
                    return e(g10, C1762y.f38384a);
                case 32:
                    return e(g10, C1763z.f38385a);
                case 33:
                    return e(g10, C1736A.f38303a);
                case 34:
                    return e(g10, C1737B.f38304a);
                case 35:
                    return e(g10, C1738C.f38305a);
                case 36:
                    return e(g10, D.f38306a);
                case 37:
                    return e(g10, E.f38307a);
                case 38:
                    return e(g10, F.f38308a);
                case 39:
                    return e(g10, G.f38309a);
                case 40:
                    return e(g10, I.f38311a);
                case 41:
                    return e(g10, J.f38312a);
                case 42:
                    return e(g10, K.f38313a);
                case 43:
                    return e(g10, L.f38314a);
                case 44:
                    return e(g10, M.f38315a);
                case 45:
                    return e(g10, N.f38316a);
                case 46:
                    return e(g10, O.f38317a);
                case 47:
                    return e(g10, P.f38318a);
                case 48:
                    return e(g10, Q.f38319a);
                case 49:
                    return e(g10, S.f38320a);
                case 50:
                    return e(g10, U.f38322a);
                default:
                    return f38364d;
            }
        }
        return f38364d;
    }

    public static int g(String str) {
        return str.charAt(0);
    }
}
