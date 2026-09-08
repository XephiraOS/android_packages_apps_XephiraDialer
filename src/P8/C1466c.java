package p8;

import java.lang.reflect.Field;
import java.util.HashMap;

/* compiled from: SystemServiceMap.java */
/* renamed from: p8.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1466c implements InterfaceC1464a {

    /* renamed from: a, reason: collision with root package name */
    public HashMap<Integer, String> f36107a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public String f36108b;

    public C1466c(String str) {
        this.f36108b = str;
        c();
    }

    @Override // p8.InterfaceC1464a
    public String a() {
        return this.f36108b;
    }

    @Override // p8.InterfaceC1464a
    public String b(int i10) {
        if (this.f36107a.containsKey(Integer.valueOf(i10))) {
            return this.f36107a.get(Integer.valueOf(i10));
        }
        return null;
    }

    public final void c() {
        try {
            Class<?> cls = Class.forName(this.f36108b + "$Stub");
            for (Field field : cls.getDeclaredFields()) {
                if (field.getName().startsWith("TRANSACTION_")) {
                    field.setAccessible(true);
                    this.f36107a.put(Integer.valueOf(field.getInt(cls)), field.getName().replaceFirst("TRANSACTION_", ""));
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException e10) {
            e10.printStackTrace();
        }
    }
}
