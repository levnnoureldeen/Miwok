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

public class phrasesAdapter extends ArrayAdapter<phrases> {
    int backgroundColorID = 0;
    public phrasesAdapter(@NonNull Activity context, @NonNull ArrayList<phrases> phrasesArrayList , int backgroundColorID) {
        super(context, 0, phrasesArrayList);
        this.backgroundColorID = backgroundColorID;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        phrases currentphrase = getItem(position);
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        TextView miwokNumer = (TextView) listItemView.findViewById(R.id.miwok_textview);
        miwokNumer.setText(currentphrase.getMiwokWord());
        TextView englishNumer = (TextView) listItemView.findViewById(R.id.english_textview);
        englishNumer.setText(currentphrase.getEnglishWord());
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.icon_image);
        if(currentphrase.hasImage()) {
            imageView.setImageResource(currentphrase.getImageResourceID());
        }else {
            imageView.setVisibility(View.GONE);
        }
        LinearLayout textLinearLayout = (LinearLayout) listItemView.findViewById(R.id.texts_linear_layout);
        textLinearLayout.setBackgroundColor(ContextCompat.getColor(getContext(),backgroundColorID));

        return listItemView;
    }
}
