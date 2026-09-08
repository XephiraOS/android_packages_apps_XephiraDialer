package com.android.contacts.editor;

import Z0.b;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.editor.A;
import com.android.contacts.framework.omoji.utils.OmojiUtils;
import com.android.contacts.framework.omoji.view.AlphaMovieView;
import com.android.contacts.model.EntityDelta;
import com.customize.contacts.util.h0;
import com.oplus.dialer.R;
import f.C0991a;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class PhotoEditorView extends RelativeLayout implements A {

    /* renamed from: a, reason: collision with root package name */
    public String f15352a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f15353b;

    /* renamed from: c, reason: collision with root package name */
    public View f15354c;

    /* renamed from: d, reason: collision with root package name */
    public EntityDelta.ValuesDelta f15355d;

    /* renamed from: e, reason: collision with root package name */
    public EntityDelta.ValuesDelta f15356e;

    /* renamed from: f, reason: collision with root package name */
    public A.a f15357f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15358g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f15359h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f15360i;

    /* renamed from: j, reason: collision with root package name */
    public String f15361j;

    /* renamed from: k, reason: collision with root package name */
    public AlphaMovieView f15362k;

    /* renamed from: l, reason: collision with root package name */
    public Uri f15363l;

    /* renamed from: m, reason: collision with root package name */
    public String f15364m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f15365n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f15366o;

    /* renamed from: p, reason: collision with root package name */
    public AnimatorSet f15367p;

    /* renamed from: q, reason: collision with root package name */
    public ObjectAnimator f15368q;

    /* renamed from: r, reason: collision with root package name */
    public ObjectAnimator f15369r;

    /* renamed from: x, reason: collision with root package name */
    public Runnable f15370x;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: com.android.contacts.editor.PhotoEditorView$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0161a implements f1.d {
            public C0161a() {
            }

            @Override // f1.d
            public void a(boolean z10) {
                if (z10) {
                    PhotoEditorView.this.f15362k.postDelayed(PhotoEditorView.this.f15370x, 700L);
                }
            }
        }

        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            PhotoEditorView.this.f15362k.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (PhotoEditorView.this.f15363l == null && !PhotoEditorView.this.f15358g) {
                OmojiUtils.a(PhotoEditorView.this.getContext(), new C0161a());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* loaded from: classes.dex */
        public class a implements AlphaMovieView.b {
            public a() {
            }

            @Override // com.android.contacts.framework.omoji.view.AlphaMovieView.b
            public void a() {
                if (PhotoEditorView.this.isAttachedToWindow()) {
                    PhotoEditorView.this.f15362k.M();
                    if (!com.android.contacts.framework.baseui.util.o.e(PhotoEditorView.this.getContext()) && !PhotoEditorView.this.f15365n) {
                        PhotoEditorView.this.f15362k.setVisibility(8);
                        return;
                    }
                    if (PhotoEditorView.this.f15367p == null) {
                        PhotoEditorView.this.f15367p = new AnimatorSet();
                    }
                    if (PhotoEditorView.this.f15368q == null) {
                        PhotoEditorView photoEditorView = PhotoEditorView.this;
                        photoEditorView.f15368q = PhotoEditorView.v(photoEditorView.f15353b, 200, 0.0f, 1.0f, false);
                    }
                    if (PhotoEditorView.this.f15369r == null) {
                        PhotoEditorView photoEditorView2 = PhotoEditorView.this;
                        photoEditorView2.f15369r = PhotoEditorView.v(photoEditorView2.f15362k, 200, 1.0f, 0.0f, true);
                    }
                    PhotoEditorView.this.f15367p.playTogether(PhotoEditorView.this.f15368q, PhotoEditorView.this.f15369r);
                    PhotoEditorView.this.f15367p.start();
                }
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PhotoEditorView.this.f15366o && PhotoEditorView.this.isAttachedToWindow()) {
                OmojiUtils.n(PhotoEditorView.this.getContext());
                PhotoEditorView.this.f15362k.setVisibility(0);
                PhotoEditorView.this.f15362k.N(1, false, false);
                PhotoEditorView.this.f15362k.setOnVideoEndedListener(new a());
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f15375a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f15376b;

        public c(boolean z10, View view) {
            this.f15375a = z10;
            this.f15376b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f15375a) {
                this.f15376b.setVisibility(8);
            }
        }
    }

    public PhotoEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15352a = "data15";
        this.f15358g = false;
        this.f15360i = true;
        this.f15362k = null;
        this.f15366o = true;
        this.f15370x = new b();
    }

    private void setDisplayPhoto(byte[] bArr) {
        boolean z10;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        if (decodeByteArray != null) {
            this.f15353b.setImageBitmap(decodeByteArray);
            View view = this.f15354c;
            if (!this.f15359h && isEnabled() && z()) {
                z10 = true;
            } else {
                z10 = false;
            }
            view.setEnabled(z10);
            this.f15358g = true;
            this.f15355d.r0(false);
            return;
        }
        C();
    }

    private void setOmojiValues(EntityDelta entityDelta) {
        EntityDelta.ValuesDelta m10;
        if (entityDelta != null) {
            ArrayList<EntityDelta.ValuesDelta> D10 = entityDelta.D("vnd.android.cursor.item/omoji_photo");
            ArrayList<EntityDelta.ValuesDelta> D11 = entityDelta.D("vnd.android.cursor.item/photo");
            if (D11 != null) {
                Iterator<EntityDelta.ValuesDelta> it = D11.iterator();
                while (it.hasNext()) {
                    EntityDelta.ValuesDelta next = it.next();
                    Long x10 = next.x(BreenoCallContract.BaseColumns._ID);
                    Long x11 = next.x("raw_contact_id");
                    if (x11 != null && x10 != null) {
                        if (D10 != null) {
                            Iterator<EntityDelta.ValuesDelta> it2 = D10.iterator();
                            while (it2.hasNext()) {
                                if (x11.equals(it2.next().x("raw_contact_id"))) {
                                    break;
                                }
                            }
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("mimetype", "vnd.android.cursor.item/omoji_photo");
                        if (x10.longValue() > 0) {
                            contentValues.put(BreenoCallContract.BaseColumns._ID, (Integer) (-1));
                            m10 = EntityDelta.ValuesDelta.n(contentValues);
                            m10.d0("raw_contact_id", x11.longValue());
                        } else {
                            contentValues.put("raw_contact_id", x11);
                            m10 = EntityDelta.ValuesDelta.m(contentValues);
                        }
                        entityDelta.d(m10);
                    } else if (H7.a.b()) {
                        H7.b.b("PhotoEditorView", "rawContactId is null or photoDataId is null");
                    }
                }
            }
        }
    }

    public static ObjectAnimator v(View view, int i10, float f10, float f11, boolean z10) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", f10, f11);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(Z3.f.f5911k);
        ofFloat.addListener(new c(z10, view));
        return ofFloat;
    }

    private void x(EntityDelta.ValuesDelta valuesDelta) {
        if (valuesDelta == null) {
            return;
        }
        this.f15360i = valuesDelta.q("account_writable", Boolean.TRUE).booleanValue();
        this.f15361j = valuesDelta.z("account_name");
        valuesDelta.p0("account_writable");
        valuesDelta.p0("account_name");
    }

    public final /* synthetic */ void A(View view) {
        u();
    }

    public void B() {
        AlphaMovieView alphaMovieView = this.f15362k;
        if (alphaMovieView != null) {
            alphaMovieView.S();
            this.f15362k.setVisibility(8);
            this.f15362k.M();
        }
    }

    public void C() {
        boolean z10;
        Uri uri = this.f15363l;
        int i10 = R.drawable.pb_ic_my_profile_large;
        if (uri != null) {
            if (this.f15365n) {
                this.f15353b.setImageDrawable(C0991a.b(getContext(), R.drawable.pb_ic_my_profile_large));
            } else {
                b.c cVar = new b.c(this.f15364m, String.valueOf(ContentUris.parseId(uri)), false);
                cVar.f5789g = 3;
                Z0.b.g(getContext()).j(this.f15353b, null, -1, false, false, cVar);
            }
        } else {
            Context context = getContext();
            if (!this.f15365n) {
                i10 = R.drawable.pb_ic_default_large_photo;
            }
            this.f15353b.setImageDrawable(C0991a.b(context, i10));
        }
        if (this.f15359h) {
            this.f15354c.setEnabled(false);
            this.f15353b.setEnabled(false);
            return;
        }
        View view = this.f15354c;
        if (isEnabled() && z()) {
            z10 = true;
        } else {
            z10 = false;
        }
        view.setEnabled(z10);
        this.f15358g = false;
        this.f15355d.r0(true);
    }

    public void D(EntityDelta entityDelta, Bundle bundle) {
        ArrayList<EntityDelta.ValuesDelta> D10;
        setOmojiValues(entityDelta);
        if (entityDelta != null && (D10 = entityDelta.D("vnd.android.cursor.item/omoji_photo")) != null) {
            Iterator<EntityDelta.ValuesDelta> it = D10.iterator();
            while (it.hasNext()) {
                EntityDelta.ValuesDelta next = it.next();
                if (next != null) {
                    if (bundle != null) {
                        next.e0("data1", bundle.getParcelable("output_uri").toString());
                        next.e0("data2", bundle.getString("extra_data"));
                    } else {
                        next.Y();
                    }
                }
            }
        }
    }

    @Override // com.android.contacts.editor.A
    public void c() {
        C();
    }

    @Override // com.android.contacts.editor.A
    public void g(com.android.contacts.model.c cVar, EntityDelta.ValuesDelta valuesDelta, EntityDelta entityDelta, boolean z10, ViewIdGenerator viewIdGenerator) {
        x(valuesDelta);
        if (this.f15360i) {
            this.f15355d = valuesDelta;
        } else {
            this.f15355d = com.android.contacts.model.d.v(entityDelta, cVar);
            this.f15356e = valuesDelta;
        }
        this.f15359h = z10;
        if (viewIdGenerator != null) {
            setId(viewIdGenerator.d(entityDelta, cVar, valuesDelta, 0));
        }
        if (valuesDelta != null) {
            byte[] t10 = valuesDelta.t(getPhotoColumn());
            if (t10 != null) {
                setDisplayPhoto(t10);
                return;
            } else {
                C();
                return;
            }
        }
        C();
    }

    public String getPhotoColumn() {
        return this.f15352a;
    }

    @Override // com.android.contacts.editor.A
    public boolean isEmpty() {
        return !this.f15358g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AlphaMovieView alphaMovieView = this.f15362k;
        if (alphaMovieView != null && alphaMovieView.getVisibility() == 0) {
            this.f15362k.S();
            this.f15362k.M();
            this.f15362k.removeCallbacks(this.f15370x);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f15353b = (ImageView) findViewById(R.id.photo);
        this.f15354c = findViewById(R.id.frame);
        if (OmojiUtils.h(getContext()) < 3) {
            if (this.f15362k == null) {
                this.f15362k = (AlphaMovieView) ((ViewStub) findViewById(R.id.video_view_stub)).inflate();
            }
            this.f15362k.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        }
        View view = this.f15354c;
        if (view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.android.contacts.editor.C
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PhotoEditorView.this.A(view2);
            }
        });
    }

    public void setDisplayName(String str) {
        this.f15364m = str;
    }

    @Override // com.android.contacts.editor.A
    public void setEditorListener(A.a aVar) {
        this.f15357f = aVar;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.f15354c.setEnabled(z10);
    }

    public void setIsUserProfile(boolean z10) {
        this.f15365n = z10;
    }

    public void setLookupUri(Uri uri) {
        this.f15363l = uri;
    }

    public void setNeedPlay(boolean z10) {
        this.f15366o = z10;
    }

    public void setPhotoBitmap(Bitmap bitmap) {
        boolean z10;
        EntityDelta.ValuesDelta valuesDelta;
        if (bitmap == null) {
            if (!this.f15360i && this.f15355d.K() && this.f15355d.t(getPhotoColumn()) == null) {
                A.a aVar = this.f15357f;
                if (aVar != null) {
                    aVar.e(this.f15361j);
                    return;
                }
                return;
            }
            this.f15355d.i0(getPhotoColumn(), null);
            if (!this.f15360i && (valuesDelta = this.f15356e) != null) {
                byte[] t10 = valuesDelta.t(getPhotoColumn());
                if (t10 != null) {
                    setDisplayPhoto(t10);
                    return;
                } else {
                    C();
                    return;
                }
            }
            C();
            return;
        }
        try {
            byte[] d10 = com.android.contacts.util.i.d(bitmap);
            this.f15355d.i0(getPhotoColumn(), d10);
            if (H7.a.b()) {
                H7.b.b("PhotoEditorView", "setPhotoBitmap photo final size = " + d10.length);
            }
            this.f15353b.setImageBitmap(bitmap);
            View view = this.f15354c;
            if (isEnabled() && z()) {
                z10 = true;
            } else {
                z10 = false;
            }
            view.setEnabled(z10);
            this.f15358g = true;
            this.f15355d.r0(false);
            this.f15355d.b0("is_super_primary", 1);
        } catch (Exception e10) {
            H7.b.i("PhotoEditorView", "Unable to serialize photo: " + e10);
        }
    }

    public void setSuperPrimary(boolean z10) {
        this.f15355d.b0("is_super_primary", z10 ? 1 : 0);
    }

    public final void u() {
        A.a aVar = this.f15357f;
        if (aVar != null) {
            aVar.c(1);
            h0.M(getContext(), ContactEditorFragment.r3(), "profile_photo");
        }
    }

    public boolean w() {
        return this.f15358g;
    }

    public boolean y() {
        AlphaMovieView alphaMovieView = this.f15362k;
        if (alphaMovieView != null && alphaMovieView.getVisibility() == 0 && this.f15362k.G()) {
            return true;
        }
        return false;
    }

    public final boolean z() {
        return true;
    }

    @Override // com.android.contacts.editor.A
    public void a() {
    }

    @Override // com.android.contacts.editor.A
    public void setDeletable(boolean z10) {
    }
}
