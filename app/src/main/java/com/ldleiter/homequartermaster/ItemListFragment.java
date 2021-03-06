package com.ldleiter.homequartermaster;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ItemListFragment extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_item_list, container, false);
        container.removeAllViews();
        View.OnClickListener onClickListener = itemView ->
        {
            int selectedItemId = (int) itemView.getTag();
            Bundle args = new Bundle();
            args.putInt(ItemDescriptionFragment.ARG_ITEM_ID, selectedItemId);

            Navigation.findNavController(itemView).navigate(R.id.show_item_detail, args);
        };

        RecyclerView recyclerView = rootView.findViewById(R.id.item_list);
        List<ItemTable> items = ItemRepository.getInstance(requireContext()).getItems();
        recyclerView.setAdapter(new ItemAdapter(items, onClickListener));

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        Log.d("FragmentOnViewCreated", "Function ran");
        View btn = view.findViewById(R.id.addButton);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Fragment newItemFragment = new NewItemFragment();
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.item_list_container, newItemFragment ); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
            }

        });

    }

    private class ItemAdapter extends RecyclerView.Adapter<ItemHolder>
    {
        private final List<ItemTable> mItems;
        private final View.OnClickListener mOnClickListener;

        public ItemAdapter(List<ItemTable> items, View.OnClickListener onClickListener)
        {
            mItems = items;
            mOnClickListener = onClickListener;
        }

        @NonNull
        @Override
        public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position)
        {
            ItemTable item = mItems.get(position);
            holder.bind(item);
            holder.itemView.setTag(item.getId());
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount()
        {
            return mItems.size();
        }
    }

    private static class ItemHolder extends RecyclerView.ViewHolder
    {
        private final TextView mNameTextView;

        public ItemHolder(LayoutInflater inflater, ViewGroup parent)
        {
            super(inflater.inflate(R.layout.list_item, parent, false));
            mNameTextView = itemView.findViewById(R.id.item_name);
        }

        public void bind(ItemTable item)
        {
            mNameTextView.setText(item.getName());
        }
    }
}