package com.ted.number;

import android.text.Editable;
import android.text.Html;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ParagraphStyle;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

/* compiled from: ColorHTML.java */
/* loaded from: classes4.dex */
public class b {

    /* compiled from: ColorHTML.java */
    /* renamed from: com.ted.number.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0284b {

        /* renamed from: a, reason: collision with root package name */
        public static final U9.f f29594a = new U9.f();
    }

    /* compiled from: ColorHTML.java */
    /* loaded from: classes4.dex */
    public interface c {
        void a(String str, SpannableStringBuilder spannableStringBuilder);

        void b(String str, SpannableStringBuilder spannableStringBuilder, Attributes attributes);
    }

    public static Spanned a(String str, int i10) {
        return b(str, i10, null, null);
    }

    public static Spanned b(String str, int i10, Html.ImageGetter imageGetter, c cVar) {
        U9.h hVar = new U9.h();
        try {
            hVar.setProperty("http://www.ccil.org/~cowan/tagsoup/properties/schema", C0284b.f29594a);
            return new a(str, imageGetter, cVar, hVar, i10).b();
        } catch (SAXNotRecognizedException e10) {
            throw new RuntimeException(e10);
        } catch (SAXNotSupportedException e11) {
            throw new RuntimeException(e11);
        }
    }

    /* compiled from: ColorHTML.java */
    /* loaded from: classes4.dex */
    public static class a implements ContentHandler {

        /* renamed from: g, reason: collision with root package name */
        public static final float[] f29574g = {1.5f, 1.4f, 1.3f, 1.2f, 1.1f, 1.0f};

        /* renamed from: h, reason: collision with root package name */
        public static Pattern f29575h;

        /* renamed from: i, reason: collision with root package name */
        public static Pattern f29576i;

        /* renamed from: j, reason: collision with root package name */
        public static Pattern f29577j;

        /* renamed from: k, reason: collision with root package name */
        public static Pattern f29578k;

        /* renamed from: l, reason: collision with root package name */
        public static final Map<String, Integer> f29579l;

        /* renamed from: a, reason: collision with root package name */
        public String f29580a;

        /* renamed from: b, reason: collision with root package name */
        public XMLReader f29581b;

        /* renamed from: c, reason: collision with root package name */
        public SpannableStringBuilder f29582c = new SpannableStringBuilder();

        /* renamed from: d, reason: collision with root package name */
        public Html.ImageGetter f29583d;

        /* renamed from: e, reason: collision with root package name */
        public final c f29584e;

        /* renamed from: f, reason: collision with root package name */
        public int f29585f;

        /* compiled from: ColorHTML.java */
        /* renamed from: com.ted.number.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0282a {

            /* renamed from: a, reason: collision with root package name */
            public Layout.Alignment f29586a;

            public C0282a(Layout.Alignment alignment) {
                this.f29586a = alignment;
            }
        }

        /* compiled from: ColorHTML.java */
        /* renamed from: com.ted.number.b$a$b, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0283b {

            /* renamed from: a, reason: collision with root package name */
            public int f29587a;

            public C0283b(int i10) {
                this.f29587a = i10;
            }
        }

        /* compiled from: ColorHTML.java */
        /* loaded from: classes4.dex */
        public static class c {
            public c() {
            }
        }

        /* compiled from: ColorHTML.java */
        /* loaded from: classes4.dex */
        public static class d {
            public d() {
            }
        }

        /* compiled from: ColorHTML.java */
        /* loaded from: classes4.dex */
        public static class e {
            public e() {
            }
        }

        /* compiled from: ColorHTML.java */
        /* loaded from: classes4.dex */
        public static class f {
            public f() {
            }
        }

        /* compiled from: ColorHTML.java */
        /* loaded from: classes4.dex */
        public static class g {

            /* renamed from: a, reason: collision with root package name */
            public String f29588a;

            public g(String str) {
                this.f29588a = str;
            }
        }

        /* compiled from: ColorHTML.java */
        /* loaded from: classes4.dex */
        public static class h {

            /* renamed from: a, reason: collision with root package name */
            public int f29589a;

            public h(int i10) {
                this.f29589a = i10;
            }
        }

        /* compiled from: ColorHTML.java */
        /* loaded from: classes4.dex */
        public static class i {

            /* renamed from: a, reason: collision with root package name */
            public int f29590a;

            public i(int i10) {
                this.f29590a = i10;
            }
        }

        /* compiled from: ColorHTML.java */
        /* loaded from: classes4.dex */
        public static class j {

            /* renamed from: a, reason: collision with root package name */
            public int f29591a;

            public j(int i10) {
                this.f29591a = i10;
            }
        }

        /* compiled from: ColorHTML.java */
        /* loaded from: classes4.dex */
        public static class k {

            /* renamed from: a, reason: collision with root package name */
            public String f29592a;

            public k(String str) {
                this.f29592a = str;
            }
        }

        /* compiled from: ColorHTML.java */
        /* loaded from: classes4.dex */
        public static class l {
            public l() {
            }
        }

        /* compiled from: ColorHTML.java */
        /* loaded from: classes4.dex */
        public static class m {
            public m() {
            }
        }

        /* compiled from: ColorHTML.java */
        /* loaded from: classes4.dex */
        public static class n {
            public n() {
            }
        }

        /* compiled from: ColorHTML.java */
        /* loaded from: classes4.dex */
        public static class o {

            /* renamed from: a, reason: collision with root package name */
            public int f29593a;

            public o(int i10) {
                this.f29593a = i10;
            }
        }

        /* compiled from: ColorHTML.java */
        /* loaded from: classes4.dex */
        public static class p {
            public p() {
            }
        }

        /* compiled from: ColorHTML.java */
        /* loaded from: classes4.dex */
        public static class q {
            public q() {
            }
        }

        /* compiled from: ColorHTML.java */
        /* loaded from: classes4.dex */
        public static class r {
            public r() {
            }
        }

        /* compiled from: ColorHTML.java */
        /* loaded from: classes4.dex */
        public static class s {
            public s() {
            }
        }

        /* compiled from: ColorHTML.java */
        /* loaded from: classes4.dex */
        public static class t {
            public t() {
            }
        }

        static {
            HashMap hashMap = new HashMap();
            f29579l = hashMap;
            hashMap.put("darkgray", -5658199);
            hashMap.put("gray", -8355712);
            hashMap.put("lightgray", -2894893);
            hashMap.put("darkgrey", -5658199);
            hashMap.put("grey", -8355712);
            hashMap.put("lightgrey", -2894893);
            hashMap.put("green", -16744448);
        }

        public a(String str, Html.ImageGetter imageGetter, c cVar, U9.h hVar, int i10) {
            this.f29580a = str;
            this.f29583d = imageGetter;
            this.f29584e = cVar;
            this.f29581b = hVar;
            this.f29585f = i10;
        }

        public static void A(Spannable spannable, Object obj, Object... objArr) {
            int spanStart = spannable.getSpanStart(obj);
            spannable.removeSpan(obj);
            int length = spannable.length();
            if (spanStart != length) {
                for (Object obj2 : objArr) {
                    spannable.setSpan(obj2, spanStart, length, 33);
                }
            }
        }

        public static void B(Editable editable, Object obj) {
            int length = editable.length();
            editable.setSpan(obj, length, length, 17);
        }

        public static void C(Editable editable, Attributes attributes) {
            B(editable, new k(attributes.getValue("", "href")));
        }

        public static void D(Editable editable, Attributes attributes, int i10) {
            editable.length();
            if (i10 > 0) {
                a(editable, i10);
                B(editable, new o(i10));
            }
            String value = attributes.getValue("", "style");
            if (value != null) {
                Matcher matcher = v().matcher(value);
                if (matcher.find()) {
                    String group = matcher.group(1);
                    if (group.equalsIgnoreCase("start")) {
                        B(editable, new C0282a(Layout.Alignment.ALIGN_NORMAL));
                    } else if (group.equalsIgnoreCase("center")) {
                        B(editable, new C0282a(Layout.Alignment.ALIGN_CENTER));
                    } else if (group.equalsIgnoreCase("end")) {
                        B(editable, new C0282a(Layout.Alignment.ALIGN_OPPOSITE));
                    }
                }
            }
        }

        public static void a(Editable editable, int i10) {
            int length = editable.length();
            if (length == 0) {
                return;
            }
            int i11 = 0;
            for (int i12 = length - 1; i12 >= 0 && editable.charAt(i12) == '\n'; i12--) {
                i11++;
            }
            while (i11 < i10) {
                editable.append("\n");
                i11++;
            }
        }

        public static void c(Editable editable, Class cls, Object obj) {
            editable.length();
            Object n10 = n(editable, cls);
            if (n10 != null) {
                A(editable, n10, obj);
            }
        }

        public static void d(Editable editable) {
            k kVar = (k) n(editable, k.class);
            if (kVar != null && kVar.f29592a != null) {
                A(editable, kVar, new URLSpan(kVar.f29592a));
            }
        }

        public static void e(Editable editable) {
            o oVar = (o) n(editable, o.class);
            if (oVar != null) {
                a(editable, oVar.f29593a);
                editable.removeSpan(oVar);
            }
            C0282a c0282a = (C0282a) n(editable, C0282a.class);
            if (c0282a != null) {
                A(editable, c0282a, new AlignmentSpan.Standard(c0282a.f29586a));
            }
        }

        public static void f(Editable editable) {
            e(editable);
            c(editable, d.class, new QuoteSpan());
        }

        public static void g(Editable editable) {
            q qVar = (q) n(editable, q.class);
            if (qVar != null) {
                A(editable, qVar, new StrikethroughSpan());
            }
            C0283b c0283b = (C0283b) n(editable, C0283b.class);
            if (c0283b != null) {
                A(editable, c0283b, new BackgroundColorSpan(c0283b.f29587a));
            }
            i iVar = (i) n(editable, i.class);
            if (iVar != null) {
                A(editable, iVar, new ForegroundColorSpan(iVar.f29590a));
            }
        }

        public static void h(Editable editable) {
            g gVar = (g) n(editable, g.class);
            if (gVar != null) {
                A(editable, gVar, new TypefaceSpan(gVar.f29588a));
            }
            i iVar = (i) n(editable, i.class);
            if (iVar != null) {
                A(editable, iVar, new ForegroundColorSpan(iVar.f29590a));
            }
            h hVar = (h) n(editable, h.class);
            if (hVar != null) {
                A(editable, hVar, new AbsoluteSizeSpan(hVar.f29589a, true));
            }
        }

        public static void i(Editable editable) {
            j jVar = (j) n(editable, j.class);
            if (jVar != null) {
                A(editable, jVar, new RelativeSizeSpan(f29574g[jVar.f29591a]), new StyleSpan(1));
            }
            e(editable);
        }

        public static void j(Editable editable) {
            g(editable);
            e(editable);
            c(editable, f.class, new BulletSpan());
        }

        public static Pattern k() {
            if (f29577j == null) {
                f29577j = Pattern.compile("(?:\\s+|\\A)background(?:-color)?\\s*:\\s*(\\S*)\\b");
            }
            return f29577j;
        }

        public static Pattern l() {
            if (f29576i == null) {
                f29576i = Pattern.compile("(?:\\s+|\\A)color\\s*:\\s*(\\S*)\\b");
            }
            return f29576i;
        }

        public static <T> T n(Spanned spanned, Class<T> cls) {
            Object[] spans = spanned.getSpans(0, spanned.length(), cls);
            if (spans.length == 0) {
                return null;
            }
            return (T) spans[spans.length - 1];
        }

        public static Pattern v() {
            if (f29575h == null) {
                f29575h = Pattern.compile("(?:\\s+|\\A)text-align\\s*:\\s*(\\S*)\\b");
            }
            return f29575h;
        }

        public static Pattern w() {
            if (f29578k == null) {
                f29578k = Pattern.compile("(?:\\s+|\\A)text-decoration\\s*:\\s*(\\S*)\\b");
            }
            return f29578k;
        }

        public static void x(Editable editable) {
            editable.append('\n');
        }

        public final void E(Editable editable, Attributes attributes) {
            D(editable, attributes, p());
            B(editable, new d());
        }

        public final void F(Editable editable, Attributes attributes) {
            int m10;
            int m11;
            String value = attributes.getValue("", "style");
            if (value != null) {
                Matcher matcher = l().matcher(value);
                if (matcher.find() && (m11 = m(matcher.group(1))) != -1) {
                    B(editable, new i(m11 | (-16777216)));
                }
                Matcher matcher2 = k().matcher(value);
                if (matcher2.find() && (m10 = m(matcher2.group(1))) != -1) {
                    B(editable, new C0283b(m10 | (-16777216)));
                }
                Matcher matcher3 = w().matcher(value);
                if (matcher3.find() && matcher3.group(1).equalsIgnoreCase("line-through")) {
                    B(editable, new q());
                }
            }
        }

        public final void G(Editable editable, Attributes attributes) {
            int i10;
            int m10;
            String value = attributes.getValue("", "color");
            String value2 = attributes.getValue("", "face");
            String value3 = attributes.getValue("", "size-dp");
            if (!TextUtils.isEmpty(value) && (m10 = m(value)) != -1) {
                B(editable, new i(m10 | (-16777216)));
            }
            if (!TextUtils.isEmpty(value2)) {
                B(editable, new g(value2));
            }
            if (!TextUtils.isEmpty(value3)) {
                try {
                    i10 = Integer.parseInt(value3);
                } catch (Exception e10) {
                    e = e10;
                    i10 = 14;
                }
                try {
                    i10 = (int) (i10 * P7.a.f2962b.getResources().getConfiguration().fontScale);
                } catch (Exception e11) {
                    e = e11;
                    H7.b.c("ColorHtmlToSpannedConverter", "startFont e: " + e);
                    B(editable, new h(i10));
                }
                B(editable, new h(i10));
            }
        }

        public final void H(Editable editable, Attributes attributes, int i10) {
            D(editable, attributes, r());
            B(editable, new j(i10));
        }

        public final void J(Editable editable, Attributes attributes) {
            D(editable, attributes, t());
            B(editable, new f());
            F(editable, attributes);
        }

        public Spanned b() {
            this.f29581b.setContentHandler(this);
            try {
                this.f29581b.parse(new InputSource(new StringReader(this.f29580a)));
                SpannableStringBuilder spannableStringBuilder = this.f29582c;
                Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ParagraphStyle.class);
                for (int i10 = 0; i10 < spans.length; i10++) {
                    int spanStart = this.f29582c.getSpanStart(spans[i10]);
                    int spanEnd = this.f29582c.getSpanEnd(spans[i10]);
                    int i11 = spanEnd - 2;
                    if (i11 >= 0 && this.f29582c.charAt(spanEnd - 1) == '\n' && this.f29582c.charAt(i11) == '\n') {
                        spanEnd--;
                    }
                    if (spanEnd == spanStart) {
                        this.f29582c.removeSpan(spans[i10]);
                    } else {
                        this.f29582c.setSpan(spans[i10], spanStart, spanEnd, 51);
                    }
                }
                return this.f29582c;
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            } catch (SAXException e11) {
                throw new RuntimeException(e11);
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i10, int i11) {
            char charAt;
            StringBuilder sb = new StringBuilder();
            for (int i12 = 0; i12 < i11; i12++) {
                char c10 = cArr[i12 + i10];
                if (c10 != ' ' && c10 != '\n') {
                    sb.append(c10);
                } else {
                    int length = sb.length();
                    if (length == 0) {
                        int length2 = this.f29582c.length();
                        if (length2 == 0) {
                            charAt = '\n';
                        } else {
                            charAt = this.f29582c.charAt(length2 - 1);
                        }
                    } else {
                        charAt = sb.charAt(length - 1);
                    }
                    if (charAt != ' ' && charAt != '\n') {
                        sb.append(' ');
                    }
                }
            }
            this.f29582c.append((CharSequence) sb);
        }

        @Override // org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            y(str2);
        }

        public final int m(String str) {
            Integer num;
            if ((this.f29585f & 256) == 256 && (num = f29579l.get(str.toLowerCase(Locale.US))) != null) {
                return num.intValue();
            }
            return u.a(str, -1);
        }

        public final int o(int i10) {
            if ((this.f29585f & i10) != 0) {
                return 1;
            }
            return 2;
        }

        public final int p() {
            return o(32);
        }

        public final int q() {
            return o(16);
        }

        public final int r() {
            return o(2);
        }

        public final int s() {
            return o(8);
        }

        @Override // org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            z(str2, attributes);
        }

        public final int t() {
            return o(4);
        }

        public final int u() {
            return o(1);
        }

        public final void y(String str) {
            if (str.equalsIgnoreCase("br")) {
                x(this.f29582c);
                return;
            }
            if (str.equalsIgnoreCase("p")) {
                g(this.f29582c);
                e(this.f29582c);
                return;
            }
            if (str.equalsIgnoreCase("ul")) {
                e(this.f29582c);
                return;
            }
            if (str.equalsIgnoreCase("li")) {
                j(this.f29582c);
                return;
            }
            if (str.equalsIgnoreCase("div")) {
                e(this.f29582c);
                return;
            }
            if (str.equalsIgnoreCase("span")) {
                g(this.f29582c);
                return;
            }
            if (str.equalsIgnoreCase("strong")) {
                c(this.f29582c, e.class, new StyleSpan(1));
                return;
            }
            if (str.equalsIgnoreCase(com.heytap.accessory.e.f25269e)) {
                c(this.f29582c, m.class, new StyleSpan(1));
                return;
            }
            if (str.equalsIgnoreCase("em")) {
                c(this.f29582c, l.class, new StyleSpan(2));
                return;
            }
            if (str.equalsIgnoreCase("cite")) {
                c(this.f29582c, l.class, new StyleSpan(2));
                return;
            }
            if (str.equalsIgnoreCase("dfn")) {
                c(this.f29582c, l.class, new StyleSpan(2));
                return;
            }
            if (str.equalsIgnoreCase("i")) {
                c(this.f29582c, l.class, new StyleSpan(2));
                return;
            }
            if (str.equalsIgnoreCase("big")) {
                c(this.f29582c, c.class, new RelativeSizeSpan(1.25f));
                return;
            }
            if (str.equalsIgnoreCase("small")) {
                c(this.f29582c, p.class, new RelativeSizeSpan(0.8f));
                return;
            }
            if (str.equalsIgnoreCase("font")) {
                h(this.f29582c);
                return;
            }
            if (str.equalsIgnoreCase("blockquote")) {
                f(this.f29582c);
                return;
            }
            if (str.equalsIgnoreCase("tt")) {
                c(this.f29582c, n.class, new TypefaceSpan("monospace"));
                return;
            }
            if (str.equalsIgnoreCase("a")) {
                d(this.f29582c);
                return;
            }
            if (str.equalsIgnoreCase("u")) {
                c(this.f29582c, t.class, new UnderlineSpan());
                return;
            }
            if (str.equalsIgnoreCase("del")) {
                c(this.f29582c, q.class, new StrikethroughSpan());
                return;
            }
            if (str.equalsIgnoreCase("s")) {
                c(this.f29582c, q.class, new StrikethroughSpan());
                return;
            }
            if (str.equalsIgnoreCase("strike")) {
                c(this.f29582c, q.class, new StrikethroughSpan());
                return;
            }
            if (str.equalsIgnoreCase("sup")) {
                c(this.f29582c, s.class, new SuperscriptSpan());
                return;
            }
            if (str.equalsIgnoreCase("sub")) {
                c(this.f29582c, r.class, new SubscriptSpan());
                return;
            }
            if (str.length() == 2 && Character.toLowerCase(str.charAt(0)) == 'h' && str.charAt(1) >= '1' && str.charAt(1) <= '6') {
                i(this.f29582c);
                return;
            }
            c cVar = this.f29584e;
            if (cVar != null) {
                cVar.a(str, this.f29582c);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void z(String str, Attributes attributes) {
            if (!str.equalsIgnoreCase("br")) {
                if (str.equalsIgnoreCase("p")) {
                    D(this.f29582c, attributes, u());
                    F(this.f29582c, attributes);
                    return;
                }
                if (str.equalsIgnoreCase("ul")) {
                    D(this.f29582c, attributes, s());
                    return;
                }
                if (str.equalsIgnoreCase("li")) {
                    J(this.f29582c, attributes);
                    return;
                }
                if (str.equalsIgnoreCase("div")) {
                    D(this.f29582c, attributes, q());
                    return;
                }
                if (str.equalsIgnoreCase("span")) {
                    F(this.f29582c, attributes);
                    return;
                }
                Object[] objArr = 0;
                Object[] objArr2 = 0;
                Object[] objArr3 = 0;
                Object[] objArr4 = 0;
                Object[] objArr5 = 0;
                Object[] objArr6 = 0;
                Object[] objArr7 = 0;
                Object[] objArr8 = 0;
                Object[] objArr9 = 0;
                Object[] objArr10 = 0;
                Object[] objArr11 = 0;
                Object[] objArr12 = 0;
                Object[] objArr13 = 0;
                Object[] objArr14 = 0;
                if (str.equalsIgnoreCase("strong")) {
                    B(this.f29582c, new e());
                    return;
                }
                if (str.equalsIgnoreCase(com.heytap.accessory.e.f25269e)) {
                    B(this.f29582c, new m());
                    return;
                }
                if (str.equalsIgnoreCase("em")) {
                    B(this.f29582c, new l());
                    return;
                }
                if (str.equalsIgnoreCase("cite")) {
                    B(this.f29582c, new l());
                    return;
                }
                if (str.equalsIgnoreCase("dfn")) {
                    B(this.f29582c, new l());
                    return;
                }
                if (str.equalsIgnoreCase("i")) {
                    B(this.f29582c, new l());
                    return;
                }
                if (str.equalsIgnoreCase("big")) {
                    B(this.f29582c, new c());
                    return;
                }
                if (str.equalsIgnoreCase("small")) {
                    B(this.f29582c, new p());
                    return;
                }
                if (str.equalsIgnoreCase("font")) {
                    G(this.f29582c, attributes);
                    return;
                }
                if (str.equalsIgnoreCase("blockquote")) {
                    E(this.f29582c, attributes);
                    return;
                }
                if (str.equalsIgnoreCase("tt")) {
                    B(this.f29582c, new n());
                    return;
                }
                if (str.equalsIgnoreCase("a")) {
                    C(this.f29582c, attributes);
                    return;
                }
                if (str.equalsIgnoreCase("u")) {
                    B(this.f29582c, new t());
                    return;
                }
                if (str.equalsIgnoreCase("del")) {
                    B(this.f29582c, new q());
                    return;
                }
                if (str.equalsIgnoreCase("s")) {
                    B(this.f29582c, new q());
                    return;
                }
                if (str.equalsIgnoreCase("strike")) {
                    B(this.f29582c, new q());
                    return;
                }
                if (str.equalsIgnoreCase("sup")) {
                    B(this.f29582c, new s());
                    return;
                }
                if (str.equalsIgnoreCase("sub")) {
                    B(this.f29582c, new r());
                    return;
                }
                if (str.length() == 2 && Character.toLowerCase(str.charAt(0)) == 'h' && str.charAt(1) >= '1' && str.charAt(1) <= '6') {
                    H(this.f29582c, attributes, str.charAt(1) - '1');
                    return;
                }
                if (str.equalsIgnoreCase("img")) {
                    I(this.f29582c, attributes, this.f29583d);
                    return;
                }
                c cVar = this.f29584e;
                if (cVar != null) {
                    cVar.b(str, this.f29582c, attributes);
                }
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void endPrefixMapping(String str) {
        }

        @Override // org.xml.sax.ContentHandler
        public void setDocumentLocator(Locator locator) {
        }

        @Override // org.xml.sax.ContentHandler
        public void skippedEntity(String str) {
        }

        @Override // org.xml.sax.ContentHandler
        public void endDocument() {
        }

        @Override // org.xml.sax.ContentHandler
        public void startDocument() {
        }

        @Override // org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) {
        }

        @Override // org.xml.sax.ContentHandler
        public void startPrefixMapping(String str, String str2) {
        }

        public static void I(Editable editable, Attributes attributes, Html.ImageGetter imageGetter) {
        }

        @Override // org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] cArr, int i10, int i11) {
        }
    }
}
