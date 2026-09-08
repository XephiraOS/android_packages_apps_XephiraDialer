package f4;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* compiled from: ImageMatrixProperty.java */
/* renamed from: f4.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1006g extends Property<ImageView, Matrix> {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f31711a;

    public C1006g() {
        super(Matrix.class, "imageMatrixProperty");
        this.f31711a = new Matrix();
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix get(ImageView imageView) {
        this.f31711a.set(imageView.getImageMatrix());
        return this.f31711a;
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
