package y8;

import java.util.Map;
import org.json.JSONObject;
import s8.C1562e;

/* compiled from: CastUtil.java */
/* renamed from: y8.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1713e {
    public static JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null && !map.isEmpty()) {
            try {
                for (String str : map.keySet()) {
                    jSONObject.put(str, map.get(str));
                }
            } catch (Exception e10) {
                C1714f.b("CastUtil", new C1562e(e10));
            }
        }
        return jSONObject;
    }
}
