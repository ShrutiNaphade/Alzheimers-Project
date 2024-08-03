package com.example.game;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import java.util.ArrayList;
import java.util.Locale;
public class LevelEight extends Collection {
    private TextView txvResult;
    int a_count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_eight);
        txvResult = (TextView) findViewById(R.id.txvResult);
    }
    public void navigation(View view)
    {
        switch (view.getId()) {
            case R.id.home:
                startActivity(new Intent(LevelEight.this,LevelSelection.class));
                break;
            case R.id.next:
                startActivity(new Intent(LevelEight.this,Profile.class));
                break;
        }
    }
    public void getSpeechInput(View view) {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txvResult.setText(result.get(0));
                    //Toast.makeText(getApplicationContext(),txvResult.getText().toString(),Toast.LENGTH_LONG).show();

                    String[] separated = txvResult.getText().toString().split(" ");

                        for(int i=0;i<separated.length;i++)
                        {
                            if (separated[i].startsWith("a"))
                            {
                                a_count++;
                            }
                            else if(separated[i].startsWith("A"))
                            {
                                a_count++;
                            }
                        }


                    AlertDialog alert = new AlertDialog.Builder(LevelEight.this).create();
                    alert.setTitle("Correct words : ");
                    alert.setMessage(" "+a_count);
                    alert.setCancelMessage(null);
                    alert.show();
                    if(a_count>3)
                    {
                        level8score=3;
                        /*SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("level8",""+3);
                        editor.apply();*/
                    }
                    else  if(a_count>=2)
                    {
                        level8score=2;
                        /*SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("level8",""+2);
                        editor.apply();*/
                    }
                    else
                    {
                        level8score = 0;
                        /*SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("level8",""+0);
                        editor.apply();*/
                    }
                }
                break;
        }
    }
}
