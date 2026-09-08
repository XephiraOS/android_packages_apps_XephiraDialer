package com.android.contacts.calllog;

import android.content.Context;
import android.content.res.Resources;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.VirtualSupportUtils;

/* compiled from: CallTypeHelper.java */
/* loaded from: classes.dex */
public class w {
    public static CharSequence a(Context context, int i10, boolean z10) {
        int i11;
        int i12;
        int i13;
        int i14;
        Resources resources = context.getResources();
        boolean f02 = B3.a.f0();
        int i15 = R.string.oplus_block;
        if (f02 && (i10 == 28 || i10 == 29 || i10 == 30)) {
            if (z10) {
                i15 = R.string.oplus_video_oplus_block;
            }
            return resources.getString(i15);
        }
        int abs = Math.abs(i10);
        int i16 = R.string.type_incoming;
        if (abs != 1) {
            if (abs != 2) {
                if (abs != 3) {
                    if (abs != 4) {
                        if (abs != 5) {
                            if (abs != 7) {
                                if (abs != 10) {
                                    if (abs != 56) {
                                        if (abs != 100) {
                                            if (abs != 101) {
                                                switch (abs) {
                                                    case 19:
                                                    case 20:
                                                    case 21:
                                                    case 22:
                                                    case 23:
                                                    case 24:
                                                    case 25:
                                                    case 26:
                                                    case 27:
                                                        break;
                                                    default:
                                                        switch (abs) {
                                                            case 49:
                                                            case 50:
                                                            case 51:
                                                            case 52:
                                                            case 53:
                                                            case 54:
                                                                break;
                                                            default:
                                                                H7.b.c("CallTypeHelper", "invalid call type: " + i10);
                                                                if (z10) {
                                                                    i16 = R.string.oplus_video_type_incoming;
                                                                }
                                                                return resources.getString(i16);
                                                        }
                                                }
                                            }
                                        }
                                    }
                                    if (z10) {
                                        i15 = R.string.oplus_video_oplus_block;
                                    }
                                    return resources.getString(i15);
                                }
                            } else {
                                if (VirtualSupportUtils.m()) {
                                    return resources.getString(R.string.type_answer_on_another_device);
                                }
                                if (z10) {
                                    i16 = R.string.oplus_video_type_incoming;
                                }
                                return resources.getString(i16);
                            }
                        }
                        if (z10) {
                            i14 = R.string.oplus_video_type_declined;
                        } else {
                            i14 = R.string.type_declined;
                        }
                        return resources.getString(i14);
                    }
                    if (z10) {
                        i13 = R.string.oplus_video_type_voicemail;
                    } else {
                        i13 = R.string.type_voicemail;
                    }
                    return resources.getString(i13);
                }
                if (z10) {
                    i12 = R.string.oplus_video_type_missed;
                } else {
                    i12 = R.string.type_missed;
                }
                return resources.getString(i12);
            }
            if (z10) {
                i11 = R.string.oplus_video_type_outgoing;
            } else {
                i11 = R.string.type_outgoing;
            }
            return resources.getString(i11);
        }
        if (z10) {
            i16 = R.string.oplus_video_type_incoming;
        }
        return resources.getString(i16);
    }

    public static Integer b(Context context, int i10) {
        int abs = Math.abs(i10);
        if (abs == 3) {
            return Integer.valueOf(com.android.contacts.framework.baseui.util.r.d(context));
        }
        if (abs == 4) {
            return Integer.valueOf(com.android.contacts.framework.baseui.util.r.a(context));
        }
        return null;
    }
}
