package com.aura.popescu.tcb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

public class Projects extends AppCompatActivity {
    ListView list;
    String[] mTestArray;

    Integer[] listviewImage = {R.drawable.buton_calut, R.drawable.buton_canuta,
            R.drawable.buton_cavaler,R.drawable.buton_bomboland
            ,R.drawable.buton_ciorapel,R.drawable.buton_oameni, R.drawable.buton_pui

    };

    /*String[] listviewShortDescription = new String[]{
            "Android ListView Short Description", "Android ListView Short Description", "Android ListView Short Description", "Android ListView Short Description",
            "Android ListView Short Description", "Android ListView Short Description", "Android ListView Short Description"
    };*/
    /*private String[] myImageNameList = new String[]{"VINEREA SPERANTEI - Vinerea Speranței este un proiect de incluziune, în care copii cu nevoi speciale din București se întâlnesc cu căluți, llame și căței la adăpostul pentru cai “Steaua Speranței”!", "CANUTA CU BOMBOANE",
            "SEARA DE POVESTE - O carte sub braț, un măr în mână și multă dragoste! Voluntari din toată țara și din toate colțurile lumii, împreună cu Gașca Colorată transformă serile obișnuite de spital în momente magice!","BOMBOLAND - Bomboland este cel mai ambițios proiect al Taxiului cu Bomboane. Este locul unde prin atelierele desfășurate zi de zi, tinerii cu nevoi speciale își vor redobândi stima de sine și sentimentul de utilitate."
            ,"CIORAPELUL CU BOMBOANE - Ultima cursă specială din 2017 a “Taxiului cu Bomboane”! Între 5 şi 7 decembrie voluntarii au oprit la toate secţiile de pediatrie din Bucureşti şi au împărţit copiilor ciorăpei cu bomboane, pupici şi zâmbete!",
            "OAMENI DIN TAXIUL CU BOMBOANE - Galeria Occidentului organizează vernisaj și licitație de fotografii în scopul strângerii de fonduri pentru Asociația Taxiul cu Bomboane! Deși un proiect recent, acest eveniment este deja la a doua ediție!\n" +
                    "\n","PUI DE PERNA PENTRU PUI DE OM - În fiecare an, în preajma Paştelui, copiii din spitalele de pediatrie primesc pernuţe însoţite de cărţi! Este o acţiune prin care dorim să bucurăm copiii dar şi să le trezim curiozitatea de a citi! "};
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        mTestArray = getResources().getStringArray(R.array.projectsArray);
        CustomList adapter = new CustomList(Projects.this, mTestArray, listviewImage);
        list = findViewById(R.id.list);
        list.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Write your logic here
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}