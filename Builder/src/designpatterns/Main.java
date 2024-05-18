package designpatterns;

class Phone{
    private String data;

    public Phone(){
        data = "";
    }

    public String aboutPhone() {
        return data;
    }

    public void appenData(String str) {
        data += str;
    }
}

interface IDeveloper{
    void createDisplay();
    void createBox();
    void systemInstall();
    Phone getPhone();
}

class AndroidDeveloper implements IDeveloper {
    private Phone phone;

    public AndroidDeveloper() {
        phone = new Phone();
    }

    @Override
    public void createDisplay() {
        phone.appenData("Samsung display manufactured\n");
    }
    @Override
    public void createBox() {
        phone.appenData("The case is manufactured by Samsung\n");
    }
    @Override
    public void systemInstall() {
        phone.appenData("Android system installed\n");
    }
    @Override
    public Phone getPhone() {
        return phone;
    }
}

class IPhoneDeveloper implements IDeveloper {
    private Phone phone;

    public IPhoneDeveloper() {
        phone = new Phone();
    }

    @Override
    public void createDisplay() {
        phone.appenData("iPhone display manufactured\n");
    }
    @Override
    public void createBox() {
        phone.appenData("The case is manufactured by Apple\n");
    }
    @Override
    public void systemInstall() {
        phone.appenData("IOS system installed\n");
    }
    @Override
    public Phone getPhone() {
        return phone;
    }
}

class Director {
    private IDeveloper developer;

    public Director(IDeveloper developer) {
        this.developer = developer;
    }

    public void setDeveloper(IDeveloper developer) {
        this.developer = developer;
    }

    public Phone mountOnlyPhone() {
        developer.createDisplay();
        developer.createBox();
        return developer.getPhone();
    }

    public Phone mountFullPhone() {
        developer.createDisplay();
        developer.createBox();
        developer.systemInstall();
        return developer.getPhone();
    }
}

public class Main {
    public static void main(String[] args) {
        IDeveloper androidDeveloper = new AndroidDeveloper();
        Director director = new Director(androidDeveloper);
        Phone samsung = director.mountFullPhone();

        IDeveloper iphoneDeveloper = new IPhoneDeveloper();
        director.setDeveloper(iphoneDeveloper);
        Phone iphone = director.mountFullPhone();

        System.out.println(samsung.aboutPhone());
        System.out.println(iphone.aboutPhone());
    }
}