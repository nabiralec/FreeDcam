/*
 *
 *     Copyright (C) 2015 Ingo Fuchs
 *     This program is free software; you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation; either version 2 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License along
 *     with this program; if not, write to the Free Software Foundation, Inc.,
 *     51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * /
 */

package com.freedcam.apis.camera1.camera;

import android.hardware.Camera;

import com.freedcam.apis.basecamera.camera.interfaces.I_CameraChangedListner;
import com.freedcam.utils.AppSettingsManager;
import com.freedcam.utils.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by troop on 08.06.2016.
 */
public class CameraHolderMotoX extends CameraHolder
{
    public CameraHolderMotoX(I_CameraChangedListner cameraChangedListner, AppSettingsManager appSettingsManager, Frameworks frameworks) {
        super(cameraChangedListner, appSettingsManager, frameworks);
    }

    @Override
    public boolean OpenCamera(int camera)
    {
        try {
            mCamera = openWrapper(camera);
            Camera.Parameters paras = mCamera.getParameters();
            paras.set("mot-app", "true");
            mCamera.setParameters(paras);
        }
        catch (RuntimeException ex)
        {
            cameraChangedListner.onCameraError("Fail to connect to camera service");
            isRdy = false;
        }

        cameraChangedListner.onCameraOpen("");
        super.OpenCamera(0);
        return isRdy;
    }

    private  Camera openWrapper(int n) {
        Class[] arrclass = new Class[]{Integer.TYPE, Integer.TYPE};
        try {
            Method method = Class.forName("android.hardware.Camera").getDeclaredMethod("openLegacy", arrclass);
            Object[] arrobject = new Object[]{n, 256};
            return (Camera)method.invoke(null, arrobject);
        }
        catch (NoSuchMethodException e) {
            Logger.e(TAG, e.getMessage());
            return Camera.open(n);}
        catch (ClassNotFoundException e) {
            Logger.e(TAG, e.getMessage());
            return Camera.open(n);}
        catch (IllegalAccessException e) {
            Logger.e(TAG, e.getMessage());
            return Camera.open(n);}
        catch (InvocationTargetException e) {
            Logger.e(TAG, e.getMessage());
            return Camera.open(n);}
    }
}
