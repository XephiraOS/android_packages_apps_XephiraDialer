package G5;

import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: ProviderInfo.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f1120a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, b> f1121b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, Method> f1122c;

    public Method a(String str) {
        Method method = this.f1122c.get(str);
        if (method != null) {
            return method;
        }
        b bVar = this.f1121b.get(str);
        try {
            Method declaredMethod = Class.forName(this.f1120a).getDeclaredMethod(bVar.a(), b(bVar.b()));
            this.f1122c.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            return null;
        }
    }

    public final Class<?>[] b(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            int length = strArr.length;
            Class<?>[] clsArr = new Class[length];
            for (int i10 = 0; i10 < length; i10++) {
                clsArr[i10] = Class.forName(strArr[i10]);
            }
            return clsArr;
        }
        return null;
    }
}
