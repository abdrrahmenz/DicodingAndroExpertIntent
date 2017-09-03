package id.co.qodr.androexpertintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

// TODO implement View.OnclickListener untuk mendapatkan aksi pada button view
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // TODO Deklarasi Button yg ada di View layout main
    private Button btnMoveActivity, btnMoveWithDataActivity, btnMoveWithObject, btnDialPhone,btnMoveForResult;
    private TextView tvResult;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO inisialisasi Object Button diatas agar sesuasi (cast) dg layout id xml
        btnMoveActivity = (Button) findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);
        btnMoveWithDataActivity = (Button) findViewById(R.id.btn_move_activity_data);
        btnMoveWithDataActivity.setOnClickListener(this);
        btnMoveWithObject = (Button) findViewById(R.id.btn_move_activity_object);
        btnMoveWithObject.setOnClickListener(this);
        btnDialPhone = (Button) findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(this);
        btnMoveForResult = (Button) findViewById(R.id.btn_move_for_result);
        btnMoveForResult.setOnClickListener(this);
        tvResult = (TextView) findViewById(R.id.tv_result);
    }

    // TODO menambahka logic untuk aksi button
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            // TODO pindah activity dengan tidak membawa data (buat activity baru jika belum buat)
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;
            // TODO pindah activity dengan membawa data (buat activity baru jika belum buat)
            case R.id.btn_move_activity_data:
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Qodr Academy Boy");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 7);
                startActivity(moveWithDataIntent);
                break;
            // TODO pindah activity dengan membawa data dari POJO (buat activity baru & POJO class jika belum buat)
            case R.id.btn_move_activity_object:
                // set data untuk POJO Person.class
                Person mPerson = new Person();
                mPerson.setName("Qodr Academy");
                mPerson.setAge(17);
                mPerson.setEmail("academy@qodr.or.id");
                mPerson.setCity("Pekalongan");

                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, mPerson);
                startActivity(moveWithObjectIntent);
                break;
            // TODO pindah activity dengan menjalankan dial phone bawaan handphone
            case R.id.btn_dial_number:
                String phoneNumber = "089634518222";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;
            // TODO pindah activity dengan result code (tambahkan onActivityResult method jika belum ada)
            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }
    }

    // TODO tambahkan logic REQUEST CODE dan RESULT CODE dari activity sebelumnya kemudian set text
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE,0);
                tvResult.setText("Hasil : "+selectedValue);
            }
        }
    }
}
