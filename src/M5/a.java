package M5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: ServiceMap.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static List<Object> f1773a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, String> f1774b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public static List<String> f1775c = new ArrayList(Arrays.asList("android.app.IActivityManager", "android.content.pm.IPackageManager", "android.view.IWindowManager"));

    public static void a() {
        Iterator<String> it = f1775c.iterator();
        while (it.hasNext()) {
            f1773a.add(new b(it.next()));
        }
        f1774b.put("android.view.IWindowSession", "IWindowSession");
        f1774b.put("android.view.IWindowManager", "IWindowSession");
        f1774b.put("android.content.pm.IPackageInstaller", "PackageInstaller.Session");
        f1774b.put("android.content.pm.IPackageInstallerSession", "PackageInstaller.Session");
    }
}
