package commuhaimen.facebook.muhaimenulislam.myexpenditure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddItem extends AppCompatActivity {

    DataAccess dao;
    EditText editText,editText2,editText3,editText4;
    Button button_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        dao = new DataAccess(this);

        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);

        button_add = (Button)findViewById(R.id.button_add);
        addData();
    }

    public void addData(){
        button_add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = dao.insertData(editText.getText().toString(), editText2.getText().toString(), editText3.getText().toString(), editText4.getText().toString());

                        if (isInserted) {
                            Toast.makeText(AddItem.this, "Data is Inserted", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(AddItem.this, "Data is not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
