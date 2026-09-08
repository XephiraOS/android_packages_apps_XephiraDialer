package com.android.contacts.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.android.contacts.V0;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.b;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.opencv.imgproc.Imgproc;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ExternalAccountType.java */
/* loaded from: classes.dex */
public class f extends b {

    /* renamed from: B, reason: collision with root package name */
    public static final String[] f17025B = {"android.provider.ALTERNATE_CONTACTS_STRUCTURE", "android.provider.CONTACTS_STRUCTURE"};

    /* renamed from: A, reason: collision with root package name */
    public boolean f17026A;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f17027k;

    /* renamed from: l, reason: collision with root package name */
    public String f17028l;

    /* renamed from: m, reason: collision with root package name */
    public String f17029m;

    /* renamed from: n, reason: collision with root package name */
    public String f17030n;

    /* renamed from: o, reason: collision with root package name */
    public String f17031o;

    /* renamed from: p, reason: collision with root package name */
    public int f17032p;

    /* renamed from: q, reason: collision with root package name */
    public String f17033q;

    /* renamed from: r, reason: collision with root package name */
    public String f17034r;

    /* renamed from: s, reason: collision with root package name */
    public String f17035s;

    /* renamed from: t, reason: collision with root package name */
    public int f17036t;

    /* renamed from: u, reason: collision with root package name */
    public String f17037u;

    /* renamed from: v, reason: collision with root package name */
    public String f17038v;

    /* renamed from: w, reason: collision with root package name */
    public List<String> f17039w;

    /* renamed from: x, reason: collision with root package name */
    public String f17040x;

    /* renamed from: y, reason: collision with root package name */
    public String f17041y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f17042z;

    public f(Context context, String str, boolean z10) {
        this(context, str, z10, null);
    }

    public static XmlResourceParser d0(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Iterator<ResolveInfo> it = packageManager.queryIntentServices(new Intent("android.content.SyncAdapter").setPackage(str), Imgproc.COLOR_BGR2YUV_YV12).iterator();
        while (it.hasNext()) {
            ServiceInfo serviceInfo = it.next().serviceInfo;
            if (serviceInfo != null) {
                for (String str2 : f17025B) {
                    XmlResourceParser loadXmlMetaData = serviceInfo.loadXmlMetaData(packageManager, str2);
                    if (loadXmlMetaData != null) {
                        if (H7.a.b()) {
                            H7.b.b("ExternalAccountType", String.format("Metadata loaded from: %s, %s, %s", serviceInfo.packageName, serviceInfo.name, str2));
                        }
                        return loadXmlMetaData;
                    }
                }
            }
        }
        return null;
    }

    public static int e0(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (str.charAt(0) != '@') {
            H7.b.c("ExternalAccountType", str3 + " must be a resource name beginnig with '@'");
            return -1;
        }
        try {
            int identifier = context.getPackageManager().getResourcesForApplication(str2).getIdentifier(str.substring(1), null, str2);
            if (identifier == 0) {
                H7.b.c("ExternalAccountType", "Unable to load " + str + " from package " + str2);
                return -1;
            }
            return identifier;
        } catch (PackageManager.NameNotFoundException unused) {
            H7.b.c("ExternalAccountType", "Unable to load package " + str2);
            return -1;
        }
    }

    public final void a0(String str) {
        if (j(str) != null) {
            return;
        }
        throw new AccountType.DefinitionException(str + " must be supported");
    }

    @Override // com.android.contacts.model.AccountType
    public boolean b() {
        return this.f17026A;
    }

    public boolean b0() {
        return this.f17042z;
    }

    public void c0(Context context, XmlPullParser xmlPullParser) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        if (context == null) {
            return;
        }
        do {
            try {
                next = xmlPullParser.next();
                if (next == 2) {
                    break;
                }
            } catch (IOException e10) {
                throw new AccountType.DefinitionException("Problem reading XML" + e10);
            } catch (XmlPullParserException e11) {
                throw new AccountType.DefinitionException("Problem reading XML" + e11);
            } catch (Exception e12) {
                H7.b.c("ExternalAccountType", "e = " + e12);
                return;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xmlPullParser.getName();
            if (!"ContactsAccountType".equals(name) && !"ContactsSource".equals(name)) {
                throw new IllegalStateException("Top level element must be ContactsAccountType, not " + name);
            }
            this.f17042z = true;
            int attributeCount = xmlPullParser.getAttributeCount();
            for (int i10 = 0; i10 < attributeCount; i10++) {
                String attributeName = xmlPullParser.getAttributeName(i10);
                String attributeValue = xmlPullParser.getAttributeValue(i10);
                if (Log.isLoggable("ExternalAccountType", 3)) {
                    H7.b.b("ExternalAccountType", attributeName + "=");
                }
                if ("editContactActivity".equals(attributeName)) {
                    this.f17028l = attributeValue;
                } else if ("createContactActivity".equals(attributeName)) {
                    this.f17029m = attributeValue;
                } else if ("inviteContactActivity".equals(attributeName)) {
                    this.f17030n = attributeValue;
                } else if ("inviteContactActionLabel".equals(attributeName)) {
                    this.f17031o = attributeValue;
                } else if ("viewContactNotifyService".equals(attributeName)) {
                    this.f17033q = attributeValue;
                } else if ("viewGroupActivity".equals(attributeName)) {
                    this.f17034r = attributeValue;
                } else if ("viewGroupActionLabel".equals(attributeName)) {
                    this.f17035s = attributeValue;
                } else if ("viewStreamItemActivity".equals(attributeName)) {
                    this.f17037u = attributeValue;
                } else if ("viewStreamItemPhotoActivity".equals(attributeName)) {
                    this.f17038v = attributeValue;
                } else if ("dataSet".equals(attributeName)) {
                    this.f16945b = attributeValue;
                } else if ("extensionPackageNames".equals(attributeName)) {
                    this.f17039w.add(attributeValue);
                } else if ("accountType".equals(attributeName)) {
                    this.f16944a = attributeValue;
                } else if ("accountTypeLabel".equals(attributeName)) {
                    this.f17040x = attributeValue;
                } else if ("accountTypeIcon".equals(attributeName)) {
                    this.f17041y = attributeValue;
                } else {
                    H7.b.c("ExternalAccountType", "Unsupported attribute ");
                }
            }
            int depth = xmlPullParser.getDepth();
            while (true) {
                int next2 = xmlPullParser.next();
                if ((next2 != 3 || xmlPullParser.getDepth() > depth) && next2 != 1) {
                    if (next2 == 2 && xmlPullParser.getDepth() == depth + 1) {
                        String name2 = xmlPullParser.getName();
                        if ("EditSchema".equals(name2)) {
                            this.f17026A = true;
                            Z(context, xmlPullParser, asAttributeSet);
                        } else if ("ContactsDataKind".equals(name2)) {
                            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(asAttributeSet, V0.f13487o2);
                            c cVar = new c();
                            cVar.f17004c = obtainStyledAttributes.getString(1);
                            String string = obtainStyledAttributes.getString(2);
                            if (string != null) {
                                cVar.f17011j = new b.v(string);
                            }
                            String string2 = obtainStyledAttributes.getString(3);
                            if (string2 != null) {
                                cVar.f17013l = new b.v(string2);
                            }
                            obtainStyledAttributes.recycle();
                            a(cVar);
                        }
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("No start tag found");
        }
    }

    @Override // com.android.contacts.model.AccountType
    public String d() {
        return this.f17029m;
    }

    @Override // com.android.contacts.model.AccountType
    public String g() {
        return this.f17028l;
    }

    @Override // com.android.contacts.model.AccountType
    public List<String> h() {
        return this.f17039w;
    }

    @Override // com.android.contacts.model.AccountType
    public String i() {
        return this.f17030n;
    }

    @Override // com.android.contacts.model.AccountType
    public String m() {
        return this.f17033q;
    }

    @Override // com.android.contacts.model.AccountType
    public boolean n() {
        return false;
    }

    @Override // com.android.contacts.model.AccountType
    public boolean o() {
        return this.f17027k;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public f(android.content.Context r3, java.lang.String r4, boolean r5, android.content.res.XmlResourceParser r6) {
        /*
            r2 = this;
            r2.<init>()
            r2.f17027k = r5
            r2.f16946c = r4
            r2.f16947d = r4
            if (r6 != 0) goto L11
            android.content.res.XmlResourceParser r6 = d0(r3, r4)     // Catch: java.lang.Exception -> L10
            goto L11
        L10:
            return
        L11:
            r5 = 1
            if (r6 == 0) goto L1d
            r2.c0(r3, r6)     // Catch: java.lang.Throwable -> L18 com.android.contacts.model.AccountType.DefinitionException -> L1b
            goto L1d
        L18:
            r2 = move-exception
            goto Lce
        L1b:
            r2 = move-exception
            goto L8e
        L1d:
            r0 = 0
            boolean r1 = r2.f17026A     // Catch: java.lang.Throwable -> L18 com.android.contacts.model.AccountType.DefinitionException -> L3f
            if (r1 == 0) goto L42
            java.lang.String r1 = "vnd.android.cursor.item/name"
            r2.a0(r1)     // Catch: java.lang.Throwable -> L18 com.android.contacts.model.AccountType.DefinitionException -> L3f
            java.lang.String r1 = "#displayName"
            r2.a0(r1)     // Catch: java.lang.Throwable -> L18 com.android.contacts.model.AccountType.DefinitionException -> L3f
            java.lang.String r1 = "#phoneticName"
            r2.a0(r1)     // Catch: java.lang.Throwable -> L18 com.android.contacts.model.AccountType.DefinitionException -> L3f
            java.lang.String r1 = "vnd.android.cursor.item/photo"
            r2.a0(r1)     // Catch: java.lang.Throwable -> L18 com.android.contacts.model.AccountType.DefinitionException -> L3f
            r2.H(r3)     // Catch: java.lang.Throwable -> L18 com.android.contacts.model.AccountType.DefinitionException -> L3f
            r2.M(r3)     // Catch: java.lang.Throwable -> L18 com.android.contacts.model.AccountType.DefinitionException -> L3f
            goto L4e
        L3f:
            r2 = move-exception
            r5 = r0
            goto L8e
        L42:
            r2.J(r3)     // Catch: java.lang.Throwable -> L18 com.android.contacts.model.AccountType.DefinitionException -> L3f
            r2.y(r3)     // Catch: java.lang.Throwable -> L18 com.android.contacts.model.AccountType.DefinitionException -> L3f
            r2.D(r3)     // Catch: java.lang.Throwable -> L18 com.android.contacts.model.AccountType.DefinitionException -> L3f
            r2.E(r3)     // Catch: java.lang.Throwable -> L18 com.android.contacts.model.AccountType.DefinitionException -> L3f
        L4e:
            if (r6 == 0) goto L53
            r6.close()
        L53:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r2.f17039w = r4
            java.lang.String r4 = r2.f17031o
            java.lang.String r6 = r2.f16947d
            java.lang.String r0 = "inviteContactActionLabel"
            int r4 = e0(r3, r4, r6, r0)
            r2.f17032p = r4
            java.lang.String r4 = r2.f17035s
            java.lang.String r6 = r2.f16947d
            java.lang.String r0 = "viewGroupActionLabel"
            int r4 = e0(r3, r4, r6, r0)
            r2.f17036t = r4
            java.lang.String r4 = r2.f17040x
            java.lang.String r6 = r2.f16946c
            java.lang.String r0 = "accountTypeLabel"
            int r4 = e0(r3, r4, r6, r0)
            r2.f16948e = r4
            java.lang.String r4 = r2.f17041y
            java.lang.String r6 = r2.f16946c
            java.lang.String r0 = "accountTypeIcon"
            int r3 = e0(r3, r4, r6, r0)
            r2.f16949f = r3
            r2.f16950g = r5
            return
        L8e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L18
            r3.<init>()     // Catch: java.lang.Throwable -> L18
            java.lang.String r0 = "Problem reading XML"
            r3.append(r0)     // Catch: java.lang.Throwable -> L18
            if (r5 == 0) goto La8
            if (r6 == 0) goto La8
            java.lang.String r5 = " in line "
            r3.append(r5)     // Catch: java.lang.Throwable -> L18
            int r5 = r6.getLineNumber()     // Catch: java.lang.Throwable -> L18
            r3.append(r5)     // Catch: java.lang.Throwable -> L18
        La8:
            java.lang.String r5 = " for external package "
            r3.append(r5)     // Catch: java.lang.Throwable -> L18
            r3.append(r4)     // Catch: java.lang.Throwable -> L18
            java.lang.String r4 = "ExternalAccountType"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L18
            r5.<init>()     // Catch: java.lang.Throwable -> L18
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L18
            r5.append(r3)     // Catch: java.lang.Throwable -> L18
            r5.append(r2)     // Catch: java.lang.Throwable -> L18
            java.lang.String r2 = r5.toString()     // Catch: java.lang.Throwable -> L18
            H7.b.c(r4, r2)     // Catch: java.lang.Throwable -> L18
            if (r6 == 0) goto Lcd
            r6.close()
        Lcd:
            return
        Lce:
            if (r6 == 0) goto Ld3
            r6.close()
        Ld3:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.model.f.<init>(android.content.Context, java.lang.String, boolean, android.content.res.XmlResourceParser):void");
    }
}
