package r5;

import android.content.Context;
import com.heytap.accessory.bean.ServiceProfile;
import com.heytap.accessory.utils.ResourceParserException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import n5.C1371a;

/* compiled from: ConfigUtil.java */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: c, reason: collision with root package name */
    public static final String f36284c = "ConfigUtil";

    /* renamed from: d, reason: collision with root package name */
    public static e f36285d;

    /* renamed from: a, reason: collision with root package name */
    public final Context f36286a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, ServiceProfile> f36287b;

    public e(Context context) {
        this.f36286a = context;
    }

    public static synchronized e c(Context context) {
        e eVar;
        synchronized (e.class) {
            try {
                if (f36285d == null) {
                    f36285d = new e(context);
                }
                eVar = f36285d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    public final synchronized boolean a() {
        synchronized (e.class) {
            try {
                byte[][] e10 = i.c(this.f36286a).e(this.f36286a.getPackageName());
                if (e10 != null) {
                    ArrayList<ServiceProfile> arrayList = new ArrayList();
                    for (byte[] bArr : e10) {
                        try {
                            List<ServiceProfile> d10 = i.d(bArr);
                            if (d10 != null && !d10.isEmpty()) {
                                arrayList.addAll(d10);
                            }
                        } catch (ResourceParserException e11) {
                            throw new ResourceParserException(e11);
                        }
                    }
                    for (ServiceProfile serviceProfile : arrayList) {
                        if (this.f36287b == null) {
                            this.f36287b = new HashMap<>();
                        }
                        this.f36287b.put(serviceProfile.getServiceImpl(), serviceProfile);
                    }
                } else {
                    throw new ResourceParserException("readXml failed");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.f36287b != null) {
            C1371a.c(f36284c, "parse the accessory services size:" + this.f36287b.size());
        } else {
            throw new ResourceParserException("Unable to parse the accessory services configuration file");
        }
        return true;
    }

    public synchronized ServiceProfile b(String str) {
        if (this.f36287b == null) {
            try {
                a();
            } catch (ResourceParserException e10) {
                C1371a.f(f36284c, e10);
            }
        }
        HashMap<String, ServiceProfile> hashMap = this.f36287b;
        if (hashMap != null && hashMap.get(str) != null) {
            return this.f36287b.get(str);
        }
        C1371a.d(f36284c, "fetchServicesDescription: Class not found in registered list" + str);
        return null;
    }

    public synchronized void d(ServiceProfile serviceProfile) {
        try {
            if (this.f36287b == null) {
                this.f36287b = new HashMap<>();
            }
            this.f36287b.put(serviceProfile.getServiceImpl(), serviceProfile);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void e(ServiceProfile serviceProfile) {
        try {
            if (this.f36287b == null) {
                this.f36287b = new HashMap<>();
            }
            this.f36287b.remove(serviceProfile.getServiceImpl());
        } catch (Throwable th) {
            throw th;
        }
    }
}
