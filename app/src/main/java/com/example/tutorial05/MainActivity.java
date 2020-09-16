package com.example.tutorial05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText fname,lname,username,password;
    Switch aSwitch;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Spinner spinner;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = findViewById(R.id.edtFirstname);
        lname = findViewById(R.id.edtLastname);
        username = findViewById(R.id.edtUsername);
        password = findViewById(R.id.edtPassword);

        aSwitch = findViewById(R.id.swtBranch);

        radioGroup = findViewById(R.id.rdgGender);
        radioButton = findViewById(radioGroup.getCheckedRadioButtonId());

        spinner = findViewById(R.id.spnCity);

        checkBox = findViewById(R.id.chkStatus);
    }

    public void checkDataValidity(View view) {
        String city,gender,status;

        city = spinner.getSelectedItem().toString();
        gender = radioButton.getText().toString();
        status = checkBox.isChecked()?"Active":"Inactive";
        if(isEmpty(fname)){
            Toast.makeText(this,"You must be enter first name",Toast.LENGTH_LONG).show();
            return;
        }
        if(isEmpty(lname)){
            Toast.makeText(this,"You must be enter last name",Toast.LENGTH_LONG).show();
            return;
        }
        if(isEmpty(username)){
            Toast.makeText(this,"You must be enter username",Toast.LENGTH_LONG).show();
            return;
        }
        if(isEmpty(password)){
            Toast.makeText(this,"You must be enter password",Toast.LENGTH_LONG).show();
            return;
        }
        if(!isEmail(username)){
            Toast.makeText(this,"Enter valid email",Toast.LENGTH_LONG).show();
            return;
        }
        String City = spinner.getSelectedItem().toString();
        if(City.equals("Select City")){
            Toast.makeText(this,"Select city",Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent = new Intent(MainActivity.this,DisplayActivity.class);
        intent.putExtra("first_name",fname.getText().toString());
        intent.putExtra("last_name",lname.getText().toString());
        intent.putExtra("username",username.getText().toString());
        intent.putExtra("password",password.getText().toString());
        intent.putExtra("city",city);
        intent.putExtra("gender",gender);
        intent.putExtra("status",status);

        startActivity(intent);
    }

    public boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    public boolean isEmail(EditText text){
        CharSequence str = text.getText().toString();
        return Patterns.EMAIL_ADDRESS.matcher(str).matches();
    }
}