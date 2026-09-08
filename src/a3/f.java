package a3;

/* compiled from: ByteArrayAdapter.java */
/* loaded from: classes.dex */
public final class f implements InterfaceC0420a<byte[]> {
    @Override // a3.InterfaceC0420a
    public int a() {
        return 1;
    }

    @Override // a3.InterfaceC0420a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int b(byte[] bArr) {
        return bArr.length;
    }

    @Override // a3.InterfaceC0420a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public byte[] newArray(int i10) {
        return new byte[i10];
    }

    @Override // a3.InterfaceC0420a
    public String getTag() {
        return "ByteArrayPool";
    }
}
