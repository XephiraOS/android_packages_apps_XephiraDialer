package q5;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.heytap.accessory.constant.FastPairConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: StreamUtils.java */
/* renamed from: q5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1487a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f36158a = "StreamUtils";

    /* compiled from: StreamUtils.java */
    /* renamed from: q5.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0343a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public InputStream f36159a;

        /* renamed from: b, reason: collision with root package name */
        public OutputStream f36160b;

        /* renamed from: c, reason: collision with root package name */
        public int f36161c;

        public C0343a(InputStream inputStream, int i10, OutputStream outputStream) {
            super("ParcelFileDescriptor Transfer Thread");
            this.f36159a = inputStream;
            this.f36160b = outputStream;
            this.f36161c = a(i10);
            setDaemon(true);
        }

        public final int a(int i10) {
            if (i10 != 1) {
                if (i10 == 2) {
                    return FastPairConstants.PAIR_TYPE_BLE_IN_PAIR;
                }
                if (i10 != 4) {
                    Log.w(C1487a.f36158a, "unsupported transport time, return default packet length");
                    return FastPairConstants.PAIR_TYPE_BLE_IN_PAIR;
                }
                return 4840;
            }
            return 64888;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            byte[] bArr = new byte[this.f36161c];
            while (true) {
                try {
                    try {
                        try {
                            int read = this.f36159a.read(bArr);
                            if (read <= 0) {
                                break;
                            } else {
                                this.f36160b.write(bArr, 0, read);
                            }
                        } catch (IOException e10) {
                            Log.e("TransferThread", e10.getMessage());
                            try {
                                this.f36159a.close();
                                this.f36159a = null;
                            } catch (IOException unused) {
                            }
                            this.f36160b.close();
                        }
                    } finally {
                    }
                } catch (IOException unused2) {
                    return;
                }
            }
            this.f36160b.flush();
            try {
                this.f36159a.close();
                this.f36159a = null;
            } catch (IOException unused3) {
            }
            this.f36160b.close();
            this.f36160b = null;
        }
    }

    public static ParcelFileDescriptor b(InputStream inputStream, int i10) {
        ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
        new C0343a(inputStream, i10, new ParcelFileDescriptor.AutoCloseOutputStream(createPipe[1])).start();
        return parcelFileDescriptor;
    }
}
