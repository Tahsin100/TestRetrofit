package com.tahsin.testretrofit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tahsin.testretrofit.R;
import com.tahsin.testretrofit.models.Notice;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder>{

    private Context c;
    private AdapterCallback adapterCallBack;
    private ArrayList<Notice> notices;
    public NoticeAdapter(Context context, ArrayList<Notice> noticeList) {
        this.c = context;
        this.notices = noticeList;

        try {

            this.adapterCallBack = ((AdapterCallback) context);

        } catch (ClassCastException e) {

            throw new ClassCastException("Activity must implement AdapterCallback.");

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_recyclerview_layout, parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.appCompatTextViewTitle.setText(notices.get(position).getTitle());
        holder.appCompatTextViewBrief.setText(notices.get(position).getBrief());
        holder.appCompatTextViewLink.setText(notices.get(position).getFilesource());

    }


    @Override
    public int getItemCount() {
        return notices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        AppCompatTextView appCompatTextViewTitle, appCompatTextViewBrief, appCompatTextViewLink;
        AppCompatEditText appCompatEditTextNumber;

        public ViewHolder(View itemView) {
            super(itemView);
            appCompatTextViewTitle = itemView.findViewById(R.id.appCompatTextViewTitle);
            appCompatTextViewBrief = itemView.findViewById(R.id.appCompatTextViewBrief);
            appCompatTextViewLink = itemView.findViewById(R.id.appCompatTextViewLink);
            appCompatEditTextNumber = itemView.findViewById(R.id.appCompatEditTextNumber);


            appCompatEditTextNumber.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    try{
                        int position = getAdapterPosition();
                        adapterCallBack.onMethodCallback(position, Integer.parseInt(appCompatEditTextNumber.getText().toString()));
                    }catch (ClassCastException ex){

                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }


    }

    public interface AdapterCallback{
        void onMethodCallback(int position, int value);
    }
}
