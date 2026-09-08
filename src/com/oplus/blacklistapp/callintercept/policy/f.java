package com.oplus.blacklistapp.callintercept.policy;

import android.graphics.drawable.Drawable;
import com.oplus.utils.C0846g;

/* compiled from: YellowPageInfo.java */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public String f26718a;

    /* renamed from: b, reason: collision with root package name */
    public String f26719b;

    /* renamed from: c, reason: collision with root package name */
    public String f26720c;

    /* renamed from: d, reason: collision with root package name */
    public String f26721d;

    /* renamed from: e, reason: collision with root package name */
    public String f26722e;

    /* renamed from: f, reason: collision with root package name */
    public int f26723f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f26724g = 0;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f26725h;

    /* renamed from: i, reason: collision with root package name */
    public int f26726i;

    /* renamed from: j, reason: collision with root package name */
    public int f26727j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f26728k;

    /* compiled from: YellowPageInfo.java */
    /* loaded from: classes3.dex */
    public interface a {
        void a(f fVar);
    }

    public static String b(int i10) {
        switch (i10) {
            case 0:
                return "QUERY_STATE_NOT_STARTED";
            case 1:
                return "QUERY_STATE_STARTED";
            case 2:
                return "QUERY_STATE_INFO_COMPLETE";
            case 3:
                return "QUERY_STATE_PHOTO_COMPLETE";
            case 4:
                return "QUERY_STATE_LOCATION_COMPLETE";
            case 5:
                return "QUERY_STATE_CALL_LOG_COMPLETE";
            case 6:
                return "QUERY_CUSTOM_RECORD_COMPLETE";
            default:
                return "Unkonw State";
        }
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public f clone() {
        f fVar = new f();
        fVar.f26718a = this.f26718a;
        fVar.f26719b = this.f26719b;
        fVar.f26720c = this.f26720c;
        fVar.f26721d = this.f26721d;
        fVar.f26722e = this.f26722e;
        fVar.f26724g = this.f26724g;
        fVar.f26723f = this.f26723f;
        fVar.f26725h = this.f26725h;
        fVar.f26726i = this.f26726i;
        fVar.f26727j = this.f26727j;
        fVar.f26728k = this.f26728k;
        return fVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("YellowPageInfo{ ");
        sb.append("  number: " + C0846g.f(this.f26718a));
        sb.append("  oriNumber: " + C0846g.f(this.f26719b));
        sb.append("  queryState: " + this.f26726i);
        sb.append("  name: ");
        sb.append("  markInfo: " + this.f26721d);
        sb.append("  markInfoCounter: " + this.f26722e);
        sb.append("  markInfoCount: " + this.f26724g);
        sb.append("  markInfoType: " + this.f26723f);
        sb.append("  photo: " + this.f26725h);
        sb.append("  slotId: " + this.f26727j);
        sb.append("  isAntiFraudCenterNumber: " + this.f26728k);
        sb.append(" }\n");
        return sb.toString();
    }
}
