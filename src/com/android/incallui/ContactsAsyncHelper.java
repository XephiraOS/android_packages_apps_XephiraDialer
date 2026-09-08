package com.android.incallui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ContactsAsyncHelper {
    private static final int EVENT_LOAD_IMAGE = 1;
    private static ContactsAsyncHelper sInstance = new ContactsAsyncHelper();
    private static Handler sThreadHandler;
    private final Handler mResultHandler = new Handler() { // from class: com.android.incallui.ContactsAsyncHelper.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WorkerArgs workerArgs = (WorkerArgs) message.obj;
            if (message.arg1 == 1 && workerArgs.listener != null) {
                Log.d(this, "Notifying listener: " + workerArgs.listener + " image: " + workerArgs.displayPhotoUri + " completed");
                Drawable drawable = workerArgs.omojiPhoto;
                if (drawable != null) {
                    workerArgs.listener.onOmojiLoadComplete(message.what, drawable, workerArgs.cookie);
                } else {
                    workerArgs.listener.onImageLoadComplete(message.what, workerArgs.photo, workerArgs.photoIcon, workerArgs.cookie);
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface OnImageLoadCompleteListener {
        void onImageLoadComplete(int i10, Drawable drawable, Bitmap bitmap, Object obj);

        void onOmojiLoadComplete(int i10, Drawable drawable, Object obj);
    }

    /* loaded from: classes.dex */
    public static final class WorkerArgs {
        public Uri contactPhotoThumbnailUri;
        public Context context;
        public Object cookie;
        public Uri displayPhotoUri;
        public OnImageLoadCompleteListener listener;
        public Drawable omojiPhoto;
        public Uri omojiPhotoUri;
        public Drawable photo;
        public Bitmap photoIcon;

        private WorkerArgs() {
        }
    }

    /* loaded from: classes.dex */
    public class WorkerHandler extends Handler {
        public WorkerHandler(Looper looper) {
            super(looper);
        }

        private Bitmap getPhotoIconWhenAppropriate(Context context, Drawable drawable) {
            if (!(drawable instanceof BitmapDrawable)) {
                return null;
            }
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.notification_icon_size);
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int max = Math.max(width, height);
            if (max > dimensionPixelSize) {
                float f10 = max / dimensionPixelSize;
                int i10 = (int) (width / f10);
                int i11 = (int) (height / f10);
                if (i10 > 0 && i11 > 0) {
                    return Bitmap.createScaledBitmap(bitmap, i10, i11, true);
                }
                Log.w(this, "Photo icon's width or height become 0.");
                return null;
            }
            return bitmap;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            InputStream inputStream;
            WorkerArgs workerArgs = (WorkerArgs) message.obj;
            if (message.arg1 == 1) {
                InputStream inputStream2 = null;
                try {
                    Uri uri = workerArgs.omojiPhotoUri;
                    try {
                        if (uri != null) {
                            Bitmap a10 = com.android.incallui.mvvm.utils.e.a(uri);
                            if (a10 != null) {
                                a10 = Bitmap.createBitmap(a10, 0, 216, a10.getWidth(), 1584);
                            }
                            workerArgs.omojiPhoto = new BitmapDrawable(workerArgs.context.getResources(), a10);
                        }
                    } catch (Exception e10) {
                        Log.d(ContactsAsyncHelper.this, "Error opening omojiPhotoUri input stream", e10.getMessage());
                    } finally {
                    }
                    if (workerArgs.omojiPhoto != null) {
                        Log.d(ContactsAsyncHelper.this, "successfully get omoji photo, no need to query contactPhoto");
                    } else {
                        Log.d(ContactsAsyncHelper.this, "failed to get omoji photo, need to query contactPhoto");
                        try {
                            inputStream = workerArgs.context.getContentResolver().openInputStream(workerArgs.displayPhotoUri);
                        } catch (Exception e11) {
                            Log.e(this, "Error opening photo input stream", e11);
                            inputStream = null;
                        }
                        if (inputStream == null) {
                            try {
                                try {
                                    inputStream = workerArgs.context.getContentResolver().openInputStream(workerArgs.contactPhotoThumbnailUri);
                                } catch (Exception e12) {
                                    Log.e(this, "Error opening contactPhotoThumbnailUri input stream", e12);
                                }
                            } catch (Throwable th) {
                                th = th;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException e13) {
                                        Log.e(this, "Unable to close input stream.", e13);
                                    }
                                }
                                throw th;
                            }
                        }
                        if (inputStream != null) {
                            Drawable createFromStream = Drawable.createFromStream(inputStream, workerArgs.displayPhotoUri.toString());
                            workerArgs.photo = createFromStream;
                            workerArgs.photoIcon = getPhotoIconWhenAppropriate(workerArgs.context, createFromStream);
                            Log.d(ContactsAsyncHelper.this, "Loading image: " + message.arg1 + " token: " + message.what + " image URI: " + workerArgs.displayPhotoUri);
                        } else {
                            workerArgs.photo = null;
                            workerArgs.photoIcon = null;
                            Log.d(ContactsAsyncHelper.this, "Problem with image: " + message.arg1 + " token: " + message.what + " image URI: " + workerArgs.displayPhotoUri + ", using default image.");
                        }
                        inputStream2 = inputStream;
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e14) {
                            Log.e(this, "Unable to close input stream.", e14);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            Message obtainMessage = ContactsAsyncHelper.this.mResultHandler.obtainMessage(message.what);
            obtainMessage.arg1 = message.arg1;
            obtainMessage.obj = message.obj;
            obtainMessage.sendToTarget();
        }
    }

    private ContactsAsyncHelper() {
        HandlerThread handlerThread = new HandlerThread("ContactsAsyncWorker");
        handlerThread.start();
        sThreadHandler = new WorkerHandler(handlerThread.getLooper());
    }

    public static final void startObtainPhotoAsync(int i10, Context context, Uri uri, Uri uri2, Uri uri3, OnImageLoadCompleteListener onImageLoadCompleteListener, Object obj) {
        if (uri == null && uri2 == null && uri3 == null) {
            Log.wtf("startObjectPhotoAsync", "Uri is missing");
            return;
        }
        WorkerArgs workerArgs = new WorkerArgs();
        workerArgs.cookie = obj;
        workerArgs.context = context;
        workerArgs.displayPhotoUri = uri;
        workerArgs.listener = onImageLoadCompleteListener;
        workerArgs.contactPhotoThumbnailUri = uri2;
        workerArgs.omojiPhotoUri = uri3;
        Message obtainMessage = sThreadHandler.obtainMessage(i10);
        obtainMessage.arg1 = 1;
        obtainMessage.obj = workerArgs;
        Log.d("startObjectPhotoAsync", "Begin loading image: " + workerArgs.displayPhotoUri + ", displaying default image for now.");
        sThreadHandler.sendMessage(obtainMessage);
    }
}
