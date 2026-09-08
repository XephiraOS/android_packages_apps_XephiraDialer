package com.google.i18n.phonenumbers;

import O4.h;
import O4.i;
import com.android.incallui.OplusPhoneUtils;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberMatcher;
import com.google.i18n.phonenumbers.Phonenumber$PhoneNumber;
import com.google.i18n.phonenumbers.internal.RegexCache;
import com.google.i18n.phonenumbers.internal.c;
import com.heytap.accessory.constant.FastPairConstants;
import com.oplus.backup.sdk.common.utils.ModuleType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class PhoneNumberUtil {

    /* renamed from: A, reason: collision with root package name */
    public static final String f24857A;

    /* renamed from: B, reason: collision with root package name */
    public static final Pattern f24858B;

    /* renamed from: C, reason: collision with root package name */
    public static final String f24859C;

    /* renamed from: D, reason: collision with root package name */
    public static final String f24860D;

    /* renamed from: E, reason: collision with root package name */
    public static final String f24861E;

    /* renamed from: F, reason: collision with root package name */
    public static final String f24862F;

    /* renamed from: G, reason: collision with root package name */
    public static final Pattern f24863G;

    /* renamed from: H, reason: collision with root package name */
    public static final Pattern f24864H;

    /* renamed from: I, reason: collision with root package name */
    public static final Pattern f24865I;

    /* renamed from: J, reason: collision with root package name */
    public static final Pattern f24866J;

    /* renamed from: K, reason: collision with root package name */
    public static final Pattern f24867K;

    /* renamed from: L, reason: collision with root package name */
    public static final Pattern f24868L;

    /* renamed from: M, reason: collision with root package name */
    public static PhoneNumberUtil f24869M;

    /* renamed from: h, reason: collision with root package name */
    public static final Logger f24870h = Logger.getLogger(PhoneNumberUtil.class.getName());

    /* renamed from: i, reason: collision with root package name */
    public static final Map<Integer, String> f24871i;

    /* renamed from: j, reason: collision with root package name */
    public static final Set<Integer> f24872j;

    /* renamed from: k, reason: collision with root package name */
    public static final Set<Integer> f24873k;

    /* renamed from: l, reason: collision with root package name */
    public static final Map<Character, Character> f24874l;

    /* renamed from: m, reason: collision with root package name */
    public static final Map<Character, Character> f24875m;

    /* renamed from: n, reason: collision with root package name */
    public static final Map<Character, Character> f24876n;

    /* renamed from: o, reason: collision with root package name */
    public static final Map<Character, Character> f24877o;

    /* renamed from: p, reason: collision with root package name */
    public static final Pattern f24878p;

    /* renamed from: q, reason: collision with root package name */
    public static final String f24879q;

    /* renamed from: r, reason: collision with root package name */
    public static final Pattern f24880r;

    /* renamed from: s, reason: collision with root package name */
    public static final Pattern f24881s;

    /* renamed from: t, reason: collision with root package name */
    public static final Pattern f24882t;

    /* renamed from: u, reason: collision with root package name */
    public static final Pattern f24883u;

    /* renamed from: v, reason: collision with root package name */
    public static final Pattern f24884v;

    /* renamed from: w, reason: collision with root package name */
    public static final Pattern f24885w;

    /* renamed from: x, reason: collision with root package name */
    public static final Pattern f24886x;

    /* renamed from: y, reason: collision with root package name */
    public static final String f24887y;

    /* renamed from: z, reason: collision with root package name */
    public static final String f24888z;

    /* renamed from: a, reason: collision with root package name */
    public final h f24889a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Integer, List<String>> f24890b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.i18n.phonenumbers.internal.b f24891c = c.b();

    /* renamed from: d, reason: collision with root package name */
    public final Set<String> f24892d = new HashSet(35);

    /* renamed from: e, reason: collision with root package name */
    public final RegexCache f24893e = new RegexCache(100);

    /* renamed from: f, reason: collision with root package name */
    public final Set<String> f24894f = new HashSet(ModuleType.TYPE_WEATHER);

    /* renamed from: g, reason: collision with root package name */
    public final Set<Integer> f24895g = new HashSet();

    /* loaded from: classes3.dex */
    public enum Leniency {
        POSSIBLE { // from class: com.google.i18n.phonenumbers.PhoneNumberUtil.Leniency.1
            @Override // com.google.i18n.phonenumbers.PhoneNumberUtil.Leniency
            public boolean b(Phonenumber$PhoneNumber phonenumber$PhoneNumber, CharSequence charSequence, PhoneNumberUtil phoneNumberUtil, PhoneNumberMatcher phoneNumberMatcher) {
                return phoneNumberUtil.Y(phonenumber$PhoneNumber);
            }
        },
        VALID { // from class: com.google.i18n.phonenumbers.PhoneNumberUtil.Leniency.2
            @Override // com.google.i18n.phonenumbers.PhoneNumberUtil.Leniency
            public boolean b(Phonenumber$PhoneNumber phonenumber$PhoneNumber, CharSequence charSequence, PhoneNumberUtil phoneNumberUtil, PhoneNumberMatcher phoneNumberMatcher) {
                if (phoneNumberUtil.b0(phonenumber$PhoneNumber) && PhoneNumberMatcher.e(phonenumber$PhoneNumber, charSequence.toString(), phoneNumberUtil)) {
                    return PhoneNumberMatcher.m(phonenumber$PhoneNumber, phoneNumberUtil);
                }
                return false;
            }
        },
        STRICT_GROUPING { // from class: com.google.i18n.phonenumbers.PhoneNumberUtil.Leniency.3

            /* renamed from: com.google.i18n.phonenumbers.PhoneNumberUtil$Leniency$3$a */
            /* loaded from: classes3.dex */
            public class a implements PhoneNumberMatcher.a {
                public a() {
                }

                @Override // com.google.i18n.phonenumbers.PhoneNumberMatcher.a
                public boolean a(PhoneNumberUtil phoneNumberUtil, Phonenumber$PhoneNumber phonenumber$PhoneNumber, StringBuilder sb, String[] strArr) {
                    return PhoneNumberMatcher.b(phoneNumberUtil, phonenumber$PhoneNumber, sb, strArr);
                }
            }

            @Override // com.google.i18n.phonenumbers.PhoneNumberUtil.Leniency
            public boolean b(Phonenumber$PhoneNumber phonenumber$PhoneNumber, CharSequence charSequence, PhoneNumberUtil phoneNumberUtil, PhoneNumberMatcher phoneNumberMatcher) {
                String charSequence2 = charSequence.toString();
                if (phoneNumberUtil.b0(phonenumber$PhoneNumber) && PhoneNumberMatcher.e(phonenumber$PhoneNumber, charSequence2, phoneNumberUtil) && !PhoneNumberMatcher.d(phonenumber$PhoneNumber, charSequence2) && PhoneNumberMatcher.m(phonenumber$PhoneNumber, phoneNumberUtil)) {
                    return phoneNumberMatcher.c(phonenumber$PhoneNumber, charSequence, phoneNumberUtil, new a());
                }
                return false;
            }
        },
        EXACT_GROUPING { // from class: com.google.i18n.phonenumbers.PhoneNumberUtil.Leniency.4

            /* renamed from: com.google.i18n.phonenumbers.PhoneNumberUtil$Leniency$4$a */
            /* loaded from: classes3.dex */
            public class a implements PhoneNumberMatcher.a {
                public a() {
                }

                @Override // com.google.i18n.phonenumbers.PhoneNumberMatcher.a
                public boolean a(PhoneNumberUtil phoneNumberUtil, Phonenumber$PhoneNumber phonenumber$PhoneNumber, StringBuilder sb, String[] strArr) {
                    return PhoneNumberMatcher.a(phoneNumberUtil, phonenumber$PhoneNumber, sb, strArr);
                }
            }

            @Override // com.google.i18n.phonenumbers.PhoneNumberUtil.Leniency
            public boolean b(Phonenumber$PhoneNumber phonenumber$PhoneNumber, CharSequence charSequence, PhoneNumberUtil phoneNumberUtil, PhoneNumberMatcher phoneNumberMatcher) {
                String charSequence2 = charSequence.toString();
                if (phoneNumberUtil.b0(phonenumber$PhoneNumber) && PhoneNumberMatcher.e(phonenumber$PhoneNumber, charSequence2, phoneNumberUtil) && !PhoneNumberMatcher.d(phonenumber$PhoneNumber, charSequence2) && PhoneNumberMatcher.m(phonenumber$PhoneNumber, phoneNumberUtil)) {
                    return phoneNumberMatcher.c(phonenumber$PhoneNumber, charSequence, phoneNumberUtil, new a());
                }
                return false;
            }
        };

        public abstract boolean b(Phonenumber$PhoneNumber phonenumber$PhoneNumber, CharSequence charSequence, PhoneNumberUtil phoneNumberUtil, PhoneNumberMatcher phoneNumberMatcher);

        /* synthetic */ Leniency(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public enum MatchType {
        NOT_A_NUMBER,
        NO_MATCH,
        SHORT_NSN_MATCH,
        NSN_MATCH,
        EXACT_MATCH
    }

    /* loaded from: classes3.dex */
    public enum PhoneNumberFormat {
        E164,
        INTERNATIONAL,
        NATIONAL,
        RFC3966
    }

    /* loaded from: classes3.dex */
    public enum PhoneNumberType {
        FIXED_LINE,
        MOBILE,
        FIXED_LINE_OR_MOBILE,
        TOLL_FREE,
        PREMIUM_RATE,
        SHARED_COST,
        VOIP,
        PERSONAL_NUMBER,
        PAGER,
        UAN,
        VOICEMAIL,
        UNKNOWN
    }

    /* loaded from: classes3.dex */
    public enum ValidationResult {
        IS_POSSIBLE,
        IS_POSSIBLE_LOCAL_ONLY,
        INVALID_COUNTRY_CODE,
        TOO_SHORT,
        INVALID_LENGTH,
        TOO_LONG
    }

    /* loaded from: classes3.dex */
    public class a implements Iterable<L4.c> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f24934a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f24935b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Leniency f24936c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f24937d;

        public a(CharSequence charSequence, String str, Leniency leniency, long j10) {
            this.f24934a = charSequence;
            this.f24935b = str;
            this.f24936c = leniency;
            this.f24937d = j10;
        }

        @Override // java.lang.Iterable
        public Iterator<L4.c> iterator() {
            return new PhoneNumberMatcher(PhoneNumberUtil.this, this.f24934a, this.f24935b, this.f24936c, this.f24937d);
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24939a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f24940b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f24941c;

        static {
            int[] iArr = new int[PhoneNumberType.values().length];
            f24941c = iArr;
            try {
                iArr[PhoneNumberType.PREMIUM_RATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24941c[PhoneNumberType.TOLL_FREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24941c[PhoneNumberType.MOBILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f24941c[PhoneNumberType.FIXED_LINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f24941c[PhoneNumberType.FIXED_LINE_OR_MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f24941c[PhoneNumberType.SHARED_COST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f24941c[PhoneNumberType.VOIP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f24941c[PhoneNumberType.PERSONAL_NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f24941c[PhoneNumberType.PAGER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f24941c[PhoneNumberType.UAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f24941c[PhoneNumberType.VOICEMAIL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr2 = new int[PhoneNumberFormat.values().length];
            f24940b = iArr2;
            try {
                iArr2[PhoneNumberFormat.E164.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f24940b[PhoneNumberFormat.INTERNATIONAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f24940b[PhoneNumberFormat.RFC3966.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f24940b[PhoneNumberFormat.NATIONAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr3 = new int[Phonenumber$PhoneNumber.CountryCodeSource.values().length];
            f24939a = iArr3;
            try {
                iArr3[Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f24939a[Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f24939a[Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f24939a[Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(54, "9");
        f24871i = Collections.unmodifiableMap(hashMap);
        HashSet hashSet = new HashSet();
        hashSet.add(86);
        f24872j = Collections.unmodifiableSet(hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add(52);
        hashSet2.add(54);
        hashSet2.add(55);
        hashSet2.add(62);
        hashSet2.addAll(hashSet);
        f24873k = Collections.unmodifiableSet(hashSet2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put('0', '0');
        hashMap2.put('1', '1');
        hashMap2.put('2', '2');
        hashMap2.put('3', '3');
        hashMap2.put('4', '4');
        hashMap2.put('5', '5');
        hashMap2.put('6', '6');
        hashMap2.put('7', '7');
        hashMap2.put('8', '8');
        hashMap2.put('9', '9');
        HashMap hashMap3 = new HashMap(40);
        hashMap3.put('A', '2');
        hashMap3.put('B', '2');
        hashMap3.put('C', '2');
        hashMap3.put('D', '3');
        hashMap3.put('E', '3');
        hashMap3.put('F', '3');
        hashMap3.put('G', '4');
        hashMap3.put('H', '4');
        hashMap3.put('I', '4');
        hashMap3.put('J', '5');
        hashMap3.put('K', '5');
        hashMap3.put('L', '5');
        hashMap3.put('M', '6');
        hashMap3.put('N', '6');
        hashMap3.put('O', '6');
        hashMap3.put('P', '7');
        hashMap3.put('Q', '7');
        hashMap3.put('R', '7');
        hashMap3.put('S', '7');
        hashMap3.put('T', '8');
        hashMap3.put('U', '8');
        hashMap3.put('V', '8');
        hashMap3.put('W', '9');
        hashMap3.put('X', '9');
        hashMap3.put('Y', '9');
        hashMap3.put('Z', '9');
        Map<Character, Character> unmodifiableMap = Collections.unmodifiableMap(hashMap3);
        f24875m = unmodifiableMap;
        HashMap hashMap4 = new HashMap(100);
        hashMap4.putAll(unmodifiableMap);
        hashMap4.putAll(hashMap2);
        f24876n = Collections.unmodifiableMap(hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.putAll(hashMap2);
        hashMap5.put('+', '+');
        hashMap5.put('*', '*');
        hashMap5.put('#', '#');
        f24874l = Collections.unmodifiableMap(hashMap5);
        HashMap hashMap6 = new HashMap();
        for (Character ch : unmodifiableMap.keySet()) {
            hashMap6.put(Character.valueOf(Character.toLowerCase(ch.charValue())), ch);
            hashMap6.put(ch, ch);
        }
        hashMap6.putAll(hashMap2);
        hashMap6.put('-', '-');
        hashMap6.put((char) 65293, '-');
        hashMap6.put((char) 8208, '-');
        hashMap6.put((char) 8209, '-');
        hashMap6.put((char) 8210, '-');
        hashMap6.put((char) 8211, '-');
        hashMap6.put((char) 8212, '-');
        hashMap6.put((char) 8213, '-');
        hashMap6.put((char) 8722, '-');
        hashMap6.put('/', '/');
        hashMap6.put((char) 65295, '/');
        hashMap6.put(' ', ' ');
        hashMap6.put((char) 12288, ' ');
        hashMap6.put((char) 8288, ' ');
        hashMap6.put('.', '.');
        hashMap6.put((char) 65294, '.');
        f24877o = Collections.unmodifiableMap(hashMap6);
        f24878p = Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
        StringBuilder sb = new StringBuilder();
        Map<Character, Character> map = f24875m;
        sb.append(Arrays.toString(map.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
        sb.append(Arrays.toString(map.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
        String sb2 = sb.toString();
        f24879q = sb2;
        f24880r = Pattern.compile("[+＋]+");
        f24881s = Pattern.compile("[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]+");
        f24882t = Pattern.compile("(\\p{Nd})");
        f24883u = Pattern.compile("[+＋\\p{Nd}]");
        f24884v = Pattern.compile("[\\\\/] *x");
        f24885w = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
        f24886x = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
        String str = "\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*" + sb2 + "\\p{Nd}]*";
        f24887y = str;
        String f10 = f(true);
        f24888z = f10;
        f24857A = f(false);
        f24858B = Pattern.compile("^\\+(\\p{Nd}|[\\-\\.\\(\\)]?)*\\p{Nd}(\\p{Nd}|[\\-\\.\\(\\)]?)*$");
        String str2 = sb2 + "\\p{Nd}";
        f24859C = str2;
        String str3 = "[" + str2 + "]+((\\-)*[" + str2 + "])*";
        f24860D = str3;
        String str4 = "[" + sb2 + "]+((\\-)*[" + str2 + "])*";
        f24861E = str4;
        String str5 = "^(" + str3 + "\\.)*" + str4 + "\\.?$";
        f24862F = str5;
        f24863G = Pattern.compile(str5);
        f24864H = Pattern.compile("(?:" + f10 + ")$", 66);
        f24865I = Pattern.compile(str + "(?:" + f10 + ")?", 66);
        f24866J = Pattern.compile("(\\D+)");
        f24867K = Pattern.compile("(\\$\\d)");
        f24868L = Pattern.compile("\\(?\\$1\\)?");
        f24869M = null;
    }

    public PhoneNumberUtil(h hVar, Map<Integer, List<String>> map) {
        this.f24889a = hVar;
        this.f24890b = map;
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            if (value.size() == 1 && FastPairConstants.STATUS_CONNECT_RESULT_FAIL.equals(value.get(0))) {
                this.f24895g.add(entry.getKey());
            } else {
                this.f24894f.addAll(value);
            }
        }
        if (this.f24894f.remove(FastPairConstants.STATUS_CONNECT_RESULT_FAIL)) {
            f24870h.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.f24892d.addAll(map.get(1));
    }

    public static String B(int i10) {
        Map<Integer, String> map = f24871i;
        if (map.containsKey(Integer.valueOf(i10))) {
            return map.get(Integer.valueOf(i10));
        }
        return "";
    }

    public static synchronized PhoneNumberUtil C() {
        PhoneNumberUtil phoneNumberUtil;
        synchronized (PhoneNumberUtil.class) {
            try {
                if (f24869M == null) {
                    w0(g(M4.a.b().c()));
                }
                phoneNumberUtil = f24869M;
            } catch (Throwable th) {
                throw th;
            }
        }
        return phoneNumberUtil;
    }

    public static Phonenumber$PhoneNumber e(Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        Phonenumber$PhoneNumber phonenumber$PhoneNumber2 = new Phonenumber$PhoneNumber();
        phonenumber$PhoneNumber2.w(phonenumber$PhoneNumber.f());
        phonenumber$PhoneNumber2.A(phonenumber$PhoneNumber.i());
        if (phonenumber$PhoneNumber.h().length() > 0) {
            phonenumber$PhoneNumber2.y(phonenumber$PhoneNumber.h());
        }
        if (phonenumber$PhoneNumber.u()) {
            phonenumber$PhoneNumber2.z(true);
            phonenumber$PhoneNumber2.B(phonenumber$PhoneNumber.j());
        }
        return phonenumber$PhoneNumber2;
    }

    public static boolean e0(CharSequence charSequence) {
        if (charSequence.length() < 2) {
            return false;
        }
        return f24865I.matcher(charSequence).matches();
    }

    public static String f(boolean z10) {
        String str = (";ext=" + k(20)) + "|" + ("[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|доб|anexo)[:\\.．]?[  \\t,-]*" + k(20) + "#?") + "|" + ("[  \\t,]*(?:[xｘ#＃~～]|int|ｉｎｔ)[:\\.．]?[  \\t,-]*" + k(9) + "#?") + "|" + ("[- ]+" + k(6) + "#");
        if (z10) {
            return str + "|" + ("[  \\t]*(?:,{2}|;)[:\\.．]?[  \\t,-]*" + k(15) + "#?") + "|" + ("[  \\t]*(?:,)+[:\\.．]?[  \\t,-]*" + k(9) + "#?");
        }
        return str;
    }

    public static PhoneNumberUtil g(L4.b bVar) {
        if (bVar != null) {
            return h(new i(M4.a.b().e(), bVar, M4.a.b().d()));
        }
        throw new IllegalArgumentException("metadataLoader could not be null.");
    }

    public static PhoneNumberUtil h(h hVar) {
        if (hVar != null) {
            return new PhoneNumberUtil(hVar, L4.a.a());
        }
        throw new IllegalArgumentException("metadataSource could not be null.");
    }

    public static boolean i(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        if (phonemetadata$PhoneNumberDesc.c() != 1 || phonemetadata$PhoneNumberDesc.b(0) != -1) {
            return true;
        }
        return false;
    }

    public static void j(Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, String str) {
        if (phonemetadata$PhoneMetadata != null) {
        } else {
            throw new MissingMetadataException(str);
        }
    }

    public static String k(int i10) {
        return "(\\p{Nd}{1," + i10 + "})";
    }

    public static StringBuilder k0(StringBuilder sb) {
        if (f24886x.matcher(sb).matches()) {
            sb.replace(0, sb.length(), o0(sb, f24876n, true));
        } else {
            sb.replace(0, sb.length(), n0(sb));
        }
        return sb;
    }

    public static String l0(CharSequence charSequence) {
        return o0(charSequence, f24874l, true);
    }

    public static StringBuilder m0(CharSequence charSequence, boolean z10) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char charAt = charSequence.charAt(i10);
            int digit = Character.digit(charAt, 10);
            if (digit != -1) {
                sb.append(digit);
            } else if (z10) {
                sb.append(charAt);
            }
        }
        return sb;
    }

    public static CharSequence n(CharSequence charSequence) {
        Matcher matcher = f24883u.matcher(charSequence);
        if (matcher.find()) {
            CharSequence subSequence = charSequence.subSequence(matcher.start(), charSequence.length());
            Matcher matcher2 = f24885w.matcher(subSequence);
            if (matcher2.find()) {
                subSequence = subSequence.subSequence(0, matcher2.start());
            }
            Matcher matcher3 = f24884v.matcher(subSequence);
            if (matcher3.find()) {
                return subSequence.subSequence(0, matcher3.start());
            }
            return subSequence;
        }
        return "";
    }

    public static String n0(CharSequence charSequence) {
        return m0(charSequence, false).toString();
    }

    public static String o0(CharSequence charSequence, Map<Character, Character> map, boolean z10) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char charAt = charSequence.charAt(i10);
            Character ch = map.get(Character.valueOf(Character.toUpperCase(charAt)));
            if (ch != null) {
                sb.append(ch);
            } else if (!z10) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static synchronized void w0(PhoneNumberUtil phoneNumberUtil) {
        synchronized (PhoneNumberUtil.class) {
            f24869M = phoneNumberUtil;
        }
    }

    public static void x0(CharSequence charSequence, Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        if (charSequence.length() > 1 && charSequence.charAt(0) == '0') {
            phonenumber$PhoneNumber.z(true);
            int i10 = 1;
            while (i10 < charSequence.length() - 1 && charSequence.charAt(i10) == '0') {
                i10++;
            }
            if (i10 != 1) {
                phonenumber$PhoneNumber.B(i10);
            }
        }
    }

    public static boolean y(String str) {
        if (str.length() != 0 && !f24868L.matcher(str).matches()) {
            return false;
        }
        return true;
    }

    public final int A(String str) {
        Phonemetadata$PhoneMetadata E10 = E(str);
        if (E10 != null) {
            return E10.a();
        }
        throw new IllegalArgumentException("Invalid region code: " + str);
    }

    public Phonemetadata$PhoneMetadata D(int i10) {
        if (!this.f24895g.contains(Integer.valueOf(i10))) {
            return null;
        }
        Phonemetadata$PhoneMetadata a10 = this.f24889a.a(i10);
        j(a10, "Missing metadata for country code " + i10);
        return a10;
    }

    public Phonemetadata$PhoneMetadata E(String str) {
        if (!d0(str)) {
            return null;
        }
        Phonemetadata$PhoneMetadata b10 = this.f24889a.b(str);
        j(b10, "Missing metadata for region code " + str);
        return b10;
    }

    public final Phonemetadata$PhoneMetadata F(int i10, String str) {
        if (FastPairConstants.STATUS_CONNECT_RESULT_FAIL.equals(str)) {
            return D(i10);
        }
        return E(str);
    }

    public String G(Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        StringBuilder sb = new StringBuilder();
        if (phonenumber$PhoneNumber.u() && phonenumber$PhoneNumber.j() > 0) {
            char[] cArr = new char[phonenumber$PhoneNumber.j()];
            Arrays.fill(cArr, '0');
            sb.append(new String(cArr));
        }
        sb.append(phonenumber$PhoneNumber.i());
        return sb.toString();
    }

    public String H(String str, boolean z10) {
        Phonemetadata$PhoneMetadata E10 = E(str);
        if (E10 == null) {
            Logger logger = f24870h;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid or missing region code (");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            sb.append(") provided.");
            logger.log(level, sb.toString());
            return null;
        }
        String j10 = E10.j();
        if (j10.length() == 0) {
            return null;
        }
        if (z10) {
            return j10.replace("~", "");
        }
        return j10;
    }

    public Phonemetadata$PhoneNumberDesc I(Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, PhoneNumberType phoneNumberType) {
        switch (b.f24941c[phoneNumberType.ordinal()]) {
            case 1:
                return phonemetadata$PhoneMetadata.s();
            case 2:
                return phonemetadata$PhoneMetadata.v();
            case 3:
                return phonemetadata$PhoneMetadata.i();
            case 4:
            case 5:
                return phonemetadata$PhoneMetadata.b();
            case 6:
                return phonemetadata$PhoneMetadata.u();
            case 7:
                return phonemetadata$PhoneMetadata.y();
            case 8:
                return phonemetadata$PhoneMetadata.q();
            case 9:
                return phonemetadata$PhoneMetadata.p();
            case 10:
                return phonemetadata$PhoneMetadata.w();
            case 11:
                return phonemetadata$PhoneMetadata.x();
            default:
                return phonemetadata$PhoneMetadata.c();
        }
    }

    public PhoneNumberType J(Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        Phonemetadata$PhoneMetadata F10 = F(phonenumber$PhoneNumber.f(), M(phonenumber$PhoneNumber));
        if (F10 == null) {
            return PhoneNumberType.UNKNOWN;
        }
        return K(G(phonenumber$PhoneNumber), F10);
    }

    public final PhoneNumberType K(String str, Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata) {
        if (!W(str, phonemetadata$PhoneMetadata.c())) {
            return PhoneNumberType.UNKNOWN;
        }
        if (W(str, phonemetadata$PhoneMetadata.s())) {
            return PhoneNumberType.PREMIUM_RATE;
        }
        if (W(str, phonemetadata$PhoneMetadata.v())) {
            return PhoneNumberType.TOLL_FREE;
        }
        if (W(str, phonemetadata$PhoneMetadata.u())) {
            return PhoneNumberType.SHARED_COST;
        }
        if (W(str, phonemetadata$PhoneMetadata.y())) {
            return PhoneNumberType.VOIP;
        }
        if (W(str, phonemetadata$PhoneMetadata.q())) {
            return PhoneNumberType.PERSONAL_NUMBER;
        }
        if (W(str, phonemetadata$PhoneMetadata.p())) {
            return PhoneNumberType.PAGER;
        }
        if (W(str, phonemetadata$PhoneMetadata.w())) {
            return PhoneNumberType.UAN;
        }
        if (W(str, phonemetadata$PhoneMetadata.x())) {
            return PhoneNumberType.VOICEMAIL;
        }
        if (W(str, phonemetadata$PhoneMetadata.b())) {
            if (phonemetadata$PhoneMetadata.t()) {
                return PhoneNumberType.FIXED_LINE_OR_MOBILE;
            }
            if (W(str, phonemetadata$PhoneMetadata.i())) {
                return PhoneNumberType.FIXED_LINE_OR_MOBILE;
            }
            return PhoneNumberType.FIXED_LINE;
        }
        if (!phonemetadata$PhoneMetadata.t() && W(str, phonemetadata$PhoneMetadata.i())) {
            return PhoneNumberType.MOBILE;
        }
        return PhoneNumberType.UNKNOWN;
    }

    public String L(int i10) {
        List<String> list = this.f24890b.get(Integer.valueOf(i10));
        if (list == null) {
            return "ZZ";
        }
        return list.get(0);
    }

    public String M(Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        int f10 = phonenumber$PhoneNumber.f();
        List<String> list = this.f24890b.get(Integer.valueOf(f10));
        if (list == null) {
            f24870h.log(Level.INFO, "Missing/invalid country_code (" + f10 + ")");
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        return N(phonenumber$PhoneNumber, list);
    }

    public final String N(Phonenumber$PhoneNumber phonenumber$PhoneNumber, List<String> list) {
        String G10 = G(phonenumber$PhoneNumber);
        for (String str : list) {
            Phonemetadata$PhoneMetadata E10 = E(str);
            if (E10.z()) {
                if (this.f24893e.a(E10.h()).matcher(G10).lookingAt()) {
                    return str;
                }
            } else if (K(G10, E10) != PhoneNumberType.UNKNOWN) {
                return str;
            }
        }
        return null;
    }

    public List<String> O(int i10) {
        List<String> list = this.f24890b.get(Integer.valueOf(i10));
        if (list == null) {
            list = new ArrayList<>(0);
        }
        return Collections.unmodifiableList(list);
    }

    public Set<String> P() {
        return Collections.unmodifiableSet(this.f24894f);
    }

    public final boolean Q(int i10) {
        return this.f24890b.containsKey(Integer.valueOf(i10));
    }

    public final boolean R(Phonenumber$PhoneNumber phonenumber$PhoneNumber, Phonenumber$PhoneNumber phonenumber$PhoneNumber2) {
        String valueOf = String.valueOf(phonenumber$PhoneNumber.i());
        String valueOf2 = String.valueOf(phonenumber$PhoneNumber2.i());
        if (!valueOf.endsWith(valueOf2) && !valueOf2.endsWith(valueOf)) {
            return false;
        }
        return true;
    }

    public boolean S(PhoneNumberType phoneNumberType, int i10) {
        if (phoneNumberType != PhoneNumberType.FIXED_LINE && phoneNumberType != PhoneNumberType.FIXED_LINE_OR_MOBILE && (!f24873k.contains(Integer.valueOf(i10)) || phoneNumberType != PhoneNumberType.MOBILE)) {
            return false;
        }
        return true;
    }

    public MatchType T(Phonenumber$PhoneNumber phonenumber$PhoneNumber, Phonenumber$PhoneNumber phonenumber$PhoneNumber2) {
        Phonenumber$PhoneNumber e10 = e(phonenumber$PhoneNumber);
        Phonenumber$PhoneNumber e11 = e(phonenumber$PhoneNumber2);
        if (e10.o() && e11.o() && !e10.h().equals(e11.h())) {
            return MatchType.NO_MATCH;
        }
        int f10 = e10.f();
        int f11 = e11.f();
        if (f10 != 0 && f11 != 0) {
            if (e10.e(e11)) {
                return MatchType.EXACT_MATCH;
            }
            if (f10 == f11 && R(e10, e11)) {
                return MatchType.SHORT_NSN_MATCH;
            }
            return MatchType.NO_MATCH;
        }
        e10.w(f11);
        if (e10.e(e11)) {
            return MatchType.NSN_MATCH;
        }
        if (R(e10, e11)) {
            return MatchType.SHORT_NSN_MATCH;
        }
        return MatchType.NO_MATCH;
    }

    public MatchType U(Phonenumber$PhoneNumber phonenumber$PhoneNumber, CharSequence charSequence) {
        try {
            return T(phonenumber$PhoneNumber, p0(charSequence, "ZZ"));
        } catch (NumberParseException e10) {
            if (e10.a() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE) {
                String L10 = this.L(phonenumber$PhoneNumber.f());
                try {
                    if (!L10.equals("ZZ")) {
                        MatchType T10 = this.T(phonenumber$PhoneNumber, this.p0(charSequence, L10));
                        if (T10 == MatchType.EXACT_MATCH) {
                            return MatchType.NSN_MATCH;
                        }
                        return T10;
                    }
                    Phonenumber$PhoneNumber phonenumber$PhoneNumber2 = new Phonenumber$PhoneNumber();
                    this.t0(charSequence, null, false, false, phonenumber$PhoneNumber2);
                    return this.T(phonenumber$PhoneNumber, phonenumber$PhoneNumber2);
                } catch (NumberParseException unused) {
                    return MatchType.NOT_A_NUMBER;
                }
            }
            return MatchType.NOT_A_NUMBER;
        }
    }

    public MatchType V(CharSequence charSequence, CharSequence charSequence2) {
        try {
            return U(p0(charSequence, "ZZ"), charSequence2);
        } catch (NumberParseException e10) {
            if (e10.a() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE) {
                try {
                    return this.U(this.p0(charSequence2, "ZZ"), charSequence);
                } catch (NumberParseException e11) {
                    if (e11.a() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE) {
                        try {
                            Phonenumber$PhoneNumber phonenumber$PhoneNumber = new Phonenumber$PhoneNumber();
                            Phonenumber$PhoneNumber phonenumber$PhoneNumber2 = new Phonenumber$PhoneNumber();
                            this.t0(charSequence, null, false, false, phonenumber$PhoneNumber);
                            this.t0(charSequence2, null, false, false, phonenumber$PhoneNumber2);
                            return this.T(phonenumber$PhoneNumber, phonenumber$PhoneNumber2);
                        } catch (NumberParseException unused) {
                            return MatchType.NOT_A_NUMBER;
                        }
                    }
                    return MatchType.NOT_A_NUMBER;
                }
            }
            return MatchType.NOT_A_NUMBER;
        }
    }

    public boolean W(String str, Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        int length = str.length();
        List<Integer> d10 = phonemetadata$PhoneNumberDesc.d();
        if (d10.size() > 0 && !d10.contains(Integer.valueOf(length))) {
            return false;
        }
        return this.f24891c.a(str, phonemetadata$PhoneNumberDesc, false);
    }

    public final boolean X(String str) {
        if (str == null) {
            return true;
        }
        if (str.length() == 0) {
            return false;
        }
        if (f24858B.matcher(str).matches() || f24863G.matcher(str).matches()) {
            return true;
        }
        return false;
    }

    public boolean Y(Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        ValidationResult a02 = a0(phonenumber$PhoneNumber);
        if (a02 != ValidationResult.IS_POSSIBLE && a02 != ValidationResult.IS_POSSIBLE_LOCAL_ONLY) {
            return false;
        }
        return true;
    }

    public ValidationResult Z(Phonenumber$PhoneNumber phonenumber$PhoneNumber, PhoneNumberType phoneNumberType) {
        String G10 = G(phonenumber$PhoneNumber);
        int f10 = phonenumber$PhoneNumber.f();
        if (!Q(f10)) {
            return ValidationResult.INVALID_COUNTRY_CODE;
        }
        return z0(G10, F(f10, L(f10)), phoneNumberType);
    }

    public final void a(String str, StringBuilder sb) {
        int indexOf = str.indexOf(";phone-context=");
        String m10 = m(str, indexOf);
        if (X(m10)) {
            if (m10 != null) {
                int i10 = 0;
                if (m10.charAt(0) == '+') {
                    sb.append(m10);
                }
                int indexOf2 = str.indexOf("tel:");
                if (indexOf2 >= 0) {
                    i10 = indexOf2 + 4;
                }
                sb.append(str.substring(i10, indexOf));
            } else {
                sb.append(n(str));
            }
            int indexOf3 = sb.indexOf(";isub=");
            if (indexOf3 > 0) {
                sb.delete(indexOf3, sb.length());
                return;
            }
            return;
        }
        throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The phone-context value is invalid.");
    }

    public ValidationResult a0(Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        return Z(phonenumber$PhoneNumber, PhoneNumberType.UNKNOWN);
    }

    public boolean b(Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        if (E(M(phonenumber$PhoneNumber)) == null) {
            return true;
        }
        return !W(G(phonenumber$PhoneNumber), r0.m());
    }

    public boolean b0(Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        return c0(phonenumber$PhoneNumber, M(phonenumber$PhoneNumber));
    }

    public final boolean c(CharSequence charSequence, String str) {
        if (!d0(str)) {
            if (charSequence == null || charSequence.length() == 0 || !f24880r.matcher(charSequence).lookingAt()) {
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean c0(Phonenumber$PhoneNumber phonenumber$PhoneNumber, String str) {
        int f10 = phonenumber$PhoneNumber.f();
        Phonemetadata$PhoneMetadata F10 = F(f10, str);
        if (F10 == null) {
            return false;
        }
        if ((!FastPairConstants.STATUS_CONNECT_RESULT_FAIL.equals(str) && f10 != A(str)) || K(G(phonenumber$PhoneNumber), F10) == PhoneNumberType.UNKNOWN) {
            return false;
        }
        return true;
    }

    public Phonemetadata$NumberFormat d(List<Phonemetadata$NumberFormat> list, String str) {
        for (Phonemetadata$NumberFormat phonemetadata$NumberFormat : list) {
            int d10 = phonemetadata$NumberFormat.d();
            if (d10 == 0 || this.f24893e.a(phonemetadata$NumberFormat.c(d10 - 1)).matcher(str).lookingAt()) {
                if (this.f24893e.a(phonemetadata$NumberFormat.g()).matcher(str).matches()) {
                    return phonemetadata$NumberFormat;
                }
            }
        }
        return null;
    }

    public final boolean d0(String str) {
        if (str != null && this.f24894f.contains(str)) {
            return true;
        }
        return false;
    }

    public final void f0(Phonenumber$PhoneNumber phonenumber$PhoneNumber, Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, PhoneNumberFormat phoneNumberFormat, StringBuilder sb) {
        if (phonenumber$PhoneNumber.o() && phonenumber$PhoneNumber.h().length() > 0) {
            if (phoneNumberFormat == PhoneNumberFormat.RFC3966) {
                sb.append(";ext=");
                sb.append(phonenumber$PhoneNumber.h());
            } else if (phonemetadata$PhoneMetadata.A()) {
                sb.append(phonemetadata$PhoneMetadata.r());
                sb.append(phonenumber$PhoneNumber.h());
            } else {
                sb.append(" ext. ");
                sb.append(phonenumber$PhoneNumber.h());
            }
        }
    }

    public int g0(CharSequence charSequence, Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, StringBuilder sb, boolean z10, Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        String str;
        if (charSequence.length() == 0) {
            return 0;
        }
        StringBuilder sb2 = new StringBuilder(charSequence);
        if (phonemetadata$PhoneMetadata != null) {
            str = phonemetadata$PhoneMetadata.e();
        } else {
            str = "NonMatch";
        }
        Phonenumber$PhoneNumber.CountryCodeSource i02 = i0(sb2, str);
        if (z10) {
            phonenumber$PhoneNumber.x(i02);
        }
        if (i02 != Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            if (sb2.length() > 2) {
                int l10 = l(sb2, sb);
                if (l10 != 0) {
                    phonenumber$PhoneNumber.w(l10);
                    return l10;
                }
                throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
            }
            throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
        }
        if (phonemetadata$PhoneMetadata != null) {
            int a10 = phonemetadata$PhoneMetadata.a();
            String valueOf = String.valueOf(a10);
            String sb3 = sb2.toString();
            if (sb3.startsWith(valueOf)) {
                StringBuilder sb4 = new StringBuilder(sb3.substring(valueOf.length()));
                Phonemetadata$PhoneNumberDesc c10 = phonemetadata$PhoneMetadata.c();
                j0(sb4, phonemetadata$PhoneMetadata, null);
                if ((!this.f24891c.a(sb2, c10, false) && this.f24891c.a(sb4, c10, false)) || y0(sb2, phonemetadata$PhoneMetadata) == ValidationResult.TOO_LONG) {
                    sb.append((CharSequence) sb4);
                    if (z10) {
                        phonenumber$PhoneNumber.x(Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                    }
                    phonenumber$PhoneNumber.w(a10);
                    return a10;
                }
            }
        }
        phonenumber$PhoneNumber.w(0);
        return 0;
    }

    public String h0(StringBuilder sb) {
        Matcher matcher = f24864H.matcher(sb);
        if (matcher.find() && e0(sb.substring(0, matcher.start()))) {
            int groupCount = matcher.groupCount();
            for (int i10 = 1; i10 <= groupCount; i10++) {
                if (matcher.group(i10) != null) {
                    String group = matcher.group(i10);
                    sb.delete(matcher.start(), sb.length());
                    return group;
                }
            }
            return "";
        }
        return "";
    }

    public Phonenumber$PhoneNumber.CountryCodeSource i0(StringBuilder sb, String str) {
        if (sb.length() == 0) {
            return Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
        }
        Matcher matcher = f24880r.matcher(sb);
        if (matcher.lookingAt()) {
            sb.delete(0, matcher.end());
            k0(sb);
            return Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        }
        Pattern a10 = this.f24893e.a(str);
        k0(sb);
        if (u0(a10, sb)) {
            return Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD;
        }
        return Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
    }

    public boolean j0(StringBuilder sb, Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, StringBuilder sb2) {
        int length = sb.length();
        String k10 = phonemetadata$PhoneMetadata.k();
        if (length != 0 && k10.length() != 0) {
            Matcher matcher = this.f24893e.a(k10).matcher(sb);
            if (matcher.lookingAt()) {
                Phonemetadata$PhoneNumberDesc c10 = phonemetadata$PhoneMetadata.c();
                boolean a10 = this.f24891c.a(sb, c10, false);
                int groupCount = matcher.groupCount();
                String l10 = phonemetadata$PhoneMetadata.l();
                if (l10 != null && l10.length() != 0 && matcher.group(groupCount) != null) {
                    StringBuilder sb3 = new StringBuilder(sb);
                    sb3.replace(0, length, matcher.replaceFirst(l10));
                    if (a10 && !this.f24891c.a(sb3.toString(), c10, false)) {
                        return false;
                    }
                    if (sb2 != null && groupCount > 1) {
                        sb2.append(matcher.group(1));
                    }
                    sb.replace(0, sb.length(), sb3.toString());
                    return true;
                }
                if (a10 && !this.f24891c.a(sb.substring(matcher.end()), c10, false)) {
                    return false;
                }
                if (sb2 != null && groupCount > 0 && matcher.group(groupCount) != null) {
                    sb2.append(matcher.group(1));
                }
                sb.delete(0, matcher.end());
                return true;
            }
        }
        return false;
    }

    public int l(StringBuilder sb, StringBuilder sb2) {
        if (sb.length() != 0 && sb.charAt(0) != '0') {
            int length = sb.length();
            for (int i10 = 1; i10 <= 3 && i10 <= length; i10++) {
                int parseInt = Integer.parseInt(sb.substring(0, i10));
                if (this.f24890b.containsKey(Integer.valueOf(parseInt))) {
                    sb2.append(sb.substring(i10));
                    return parseInt;
                }
            }
        }
        return 0;
    }

    public final String m(String str, int i10) {
        if (i10 == -1) {
            return null;
        }
        int i11 = i10 + 15;
        if (i11 >= str.length()) {
            return "";
        }
        int indexOf = str.indexOf(59, i11);
        if (indexOf != -1) {
            return str.substring(i11, indexOf);
        }
        return str.substring(i11);
    }

    public Iterable<L4.c> o(CharSequence charSequence, String str, Leniency leniency, long j10) {
        return new a(charSequence, str, leniency, j10);
    }

    public String p(Phonenumber$PhoneNumber phonenumber$PhoneNumber, PhoneNumberFormat phoneNumberFormat) {
        if (phonenumber$PhoneNumber.i() == 0) {
            String l10 = phonenumber$PhoneNumber.l();
            if (l10.length() > 0 || !phonenumber$PhoneNumber.m()) {
                return l10;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        q(phonenumber$PhoneNumber, phoneNumberFormat, sb);
        return sb.toString();
    }

    public Phonenumber$PhoneNumber p0(CharSequence charSequence, String str) {
        Phonenumber$PhoneNumber phonenumber$PhoneNumber = new Phonenumber$PhoneNumber();
        q0(charSequence, str, phonenumber$PhoneNumber);
        return phonenumber$PhoneNumber;
    }

    public void q(Phonenumber$PhoneNumber phonenumber$PhoneNumber, PhoneNumberFormat phoneNumberFormat, StringBuilder sb) {
        sb.setLength(0);
        int f10 = phonenumber$PhoneNumber.f();
        String G10 = G(phonenumber$PhoneNumber);
        PhoneNumberFormat phoneNumberFormat2 = PhoneNumberFormat.E164;
        if (phoneNumberFormat == phoneNumberFormat2) {
            sb.append(G10);
            v0(f10, phoneNumberFormat2, sb);
        } else {
            if (!Q(f10)) {
                sb.append(G10);
                return;
            }
            Phonemetadata$PhoneMetadata F10 = F(f10, L(f10));
            sb.append(t(G10, F10, phoneNumberFormat));
            f0(phonenumber$PhoneNumber, F10, phoneNumberFormat, sb);
            v0(f10, phoneNumberFormat, sb);
        }
    }

    public void q0(CharSequence charSequence, String str, Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        t0(charSequence, str, false, true, phonenumber$PhoneNumber);
    }

    public String r(Phonenumber$PhoneNumber phonenumber$PhoneNumber, CharSequence charSequence) {
        int f10 = phonenumber$PhoneNumber.f();
        String G10 = G(phonenumber$PhoneNumber);
        if (!Q(f10)) {
            return G10;
        }
        Phonemetadata$PhoneMetadata F10 = F(f10, L(f10));
        StringBuilder sb = new StringBuilder(20);
        PhoneNumberFormat phoneNumberFormat = PhoneNumberFormat.NATIONAL;
        sb.append(u(G10, F10, phoneNumberFormat, charSequence));
        f0(phonenumber$PhoneNumber, F10, phoneNumberFormat, sb);
        v0(f10, phoneNumberFormat, sb);
        return sb.toString();
    }

    public Phonenumber$PhoneNumber r0(CharSequence charSequence, String str) {
        Phonenumber$PhoneNumber phonenumber$PhoneNumber = new Phonenumber$PhoneNumber();
        s0(charSequence, str, phonenumber$PhoneNumber);
        return phonenumber$PhoneNumber;
    }

    public String s(Phonenumber$PhoneNumber phonenumber$PhoneNumber, CharSequence charSequence) {
        if (phonenumber$PhoneNumber.k().length() > 0) {
            charSequence = phonenumber$PhoneNumber.k();
        }
        return r(phonenumber$PhoneNumber, charSequence);
    }

    public void s0(CharSequence charSequence, String str, Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        t0(charSequence, str, true, true, phonenumber$PhoneNumber);
    }

    public final String t(String str, Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, PhoneNumberFormat phoneNumberFormat) {
        return u(str, phonemetadata$PhoneMetadata, phoneNumberFormat, null);
    }

    public final void t0(CharSequence charSequence, String str, boolean z10, boolean z11, Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        int g02;
        if (charSequence != null) {
            if (charSequence.length() <= 250) {
                StringBuilder sb = new StringBuilder();
                String charSequence2 = charSequence.toString();
                a(charSequence2, sb);
                if (e0(sb)) {
                    if (z11 && !c(sb, str)) {
                        throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
                    }
                    if (z10) {
                        phonenumber$PhoneNumber.D(charSequence2);
                    }
                    String h02 = h0(sb);
                    if (h02.length() > 0) {
                        phonenumber$PhoneNumber.y(h02);
                    }
                    Phonemetadata$PhoneMetadata E10 = E(str);
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        g02 = g0(sb, E10, sb2, z10, phonenumber$PhoneNumber);
                    } catch (NumberParseException e10) {
                        Matcher matcher = f24880r.matcher(sb);
                        if (e10.a() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE && matcher.lookingAt()) {
                            g02 = g0(sb.substring(matcher.end()), E10, sb2, z10, phonenumber$PhoneNumber);
                            if (g02 == 0) {
                                throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
                            }
                        } else {
                            throw new NumberParseException(e10.a(), e10.getMessage());
                        }
                    }
                    if (g02 != 0) {
                        String L10 = L(g02);
                        if (!L10.equals(str)) {
                            E10 = F(g02, L10);
                        }
                    } else {
                        sb2.append((CharSequence) k0(sb));
                        if (str != null) {
                            phonenumber$PhoneNumber.w(E10.a());
                        } else if (z10) {
                            phonenumber$PhoneNumber.a();
                        }
                    }
                    if (sb2.length() >= 2) {
                        if (E10 != null) {
                            StringBuilder sb3 = new StringBuilder();
                            StringBuilder sb4 = new StringBuilder(sb2);
                            j0(sb4, E10, sb3);
                            ValidationResult y02 = y0(sb4, E10);
                            if (y02 != ValidationResult.TOO_SHORT && y02 != ValidationResult.IS_POSSIBLE_LOCAL_ONLY && y02 != ValidationResult.INVALID_LENGTH) {
                                if (z10 && sb3.length() > 0) {
                                    phonenumber$PhoneNumber.C(sb3.toString());
                                }
                                sb2 = sb4;
                            }
                        }
                        int length = sb2.length();
                        if (length >= 2) {
                            if (length <= 17) {
                                x0(sb2, phonenumber$PhoneNumber);
                                phonenumber$PhoneNumber.A(Long.parseLong(sb2.toString()));
                                return;
                            }
                            throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied is too long to be a phone number.");
                        }
                        throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                    }
                    throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                }
                throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
            }
            throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied was too long to parse.");
        }
        throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The phone number supplied was null.");
    }

    public final String u(String str, Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, PhoneNumberFormat phoneNumberFormat, CharSequence charSequence) {
        List<Phonemetadata$NumberFormat> o10;
        if (phonemetadata$PhoneMetadata.g().size() != 0 && phoneNumberFormat != PhoneNumberFormat.NATIONAL) {
            o10 = phonemetadata$PhoneMetadata.g();
        } else {
            o10 = phonemetadata$PhoneMetadata.o();
        }
        Phonemetadata$NumberFormat d10 = d(o10, str);
        if (d10 != null) {
            return w(str, d10, phoneNumberFormat, charSequence);
        }
        return str;
    }

    public final boolean u0(Pattern pattern, StringBuilder sb) {
        Matcher matcher = pattern.matcher(sb);
        if (!matcher.lookingAt()) {
            return false;
        }
        int end = matcher.end();
        Matcher matcher2 = f24882t.matcher(sb.substring(end));
        if (matcher2.find() && n0(matcher2.group(1)).equals(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE)) {
            return false;
        }
        sb.delete(0, end);
        return true;
    }

    public String v(String str, Phonemetadata$NumberFormat phonemetadata$NumberFormat, PhoneNumberFormat phoneNumberFormat) {
        return w(str, phonemetadata$NumberFormat, phoneNumberFormat, null);
    }

    public final void v0(int i10, PhoneNumberFormat phoneNumberFormat, StringBuilder sb) {
        int i11 = b.f24940b[phoneNumberFormat.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    return;
                }
                sb.insert(0, "-").insert(0, i10).insert(0, '+').insert(0, "tel:");
                return;
            }
            sb.insert(0, " ").insert(0, i10).insert(0, '+');
            return;
        }
        sb.insert(0, i10).insert(0, '+');
    }

    public final String w(String str, Phonemetadata$NumberFormat phonemetadata$NumberFormat, PhoneNumberFormat phoneNumberFormat, CharSequence charSequence) {
        String replaceAll;
        String b10 = phonemetadata$NumberFormat.b();
        Matcher matcher = this.f24893e.a(phonemetadata$NumberFormat.g()).matcher(str);
        PhoneNumberFormat phoneNumberFormat2 = PhoneNumberFormat.NATIONAL;
        if (phoneNumberFormat == phoneNumberFormat2 && charSequence != null && charSequence.length() > 0 && phonemetadata$NumberFormat.a().length() > 0) {
            replaceAll = matcher.replaceAll(f24867K.matcher(b10).replaceFirst(phonemetadata$NumberFormat.a().replace("$CC", charSequence)));
        } else {
            String e10 = phonemetadata$NumberFormat.e();
            if (phoneNumberFormat == phoneNumberFormat2 && e10 != null && e10.length() > 0) {
                replaceAll = matcher.replaceAll(f24867K.matcher(b10).replaceFirst(e10));
            } else {
                replaceAll = matcher.replaceAll(b10);
            }
        }
        if (phoneNumberFormat == PhoneNumberFormat.RFC3966) {
            Matcher matcher2 = f24881s.matcher(replaceAll);
            if (matcher2.lookingAt()) {
                replaceAll = matcher2.replaceFirst("");
            }
            return matcher2.reset(replaceAll).replaceAll("-");
        }
        return replaceAll;
    }

    public String x(Phonenumber$PhoneNumber phonenumber$PhoneNumber, String str, boolean z10) {
        boolean z11;
        String p10;
        int f10 = phonenumber$PhoneNumber.f();
        String str2 = "";
        if (!Q(f10)) {
            if (!phonenumber$PhoneNumber.t()) {
                return "";
            }
            return phonenumber$PhoneNumber.l();
        }
        Phonenumber$PhoneNumber b10 = new Phonenumber$PhoneNumber().v(phonenumber$PhoneNumber).b();
        String L10 = L(f10);
        PhoneNumberType J10 = J(b10);
        boolean z12 = false;
        if (J10 != PhoneNumberType.UNKNOWN) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (str.equals(L10)) {
            if (J10 == PhoneNumberType.FIXED_LINE || J10 == PhoneNumberType.MOBILE || J10 == PhoneNumberType.FIXED_LINE_OR_MOBILE) {
                z12 = true;
            }
            if (L10.equals("BR") && z12) {
                if (b10.k().length() > 0) {
                    str2 = s(b10, "");
                }
            } else {
                if (f10 == 1) {
                    Phonemetadata$PhoneMetadata E10 = E(str);
                    if (b(b10) && y0(G(b10), E10) != ValidationResult.TOO_SHORT) {
                        p10 = p(b10, PhoneNumberFormat.INTERNATIONAL);
                    } else {
                        p10 = p(b10, PhoneNumberFormat.NATIONAL);
                    }
                } else if ((L10.equals(FastPairConstants.STATUS_CONNECT_RESULT_FAIL) || ((L10.equals("MX") || L10.equals("CL") || L10.equals("UZ")) && z12)) && b(b10)) {
                    p10 = p(b10, PhoneNumberFormat.INTERNATIONAL);
                } else {
                    p10 = p(b10, PhoneNumberFormat.NATIONAL);
                }
                str2 = p10;
            }
        } else if (z11 && b(b10)) {
            if (z10) {
                return p(b10, PhoneNumberFormat.INTERNATIONAL);
            }
            return p(b10, PhoneNumberFormat.E164);
        }
        if (!z10) {
            return l0(str2);
        }
        return str2;
    }

    public final ValidationResult y0(CharSequence charSequence, Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata) {
        return z0(charSequence, phonemetadata$PhoneMetadata, PhoneNumberType.UNKNOWN);
    }

    public int z(String str) {
        if (!d0(str)) {
            Logger logger = f24870h;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid or missing region code (");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            sb.append(") provided.");
            logger.log(level, sb.toString());
            return 0;
        }
        return A(str);
    }

    public final ValidationResult z0(CharSequence charSequence, Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, PhoneNumberType phoneNumberType) {
        List<Integer> d10;
        List<Integer> d11;
        Phonemetadata$PhoneNumberDesc I10 = I(phonemetadata$PhoneMetadata, phoneNumberType);
        if (I10.d().isEmpty()) {
            d10 = phonemetadata$PhoneMetadata.c().d();
        } else {
            d10 = I10.d();
        }
        List<Integer> f10 = I10.f();
        if (phoneNumberType == PhoneNumberType.FIXED_LINE_OR_MOBILE) {
            if (!i(I(phonemetadata$PhoneMetadata, PhoneNumberType.FIXED_LINE))) {
                return z0(charSequence, phonemetadata$PhoneMetadata, PhoneNumberType.MOBILE);
            }
            Phonemetadata$PhoneNumberDesc I11 = I(phonemetadata$PhoneMetadata, PhoneNumberType.MOBILE);
            if (i(I11)) {
                ArrayList arrayList = new ArrayList(d10);
                if (I11.c() == 0) {
                    d11 = phonemetadata$PhoneMetadata.c().d();
                } else {
                    d11 = I11.d();
                }
                arrayList.addAll(d11);
                Collections.sort(arrayList);
                if (f10.isEmpty()) {
                    f10 = I11.f();
                } else {
                    ArrayList arrayList2 = new ArrayList(f10);
                    arrayList2.addAll(I11.f());
                    Collections.sort(arrayList2);
                    f10 = arrayList2;
                }
                d10 = arrayList;
            }
        }
        if (d10.get(0).intValue() == -1) {
            return ValidationResult.INVALID_LENGTH;
        }
        int length = charSequence.length();
        if (f10.contains(Integer.valueOf(length))) {
            return ValidationResult.IS_POSSIBLE_LOCAL_ONLY;
        }
        int intValue = d10.get(0).intValue();
        if (intValue == length) {
            return ValidationResult.IS_POSSIBLE;
        }
        if (intValue > length) {
            return ValidationResult.TOO_SHORT;
        }
        if (d10.get(d10.size() - 1).intValue() < length) {
            return ValidationResult.TOO_LONG;
        }
        if (d10.subList(1, d10.size()).contains(Integer.valueOf(length))) {
            return ValidationResult.IS_POSSIBLE;
        }
        return ValidationResult.INVALID_LENGTH;
    }
}
