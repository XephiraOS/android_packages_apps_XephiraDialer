package com.google.zxing.qrcode.decoder;

import S4.b;

/* loaded from: classes3.dex */
enum DataMask {
    DATA_MASK_000 { // from class: com.google.zxing.qrcode.decoder.DataMask.1
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean a(int i10, int i11) {
            if (((i10 + i11) & 1) == 0) {
                return true;
            }
            return false;
        }
    },
    DATA_MASK_001 { // from class: com.google.zxing.qrcode.decoder.DataMask.2
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean a(int i10, int i11) {
            if ((i10 & 1) == 0) {
                return true;
            }
            return false;
        }
    },
    DATA_MASK_010 { // from class: com.google.zxing.qrcode.decoder.DataMask.3
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean a(int i10, int i11) {
            if (i11 % 3 == 0) {
                return true;
            }
            return false;
        }
    },
    DATA_MASK_011 { // from class: com.google.zxing.qrcode.decoder.DataMask.4
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean a(int i10, int i11) {
            if ((i10 + i11) % 3 == 0) {
                return true;
            }
            return false;
        }
    },
    DATA_MASK_100 { // from class: com.google.zxing.qrcode.decoder.DataMask.5
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean a(int i10, int i11) {
            if ((((i10 / 2) + (i11 / 3)) & 1) == 0) {
                return true;
            }
            return false;
        }
    },
    DATA_MASK_101 { // from class: com.google.zxing.qrcode.decoder.DataMask.6
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean a(int i10, int i11) {
            if ((i10 * i11) % 6 == 0) {
                return true;
            }
            return false;
        }
    },
    DATA_MASK_110 { // from class: com.google.zxing.qrcode.decoder.DataMask.7
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean a(int i10, int i11) {
            if ((i10 * i11) % 6 < 3) {
                return true;
            }
            return false;
        }
    },
    DATA_MASK_111 { // from class: com.google.zxing.qrcode.decoder.DataMask.8
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean a(int i10, int i11) {
            if (((i10 + i11 + ((i10 * i11) % 3)) & 1) == 0) {
                return true;
            }
            return false;
        }
    };

    public abstract boolean a(int i10, int i11);

    public final void b(b bVar, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            for (int i12 = 0; i12 < i10; i12++) {
                if (a(i11, i12)) {
                    bVar.c(i12, i11);
                }
            }
        }
    }
}
