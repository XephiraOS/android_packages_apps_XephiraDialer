package com.android.incallui.mvvm.repository.dynamic;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.android.incallui.Log;
import com.android.incallui.mvvm.utils.C0727a;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import kotlinx.coroutines.w0;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: ResponsiveConfigRepository.kt */
@InterfaceC1470d(c = "com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository$captureWallpaperAsync$1", f = "ResponsiveConfigRepository.kt", l = {59}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ResponsiveConfigRepository$captureWallpaperAsync$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    int label;

    /* compiled from: ResponsiveConfigRepository.kt */
    @InterfaceC1470d(c = "com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository$captureWallpaperAsync$1$1", f = "ResponsiveConfigRepository.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository$captureWallpaperAsync$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<E, c<? super q>, Object> {
        final /* synthetic */ BitmapDrawable $newWallpaper;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BitmapDrawable bitmapDrawable, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$newWallpaper = bitmapDrawable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<q> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.$newWallpaper, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Bitmap bitmap;
            Bitmap bitmap2;
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                StringBuilder sb = new StringBuilder();
                sb.append(": wallpaper change preWallpaper=");
                ResponsiveConfigRepository responsiveConfigRepository = ResponsiveConfigRepository.f18540a;
                BitmapDrawable value = responsiveConfigRepository.D1().getValue();
                Bitmap bitmap3 = null;
                if (value != null) {
                    bitmap = value.getBitmap();
                } else {
                    bitmap = null;
                }
                sb.append(bitmap);
                sb.append(" ,newWallpaper=");
                BitmapDrawable bitmapDrawable = this.$newWallpaper;
                if (bitmapDrawable != null) {
                    bitmap3 = bitmapDrawable.getBitmap();
                }
                sb.append(bitmap3);
                Log.d("ResponsiveConfigRepository", sb.toString());
                BitmapDrawable value2 = responsiveConfigRepository.D1().getValue();
                responsiveConfigRepository.D1().o(this.$newWallpaper);
                if (value2 != null && (bitmap2 = value2.getBitmap()) != null && !bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
                return q.f35511a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(E e10, c<? super q> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(q.f35511a);
        }
    }

    public ResponsiveConfigRepository$captureWallpaperAsync$1(c<? super ResponsiveConfigRepository$captureWallpaperAsync$1> cVar) {
        super(2, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new ResponsiveConfigRepository$captureWallpaperAsync$1(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                kotlin.b.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            Log.d("captureWallpaperTask", ": default launcher start");
            BitmapDrawable a10 = C0727a.a();
            w0 c11 = S.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(a10, null);
            this.label = 1;
            if (C1244g.g(c11, anonymousClass1, this) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((ResponsiveConfigRepository$captureWallpaperAsync$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
