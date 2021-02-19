package me.pgb.a2021_02_19b.model;

public class Dog {

    private String name;
    private int myPhoto;

    public Dog(String n, int imageNumber) {
        name = n;
        myPhoto = imageNumber;
    }

    public String getName() { return name; }
    public int getImage() { return myPhoto; }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int imageNumber) {
        this.myPhoto = imageNumber;
    }
}
