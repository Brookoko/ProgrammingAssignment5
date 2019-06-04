package labs.introtoprogramming.lab5.object.Builder.POJO;

public class ReflectivityTransmission {
    private boolean isRGB = false;
    private boolean isXYZ = false;
    private double redX;
    private double greenY;
    private double blueZ;


    public boolean isRGB() {
        return isRGB;
    }

    public void setRGB(boolean RGB) {
        isRGB = RGB;
    }

    public boolean isXYZ() {
        return isXYZ;
    }

    public void setXYZ(boolean XYZ) {
        isXYZ = XYZ;
    }

    public double getRedX() {
        return redX;
    }

    public void setRedX(double redX) {
        this.redX = redX;
    }

    public double getGy() {
        return greenY;
    }

    public void setGy(double gy) {
        this.greenY = gy;
    }

    public double getBz() {
        return blueZ;
    }

    public void setBz(double bz) {
        this.blueZ = bz;
    }

    public ReflectivityTransmission() {
    }

}
