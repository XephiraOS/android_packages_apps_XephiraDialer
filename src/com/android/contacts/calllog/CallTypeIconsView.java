package com.android.contacts.calllog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.customize.contacts.util.C0801l;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class CallTypeIconsView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final List<Integer> f13766a;

    /* renamed from: b, reason: collision with root package name */
    public final x f13767b;

    /* renamed from: c, reason: collision with root package name */
    public int f13768c;

    /* renamed from: d, reason: collision with root package name */
    public int f13769d;

    /* renamed from: e, reason: collision with root package name */
    public int f13770e;

    public CallTypeIconsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13766a = new ArrayList(3);
        this.f13767b = x.b(context);
    }

    public void a(int i10, int i11) {
        this.f13766a.add(Integer.valueOf(i10));
        this.f13770e = i11;
        Drawable c10 = c(i10);
        this.f13768c += c10.getIntrinsicWidth();
        this.f13769d = Math.max(this.f13769d, c10.getIntrinsicHeight());
        invalidate();
    }

    public void b() {
        this.f13766a.clear();
        this.f13768c = 0;
        this.f13769d = 0;
        invalidate();
    }

    public final Drawable c(int i10) {
        boolean z10;
        int abs = Math.abs(i10);
        int i11 = this.f13770e;
        boolean z11 = false;
        if ((i11 & 524288) != 524288 && (i11 & 8) != 8) {
            z10 = false;
        } else {
            z10 = true;
        }
        if ((i11 & 1) == 1) {
            z11 = true;
        }
        if (B3.a.f0() && (abs == 28 || abs == 29 || abs == 30)) {
            if (!B3.a.Z() && (!B3.a.a0() || !z10)) {
                if (z11) {
                    setContentDescription(getContext().getString(R.string.oplus_video_oplus_block));
                    return this.f13767b.f14041i;
                }
                setContentDescription(getContext().getString(R.string.oplus_blocked_call_description));
                return this.f13767b.f14037e;
            }
            if (z11) {
                setContentDescription(getResources().getString(R.string.oplus_video_oplus_block));
                return this.f13767b.f14048p;
            }
            setContentDescription(getResources().getString(R.string.oplus_blocked_call_description));
            return this.f13767b.f14052t;
        }
        if (abs != 1) {
            if (abs != 2) {
                if (abs != 3) {
                    if (abs != 4) {
                        if (abs != 5 && abs != 10) {
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
                                                        H7.b.i("CallTypeIconsView", "invalid call type: " + abs);
                                                        return this.f13767b.f14033a;
                                                }
                                        }
                                    } else {
                                        if (!B3.a.Z() && !B3.a.a0()) {
                                            if (z11) {
                                                setContentDescription(getContext().getString(R.string.oplus_video_type_incoming));
                                                return this.f13767b.f14038f;
                                            }
                                            setContentDescription(getContext().getString(R.string.oplus_incoming_call_description));
                                            return this.f13767b.f14033a;
                                        }
                                        if (z11) {
                                            setContentDescription(getResources().getString(R.string.oplus_video_type_incoming));
                                            return this.f13767b.f14045m;
                                        }
                                        setContentDescription(getResources().getString(R.string.oplus_incoming_call_description));
                                        return this.f13767b.f14049q;
                                    }
                                } else {
                                    if (!B3.a.Z() && !B3.a.a0()) {
                                        if (z11) {
                                            setContentDescription(getContext().getString(R.string.oplus_video_type_outgoing));
                                            return this.f13767b.f14039g;
                                        }
                                        setContentDescription(getContext().getString(R.string.oplus_outgiong_call_description));
                                        return this.f13767b.f14034b;
                                    }
                                    if (z11) {
                                        setContentDescription(getResources().getString(R.string.oplus_video_type_outgoing));
                                        return this.f13767b.f14046n;
                                    }
                                    setContentDescription(getResources().getString(R.string.oplus_outgiong_call_description));
                                    return this.f13767b.f14050r;
                                }
                            }
                            if ((B3.a.Z() || B3.a.a0()) && z10) {
                                if (z11) {
                                    setContentDescription(getResources().getString(R.string.oplus_video_oplus_block));
                                    return this.f13767b.f14048p;
                                }
                                setContentDescription(getResources().getString(R.string.oplus_blocked_call_description));
                                return this.f13767b.f14052t;
                            }
                            if (z11) {
                                setContentDescription(getContext().getString(R.string.oplus_video_oplus_block));
                                return this.f13767b.f14041i;
                            }
                            setContentDescription(getContext().getString(R.string.oplus_blocked_call_description));
                            return this.f13767b.f14037e;
                        }
                        if ((B3.a.Z() || B3.a.a0()) && z10) {
                            if (z11) {
                                setContentDescription(getResources().getString(R.string.oplus_video_type_declined));
                                return this.f13767b.f14048p;
                            }
                            setContentDescription(getResources().getString(R.string.oplus_reject_call_description));
                            return this.f13767b.f14052t;
                        }
                        if (z11) {
                            setContentDescription(getContext().getString(R.string.oplus_video_type_declined));
                            return this.f13767b.f14041i;
                        }
                        setContentDescription(getContext().getString(R.string.oplus_reject_call_description));
                        return this.f13767b.f14037e;
                    }
                    setContentDescription(getContext().getString(R.string.type_voicemail));
                    return this.f13767b.f14036d;
                }
                if ((B3.a.Z() || B3.a.a0()) && z10) {
                    if (z11) {
                        setContentDescription(getResources().getString(R.string.oplus_video_type_missed));
                        return this.f13767b.f14047o;
                    }
                    setContentDescription(getResources().getString(R.string.oplus_missed_call_description));
                    return this.f13767b.f14051s;
                }
                if (z11) {
                    setContentDescription(getContext().getString(R.string.oplus_video_type_missed));
                    return this.f13767b.f14040h;
                }
                setContentDescription(getContext().getString(R.string.oplus_missed_call_description));
                return this.f13767b.f14035c;
            }
            if ((B3.a.Z() || B3.a.a0()) && z10) {
                if (z11) {
                    setContentDescription(getResources().getString(R.string.oplus_video_type_outgoing));
                    return this.f13767b.f14046n;
                }
                setContentDescription(getResources().getString(R.string.oplus_outgiong_call_description));
                return this.f13767b.f14050r;
            }
            if (z11) {
                setContentDescription(getContext().getString(R.string.oplus_video_type_outgoing));
                return this.f13767b.f14039g;
            }
            setContentDescription(getContext().getString(R.string.oplus_outgiong_call_description));
            return this.f13767b.f14034b;
        }
        if (C0801l.n(this.f13770e)) {
            setContentDescription(getContext().getString(R.string.assistant_answer));
            return this.f13767b.f14044l;
        }
        if ((B3.a.Z() || B3.a.a0()) && z10) {
            if (z11) {
                setContentDescription(getResources().getString(R.string.oplus_video_type_incoming));
                return this.f13767b.f14045m;
            }
            setContentDescription(getResources().getString(R.string.oplus_incoming_call_description));
            return this.f13767b.f14049q;
        }
        if (z11) {
            setContentDescription(getContext().getString(R.string.oplus_video_type_incoming));
            return this.f13767b.f14038f;
        }
        setContentDescription(getContext().getString(R.string.oplus_incoming_call_description));
        return this.f13767b.f14033a;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Iterator<Integer> it = this.f13766a.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            Drawable c10 = c(it.next().intValue());
            int intrinsicWidth = c10.getIntrinsicWidth() + i10;
            c10.setBounds(i10, 0, intrinsicWidth, c10.getIntrinsicHeight());
            c10.draw(canvas);
            i10 = intrinsicWidth;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(this.f13768c, this.f13769d);
    }
}
