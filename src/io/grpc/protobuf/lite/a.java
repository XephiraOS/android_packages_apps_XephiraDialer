package io.grpc.protobuf.lite;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import j9.InterfaceC1189A;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* compiled from: ProtoInputStream.java */
/* loaded from: classes4.dex */
public final class a extends InputStream implements InterfaceC1189A {

    /* renamed from: a, reason: collision with root package name */
    public MessageLite f33426a;

    /* renamed from: b, reason: collision with root package name */
    public final Parser<?> f33427b;

    /* renamed from: c, reason: collision with root package name */
    public ByteArrayInputStream f33428c;

    public a(MessageLite messageLite, Parser<?> parser) {
        this.f33426a = messageLite;
        this.f33427b = parser;
    }

    public MessageLite a() {
        MessageLite messageLite = this.f33426a;
        if (messageLite != null) {
            return messageLite;
        }
        throw new IllegalStateException("message not available");
    }

    @Override // java.io.InputStream
    public int available() {
        MessageLite messageLite = this.f33426a;
        if (messageLite != null) {
            return messageLite.getSerializedSize();
        }
        ByteArrayInputStream byteArrayInputStream = this.f33428c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    public Parser<?> c() {
        return this.f33427b;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f33426a != null) {
            this.f33428c = new ByteArrayInputStream(this.f33426a.toByteArray());
            this.f33426a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f33428c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        MessageLite messageLite = this.f33426a;
        if (messageLite != null) {
            int serializedSize = messageLite.getSerializedSize();
            if (serializedSize == 0) {
                this.f33426a = null;
                this.f33428c = null;
                return -1;
            }
            if (i11 >= serializedSize) {
                CodedOutputStream newInstance = CodedOutputStream.newInstance(bArr, i10, serializedSize);
                this.f33426a.writeTo(newInstance);
                newInstance.flush();
                newInstance.checkNoSpaceLeft();
                this.f33426a = null;
                this.f33428c = null;
                return serializedSize;
            }
            this.f33428c = new ByteArrayInputStream(this.f33426a.toByteArray());
            this.f33426a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f33428c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i10, i11);
        }
        return -1;
    }
}
