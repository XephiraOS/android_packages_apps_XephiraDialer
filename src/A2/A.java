package A2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;

/* compiled from: YellowPageInfo.java */
/* loaded from: classes.dex */
public class A {

    /* renamed from: a, reason: collision with root package name */
    public String f93a;

    /* renamed from: b, reason: collision with root package name */
    public String f94b;

    /* renamed from: c, reason: collision with root package name */
    public String f95c;

    /* renamed from: d, reason: collision with root package name */
    public String f96d;

    /* renamed from: e, reason: collision with root package name */
    public String f97e;

    /* renamed from: f, reason: collision with root package name */
    public String f98f;

    /* renamed from: g, reason: collision with root package name */
    public int f99g = -1;

    /* renamed from: h, reason: collision with root package name */
    public int f100h = 0;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f101i;

    /* renamed from: j, reason: collision with root package name */
    public String f102j;

    /* renamed from: k, reason: collision with root package name */
    public int f103k;

    /* renamed from: l, reason: collision with root package name */
    public int f104l;

    /* renamed from: m, reason: collision with root package name */
    public String f105m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f106n;

    /* renamed from: o, reason: collision with root package name */
    public Uri f107o;

    /* compiled from: YellowPageInfo.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(A a10);
    }

    public static String c(int i10) {
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
            case 7:
                return "QUERY_STATE_WHITE_LIST_COMPLETE";
            default:
                return "Unkonw State";
        }
    }

    public void a() {
        Bitmap bitmap;
        Bitmap bitmap2;
        Drawable drawable = this.f106n;
        if ((drawable instanceof BitmapDrawable) && (bitmap2 = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap2.isRecycled()) {
            bitmap2.recycle();
        }
        Drawable drawable2 = this.f101i;
        if ((drawable2 instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable2).getBitmap()) != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public A clone() {
        A a10 = new A();
        a10.f93a = this.f93a;
        a10.f94b = this.f94b;
        a10.f95c = this.f95c;
        a10.f96d = this.f96d;
        a10.f97e = this.f97e;
        a10.f98f = this.f98f;
        a10.f100h = this.f100h;
        a10.f99g = this.f99g;
        a10.f101i = this.f101i;
        a10.f102j = this.f102j;
        a10.f103k = this.f103k;
        a10.f104l = this.f104l;
        a10.f105m = this.f105m;
        a10.f107o = this.f107o;
        a10.f106n = this.f106n;
        return a10;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("YellowPageInfo{ ");
        sb.append("  number: " + D2.g.l(this.f93a));
        sb.append("  oriNumber: " + D2.g.l(this.f94b));
        sb.append("  queryState: " + this.f103k);
        sb.append("  name: " + D2.g.o(this.f95c));
        sb.append("  mAntiFraudCenterNumber: " + D2.g.l(this.f96d));
        sb.append("  markInfo: " + this.f97e);
        sb.append("  markInfoCounter: " + this.f98f);
        sb.append("  markInfoCount: " + this.f100h);
        sb.append("  markInfoType: " + this.f99g);
        sb.append("  photo: " + this.f101i);
        sb.append("  slotId: " + this.f104l);
        sb.append("  omojiColor: " + this.f105m);
        sb.append("  omojiPhoto: " + this.f106n);
        sb.append("  omojiVideoUri: " + D2.g.o(this.f107o));
        sb.append(" }\n");
        return sb.toString();
    }
}
