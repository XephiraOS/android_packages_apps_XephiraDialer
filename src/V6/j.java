package V6;

import java.util.ArrayList;
import java.util.Date;

/* compiled from: ZenModeConfig.java */
/* loaded from: classes3.dex */
public class j {

    /* compiled from: ZenModeConfig.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<Integer> f4086a;

        /* renamed from: b, reason: collision with root package name */
        public int f4087b;

        /* renamed from: c, reason: collision with root package name */
        public int f4088c;

        /* renamed from: d, reason: collision with root package name */
        public int f4089d;

        /* renamed from: e, reason: collision with root package name */
        public int f4090e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f4091f;

        /* renamed from: g, reason: collision with root package name */
        public long f4092g;

        public static String a(long j10) {
            return new Date(j10) + " (" + j10 + ")";
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!j.b(this.f4086a).equals(j.b(aVar.f4086a)) || this.f4087b != aVar.f4087b || this.f4088c != aVar.f4088c || this.f4089d != aVar.f4089d || this.f4090e != aVar.f4090e || this.f4091f != aVar.f4091f) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 0;
        }

        public String toString() {
            return "ScheduleInfo{days=" + this.f4086a + ", startHour=" + this.f4087b + ", startMinute=" + this.f4088c + ", endHour=" + this.f4089d + ", endMinute=" + this.f4090e + ", exitAtAlarm=" + this.f4091f + ", nextAlarm=" + a(this.f4092g) + '}';
        }
    }

    public static String b(ArrayList<Integer> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb = new StringBuilder();
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                if (i10 > 0) {
                    sb.append('.');
                }
                sb.append(arrayList.get(i10));
            }
            return sb.toString();
        }
        return "";
    }
}
