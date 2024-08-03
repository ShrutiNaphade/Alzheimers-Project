package com.example.game;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends Collection {
    EditText emailId, password;
    Button btnSignUp;
    //TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;
    private static final int RC_SIGN_IN = 234;
    GoogleSignInClient mGoogleSignInClient;
    Locale myLocale;
    String currentLanguage = "en", currentLang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentLanguage = getIntent().getStringExtra(currentLang);
        TextView h=(TextView) findViewById(R.id.hello);
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(),newActivity.class);
                startActivity(i);
            }
        });

        //tvSignIn = findViewById(R.id.textView);
        mFirebaseAuth = FirebaseAuth.getInstance();
        //Then we need a GoogleSignInOptions object
        //And we need to build it as below
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        //Then we will get the GoogleSignInClient object from GoogleSignIn class
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
        emailId = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        btnSignUp = findViewById(R.id.button2);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                if (email.isEmpty()) {
                    emailId.setError("Please enter email id");
                    emailId.requestFocus();
                } else if (pwd.isEmpty()) {
                    password.setError("Please enter your password");
                    password.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fields are Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && pwd.isEmpty()))
                {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "SignUp Unsuccessful,Please Try again", Toast.LENGTH_SHORT).show();
                            } else {
                                String uid=FirebaseAuth.getInstance().getCurrentUser().getUid();
                                //String uname=FirebaseAuth.getInstance().getCurrentUser().getDisplayName();

                                int index = email.indexOf('@');
                                String uname = email.substring(0,index);
                                user_name = uname;
                                useremail = email;
                                userid = uid;
                               /* SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPref.edit();
                                editor.putString("email", email);
                                editor.putString("uid", uid);
                                editor.putString("uname", uname);
                                editor.apply();*/
                                Toast.makeText(MainActivity.this, "User Signed In as "+uname, Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(MainActivity.this, LevelSelection.class);
                                i.putExtra("email",email);
                                startActivity(i);
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Error Occured!",Toast.LENGTH_SHORT).show();
                }
            }
        });
//--------------------------------------------------------------------------------
       /* String text = "Already have an account? Sign in here";
        SpannableString ss = new SpannableString(text);
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(MainActivity.this, "Redirecting to login", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(MainActivity.this,LoginActivity.class);
                Toast.makeText(MainActivity.this, "Intent is created", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);
            }
        };
        ss.setSpan(clickableSpan1, 25, 37, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvSignIn.setText(ss);
        tvSignIn.setMovementMethod(LinkMovementMethod.getInstance());

       tvSignIn.setClickable(true);
       tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Redirecting to login", Toast.LENGTH_SHORT).show();
                tvSignIn=findViewById(R.id.textView);
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });*/
    }
    //this method is called on click
    private void signIn() {
        //getting the google signin intent
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();

        //starting the activity for result
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //if the requestCode is the Google Sign In code that we defined at starting
        if (requestCode == RC_SIGN_IN) {

            //Getting the GoogleSignIn Task
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                //Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);

                //authenticating with firebase
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d("AMYPAD", "firebaseAuthWithGoogle:" + acct.getId());

        //getting the auth credential
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);

        //Now using firebase we are signing in the user here
        mFirebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("AMYPAD", "signInWithCredential:success");
                            FirebaseUser user = mFirebaseAuth.getCurrentUser();
                            String username = user.getDisplayName();
                            user_name = username;
                            useremail = user.getEmail();
                            userid=user.getUid();
                            SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            //editor.putString("email",user.getEmail().toString());
                            editor.putString("uid",user.getUid());
                            //editor.putString("uname",user.getDisplayName());
                            editor.apply();
                            Toast.makeText(MainActivity.this, "User Signed In as "+username, Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(MainActivity.this, LevelSelection.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("AMYPAD", "signInWithCredential:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_first, menu);

        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) item.getActionView();
        List<String> list = new ArrayList<String>();
        list.add("          ");
        list.add("English");
        list.add("Español");
        list.add("Français");
        list.add("Hindi");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.custom_spinner, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        setLocale("en");
                        break;
                    case 2:
                        setLocale("es");
                        break;
                    case 3:
                        setLocale("fr");
                        break;
                    case 4:
                        setLocale("hi");
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        return true;
    }
    public void setLocale(String localeName) {
        if (!localeName.equals(currentLanguage)) {
            myLocale = new Locale(localeName);
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(this, MainActivity.class);
            refresh.putExtra(currentLang, localeName);
            startActivity(refresh);
        } else {
            Toast.makeText(MainActivity.this, "Language already selected!", Toast.LENGTH_SHORT).show();
        }
    }
}
