package m5;

import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MultiTransferErrorMsg.java */
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public int[] f35130a = null;

    /* renamed from: b, reason: collision with root package name */
    public int f35131b = -1;

    /* renamed from: c, reason: collision with root package name */
    public String f35132c = "";

    public void a(Object obj) {
        JSONObject jSONObject = new JSONObject((String) obj);
        JSONArray jSONArray = jSONObject.getJSONArray("id");
        this.f35131b = jSONObject.getInt("errorCode");
        this.f35132c = jSONObject.getString("errorMsg");
        this.f35130a = new int[jSONArray.length()];
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            this.f35130a[i10] = jSONArray.getInt(i10);
        }
    }

    public int b() {
        return this.f35131b;
    }

    public int[] c() {
        return this.f35130a;
    }
}
