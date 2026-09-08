package a3;

/* compiled from: IntegerArrayAdapter.java */
/* loaded from: classes.dex */
public final class h implements InterfaceC0420a<int[]> {
    @Override // a3.InterfaceC0420a
    public int a() {
        return 4;
    }

    @Override // a3.InterfaceC0420a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int b(int[] iArr) {
        return iArr.length;
    }

    @Override // a3.InterfaceC0420a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int[] newArray(int i10) {
        return new int[i10];
    }

    @Override // a3.InterfaceC0420a
    public String getTag() {
        return "IntegerArrayPool";
    }
}
