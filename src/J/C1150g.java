package j;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.K;
import androidx.appcompat.widget.u;
import androidx.core.view.AbstractC0447b;
import androidx.core.view.r;
import e.j;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: SupportMenuInflater.java */
/* renamed from: j.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1150g extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class<?>[] f33693e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class<?>[] f33694f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f33695a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f33696b;

    /* renamed from: c, reason: collision with root package name */
    public Context f33697c;

    /* renamed from: d, reason: collision with root package name */
    public Object f33698d;

    /* compiled from: SupportMenuInflater.java */
    /* renamed from: j.g$a */
    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c, reason: collision with root package name */
        public static final Class<?>[] f33699c = {MenuItem.class};

        /* renamed from: a, reason: collision with root package name */
        public Object f33700a;

        /* renamed from: b, reason: collision with root package name */
        public Method f33701b;

        public a(Object obj, String str) {
            this.f33700a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f33701b = cls.getMethod(str, f33699c);
            } catch (Exception e10) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e10);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f33701b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f33701b.invoke(this.f33700a, menuItem)).booleanValue();
                }
                this.f33701b.invoke(this.f33700a, menuItem);
                return true;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    /* compiled from: SupportMenuInflater.java */
    /* renamed from: j.g$b */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: A, reason: collision with root package name */
        public AbstractC0447b f33702A;

        /* renamed from: B, reason: collision with root package name */
        public CharSequence f33703B;

        /* renamed from: C, reason: collision with root package name */
        public CharSequence f33704C;

        /* renamed from: D, reason: collision with root package name */
        public ColorStateList f33705D = null;

        /* renamed from: E, reason: collision with root package name */
        public PorterDuff.Mode f33706E = null;

        /* renamed from: a, reason: collision with root package name */
        public Menu f33708a;

        /* renamed from: b, reason: collision with root package name */
        public int f33709b;

        /* renamed from: c, reason: collision with root package name */
        public int f33710c;

        /* renamed from: d, reason: collision with root package name */
        public int f33711d;

        /* renamed from: e, reason: collision with root package name */
        public int f33712e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f33713f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f33714g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f33715h;

        /* renamed from: i, reason: collision with root package name */
        public int f33716i;

        /* renamed from: j, reason: collision with root package name */
        public int f33717j;

        /* renamed from: k, reason: collision with root package name */
        public CharSequence f33718k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f33719l;

        /* renamed from: m, reason: collision with root package name */
        public int f33720m;

        /* renamed from: n, reason: collision with root package name */
        public char f33721n;

        /* renamed from: o, reason: collision with root package name */
        public int f33722o;

        /* renamed from: p, reason: collision with root package name */
        public char f33723p;

        /* renamed from: q, reason: collision with root package name */
        public int f33724q;

        /* renamed from: r, reason: collision with root package name */
        public int f33725r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f33726s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f33727t;

        /* renamed from: u, reason: collision with root package name */
        public boolean f33728u;

        /* renamed from: v, reason: collision with root package name */
        public int f33729v;

        /* renamed from: w, reason: collision with root package name */
        public int f33730w;

        /* renamed from: x, reason: collision with root package name */
        public String f33731x;

        /* renamed from: y, reason: collision with root package name */
        public String f33732y;

        /* renamed from: z, reason: collision with root package name */
        public String f33733z;

        public b(Menu menu) {
            this.f33708a = menu;
            h();
        }

        public void a() {
            this.f33715h = true;
            i(this.f33708a.add(this.f33709b, this.f33716i, this.f33717j, this.f33718k));
        }

        public SubMenu b() {
            this.f33715h = true;
            SubMenu addSubMenu = this.f33708a.addSubMenu(this.f33709b, this.f33716i, this.f33717j, this.f33718k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public final char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        public boolean d() {
            return this.f33715h;
        }

        public final <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, C1150g.this.f33697c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e10) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e10);
                return null;
            }
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = C1150g.this.f33697c.obtainStyledAttributes(attributeSet, j.f30537y1);
            this.f33709b = obtainStyledAttributes.getResourceId(j.f30284A1, 0);
            this.f33710c = obtainStyledAttributes.getInt(j.f30294C1, 0);
            this.f33711d = obtainStyledAttributes.getInt(j.f30299D1, 0);
            this.f33712e = obtainStyledAttributes.getInt(j.f30304E1, 0);
            this.f33713f = obtainStyledAttributes.getBoolean(j.f30289B1, true);
            this.f33714g = obtainStyledAttributes.getBoolean(j.f30542z1, true);
            obtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            boolean z10;
            K v10 = K.v(C1150g.this.f33697c, attributeSet, j.f30309F1);
            this.f33716i = v10.n(j.f30324I1, 0);
            this.f33717j = (v10.k(j.f30339L1, this.f33710c) & (-65536)) | (v10.k(j.f30344M1, this.f33711d) & 65535);
            this.f33718k = v10.p(j.f30349N1);
            this.f33719l = v10.p(j.f30354O1);
            this.f33720m = v10.n(j.f30314G1, 0);
            this.f33721n = c(v10.o(j.f30359P1));
            this.f33722o = v10.k(j.f30394W1, 4096);
            this.f33723p = c(v10.o(j.f30364Q1));
            this.f33724q = v10.k(j.f30415a2, 4096);
            int i10 = j.f30369R1;
            if (v10.s(i10)) {
                this.f33725r = v10.a(i10, false) ? 1 : 0;
            } else {
                this.f33725r = this.f33712e;
            }
            this.f33726s = v10.a(j.f30329J1, false);
            this.f33727t = v10.a(j.f30334K1, this.f33713f);
            this.f33728u = v10.a(j.f30319H1, this.f33714g);
            this.f33729v = v10.k(j.f30421b2, -1);
            this.f33733z = v10.o(j.f30374S1);
            this.f33730w = v10.n(j.f30379T1, 0);
            this.f33731x = v10.o(j.f30389V1);
            String o10 = v10.o(j.f30384U1);
            this.f33732y = o10;
            if (o10 != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10 && this.f33730w == 0 && this.f33731x == null) {
                this.f33702A = (AbstractC0447b) e(o10, C1150g.f33694f, C1150g.this.f33696b);
            } else {
                if (z10) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f33702A = null;
            }
            this.f33703B = v10.p(j.f30399X1);
            this.f33704C = v10.p(j.f30427c2);
            int i11 = j.f30409Z1;
            if (v10.s(i11)) {
                this.f33706E = u.d(v10.k(i11, -1), this.f33706E);
            } else {
                this.f33706E = null;
            }
            int i12 = j.f30404Y1;
            if (v10.s(i12)) {
                this.f33705D = v10.c(i12);
            } else {
                this.f33705D = null;
            }
            v10.y();
            this.f33715h = false;
        }

        public void h() {
            this.f33709b = 0;
            this.f33710c = 0;
            this.f33711d = 0;
            this.f33712e = 0;
            this.f33713f = true;
            this.f33714g = true;
        }

        public final void i(MenuItem menuItem) {
            boolean z10;
            MenuItem enabled = menuItem.setChecked(this.f33726s).setVisible(this.f33727t).setEnabled(this.f33728u);
            boolean z11 = false;
            if (this.f33725r >= 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            enabled.setCheckable(z10).setTitleCondensed(this.f33719l).setIcon(this.f33720m);
            int i10 = this.f33729v;
            if (i10 >= 0) {
                menuItem.setShowAsAction(i10);
            }
            if (this.f33733z != null) {
                if (!C1150g.this.f33697c.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(C1150g.this.b(), this.f33733z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.f33725r >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).setExclusiveCheckable(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).setExclusiveCheckable(true);
                }
            }
            String str = this.f33731x;
            if (str != null) {
                menuItem.setActionView((View) e(str, C1150g.f33693e, C1150g.this.f33695a));
                z11 = true;
            }
            int i11 = this.f33730w;
            if (i11 > 0) {
                if (!z11) {
                    menuItem.setActionView(i11);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            AbstractC0447b abstractC0447b = this.f33702A;
            if (abstractC0447b != null) {
                r.a(menuItem, abstractC0447b);
            }
            r.c(menuItem, this.f33703B);
            r.g(menuItem, this.f33704C);
            r.b(menuItem, this.f33721n, this.f33722o);
            r.f(menuItem, this.f33723p, this.f33724q);
            PorterDuff.Mode mode = this.f33706E;
            if (mode != null) {
                r.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.f33705D;
            if (colorStateList != null) {
                r.d(menuItem, colorStateList);
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f33693e = clsArr;
        f33694f = clsArr;
    }

    public C1150g(Context context) {
        super(context);
        this.f33697c = context;
        Object[] objArr = {context};
        this.f33695a = objArr;
        this.f33696b = objArr;
    }

    public final Object a(Object obj) {
        if (obj instanceof Activity) {
            return obj;
        }
        if (obj instanceof ContextWrapper) {
            return a(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }

    public Object b() {
        if (this.f33698d == null) {
            this.f33698d = a(this.f33697c);
        }
        return this.f33698d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
    
        if (r15 == 2) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
    
        if (r15 == 3) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
    
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        if (r15.equals(r8) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        r7 = false;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b9, code lost:
    
        r15 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
    
        if (r15.equals("group") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
    
        r0.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        if (r15.equals("item") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (r0.d() != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        r15 = r0.f33702A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
    
        if (r15 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        if (r15.hasSubMenu() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
    
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
    
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
    
        if (r15.equals("menu") == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
    
        if (r7 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0091, code lost:
    
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0099, code lost:
    
        if (r15.equals("group") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
    
        r0.f(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
    
        if (r15.equals("item") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a5, code lost:
    
        r0.g(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ad, code lost:
    
        if (r15.equals("menu") == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00af, code lost:
    
        c(r13, r14, r0.b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b7, code lost:
    
        r8 = r15;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c5, code lost:
    
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c6, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003b, code lost:
    
        r6 = false;
        r7 = false;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0040, code lost:
    
        if (r6 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0042, code lost:
    
        if (r15 == 1) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.view.Menu r15) {
        /*
            r12 = this;
            j.g$b r0 = new j.g$b
            r0.<init>(r15)
            int r15 = r13.getEventType()
        L9:
            r1 = 2
            java.lang.String r2 = "menu"
            r3 = 1
            if (r15 != r1) goto L35
            java.lang.String r15 = r13.getName()
            boolean r4 = r15.equals(r2)
            if (r4 == 0) goto L1e
            int r15 = r13.next()
            goto L3b
        L1e:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Expecting menu, got "
            r13.append(r14)
            r13.append(r15)
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        L35:
            int r15 = r13.next()
            if (r15 != r3) goto L9
        L3b:
            r4 = 0
            r5 = 0
            r6 = r4
            r7 = r6
            r8 = r5
        L40:
            if (r6 != 0) goto Lc6
            if (r15 == r3) goto Lbe
            java.lang.String r9 = "item"
            java.lang.String r10 = "group"
            if (r15 == r1) goto L8e
            r11 = 3
            if (r15 == r11) goto L4f
            goto Lb9
        L4f:
            java.lang.String r15 = r13.getName()
            if (r7 == 0) goto L5e
            boolean r11 = r15.equals(r8)
            if (r11 == 0) goto L5e
            r7 = r4
            r8 = r5
            goto Lb9
        L5e:
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L68
            r0.h()
            goto Lb9
        L68:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto L86
            boolean r15 = r0.d()
            if (r15 != 0) goto Lb9
            androidx.core.view.b r15 = r0.f33702A
            if (r15 == 0) goto L82
            boolean r15 = r15.hasSubMenu()
            if (r15 == 0) goto L82
            r0.b()
            goto Lb9
        L82:
            r0.a()
            goto Lb9
        L86:
            boolean r15 = r15.equals(r2)
            if (r15 == 0) goto Lb9
            r6 = r3
            goto Lb9
        L8e:
            if (r7 == 0) goto L91
            goto Lb9
        L91:
            java.lang.String r15 = r13.getName()
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L9f
            r0.f(r14)
            goto Lb9
        L9f:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto La9
            r0.g(r14)
            goto Lb9
        La9:
            boolean r9 = r15.equals(r2)
            if (r9 == 0) goto Lb7
            android.view.SubMenu r15 = r0.b()
            r12.c(r13, r14, r15)
            goto Lb9
        Lb7:
            r8 = r15
            r7 = r3
        Lb9:
            int r15 = r13.next()
            goto L40
        Lbe:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException
            java.lang.String r13 = "Unexpected end of document"
            r12.<init>(r13)
            throw r12
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j.C1150g.c(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    @Override // android.view.MenuInflater
    public void inflate(int i10, Menu menu) {
        if (!(menu instanceof D.a)) {
            super.inflate(i10, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        boolean z10 = false;
        try {
            try {
                xmlResourceParser = this.f33697c.getResources().getLayout(i10);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
                if (menu instanceof MenuBuilder) {
                    MenuBuilder menuBuilder = (MenuBuilder) menu;
                    if (menuBuilder.isDispatchingItemsChanged()) {
                        menuBuilder.stopDispatchingItemsChanged();
                        z10 = true;
                    }
                }
                c(xmlResourceParser, asAttributeSet, menu);
                if (z10) {
                    ((MenuBuilder) menu).startDispatchingItemsChanged();
                }
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (IOException e10) {
                throw new InflateException("Error inflating menu XML", e10);
            } catch (XmlPullParserException e11) {
                throw new InflateException("Error inflating menu XML", e11);
            }
        } catch (Throwable th) {
            if (z10) {
                ((MenuBuilder) menu).startDispatchingItemsChanged();
            }
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
