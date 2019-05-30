package edith.example.rwby;

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

import java.io.FileNotFoundException;

import edith.example.datos.BaseDatos;
import edith.example.datos.RWDatos;
import edith.example.roltastico.Dado;
import edith.example.roltastico.R;

public class Rwby extends AppCompatActivity {
    FloatingActionMenu menuFlo;
    RWDatos rwDatos;

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
    private static Bitmap bRWImagen;
    //general
    private static ImageView imgVwRwPer;
    private static EditText edtTxtRwNom, edtTxtRwOjos, edtTxtRwCabe, edtTxtRwArma;
    private static RadioButton rdBtnRwFem, rdBtnRwMasc, rdBtnHuma, rdBtnFau;
    //rasgos
    private static Spinner spMel, spnRan, spnStr, spnEnd, spnPer, spnDis, spnAgi, spnWil;
    private static TextView txtMel, txtRan, txtSal, txtAu, txtCap;
    private static EditText edtTxtRwSal, edtTxtRwAur, edtTxtRwCap;
    //dust
    private static RadioButton rdBtnBlack, rdBtnBrown, rdBtnRed, rdBtnOrange, rdBtnYellow, rdBtnGreen,
            rdBtnBlue, rdBtnViolet, rdBtnPink, rdBtnWhite;
    //ventaja
    private static EditText edtTxtSem, edtTxtRwMod1, edtTxtRwMod2, edtTxtRwMod3, edtTxtRwMod4, edtTxtRwMod5;
    //
    private GalleryPhoto gpGaleria;
    private String sRutaImagen;
    //
    private BaseDatos baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rwby);

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


        menuFlo =  findViewById(R.id.menuRw);
        menuFlo.setClosedOnTouchOutside(true);

        baseDatos = new BaseDatos(getApplicationContext());
        //
        gpGaleria = new GalleryPhoto(getApplicationContext());
    }

    public void selecRwImagen(View v) {
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
                    bRWImagen = ImageLoader.init().from(sRutaImagen).getBitmap();
                    imgVwRwPer.setImageBitmap(bRWImagen);
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
        getMenuInflater().inflate(R.menu.menu_rwby, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        int isfem, ishum;
        String dust1 = "";
        String dust2 = "";

        //noinspection SimplifiableIfStatement
        if (id == R.id.acRwGuardar) {
            if (rdBtnRwFem.isChecked())
                isfem = 1;
            else
                isfem = 0;
            if (rdBtnHuma.isChecked())
                ishum = 1;
            else
                ishum = 0;
            if (rdBtnBlack.isChecked())
                dust1 = "Negro";
            else if (rdBtnBrown.isChecked())
                dust1 = "Café";
            else if (rdBtnRed.isChecked())
                dust1 = "Rojo";
            else if (rdBtnOrange.isChecked())
                dust1 = "Naranja";
            else if (rdBtnYellow.isChecked())
                dust1 = "Amarillo";
            if (rdBtnGreen.isChecked())
                dust1 = "Verde";
            else if (rdBtnBlue.isChecked())
                dust1 = "Azul";
            else if (rdBtnViolet.isChecked())
                dust1 = "Morado";
            else if (rdBtnPink.isChecked())
                dust1 = "Rosa";
            else if (rdBtnWhite.isChecked())
                dust1 = "Blanco";
            baseDatos.insertarRW(sRutaImagen, edtTxtRwNom.getText().toString(), isfem, ishum, edtTxtRwCabe.getText().toString(), edtTxtRwOjos.getText().toString(), edtTxtRwArma.getText().toString(),
                    3, 2, 2, 1, 3, 1, 100, 5, 3, 2, 1, dust1,
                    dust2, edtTxtSem.getText().toString(), edtTxtRwMod1.getText().toString() + "," + edtTxtRwMod2.getText().toString() + "," + edtTxtRwMod3.getText().toString() + "," + edtTxtRwMod4.getText().toString() + "," + edtTxtRwMod5.getText().toString());
            Toast.makeText(this, "Guardado.", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.acRwEliminar) {
            baseDatos.eliminarCF(edtTxtRwNom.getText().toString(), edtTxtRwCabe.getText().toString());
            Toast.makeText(this, "Eliminado.", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        Dado d;
        int t1,t2;
        String str="error";
        switch (view.getId()) {
            case R.id.double10:
                d = new Dado(10);
                t1 = d.roll();
                t2 = d.roll();
                str="["+t1+","+t2+"]= "+(t1+t2);
                break;
            case R.id.d4:
                d = new Dado(4);
                t1 = d.roll();
                str="["+t1+"]";
                break;
        }
        Toast.makeText(this, str ,Toast.LENGTH_SHORT).show();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private AdapterView.OnItemSelectedListener mele;

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
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = null;
            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1://general
                    rootView = inflater.inflate(R.layout.fragment_rw_general, container, false);
                    imgVwRwPer = rootView.findViewById(R.id.imgVwRwPer);
                    edtTxtRwNom = rootView.findViewById(R.id.edtTxtRwNom);
                    edtTxtRwOjos = rootView.findViewById(R.id.edtTxtRwOjos);
                    edtTxtRwCabe = rootView.findViewById(R.id.edtTxtRwCabe);
                    edtTxtRwArma = rootView.findViewById(R.id.edtTxtRwArma);
                    rdBtnRwFem = rootView.findViewById(R.id.rdBtnRwFem);
                    rdBtnRwMasc = rootView.findViewById(R.id.rdBtnRwMasc);
                    rdBtnHuma = rootView.findViewById(R.id.rdBtnHuma);
                    rdBtnFau = rootView.findViewById(R.id.rdBtnFau);
                    break;
                case 2:
                    rootView = inflater.inflate(R.layout.fragment_rw_rasgos, container, false);
                    spMel = rootView.findViewById(R.id.spMelee);
                    txtMel = rootView.findViewById(R.id.txtRwMel);
                    txtRan = rootView.findViewById(R.id.txtRwRan);
                    spnStr = rootView.findViewById(R.id.spRwFue);
                    spnEnd = rootView.findViewById(R.id.spRwRes);
                    spnPer = rootView.findViewById(R.id.spRwPer);
                    spnDis = rootView.findViewById(R.id.spRwDis);
                    spnAgi = rootView.findViewById(R.id.spRwAgi);
                    spnRan = rootView.findViewById(R.id.spRanged);
                    spnWil = rootView.findViewById(R.id.spRwVol);
                    edtTxtRwSal = rootView.findViewById(R.id.edtTxtRwSal);
                    edtTxtRwAur = rootView.findViewById(R.id.edtTxtRwAur);
                    edtTxtRwCap = rootView.findViewById(R.id.edtTxtRwCap);
                    //resistencia genera campos
                    txtSal = rootView.findViewById(R.id.txtRwSalMax);
                    spnEnd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            txtSal.setText(position+1+"");
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                    //per genera aura

                    txtAu = rootView.findViewById(R.id.txtRwAurMax);
                    spnPer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            txtAu.setText(position+10+"");
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                    txtCap = rootView.findViewById(R.id.txtRwCapMax);
                    spnDis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            txtCap.setText(position+1+"");
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                    mele = new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            int res = -1;
                            switch (position) {
                                case 0:
                                    res = spnStr.getSelectedItemPosition() + spnEnd.getSelectedItemPosition();
                                    break;
                                case 1:
                                    res = spnStr.getSelectedItemPosition() + spnAgi.getSelectedItemPosition();
                                    break;
                                case 2:
                                    res = spnStr.getSelectedItemPosition() + spnDis.getSelectedItemPosition();
                                    break;
                            }
                            txtMel.setText(res + "");
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    };
                    spMel.setOnItemSelectedListener(mele);

                    spnRan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            int res =-1;
                            switch (position){
                                case 0:
                                    res = spnStr.getSelectedItemPosition()+spnEnd.getSelectedItemPosition();
                                    break;
                                case 1:
                                    res = spnStr.getSelectedItemPosition()+spnWil.getSelectedItemPosition();
                                    break;
                                case 2:
                                    res = spnStr.getSelectedItemPosition()+spnDis.getSelectedItemPosition();
                                    break;
                            }
                            txtRan.setText(res+"");
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


                    break;
                case 3:
                    rootView = inflater.inflate(R.layout.fragment_rw_dust, container, false);
                    rdBtnBlack = rootView.findViewById(R.id.rdBtnBlack);
                    rdBtnBrown = rootView.findViewById(R.id.rdBtnBrown);
                    rdBtnRed = rootView.findViewById(R.id.rdBtnRed);
                    rdBtnOrange = rootView.findViewById(R.id.rdBtnOrange);
                    rdBtnYellow = rootView.findViewById(R.id.rdBtnYellow);
                    rdBtnGreen = rootView.findViewById(R.id.rdBtnGreen);
                    rdBtnBlue = rootView.findViewById(R.id.rdBtnBlue);
                    rdBtnViolet = rootView.findViewById(R.id.rdBtnViolet);
                    rdBtnPink = rootView.findViewById(R.id.rdBtnPink);
                    rdBtnWhite = rootView.findViewById(R.id.rdBtnWhite);
                    break;
                case 4:
                    rootView = inflater.inflate(R.layout.fragment_rw_ventaja, container, false);
                    edtTxtSem = rootView.findViewById(R.id.edtTxtSem);
                    edtTxtRwMod1 = rootView.findViewById(R.id.edtTxtRwMod1);
                    edtTxtRwMod2 = rootView.findViewById(R.id.edtTxtRwMod2);
                    edtTxtRwMod3 = rootView.findViewById(R.id.edtTxtRwMod3);
                    edtTxtRwMod4 = rootView.findViewById(R.id.edtTxtRwMod4);
                    edtTxtRwMod5 = rootView.findViewById(R.id.edtTxtRwMod5);
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
            //Muestra 4 páginas
            return 4;
        }
    }
}
