package commuhaimen.facebook.muhaimenulislam.myexpenditure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void addItem(View view){
        Intent i1 = new Intent(this, AddItem.class);
        startActivity(i1);
    }
    public void viewItem(View view){
        Intent i2 = new Intent(this, ViewItem.class);
        startActivity(i2);
    }
}
