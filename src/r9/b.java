package R9;

import S9.i;
import S9.k;
import S9.m;
import java.io.InputStream;
import org.apache.james.mime4j.stream.EntityState;

/* compiled from: MimeStreamParser.java */
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public R9.a f3365a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3366b;

    /* renamed from: c, reason: collision with root package name */
    public final m f3367c;

    /* compiled from: MimeStreamParser.java */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3368a;

        static {
            int[] iArr = new int[EntityState.values().length];
            f3368a = iArr;
            try {
                iArr[EntityState.T_BODY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3368a[EntityState.T_END_BODYPART.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3368a[EntityState.T_END_HEADER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3368a[EntityState.T_END_MESSAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3368a[EntityState.T_END_MULTIPART.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3368a[EntityState.T_END_OF_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3368a[EntityState.T_EPILOGUE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3368a[EntityState.T_FIELD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3368a[EntityState.T_PREAMBLE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3368a[EntityState.T_RAW_ENTITY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3368a[EntityState.T_START_BODYPART.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3368a[EntityState.T_START_HEADER.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f3368a[EntityState.T_START_MESSAGE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f3368a[EntityState.T_START_MULTIPART.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public b(m mVar) {
        this.f3365a = null;
        this.f3367c = mVar;
        this.f3366b = false;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x003e. Please report as an issue. */
    public void a(InputStream inputStream) {
        InputStream f10;
        k c10 = this.f3367c.c();
        if (c10.b() != null) {
            i j10 = this.f3367c.j(inputStream, c10.b());
            this.f3365a.k();
            this.f3365a.d();
            this.f3365a.h(j10);
            this.f3365a.e();
        } else {
            this.f3367c.i(inputStream);
        }
        while (true) {
            EntityState g10 = this.f3367c.g();
            switch (a.f3368a[g10.ordinal()]) {
                case 1:
                    S9.b b10 = this.f3367c.b();
                    if (this.f3366b) {
                        f10 = this.f3367c.d();
                    } else {
                        f10 = this.f3367c.f();
                    }
                    this.f3365a.g(b10, f10);
                    this.f3367c.h();
                case 2:
                    this.f3365a.b();
                    this.f3367c.h();
                case 3:
                    this.f3365a.e();
                    this.f3367c.h();
                case 4:
                    this.f3365a.c();
                    this.f3367c.h();
                case 5:
                    this.f3365a.m();
                    this.f3367c.h();
                case 6:
                    return;
                case 7:
                    this.f3365a.i(this.f3367c.f());
                    this.f3367c.h();
                case 8:
                    this.f3365a.h(this.f3367c.e());
                    this.f3367c.h();
                case 9:
                    this.f3365a.j(this.f3367c.f());
                    this.f3367c.h();
                case 10:
                    this.f3365a.l(this.f3367c.f());
                    this.f3367c.h();
                case 11:
                    this.f3365a.f();
                    this.f3367c.h();
                case 12:
                    this.f3365a.d();
                    this.f3367c.h();
                case 13:
                    this.f3365a.k();
                    this.f3367c.h();
                case 14:
                    this.f3365a.a(this.f3367c.b());
                    this.f3367c.h();
                default:
                    throw new IllegalStateException("Invalid state: " + g10);
            }
        }
    }

    public void b(R9.a aVar) {
        this.f3365a = aVar;
    }

    public b() {
        this(new m(new k(), null, null));
    }
}
