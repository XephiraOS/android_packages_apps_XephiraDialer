package com.google.i18n.phonenumbers;

import L4.c;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber$PhoneNumber;
import com.google.i18n.phonenumbers.internal.RegexCache;
import java.lang.Character;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class PhoneNumberMatcher implements Iterator<c> {

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f24836j;

    /* renamed from: o, reason: collision with root package name */
    public static final Pattern f24841o;

    /* renamed from: q, reason: collision with root package name */
    public static final Pattern f24843q;

    /* renamed from: a, reason: collision with root package name */
    public final PhoneNumberUtil f24844a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f24845b;

    /* renamed from: c, reason: collision with root package name */
    public final String f24846c;

    /* renamed from: d, reason: collision with root package name */
    public final PhoneNumberUtil.Leniency f24847d;

    /* renamed from: e, reason: collision with root package name */
    public long f24848e;

    /* renamed from: f, reason: collision with root package name */
    public State f24849f = State.NOT_READY;

    /* renamed from: g, reason: collision with root package name */
    public c f24850g = null;

    /* renamed from: h, reason: collision with root package name */
    public int f24851h = 0;

    /* renamed from: i, reason: collision with root package name */
    public final RegexCache f24852i = new RegexCache(32);

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f24837k = Pattern.compile("\\d{1,5}-+\\d{1,5}\\s{0,4}\\(\\d{1,4}");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f24838l = Pattern.compile("(?:(?:[0-3]?\\d/[01]?\\d)|(?:[01]?\\d/[0-3]?\\d))/(?:[12]\\d)?\\d{2}");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f24839m = Pattern.compile("[12]\\d{3}[-/]?[01]\\d[-/]?[0-3]\\d +[0-2]\\d$");

    /* renamed from: n, reason: collision with root package name */
    public static final Pattern f24840n = Pattern.compile(":[0-5]\\d");

    /* renamed from: p, reason: collision with root package name */
    public static final Pattern[] f24842p = {Pattern.compile("/+(.*)"), Pattern.compile("(\\([^(]*)"), Pattern.compile("(?:\\p{Z}-|-\\p{Z})\\p{Z}*(.+)"), Pattern.compile("[‒-―－]\\p{Z}*(.+)"), Pattern.compile("\\.+\\p{Z}*([^.]+)"), Pattern.compile("\\p{Z}+(\\P{Z}+)")};

    /* loaded from: classes3.dex */
    public enum State {
        NOT_READY,
        READY,
        DONE
    }

    /* loaded from: classes3.dex */
    public interface a {
        boolean a(PhoneNumberUtil phoneNumberUtil, Phonenumber$PhoneNumber phonenumber$PhoneNumber, StringBuilder sb, String[] strArr);
    }

    static {
        String str = "[^(\\[（［)\\]）］]";
        f24841o = Pattern.compile("(?:[(\\[（［])?(?:" + str + "+[)\\]）］])?" + str + "+(?:[(\\[（［]" + str + "+[)\\]）］])" + n(0, 3) + str + "*");
        String n10 = n(0, 2);
        String n11 = n(0, 4);
        String n12 = n(0, 20);
        String str2 = "[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]" + n11;
        String str3 = "\\p{Nd}" + n(1, 20);
        String str4 = "[" + ("(\\[（［+＋") + "]";
        f24843q = Pattern.compile(str4);
        f24836j = Pattern.compile("(?:" + str4 + str2 + ")" + n10 + str3 + "(?:" + str2 + str3 + ")" + n12 + "(?:" + PhoneNumberUtil.f24857A + ")?", 66);
    }

    public PhoneNumberMatcher(PhoneNumberUtil phoneNumberUtil, String str, String str2, PhoneNumberUtil.Leniency leniency, long j10) {
        if (phoneNumberUtil != null) {
            if (leniency != null) {
                if (j10 >= 0) {
                    this.f24844a = phoneNumberUtil;
                    this.f24845b = str == null ? "" : str;
                    this.f24846c = str2;
                    this.f24847d = leniency;
                    this.f24848e = j10;
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw null;
        }
        throw null;
    }

    public static boolean a(PhoneNumberUtil phoneNumberUtil, Phonenumber$PhoneNumber phonenumber$PhoneNumber, StringBuilder sb, String[] strArr) {
        int length;
        String[] split = PhoneNumberUtil.f24866J.split(sb.toString());
        if (phonenumber$PhoneNumber.o()) {
            length = split.length - 2;
        } else {
            length = split.length - 1;
        }
        if (split.length == 1 || split[length].contains(phoneNumberUtil.G(phonenumber$PhoneNumber))) {
            return true;
        }
        int length2 = strArr.length - 1;
        while (length2 > 0 && length >= 0) {
            if (!split[length].equals(strArr[length2])) {
                return false;
            }
            length2--;
            length--;
        }
        if (length >= 0 && split[length].endsWith(strArr[0])) {
            return true;
        }
        return false;
    }

    public static boolean b(PhoneNumberUtil phoneNumberUtil, Phonenumber$PhoneNumber phonenumber$PhoneNumber, StringBuilder sb, String[] strArr) {
        int i10;
        if (phonenumber$PhoneNumber.g() != Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            String num = Integer.toString(phonenumber$PhoneNumber.f());
            i10 = sb.indexOf(num) + num.length();
        } else {
            i10 = 0;
        }
        for (int i11 = 0; i11 < strArr.length; i11++) {
            int indexOf = sb.indexOf(strArr[i11], i10);
            if (indexOf < 0) {
                return false;
            }
            i10 = indexOf + strArr[i11].length();
            if (i11 == 0 && i10 < sb.length() && phoneNumberUtil.H(phoneNumberUtil.L(phonenumber$PhoneNumber.f()), true) != null && Character.isDigit(sb.charAt(i10))) {
                return sb.substring(i10 - strArr[i11].length()).startsWith(phoneNumberUtil.G(phonenumber$PhoneNumber));
            }
        }
        return sb.substring(i10).contains(phonenumber$PhoneNumber.h());
    }

    public static boolean d(Phonenumber$PhoneNumber phonenumber$PhoneNumber, String str) {
        int indexOf;
        int indexOf2 = str.indexOf(47);
        if (indexOf2 < 0 || (indexOf = str.indexOf(47, indexOf2 + 1)) < 0) {
            return false;
        }
        if ((phonenumber$PhoneNumber.g() != Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN && phonenumber$PhoneNumber.g() != Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN) || !PhoneNumberUtil.n0(str.substring(0, indexOf2)).equals(Integer.toString(phonenumber$PhoneNumber.f()))) {
            return true;
        }
        return str.substring(indexOf + 1).contains("/");
    }

    public static boolean e(Phonenumber$PhoneNumber phonenumber$PhoneNumber, String str, PhoneNumberUtil phoneNumberUtil) {
        int i10 = 0;
        while (i10 < str.length() - 1) {
            char charAt = str.charAt(i10);
            if (charAt == 'x' || charAt == 'X') {
                int i11 = i10 + 1;
                char charAt2 = str.charAt(i11);
                if (charAt2 != 'x' && charAt2 != 'X') {
                    if (!PhoneNumberUtil.n0(str.substring(i10)).equals(phonenumber$PhoneNumber.h())) {
                        return false;
                    }
                } else {
                    if (phoneNumberUtil.U(phonenumber$PhoneNumber, str.substring(i11)) != PhoneNumberUtil.MatchType.NSN_MATCH) {
                        return false;
                    }
                    i10 = i11;
                }
            }
            i10++;
        }
        return true;
    }

    public static String[] i(PhoneNumberUtil phoneNumberUtil, Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        String p10 = phoneNumberUtil.p(phonenumber$PhoneNumber, PhoneNumberUtil.PhoneNumberFormat.RFC3966);
        int indexOf = p10.indexOf(59);
        if (indexOf < 0) {
            indexOf = p10.length();
        }
        return p10.substring(p10.indexOf(45) + 1, indexOf).split("-");
    }

    public static String[] j(PhoneNumberUtil phoneNumberUtil, Phonenumber$PhoneNumber phonenumber$PhoneNumber, Phonemetadata$NumberFormat phonemetadata$NumberFormat) {
        return phoneNumberUtil.v(phoneNumberUtil.G(phonenumber$PhoneNumber), phonemetadata$NumberFormat, PhoneNumberUtil.PhoneNumberFormat.RFC3966).split("-");
    }

    public static boolean k(char c10) {
        if (c10 != '%' && Character.getType(c10) != 26) {
            return false;
        }
        return true;
    }

    public static boolean l(char c10) {
        if (!Character.isLetter(c10) && Character.getType(c10) != 6) {
            return false;
        }
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c10);
        if (!of.equals(Character.UnicodeBlock.BASIC_LATIN) && !of.equals(Character.UnicodeBlock.LATIN_1_SUPPLEMENT) && !of.equals(Character.UnicodeBlock.LATIN_EXTENDED_A) && !of.equals(Character.UnicodeBlock.LATIN_EXTENDED_ADDITIONAL) && !of.equals(Character.UnicodeBlock.LATIN_EXTENDED_B) && !of.equals(Character.UnicodeBlock.COMBINING_DIACRITICAL_MARKS)) {
            return false;
        }
        return true;
    }

    public static boolean m(Phonenumber$PhoneNumber phonenumber$PhoneNumber, PhoneNumberUtil phoneNumberUtil) {
        Phonemetadata$PhoneMetadata E10;
        if (phonenumber$PhoneNumber.g() != Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY || (E10 = phoneNumberUtil.E(phoneNumberUtil.L(phonenumber$PhoneNumber.f()))) == null) {
            return true;
        }
        Phonemetadata$NumberFormat d10 = phoneNumberUtil.d(E10.o(), phoneNumberUtil.G(phonenumber$PhoneNumber));
        if (d10 == null || d10.e().length() <= 0 || d10.f() || PhoneNumberUtil.y(d10.e())) {
            return true;
        }
        return phoneNumberUtil.j0(new StringBuilder(PhoneNumberUtil.n0(phonenumber$PhoneNumber.l())), E10, null);
    }

    public static String n(int i10, int i11) {
        if (i10 >= 0 && i11 > 0 && i11 >= i10) {
            return "{" + i10 + "," + i11 + "}";
        }
        throw new IllegalArgumentException();
    }

    public static CharSequence q(Pattern pattern, CharSequence charSequence) {
        Matcher matcher = pattern.matcher(charSequence);
        if (matcher.find()) {
            return charSequence.subSequence(0, matcher.start());
        }
        return charSequence;
    }

    public boolean c(Phonenumber$PhoneNumber phonenumber$PhoneNumber, CharSequence charSequence, PhoneNumberUtil phoneNumberUtil, a aVar) {
        StringBuilder m02 = PhoneNumberUtil.m0(charSequence, true);
        if (aVar.a(phoneNumberUtil, phonenumber$PhoneNumber, m02, i(phoneNumberUtil, phonenumber$PhoneNumber))) {
            return true;
        }
        Phonemetadata$PhoneMetadata a10 = M4.a.b().a().a(phonenumber$PhoneNumber.f());
        String G10 = phoneNumberUtil.G(phonenumber$PhoneNumber);
        if (a10 != null) {
            for (Phonemetadata$NumberFormat phonemetadata$NumberFormat : a10.o()) {
                if (phonemetadata$NumberFormat.d() <= 0 || this.f24852i.a(phonemetadata$NumberFormat.c(0)).matcher(G10).lookingAt()) {
                    if (aVar.a(phoneNumberUtil, phonenumber$PhoneNumber, m02, j(phoneNumberUtil, phonenumber$PhoneNumber, phonemetadata$NumberFormat))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final c f(CharSequence charSequence, int i10) {
        for (Pattern pattern : f24842p) {
            Matcher matcher = pattern.matcher(charSequence);
            boolean z10 = true;
            while (matcher.find() && this.f24848e > 0) {
                if (z10) {
                    c p10 = p(q(PhoneNumberUtil.f24885w, charSequence.subSequence(0, matcher.start())), i10);
                    if (p10 != null) {
                        return p10;
                    }
                    this.f24848e--;
                    z10 = false;
                }
                c p11 = p(q(PhoneNumberUtil.f24885w, matcher.group(1)), matcher.start(1) + i10);
                if (p11 != null) {
                    return p11;
                }
                this.f24848e--;
            }
        }
        return null;
    }

    public final c g(CharSequence charSequence, int i10) {
        if (f24838l.matcher(charSequence).find()) {
            return null;
        }
        if (f24839m.matcher(charSequence).find()) {
            if (f24840n.matcher(this.f24845b.toString().substring(charSequence.length() + i10)).lookingAt()) {
                return null;
            }
        }
        c p10 = p(charSequence, i10);
        if (p10 != null) {
            return p10;
        }
        return f(charSequence, i10);
    }

    public final c h(int i10) {
        Matcher matcher = f24836j.matcher(this.f24845b);
        while (this.f24848e > 0 && matcher.find(i10)) {
            int start = matcher.start();
            CharSequence q10 = q(PhoneNumberUtil.f24884v, this.f24845b.subSequence(start, matcher.end()));
            c g10 = g(q10, start);
            if (g10 != null) {
                return g10;
            }
            i10 = start + q10.length();
            this.f24848e--;
        }
        return null;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f24849f == State.NOT_READY) {
            c h10 = h(this.f24851h);
            this.f24850g = h10;
            if (h10 == null) {
                this.f24849f = State.DONE;
            } else {
                this.f24851h = h10.a();
                this.f24849f = State.READY;
            }
        }
        if (this.f24849f == State.READY) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public c next() {
        if (hasNext()) {
            c cVar = this.f24850g;
            this.f24850g = null;
            this.f24849f = State.NOT_READY;
            return cVar;
        }
        throw new NoSuchElementException();
    }

    public final c p(CharSequence charSequence, int i10) {
        try {
            if (f24841o.matcher(charSequence).matches() && !f24837k.matcher(charSequence).find()) {
                if (this.f24847d.compareTo(PhoneNumberUtil.Leniency.VALID) >= 0) {
                    if (i10 > 0 && !f24843q.matcher(charSequence).lookingAt()) {
                        char charAt = this.f24845b.charAt(i10 - 1);
                        if (k(charAt) || l(charAt)) {
                            return null;
                        }
                    }
                    int length = charSequence.length() + i10;
                    if (length < this.f24845b.length()) {
                        char charAt2 = this.f24845b.charAt(length);
                        if (k(charAt2) || l(charAt2)) {
                            return null;
                        }
                    }
                }
                Phonenumber$PhoneNumber r02 = this.f24844a.r0(charSequence, this.f24846c);
                if (this.f24847d.b(r02, charSequence, this.f24844a, this)) {
                    r02.a();
                    r02.d();
                    r02.c();
                    return new c(i10, charSequence.toString(), r02);
                }
            }
        } catch (NumberParseException unused) {
        }
        return null;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
