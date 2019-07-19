package com.example.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    ArrayList<Hinh> hinhArrayList;
    int soluong;
    int current = 0;
    final Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Khoitao();
        Xuly();
    }
    private void Khoitao()
    {
        hinhArrayList = new ArrayList<>();
        hinhArrayList.add(new Hinh(R.drawable.a1));
        hinhArrayList.add(new Hinh(R.drawable.a2));
        hinhArrayList.add(new Hinh(R.drawable.a3));
        hinhArrayList.add(new Hinh(R.drawable.a4));
        hinhArrayList.add(new Hinh(R.drawable.a5));
        hinhArrayList.add(new Hinh(R.drawable.a6));
        hinhArrayList.add(new Hinh(R.drawable.a7));
        hinhArrayList.add(new Hinh(R.drawable.a8));
        hinhArrayList.add(new Hinh(R.drawable.a9));
    }
    private void Xuly()
    {
       viewPager = (ViewPager) findViewById(R.id.pager);
       HinhAdapter adapter = new HinhAdapter(hinhArrayList, this);
       viewPager.setAdapter(adapter);
       soluong = hinhArrayList.size();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (current++ >= soluong) current = 0;
                viewPager.setCurrentItem(current, true);
                handler.postDelayed(this, 1000);
            }
        }, 1000);

    }



}
