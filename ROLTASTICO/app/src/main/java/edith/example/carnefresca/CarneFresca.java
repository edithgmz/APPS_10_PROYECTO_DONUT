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
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;
import com.kosalgeek.android.photoutil.GalleryPhoto;
import com.kosalgeek.android.photoutil.ImageLoader;

import java.io.FileNotFoundException;

import edith.example.datos.BaseDatos;
import edith.example.roltastico.Dado;
import edith.example.roltastico.R;

public class CarneFresca extends AppCompatActivity {

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
    //
    private BaseDatos baseDatos;

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

        /*
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        baseDatos = new BaseDatos(getApplicationContext());
        //
        gpGaleria = new GalleryPhoto(getApplicationContext());
    }


    public void selecImagen(View v) {
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
                String sRutaImagen = gpGaleria.getPath();
                try {
                    Bitmap bImagen = ImageLoader.init().from(sRutaImagen).getBitmap();
                    //imgVwCfPer.setImageBitmap(bImagen);
                    Toast.makeText(getApplicationContext(), sRutaImagen + "\n\n" + uriImagen, Toast.LENGTH_LONG).show();
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.acCfGuardar) {

            Toast.makeText(this, "Guardado.", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.acCfEliminar) {
            Toast.makeText(this, "Eliminar.", Toast.LENGTH_SHORT).show();
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
                    break;
                case 2:
                    rootView = inflater.inflate(R.layout.fragment_cf_rasgos, container, false);
                    break;
                case 3:
                    rootView = inflater.inflate(R.layout.fragment_cf_cuerpo, container, false);
                    break;
                case 4:
                    rootView = inflater.inflate(R.layout.fragment_cf_salud, container, false);
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
