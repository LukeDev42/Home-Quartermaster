package com.ldleiter.homequartermaster;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ItemDescriptionFragment extends Fragment
{
    public static final String ARG_ITEM_ID = "item_id";

    private Item item;

    public ItemDescriptionFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        int bandId = 1;

        Bundle args = getArguments();
        if (args != null)
        {
            bandId = args.getInt(ARG_ITEM_ID);
        }

        // Get the selected band
        item = ItemRepository.getInstance(requireContext()).getItem(bandId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_item_description, container, false);

        if (item != null)
        {
            TextView nameTextView = rootView.findViewById(R.id.itemName);
            nameTextView.setText(item.getName());

            TextView descriptionTextView = rootView.findViewById(R.id.item_description);
            descriptionTextView.setText(item.getDescription());
        }

        return rootView;
    }
}