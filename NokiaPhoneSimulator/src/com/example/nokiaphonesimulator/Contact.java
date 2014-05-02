package com.example.nokiaphonesimulator;

import android.os.Parcel;
import android.os.Parcelable;

// class representing a single contact
public class Contact implements Parcelable
{
    // member
    private String id;
    private String given_name;
    private String family_name;
    private String phone_number;

    // constructor
    public Contact(String id, String given_name, String family_name, String phone_number)
    {
        this.id = id;
        this.given_name = given_name;
        this.family_name = family_name;
        this.phone_number = phone_number;
    }

    // constructor that takes a Parcel and gives you an object populated with it's values
    private Contact(Parcel in)
    {
        this.id = in.readString();
        this.given_name = in.readString();
        this.family_name = in.readString();
        this.phone_number = in.readString();
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
        out.writeString(given_name);
        out.writeString(family_name);
        out.writeString(phone_number);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>()
    {
        public Contact createFromParcel(Parcel in)
        {
            return new Contact(in);
        }

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

    public String getGivenName()
    {
        return given_name;
    }

    public String getFamilyName()
    {
        return family_name;
    }

    public String getPhoneNumber()
    {
        return phone_number;
    }

}
