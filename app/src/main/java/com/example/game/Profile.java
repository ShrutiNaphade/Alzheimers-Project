package com.example.game;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.bumptech.glide.Glide;
import java.util.Date;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;

import androidx.core.app.ActivityCompat;
import android.Manifest;

import static android.os.Environment.getExternalStorageDirectory;
import static android.widget.Toast.makeText;

public class Profile extends Collection {
    TextView l1, l2, l3, l4, l5, l6, l7, l8;
    TextView total;
    TextView email;
    TextView percent;
    Button submit;
    Bitmap bmp, scaledBitmap;
    Date dateobj;
    DateFormat df;
    DateFormat dff;
    String uid;
    String uname;
    String valueemail;
    String usertotal,userpercent,username;
    String s1,s2,s3,s4,s5,s6,s7,s8;
    int tot;
    float rate;
    FirebaseDatabase rootNoode;
    DatabaseReference reference;
    UserHelperClass userHelperClass;
    Date today;
    ImageButton pdfbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        pdfbutton = findViewById(R.id.pdfbutton);
        ImageView imageView = findViewById(R.id.nav_header_img);
        Glide.with(this).load(R.drawable.checkbox).into(imageView);
        today = new Date();
        l1 = findViewById(R.id.level1);
        l2 = findViewById(R.id.level2);
        l3 = findViewById(R.id.level3);
        l4 = findViewById(R.id.level4);
        l5 = findViewById(R.id.level5);
        l6 = findViewById(R.id.level6);
        l7 = findViewById(R.id.level7);
        l8 = findViewById(R.id.level8);
        total = findViewById(R.id.total);
        //email=findViewById(R.id.email);
        percent = findViewById(R.id.percent);
        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        valueemail = useremail;
        // email.setText(valueemail);
        s1 = ""+level1score;
        l1.setText(s1);
        s2 = ""+level2score;
        l2.setText(s2);
        s3 = ""+level3score;
        l3.setText(s3);
        s4 = ""+level4score;
        l4.setText(s4);
        s5 = ""+level5score;
        l5.setText(s5);
        s6 = ""+level6score;
        l6.setText(s6);
        s7 =""+level7score;
        l7.setText(s7);
        s8 = ""+level8score;
        l8.setText(s8);
        tot = level1score + level2score + level3score + level4score + level5score + level6score + level7score + level8score;
        total.setText("" + tot);
        rate = (Float.parseFloat("" + tot) / 30) * 100;
        rate = 100 - rate;
        percent.setText("" + rate + "%");
        uid = userid;
        uname = user_name;
        //Toast.makeText(this,""+uid,Toast.LENGTH_SHORT).show();

        submit = findViewById(R.id.process);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alert = new AlertDialog.Builder(Profile.this).create();
                alert.setTitle("Processed successfully !");
                alert.setMessage("Your data is safe with us :)");
                alert.setCancelMessage(null);
                alert.show();
                rootNoode = FirebaseDatabase.getInstance();
                reference = rootNoode.getReference("user");
                String userid = uid;
                String useremail = valueemail; //email.getText().toString();
                String userdate = today.toString();
                usertotal = "" + tot;
                userpercent = "" + rate;
                username = uname;
                userHelperClass = new UserHelperClass(userid, username, useremail, userdate, usertotal, userpercent);
                reference.child(username).setValue(userHelperClass);
            }
        });
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.new2);
        scaledBitmap = Bitmap.createScaledBitmap(bmp, 1200, 466, false);


        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        createPDF();
    }
    public void navigation(View view)
    {
                startActivity(new Intent(Profile.this,LevelSelection.class));
    }
    private void createPDF() {
        pdfbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Report generated successfully",
                        Toast.LENGTH_SHORT).show();
                //dateobj
                //makeText(this, "Created successfully", Toast.LENGTH_SHORT).show();
                //dateobj
                dateobj = new Date();
                PdfDocument myPdfDocument;
                myPdfDocument = new PdfDocument();
                Paint myPaint = new Paint();
                Paint title = new Paint();
                title.setTextAlign(Paint.Align.CENTER);
                title.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                title.setTextSize(70);
                //pdfCreation
                PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(1200, 2010, 1).create();
                PdfDocument.Page myPage1 = myPdfDocument.startPage(myPageInfo1);
                Canvas canvas = myPage1.getCanvas();
                canvas.drawBitmap(scaledBitmap, 0, 0, myPaint);
                myPaint.setColor(Color.rgb(0, 111, 100));
                myPaint.setTextSize(30);
                myPaint.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText("Call:9665252592", 1140, 40, myPaint);
                title.setTextAlign(Paint.Align.CENTER);
                title.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                title.setTextSize(70);
                canvas.drawText("Detection Report", 600, 530, title);
                myPaint.setTextAlign(Paint.Align.LEFT);
                myPaint.setTextSize(35);
                myPaint.setColor(Color.BLACK);
                canvas.drawText("Name: " + uname, 20, 590, myPaint);
                myPaint.setTextAlign(Paint.Align.LEFT);
                canvas.drawText("Email: " + valueemail, 20, 640, myPaint);
                myPaint.setTextAlign(Paint.Align.RIGHT);
                df = new SimpleDateFormat("yyyy-MM-dd");
                canvas.drawText("Date: " + df.format(dateobj), 1180, 590, myPaint);
                dff = new SimpleDateFormat("hh:mm:ss");
                canvas.drawText("  Time: " + dff.format(dateobj), 1180, 640, myPaint);
                myPaint.setStyle(Paint.Style.STROKE);
                myPaint.setStrokeWidth(2);
                //rect
                canvas.drawRect(20, 780, 680, 860, myPaint);
                myPaint.setTextAlign(Paint.Align.LEFT);
                myPaint.setStyle(Paint.Style.FILL);
                canvas.drawText("Stage No", 40, 830, myPaint);
                canvas.drawText("Points", 240, 830, myPaint);
                //lines
                canvas.drawLine(200, 780, 200, 1350, myPaint);
                canvas.drawLine(680, 790, 680, 1350, myPaint);
                canvas.drawLine(20, 790, 20, 1350, myPaint);
                //stage 1
                canvas.drawText("Level 1", 40, 950, myPaint);
                canvas.drawText(s1, 240, 950, myPaint);
                //stage2
                canvas.drawText("Level 2", 40, 1000, myPaint);
                canvas.drawText(s2, 240, 1000, myPaint);
                //stage3
                canvas.drawText("Level 3", 40, 1050, myPaint);
                canvas.drawText(s3, 240, 1050, myPaint);
                //stage4
                canvas.drawText("Level 4", 40, 1100, myPaint);
                canvas.drawText(s4, 240, 1100, myPaint);
                //stage5
                canvas.drawText("Level 5", 40, 1150, myPaint);
                canvas.drawText(s5, 240, 1150, myPaint);
                //stage6
                canvas.drawText("Level 6", 40, 1200, myPaint);
                canvas.drawText(s6, 240, 1200, myPaint);
                //stage7
                canvas.drawText("Level 7", 40, 1250, myPaint);
                canvas.drawText(s7, 240, 1250, myPaint);
                //stage8
                canvas.drawText("Level 8", 40, 1300, myPaint);
                canvas.drawText(s8, 240, 1300, myPaint);
                canvas.drawLine(20, 1350, 680, 1350, myPaint);
                //line PageBorder
                canvas.drawLine(0, 2000, 1200, 2000, myPaint);
                canvas.drawLine(0, 0, 1200, 0, myPaint);
                canvas.drawLine(0, 0, 0, 2000, myPaint);
                canvas.drawLine(1200, 0, 1200, 2000, myPaint);
                myPaint.setColor(Color.rgb(247, 147, 30));
                canvas.drawRect(20, 1400, 680, 1500, myPaint);
                myPaint.setColor(Color.BLACK);
                myPaint.setTextSize(50);
                myPaint.setTextAlign(Paint.Align.LEFT);
                canvas.drawText("Total Points:", 30, 1465, myPaint);
                myPaint.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText("" + tot, 640, 1465, myPaint);
                myPaint.setTextAlign(Paint.Align.LEFT);
                canvas.drawText("Risk rate " + rate + " %", 30, 1550, myPaint);
                //note
                myPaint.setTextAlign(Paint.Align.LEFT);
                myPaint.setTextSize(30);
                canvas.drawText("Notes:-", 20, 1650, myPaint);
                canvas.drawText("* If your score is less than defined limits consult the doctors", 20, 1700, myPaint);
                canvas.drawText("* This is autogenerated report by AMYPAD.", 20, 1750, myPaint);
                canvas.drawText("* Made with Love by: The Legions", 20, 1800, myPaint);
                myPdfDocument.finishPage(myPage1);
                File file;
                file = new File(getExternalStorageDirectory(), "/DetectionReport.pdf");
                try {
                    myPdfDocument.writeTo(new FileOutputStream((file)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myPdfDocument.close();
            }
        });
    }
}