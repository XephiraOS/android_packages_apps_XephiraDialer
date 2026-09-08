package m5;

import com.heytap.accessory.constant.AFConstants;
import com.oplus.backup.sdk.common.utils.Constants;
import org.json.JSONObject;

/* compiled from: FileReceiveEntity.java */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public int f35114a;

    /* renamed from: b, reason: collision with root package name */
    public String f35115b;

    /* renamed from: c, reason: collision with root package name */
    public String f35116c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f35117d;

    /* renamed from: e, reason: collision with root package name */
    public long f35118e;

    public e(long j10, int i10, String str, String str2, boolean z10) {
        this.f35118e = j10;
        this.f35114a = i10;
        this.f35115b = str;
        this.f35117d = z10;
        this.f35116c = str2;
    }

    public static e a(long j10, int i10, String str, String str2, boolean z10) {
        return new e(j10, i10, str, str2, z10);
    }

    public static e b(long j10, int i10) {
        return a(j10, i10, "", "", false);
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.f35114a);
        jSONObject.put(Constants.MessagerConstants.PATH_KEY, this.f35115b);
        jSONObject.put("fileuri", this.f35116c);
        jSONObject.put("accepted", this.f35117d);
        jSONObject.put(AFConstants.EXTRA_CONNECTION_ID, this.f35118e);
        return jSONObject;
    }
}
