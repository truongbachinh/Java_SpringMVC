package study.model;

import org.springframework.stereotype.Component;

@Component
public class Company {
    private String name;
    private String address;
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image =  image;
        System.out.println(this.image);
    }
}
