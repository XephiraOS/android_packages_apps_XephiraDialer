package r5;

import android.content.Context;
import com.heytap.accessory.Initializer;
import com.heytap.accessory.api.ManagerConfig;
import com.heytap.accessory.bean.ServiceProfile;
import com.heytap.accessory.utils.ResourceParserException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import n5.C1371a;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import t5.C1592a;

/* compiled from: ServiceXmlReader.java */
/* loaded from: classes3.dex */
public class i {

    /* renamed from: b, reason: collision with root package name */
    public static final String f36295b = "ServiceXmlReader";

    /* renamed from: c, reason: collision with root package name */
    public static i f36296c;

    /* renamed from: a, reason: collision with root package name */
    public final Context f36297a;

    public i(Context context) {
        if (context != null) {
            this.f36297a = context;
            return;
        }
        throw new IllegalArgumentException("Invalid context:" + ((Object) null));
    }

    public static synchronized i c(Context context) {
        i iVar;
        synchronized (i.class) {
            try {
                if (f36296c == null) {
                    f36296c = new i(context.getApplicationContext());
                }
                iVar = f36296c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    public static synchronized List<ServiceProfile> d(byte[] bArr) {
        synchronized (i.class) {
            if (bArr == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                C1371a.c(f36295b, "Start parseServicesXML");
                synchronized (i.class) {
                    String str = new String(bArr, 0, bArr.length);
                    try {
                        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
                        newInstance.setNamespaceAware(true);
                        XmlPullParser newPullParser = newInstance.newPullParser();
                        if (newPullParser != null) {
                            newPullParser.setInput(new StringReader(str));
                        }
                        if (newPullParser == null) {
                            return null;
                        }
                        C1592a c1592a = new C1592a();
                        try {
                            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                                if (eventType == 3) {
                                    if (c1592a.n(newPullParser)) {
                                        arrayList.add(c1592a.f());
                                        c1592a.p();
                                    }
                                } else if (eventType == 2) {
                                    c1592a.o(newPullParser);
                                }
                            }
                            if (arrayList.isEmpty()) {
                                C1371a.k(f36295b, "End parse profile: Unable to parse the accessory services configuration file");
                            } else {
                                C1371a.c(f36295b, "End parse profile:" + arrayList);
                            }
                            return arrayList;
                        } catch (IOException | XmlPullParserException e10) {
                            throw new ResourceParserException(e10);
                        }
                    } catch (XmlPullParserException unused) {
                        throw new ResourceParserException("XmlPullParserFactory Exception for Accssory Service profile XML file");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(5:25|26|5|6|(2:12|(1:(2:18|19)(2:20|21))(2:15|16))(2:9|10))(1:3)|4|5|6|(0)|12|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002a, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002b, code lost:
    
        n5.C1371a.e(r5.i.f36295b, "get serviceConfig failed", r4);
        r4 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String[] a(java.lang.String r5) {
        /*
            r4 = this;
            boolean r0 = r4.b(r5)
            r1 = 0
            if (r0 == 0) goto L19
            android.content.Context r0 = r4.f36297a     // Catch: com.heytap.accessory.utils.ResourceParserException -> L10
            java.lang.String r2 = "InternalAccessoryServicesLocation"
            java.lang.String r0 = r5.k.b(r0, r5, r2)     // Catch: com.heytap.accessory.utils.ResourceParserException -> L10
            goto L21
        L10:
            r0 = move-exception
            java.lang.String r2 = r5.i.f36295b
            java.lang.String r3 = "get internalServiceConfig failed"
            n5.C1371a.e(r2, r3, r0)
            goto L20
        L19:
            java.lang.String r0 = r5.i.f36295b
            java.lang.String r2 = "no need to get internal config in third app"
            n5.C1371a.k(r0, r2)
        L20:
            r0 = r1
        L21:
            android.content.Context r4 = r4.f36297a     // Catch: com.heytap.accessory.utils.ResourceParserException -> L2a
            java.lang.String r2 = "AccessoryServicesLocation"
            java.lang.String r4 = r5.k.b(r4, r5, r2)     // Catch: com.heytap.accessory.utils.ResourceParserException -> L2a
            goto L33
        L2a:
            r4 = move-exception
            java.lang.String r5 = r5.i.f36295b
            java.lang.String r2 = "get serviceConfig failed"
            n5.C1371a.e(r5, r2, r4)
            r4 = r1
        L33:
            if (r0 != 0) goto L3f
            if (r4 != 0) goto L3f
            java.lang.String r4 = r5.i.f36295b
            java.lang.String r5 = "No meta data found with key:AccessoryServicesLocation"
            n5.C1371a.d(r4, r5)
            goto La3
        L3f:
            java.lang.String r5 = "internalServiceConfig : "
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L61
            if (r4 != 0) goto L61
            java.lang.String[] r4 = new java.lang.String[r2]
            r4[r1] = r0
            java.lang.String r1 = r5.i.f36295b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r2.append(r0)
            java.lang.String r5 = r2.toString()
            n5.C1371a.g(r1, r5)
            r1 = r4
            goto La3
        L61:
            if (r0 != 0) goto L7f
            java.lang.String[] r5 = new java.lang.String[r2]
            r5[r1] = r4
            java.lang.String r0 = r5.i.f36295b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "serviceConfig : "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            n5.C1371a.g(r0, r4)
            r1 = r5
            goto La3
        L7f:
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]
            r3[r1] = r4
            r3[r2] = r0
            java.lang.String r1 = r5.i.f36295b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r2.append(r0)
            java.lang.String r5 = " serviceConfig : "
            r2.append(r5)
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            n5.C1371a.g(r1, r4)
            r1 = r3
        La3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: r5.i.a(java.lang.String):java.lang.String[]");
    }

    public final boolean b(String str) {
        if ((Initializer.useOAFApp() && str.equals(ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE)) || (Initializer.useOAFApp() && str.equals(this.f36297a.getPackageName()))) {
            return true;
        }
        return false;
    }

    public synchronized byte[][] e(String str) {
        String[] a10 = a(str);
        if (a10 == null) {
            C1371a.k(f36295b, "configFileLocationGroup is empty,config error with " + str);
            return null;
        }
        byte[][] bArr = new byte[a10.length];
        for (int i10 = 0; i10 < a10.length; i10++) {
            String str2 = a10[i10];
            if (str2 != null) {
                bArr[i10] = k.e(this.f36297a, str, str2);
            }
        }
        return bArr;
    }
}
