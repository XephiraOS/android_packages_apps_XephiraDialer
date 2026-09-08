package p8;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: ServiceMap.java */
/* renamed from: p8.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1465b {

    /* renamed from: a, reason: collision with root package name */
    public static final List<InterfaceC1464a> f36103a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f36104b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final List<String> f36105c = new CopyOnWriteArrayList();

    /* renamed from: d, reason: collision with root package name */
    public static final List<String> f36106d = Arrays.asList("android.view.IWindowManager");

    public static String a(String str, int i10) {
        Map<String, String> map = f36104b;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        for (InterfaceC1464a interfaceC1464a : f36103a) {
            if (TextUtils.equals(interfaceC1464a.a(), str)) {
                return interfaceC1464a.b(i10);
            }
        }
        C1466c c1466c = new C1466c(str);
        f36103a.add(c1466c);
        return c1466c.b(i10);
    }

    public static void b() {
        Iterator<String> it = f36106d.iterator();
        while (it.hasNext()) {
            f36103a.add(new C1466c(it.next()));
        }
        Map<String, String> map = f36104b;
        map.put("android.view.IWindowSession", "IWindowSession");
        map.put("android.view.IWindowManager", "IWindowSession");
        f36105c.add("android.view.IWindowSession");
        map.put("android.content.pm.IPackageInstaller", "PackageInstaller.Session");
        map.put("android.content.pm.IPackageInstallerSession", "PackageInstaller.Session");
    }

    public static boolean c(String str) {
        return f36105c.contains(str);
    }
}
