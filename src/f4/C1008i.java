package f4;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MotionSpec.java */
/* renamed from: f4.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1008i {

    /* renamed from: a, reason: collision with root package name */
    public final p.i<String, C1009j> f31715a = new p.i<>();

    /* renamed from: b, reason: collision with root package name */
    public final p.i<String, PropertyValuesHolder[]> f31716b = new p.i<>();

    public static void a(C1008i c1008i, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            c1008i.l(objectAnimator.getPropertyName(), objectAnimator.getValues());
            c1008i.m(objectAnimator.getPropertyName(), C1009j.b(objectAnimator));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }

    public static C1008i c(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        if (typedArray.hasValue(i10) && (resourceId = typedArray.getResourceId(i10, 0)) != 0) {
            return d(context, resourceId);
        }
        return null;
    }

    public static C1008i d(Context context, int i10) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i10);
            if (loadAnimator instanceof AnimatorSet) {
                return e(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return e(arrayList);
        } catch (Exception e10) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i10), e10);
            return null;
        }
    }

    public static C1008i e(List<Animator> list) {
        C1008i c1008i = new C1008i();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            a(c1008i, list.get(i10));
        }
        return c1008i;
    }

    public final PropertyValuesHolder[] b(PropertyValuesHolder[] propertyValuesHolderArr) {
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i10 = 0; i10 < propertyValuesHolderArr.length; i10++) {
            propertyValuesHolderArr2[i10] = propertyValuesHolderArr[i10].clone();
        }
        return propertyValuesHolderArr2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1008i)) {
            return false;
        }
        return this.f31715a.equals(((C1008i) obj).f31715a);
    }

    public <T> ObjectAnimator f(String str, T t10, Property<T, ?> property) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(t10, g(str));
        ofPropertyValuesHolder.setProperty(property);
        h(str).a(ofPropertyValuesHolder);
        return ofPropertyValuesHolder;
    }

    public PropertyValuesHolder[] g(String str) {
        if (j(str)) {
            return b(this.f31716b.get(str));
        }
        throw new IllegalArgumentException();
    }

    public C1009j h(String str) {
        if (k(str)) {
            return this.f31715a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public int hashCode() {
        return this.f31715a.hashCode();
    }

    public long i() {
        int size = this.f31715a.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            C1009j l10 = this.f31715a.l(i10);
            j10 = Math.max(j10, l10.c() + l10.d());
        }
        return j10;
    }

    public boolean j(String str) {
        if (this.f31716b.get(str) != null) {
            return true;
        }
        return false;
    }

    public boolean k(String str) {
        if (this.f31715a.get(str) != null) {
            return true;
        }
        return false;
    }

    public void l(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f31716b.put(str, propertyValuesHolderArr);
    }

    public void m(String str, C1009j c1009j) {
        this.f31715a.put(str, c1009j);
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f31715a + "}\n";
    }
}
