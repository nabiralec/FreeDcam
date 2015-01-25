package com.troop.freedcam.camera.parameters.modes;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.troop.androiddng.MainActivity;
import com.troop.freedcam.R;
import com.troop.freedcam.camera.parameters.I_ParameterChanged;
import com.troop.freedcam.ui.AppSettingsManager;
import com.troop.freedcam.ui.MainActivity_v2;
import com.troop.freedcam.ui.handler.GuideHandler;
//defcomg was here
import java.util.HashMap;

/**
 * Created by George on 1/19/2015.
 */
public class GuideList extends BaseModeParameter
{

    MainActivity_v2 context;
    AppSettingsManager appSettingsManager;
    String value;

    public GuideList(HashMap<String, String> parameters, I_ParameterChanged parameterChanged, String value, String values,AppSettingsManager appSettingsManager,MainActivity_v2 context) {
        super(parameters,parameterChanged, value, values);
        this.appSettingsManager = appSettingsManager;
        this.context = context;
        //this.appSettingsManager = appSettingsManager;




    }





    @Override
    public boolean IsSupported() {
        return true;
    }

    @Override
    public void SetValue(final String valueToSet, boolean setToCam)
    {
        value = valueToSet;
        BackgroundValueHasChanged(valueToSet);

        //appSettingsManager.setString(AppSettingsManager.SETTING_GUIDE, valueToSet);
       // ImageView imageView1 = (ImageView)context.findViewById(R.id.GuideView);
       // imageView1.setImageResource(R.drawable.ic_guide_golden_spiral);
    }

    @Override
    public String GetValue()
    {
        if (value.equals(""))
            return "Golden Spiral";
        else
            return value;
    }

    @Override
    public String[] GetValues()
    {
        //defcomg was 24/01/15 Rearranged and added new Guides

        //return new String[]{"None","Instagram 1:1","Instagram 4:3","Instagram 16:9","Diagonal","Golden Ratio","Golden Spiral","Rule Of Thirds"};

        return new String[]{"None","Diagonal Type 1","Diagonal Type 2","Diagonal Type 3","Diagonal Type 4","Diagonal Type 5","Golden Hybrid","Golden R/S 1","Golden R/S 2","Golden Ratio","Golden Spiral","Golden Triangle","Group POV Five","Group POV Three","Group POV Potrait","Group POV Full","Group POV Elvated","Group by Depth","Group Center Lead","Instagram 1:1","Instagram 4:3","Instagram 16:9","Rule Of Thirds"};
    }



}
