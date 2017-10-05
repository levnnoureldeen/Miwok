package com.example.noureldeen.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by noureldeen on 7/17/2017.
 */

public class colorsAdapter extends ArrayAdapter<colors> {
    int backgroundColorID = 0;
    public colorsAdapter(@NonNull Activity context, @NonNull ArrayList<colors> colorsArrayList,@NonNull int backgroundColorID ) {
        super(context, 0 ,colorsArrayList);
        this.backgroundColorID = backgroundColorID;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        colors currentColor = getItem(position);
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.icon_image);
        imageView.setImageResource(currentColor.getImageResourceID());
        TextView miwokNumer = (TextView) listItemView.findViewById(R.id.miwok_textview);
        miwokNumer.setText(currentColor.getMiwokWord());
        TextView englishNumer = (TextView) listItemView.findViewById(R.id.english_textview);
        englishNumer.setText(currentColor.getEnglishWord());
        LinearLayout textLinearLayout = (LinearLayout) listItemView.findViewById(R.id.texts_linear_layout);
        textLinearLayout.setBackgroundColor(ContextCompat.getColor(getContext(),backgroundColorID));
        return listItemView;
    }
}
