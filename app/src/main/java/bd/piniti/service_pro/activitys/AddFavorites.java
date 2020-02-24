package bd.piniti.service_pro.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import bd.piniti.service_pro.R;

public class AddFavorites extends AppCompatActivity {

    private Button doneButton;
    private LinearLayout uploadImage;
    private EditText fName, lName, phone, category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_favorites);


        doneButton = findViewById(R.id.done_button);
        uploadImage = findViewById(R.id.upload_photo);
        fName = findViewById(R.id.first_name);
        lName = findViewById(R.id.last_name);
        phone = findViewById(R.id.phone);
        category = findViewById(R.id.category);
    }
}
