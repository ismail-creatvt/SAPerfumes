package com.saperfumes.account.savedaddress;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class SavedAddressViewModel extends AndroidViewModel {

    private SavedAddressListener listener;

    public void setSavedAddressListener(SavedAddressListener listener) {
        this.listener = listener;
    }

    public SavedAddressViewModel(@NonNull Application application) {
        super(application);
    }

    public void onEditClick(String id) {
        if(listener != null){
            listener.onEditClick(id);
        }
    }

    public void onRemoveClick(String id) {
        if(listener != null){
            listener.onRemoveClick(id);
        }
    }

    public void onAddNewClick(){
        if(listener != null){
            listener.onAddNewClick();
        }
    }

    public void onAddressClick(String id) {
        if(listener != null){
            listener.onAddressClick(id);
        }
    }

    public interface SavedAddressListener{
        void onEditClick(String id);
        void onRemoveClick(String id);
        void onAddNewClick();
        void onAddressClick(String id);
    }
}
