package p5;

import org.json.JSONObject;

/* compiled from: STOperateEntity.java */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public int f36028a;

    /* renamed from: b, reason: collision with root package name */
    public JSONObject f36029b;

    public e(int i10, JSONObject jSONObject) {
        this.f36028a = i10;
        this.f36029b = jSONObject;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("OpCode", this.f36028a);
        jSONObject.put("Parameters", this.f36029b);
        return jSONObject;
    }
}
