package id.co.qodr.androexpertintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObjectActivity extends AppCompatActivity {
    // TODO buat variable static bertype String untuk penentuan Key paramter intent saat dikirim/diterima
    public static String EXTRA_PERSON = "extra_person";
    private TextView tvObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        tvObject = (TextView) findViewById(R.id.tv_object_received);

        Person mPerson = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Nama : "+mPerson.getName()+", Email : "+mPerson.getEmail()+", Age : "+
                mPerson.getAge() + ", Location : "+mPerson.getCity();
        tvObject.setText(text);

    }
}
