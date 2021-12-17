package com.ldleiter.homequartermaster;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewItemFragment extends Fragment
{
    private EditText itemName;
    private EditText itemDescription;

    public NewItemFragment()
    {
        // Required empty public constructor
    }

    public static NewItemFragment newInstance()
    {
        NewItemFragment fragment = new NewItemFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        container.removeAllViews();
        return inflater.inflate(R.layout.fragment_new_item, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        Log.d("FragmentOnViewCreated", "Function ran");
        View btn = view.findViewById(R.id.createNewItemButton);
        itemName = view.findViewById(R.id.textInputEnterItemName);
        itemDescription = view.findViewById(R.id.textInputEnterItemDescription);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {


                int itemId = 0;
                String itemNameString = itemName.getText().toString();
                String itemDescriptionString = itemDescription.getText().toString();

                ItemTable newItem = new ItemTable(itemId, itemNameString, itemDescriptionString);

                //QuartermasterDatabase qmDb = QuartermasterDatabase.getInstance(getActivity().getApplicationContext());

                ItemRepository.getInstance(requireContext()).insertItem(newItem);
                Log.d("Database Operation", "Item being inserted into the table");

                Fragment listItemFragment = new ItemListFragment();
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.new_item_fragment_container, listItemFragment ); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
            }

        });

    }
}