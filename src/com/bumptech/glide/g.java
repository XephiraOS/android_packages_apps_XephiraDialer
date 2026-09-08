package com.bumptech.glide;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.c;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.k;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import d3.C0951a;
import d3.C0952b;
import d3.d;
import d3.e;
import d3.g;
import d3.l;
import d3.t;
import d3.v;
import d3.w;
import d3.x;
import d3.y;
import d3.z;
import e3.C0970a;
import e3.C0971b;
import e3.C0972c;
import e3.C0973d;
import e3.C0974e;
import g3.C1039a;
import g3.C1040b;
import g3.C1041c;
import g3.m;
import g3.p;
import g3.r;
import g3.s;
import g3.u;
import h3.C1077a;
import i0.C1089a;
import i3.C1092a;
import i3.C1096e;
import i3.C1097f;
import j3.C1160a;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.List;
import k3.C1210a;
import l3.C1290a;
import l3.C1291b;
import m3.AbstractC1328a;
import m3.InterfaceC1329b;
import s3.C1535f;

/* compiled from: RegistryFactory.java */
/* loaded from: classes.dex */
public final class g {

    /* compiled from: RegistryFactory.java */
    /* loaded from: classes.dex */
    public class a implements C1535f.b<Registry> {

        /* renamed from: a, reason: collision with root package name */
        public boolean f19340a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f19341b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f19342c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AbstractC1328a f19343d;

        public a(b bVar, List list, AbstractC1328a abstractC1328a) {
            this.f19341b = bVar;
            this.f19342c = list;
            this.f19343d = abstractC1328a;
        }

        @Override // s3.C1535f.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Registry get() {
            if (!this.f19340a) {
                C1089a.a("Glide registry");
                this.f19340a = true;
                try {
                    return g.a(this.f19341b, this.f19342c, this.f19343d);
                } finally {
                    this.f19340a = false;
                    C1089a.b();
                }
            }
            throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
        }
    }

    public static Registry a(b bVar, List<InterfaceC1329b> list, AbstractC1328a abstractC1328a) {
        a3.d f10 = bVar.f();
        a3.b e10 = bVar.e();
        Context applicationContext = bVar.i().getApplicationContext();
        e g10 = bVar.i().g();
        Registry registry = new Registry();
        b(applicationContext, registry, f10, e10, g10);
        c(applicationContext, bVar, registry, list, abstractC1328a);
        return registry;
    }

    public static void b(Context context, Registry registry, a3.d dVar, a3.b bVar, e eVar) {
        X2.e gVar;
        X2.e cVar;
        Object obj;
        Registry registry2;
        registry.o(new DefaultImageHeaderParser());
        registry.o(new m());
        Resources resources = context.getResources();
        List<ImageHeaderParser> g10 = registry.g();
        C1210a c1210a = new C1210a(context, g10, dVar, bVar);
        X2.e<ParcelFileDescriptor, Bitmap> l10 = VideoDecoder.l(dVar);
        com.bumptech.glide.load.resource.bitmap.a aVar = new com.bumptech.glide.load.resource.bitmap.a(registry.g(), resources.getDisplayMetrics(), dVar, bVar);
        if (eVar.a(c.b.class)) {
            cVar = new p();
            gVar = new g3.h();
        } else {
            gVar = new g3.g(aVar);
            cVar = new com.bumptech.glide.load.resource.bitmap.c(aVar, bVar);
        }
        registry.e("Animation", InputStream.class, Drawable.class, C1092a.f(g10, bVar));
        registry.e("Animation", ByteBuffer.class, Drawable.class, C1092a.a(g10, bVar));
        C1096e c1096e = new C1096e(context);
        C1041c c1041c = new C1041c(bVar);
        C1290a c1290a = new C1290a();
        l3.d dVar2 = new l3.d();
        ContentResolver contentResolver = context.getContentResolver();
        registry.a(ByteBuffer.class, new d3.c()).a(InputStream.class, new v(bVar)).e("Bitmap", ByteBuffer.class, Bitmap.class, gVar).e("Bitmap", InputStream.class, Bitmap.class, cVar);
        if (ParcelFileDescriptorRewinder.c()) {
            registry.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new r(aVar));
        }
        registry.e("Bitmap", AssetFileDescriptor.class, Bitmap.class, VideoDecoder.c(dVar));
        registry.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, l10).d(Bitmap.class, Bitmap.class, x.a.a()).e("Bitmap", Bitmap.class, Bitmap.class, new u()).b(Bitmap.class, c1041c).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new C1039a(resources, gVar)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new C1039a(resources, cVar)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new C1039a(resources, l10)).b(BitmapDrawable.class, new C1040b(dVar, c1041c)).e("Animation", InputStream.class, k3.c.class, new k3.j(g10, c1210a, bVar)).e("Animation", ByteBuffer.class, k3.c.class, c1210a).b(k3.c.class, new k3.d()).d(W2.a.class, W2.a.class, x.a.a()).e("Bitmap", W2.a.class, Bitmap.class, new k3.h(dVar)).c(Uri.class, Drawable.class, c1096e).c(Uri.class, Bitmap.class, new s(c1096e, dVar)).p(new C1077a.C0302a()).d(File.class, ByteBuffer.class, new d.b()).d(File.class, InputStream.class, new g.e()).c(File.class, File.class, new C1160a()).d(File.class, ParcelFileDescriptor.class, new g.b()).d(File.class, File.class, x.a.a()).p(new k.a(bVar));
        if (ParcelFileDescriptorRewinder.c()) {
            obj = BitmapDrawable.class;
            registry2 = registry;
            registry2.p(new ParcelFileDescriptorRewinder.a());
        } else {
            obj = BitmapDrawable.class;
            registry2 = registry;
        }
        d3.p<Integer, InputStream> g11 = d3.f.g(context);
        d3.p<Integer, AssetFileDescriptor> c10 = d3.f.c(context);
        d3.p<Integer, Drawable> e10 = d3.f.e(context);
        Class cls = Integer.TYPE;
        registry2.d(cls, InputStream.class, g11).d(Integer.class, InputStream.class, g11).d(cls, AssetFileDescriptor.class, c10).d(Integer.class, AssetFileDescriptor.class, c10).d(cls, Drawable.class, e10).d(Integer.class, Drawable.class, e10).d(Uri.class, InputStream.class, d3.u.f(context)).d(Uri.class, AssetFileDescriptor.class, d3.u.e(context));
        t.c cVar2 = new t.c(resources);
        t.a aVar2 = new t.a(resources);
        t.b bVar2 = new t.b(resources);
        Object obj2 = obj;
        registry2.d(Integer.class, Uri.class, cVar2).d(cls, Uri.class, cVar2).d(Integer.class, AssetFileDescriptor.class, aVar2).d(cls, AssetFileDescriptor.class, aVar2).d(Integer.class, InputStream.class, bVar2).d(cls, InputStream.class, bVar2);
        registry2.d(String.class, InputStream.class, new e.c()).d(Uri.class, InputStream.class, new e.c()).d(String.class, InputStream.class, new w.c()).d(String.class, ParcelFileDescriptor.class, new w.b()).d(String.class, AssetFileDescriptor.class, new w.a()).d(Uri.class, InputStream.class, new C0951a.c(context.getAssets())).d(Uri.class, AssetFileDescriptor.class, new C0951a.b(context.getAssets())).d(Uri.class, InputStream.class, new C0971b.a(context)).d(Uri.class, InputStream.class, new C0972c.a(context));
        registry2.d(Uri.class, InputStream.class, new C0973d.c(context));
        registry2.d(Uri.class, ParcelFileDescriptor.class, new C0973d.b(context));
        registry2.d(Uri.class, InputStream.class, new y.d(contentResolver)).d(Uri.class, ParcelFileDescriptor.class, new y.b(contentResolver)).d(Uri.class, AssetFileDescriptor.class, new y.a(contentResolver)).d(Uri.class, InputStream.class, new z.a()).d(URL.class, InputStream.class, new C0974e.a()).d(Uri.class, File.class, new l.a(context)).d(d3.h.class, InputStream.class, new C0970a.C0294a()).d(byte[].class, ByteBuffer.class, new C0952b.a()).d(byte[].class, InputStream.class, new C0952b.d()).d(Uri.class, Uri.class, x.a.a()).d(Drawable.class, Drawable.class, x.a.a()).c(Drawable.class, Drawable.class, new C1097f()).q(Bitmap.class, obj2, new C1291b(resources)).q(Bitmap.class, byte[].class, c1290a).q(Drawable.class, byte[].class, new l3.c(dVar, c1290a, dVar2)).q(k3.c.class, byte[].class, dVar2);
        X2.e<ByteBuffer, Bitmap> d10 = VideoDecoder.d(dVar);
        registry2.c(ByteBuffer.class, Bitmap.class, d10);
        registry2.c(ByteBuffer.class, obj2, new C1039a(resources, d10));
    }

    public static void c(Context context, b bVar, Registry registry, List<InterfaceC1329b> list, AbstractC1328a abstractC1328a) {
        for (InterfaceC1329b interfaceC1329b : list) {
            try {
                interfaceC1329b.b(context, bVar, registry);
            } catch (AbstractMethodError e10) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + interfaceC1329b.getClass().getName(), e10);
            }
        }
        if (abstractC1328a != null) {
            abstractC1328a.a(context, bVar, registry);
        }
    }

    public static C1535f.b<Registry> d(b bVar, List<InterfaceC1329b> list, AbstractC1328a abstractC1328a) {
        return new a(bVar, list, abstractC1328a);
    }
}
