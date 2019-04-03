package com.grafixartist.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


public class ApprenticeProfile extends AppCompatActivity {

    private TextView tvName, tvCompany, tvRole;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apprentice_profile);

        tvName = (TextView) findViewById(R.id.profile_name);
        tvCompany = (TextView) findViewById(R.id.profile_company);
        tvRole= (TextView) findViewById(R.id.profile_role);
        img = (ImageView) findViewById(R.id.apprentice_profile_pic);


        Intent intent = getIntent();
        String Name = intent.getExtras().getString("Name");
        String Company = intent.getExtras().getString("Company");
        String Role = intent.getExtras().getString("Role");
        int Image = intent.getExtras().getInt("Thumbnail");

        tvName.setText(Name);
        tvCompany.setText(Company);
        tvRole.setText(Role);
        img.setImageResource(Image);

    }
}
