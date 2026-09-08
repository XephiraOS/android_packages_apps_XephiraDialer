package m5;

import org.json.JSONObject;

/* compiled from: FTOperateEntity.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f35106a;

    /* renamed from: b, reason: collision with root package name */
    public JSONObject f35107b;

    public c(int i10, JSONObject jSONObject) {
        this.f35106a = i10;
        this.f35107b = jSONObject;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("OpCode", this.f35106a);
        jSONObject.put("Parameters", this.f35107b);
        return jSONObject;
    }
}
