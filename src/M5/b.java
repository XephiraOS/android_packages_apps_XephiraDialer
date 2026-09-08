package M5;

import java.lang.reflect.Field;
import java.util.HashMap;

/* compiled from: SystemServiceMap.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public HashMap<Integer, String> f1776a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public String f1777b;

    public b(String str) {
        this.f1777b = str;
        a();
    }

    public final void a() {
        try {
            Class<?> cls = Class.forName(this.f1777b + "$Stub");
            for (Field field : cls.getDeclaredFields()) {
                if (field.getName().startsWith("TRANSACTION_")) {
                    field.setAccessible(true);
                    this.f1776a.put(Integer.valueOf(field.getInt(cls)), field.getName().replaceFirst("TRANSACTION_", ""));
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException e10) {
            e10.printStackTrace();
        }
    }
}
