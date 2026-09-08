package com.oplus.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.oplus.blacklistapp.o;
import com.oplus.blacklistapp.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l7.b;

/* loaded from: classes4.dex */
public class CallTypeIconsView extends View {

    /* renamed from: a, reason: collision with root package name */
    public List<Integer> f29220a;

    /* renamed from: b, reason: collision with root package name */
    public a f29221b;

    /* renamed from: c, reason: collision with root package name */
    public int f29222c;

    /* renamed from: d, reason: collision with root package name */
    public int f29223d;

    /* renamed from: e, reason: collision with root package name */
    public int f29224e;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable f29225a;

        /* renamed from: b, reason: collision with root package name */
        public final Drawable f29226b;

        /* renamed from: c, reason: collision with root package name */
        public final Drawable f29227c;

        /* renamed from: d, reason: collision with root package name */
        public final Drawable f29228d;

        /* renamed from: e, reason: collision with root package name */
        public final Drawable f29229e;

        /* renamed from: f, reason: collision with root package name */
        public final Drawable f29230f;

        /* renamed from: g, reason: collision with root package name */
        public final Drawable f29231g;

        /* renamed from: h, reason: collision with root package name */
        public final Drawable f29232h;

        /* renamed from: i, reason: collision with root package name */
        public final Drawable f29233i;

        /* renamed from: j, reason: collision with root package name */
        public final Drawable f29234j;

        /* renamed from: k, reason: collision with root package name */
        public Drawable f29235k;

        /* renamed from: l, reason: collision with root package name */
        public Drawable f29236l;

        public a(Context context) {
            context.getResources();
            this.f29225a = context.getDrawable(o.f27300c);
            this.f29226b = context.getDrawable(o.f27308k);
            this.f29227c = context.getDrawable(o.f27306i);
            this.f29228d = context.getDrawable(o.f27298a);
            this.f29229e = context.getDrawable(o.f27301d);
            this.f29230f = context.getDrawable(o.f27309l);
            this.f29231g = context.getDrawable(o.f27307j);
            this.f29232h = context.getDrawable(o.f27299b);
            this.f29233i = context.getDrawable(o.f27302e);
            this.f29234j = context.getDrawable(o.f27310m);
            if (b.f34745m || b.f34746n) {
                this.f29235k = context.getDrawable(o.f27312o);
                this.f29236l = context.getDrawable(o.f27311n);
            }
        }
    }

    public CallTypeIconsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f29220a = new ArrayList(3);
        this.f29221b = new a(context);
    }

    public void a(int i10, int i11) {
        this.f29220a.add(Integer.valueOf(i10));
        this.f29224e = i11;
        Drawable c10 = c(i10);
        this.f29222c += c10.getIntrinsicWidth();
        this.f29223d = Math.max(this.f29223d, c10.getIntrinsicHeight());
        invalidate();
    }

    public void b() {
        this.f29220a.clear();
        this.f29222c = 0;
        this.f29223d = 0;
        invalidate();
    }

    public final Drawable c(int i10) {
        int abs = Math.abs(i10);
        boolean z10 = false;
        if (b.o() && (abs == 28 || abs == 29 || abs == 30)) {
            int i11 = this.f29224e;
            if ((i11 & 524288) == 524288 || (i11 & 8) == 8) {
                z10 = true;
            }
            if ((b.f34745m || b.f34746n) && z10) {
                if ((i11 & 1) == 1) {
                    setContentDescription(getResources().getString(u.f27649k3));
                    return this.f29221b.f29235k;
                }
                setContentDescription(getResources().getString(u.f27686s0));
                return this.f29221b.f29236l;
            }
            if ((i11 & 1) == 1) {
                setContentDescription(getContext().getString(u.f27649k3));
                return this.f29221b.f29232h;
            }
            setContentDescription(getContext().getString(u.f27686s0));
            return this.f29221b.f29228d;
        }
        if (abs != 1) {
            if (abs != 2) {
                if (abs != 3) {
                    if (abs != 10) {
                        if (abs != 56) {
                            if (abs != 100) {
                                if (abs != 101) {
                                    switch (abs) {
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
                                                    Log.w("CallTypeIconsView", "invalid call type: " + abs);
                                                    return this.f29221b.f29225a;
                                            }
                                    }
                                } else {
                                    setContentDescription(getContext().getString(u.f27652l1));
                                    return this.f29221b.f29233i;
                                }
                            } else {
                                setContentDescription(getContext().getString(u.f27658m2));
                                return this.f29221b.f29234j;
                            }
                        }
                        int i12 = this.f29224e;
                        if ((i12 & 524288) == 524288 || (i12 & 8) == 8) {
                            z10 = true;
                        }
                        if ((b.f34745m || b.f34746n) && z10) {
                            if ((i12 & 1) == 1) {
                                setContentDescription(getResources().getString(u.f27649k3));
                                return this.f29221b.f29235k;
                            }
                            setContentDescription(getResources().getString(u.f27686s0));
                            return this.f29221b.f29236l;
                        }
                        if ((i12 & 1) == 1) {
                            setContentDescription(getContext().getString(u.f27649k3));
                            return this.f29221b.f29232h;
                        }
                        setContentDescription(getContext().getString(u.f27686s0));
                        return this.f29221b.f29228d;
                    }
                    if ((this.f29224e & 1) == 1) {
                        setContentDescription(getContext().getString(u.f27654l3));
                        return this.f29221b.f29232h;
                    }
                    setContentDescription(getContext().getString(u.f27494A2));
                    return this.f29221b.f29228d;
                }
                if ((this.f29224e & 1) == 1) {
                    setContentDescription(getContext().getString(u.f27664n3));
                    return this.f29221b.f29231g;
                }
                setContentDescription(getContext().getString(u.f27509E1));
                return this.f29221b.f29227c;
            }
            if ((this.f29224e & 1) == 1) {
                setContentDescription(getContext().getString(u.f27669o3));
                return this.f29221b.f29230f;
            }
            setContentDescription(getContext().getString(u.f27658m2));
            return this.f29221b.f29226b;
        }
        if ((this.f29224e & 1) == 1) {
            setContentDescription(getContext().getString(u.f27659m3));
            return this.f29221b.f29229e;
        }
        setContentDescription(getContext().getString(u.f27652l1));
        return this.f29221b.f29225a;
    }

    public int getCount() {
        return this.f29220a.size();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Iterator<Integer> it = this.f29220a.iterator();
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
        setMeasuredDimension(this.f29222c, this.f29223d);
    }
}
