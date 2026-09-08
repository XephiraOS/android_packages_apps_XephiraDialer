package X7;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* compiled from: FlyweightMapStorage.java */
/* loaded from: classes3.dex */
public final class b extends c {

    /* renamed from: c, reason: collision with root package name */
    public int f4310c;

    /* renamed from: d, reason: collision with root package name */
    public int f4311d;

    /* renamed from: e, reason: collision with root package name */
    public ByteBuffer f4312e;

    /* renamed from: f, reason: collision with root package name */
    public ByteBuffer f4313f;

    /* renamed from: g, reason: collision with root package name */
    public String[] f4314g;

    public static void h(ObjectInput objectInput, int i10, ByteBuffer byteBuffer, int i11) {
        int i12 = i11 * i10;
        if (i10 == 2) {
            byteBuffer.putShort(i12, objectInput.readShort());
        } else {
            byteBuffer.putInt(i12, objectInput.readInt());
        }
    }

    public static int i(ByteBuffer byteBuffer, int i10, int i11) {
        int i12 = i11 * i10;
        if (i10 == 2) {
            return byteBuffer.getShort(i12);
        }
        return byteBuffer.getInt(i12);
    }

    public static void j(ObjectOutput objectOutput, int i10, ByteBuffer byteBuffer, int i11) {
        int i12 = i11 * i10;
        if (i10 == 2) {
            objectOutput.writeShort(byteBuffer.getShort(i12));
        } else {
            objectOutput.writeInt(byteBuffer.getInt(i12));
        }
    }

    @Override // X7.c
    public String a(int i10) {
        return this.f4314g[i(this.f4313f, this.f4311d, i10)];
    }

    @Override // X7.c
    public int d(int i10) {
        return i(this.f4312e, this.f4310c, i10);
    }

    @Override // X7.c
    public void e(ObjectInput objectInput) {
        this.f4310c = objectInput.readInt();
        this.f4311d = objectInput.readInt();
        int readInt = objectInput.readInt();
        this.f4316b.clear();
        for (int i10 = 0; i10 < readInt; i10++) {
            this.f4316b.add(Integer.valueOf(objectInput.readInt()));
        }
        int readInt2 = objectInput.readInt();
        String[] strArr = this.f4314g;
        if (strArr == null || strArr.length < readInt2) {
            this.f4314g = new String[readInt2];
        }
        for (int i11 = 0; i11 < readInt2; i11++) {
            this.f4314g[i11] = objectInput.readUTF();
        }
        g(objectInput);
    }

    @Override // X7.c
    public void f(ObjectOutput objectOutput) {
        objectOutput.writeInt(this.f4310c);
        objectOutput.writeInt(this.f4311d);
        objectOutput.writeInt(this.f4316b.size());
        Iterator<Integer> it = this.f4316b.iterator();
        while (it.hasNext()) {
            objectOutput.writeInt(it.next().intValue());
        }
        objectOutput.writeInt(this.f4314g.length);
        for (String str : this.f4314g) {
            objectOutput.writeUTF(str);
        }
        objectOutput.writeInt(this.f4315a);
        for (int i10 = 0; i10 < this.f4315a; i10++) {
            j(objectOutput, this.f4310c, this.f4312e, i10);
            j(objectOutput, this.f4311d, this.f4313f, i10);
        }
    }

    public final void g(ObjectInput objectInput) {
        this.f4315a = objectInput.readInt();
        ByteBuffer byteBuffer = this.f4312e;
        if (byteBuffer == null || byteBuffer.capacity() < this.f4315a) {
            this.f4312e = ByteBuffer.allocate(this.f4315a * this.f4310c);
        }
        ByteBuffer byteBuffer2 = this.f4313f;
        if (byteBuffer2 == null || byteBuffer2.capacity() < this.f4315a) {
            this.f4313f = ByteBuffer.allocate(this.f4315a * this.f4311d);
        }
        for (int i10 = 0; i10 < this.f4315a; i10++) {
            h(objectInput, this.f4310c, this.f4312e, i10);
            h(objectInput, this.f4311d, this.f4313f, i10);
        }
    }
}
