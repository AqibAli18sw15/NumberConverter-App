package com.example.numberconverterpluscalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    SharedPreferences shrd;
    SharedPreferences.Editor editor;
    private TabLayout tLayOut;
    private TabItem ti1,ti2,ti3;
    private ViewPager vpager;
    private PageAdapter pa;
    View v;
    View insertField,spin1,spin2,conv,explan;
    View fr2spi2,fr2spi1,fr2field1,fr2field2,fr2spi3,add,mul,sub,div;
    TextView res,fr2resSelector,fr2res,fr3Label;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tLayOut = findViewById(R.id.tabLayout);

        ti1 = findViewById(R.id.tab1);
        ti2 = findViewById(R.id.tab2);
        ti3 = findViewById(R.id.tab3);

        vpager = findViewById(R.id.vpager);



        pa= new PageAdapter(getSupportFragmentManager(), tLayOut.getTabCount());
        vpager.setAdapter(pa);
        tLayOut.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2)
                    pa.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });//end of tablayout listener
        vpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tLayOut));
    }//end of oncreate

}