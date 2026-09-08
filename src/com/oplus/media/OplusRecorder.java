package com.oplus.media;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class OplusRecorder {
    public static final int HAMR_BITRATE = 12200;
    public static final int HAMR_BYTES_P_SEC = 1600;
    public static final int HWAV_BYTES_P_SEC = 88200;
    public static final int HWAV_SAMPLERATE = 44100;
    public static final int MEDIA_RECORDER_ERROR_UNKNOWN = 1;
    public static final int MEDIA_RECORDER_INFO_MAX_DURATION_REACHED = 800;
    public static final int MEDIA_RECORDER_INFO_MAX_FILESIZE_REACHED = 801;
    public static final int MEDIA_RECORDER_INFO_UNKNOWN = 1;
    public static final int MEDIA_RECORDER_TRACK_INFO_COMPLETION_STATUS = 1000;
    public static final int MEDIA_RECORDER_TRACK_INFO_DATA_KBYTES = 1009;
    public static final int MEDIA_RECORDER_TRACK_INFO_DURATION_MS = 1003;
    public static final int MEDIA_RECORDER_TRACK_INFO_ENCODED_FRAMES = 1005;
    public static final int MEDIA_RECORDER_TRACK_INFO_INITIAL_DELAY_MS = 1007;
    public static final int MEDIA_RECORDER_TRACK_INFO_LIST_END = 2000;
    public static final int MEDIA_RECORDER_TRACK_INFO_LIST_START = 1000;
    public static final int MEDIA_RECORDER_TRACK_INFO_MAX_CHUNK_DUR_MS = 1004;
    public static final int MEDIA_RECORDER_TRACK_INFO_PROGRESS_IN_TIME = 1001;
    public static final int MEDIA_RECORDER_TRACK_INFO_START_OFFSET_MS = 1008;
    public static final int MEDIA_RECORDER_TRACK_INFO_TYPE = 1002;
    public static final int MEDIA_RECORDER_TRACK_INTER_CHUNK_TIME_MS = 1006;
    public static final int NAMR_BITRATE = 5150;
    public static final int NAMR_BYTES_P_SEC = 700;
    public static final int NWAV_BYTES_P_SEC = 16000;
    public static final int NWAV_SAMPLERATE = 8000;
    private static final String TAG = "OplusRecorder_Java";
    private a mEventHandler;
    private FileDescriptor mFd;
    private long mNativeContext;
    private b mOnErrorListener;
    private c mOnInfoListener;
    private String mPath;
    private Surface mSurface;

    /* loaded from: classes3.dex */
    public class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public OplusRecorder f28379a;

        public a(OplusRecorder oplusRecorder, Looper looper) {
            super(looper);
            this.f28379a = oplusRecorder;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f28379a.mNativeContext == 0) {
                Log.w(OplusRecorder.TAG, "OplusRecorder went away with unhandled events");
                return;
            }
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 100) {
                        if (i10 != 101) {
                            Log.e(OplusRecorder.TAG, "Unknown message type " + message.what);
                            return;
                        }
                    }
                }
                OplusRecorder.access$200(OplusRecorder.this);
                return;
            }
            OplusRecorder.access$100(OplusRecorder.this);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
    }

    /* loaded from: classes3.dex */
    public interface c {
    }

    static {
        Log.v(TAG, "loadLibrary");
        System.loadLibrary("oplusrecorder");
        native_init();
    }

    public OplusRecorder() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new a(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.mEventHandler = new a(this, mainLooper);
            } else {
                this.mEventHandler = null;
            }
        }
        Log.i(TAG, "OplusRecorder()");
        native_setup(new WeakReference(this));
    }

    private native void _prepare();

    private native void _setOutputFile(FileDescriptor fileDescriptor, long j10, long j11);

    public static /* synthetic */ b access$100(OplusRecorder oplusRecorder) {
        oplusRecorder.getClass();
        return null;
    }

    public static /* synthetic */ c access$200(OplusRecorder oplusRecorder) {
        oplusRecorder.getClass();
        return null;
    }

    public static final int getAudioSourceMax() {
        return 7;
    }

    private final native void native_finalize();

    private static final native void native_init();

    private native void native_reset();

    private final native void native_setup(Object obj);

    private static void postEventFromNative(Object obj, int i10, int i11, int i12, Object obj2) {
        a aVar;
        OplusRecorder oplusRecorder = (OplusRecorder) ((WeakReference) obj).get();
        if (oplusRecorder != null && (aVar = oplusRecorder.mEventHandler) != null) {
            oplusRecorder.mEventHandler.sendMessage(aVar.obtainMessage(i10, i11, i12, obj2));
        }
    }

    private native void setParameter(String str);

    public native void expandFile(FileDescriptor fileDescriptor, long j10, long j11, int i10);

    public native void expandFile(String str, int i10);

    public void finalize() {
        native_finalize();
    }

    public native int getMaxAmplitude();

    public native int getduration();

    public native void pause();

    public void prepare() {
        if (this.mPath != null) {
            FileOutputStream fileOutputStream = new FileOutputStream(this.mPath);
            try {
                _setOutputFile(fileOutputStream.getFD(), 0L, 0L);
            } finally {
                fileOutputStream.close();
            }
        } else {
            FileDescriptor fileDescriptor = this.mFd;
            if (fileDescriptor != null) {
                _setOutputFile(fileDescriptor, 0L, 0L);
            } else {
                throw new IOException("No valid output file");
            }
        }
        _prepare();
    }

    public native void release();

    public void reset() {
        native_reset();
        this.mEventHandler.removeCallbacksAndMessages(null);
    }

    public native void resume();

    public void setAudioChannels(int i10) {
        if (i10 > 0) {
            setParameter("audio-param-number-of-channels=" + i10);
            return;
        }
        throw new IllegalArgumentException("Number of channels is not positive");
    }

    public native void setAudioEncoder(int i10);

    public void setAudioEncodingBitRate(int i10) {
        if (i10 > 0) {
            setParameter("audio-param-encoding-bitrate=" + i10);
            return;
        }
        throw new IllegalArgumentException("Audio encoding bit rate is not positive");
    }

    public void setAudioSamplingRate(int i10) {
        if (i10 > 0) {
            setParameter("audio-param-sampling-rate=" + i10);
            return;
        }
        throw new IllegalArgumentException("Audio sampling rate is not positive");
    }

    public native void setAudioSource(int i10);

    public void setAuxiliaryOutputFile(FileDescriptor fileDescriptor) {
        Log.w(TAG, "setAuxiliaryOutputFile(FileDescriptor) is no longer supported.");
    }

    public native void setCamera(Camera camera);

    public void setCaptureRate(double d10) {
        setParameter(String.format("time-lapse-enable=1", new Object[0]));
        setParameter(String.format("time-between-time-lapse-frame-capture=%d", Integer.valueOf((int) ((1.0d / d10) * 1000.0d))));
    }

    public void setLocation(float f10, float f11) {
        int i10 = (int) ((f10 * 10000.0f) + 0.5d);
        int i11 = (int) ((10000.0f * f11) + 0.5d);
        if (i10 <= 900000 && i10 >= -900000) {
            if (i11 <= 1800000 && i11 >= -1800000) {
                setParameter("param-geotag-latitude=" + i10);
                setParameter("param-geotag-longitude=" + i11);
                return;
            }
            throw new IllegalArgumentException("Longitude: " + f11 + " out of range");
        }
        throw new IllegalArgumentException("Latitude: " + f10 + " out of range.");
    }

    public native void setMaxDuration(int i10);

    public native void setMaxFileSize(long j10);

    public void setOrientationHint(int i10) {
        if (i10 != 0 && i10 != 90 && i10 != 180 && i10 != 270) {
            throw new IllegalArgumentException("Unsupported angle: " + i10);
        }
        setParameter("video-param-rotation-angle-degrees=" + i10);
    }

    public void setOutputFile(FileDescriptor fileDescriptor) {
        this.mPath = null;
        this.mFd = fileDescriptor;
    }

    public native void setOutputFormat(int i10);

    public void setPreviewDisplay(Surface surface) {
        this.mSurface = surface;
    }

    public void setProfile(CamcorderProfile camcorderProfile) {
        setOutputFormat(camcorderProfile.fileFormat);
        setVideoFrameRate(camcorderProfile.videoFrameRate);
        setVideoSize(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
        setVideoEncodingBitRate(camcorderProfile.videoBitRate);
        setVideoEncoder(camcorderProfile.videoCodec);
        int i10 = camcorderProfile.quality;
        if (i10 < 1000 || i10 > 1007) {
            setAudioEncodingBitRate(camcorderProfile.audioBitRate);
            setAudioChannels(camcorderProfile.audioChannels);
            setAudioSamplingRate(camcorderProfile.audioSampleRate);
            setAudioEncoder(camcorderProfile.audioCodec);
        }
    }

    public native void setVideoEncoder(int i10);

    public void setVideoEncodingBitRate(int i10) {
        if (i10 > 0) {
            setParameter("video-param-encoding-bitrate=" + i10);
            return;
        }
        throw new IllegalArgumentException("Video encoding bit rate is not positive");
    }

    public native void setVideoFrameRate(int i10);

    public native void setVideoSize(int i10, int i11);

    public native void setVideoSource(int i10);

    public native void start();

    public native void stop();

    public void setAuxiliaryOutputFile(String str) {
        Log.w(TAG, "setAuxiliaryOutputFile(String) is no longer supported.");
    }

    public void setOutputFile(String str) {
        this.mFd = null;
        this.mPath = str;
    }

    public void setOnErrorListener(b bVar) {
    }

    public void setOnInfoListener(c cVar) {
    }
}
