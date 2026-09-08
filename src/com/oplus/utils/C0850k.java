package com.oplus.utils;

import android.widget.ImageView;
import com.android.incallui.OplusPhoneUtils;

/* compiled from: CallLogUtils.java */
/* renamed from: com.oplus.utils.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0850k {
    public static void a(ImageView imageView, int i10, boolean z10) {
        if (imageView != null && l7.b.f34737e && !l7.b.f34755w) {
            c(imageView, i10, z10);
        }
    }

    public static void b(ImageView imageView, int i10, boolean z10) {
        boolean z11;
        if (imageView == null) {
            return;
        }
        boolean z12 = true;
        if (4 != i10 && 4 != (i10 & 4)) {
            z11 = false;
        } else {
            z11 = true;
        }
        boolean z13 = l7.b.f34737e;
        if (!z13 || (i10 & 67108864) != 67108864) {
            z12 = false;
        }
        if (z13 && l7.b.f34747o && z11) {
            if (z10) {
                imageView.setVisibility(8);
                return;
            } else {
                imageView.setVisibility(0);
                imageView.setImageResource(com.oplus.blacklistapp.o.f27303f);
                return;
            }
        }
        if (z12) {
            if (z10) {
                imageView.setVisibility(8);
                return;
            } else {
                imageView.setVisibility(0);
                imageView.setImageResource(com.oplus.blacklistapp.o.f27296A);
                return;
            }
        }
        imageView.setVisibility(8);
    }

    public static void c(ImageView imageView, int i10, boolean z10) {
        boolean z11;
        boolean z12 = true;
        if ((i10 & OplusPhoneUtils.PROPERTY_HIGH_DEF_AUDIO_EVS) != 1048576 && (i10 & 64) != 64) {
            z11 = false;
        } else {
            z11 = true;
        }
        if ((i10 & 524288) != 524288 && (i10 & 8) != 8) {
            z12 = false;
        }
        if (z11) {
            if (z10) {
                imageView.setVisibility(8);
                return;
            } else {
                imageView.setVisibility(0);
                imageView.setImageResource(com.oplus.blacklistapp.o.f27313p);
                return;
            }
        }
        if (z12) {
            imageView.setVisibility(0);
            imageView.setImageResource(com.oplus.blacklistapp.o.f27314q);
        } else {
            imageView.setVisibility(8);
        }
    }
}
