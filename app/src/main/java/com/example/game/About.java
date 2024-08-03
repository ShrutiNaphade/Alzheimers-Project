package com.example.game;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;
import android.content.res.Configuration;
import android.view.View;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;
public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        View aboutPage = new AboutPage(this)
                .setImage(R.drawable.head)
                .setDescription("Amypad is a platform for Alzheimers Disease detection,developed with the sole purpose of utilization of technology in medical field." +
                        "It gives a user friendly environment for initial checkup test of Alzheimer's disease" +
                        " and thus lowers the patient's anxiety." +
                        "Gerocognitive Exam(SAGE) makes it assured,accurate and reliable.")
                .addItem(new Element().setTitle("Version 1.0"))
                .addGroup("Connect with us")
                .addEmail("amypadcreations@gmail.com")
                .addWebsite("https://tanvi7007.000webhostapp.com/includes/Login_v20%20(1)/Login_v20/index.html")
                .addFacebook("the.medy")
                .addTwitter("DhadiwalSandeep")
                .addYoutube("UijIZU804OU")
                .addInstagram("vaishnavidhadiwal")
                .addGitHub("vaishnavi-170701")
                .create();

        setContentView(aboutPage);
    }
}
