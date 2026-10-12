
interface Camera {
    void takePhoto();
}

interface VideoRecorder {
    void recordVideo();
}

class AndroidCamera implements Camera {
    public void takePhoto() {
        System.out.println("Android: Photo captured");
    }
}

class AndroidVideo implements VideoRecorder {
    public void recordVideo() {
        System.out.println("Android: Video recorded");
    }
}

class iPhoneCamera implements Camera {
    public void takePhoto() {
        System.out.println("iPhone: Photo captured");
    }
}

class iPhoneVideo implements VideoRecorder {
    public void recordVideo() {
        System.out.println("iPhone: Video recorded");
    }
}

interface MobileFactory {
    Camera createCamera();

    VideoRecorder createVideoRecorder();
}

class AndroidFactory implements MobileFactory {
    public Camera createCamera() {
        return new AndroidCamera();
    }

    public VideoRecorder createVideoRecorder() {
        return new AndroidVideo();
    }
}

class iPhoneFactory implements MobileFactory {
    public Camera createCamera() {
        return new iPhoneCamera();
    }

    public VideoRecorder createVideoRecorder() {
        return new iPhoneVideo();
    }
}

public class MobileFactoryDemo {
    public static void main(String[] args) {
        MobileFactory factory = new AndroidFactory();

        Camera camera = factory.createCamera();
        VideoRecorder video = factory.createVideoRecorder();

        camera.takePhoto();
        video.recordVideo();

        factory = new iPhoneFactory();

        factory.createCamera().takePhoto();
        factory.createVideoRecorder().recordVideo();
    }
}
