package j9;

/* compiled from: Codec.java */
/* renamed from: j9.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC1197g extends InterfaceC1199i, InterfaceC1204n {

    /* compiled from: Codec.java */
    /* renamed from: j9.g$a */
    /* loaded from: classes4.dex */
    public static final class a implements InterfaceC1197g {
        @Override // j9.InterfaceC1199i, j9.InterfaceC1204n
        public String a() {
            return "gzip";
        }
    }

    /* compiled from: Codec.java */
    /* renamed from: j9.g$b */
    /* loaded from: classes4.dex */
    public static final class b implements InterfaceC1197g {

        /* renamed from: a, reason: collision with root package name */
        public static final InterfaceC1197g f34015a = new b();

        @Override // j9.InterfaceC1199i, j9.InterfaceC1204n
        public String a() {
            return "identity";
        }
    }
}
