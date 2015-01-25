package com.troop.freedcam.ui.handler;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.troop.freedcam.R;
import com.troop.freedcam.camera.parameters.I_ParametersLoaded;
import com.troop.freedcam.i_camera.AbstractCameraUiWrapper;
import com.troop.freedcam.i_camera.parameters.AbstractModeParameter;
import com.troop.freedcam.ui.MainActivity_v2;

/**
 * Created by George on 1/19/2015.
 */
public class GuideHandler extends LinearLayout implements AbstractModeParameter.I_ModeParameterEvent, I_ParametersLoaded {
    LinearLayout linearLayout;
    ImageView img;
    Context contextt;
    AbstractCameraUiWrapper cameraUiWrapper;


    public GuideHandler(Context context) {

        super(context);
        init(context);
        this.contextt = context;
    }

    public GuideHandler(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
        alignment();

    }

    public GuideHandler(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        alignment();
    }

    public void setCameraUiWrapper(AbstractCameraUiWrapper cameraUiWrapper)
    {
        this.cameraUiWrapper = cameraUiWrapper;
        cameraUiWrapper.camParametersHandler.ParametersEventHandler.AddParametersLoadedListner(this);

    }



    private void init(Context context)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.guides, this);
        img = (ImageView) findViewById(R.id.imageViewGyide);

    }

    public void SetViewG(final String str)
    {
        img.post(new Runnable() {
            @Override
            public void run() {
                System.out.println("defcomg "+ "truck");

                if(str.equals("Golden Spiral")){

                    img.setImageResource(R.drawable.ic_guide_golden_spiral_4_3);
                }
                else if(str.equals("Rule Of Thirds")){
                    //ImageView img = (ImageView) findViewById(R.id.imageViewGyide);
                    img.setImageResource(R.drawable.ic_guide_rule_3rd_4_3);
                }
                else if(str.equals("Instagram 1:1")){
                    //ImageView img = (ImageView) findViewById(R.id.imageViewGyide);
                    img.setImageResource(R.drawable.ic_guide_insta_1_1);
                }
                else if (str.equals("Instagram 4:3"))
                    img.setImageResource(R.drawable.ic_guide_insta_4_3);
                else if (str.equals("Instagram 16:9"))
                    img.setImageResource(R.drawable.ic_guide_insta_16_9);
                else if (str.equals("Diagonal Type 1"))
                    img.setImageResource(R.drawable.ic_guide_diagonal_type_1_4_3);
                else if (str.equals("Diagonal Type 2"))
                    img.setImageResource(R.drawable.ic_guide_diagonal_type_2_4_3);
                else if (str.equals("Diagonal Type 3"))
                    img.setImageResource(R.drawable.ic_guide_diagonal_type_3);
                else if (str.equals("Diagonal Type 4"))
                    img.setImageResource(R.drawable.ic_guide_diagonal_type_4);
                else if (str.equals("Diagonal Type 5"))
                    img.setImageResource(R.drawable.ic_guide_diagonal_type_5);
                else if (str.equals("Golden Ratio"))
                    img.setImageResource(R.drawable.ic_guide_golden_ratio_type_1_4_3);
                else if (str.equals("Golden Hybrid"))
                    img.setImageResource(R.drawable.ic_guide_golden_spriral_ratio_4_3);
                else if (str.equals("Golden R/S 1"))
                    img.setImageResource(R.drawable.ic_guide_golden_fuse1_4_3);
                else if (str.equals("Golden R/S 2"))
                    img.setImageResource(R.drawable.ic_guide_golden_fusion2_4_3);
                else if (str.equals("Golden Triangle"))
                    img.setImageResource(R.drawable.ic_guide_golden_triangle_4_3);
                else if (str.equals("Group POV Five"))
                    img.setImageResource(R.drawable.ic_guide_groufie_five);
                else if (str.equals("Group POV Three"))
                    img.setImageResource(R.drawable.ic_guide_groufie_three);
                else if (str.equals("Group POV Potrait"))
                    img.setImageResource(R.drawable.ic_guide_groupshot_potrait);
                else if (str.equals("Group POV Full"))
                    img.setImageResource(R.drawable.ic_guide_groupshot_fullbody);
                else if (str.equals("Group POV Elvated"))
                    img.setImageResource(R.drawable.ic_guide_groupshot_elevated_pov);
                else if (str.equals("Group by Depth"))
                    img.setImageResource(R.drawable.ic_guide_groupshot_outfocusing);
                else if (str.equals("Group Center Lead"))
                    img.setImageResource(R.drawable.ic_guide_groupshot_center_leader);
                else if (str.equals("None"))
                    img.setImageBitmap(null);
            }
        });




    }

    private void alignment()
    {
       linearLayout = (LinearLayout)findViewById(R.id.GuideView);


        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = RelativeLayout.ALIGN_PARENT_RIGHT;
        layoutParams.height = 20;
        linearLayout.setLayoutParams(layoutParams);

        //hytythy


    }

    @Override
    public void onValueChanged(String val) {
        SetViewG(val);
    }

    @Override
    public void onIsSupportedChanged(boolean isSupported) {

    }

    @Override
    public void onIsSetSupportedChanged(boolean isSupported) {

    }

    @Override
    public void onValuesChanged(String[] values) {

    }

    @Override
    public void ParametersLoaded() {
        cameraUiWrapper.camParametersHandler.GuideList.addEventListner(this);
        onValueChanged(cameraUiWrapper.camParametersHandler.GuideList.GetValue());
    }
}
