package Model;

import java.io.Serializable;

/**
 * Created by anujshah on 7/20/16.
 */

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Hospital implements Comparable<Hospital>, Serializable
{
    private StringProperty name;
    private StringProperty streetAddress;
    private StringProperty city;
    private StringProperty state;
    private StringProperty zip;
    private StringProperty latitude;
    private StringProperty longitude;
    private StringProperty phoneNo;
    private StringProperty photo;

    public Hospital()
    {
        this.name = new SimpleStringProperty("");
        this.streetAddress = new SimpleStringProperty("");
        this.city = new SimpleStringProperty("");
        this.state = new SimpleStringProperty("");
        this.zip = new SimpleStringProperty("");
        this.latitude = new SimpleStringProperty("");
        this.longitude = new SimpleStringProperty("");
        this.phoneNo = new SimpleStringProperty("");
        this.photo = new SimpleStringProperty("");
    }

    public Hospital(String latitude, String longitude)
    {
        this.name = new SimpleStringProperty("");
        this.streetAddress = new SimpleStringProperty("");
        this.city = new SimpleStringProperty("");
        this.state = new SimpleStringProperty("");
        this.zip = new SimpleStringProperty("");
        this.latitude = new SimpleStringProperty(latitude);
        this.longitude = new SimpleStringProperty(longitude);
        this.phoneNo = new SimpleStringProperty("");
        this.photo = new SimpleStringProperty("");
    }

    public Hospital(String name, String streetAddress, String city, String state, String zip,
                    String latitude, String longitude, String phoneNo, String photo)
    {
        this.name = new SimpleStringProperty(name);
        this.streetAddress = new SimpleStringProperty(streetAddress);
        this.city = new SimpleStringProperty(city);
        this.state = new SimpleStringProperty(state);
        this.zip = new SimpleStringProperty(zip);
        this.latitude = new SimpleStringProperty(latitude);
        this.longitude = new SimpleStringProperty(longitude);
        this.phoneNo = new SimpleStringProperty(phoneNo);
        this.photo = new SimpleStringProperty(photo);
    }

    public String getName()
    {
        return name.get();
    }

    public void setName(String name)
    {
        this.name.set(name);
    }

    public StringProperty nameProperty()
    {
        return name;
    }

    public String getStreetAddress()
    {
        return streetAddress.get();
    }

    public void setStreetAddress(String streetAddress)
    {
        this.streetAddress.set(streetAddress);
    }

    public StringProperty streetAddressProperty()
    {
        return streetAddress;
    }

    public String getCity()
    {
        return city.get();
    }

    public void setCity(String city)
    {
        this.city.set(city);
    }

    public StringProperty cityProperty()
    {
        return city;
    }

    public String getState()
    {
        return state.get();
    }

    public void setState(String state)
    {
        this.state.set(state);
    }

    public StringProperty stateProperty()
    {
        return state;
    }

    public String getZip()
    {
        return zip.get();
    }

    public void setZip(String zip)
    {
        this.zip.set(zip);
    }

    public StringProperty zipProperty()
    {
        return zip;
    }

    public String getLatitude()
    {
        return latitude.get();
    }

    public void setLatitude(String latitude)
    {
        this.latitude.set(latitude);
    }

    public StringProperty latitudeProperty()
    {
        return latitude;
    }

    public String getLongitude()
    {
        return longitude.get();
    }

    public void setLongitude(String longitude)
    {
        this.longitude.set(longitude);
    }

    public StringProperty longitudeProperty()
    {
        return longitude;
    }

    public String getPhoneNo()
    {
        return phoneNo.get();
    }

    public void setPhoneNo(String phoneNo)
    {
        this.phoneNo.set(phoneNo);
    }

    public StringProperty phoneNoProperty()
    {
        return phoneNo;
    }

    public String getPhoto()
    {
        return photo.get();
    }

    public void setPhoto(String photo)
    {
        this.photo.set(photo);
    }

    public StringProperty photoProperty()
    {
        return photo;
    }

    @Override
    public String toString()
    {
        return "Hospital{" +
                "name=" + name.get() +
                ", streetAddress=" + streetAddress.get() +
                ", city=" + city.get() +
                ", state=" + state.get() +
                ", zip=" + zip.get() +
                ", latitude=" + latitude.get() +
                ", longitude=" + longitude.get() +
                ", phoneNo=" + phoneNo.get() +
                ", photo=" + photo.get() +
                '}';
    }

    @Override
    public int compareTo(Hospital o)
    {
        int compare = this.latitude.get().compareTo(o.getLatitude());
        return ((compare == 0) ? this.longitude.get().compareTo(o.getLongitude()) : compare);
    }
}