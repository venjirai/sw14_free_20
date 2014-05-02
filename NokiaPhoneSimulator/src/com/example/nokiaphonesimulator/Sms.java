package com.example.nokiaphonesimulator;

import android.os.Parcel;
import android.os.Parcelable;

public class Sms implements Parcelable
{
    private String id;
    private String address;
    private String person;
    private String date;
    private String read;
    private String body;

    public Sms(String id, String address, String person, String date, String read, String body)
    {
        this.id = id;
        this.address = address;
        this.person = person;
        this.date = date;
        this.read = read;
        this.body = body;
    }

    // constructor that takes a Parcel and gives you an object populated with it's values
    private Sms(Parcel in)
    {
        this.id = in.readString();
        this.address = in.readString();
        this.person = in.readString();
        this.date = in.readString();
        this.read = in.readString();
        this.body = in.readString();
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
        out.writeString(address);
        out.writeString(person);
        out.writeString(date);
        out.writeString(read);
        out.writeString(body);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Sms> CREATOR = new Parcelable.Creator<Sms>()
    {
        public Sms createFromParcel(Parcel in)
        {
            return new Sms(in);
        }

        public Sms[] newArray(int size)
        {
            return new Sms[size];
        }
    };

    public String getId()
    {
        return id;
    }

    public String getAddress()
    {
        return address;
    }

    public String getPerson()
    {
        return person;
    }

    public String getDate()
    {
        return date;
    }

    public String getRead()
    {
        return read;
    }

    public String getBody()
    {
        return body;
    }
}
