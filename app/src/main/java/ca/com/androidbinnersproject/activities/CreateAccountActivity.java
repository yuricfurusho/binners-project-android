package ca.com.androidbinnersproject.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import ca.com.androidbinnersproject.R;
import ca.com.androidbinnersproject.util.Util;

/**
 * Created by jonathan_campos on 18/02/2016.
 */
public class CreateAccountActivity extends Activity{
    public static final int CREATE_ACCOUNT_RESULT = 1;

    private ImageView imgBinnerResidentSelector;
    private EditText edtName;
    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnGetStarted;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);

        imgBinnerResidentSelector = (ImageView) findViewById(R.id.create_user_binner_resident_selector);
        edtName  = (EditText) findViewById(R.id.create_user_edtName);
        edtEmail = (EditText) findViewById(R.id.create_user_edtEmail);
        edtPassword = (EditText) findViewById(R.id.create_user_edtPassword);
        btnGetStarted = (Button) findViewById(R.id.create_user_btnGetStarted);

        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateInputs()) {

                }
            }
        });
    }

    private boolean validateInputs() {
        String name = edtName.getText().toString();
        String email= edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        boolean result = true;

        if(name == null || email == null || password == null) {
            return false;
        }

        if(name.length() <= 0) {
            edtName.setError(getString(R.string.create_user_validation_name));
            result = false;
        }
        if(email.length() <= 0 || !Util.isEmailValid(email)) {
            edtEmail.setError(getString(R.string.create_user_validation_email));
            result = false;
        }
        if(password.length() < 6) {
            edtPassword.setError(getString(R.string.create_user_validation_password));
            result = false;
        }

        return result;
    }
}