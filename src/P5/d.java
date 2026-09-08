package p5;

import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MultiTransferErrorMsg.java */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public int[] f36025a = null;

    /* renamed from: b, reason: collision with root package name */
    public int f36026b = -1;

    /* renamed from: c, reason: collision with root package name */
    public String f36027c = "";

    public void a(Object obj) {
        JSONObject jSONObject = new JSONObject((String) obj);
        JSONArray jSONArray = jSONObject.getJSONArray("id");
        this.f36026b = jSONObject.getInt("errorCode");
        this.f36027c = jSONObject.getString("errorMsg");
        this.f36025a = new int[jSONArray.length()];
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            this.f36025a[i10] = jSONArray.getInt(i10);
        }
    }

    public int b() {
        return this.f36026b;
    }

    public int[] c() {
        return this.f36025a;
    }
}
