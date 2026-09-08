package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.e;

/* loaded from: classes.dex */
public class MockView extends View {

    /* renamed from: a, reason: collision with root package name */
    public Paint f8598a;

    /* renamed from: b, reason: collision with root package name */
    public Paint f8599b;

    /* renamed from: c, reason: collision with root package name */
    public Paint f8600c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8601d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8602e;

    /* renamed from: f, reason: collision with root package name */
    public String f8603f;

    /* renamed from: g, reason: collision with root package name */
    public Rect f8604g;

    /* renamed from: h, reason: collision with root package name */
    public int f8605h;

    /* renamed from: i, reason: collision with root package name */
    public int f8606i;

    /* renamed from: j, reason: collision with root package name */
    public int f8607j;

    /* renamed from: k, reason: collision with root package name */
    public int f8608k;

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8598a = new Paint();
        this.f8599b = new Paint();
        this.f8600c = new Paint();
        this.f8601d = true;
        this.f8602e = true;
        this.f8603f = null;
        this.f8604g = new Rect();
        this.f8605h = Color.argb(255, 0, 0, 0);
        this.f8606i = Color.argb(255, 200, 200, 200);
        this.f8607j = Color.argb(255, 50, 50, 50);
        this.f8608k = 4;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f9199r6);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == e.f9217t6) {
                    this.f8603f = obtainStyledAttributes.getString(index);
                } else if (index == e.f9244w6) {
                    this.f8601d = obtainStyledAttributes.getBoolean(index, this.f8601d);
                } else if (index == e.f9208s6) {
                    this.f8605h = obtainStyledAttributes.getColor(index, this.f8605h);
                } else if (index == e.f9226u6) {
                    this.f8607j = obtainStyledAttributes.getColor(index, this.f8607j);
                } else if (index == e.f9235v6) {
                    this.f8606i = obtainStyledAttributes.getColor(index, this.f8606i);
                } else if (index == e.f9253x6) {
                    this.f8602e = obtainStyledAttributes.getBoolean(index, this.f8602e);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f8603f == null) {
            try {
                this.f8603f = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.f8598a.setColor(this.f8605h);
        this.f8598a.setAntiAlias(true);
        this.f8599b.setColor(this.f8606i);
        this.f8599b.setAntiAlias(true);
        this.f8600c.setColor(this.f8607j);
        this.f8608k = Math.round(this.f8608k * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f8601d) {
            width--;
            height--;
            float f10 = width;
            float f11 = height;
            canvas.drawLine(0.0f, 0.0f, f10, f11, this.f8598a);
            canvas.drawLine(0.0f, f11, f10, 0.0f, this.f8598a);
            canvas.drawLine(0.0f, 0.0f, f10, 0.0f, this.f8598a);
            canvas.drawLine(f10, 0.0f, f10, f11, this.f8598a);
            canvas.drawLine(f10, f11, 0.0f, f11, this.f8598a);
            canvas.drawLine(0.0f, f11, 0.0f, 0.0f, this.f8598a);
        }
        String str = this.f8603f;
        if (str != null && this.f8602e) {
            this.f8599b.getTextBounds(str, 0, str.length(), this.f8604g);
            float width2 = (width - this.f8604g.width()) / 2.0f;
            float height2 = ((height - this.f8604g.height()) / 2.0f) + this.f8604g.height();
            this.f8604g.offset((int) width2, (int) height2);
            Rect rect = this.f8604g;
            int i10 = rect.left;
            int i11 = this.f8608k;
            rect.set(i10 - i11, rect.top - i11, rect.right + i11, rect.bottom + i11);
            canvas.drawRect(this.f8604g, this.f8600c);
            canvas.drawText(this.f8603f, width2, height2, this.f8599b);
        }
    }
}
