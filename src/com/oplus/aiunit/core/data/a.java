package com.oplus.aiunit.core.data;

import android.os.Bundle;
import com.oplus.aiunit.core.data.AIConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: l, reason: collision with root package name */
    public static final C0234a f25594l = new C0234a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f25595a;

    /* renamed from: b, reason: collision with root package name */
    public Bundle f25596b;

    /* renamed from: c, reason: collision with root package name */
    public int f25597c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f25598d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f25599e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f25600f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f25601g;

    /* renamed from: h, reason: collision with root package name */
    public int f25602h;

    /* renamed from: i, reason: collision with root package name */
    public long f25603i;

    /* renamed from: j, reason: collision with root package name */
    public String f25604j;

    /* renamed from: k, reason: collision with root package name */
    public List<AIConfig> f25605k;

    /* renamed from: com.oplus.aiunit.core.data.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0234a {
        public C0234a() {
        }

        public /* synthetic */ C0234a(f fVar) {
            this();
        }
    }

    public a(String str) {
        this.f25595a = str;
        this.f25596b = new Bundle();
    }

    public final int a() {
        if (!i.b(this.f25595a, "aigc_call_summary") && !i.b(this.f25595a, "aigc_sdinpainting") && !i.b(this.f25595a, "aigc_article_summary") && !i.b(this.f25595a, "aigc_segmentation") && !i.b(this.f25595a, "audio_asr")) {
            return 0;
        }
        return 1;
    }

    public final int b() {
        return this.f25597c;
    }

    public final boolean c() {
        return this.f25598d;
    }

    public String toString() {
        return "DetectData(" + this.f25595a + ", " + this.f25597c + ", " + this.f25598d + ", " + this.f25599e + ", " + this.f25605k + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(String name, Bundle data) {
        this(name);
        i.f(name, "name");
        i.f(data, "data");
        this.f25596b = data;
        data.setClassLoader(SimpleUnitInfo.class.getClassLoader());
        this.f25597c = data.getInt("ai::key::detect_data_state", 0);
        this.f25599e = data.getBoolean("ai::key::detect_data_available", false);
        this.f25600f = data.getBoolean("ai::key::detect_data_unavailable_self", false);
        this.f25598d = data.getBoolean("package::unit_supported", false);
        if (data.containsKey("package::unit_supported") && !this.f25598d && !this.f25600f) {
            this.f25598d = true;
        }
        if (!this.f25598d && this.f25599e) {
            this.f25598d = true;
        }
        this.f25601g = data.getBoolean("ai::key::detect_data_llm", false);
        int i10 = data.getInt("ai::key::detect_data_run_type", -1);
        this.f25602h = i10;
        if (i10 == -1) {
            int a10 = a();
            this.f25602h = a10;
            data.putInt("ai::key::detect_data_run_type", a10);
        }
        this.f25603i = data.getLong("ai::key::detect_download_size", 0L);
        this.f25604j = data.getString("ai::key::unit_config_custom", null);
        String string = data.getString("package::ai_config_list", "");
        if (string == null || string.length() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Result.a aVar = Result.f34166a;
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                AIConfig.a aVar2 = AIConfig.f25576g;
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                i.e(jSONObject, "getJSONObject(...)");
                arrayList.add(aVar2.a(jSONObject));
            }
            this.f25605k = arrayList;
            Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar3 = Result.f34166a;
            Result.b(b.a(th));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(String name, boolean z10) {
        this(name);
        i.f(name, "name");
        this.f25599e = z10;
        this.f25597c = z10 ? 1 : 0;
        this.f25600f = !z10;
        this.f25598d = z10;
        this.f25601g = i.b(name, "aigc_call_summary") || i.b(name, "aigc_sdinpainting") || i.b(name, "aigc_article_summary");
        this.f25602h = a();
        Bundle bundle = new Bundle();
        bundle.setClassLoader(SimpleUnitInfo.class.getClassLoader());
        bundle.putBoolean("ai::key::detect_data_available", this.f25599e);
        bundle.putInt("ai::key::detect_data_state", this.f25597c);
        bundle.putBoolean("ai::key::detect_data_unavailable_self", this.f25600f);
        bundle.putBoolean("package::unit_supported", this.f25598d);
        bundle.putBoolean("ai::key::detect_data_llm", this.f25601g);
        bundle.putInt("ai::key::detect_data_run_type", this.f25602h);
        this.f25596b = bundle;
    }
}
