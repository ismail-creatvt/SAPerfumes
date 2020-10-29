package com.saperfumes.account.savedaddress;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class AddEditSavedAddressViewModel extends AndroidViewModel {

    private AddEditSavedAddressListener listener;

    public void setAddEditSavedAddressListener(AddEditSavedAddressListener listener) {
        this.listener = listener;
    }

    public AddEditSavedAddressViewModel(@NonNull Application application) {
        super(application);
    }

    public void onDoneClick(){
        if(listener != null){
            listener.onDoneClick();
        }
    }

    public interface AddEditSavedAddressListener{
        void onDoneClick();
    }

}
