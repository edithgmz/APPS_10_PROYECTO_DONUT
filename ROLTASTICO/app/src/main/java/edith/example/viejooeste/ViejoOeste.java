package edith.example.viejooeste;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;
import com.kosalgeek.android.photoutil.GalleryPhoto;
import com.kosalgeek.android.photoutil.ImageLoader;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;

import edith.example.datos.BaseDatos;
import edith.example.roltastico.Dado;
import edith.example.roltastico.R;

public class ViejoOeste extends AppCompatActivity {
    FloatingActionMenu menuFVO;



    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private static int GALLERY_REQUEST = 2200;
    private static Bitmap bVOImagen;
    //general
    private static ImageView imgVwVoPer;
    //
    private GalleryPhoto gpGaleria;
    private String sRutaImagen;
    //
    private BaseDatos baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viejo_oeste);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        menuFVO =  findViewById(R.id.menuVO);
        menuFVO.setClosedOnTouchOutside(true);

        baseDatos = new BaseDatos(getApplicationContext());
        //
        gpGaleria = new GalleryPhoto(getApplicationContext());
    }

    public void selecVoImagen(View v) {
        //Toast.makeText(getApplicationContext(), v.getId() + "Abrir galería.", Toast.LENGTH_SHORT).show();
        startActivityForResult(gpGaleria.openGalleryIntent(), GALLERY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == GALLERY_REQUEST) {
                Uri uriImagen = null;
                if (data != null) {
                    uriImagen = data.getData();
                }
                gpGaleria.setPhotoUri(uriImagen);
                sRutaImagen = gpGaleria.getPath();
                try {
                    bVOImagen = ImageLoader.init().from(sRutaImagen).getBitmap();
                    imgVwVoPer.setImageBitmap(bVOImagen);
                    //Toast.makeText(getApplicationContext(), "" + uriImagen, Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_viejo_oeste, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.acVoGuardar) {
            Toast.makeText(this, "Guardado.", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.acVoEliminar) {
            Toast.makeText(this, "Eliminar.", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.d3:
                Toast.makeText(this,(new Dado(3).roll())+",d3",Toast.LENGTH_SHORT).show();
                break;
            case R.id.d4:
                Toast.makeText(this,(new Dado(4).roll())+",d4",Toast.LENGTH_SHORT).show();
                break;
            case R.id.d8:
                Toast.makeText(this,(new Dado(8).roll())+",d8",Toast.LENGTH_SHORT).show();
                break;
            case R.id.dTwelve:
                Toast.makeText(this,(new Dado(12).roll())+",d12",Toast.LENGTH_SHORT).show();
                break;
            case R.id.d20:
                Toast.makeText(this,(new Dado(20).roll())+",d20",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        //general
        private static ImageView strImagen;
        private static Spinner strNombre;
        private static Spinner strClase;
        private static Spinner strNivAqd;
        private static EditText iPx;
        private static EditText iNivel;
        private static Spinner strTransfondo;
        private static EditText strTalento1;
        private static EditText strTalento2;
        private static RadioButton isFem; //género
        private static RadioButton isMas;

        //estadistica
        private static Spinner iStdFue;
        private static Spinner iStdDes;
        private static Spinner iStdCon;
        private static Spinner iStdInt;
        private static Spinner iStdSab;
        private static Spinner iStdCar;

        //modificador
        private static Spinner iModFue;
        private static Spinner iModDes;
        private static Spinner iModCon;
        private static Spinner iModInt;
        private static Spinner iModSab;
        private static Spinner iModCar;

        //habilidades
        private static EditText iAlerta;
        private static EditText iComunicacion;
        private static EditText iManipulacion;
        private static EditText iErudicion;
        private static EditText iSubterfugio;
        private static EditText iSupervivencia;
        //otros
        private static EditText iPvTot;//14 - stdFue
        private static EditText iPvAct; // va cambiando máximo pvTot
        private static EditText iDef; //14 - stdDes
        private static EditText iAtq; // 0 a 7
        private static EditText iInst;// 0 a 11

        //armas
        private static EditText strNomArm1;
        private static EditText iAtqArm1;
        private static EditText iDanArm1;
        private static EditText iTraArm1;
        private static EditText strNomArm2;
        private static EditText iAtqArm2;
        private static EditText iDanArm2;
        private static EditText iTraArm2;
        private static EditText strNomArm3;
        private static EditText iAtqArm3;
        private static EditText iDanArm3;
        private static EditText iTraArm3;

        //inventario
        private static EditText strObj1;
        private static EditText strObj2;
        private static EditText strObj3;
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = null;
            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    rootView = inflater.inflate(R.layout.fragment_vo_general, container, false);
                    imgVwVoPer = rootView.findViewById(R.id.imgVwVoPer);
                    strNombre =rootView.findViewById(R.id.edtTxtVoNom);
                    strClase  =rootView.findViewById(R.id.spVoClase);
                    strNivAqd =rootView.findViewById(R.id.spVoNivAdq);
                    iPx=rootView.findViewById(R.id.edtTxtVoPx);
                    iNivel=rootView.findViewById(R.id.spVoNivAdq);
                    strTransfondo=rootView.findViewById(R.id.edtTxtVoTrans);
                    strTalento1=rootView.findViewById(R.id.edtTxtVoTal1);
                    strTalento2=rootView.findViewById(R.id.edtTxtVoTal2);
                    isFem=rootView.findViewById(R.id.rdBtnVoFem); //género (puede que se necite el btnMas
                    isMas = rootView.findViewById(R.id.rdBtnVoMasc);
                    break;
                case 2:
                    rootView = inflater.inflate(R.layout.fragment_vo_rasgos, container, false);
                    //estadistica
                    iStdFue = rootView.findViewById(R.id.spFueStd);
                    iStdDes= rootView.findViewById(R.id.spDesStd);
                    iStdCon = rootView.findViewById(R.id.spConStd);
                    iStdInt = rootView.findViewById(R.id.spIntStd);
                    iStdSab = rootView.findViewById(R.id.spSabStd);
                    iStdCar = rootView.findViewById(R.id.spCarStd);

                    //modificador
                    iModFue = rootView.findViewById(R.id.spFueBon);
                    iModDes = rootView.findViewById(R.id.spFueBon);
                    iModCon = rootView.findViewById(R.id.spConBon);
                    iModInt = rootView.findViewById(R.id.spIntBon);
                    iModSab = rootView.findViewById(R.id.spSabBon);
                    iModCar = rootView.findViewById(R.id.spCarBon);

                    //habilidades
                    iAlerta = rootView.findViewById(R.id.edtAlerta);
                    iComunicacion = rootView.findViewById(R.id.edtComun);
                    iManipulacion = rootView.findViewById(R.id.edtManip);
                    iErudicion = rootView.findViewById(R.id.edtEru);
                    iSubterfugio = rootView.findViewById(R.id.edtSubt);
                    iSupervivencia = rootView.findViewById(R.id.edtSuperv);
                    //otros
                     iPvTot  = rootView.findViewById(R.id.edtPvTot);//14 - stdFue
                    iPvAct = rootView.findViewById(R.id.edtPvAct); // va cambiando máximo pvTot
                    iDef = rootView.findViewById(R.id.edtDef); //14 - stdDes
                    iAtq = rootView.findViewById(R.id.edtAtq); // 0 a 7
                    iInst = rootView.findViewById(R.id.edtIns);// 0 a 11

                    final Spinner spnDes = rootView.findViewById(R.id.spDesStd);
                    final TextView txtPvTot = rootView.findViewById(R.id.edtPvTot);
                    spnDes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            txtPvTot.setText(14-spnDes.getSelectedItemPosition()-3+"");
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                    break;
                case 3:
                    rootView = inflater.inflate(R.layout.fragment_vo_items, container, false);
                    //armas
                    strNomArm1 = rootView.findViewById(R.id.edtTxtArm1);
                    iAtqArm1 = rootView.findViewById(R.id.edtTxtAtq1);
                    iDanArm1 = rootView.findViewById(R.id.edtTxtDñ1);
                    iTraArm1 = rootView.findViewById(R.id.edtTxtTra1);

                    strNomArm2 = rootView.findViewById(R.id.edtTxtArm2);
                    iAtqArm2 = rootView.findViewById(R.id.edtTxtAtq2);
                    iDanArm2 = rootView.findViewById(R.id.edtTxtDñ2);
                    iTraArm2 = rootView.findViewById(R.id.edtTxtTra2);

                    strNomArm3 = rootView.findViewById(R.id.edtTxtArm3);
                    iAtqArm3 = rootView.findViewById(R.id.edtTxtAtq3);
                    iDanArm3 = rootView.findViewById(R.id.edtTxtDñ3);
                    iTraArm3 = rootView.findViewById(R.id.edtTxtTra3);
                    //inventario
                    strObj1 = rootView.findViewById(R.id.edtObj1);
                    strObj2 = rootView.findViewById(R.id.edtObj2);
                    strObj3 = rootView.findViewById(R.id.edtObj3);
                    break;
            }
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            //Muestra 3 páginas
            return 3;
        }
    }
}
