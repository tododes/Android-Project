package com.example.gx60.semiproject;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by GX60 on 14/03/2017.
 */

public class SwipeAdapter extends PagerAdapter
{
    private int[] Resources = { R.drawable.abandoned_church,
                                R.drawable.dragon_castle,
                                R.drawable.demon_dome};
    private String[] PlaceNames = { "Abandoned church", "Dragon Castle", "Demon Dome" };

    private View view;
    private Context context;
    private LayoutInflater layoutInflater;
    private ImageView imageView;
    private TextView textView;

    public SwipeAdapter(Context c)
    {
        context = c;
    }

    public SwipeAdapter(Context c, int[] rs)
    {
        context = c;
        Resources = rs;
    }

    public void setResources(int[] i)
    {
        Resources = i;
    }

    @Override
    public int getCount() {
        return Resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.swipe_layout, container, false);

        textView = (TextView) view.findViewById(R.id.swipe_text);
        imageView = (ImageView) view.findViewById(R.id.swipe_image);


        System.out.println("Position : " + position);
        if(position < Resources.length && position >= 0)
        {
            imageView.setImageResource(Resources[position]);
            textView.setText(PlaceNames[position]);
        }


        container.addView(view);
        return view;
        //return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
