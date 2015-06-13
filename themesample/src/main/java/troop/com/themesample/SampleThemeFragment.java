package troop.com.themesample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.troop.freedcam.i_camera.AbstractCameraUiWrapper;
import com.troop.freedcam.ui.AbstractFragment;
import com.troop.freedcam.ui.AppSettingsManager;
import com.troop.freedcam.ui.I_Activity;

import troop.com.themesample.views.ThumbView;
import troop.com.themesample.views.UiSettingsChild;
import troop.com.themesample.views.UiSettingsChildCameraSwitch;
import troop.com.themesample.views.UiSettingsChildExit;
import troop.com.themesample.views.UiSettingsChildModeSwitch;

/**
 * Created by troop on 09.06.2015.
 */
public class SampleThemeFragment extends AbstractFragment
{
    UiSettingsChild flash;
    UiSettingsChild iso;
    UiSettingsChild autoexposure;
    UiSettingsChild whitebalance;
    UiSettingsChild focus;
    UiSettingsChild night;
    UiSettingsChild format;
    UiSettingsChildCameraSwitch cameraSwitch;
    UiSettingsChildExit exit;
    UiSettingsChildModeSwitch modeSwitch;

    ThumbView thumbView;

    AbstractCameraUiWrapper abstractCameraUiWrapper;
    LinearLayout left_cameraUI_holder;
    View view;
    I_Activity i_activity;
    AppSettingsManager appSettingsManager;

    @Override
    public void SetStuff(AppSettingsManager appSettingsManager, I_Activity i_activity) {
        this.i_activity = i_activity;
        this.appSettingsManager = appSettingsManager;
    }

    @Override
    public void SetCameraUIWrapper(AbstractCameraUiWrapper wrapper)
    {
        this.abstractCameraUiWrapper = wrapper;
        if (view != null)
        {

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        this.view = inflater.inflate(R.layout.cameraui, container, false);
        this.left_cameraUI_holder = (LinearLayout)view.findViewById(R.id.left_ui_holder);
        this.flash = (UiSettingsChild)view.findViewById(R.id.Flash);
        flash.SetI_Activity(i_activity);
        this.iso = (UiSettingsChild)view.findViewById(R.id.Iso);
        iso.SetI_Activity(i_activity);
        this.autoexposure =(UiSettingsChild)view.findViewById(R.id.Ae);
        autoexposure.SetI_Activity(i_activity);
        this.whitebalance = (UiSettingsChild)view.findViewById(R.id.wb);
        whitebalance.SetI_Activity(i_activity);
        this.focus = (UiSettingsChild)view.findViewById(R.id.focus);
        focus.SetI_Activity(i_activity);
        this.night = (UiSettingsChild)view.findViewById(R.id.focus);
        night.SetI_Activity(i_activity);
        this.format = (UiSettingsChild)view.findViewById(R.id.format);
        format.SetI_Activity(i_activity);
        this.thumbView = (ThumbView)view.findViewById(R.id.thumbview);
        this.modeSwitch = (UiSettingsChildModeSwitch)view.findViewById(R.id.mode_switch);
        modeSwitch.SetI_Activity(i_activity);
        exit = (UiSettingsChildExit)view.findViewById(R.id.exit);
        exit.SetI_Activity(i_activity);
        cameraSwitch = (UiSettingsChildCameraSwitch)view.findViewById(R.id.camera_switch);
        cameraSwitch.SetI_Activity(i_activity);

        flash.SetParameter(abstractCameraUiWrapper.camParametersHandler.FlashMode);
        iso.SetParameter(abstractCameraUiWrapper.camParametersHandler.IsoMode);
        autoexposure.SetParameter(abstractCameraUiWrapper.camParametersHandler.ExposureMode);
        whitebalance.SetParameter(abstractCameraUiWrapper.camParametersHandler.WhiteBalanceMode);
        focus.SetParameter(abstractCameraUiWrapper.camParametersHandler.FocusMode);
        night.SetParameter(abstractCameraUiWrapper.camParametersHandler.NightMode);
        thumbView.INIT(i_activity,abstractCameraUiWrapper);


        return view;
    }

}
