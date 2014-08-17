package com.troop.freecam.camera.parameters;

import android.hardware.Camera;

/**
 * Created by troop on 17.08.2014.
 */
public class SaturationManualParameter extends BaseManualParameter
{
    public SaturationManualParameter(Camera.Parameters parameters, String value, String maxValue, String MinValue) {
        super(parameters, value, maxValue, MinValue);
        value = "saturation";
        if (hasSupport())
        {
            int max = 0;
            try {
                max = Integer.parseInt(parameters.get("max-saturation"));
                max_value = "max-saturation";
            }
            catch (Exception ex)
            {
            }
            try
            {
                max = Integer.parseInt(parameters.get("saturation-max"));
                max_value = "saturation-max";
            }
            catch (Exception ex)
            {}

            int min = 0;
            try {
                min = Integer.parseInt(parameters.get("min-saturation"));
                min_value = "min-saturation";
            }
            catch (Exception ex)
            {
            }
            try
            {
                min = Integer.parseInt(parameters.get("saturation-min"));
                min_value = "saturation-min";
            }
            catch (Exception ex)
            {}
        }
    }
}
