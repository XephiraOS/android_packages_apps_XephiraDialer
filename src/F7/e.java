package f7;

import com.oplus.epona.h;
import com.oplus.epona.provider.ProviderInfo;
import com.oplus.epona.provider.ProviderMethodInfo;
import com.oplus.utils.C0864z;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProviderRepo.java */
/* loaded from: classes3.dex */
public class e implements h {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, com.oplus.epona.c> f31778a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, ProviderInfo> f31779b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f31780c = new ConcurrentHashMap<>();

    @Override // com.oplus.epona.h
    public com.oplus.epona.c a(String str) {
        return this.f31778a.get(str);
    }

    @Override // com.oplus.epona.h
    public ProviderInfo b(String str) {
        return this.f31779b.get(str);
    }

    @Override // com.oplus.epona.h
    public void c(PrintWriter printWriter) {
        printWriter.println("---------start dump epona register info---------");
        e(printWriter);
        f(printWriter);
        printWriter.println("-------------------- end -----------------------");
    }

    public final Map<String, ProviderMethodInfo> d(ProviderInfo providerInfo) {
        if (providerInfo == null) {
            return null;
        }
        try {
            Field declaredField = providerInfo.getClass().getDeclaredField("mMethods");
            declaredField.setAccessible(true);
            return (Map) declaredField.get(providerInfo);
        } catch (Exception e10) {
            C0864z.d("Epona->ProviderRepo", e10.toString(), new Object[0]);
            return null;
        }
    }

    public final void e(PrintWriter printWriter) {
        if (this.f31778a.isEmpty()) {
            printWriter.println("Dynamic register provider is empty\n");
            return;
        }
        printWriter.println("dynamic:");
        for (Map.Entry<String, com.oplus.epona.c> entry : this.f31778a.entrySet()) {
            if (entry.getValue().getName() != null) {
                printWriter.println(entry.getValue().getName());
            }
        }
        printWriter.println("");
    }

    public final void f(PrintWriter printWriter) {
        if (this.f31779b.isEmpty()) {
            printWriter.println("Auto register provider is empty\n");
            return;
        }
        printWriter.println("static:");
        Iterator<Map.Entry<String, ProviderInfo>> it = this.f31779b.entrySet().iterator();
        while (it.hasNext()) {
            ProviderInfo value = it.next().getValue();
            String name = value.getName();
            if (name != null) {
                printWriter.println(name + " : ");
            }
            Map<String, ProviderMethodInfo> d10 = d(value);
            if (d10 != null) {
                for (Map.Entry<String, ProviderMethodInfo> entry : d10.entrySet()) {
                    if (entry != null) {
                        printWriter.println("    -> " + entry.getValue().getMethodName());
                    }
                }
            }
            printWriter.println("");
        }
    }
}
