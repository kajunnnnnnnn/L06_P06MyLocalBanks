package sg.edu.rp.c346.id20026955.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button dbs;
    Button ocbc;
    Button uob;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.dbs);
        ocbc = findViewById(R.id.ocbc);
        uob = findViewById(R.id.uob);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        if (v == dbs){
            wordClicked = "dbs";
        }
        else if(v == ocbc){
            wordClicked = "ocbc";
        }
        else{
            wordClicked = "uob";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(wordClicked.equalsIgnoreCase("dbs")){
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(intentCall);
                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+65 63272265"));
                startActivity(intentCall);
                return true;  //menu item successfully handled
            }
        }
        else if (wordClicked.equalsIgnoreCase("ocbc")){
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/gateway?"));
                startActivity(intentCall);
                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+65 63633333"));
                startActivity(intentCall);
                return true;  //menu item successfully handled
            }
        }
        else if (wordClicked.equalsIgnoreCase("uob")){
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uobgroup.com/uobgroup/index.page"));
                startActivity(intentCall);
                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+65 68685101"));
                startActivity(intentCall);
                return true;  //menu item successfully handled
            }
        }

        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.Chinese) {
            dbs.setText("星展银行");
            ocbc.setText("华侨银行");
            uob.setText("大华银行");
            return true;
        }
        else if (id == R.id.English){
            dbs.setText("Dbs");
            ocbc.setText("Ocbc");
            uob.setText("Uob");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}