package bd.piniti.service_pro.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import bd.piniti.service_pro.R;

public class EditProfileActivity extends AppCompatActivity {

    private Button doneButton;
    private EditText fName, lName, phone, address, dateOfBirth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        doneButton = findViewById(R.id.done_button);
        fName = findViewById(R.id.first_name);
        lName = findViewById(R.id.last_name);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        dateOfBirth = findViewById(R.id.date_of_birth);

        ImageView back = findViewById(R.id.back_img);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
