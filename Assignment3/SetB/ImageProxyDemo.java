
interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    RealImage(String filename) {
        this.filename = filename;
        loadImage();
    }

    private void loadImage() {
        System.out.println("Loading image: " + filename);
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;

    ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }

        realImage.display();
    }
}

public class ImageProxyDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("photo.jpg");

        System.out.println("Image object created");
        image.display();

        System.out.println("Displaying again:");
        image.display();
    }
}
