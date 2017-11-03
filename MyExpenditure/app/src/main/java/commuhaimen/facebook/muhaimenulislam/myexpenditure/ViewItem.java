package commuhaimen.facebook.muhaimenulislam.myexpenditure;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewItem extends AppCompatActivity {

    DataAccess dao;
    Button button_VA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);

        dao=new DataAccess(this);

        button_VA = (Button)findViewById(R.id.button_VA);
    }

    public void viewAll(){
        button_VA.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Cursor res = dao.getAllData();
                        if(res.getCount()==0){
                            //Show msg
                            showMsg("Error", "No Data Found");
                            return;
                        }else{
                            StringBuffer buffer = new StringBuffer();
                            while (res.moveToNext()){
                                //buffer.append("ID :"+res.getString(0)+"\n");
                                buffer.append("Name :"+res.getString(1)+"\n");
                                buffer.append("Date :"+res.getString(3)+"\n");
                                buffer.append("Amount :"+res.getString(2)+"\n");
                                buffer.append("Description :"+res.getString(4)+"\n --- --- ---\n");
                            }
                            //Show all data
                            showMsg("Data", buffer.toString());
                        }
                    }
                }
        );
    }
    public void showMsg(String title,String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }

}
