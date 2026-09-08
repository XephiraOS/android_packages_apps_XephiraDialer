package com.android.contacts.util;

import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.res.XmlResourceParser;
import org.opencv.imgproc.Imgproc;

/* compiled from: LocalizedNameResolver.java */
/* loaded from: classes.dex */
public class p {
    public static String a(Context context, String str) {
        if (context != null) {
            if (str == null) {
                return null;
            }
            return c(context, str);
        }
        throw new IllegalArgumentException("Context must not be null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0074, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002c, code lost:
    
        r6 = r9.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
    
        if (r5 != 2) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0038, code lost:
    
        if ("ContactsDataKind".equals(r6) == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003a, code lost:
    
        r9 = r8.obtainStyledAttributes(r1, com.android.contacts.V0.f13487o2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0041, code lost:
    
        r2 = r9.getNonResourceString(5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0045, code lost:
    
        if (r2 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0047, code lost:
    
        r9.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004a, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004c, code lost:
    
        r1 = r9.getResourceId(5, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0050, code lost:
    
        if (r1 != 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0052, code lost:
    
        r9.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0055, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x005e, code lost:
    
        r8 = r8.getPackageManager().getResourcesForApplication(r10).getString(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0062, code lost:
    
        r9.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0065, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0068, code lost:
    
        r9.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x006b, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x006c, code lost:
    
        r9.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x006f, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0066, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0070, code lost:
    
        r9.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0073, code lost:
    
        throw r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(android.content.Context r8, org.xmlpull.v1.XmlPullParser r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "Problem reading XML"
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r9)     // Catch: java.io.IOException -> L26 org.xmlpull.v1.XmlPullParserException -> L28
        L6:
            int r2 = r9.next()     // Catch: java.io.IOException -> L26 org.xmlpull.v1.XmlPullParserException -> L28
            r3 = 1
            r4 = 2
            if (r2 == r4) goto L11
            if (r2 == r3) goto L11
            goto L6
        L11:
            if (r2 != r4) goto L75
            int r2 = r9.getDepth()     // Catch: java.io.IOException -> L26 org.xmlpull.v1.XmlPullParserException -> L28
        L17:
            int r5 = r9.next()     // Catch: java.io.IOException -> L26 org.xmlpull.v1.XmlPullParserException -> L28
            r6 = 3
            r7 = 0
            if (r5 != r6) goto L2a
            int r6 = r9.getDepth()     // Catch: java.io.IOException -> L26 org.xmlpull.v1.XmlPullParserException -> L28
            if (r6 <= r2) goto L74
            goto L2a
        L26:
            r8 = move-exception
            goto L7d
        L28:
            r8 = move-exception
            goto L92
        L2a:
            if (r5 == r3) goto L74
            java.lang.String r6 = r9.getName()     // Catch: java.io.IOException -> L26 org.xmlpull.v1.XmlPullParserException -> L28
            if (r5 != r4) goto L17
            java.lang.String r5 = "ContactsDataKind"
            boolean r5 = r5.equals(r6)     // Catch: java.io.IOException -> L26 org.xmlpull.v1.XmlPullParserException -> L28
            if (r5 == 0) goto L17
            int[] r9 = com.android.contacts.V0.f13487o2     // Catch: java.io.IOException -> L26 org.xmlpull.v1.XmlPullParserException -> L28
            android.content.res.TypedArray r9 = r8.obtainStyledAttributes(r1, r9)     // Catch: java.io.IOException -> L26 org.xmlpull.v1.XmlPullParserException -> L28
            r1 = 5
            java.lang.String r2 = r9.getNonResourceString(r1)     // Catch: java.lang.Throwable -> L66
            if (r2 == 0) goto L4b
            r9.recycle()     // Catch: java.io.IOException -> L26 org.xmlpull.v1.XmlPullParserException -> L28
            return r2
        L4b:
            r2 = 0
            int r1 = r9.getResourceId(r1, r2)     // Catch: java.lang.Throwable -> L66
            if (r1 != 0) goto L56
            r9.recycle()     // Catch: java.io.IOException -> L26 org.xmlpull.v1.XmlPullParserException -> L28
            return r7
        L56:
            android.content.pm.PackageManager r8 = r8.getPackageManager()     // Catch: java.lang.Throwable -> L66
            android.content.res.Resources r8 = r8.getResourcesForApplication(r10)     // Catch: java.lang.Throwable -> L66 android.content.pm.PackageManager.NameNotFoundException -> L6c
            java.lang.String r8 = r8.getString(r1)     // Catch: java.lang.Throwable -> L66 android.content.res.Resources.NotFoundException -> L68
            r9.recycle()     // Catch: java.io.IOException -> L26 org.xmlpull.v1.XmlPullParserException -> L28
            return r8
        L66:
            r8 = move-exception
            goto L70
        L68:
            r9.recycle()     // Catch: java.io.IOException -> L26 org.xmlpull.v1.XmlPullParserException -> L28
            return r7
        L6c:
            r9.recycle()     // Catch: java.io.IOException -> L26 org.xmlpull.v1.XmlPullParserException -> L28
            return r7
        L70:
            r9.recycle()     // Catch: java.io.IOException -> L26 org.xmlpull.v1.XmlPullParserException -> L28
            throw r8     // Catch: java.io.IOException -> L26 org.xmlpull.v1.XmlPullParserException -> L28
        L74:
            return r7
        L75:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch: java.io.IOException -> L26 org.xmlpull.v1.XmlPullParserException -> L28
            java.lang.String r9 = "No start tag found"
            r8.<init>(r9)     // Catch: java.io.IOException -> L26 org.xmlpull.v1.XmlPullParserException -> L28
            throw r8     // Catch: java.io.IOException -> L26 org.xmlpull.v1.XmlPullParserException -> L28
        L7d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.<init>(r8)
            throw r9
        L92:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.util.p.b(android.content.Context, org.xmlpull.v1.XmlPullParser, java.lang.String):java.lang.String");
    }

    public static String c(Context context, String str) {
        for (AuthenticatorDescription authenticatorDescription : AccountManager.get(context).getAuthenticatorTypes()) {
            if (str.equals(authenticatorDescription.type)) {
                return d(context, authenticatorDescription.packageName);
            }
        }
        return null;
    }

    public static String d(Context context, String str) {
        ServiceInfo[] serviceInfoArr;
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, Imgproc.COLOR_BGR2YUV_YV12);
            if (packageInfo != null && (serviceInfoArr = packageInfo.services) != null) {
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    XmlResourceParser loadXmlMetaData = serviceInfo.loadXmlMetaData(packageManager, "android.provider.CONTACTS_STRUCTURE");
                    if (loadXmlMetaData != null) {
                        return b(context, loadXmlMetaData, str);
                    }
                }
                return null;
            }
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            H7.b.i("LocalizedNameResolver", "Problem loading \"All Contacts\"-name: " + e10.toString());
            return null;
        } catch (Exception e11) {
            H7.b.i("LocalizedNameResolver", "Problem loading \"All Contacts\"-name: " + e11.toString());
            return null;
        }
    }
}
