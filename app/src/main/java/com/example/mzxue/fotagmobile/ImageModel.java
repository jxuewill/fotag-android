package com.example.mzxue.fotagmobile;

import android.os.Parcel;
import android.os.Parcelable;

public class ImageModel implements Parcelable{
    public int rating = 5;
    public String filename;

    public ImageModel(String f){
        filename = f;
    }
    public ImageModel(Parcel parcel){
        rating = parcel.readInt();
        filename = parcel.readString();

    }
    public void setrating(int r){
        rating = r;
    }

    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(rating);
        parcel.writeString(filename);
    }

    public static final Creator<ImageModel> CREATOR = new Creator<ImageModel>(){
        @Override
        public ImageModel[] newArray(int i) {
            return new ImageModel[i];
        }

        @Override
        public ImageModel createFromParcel(Parcel parcel) {
            return new ImageModel(parcel);
        }
    };
}
