package F3;

import android.graphics.Matrix;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.AsyncTask;
import com.coui.responsiveui.config.ResponsiveUIConfig;
import com.coui.responsiveui.config.UIConfig;
import com.customize.contacts.activities.BusinessCardCaptureActivity;
import com.customize.contacts.camera.CameraSurfaceView;
import com.oplus.foundation.util.display.DisplayUtil;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: CameraManager.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: v, reason: collision with root package name */
    public static int f809v;

    /* renamed from: w, reason: collision with root package name */
    public static int f810w;

    /* renamed from: g, reason: collision with root package name */
    public Camera f817g;

    /* renamed from: h, reason: collision with root package name */
    public Camera.Parameters f818h;

    /* renamed from: i, reason: collision with root package name */
    public Point f819i;

    /* renamed from: j, reason: collision with root package name */
    public Point f820j;

    /* renamed from: k, reason: collision with root package name */
    public Point f821k;

    /* renamed from: l, reason: collision with root package name */
    public Point f822l;

    /* renamed from: m, reason: collision with root package name */
    public CameraSurfaceView f823m;

    /* renamed from: r, reason: collision with root package name */
    public e f828r;

    /* renamed from: s, reason: collision with root package name */
    public c f829s;

    /* renamed from: t, reason: collision with root package name */
    public BusinessCardCaptureActivity f830t;

    /* renamed from: u, reason: collision with root package name */
    public d f831u;

    /* renamed from: a, reason: collision with root package name */
    public final Object f811a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public String f812b = "off";

    /* renamed from: c, reason: collision with root package name */
    public int f813c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f814d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f815e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f816f = 0;

    /* renamed from: n, reason: collision with root package name */
    public boolean f824n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f825o = true;

    /* renamed from: p, reason: collision with root package name */
    public boolean f826p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f827q = false;

    /* compiled from: CameraManager.java */
    /* renamed from: F3.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0014a implements Camera.PictureCallback {
        public C0014a() {
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            if (bArr == null) {
                H7.b.b("CameraManager", "takePicture, data is null.");
                a.this.f825o = true;
                a.this.f817g.startPreview();
                return;
            }
            try {
                H7.b.b("CameraManager", "takePicture,CaptureTask");
                new b(bArr).execute(new Integer[0]);
            } catch (Throwable th) {
                H7.b.i("CameraManager", "takePicture, ex=" + th);
            }
            a.this.f825o = true;
        }
    }

    /* compiled from: CameraManager.java */
    /* loaded from: classes3.dex */
    public class b extends AsyncTask<Integer, Integer, Object> {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f833a;

        public b(byte[] bArr) {
            this.f833a = bArr;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object doInBackground(Integer... numArr) {
            return a.this.f829s.b(this.f833a, numArr);
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Object obj) {
            a.this.f829s.a(obj);
        }
    }

    /* compiled from: CameraManager.java */
    /* loaded from: classes3.dex */
    public interface c {
        void a(Object obj);

        Object b(byte[] bArr, Integer... numArr);
    }

    /* compiled from: CameraManager.java */
    /* loaded from: classes3.dex */
    public interface d {
        void r(int i10, int i11);
    }

    public a(BusinessCardCaptureActivity businessCardCaptureActivity, CameraSurfaceView cameraSurfaceView) {
        this.f830t = businessCardCaptureActivity;
        this.f823m = cameraSurfaceView;
        this.f831u = businessCardCaptureActivity;
        l();
        m(this.f830t);
    }

    public static String f(String str, Collection<String> collection, String... strArr) {
        if (H7.a.b()) {
            H7.b.e("CameraManager", "Requesting " + str + " value from among: " + Arrays.toString(strArr) + " supportedValues: " + collection);
        }
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    H7.b.e("CameraManager", "Can set " + str + " to: " + str2);
                    return str2;
                }
            }
        }
        H7.b.e("CameraManager", "No supported values match");
        return null;
    }

    public static void m(BusinessCardCaptureActivity businessCardCaptureActivity) {
        f809v = DisplayUtil.f(businessCardCaptureActivity, true);
        f810w = DisplayUtil.e(businessCardCaptureActivity, true);
    }

    public static void v(Camera.Parameters parameters, boolean z10) {
        String f10;
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (z10) {
            f10 = f("focus mode", supportedFocusModes, "auto");
        } else {
            f10 = f("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto");
        }
        if (f10 != null) {
            if (f10.equals(parameters.getFocusMode())) {
                H7.b.e("CameraManager", "Focus mode already set to " + f10);
                return;
            }
            parameters.setFocusMode(f10);
        }
    }

    public void A(int i10) {
        this.f816f = i10;
    }

    public final void B() {
        int[] iArr;
        int i10;
        List<int[]> supportedPreviewFpsRange = this.f818h.getSupportedPreviewFpsRange();
        if (supportedPreviewFpsRange != null && !supportedPreviewFpsRange.isEmpty()) {
            int i11 = supportedPreviewFpsRange.get(0)[0];
            int i12 = supportedPreviewFpsRange.get(0)[1];
            int i13 = 1;
            while (i13 < supportedPreviewFpsRange.size() && (i10 = (iArr = supportedPreviewFpsRange.get(i13))[1]) < 30000) {
                i11 = iArr[0];
                i13++;
                i12 = i10;
            }
            this.f818h.setPreviewFpsRange(i11, i12);
        }
    }

    public void C() {
        D(false);
    }

    public void D(boolean z10) {
        BusinessCardCaptureActivity businessCardCaptureActivity;
        CameraSurfaceView cameraSurfaceView;
        H7.b.b("CameraManager", "startPreview paused = " + z10);
        synchronized (this.f811a) {
            try {
                if (this.f817g == null && (cameraSurfaceView = this.f823m) != null && cameraSurfaceView.b()) {
                    k();
                }
                if (this.f817g == null) {
                    return;
                }
                try {
                    this.f826p = true;
                    z(this.f830t);
                    this.f817g.startPreview();
                    this.f828r = new e(this.f830t, this.f817g, this);
                } catch (RuntimeException e10) {
                    H7.b.c("CameraManager", "Fail to connect to camera service. " + e10);
                    if (!z10 && (businessCardCaptureActivity = this.f830t) != null) {
                        businessCardCaptureActivity.finish();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void E() {
        H7.b.b("CameraManager", "stopPreview");
        e eVar = this.f828r;
        if (eVar != null) {
            eVar.d();
            this.f828r = null;
        }
        this.f826p = false;
        try {
            e();
        } catch (Exception e10) {
            H7.b.c("CameraManager", "close camera fail." + e10);
            this.f817g = null;
        }
    }

    public boolean F() {
        if (this.f817g != null && this.f825o) {
            this.f825o = false;
            G();
            if (H7.a.b()) {
                H7.b.b("CameraManager", "takePicture isChangeOrientation:,mJpegRotation:" + this.f814d);
            }
            try {
                this.f818h.setRotation(this.f814d);
                this.f817g.enableShutterSound(false);
                this.f817g.setParameters(this.f818h);
                this.f817g.takePicture(null, null, new C0014a());
                return true;
            } catch (Exception e10) {
                this.f825o = true;
                H7.b.c("CameraManager", "takePicture,failed: " + e10);
                return false;
            }
        }
        this.f825o = true;
        H7.b.i("CameraManager", "takePicture,failed");
        return false;
    }

    public final void G() {
        int i10 = this.f816f;
        if (i10 != -1) {
            this.f814d = (this.f815e + i10) % 360;
        } else {
            this.f814d = this.f815e;
        }
        if (H7.a.b()) {
            H7.b.b("CameraManager", "updateJpegRotation, mCurrentOrientation: " + this.f816f + ", mJpegRotation: " + this.f814d);
        }
    }

    public void d() {
        synchronized (this.f811a) {
            try {
                Camera camera = this.f817g;
                if (camera != null) {
                    camera.setOneShotPreviewCallback(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        if (H7.a.b()) {
            H7.b.b("CameraManager", "closeCamera");
        }
        synchronized (this.f811a) {
            try {
                Camera camera = this.f817g;
                if (camera != null) {
                    camera.setPreviewCallback(null);
                    this.f817g.stopPreview();
                    this.f817g.release();
                    this.f817g = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Point g() {
        return this.f821k;
    }

    public Camera h() {
        return this.f817g;
    }

    public int i() {
        return this.f815e;
    }

    public void j(boolean z10) {
        if (this.f817g == null) {
            return;
        }
        if (this.f818h.isZoomSupported()) {
            int maxZoom = this.f818h.getMaxZoom();
            int zoom = this.f818h.getZoom();
            if (z10 && zoom < maxZoom) {
                zoom++;
            } else if (zoom > 0) {
                zoom--;
            }
            this.f818h.setZoom(zoom);
            try {
                this.f817g.setParameters(this.f818h);
                return;
            } catch (Exception e10) {
                H7.b.c("CameraManager", "handleZoom failed: " + e10);
                return;
            }
        }
        H7.b.b("CameraManager", "zoom not supported");
    }

    public final void k() {
        boolean z10;
        try {
            p();
            Camera camera = this.f817g;
            if (camera == null) {
                return;
            }
            this.f818h = camera.getParameters();
            this.f817g.setDisplayOrientation(this.f815e);
            if (!this.f827q) {
                this.f827q = true;
                if (ResponsiveUIConfig.getDefault(this.f830t).getUiConfig().getValue().getStatus() != UIConfig.Status.UNFOLD) {
                    int i10 = (f809v * 4) / 3;
                    Point point = new Point(f809v, i10);
                    this.f819i = point;
                    this.f820j = F3.b.c(this.f818h, point);
                    Point point2 = new Point(this.f820j);
                    this.f821k = point2;
                    d dVar = this.f831u;
                    if (dVar != null) {
                        dVar.r(point2.x, i10);
                        this.f831u = null;
                    }
                } else {
                    int i11 = f809v;
                    Point point3 = new Point(i11, f810w);
                    this.f819i = point3;
                    this.f820j = F3.b.c(this.f818h, point3);
                    Point point4 = new Point(this.f820j);
                    this.f821k = point4;
                    d dVar2 = this.f831u;
                    if (dVar2 != null) {
                        dVar2.r(point4.y, i11);
                        this.f831u = null;
                    }
                }
                this.f822l = F3.b.b(this.f818h, this.f819i, f810w, f809v);
                if (H7.a.b()) {
                    H7.b.e("CameraManager", "Screen resolution in current orientation: " + this.f819i + "\nCamera resolution: " + this.f820j + "\nBest available picture size: " + this.f822l);
                }
            }
            Camera.Parameters parameters = this.f818h;
            Point point5 = this.f821k;
            parameters.setPreviewSize(point5.x, point5.y);
            Camera.Parameters parameters2 = this.f818h;
            Point point6 = this.f822l;
            parameters2.setPictureSize(point6.x, point6.y);
            if (this.f818h.getMaxNumFocusAreas() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f824n = z10;
            if (H7.a.b()) {
                H7.b.b("CameraManager", "initCamera, mSupportFocus:" + this.f824n + " ,mCameraOrientation = " + this.f815e);
            }
            u(this.f812b);
            B();
            y(true);
            this.f817g.setParameters(this.f818h);
            this.f817g.setPreviewDisplay(this.f823m.getHolder());
            Camera.Size previewSize = this.f817g.getParameters().getPreviewSize();
            if (previewSize != null) {
                Point point7 = this.f821k;
                if (point7.x != previewSize.width || point7.y != previewSize.height) {
                    H7.b.i("CameraManager", "Camera said it supported preview size " + this.f821k.x + 'x' + this.f821k.y + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height);
                    Point point8 = this.f821k;
                    point8.x = previewSize.width;
                    point8.y = previewSize.height;
                }
            }
        } catch (Exception e10) {
            H7.b.c("CameraManager", "Exception e: " + e10);
        }
    }

    public final void l() {
        try {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(this.f813c, cameraInfo);
            this.f815e = cameraInfo.orientation;
        } catch (Exception e10) {
            H7.b.c("CameraManager", "getCameraInfo error!" + e10);
            this.f815e = 90;
        }
        if (H7.a.b()) {
            H7.b.b("CameraManager", "initCameraDisplayOrientation, mCameraOrientation = " + this.f815e);
        }
    }

    public synchronized boolean n() {
        boolean z10;
        if (this.f817g != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }

    public void o(boolean z10) {
        x(null, null);
    }

    public final void p() {
        if (H7.a.b()) {
            H7.b.b("CameraManager", "openCamera start");
        }
        synchronized (this.f811a) {
            if (this.f817g == null) {
                try {
                    this.f817g = Camera.open();
                } catch (Exception e10) {
                    H7.b.c("CameraManager", "Exception e: " + e10);
                }
            }
        }
        if (H7.a.b()) {
            H7.b.b("CameraManager", "openCamera end");
        }
    }

    public synchronized Matrix q() {
        Matrix matrix;
        int i10 = this.f815e;
        matrix = new Matrix();
        F3.b.g(matrix, false, i10, this.f823m.getWidth(), this.f823m.getHeight());
        return matrix;
    }

    public synchronized void r(int i10, int i11, int i12, int i13) {
        e eVar;
        if (this.f817g != null && this.f826p && (eVar = this.f828r) != null) {
            eVar.c(i10, i11, i12, i13);
        }
    }

    public void s(int i10) {
        this.f815e = i10;
    }

    public void t(c cVar) {
        this.f829s = cVar;
    }

    public void u(String str) {
        Camera.Parameters parameters;
        if (this.f817g != null && (parameters = this.f818h) != null) {
            List<String> supportedFlashModes = parameters.getSupportedFlashModes();
            if (supportedFlashModes != null && supportedFlashModes.size() != 0) {
                Iterator<String> it = supportedFlashModes.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(str)) {
                        try {
                            H7.b.b("CameraManager", "setFlashMode flashMode:" + str);
                            this.f818h.setFlashMode(str);
                            this.f817g.setParameters(this.f818h);
                            this.f812b = str;
                            return;
                        } catch (Exception e10) {
                            H7.b.c("CameraManager", "Camera setParameters error" + e10);
                            return;
                        }
                    }
                }
                return;
            }
            H7.b.i("CameraManager", "setFlashMode no supported FlashModes");
            this.f812b = "off";
        }
    }

    public final void w(Camera camera, List<Camera.Area> list, List<Camera.Area> list2) {
        Camera.Parameters parameters = camera.getParameters();
        if (parameters == null) {
            H7.b.i("CameraManager", "Device error: no camera parameters are available.");
            return;
        }
        if (parameters.getMaxNumFocusAreas() > 0) {
            parameters.setFocusAreas(list);
        } else {
            H7.b.e("CameraManager", "Device does not support focus areas");
        }
        if (parameters.getMaxNumMeteringAreas() > 0) {
            parameters.setMeteringAreas(list2);
        } else {
            H7.b.e("CameraManager", "Device does not support metering areas");
        }
        if (list == null) {
            v(parameters, false);
        } else {
            v(parameters, true);
        }
        try {
            camera.setParameters(parameters);
        } catch (Exception e10) {
            H7.b.c("CameraManager", "setFocusAreaParameters failed:" + e10);
        }
    }

    public synchronized void x(List<Camera.Area> list, List<Camera.Area> list2) {
        Camera camera = this.f817g;
        if (camera != null && this.f826p) {
            w(camera, list, list2);
        }
    }

    public final void y(boolean z10) {
        Camera.Parameters parameters = this.f818h;
        if (parameters != null && this.f817g != null) {
            if (z10) {
                List<String> supportedFocusModes = parameters.getSupportedFocusModes();
                if (supportedFocusModes != null && !supportedFocusModes.isEmpty()) {
                    if (supportedFocusModes.contains("continuous-picture")) {
                        this.f818h.setFocusMode("continuous-picture");
                    } else if (supportedFocusModes.contains("fixed")) {
                        this.f818h.setFocusMode("fixed");
                    } else if (supportedFocusModes.contains("infinity")) {
                        this.f818h.setFocusMode("infinity");
                    } else {
                        this.f818h.setFocusMode(supportedFocusModes.get(0));
                    }
                } else {
                    H7.b.b("CameraManager", "setFocusMode, modes is null");
                    return;
                }
            } else if (this.f824n) {
                parameters.setFocusMode("auto");
            }
            try {
                this.f817g.setParameters(this.f818h);
            } catch (Exception e10) {
                H7.b.b("CameraManager", "setFocusMode failed: " + e10);
            }
        }
    }

    public void z(Camera.PreviewCallback previewCallback) {
        synchronized (this.f811a) {
            try {
                Camera camera = this.f817g;
                if (camera != null && previewCallback != null) {
                    camera.setOneShotPreviewCallback(previewCallback);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
