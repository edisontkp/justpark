package edisontkp.com.justpark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.pedant.SweetAlert.SweetAlertDialog;
import edisontkp.com.justpark.utility.PreferenceHelper;

public class SignActivity extends AppCompatActivity {

    private TextView phoneNumber;
    private Button signButton;
    private PreferenceHelper pHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        pHelper = new PreferenceHelper(this);

        phoneNumber = (TextView)findViewById(R.id.phone_number);
        signButton = (Button) findViewById(R.id.sign_button);
        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!phoneNumber.getText().toString().isEmpty()){
                    pHelper.setPhoneNumber(phoneNumber.getText().toString());
                    Intent i = new Intent(SignActivity.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    new SweetAlertDialog(SignActivity.this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Oops...")
                            .setContentText("Something went wrong!")
                            .show();
                }
            }
        });


    }
}
