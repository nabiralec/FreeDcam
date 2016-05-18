package com.freedcam.apis.camera1.camera.parameters.manual;

import android.hardware.Camera;

import com.freedcam.apis.camera1.camera.CameraHolderApi1;
import com.freedcam.apis.camera1.camera.parameters.CamParametersHandler;
import com.freedcam.utils.Logger;

import java.util.HashMap;

/**
 * Created by troop on 27.01.2016.
 */
public class AE_Handler_LGG4
{
    private ISOManualParameterG4 isoManualParameter;
    private ShutterManualParameterG4 shutterPrameter;
    private int currentIso = 0;
    private int currentShutter = 0;
    private Camera.Parameters parameters;
    boolean auto = true;
    private CamParametersHandler camParametersHandler;

    final String TAG = AE_Handler_LGG4.class.getSimpleName();

    enum AeManual
    {
        shutter,
        iso,
    }

    public AE_Handler_LGG4(Camera.Parameters parameters, CameraHolderApi1 cameraHolder, CamParametersHandler camParametersHandler)
    {
        this.camParametersHandler = camParametersHandler;
        this.isoManualParameter = new ISOManualParameterG4(parameters,cameraHolder, camParametersHandler, aeevent);
        camParametersHandler.ISOManual = isoManualParameter;
        this.shutterPrameter = new ShutterManualParameterG4(parameters, camParametersHandler, aeevent);
        camParametersHandler.ManualShutter = shutterPrameter;
        this.parameters = parameters;
    }

    public interface AeManualEvent
    {
        void onManualChanged(AeManual fromManual, boolean automode, int value);
    }

    AeManualEvent aeevent =  new AeManualEvent() {
        @Override
        public void onManualChanged(AeManual fromManual, boolean automode, int value)
        {
            if (automode)
            {
                Logger.d(TAG, "AutomodeActive");
                auto = automode;


                switch (fromManual) {
                    case shutter:
                        currentIso = isoManualParameter.GetValue();
                        isoManualParameter.setValue(0);
                        break;
                    case iso:
                        currentShutter = shutterPrameter.GetValue();
                        shutterPrameter.setValue(0);
                        break;
                }
                parameters.set("lg-manual-mode-reset", "1");
                camParametersHandler.SetParametersToCamera(parameters);
                parameters.set("lg-manual-mode-reset", "0");


            }
            else
            {
                if (auto)
                {
                    Logger.d(TAG, "Automode Deactivated, set last values");
                    auto = false;
                    switch (fromManual) {
                        case shutter:
                            isoManualParameter.setValue(currentIso);
                            break;
                        case iso:
                            if (currentShutter == 0) currentShutter =9;
                            shutterPrameter.setValue(currentShutter);
                            break;
                    }
                }
                else
                {
                    Logger.d(TAG, "Automode Deactivated, set UserValues");
                    switch (fromManual) {
                        case shutter:
                            shutterPrameter.setValue(value);
                            break;
                        case iso:
                            isoManualParameter.setValue(value);
                            break;
                    }
                }
                parameters.set("lg-manual-mode-reset", "0");
            }
            camParametersHandler.SetParametersToCamera(parameters);
            if (automode) {
                String t = camParametersHandler.IsoMode.GetValue();
                if (!t.equals("ISO100"))
                    camParametersHandler.IsoMode.SetValue("ISO100", true);
                else
                    camParametersHandler.IsoMode.SetValue("auto", true);
                camParametersHandler.IsoMode.SetValue(t, true);
            }
        }
    };
}
