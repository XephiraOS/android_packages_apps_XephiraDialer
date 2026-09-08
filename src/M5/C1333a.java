package m5;

import org.json.JSONObject;

/* compiled from: CancelAllRequest.java */
/* renamed from: m5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1333a {

    /* renamed from: a, reason: collision with root package name */
    public String f35103a;

    public C1333a(String str) {
        this.f35103a = str;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("AgentId", this.f35103a);
        return jSONObject;
    }
}
