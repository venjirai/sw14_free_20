package com.example.nokiaphonesimulator;

import android.os.Parcel;
import android.os.Parcelable;

// class representing a single contact
public class Contact implements Parcelable
{
    // member
    private String id;
    private String name;
    private String number;

    // constructor
    public Contact(String id, String name, String number)
    {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    // constructor that takes a Parcel and gives you an object populated with it's values
    private Contact(Parcel in)
    {
        this.id = in.readString();
        this.name = in.readString();
        this.number = in.readString();
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags)
    {
        out.writeString(id);
        out.writeString(name);
        out.writeString(number);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>()
    {
        @Override
        public Contact createFromParcel(Parcel in)
        {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size)
        {
            return new Contact[size];
        }
    };
    
    // getter
    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getNumber()
    {
        return number;
    }

}
