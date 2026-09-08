package X7;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;

/* compiled from: DefaultMapStorage.java */
/* loaded from: classes3.dex */
public class a extends c {

    /* renamed from: c, reason: collision with root package name */
    public int[] f4308c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f4309d;

    @Override // X7.c
    public String a(int i10) {
        return this.f4309d[i10];
    }

    @Override // X7.c
    public int d(int i10) {
        return this.f4308c[i10];
    }

    @Override // X7.c
    public void e(ObjectInput objectInput) {
        int readInt = objectInput.readInt();
        this.f4315a = readInt;
        int[] iArr = this.f4308c;
        if (iArr == null || iArr.length < readInt) {
            this.f4308c = new int[readInt];
        }
        String[] strArr = this.f4309d;
        if (strArr == null || strArr.length < readInt) {
            this.f4309d = new String[readInt];
        }
        for (int i10 = 0; i10 < this.f4315a; i10++) {
            this.f4308c[i10] = objectInput.readInt();
            this.f4309d[i10] = objectInput.readUTF();
        }
        int readInt2 = objectInput.readInt();
        this.f4316b.clear();
        for (int i11 = 0; i11 < readInt2; i11++) {
            this.f4316b.add(Integer.valueOf(objectInput.readInt()));
        }
    }

    @Override // X7.c
    public void f(ObjectOutput objectOutput) {
        objectOutput.writeInt(this.f4315a);
        for (int i10 = 0; i10 < this.f4315a; i10++) {
            objectOutput.writeInt(this.f4308c[i10]);
            objectOutput.writeUTF(this.f4309d[i10]);
        }
        objectOutput.writeInt(this.f4316b.size());
        Iterator<Integer> it = this.f4316b.iterator();
        while (it.hasNext()) {
            objectOutput.writeInt(it.next().intValue());
        }
    }
}
