package com.coui.appcompat.scanview;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.i;
import m9.q;
import v9.l;

/* compiled from: LightManagerClient.kt */
/* loaded from: classes.dex */
public final class LightManagerClient {
    public static final Companion Companion = new Companion(null);
    private static final int DARK_THRESHOLD = 60;
    private static final long DETECT_INTERVAL = 300;
    private static final int MAX_LIGHT = 255;
    private static final int SAMPLE_STEP = 10;
    private int lastDarkIndex;
    private long lastDetectTime;
    private l<? super Boolean, q> listener = new l<Boolean, q>() { // from class: com.coui.appcompat.scanview.LightManagerClient$listener$1
        public final void invoke(boolean z10) {
        }

        @Override // v9.l
        public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return q.f35511a;
        }
    };
    private final int[] darkHistory = {255, 255, 255};

    /* compiled from: LightManagerClient.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    private final byte[] toByteArray(ByteBuffer byteBuffer) {
        byteBuffer.rewind();
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }

    public final l<Boolean, q> getListener() {
        return this.listener;
    }

    public final void handlePreviewData(byte[] data, int i10, int i11) {
        i.f(data, "data");
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.lastDetectTime) <= DETECT_INTERVAL) {
            return;
        }
        this.lastDetectTime = currentTimeMillis;
        int i12 = i10 * i11;
        boolean z10 = false;
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14 += 10) {
            i13 += (int) (data[i14] & 255);
        }
        int[] iArr = this.darkHistory;
        int length = this.lastDarkIndex % iArr.length;
        iArr[length] = i13 / (i12 / 10);
        this.lastDarkIndex = length + 1;
        int length2 = iArr.length;
        int i15 = 0;
        while (true) {
            if (i15 >= length2) {
                z10 = true;
                break;
            } else if (iArr[i15] > 60) {
                break;
            } else {
                i15++;
            }
        }
        this.listener.invoke(Boolean.valueOf(z10));
    }

    public final void setListener(l<? super Boolean, q> lVar) {
        i.f(lVar, "<set-?>");
        this.listener = lVar;
    }

    public final void handlePreviewData(ByteBuffer data, int i10, int i11) {
        i.f(data, "data");
        handlePreviewData(toByteArray(data), i10, i11);
    }
}
