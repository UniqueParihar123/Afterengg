package com.example.anupamparihar.afterengg;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();
        return true;
    }



    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
       final EditText editText1=(EditText)findViewById(R.id.ret1);
     final EditText   editText2=(EditText)findViewById(R.id.ret2);
       Button  button=(Button)findViewById(R.id.rbtn);
        mAuth = FirebaseAuth.getInstance();
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String s1=editText1.getText().toString();
                 String s2=editText2.getText().toString();
                 if (TextUtils.isEmpty(s1)){
                     editText1.setError("Enter Your Username");
                     editText2.requestFocus();
                     return;
                 }
                 Boolean onError = false;
                 if (!isValidEmail(s1)) {
                     onError = true;
                     editText1.setError("Invalid Email");
                     return;
                 }
                 if (TextUtils.isEmpty(s2)){
                     editText2.setError("Enter Password ");
                     editText2.requestFocus();
                     return;
                 }

                 mAuth.createUserWithEmailAndPassword(s1,s2)
                         .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                             @Override
                             public void onComplete(@NonNull Task<AuthResult> task) {
                                 // Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                                 // If sign in fails, display a message to the user. If sign in succeeds
                                 // the auth state listener will be notified and logic to handle the
                                 // signed in user can be handled in the listener.





                                 ProgressDialog.show(Register.this,"Registering Account","Please Wait ..");
                                 Toast.makeText(Register.this, "Please Login Now !", Toast.LENGTH_SHORT).show();
                                 Save.save(getApplicationContext(),"session","true");
                                 Intent i=new Intent(Register.this,login.class);
                                 startActivity(i);
                                 finish();
                                 //if user completes signup


                                 // ...
                             }
                         });
             }
         });
    }



    @Override
    public void onResume() {
        super.onResume();
        //Get a Tracker (should auto-report)


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
