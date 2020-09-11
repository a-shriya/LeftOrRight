package com.example.leftorright.modals;

import android.graphics.drawable.Drawable;

import com.example.leftorright.R;

import java.util.Random;

public class LeftOrRightExpert
{

    final private int[] images =
            new int[]{
                    R.drawable.gryffindor_badge_transparent,
                    R.drawable.hufflepuff_crest_transparent,
                    R.drawable.ravenclaw_house_crest_transparent,
                    R.drawable.slytherin_house_crest_transparent
            };


    final private String[] houseDescriptions =
            {
                    "Gryffindor values bravery, daring, nerve, and chivalry. Its emblematic animal is the lion and its colours are scarlet and gold.",
                    "Ravenclaw values intelligence, knowledge, curiosity, creativity and wit. Its emblematic animal is the eagle, and its colours are blue and bronze.",
                    "Hufflepuff values hard work, dedication, patience, loyalty, and fair play. Its emblematic animal is the badger, and Yellow and Black are its colours.",
                    "Slytherin House values ambition, leadership, self-preservation, cunning and resourcefulness and was founded by Salazar Slytherin."
            };

    int index;

    public void setIndex()
    {
        Random random  = new Random();
        index = Math.abs(random.nextInt() % 4);
    }

    public int getIndex()
    {
        return index;
    }

    public int nextHouse()
    {
        return images[getIndex()];
    }

    public String nextDescription(int index)
    {
        return houseDescriptions[getIndex()];
    }

}
