package com.troop.freedcam.camera.modules;

import android.hardware.Camera;

import com.sec.android.seccamera.SecCamera;

/**
 * Created by troop on 06.01.2015.
 */
public class I_Callbacks
{
    public interface ShutterCallback
    {
        void onShutter();
    }

    public interface PictureCallback {

        void onPictureTaken(byte[] data);
    };

    public interface PreviewCallback
    {

        void onPreviewFrame(byte[] data);
    };

    public interface AutoFocusCallback
    {
        void onAutoFocus(CameraFocusEvent cameraFocusEvent);
    }


    public interface ErrorCallback
    {
        void onError(int error);
    };
}


