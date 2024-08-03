package com.example.game.ui.home;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.game.LevelOne;
import com.example.game.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    ViewFlipper v_flipper;
    View root;
    ProgressDialog progressDialog;
    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState)
    {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);
        TextView txt= root.findViewById(R.id.text);
        ImageView playbtn = root.findViewById(R.id.playbtn);
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(view.getContext());
                progressDialog.setMessage("Sometimes we're tested not to show our weakness but to discover our strength");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
                progressDialog.show(); // Display Progress Dialog
                progressDialog.setCancelable(false);
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(5000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        progressDialog.dismiss();
                    }
                }).start();
                Handler mHandler = new Handler();
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getContext(), LevelOne.class));
                    }

                }, 5000);

            }
        });
        txt.setSelected(true);
        int images[]={R.drawable.flip1,R.drawable.flip2,R.drawable.flip3,R.drawable.flip4,R.drawable.flip5};
        v_flipper = (ViewFlipper) 	root.findViewById(R.id.v_flipper);
        for(int i=0;i<images.length;i++)
        {
            flipperImage(images[i]);
        }
        return root;
    }
    public void flipperImage(int image)
    {
        ImageView imageView=new ImageView(root.getContext());
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(6000);
        v_flipper.setAutoStart(true);

        //animation
        v_flipper.setInAnimation(root.getContext(),android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(root.getContext(),android.R.anim.slide_out_right);
    }
}