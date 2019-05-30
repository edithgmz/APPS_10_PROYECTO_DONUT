package edith.example.carnefresca;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;
import com.kosalgeek.android.photoutil.GalleryPhoto;
import com.kosalgeek.android.photoutil.ImageLoader;

import java.io.FileNotFoundException;

import edith.example.datos.BaseDatos;
import edith.example.roltastico.Dado;
import edith.example.roltastico.R;

import static edith.example.carnefresca.CfGeneral.OnFragmentInteractionListener;

public class CarneFresca extends AppCompatActivity implements OnFragmentInteractionListener {

    private FloatingActionMenu menuFlo;
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
    //
    private GalleryPhoto gpGaleria;
    private static Bitmap bCFImagen;
    //general
    private static ImageView imgVwCfPer;
    //
    private BaseDatos baseDatos;
    private static EditText edtTxtCfNom, edtTxtCfRasFis;
    private static RadioButton rdBtnCfFem, rdBtnCfMasc;
    //rasgos
    private static Spinner spCfBasDa, spCfPelDes, spCfPelArm, spCfRes, spCfCond, spCfPunt, spCfSigi, spCfArram, spCfManit,
            spCfPrAux, spCfOcEnc, spCfInti, spCfConv, spCfAten, spCfOrie;
    //cuerpo
    private static Spinner spCfCabeza, spCfTorso, spCfBrIzq, spCfBrDer, spCfPiernas;
    //salud
    private static SeekBar sBarDanio, sBarTen;
    private String sRutaImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carne_fresca);

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

        menuFlo =  findViewById(R.id.menuCF);
        menuFlo.setClosedOnTouchOutside(true);

        baseDatos = new BaseDatos(this);
        //
        gpGaleria = new GalleryPhoto(this);
    }


    public void selecCfImagen(View v) {
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
                    bCFImagen = ImageLoader.init().from(sRutaImagen).getBitmap();
                    imgVwCfPer.setImageBitmap(bCFImagen);
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
        getMenuInflater().inflate(R.menu.menu_carne_fresca, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        int isfem;

        //noinspection SimplifiableIfStatement
        if (id == R.id.acCfGuardar) {
            if (rdBtnCfFem.isChecked())
                isfem = 1;
            else
                isfem = 0;
            baseDatos.insertarCF(sRutaImagen, edtTxtCfNom.getText().toString(), edtTxtCfRasFis.getText().toString(), isfem,
                    spCfCabeza.getSelectedItem().toString(), spCfBrDer.getSelectedItem().toString(), spCfBrIzq.getSelectedItem().toString(),
                    spCfTorso.getSelectedItem().toString(), spCfPiernas.getSelectedItem().toString(), Integer.parseInt(spCfBasDa.getSelectedItem().toString()),
                    Integer.parseInt(spCfPelDes.getSelectedItem().toString()), Integer.parseInt(spCfPelArm.getSelectedItem().toString()),
                    Integer.parseInt(spCfRes.getSelectedItem().toString()), Integer.parseInt(spCfCond.getSelectedItem().toString()),
                    Integer.parseInt(spCfPunt.getSelectedItem().toString()), Integer.parseInt(spCfSigi.getSelectedItem().toString()),
                    Integer.parseInt(spCfManit.getSelectedItem().toString()), Integer.parseInt(spCfArram.getSelectedItem().toString()),
                    Integer.parseInt(spCfOcEnc.getSelectedItem().toString()), Integer.parseInt(spCfPrAux.getSelectedItem().toString()),
                    Integer.parseInt(spCfInti.getSelectedItem().toString()), Integer.parseInt(spCfConv.getSelectedItem().toString()),
                    Integer.parseInt(spCfAten.getSelectedItem().toString()),
                    Integer.parseInt(spCfOrie.getSelectedItem().toString()), sBarDanio.getProgress(), sBarTen.getProgress());
            Toast.makeText(this, "Guardado.", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.acCfEliminar) {
            baseDatos.eliminarCF(edtTxtCfNom.getText().toString(), edtTxtCfRasFis.getText().toString());
            Toast.makeText(this, "Eliminado.", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {
        Dado d6 =new Dado(6);
        int t1=d6.roll();
        int t2=d6.roll();
        String str="error",res="fracaso";

        switch (v.getId()) {
            case R.id.facil:
                str="["+t1+","+t2+"]";
                if (t1>3||t2>3)
                        res="exito";
                break;
            case R.id.medio:
                str="["+t1+"]";
                if (t1>3)
                    res="exito";
                break;
            case R.id.dificil:
                str="["+t1+","+t2+"]";
                if (t1>3&&t2>3)
                    res="exito";
                break;
            case R.id.mDificil:
                int t3=d6.roll();
                str="["+t1+","+t2+","+t3+"]";
                if (t1>3&&t2>3&&t3>3)
                    res="exito";
                break;
        }
        str+=res;
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

    @Override
    public Bitmap getCfImagen() {
        return bCFImagen;
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
                    rootView = inflater.inflate(R.layout.fragment_cf_general, container, false);
                    imgVwCfPer = rootView.findViewById(R.id.imgVwCfPer);
                    edtTxtCfNom = rootView.findViewById(R.id.edtTxtCfNom);
                    edtTxtCfRasFis = rootView.findViewById(R.id.edtTxtCfRasFis);
                    rdBtnCfFem = rootView.findViewById(R.id.rdBtnCfFem);
                    rdBtnCfMasc = rootView.findViewById(R.id.rdBtnCfMasc);
                    break;
                case 2:
                    rootView = inflater.inflate(R.layout.fragment_cf_rasgos, container, false);
                    spCfBasDa = rootView.findViewById(R.id.spCfBasDa);
                    spCfPelDes = rootView.findViewById(R.id.spCfPelDes);
                    spCfPelArm = rootView.findViewById(R.id.spCfPelArm);
                    spCfRes = rootView.findViewById(R.id.spCfRes);
                    spCfCond = rootView.findViewById(R.id.spCfCond);
                    spCfPunt = rootView.findViewById(R.id.spCfPunt);
                    spCfSigi = rootView.findViewById(R.id.spCfSigi);
                    spCfArram = rootView.findViewById(R.id.spCfArram);
                    spCfManit = rootView.findViewById(R.id.spCfManit);
                    spCfPrAux = rootView.findViewById(R.id.spCfPrAux);
                    spCfOcEnc = rootView.findViewById(R.id.spCfOcEnc);
                    spCfInti = rootView.findViewById(R.id.spCfInti);
                    spCfConv = rootView.findViewById(R.id.spCfConv);
                    spCfAten = rootView.findViewById(R.id.spCfAten);
                    spCfOrie = rootView.findViewById(R.id.spCfOrie);
                    break;
                case 3:
                    rootView = inflater.inflate(R.layout.fragment_cf_cuerpo, container, false);
                    spCfCabeza = rootView.findViewById(R.id.spCfCabeza);
                    spCfTorso = rootView.findViewById(R.id.spCfTorso);
                    spCfBrIzq = rootView.findViewById(R.id.spCfBrIzq);
                    spCfBrDer = rootView.findViewById(R.id.spCfBrDer);
                    spCfPiernas = rootView.findViewById(R.id.spCfPiernas);
                    break;
                case 4:
                    rootView = inflater.inflate(R.layout.fragment_cf_salud, container, false);
                    sBarDanio = rootView.findViewById(R.id.sBarDanio);
                    sBarTen = rootView.findViewById(R.id.sBarTen);
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
