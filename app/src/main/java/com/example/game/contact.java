package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class contact extends AppCompatActivity {
    TextView mail;
    Intent emailIntent;
    String TO;
    ImageView home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(contact.this,LevelSelection.class));

            }
        });
        mail=findViewById(R.id.mail1);
        mail.setText(Html.fromHtml("<u>vaishnavi.dhadiwal9@gmail.com</u>"));
        mail=findViewById(R.id.mail2);
        mail.setText(Html.fromHtml("<u>t.katakkar9@gmail.com</u>"));
        mail=findViewById(R.id.mail3);
        mail.setText(Html.fromHtml("<u>sakshimemane2001@gmail.com</u>"));
        mail=findViewById(R.id.mail4);
        mail.setText(Html.fromHtml("<u>shrutinaphade027@gmail.com</u>"));
    }
    public void sendMail(View view)
    {
        switch(view.getId())
        {
            case R.id.mail1:
                mail = findViewById(R.id.mail1);
                TO = mail.getText().toString();
                emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ TO});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contact legions");
                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(contact.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.mail2:
                mail = findViewById(R.id.mail2);
                TO = mail.getText().toString();
                emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ TO});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contact legions");
                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(contact.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.mail3:
                mail = findViewById(R.id.mail3);
                TO = mail.getText().toString();
                emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ TO});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contact legions");
                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(contact.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.mail4:
                mail = findViewById(R.id.mail4);
                TO = mail.getText().toString();
                emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ TO});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contact legions");
                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(contact.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
