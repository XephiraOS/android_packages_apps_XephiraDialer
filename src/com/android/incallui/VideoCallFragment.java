package com.android.incallui;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.android.incallui.VideoCallPresenter;
import java.util.Map;

/* loaded from: classes.dex */
public class VideoCallFragment extends BaseFragment<VideoCallPresenter, VideoCallPresenter.VideoCallUi> implements VideoCallPresenter.VideoCallUi {
    private static final int DEFAUT_VIDEO_SIZE_HEIGHT = 640;
    private static final int DEFAUT_VIDEO_SIZE_WIDTH = 480;
    private static final int DIMENSIONS_NOT_SET = -1;
    private static final long DISMISS_VIDEO_CALL_DELAY_TIME = 3000;
    private static final double MAX_RATIO = 0.75d;
    public static final int SURFACE_DISPLAY = 1;
    public static final int SURFACE_PREVIEW = 2;
    private static final String TAG = "VideoCallFragment";
    public static final float TEXTUREVIEW_INVISIBLE = 0.01f;
    public static final float TEXTUREVIEW_VISIBLE = 1.0f;
    private static boolean mOplusShowDisplayVideoBackground = false;
    private static boolean mOplusShowPreviewVideoBackground = false;
    private static Point sDisplaySize = null;
    private static VideoCallSurface sDisplaySurface = null;
    private static VideoCallSurface sPreviewSurface = null;
    private static boolean sVideoSurfacesInUse = false;
    private int mAnimationDuration;
    private int mDefaultSmallSurfaceWidth;
    Point mDisplayLargeSize;
    Point mDisplayLargeSizeLand;
    Point mDisplayLargeSizeNotFullScreen;
    Point mDisplaySmallSize;
    private ImageView mDisplayVideoBackground;
    private ImageView mDisplayVideoCallMask;
    private View mDisplayVideoContainer;
    private ImageView mDisplayVideoPause;
    private boolean mIsLayoutComplete = false;
    private float mOplusScreenRatio;
    private Point mPreviewLargeSize;
    private Point mPreviewLargeSizeNotFullScreen;
    private Point mPreviewSmallSize;
    private ImageView mPreviewVideoBackground;
    private ImageView mPreviewVideoCallMask;
    private View mPreviewVideoContainer;
    private ImageView mPreviewVideoPause;
    private View mVideoViews;
    private ViewStub mVideoViewsStub;

    /* loaded from: classes.dex */
    public static class VideoCallSurface implements TextureView.SurfaceTextureListener, View.OnClickListener, View.OnAttachStateChangeListener, View.OnTouchListener {
        private int mHeight;
        private boolean mIsDoneWithSurface;
        private VideoCallPresenter mPresenter;
        private Surface mSavedSurface;
        private SurfaceTexture mSavedSurfaceTexture;
        private int mSurfaceId;
        private TextureView mTextureView;
        private int mWidth;

        public VideoCallSurface(VideoCallPresenter videoCallPresenter, int i10, TextureView textureView) {
            this(videoCallPresenter, i10, textureView, -1, -1);
        }

        private boolean createSurface() {
            int i10;
            if (Log.sDebug) {
                Log.d(VideoCallFragment.TAG, "createSurface mSavedSurfaceTexture=" + this.mSavedSurfaceTexture + " mSurfaceId =" + this.mSurfaceId + " mWidth =" + this.mWidth + " mHeight =" + this.mHeight);
            }
            if (this.mSavedSurfaceTexture == null) {
                return false;
            }
            this.mSavedSurface = new Surface(this.mSavedSurfaceTexture);
            int i11 = this.mWidth;
            if (i11 != -1 && (i10 = this.mHeight) != -1) {
                this.mSavedSurfaceTexture.setDefaultBufferSize(i11, i10);
                return true;
            }
            return true;
        }

        private void onSurfaceCreated() {
            VideoCallPresenter videoCallPresenter = this.mPresenter;
            if (videoCallPresenter != null) {
                videoCallPresenter.onSurfaceCreated(this.mSurfaceId);
            } else {
                Log.e(VideoCallFragment.TAG, "onSurfaceTextureAvailable: Presenter is null");
            }
        }

        private void onSurfaceDestroyed() {
            VideoCallPresenter videoCallPresenter = this.mPresenter;
            if (videoCallPresenter != null) {
                videoCallPresenter.onSurfaceDestroyed(this.mSurfaceId);
            } else {
                Log.e(VideoCallFragment.TAG, "onSurfaceTextureDestroyed: Presenter is null.");
            }
        }

        private void onSurfaceReleased() {
            VideoCallPresenter videoCallPresenter = this.mPresenter;
            if (videoCallPresenter != null) {
                videoCallPresenter.onSurfaceReleased(this.mSurfaceId);
            } else {
                Log.d(VideoCallFragment.TAG, "setDoneWithSurface: Presenter is null.");
            }
        }

        public Surface getSurface() {
            return this.mSavedSurface;
        }

        public Point getSurfaceDimensions() {
            return new Point(this.mWidth, this.mHeight);
        }

        public TextureView getTextureView() {
            return this.mTextureView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.mPresenter != null) {
                if (OplusPhoneUtils.noNeedHandleClickForCMCC()) {
                    return;
                }
                this.mPresenter.onSurfaceClick(this.mSurfaceId);
                return;
            }
            Log.e(VideoCallFragment.TAG, "onClick: Presenter is null.");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
            SurfaceTexture surfaceTexture2;
            if (Log.sDebug) {
                Log.i(VideoCallFragment.TAG, "onSurfaceTextureAvailable: " + surfaceTexture);
            }
            if (Log.sDebug) {
                Log.d(VideoCallFragment.TAG, " onSurfaceTextureAvailable mSurfaceId=" + this.mSurfaceId + " surfaceTexture=" + surfaceTexture + " width=" + i10 + " height=" + i11 + " mSavedSurfaceTexture=" + this.mSavedSurfaceTexture);
                StringBuilder sb = new StringBuilder();
                sb.append(" onSurfaceTextureAvailable VideoCallPresenter=");
                sb.append(this.mPresenter);
                Log.d(VideoCallFragment.TAG, sb.toString());
            }
            if (this.mSavedSurfaceTexture == null) {
                this.mSavedSurfaceTexture = surfaceTexture;
                if (!createSurface()) {
                    return;
                }
            } else {
                if (Log.sDebug) {
                    Log.d(VideoCallFragment.TAG, " onSurfaceTextureAvailable: Replacing with cached surface...");
                }
                TextureView textureView = this.mTextureView;
                if (textureView != null && textureView.isAvailable() && (surfaceTexture2 = this.mSavedSurfaceTexture) != null && !surfaceTexture2.isReleased()) {
                    this.mTextureView.setSurfaceTexture(this.mSavedSurfaceTexture);
                } else {
                    return;
                }
            }
            onSurfaceCreated();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (Log.sDebug) {
                Log.d(VideoCallFragment.TAG, " onSurfaceTextureDestroyed mSurfaceId=" + this.mSurfaceId + " surfaceTexture=" + surfaceTexture + " SavedSurfaceTexture=" + this.mSavedSurfaceTexture + " SavedSurface=" + this.mSavedSurface);
                StringBuilder sb = new StringBuilder();
                sb.append(" onSurfaceTextureDestroyed VideoCallPresenter=");
                sb.append(this.mPresenter);
                Log.d(VideoCallFragment.TAG, sb.toString());
            }
            onSurfaceDestroyed();
            if (this.mIsDoneWithSurface) {
                onSurfaceReleased();
                Surface surface = this.mSavedSurface;
                if (surface != null) {
                    surface.release();
                    this.mSavedSurface = null;
                }
                SurfaceTexture surfaceTexture2 = this.mSavedSurfaceTexture;
                if (surfaceTexture2 != null) {
                    surfaceTexture2.release();
                    this.mSavedSurfaceTexture = null;
                }
            }
            return this.mIsDoneWithSurface;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
            if (Log.sDebug) {
                Log.i(VideoCallFragment.TAG, "onSurfaceTextureSizeChanged, mSurfaceId =" + this.mSurfaceId + ", width: " + i10 + ", height: " + i11);
            }
            if (this.mSurfaceId == 2 && i10 != -1 && i11 != -1 && this.mSavedSurfaceTexture != null) {
                if (Log.sDebug) {
                    Log.i(VideoCallFragment.TAG, "reset SurfaceTexture " + this.mWidth + "x" + this.mHeight);
                }
                this.mSavedSurfaceTexture.setDefaultBufferSize(this.mWidth, this.mHeight);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoCallPresenter videoCallPresenter = this.mPresenter;
            if (videoCallPresenter != null) {
                return videoCallPresenter.onSurfaceTouch(this.mSurfaceId, view, motionEvent);
            }
            Log.e(VideoCallFragment.TAG, "onTouch: Presenter is null.");
            return false;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (Log.sDebug) {
                Log.i(VideoCallFragment.TAG, "OnViewAttachedToWindow");
            }
            SurfaceTexture surfaceTexture = this.mSavedSurfaceTexture;
            if (surfaceTexture != null) {
                this.mTextureView.setSurfaceTexture(surfaceTexture);
            }
        }

        public void oplusReleaseTextureView() {
            if (Log.sDebug) {
                Log.d(VideoCallFragment.TAG, "oplusReleaseTextureView: SavedSurface=" + this.mSavedSurface + " SavedSurfaceTexture=" + this.mSavedSurfaceTexture);
            }
            this.mIsDoneWithSurface = true;
            TextureView textureView = this.mTextureView;
            if (textureView != null) {
                textureView.setSurfaceTextureListener(null);
                this.mTextureView.setOnTouchListener(null);
                this.mTextureView.setOnClickListener(null);
                this.mTextureView = null;
            }
            if (this.mSavedSurface != null) {
                onSurfaceReleased();
                this.mSavedSurface.release();
                this.mSavedSurface = null;
            }
            SurfaceTexture surfaceTexture = this.mSavedSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSavedSurfaceTexture = null;
            }
        }

        public void recreateView(TextureView textureView) {
            if (Log.sDebug) {
                Log.i(VideoCallFragment.TAG, "recreateView: " + textureView);
            }
            if (this.mTextureView == textureView) {
                return;
            }
            this.mTextureView = textureView;
            textureView.setSurfaceTextureListener(this);
            this.mTextureView.setOnClickListener(this);
            this.mTextureView.setOnTouchListener(this);
            boolean a10 = com.google.common.base.h.a(this.mSavedSurfaceTexture, this.mTextureView.getSurfaceTexture());
            if (Log.sDebug) {
                Log.d(VideoCallFragment.TAG, "recreateView: SavedSurfaceTexture=" + this.mSavedSurfaceTexture + " areSameSurfaces=" + a10);
            }
            SurfaceTexture surfaceTexture = this.mSavedSurfaceTexture;
            if (surfaceTexture != null && !a10) {
                this.mTextureView.setSurfaceTexture(surfaceTexture);
                if (createSurface()) {
                    onSurfaceCreated();
                }
            }
            this.mIsDoneWithSurface = false;
        }

        public void resetPresenter(VideoCallPresenter videoCallPresenter) {
            if (Log.sDebug) {
                Log.d(VideoCallFragment.TAG, "resetPresenter: CurrentPresenter=" + this.mPresenter + " NewPresenter=" + videoCallPresenter);
            }
            this.mPresenter = videoCallPresenter;
        }

        public void setDoneWithSurface() {
            if (Log.sDebug) {
                Log.d(VideoCallFragment.TAG, "setDoneWithSurface: SavedSurface=" + this.mSavedSurface + " SavedSurfaceTexture=" + this.mSavedSurfaceTexture);
            }
            this.mIsDoneWithSurface = true;
            TextureView textureView = this.mTextureView;
            if (textureView != null && textureView.isAvailable()) {
                return;
            }
            if (this.mSavedSurface != null) {
                onSurfaceReleased();
                this.mSavedSurface.release();
                this.mSavedSurface = null;
            }
            SurfaceTexture surfaceTexture = this.mSavedSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSavedSurfaceTexture = null;
            }
        }

        public void setSurfaceDimensions(int i10, int i11) {
            if (Log.sDebug) {
                Log.d(VideoCallFragment.TAG, "setSurfaceDimensions, mSurfaceId = " + this.mSurfaceId + " width=" + i10 + " height=" + i11);
            }
            this.mWidth = i10;
            this.mHeight = i11;
            if (i10 != -1 && i11 != -1 && this.mSavedSurfaceTexture != null) {
                if (Log.sDebug) {
                    Log.d(VideoCallFragment.TAG, "setSurfaceDimensions, mSavedSurfaceTexture is NOT equal to null.");
                }
                this.mSavedSurfaceTexture.setDefaultBufferSize(i10, i11);
            }
        }

        public VideoCallSurface(VideoCallPresenter videoCallPresenter, int i10, TextureView textureView, int i11, int i12) {
            if (Log.sDebug) {
                Log.d(VideoCallFragment.TAG, "VideoCallSurface: surfaceId=" + i10 + " width=" + i11 + " height=" + i12);
            }
            this.mPresenter = videoCallPresenter;
            this.mWidth = i11;
            this.mHeight = i12;
            this.mSurfaceId = i10;
            if (textureView != null) {
                if (Log.sDebug) {
                    Log.d(VideoCallFragment.TAG, "VideoCallSurface setAlpha 0...");
                }
                textureView.setAlpha(0.01f);
            }
            recreateView(textureView);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    private Uri getPauseImageUri(int i10) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            if (Log.sDebug) {
                Log.d(TAG, "getPauseImageUri: context is null");
                return null;
            }
            return null;
        }
        Resources resources = activity.getResources();
        return new Uri.Builder().scheme("android.resource").authority(resources.getResourcePackageName(i10)).appendPath(resources.getResourceTypeName(i10)).appendPath(resources.getResourceEntryName(i10)).build();
    }

    private int getVideoContainerWidth(ViewGroup.LayoutParams layoutParams) {
        if (Log.sDebug) {
            Log.d(TAG, "addPreviewVideoCallMask containerParams.x: " + layoutParams.width + "containerParams.y :" + layoutParams.height);
        }
        int i10 = layoutParams.width;
        int i11 = layoutParams.height;
        if (i10 > i11) {
            return i11;
        }
        return i10;
    }

    private void inflateVideoCallViews() {
        if (Log.sDebug) {
            Log.d(TAG, "inflateVideoCallViews");
        }
        if (this.mVideoViews == null) {
            this.mVideoViews = this.mVideoViewsStub.inflate();
        }
        View view = this.mVideoViews;
        if (view != null) {
            this.mDisplayVideoContainer = view.findViewById(R.id.incomingVideoContainer);
            ImageView imageView = (ImageView) this.mVideoViews.findViewById(R.id.incomingVideoPause);
            this.mDisplayVideoPause = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.android.incallui.VideoCallFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (VideoCallFragment.this.getPresenter() != null) {
                        VideoCallFragment.this.getPresenter().onSurfaceClick(1);
                    }
                }
            });
            this.mDisplayVideoPause.setOnTouchListener(new View.OnTouchListener() { // from class: com.android.incallui.VideoCallFragment.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (VideoCallFragment.this.getPresenter() != null) {
                        return VideoCallFragment.this.getPresenter().onSurfaceTouch(1, view2, motionEvent);
                    }
                    return false;
                }
            });
            this.mPreviewVideoContainer = this.mVideoViews.findViewById(R.id.previewVideoContainer);
            ImageView imageView2 = (ImageView) this.mVideoViews.findViewById(R.id.previewVideoPause);
            this.mPreviewVideoPause = imageView2;
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.android.incallui.VideoCallFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!OplusPhoneUtils.noNeedHandleClickForCMCC() && VideoCallFragment.this.getPresenter() != null) {
                        VideoCallFragment.this.getPresenter().onSurfaceClick(2);
                    }
                }
            });
            this.mPreviewVideoPause.setOnTouchListener(new View.OnTouchListener() { // from class: com.android.incallui.VideoCallFragment.4
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (VideoCallFragment.this.getPresenter() != null) {
                        return VideoCallFragment.this.getPresenter().onSurfaceTouch(2, view2, motionEvent);
                    }
                    return false;
                }
            });
            this.mPreviewVideoBackground = (ImageView) this.mVideoViews.findViewById(R.id.previewVideoBackground);
            this.mDisplayVideoBackground = (ImageView) this.mVideoViews.findViewById(R.id.incomingVideoBackground);
            this.mPreviewVideoCallMask = (ImageView) this.mVideoViews.findViewById(R.id.previewVideoMask);
            this.mDisplayVideoCallMask = (ImageView) this.mVideoViews.findViewById(R.id.incomingVideoMask);
            if (mOplusShowPreviewVideoBackground) {
                oplusShowPreviewVideoBackground(true);
            }
            if (mOplusShowDisplayVideoBackground) {
                oplusShowDisplayVideoBackground(true);
            }
            View view2 = this.mVideoViews;
            int i10 = R.id.incomingVideo;
            TextureView textureView = (TextureView) view2.findViewById(i10);
            if (Log.sDebug) {
                Log.d(TAG, "inflateVideoCallViews: sVideoSurfacesInUse=" + sVideoSurfacesInUse);
            }
            Point screenSize = getScreenSize();
            Point point = sDisplaySize;
            if (point != null) {
                setSurfaceSizeAndTranslation(textureView, point);
                if (getPresenter() != null && getPresenter().isConnectingOrDialingOrIncomming()) {
                    oplusRefreshVideoLayoutParams(false, textureView, true);
                }
            } else {
                setDisplayVideoSize(screenSize.x, screenSize.y);
            }
            TextureView oplusFindPreviewSurface = oplusFindPreviewSurface();
            if (oplusFindPreviewSurface == null) {
                return;
            }
            if (!sVideoSurfacesInUse) {
                if (Log.sDebug) {
                    Log.d(TAG, " inflateVideoCallViews screenSize" + screenSize);
                }
                sDisplaySurface = new VideoCallSurface(getPresenter(), 1, (TextureView) this.mVideoViews.findViewById(i10), screenSize.x, screenSize.y);
                sPreviewSurface = new VideoCallSurface(getPresenter(), 2, oplusFindPreviewSurface);
                sVideoSurfacesInUse = true;
            } else {
                sDisplaySurface.recreateView((TextureView) this.mVideoViews.findViewById(i10));
                sPreviewSurface.recreateView(oplusFindPreviewSurface);
            }
            this.mVideoViews.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.android.incallui.VideoCallFragment.5
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    View findViewById = VideoCallFragment.this.mVideoViews.findViewById(R.id.incomingVideo);
                    if (findViewById != null) {
                        VideoCallFragment.this.centerDisplayView(findViewById);
                    }
                    VideoCallFragment.this.mIsLayoutComplete = true;
                    ViewTreeObserver viewTreeObserver = VideoCallFragment.this.mVideoViews.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                }
            });
        }
    }

    private void inflateVideoUi(boolean z10) {
        int i10;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        getView().setVisibility(i10);
        if (z10) {
            inflateVideoCallViews();
        }
        View view = this.mVideoViews;
        if (view != null) {
            view.setVisibility(i10);
        }
        if (!z10) {
            if (Log.sDebug) {
                Log.d(TAG, "inflateVideoUi setAlpha 0...");
            }
            if (oplusGetPreviewVideoTextureView() != null) {
                oplusGetPreviewVideoTextureView().setAlpha(0.01f);
            }
            if (oplusGetDispalyVideoTextureView() != null) {
                oplusGetDispalyVideoTextureView().setAlpha(0.01f);
            }
            if (OplusFeatureOption.OPLUS_PHONE_VILTE_NOT_FULLSCREEN) {
                oplusShowPreviewVideoBackground(false);
                oplusShowDisplayVideoBackground(false);
            }
        }
    }

    private void onPresenterChanged(VideoCallPresenter videoCallPresenter) {
        if (Log.sDebug) {
            Log.d(TAG, "onPresenterChanged: Presenter=" + videoCallPresenter);
        }
        VideoCallSurface videoCallSurface = sDisplaySurface;
        if (videoCallSurface != null) {
            videoCallSurface.resetPresenter(videoCallPresenter);
        }
        VideoCallSurface videoCallSurface2 = sPreviewSurface;
        if (videoCallSurface2 != null) {
            videoCallSurface2.resetPresenter(videoCallPresenter);
        }
    }

    private TextureView oplusFindPreviewSurface() {
        FrameLayout frameLayout;
        View view = this.mVideoViews;
        if (view == null || (frameLayout = (FrameLayout) view.findViewById(R.id.previewVideoFrame)) == null) {
            return null;
        }
        if (frameLayout.getChildAt(0) == null) {
            TextureView textureView = new TextureView(getLayoutInflater().getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            frameLayout.addView(textureView, layoutParams);
            Log.d(TAG, "oplusFindPreviewSurface: create TextureView - " + textureView);
        }
        return (TextureView) frameLayout.getChildAt(0);
    }

    private boolean oplusGetIsInCall() {
        CallList callList = CallList.getInstance();
        if (callList != null) {
            if (callList.getPendingOutgoingCall() != null || callList.getOutgoingCall() != null || callList.getIncomingCall() != null) {
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean oplusGetIsSmallVideo(int i10) {
        if (i10 == this.mDefaultSmallSurfaceWidth) {
            return true;
        }
        return false;
    }

    private Point oplusGetResizedVideoSize(boolean z10, boolean z11, boolean z12) {
        Point point;
        Point point2;
        if (z10) {
            point = this.mPreviewSmallSize;
        } else {
            point = this.mDisplayLargeSize;
        }
        if (getResources() == null) {
            return point;
        }
        if (z11) {
            if (z10) {
                point2 = this.mPreviewSmallSize;
            } else {
                point2 = this.mDisplaySmallSize;
            }
        } else if (OplusFeatureOption.OPLUS_PHONE_VILTE_NOT_FULLSCREEN) {
            if (z10) {
                point2 = this.mPreviewLargeSize;
            } else if (z12) {
                if (getPresenter() != null && getPresenter().oplusIsLandscape() && getPresenter().isNotFoldOpen()) {
                    point2 = this.mDisplayLargeSizeLand;
                } else {
                    point2 = this.mDisplayLargeSize;
                }
            } else if (getPresenter().isConnectingOrDialingOrIncomming()) {
                point2 = this.mDisplayLargeSizeNotFullScreen;
            } else {
                point2 = this.mDisplayLargeSize;
            }
        } else if (z10) {
            point2 = this.mPreviewLargeSize;
        } else {
            point2 = this.mDisplayLargeSize;
        }
        if (Log.sDebug) {
            Log.d(TAG, "oplusGetResizedVideoSize: isPreview = " + z10 + "  isSmallVideo = " + z11 + "  videoSize = " + point2.x + " " + point2.y);
        }
        return point2;
    }

    private int oplusGetVideoBottomMargin() {
        if (getActivity() != null && getResources() != null) {
            return OplusPhoneUtils.getNavigationBarHeight(getActivity()) + getResources().getDimensionPixelSize(R.dimen.oplus_call_button_margin_bottom) + getResources().getDimensionPixelSize(R.dimen.oplus_touch_hangup_btn_height) + getResources().getDimensionPixelSize(R.dimen.oplus_dialpad_marginBottom);
        }
        return 0;
    }

    private void oplusRefreshDisplaySize(Point point, float f10) {
        if (f10 > 1.0f) {
            Point point2 = this.mDisplayLargeSize;
            point2.x = point.x;
            point2.y = (int) (point.x / f10);
        } else if (OplusPhoneUtils.isCMCCNumberPrefix(CallList.getInstance().getOutgoingOrActive(), OplusInCallApp.getAppContext().getApplicationContext())) {
            Log.d(TAG, "oplusRefreshDisplaySize isCMCC5GVideoServiceNumber so Based on width");
            Point point3 = this.mDisplayLargeSize;
            point3.x = point.x;
            point3.y = (int) (point.x / f10);
        } else {
            Point point4 = this.mDisplayLargeSize;
            point4.y = point.y;
            point4.x = (int) (point.y * f10);
        }
        if (f10 > 1.0f) {
            Point point5 = this.mDisplaySmallSize;
            int i10 = this.mDefaultSmallSurfaceWidth;
            point5.y = i10;
            point5.x = (int) (i10 * f10);
        } else {
            Point point6 = this.mDisplaySmallSize;
            int i11 = this.mDefaultSmallSurfaceWidth;
            point6.x = i11;
            point6.y = (int) (i11 / f10);
        }
        if (Log.sDebug) {
            Log.d(TAG, "oplusRefreshDisplaySize videoRatio = " + f10 + " mOplusScreenRatio = " + this.mOplusScreenRatio + ",mDisplayLargeSizex:" + this.mDisplayLargeSize.x + ",mDisplayLargeSizey:" + this.mDisplayLargeSize.y);
        }
    }

    private void oplusRefreshPreviewSize(Point point, float f10) {
        if (f10 > 1.0f) {
            Point point2 = this.mPreviewLargeSize;
            point2.x = point.x;
            point2.y = (int) (point.x / f10);
            Point point3 = this.mPreviewSmallSize;
            int i10 = this.mDefaultSmallSurfaceWidth;
            point3.y = i10;
            point3.x = (int) (i10 * f10);
        } else {
            Point point4 = this.mPreviewLargeSize;
            point4.y = point.y;
            point4.x = (int) (point.y * f10);
            Point point5 = this.mPreviewSmallSize;
            int i11 = this.mDefaultSmallSurfaceWidth;
            point5.x = i11;
            point5.y = (int) (i11 / f10);
        }
        if (Log.sDebug) {
            Log.d(TAG, "oplusRefreshPreviewSize videoRatio = " + f10 + " mOplusScreenRatio = " + this.mOplusScreenRatio + ",mPreviewLargeSizex:" + this.mPreviewLargeSize.x + ",mPreviewLargeSizey:" + this.mPreviewLargeSize.y);
        }
    }

    private void oplusRefreshVideoLayoutParams(boolean z10, View view, boolean z11) {
        FrameLayout.LayoutParams layoutParams;
        int i10;
        if (view == null || (layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        boolean isConnectingOrDialingOrIncomming = getPresenter().isConnectingOrDialingOrIncomming();
        int oplusGetVideoBottomMargin = oplusGetVideoBottomMargin();
        Point screenSize = getScreenSize();
        int i11 = layoutParams.height;
        int i12 = layoutParams.width;
        if (i11 <= i12) {
            i11 = i12;
        }
        if (!z10 && isConnectingOrDialingOrIncomming) {
            layoutParams.gravity = 17;
            layoutParams.setMargins(0, 0, 0, 0);
        } else if (!z11 && (i10 = screenSize.y) > 0 && i11 + oplusGetVideoBottomMargin >= i10) {
            layoutParams.gravity = 17;
            layoutParams.setMargins(0, 0, 0, 0);
        } else if (z11) {
            layoutParams.gravity = 17;
            layoutParams.setMargins(0, 0, 0, 0);
        } else if (z10) {
            layoutParams.gravity = 80;
            layoutParams.setMargins(0, 0, 0, oplusGetVideoBottomMargin);
        } else {
            layoutParams.gravity = 17;
            layoutParams.setMargins(0, 0, 0, 0);
        }
        if (Log.sDebug) {
            Log.d(TAG, "oplusRefreshVideoLayoutParams: isPreview = " + z10 + " reset = " + z11 + "  isLandscape = false  videoBottomMargin = " + oplusGetVideoBottomMargin + "  height = " + i11);
        }
        view.setLayoutParams(layoutParams);
    }

    private void oplusSetDisplayLargeSizeLand(float f10) {
        int i10;
        int i11;
        Point screenSize = getScreenSize();
        if (screenSize != null && (i10 = screenSize.x) > 0 && (i11 = screenSize.y) > 0 && f10 > 0.0f) {
            if (f10 > MAX_RATIO) {
                Point point = this.mDisplayLargeSizeLand;
                point.x = i11;
                point.y = (int) (i11 / f10);
            } else {
                Point point2 = this.mDisplayLargeSizeLand;
                point2.x = (int) (i10 * f10);
                point2.y = screenSize.x;
            }
            if (Log.sDebug) {
                Log.d(TAG, "oplusSetDisplayLargeSizeLand = " + f10 + " mDisplayLargeSizeLand.x = " + this.mDisplayLargeSizeLand.x + " mDisplayLargeSizeLand.y = " + this.mDisplayLargeSizeLand.y);
            }
        }
    }

    private void refreshVideoRingToneSize(Point point, float f10) {
        int i10;
        int i11 = point.x;
        if (i11 > 0 && (i10 = point.y) > 0 && f10 > 0.0f) {
            if (f10 > i11 / i10) {
                Point point2 = this.mDisplayLargeSizeNotFullScreen;
                point2.x = i11;
                point2.y = (int) (point.x / f10);
            } else {
                Point point3 = this.mDisplayLargeSizeNotFullScreen;
                point3.y = i10;
                point3.x = (int) (point.y * f10);
            }
            if (Log.sDebug) {
                Log.d(TAG, "refreshVideoRingToneSize videoRatio" + f10 + ", mDisplayLargeSizeNotFullScreen = " + this.mDisplayLargeSizeNotFullScreen);
                return;
            }
            return;
        }
        Log.d(TAG, "screenSize is less than 0 and return");
    }

    private void setSurfaceSizeAndTranslation(TextureView textureView, Point point) {
        ViewGroup.LayoutParams layoutParams = textureView.getLayoutParams();
        layoutParams.width = point.x;
        layoutParams.height = point.y;
        textureView.setLayoutParams(layoutParams);
        if (Log.sDebug) {
            Log.d(TAG, "setSurfaceSizeAndTranslation: Size=" + point + "IsLayoutComplete=" + this.mIsLayoutComplete);
        }
        if (this.mIsLayoutComplete) {
            centerDisplayView(textureView);
        }
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public void adjustPreviewLocation(boolean z10, int i10) {
        View view;
        float f10;
        if (sPreviewSurface != null && (view = this.mPreviewVideoContainer) != null) {
            float f11 = 0.0f;
            if (z10) {
                f10 = 0.0f;
            } else {
                f10 = -i10;
            }
            view.setTranslationY(f10);
            ViewPropertyAnimator duration = this.mPreviewVideoContainer.animate().setInterpolator(OplusAnimationUtils.EASE_OUT_EASE_IN).setDuration(this.mAnimationDuration);
            if (z10) {
                f11 = -i10;
            }
            duration.translationY(f11).start();
        }
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public void cleanupSurfaces() {
        if (Log.sDebug) {
            Log.d(TAG, "cleanupSurfaces");
        }
        VideoCallSurface videoCallSurface = sDisplaySurface;
        if (videoCallSurface != null) {
            videoCallSurface.setDoneWithSurface();
            sDisplaySurface = null;
        }
        VideoCallSurface videoCallSurface2 = sPreviewSurface;
        if (videoCallSurface2 != null) {
            videoCallSurface2.setDoneWithSurface();
            sPreviewSurface = null;
        }
        sVideoSurfacesInUse = false;
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public int getCurrentRotation() {
        return OplusPhoneUtils.getRotation(OplusInCallApp.getDefaultDisplayUiContext());
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public Surface getDisplayVideoSurface() {
        VideoCallSurface videoCallSurface = sDisplaySurface;
        if (videoCallSurface == null) {
            return null;
        }
        return videoCallSurface.getSurface();
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public Point getPreviewSize() {
        VideoCallSurface videoCallSurface = sPreviewSurface;
        if (videoCallSurface == null) {
            return null;
        }
        return videoCallSurface.getSurfaceDimensions();
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public Surface getPreviewVideoSurface() {
        VideoCallSurface videoCallSurface = sPreviewSurface;
        if (videoCallSurface == null) {
            return null;
        }
        return videoCallSurface.getSurface();
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public Point getScreenSize() {
        int i10;
        int i11;
        if (getActivity() == null) {
            return new Point(0, 0);
        }
        Display defaultDisplay = getActivity().getWindowManager().getDefaultDisplay();
        Point point = new Point();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        point.y = displayMetrics.heightPixels;
        point.x = displayMetrics.widthPixels;
        if (getPresenter() != null && getPresenter().isNotFoldOpen() && (i10 = point.x) > (i11 = point.y)) {
            point.x = i11;
            point.y = i10;
        }
        return point;
    }

    @Override // com.android.incallui.BaseFragment
    public VideoCallPresenter.VideoCallUi getUi() {
        return this;
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public void hideVideoUi() {
        inflateVideoUi(false);
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public boolean isDisplayVideoSurfaceCreated() {
        boolean z10;
        VideoCallSurface videoCallSurface = sDisplaySurface;
        if (videoCallSurface != null && videoCallSurface.getSurface() != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d(TAG, " isDisplayVideoSurfaceCreated returns " + z10);
        }
        return z10;
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public boolean isPreviewVideoSurfaceCreated() {
        boolean z10;
        VideoCallSurface videoCallSurface = sPreviewSurface;
        if (videoCallSurface != null && videoCallSurface.getSurface() != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d(TAG, " isPreviewVideoSurfaceCreated returns " + z10);
        }
        return z10;
    }

    public boolean isVideoCallUIVisible() {
        if (this.mVideoViews != null) {
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (Log.sDebug) {
            Log.d(TAG, "onConfigurationChanged, newConfig = " + configuration);
        }
        if (getPresenter() != null) {
            getPresenter().onConfigurationChanged();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        int i10;
        int i11;
        int i12;
        float oplusPeerVideoRatio;
        super.onCreate(bundle);
        this.mAnimationDuration = getResources().getInteger(R.integer.video_animation_duration);
        this.mDefaultSmallSurfaceWidth = getResources().getDimensionPixelSize(R.dimen.oplus_video_small_surface_width);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.oplus_video_small_surface_height);
        Point screenSize = getScreenSize();
        Call callToShow = OplusPhoneUtils.getCallToShow(CallList.getInstance());
        if (callToShow != null && callToShow.getOplusPeerVideoRatio() > 0.0f && callToShow.getOplusPeerVideoRatio() < 1.0f) {
            i12 = (int) (screenSize.y * callToShow.getOplusPeerVideoRatio());
            i10 = (int) (screenSize.x / callToShow.getOplusPeerVideoRatio());
            oplusPeerVideoRatio = this.mDefaultSmallSurfaceWidth / callToShow.getOplusPeerVideoRatio();
        } else if (callToShow != null && callToShow.getOplusPeerVideoRatio() > 1.0f) {
            i12 = (int) (screenSize.y / callToShow.getOplusPeerVideoRatio());
            i10 = (int) (screenSize.x * callToShow.getOplusPeerVideoRatio());
            oplusPeerVideoRatio = this.mDefaultSmallSurfaceWidth * callToShow.getOplusPeerVideoRatio();
        } else {
            i10 = (screenSize.x * DEFAUT_VIDEO_SIZE_HEIGHT) / 480;
            i11 = dimensionPixelSize;
            i12 = (screenSize.y * 480) / DEFAUT_VIDEO_SIZE_HEIGHT;
            this.mPreviewLargeSize = new Point(i12, screenSize.y);
            this.mPreviewSmallSize = new Point(this.mDefaultSmallSurfaceWidth, i11);
            this.mDisplayLargeSize = new Point(i12, screenSize.y);
            this.mDisplaySmallSize = new Point(this.mDefaultSmallSurfaceWidth, i11);
            this.mDisplayLargeSizeNotFullScreen = new Point(screenSize.x, i10);
            this.mDisplayLargeSizeLand = new Point((screenSize.x * 480) / DEFAUT_VIDEO_SIZE_HEIGHT, screenSize.x);
            refreshVideoSizeFromCache(callToShow);
        }
        i11 = (int) oplusPeerVideoRatio;
        this.mPreviewLargeSize = new Point(i12, screenSize.y);
        this.mPreviewSmallSize = new Point(this.mDefaultSmallSurfaceWidth, i11);
        this.mDisplayLargeSize = new Point(i12, screenSize.y);
        this.mDisplaySmallSize = new Point(this.mDefaultSmallSurfaceWidth, i11);
        this.mDisplayLargeSizeNotFullScreen = new Point(screenSize.x, i10);
        this.mDisplayLargeSizeLand = new Point((screenSize.x * 480) / DEFAUT_VIDEO_SIZE_HEIGHT, screenSize.x);
        refreshVideoSizeFromCache(callToShow);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return layoutInflater.inflate(R.layout.video_call_fragment, viewGroup, false);
    }

    @Override // com.android.incallui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (Log.sDebug) {
            Log.d(TAG, "onDestroyView:");
        }
        if (InCallPresenter.getInstance() != null) {
            InCallPresenter.getInstance().setVideoCallPresenter(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (Log.sDebug) {
            Log.d(TAG, "onPause:");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (Log.sDebug) {
            Log.d(TAG, "onResume:");
        }
        if (getPresenter() != null) {
            getPresenter().oplusCheckSystemUiVisibility();
            getPresenter().oplusCheckVideoRingToneMode();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (Log.sDebug) {
            Log.d(TAG, "onStop:");
        }
    }

    @Override // com.android.incallui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        if (Log.sDebug) {
            Log.d(TAG, "onViewCreated: VideoSurfacesInUse=" + sVideoSurfacesInUse);
        }
        this.mVideoViewsStub = (ViewStub) view.findViewById(R.id.videoCallViewsStub);
        getPresenter().init(getActivity());
        super.onViewCreated(view, bundle);
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public void oplusDowngradeToAudioNotice(int i10) {
        OplusCallCardFragment h10;
        InCallActivity inCallActivity = (InCallActivity) getActivity();
        if (inCallActivity == null || (h10 = inCallActivity.getInCallFragmentManager().h()) == null) {
            return;
        }
        String string = inCallActivity.getResources().getString(i10);
        if (Log.sDebug) {
            Log.d(TAG, "oplusDowngradeToAudioNotice: msg = " + string);
        }
        h10.updateCallStatusPrompt(string, 3000L);
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public View oplusGetDispalyVideoTextureView() {
        VideoCallSurface videoCallSurface = sDisplaySurface;
        if (videoCallSurface == null) {
            return null;
        }
        return videoCallSurface.getTextureView();
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public View oplusGetDisplayVideoContainer() {
        return this.mDisplayVideoContainer;
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public View oplusGetPreviewVideoContainer() {
        return this.mPreviewVideoContainer;
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public View oplusGetPreviewVideoTextureView() {
        VideoCallSurface videoCallSurface = sPreviewSurface;
        if (videoCallSurface == null) {
            return null;
        }
        return videoCallSurface.getTextureView();
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public void oplusRefreshVideoSize(float f10) {
        if (f10 <= 0.0f) {
            return;
        }
        oplusRefreshViewSize(false, f10);
        if (f10 > 1.0f) {
            oplusRefreshViewSize(true, 1.0f / f10);
        } else {
            oplusRefreshViewSize(true, f10);
        }
    }

    public void oplusRefreshViewSize(boolean z10, float f10) {
        int i10;
        int i11;
        Point screenSize = getScreenSize();
        if (screenSize != null && (i10 = screenSize.x) > 0 && (i11 = screenSize.y) > 0 && f10 > 0.0f) {
            this.mOplusScreenRatio = i10 / i11;
            if (Log.sDebug) {
                Log.d(TAG, "videoRatio = " + f10 + " mOplusScreenRatio = " + this.mOplusScreenRatio + ",screenSizex:" + screenSize.x + ",screenSizey:" + screenSize.y);
            }
            if (z10) {
                oplusRefreshPreviewSize(screenSize, f10);
                return;
            }
            refreshVideoRingToneSize(screenSize, f10);
            oplusRefreshDisplaySize(screenSize, f10);
            oplusSetDisplayLargeSizeLand(f10);
        }
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public void oplusReleasePreviewSurface() {
        View view = this.mVideoViews;
        if (view != null) {
            int i10 = R.id.previewVideoFrame;
            if (view.findViewById(i10) != null) {
                ((FrameLayout) this.mVideoViews.findViewById(i10)).removeAllViews();
            }
        }
        VideoCallSurface videoCallSurface = sPreviewSurface;
        if (videoCallSurface != null) {
            videoCallSurface.oplusReleaseTextureView();
        }
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public void oplusSetDisplayVideoVisibility(boolean z10) {
        int i10;
        if (this.mDisplayVideoContainer != null) {
            Log.d(TAG, "oplusSetDisplayVideoVisibility: " + z10);
            View view = this.mDisplayVideoContainer;
            if (z10) {
                i10 = 0;
            } else {
                i10 = 4;
            }
            view.setVisibility(i10);
        }
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public void oplusSetPreviewVideoVisibility(boolean z10) {
        int i10;
        if (this.mPreviewVideoContainer != null) {
            Log.d(TAG, "oplusSetPreviewVideoVisibility: " + z10);
            View view = this.mPreviewVideoContainer;
            if (z10) {
                i10 = 0;
            } else {
                i10 = 4;
            }
            view.setVisibility(i10);
        }
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public void oplusSetVideoRatio(boolean z10, int i10, int i11) {
        if (Log.sDebug) {
            Log.d(TAG, "oplusSetVideoRatio: isPreviewVideo = " + z10 + "  width = " + i10 + "  height = " + i11);
        }
        if (i10 > 0 && i11 > 0) {
            if (z10 && i10 > i11) {
                i11 = i10;
                i10 = i11;
            }
            oplusRefreshViewSize(z10, i10 / i11);
        }
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public void oplusShowDisplayVideoBackground(boolean z10) {
        int i10;
        if (Log.sDebug) {
            Log.d(TAG, "oplusShowDisplayVideoBackground: " + z10);
        }
        mOplusShowDisplayVideoBackground = z10;
        ImageView imageView = this.mDisplayVideoBackground;
        if (imageView != null) {
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            imageView.setVisibility(i10);
            if (z10) {
                if (getPresenter().isConnectingOrDialingOrIncomming()) {
                    this.mDisplayVideoBackground.setBackground(null);
                    this.mDisplayVideoBackground.setVisibility(8);
                    return;
                } else {
                    this.mDisplayVideoBackground.setBackgroundColor(androidx.core.content.b.c(getLayoutInflater().getContext(), android.R.color.black));
                    return;
                }
            }
            this.mDisplayVideoBackground.setBackground(null);
        }
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public void oplusShowDisplayVideoPause(boolean z10) {
        int i10;
        if (Log.sDebug) {
            Log.d(TAG, "oplusShowDisplayVideoPause: " + z10);
        }
        OplusPhoneUserActionStatistics.onCommon(getActivity(), OplusPhoneUserActionStatistics.TAG_VIDEO_CALL, OplusPhoneUserActionStatistics.VIDEO_CAMERA_CLOSE_BY_REMOTE_WHEN_CALL, (Map) null);
        ImageView imageView = this.mDisplayVideoPause;
        if (imageView != null) {
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            imageView.setVisibility(i10);
        }
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public void oplusShowPreviewVideoBackground(boolean z10) {
        int i10;
        if (Log.sDebug) {
            Log.d(TAG, "oplusShowPreviewVideoBackground: " + z10);
        }
        mOplusShowPreviewVideoBackground = z10;
        ImageView imageView = this.mPreviewVideoBackground;
        if (imageView != null) {
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            imageView.setVisibility(i10);
        }
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public void oplusShowPreviewVideoPause(boolean z10) {
        Call activeCall;
        int i10;
        if (Log.sDebug) {
            Log.d(TAG, "oplusShowPreviewVideoPause: " + z10);
        }
        ImageView imageView = this.mPreviewVideoPause;
        if (imageView != null) {
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            imageView.setVisibility(i10);
        }
        if (OplusPhoneUtils.isCMCCNumberPrefix(CallList.getInstance().getActiveCall(), OplusInCallApp.getAppContext().getApplicationContext()) && this.mVideoViews != null && z10 && (activeCall = CallList.getInstance().oplusCallList().getActiveCall()) != null && activeCall.getVideoCall() != null && activeCall.getState() == 3 && activeCall.getVideoState() == 3) {
            if (Log.sDebug) {
                Log.d(TAG, "oplusShowPreviewVideoPause: setPauseImage");
            }
            ImageView imageView2 = this.mPreviewVideoPause;
            int i11 = R.drawable.incall_mobile_video_off;
            imageView2.setBackgroundResource(i11);
            activeCall.getVideoCall().setCamera(null);
            activeCall.getVideoCall().setPauseImage(getPauseImageUri(i11));
        }
    }

    public void refreshVideoSizeFromCache(Call call) {
        if (call != null && call.getOplusPeerVideoRatio() > 0.0f) {
            oplusRefreshViewSize(false, call.getOplusPeerVideoRatio());
        }
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public void setDisplayVideoSize(int i10, int i11) {
        boolean z10;
        boolean z11;
        if (Log.sDebug) {
            Log.d(TAG, "setDisplayVideoSize: width=" + i10 + " height=" + i11);
        }
        VideoCallSurface videoCallSurface = sDisplaySurface;
        if (videoCallSurface != null) {
            TextureView textureView = videoCallSurface.getTextureView();
            if (textureView == null) {
                Log.e(TAG, "Display Video texture view is null. Bail out");
                return;
            }
            boolean oplusGetIsSmallVideo = oplusGetIsSmallVideo(i10);
            if (OplusFeatureOption.OPLUS_PHONE_VILTE_NOT_FULLSCREEN && !oplusGetIsSmallVideo) {
                z10 = oplusGetIsInCall();
            } else {
                z10 = false;
            }
            Point oplusGetResizedVideoSize = oplusGetResizedVideoSize(false, oplusGetIsSmallVideo, z10);
            sDisplaySize = oplusGetResizedVideoSize;
            setSurfaceSizeAndTranslation(textureView, oplusGetResizedVideoSize);
            if (!oplusGetIsSmallVideo && z10) {
                z11 = false;
            } else {
                z11 = true;
            }
            oplusRefreshVideoLayoutParams(false, textureView, z11);
            View view = this.mDisplayVideoContainer;
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (getResources() != null && oplusGetIsSmallVideo) {
                    if (OplusFeatureOption.OPLUS_PHONE_VILTE_NOT_FULLSCREEN && getPresenter() != null && getPresenter().oplusIsLandscape() && getPresenter().isNotFoldOpen()) {
                        Point point = sDisplaySize;
                        layoutParams.width = point.y;
                        layoutParams.height = point.x;
                    } else {
                        Point point2 = sDisplaySize;
                        layoutParams.width = point2.x;
                        layoutParams.height = point2.y;
                    }
                } else {
                    layoutParams.width = i10;
                    layoutParams.height = i11;
                }
                if (Log.sDebug) {
                    Log.d(TAG, "setDisplayVideoSize: containerParams width=" + layoutParams.width + " containerParams height=" + layoutParams.height);
                }
                this.mDisplayVideoContainer.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        Log.e(TAG, "Display Video Surface is null. Bail out");
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public void setPreviewSize(int i10, int i11) {
        TextureView textureView;
        boolean z10;
        if (Log.sDebug) {
            Log.d(TAG, "setPreviewSize: width=" + i10 + " height=" + i11);
        }
        VideoCallSurface videoCallSurface = sPreviewSurface;
        if (videoCallSurface == null || (textureView = videoCallSurface.getTextureView()) == null) {
            return;
        }
        boolean oplusGetIsSmallVideo = oplusGetIsSmallVideo(Math.min(i10, i11));
        boolean z11 = false;
        if (OplusFeatureOption.OPLUS_PHONE_VILTE_NOT_FULLSCREEN && !oplusGetIsSmallVideo) {
            z10 = oplusGetIsInCall();
        } else {
            z10 = false;
        }
        ViewGroup.LayoutParams layoutParams = textureView.getLayoutParams();
        Point oplusGetResizedVideoSize = oplusGetResizedVideoSize(true, oplusGetIsSmallVideo, z10);
        layoutParams.width = oplusGetResizedVideoSize.x;
        layoutParams.height = oplusGetResizedVideoSize.y;
        textureView.setLayoutParams(layoutParams);
        Log.d(TAG, "setPreViewVideoSize  : sPreviewSize.x =" + oplusGetResizedVideoSize.x + " sPreviewSize.y=" + oplusGetResizedVideoSize.y);
        if (oplusGetIsSmallVideo || !z10) {
            z11 = true;
        }
        oplusRefreshVideoLayoutParams(true, textureView, z11);
        View view = this.mPreviewVideoContainer;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (getResources() != null && oplusGetIsSmallVideo) {
                if (getPresenter() != null && getPresenter().oplusIsLandscape() && !getPresenter().isNotFoldOpen()) {
                    int i12 = oplusGetResizedVideoSize.x;
                    int i13 = oplusGetResizedVideoSize.y;
                    if (i12 < i13) {
                        layoutParams2.width = i13;
                        layoutParams2.height = i12;
                    }
                } else {
                    layoutParams2.width = oplusGetResizedVideoSize.x;
                    layoutParams2.height = oplusGetResizedVideoSize.y;
                }
            } else {
                layoutParams2.width = i10;
                layoutParams2.height = i11;
            }
            if (Log.sDebug) {
                Log.d(TAG, "setPreViewVideoSize: containerParams width=" + layoutParams2.width + " containerParams height=" + layoutParams2.height);
            }
            this.mPreviewVideoContainer.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public void setPreviewSurfaceSize(int i10, int i11) {
        boolean z10;
        if (sPreviewSurface != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d(TAG, "setPreviewSurfaceSize: width=" + i10 + " height=" + i11 + " isPreviewSurfaceAvailable=" + z10);
        }
        if (z10) {
            sPreviewSurface.setSurfaceDimensions(i10, i11);
        }
    }

    public void setVideoCallUIVisible(boolean z10) {
        int i10;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        if (getView() != null) {
            getView().setVisibility(i10);
        }
        View view = this.mVideoViews;
        if (view != null) {
            view.setVisibility(i10);
        }
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public void showDisplayVideoCallMask(boolean z10) {
        if (this.mDisplayVideoCallMask != null && this.mDisplayVideoContainer != null) {
            if (Log.sDebug) {
                Log.d(TAG, "addDisplayVideoCallMask show: " + z10);
            }
            ViewGroup.LayoutParams layoutParams = this.mDisplayVideoContainer.getLayoutParams();
            if (z10 && layoutParams != null && !oplusGetIsSmallVideo(getVideoContainerWidth(layoutParams))) {
                this.mDisplayVideoCallMask.setVisibility(0);
                this.mDisplayVideoCallMask.bringToFront();
                return;
            } else {
                this.mDisplayVideoCallMask.setVisibility(8);
                return;
            }
        }
        if (Log.sDebug) {
            Log.e(TAG, "addDisplayVideoCallMask return");
        }
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public void showPreviewVideoCallMask(boolean z10) {
        if (this.mPreviewVideoCallMask != null && this.mPreviewVideoContainer != null) {
            if (Log.sDebug) {
                Log.d(TAG, "addPreviewVideoCallMask show: " + z10);
            }
            ViewGroup.LayoutParams layoutParams = this.mPreviewVideoContainer.getLayoutParams();
            if (z10 && layoutParams != null && !oplusGetIsSmallVideo(getVideoContainerWidth(layoutParams))) {
                this.mPreviewVideoCallMask.setVisibility(0);
                this.mPreviewVideoCallMask.bringToFront();
                return;
            } else {
                this.mPreviewVideoCallMask.setVisibility(8);
                return;
            }
        }
        if (Log.sDebug) {
            Log.e(TAG, "addPreviewVideoCallMask return");
        }
    }

    @Override // com.android.incallui.VideoCallPresenter.VideoCallUi
    public void showVideoViews(boolean z10, boolean z11, int i10) {
        boolean z12 = true;
        inflateVideoUi(true);
        if (z11 || i10 == 4) {
            z12 = false;
        }
        oplusShowDisplayVideoPause(z12);
    }

    @Override // com.android.incallui.BaseFragment
    public VideoCallPresenter createPresenter() {
        if (Log.sDebug) {
            Log.d(TAG, "createPresenter");
        }
        VideoCallPresenter videoCallPresenter = new VideoCallPresenter();
        onPresenterChanged(videoCallPresenter);
        InCallPresenter.getInstance().setVideoCallPresenter(videoCallPresenter);
        return videoCallPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void centerDisplayView(View view) {
    }

    @Override // com.android.incallui.Ui
    public void setVisible(boolean z10) {
    }
}
