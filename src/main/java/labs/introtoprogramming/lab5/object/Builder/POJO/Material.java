package labs.introtoprogramming.lab5.object.Builder.POJO;

import labs.introtoprogramming.lab5.object.Builder.BuilderInterface;

public class Material {
    private String nameOfMaterial;
    private ReflectivityTransmission ka = new ReflectivityTransmission();
    private ReflectivityTransmission kd = new ReflectivityTransmission();
    private ReflectivityTransmission ks = new ReflectivityTransmission();
    private ReflectivityTransmission tf = new ReflectivityTransmission();
    private int illumModel = 0;
    private boolean dHalo = false;
    private double dFactor = 0.0;
    private double nsExponent = 0.0;
    private double sharpnessValue = 0.0;
    private double niOpticalDensity = 0.0;
    private String mapKaFilename = null;
    private String mapKdFilename = null;
    private String mapKsFilename = null;
    private String mapNsFilename = null;
    private String mapDFilename = null;
    private String decalFilename = null;
    private String dispFilename = null;
    private String bumpFilename = null;
    private int reflType = BuilderInterface.MTL_REFL_TYPE_UNKNOWN;

    public String getNameOfMaterial() {
        return nameOfMaterial;
    }

    public void setNameOfMaterial(String nameOfMaterial) {
        this.nameOfMaterial = nameOfMaterial;
    }

    public ReflectivityTransmission getKa() {
        return ka;
    }

    public void setKa(ReflectivityTransmission ka) {
        this.ka = ka;
    }

    public ReflectivityTransmission getKd() {
        return kd;
    }

    public void setKd(ReflectivityTransmission kd) {
        this.kd = kd;
    }

    public ReflectivityTransmission getKs() {
        return ks;
    }

    public void setKs(ReflectivityTransmission ks) {
        this.ks = ks;
    }

    public ReflectivityTransmission getTf() {
        return tf;
    }

    public void setTf(ReflectivityTransmission tf) {
        this.tf = tf;
    }

    public int getIllumModel() {
        return illumModel;
    }

    public void setIllumModel(int illumModel) {
        this.illumModel = illumModel;
    }

    public boolean isdHalo() {
        return dHalo;
    }

    public void setdHalo(boolean dHalo) {
        this.dHalo = dHalo;
    }

    public double getdFactor() {
        return dFactor;
    }

    public void setdFactor(double dFactor) {
        this.dFactor = dFactor;
    }

    public double getNsExponent() {
        return nsExponent;
    }

    public void setNsExponent(double nsExponent) {
        this.nsExponent = nsExponent;
    }

    public double getSharpnessValue() {
        return sharpnessValue;
    }

    public void setSharpnessValue(double sharpnessValue) {
        this.sharpnessValue = sharpnessValue;
    }

    public double getNiOpticalDensity() {
        return niOpticalDensity;
    }

    public void setNiOpticalDensity(double niOpticalDensity) {
        this.niOpticalDensity = niOpticalDensity;
    }

    public String getMapKaFilename() {
        return mapKaFilename;
    }

    public void setMapKaFilename(String mapKaFilename) {
        this.mapKaFilename = mapKaFilename;
    }

    public String getMapKdFilename() {
        return mapKdFilename;
    }

    public void setMapKdFilename(String mapKdFilename) {
        this.mapKdFilename = mapKdFilename;
    }

    public String getMapKsFilename() {
        return mapKsFilename;
    }

    public void setMapKsFilename(String mapKsFilename) {
        this.mapKsFilename = mapKsFilename;
    }

    public String getMapNsFilename() {
        return mapNsFilename;
    }

    public void setMapNsFilename(String mapNsFilename) {
        this.mapNsFilename = mapNsFilename;
    }

    public String getMapDFilename() {
        return mapDFilename;
    }

    public void setMapDFilename(String mapDFilename) {
        this.mapDFilename = mapDFilename;
    }

    public String getDecalFilename() {
        return decalFilename;
    }

    public void setDecalFilename(String decalFilename) {
        this.decalFilename = decalFilename;
    }

    public String getDispFilename() {
        return dispFilename;
    }

    public void setDispFilename(String dispFilename) {
        this.dispFilename = dispFilename;
    }

    public String getBumpFilename() {
        return bumpFilename;
    }

    public void setBumpFilename(String bumpFilename) {
        this.bumpFilename = bumpFilename;
    }

    public int getReflType() {
        return reflType;
    }

    public void setReflType(int reflType) {
        this.reflType = reflType;
    }

    public String getReflFilename() {
        return reflFilename;
    }

    public void setReflFilename(String reflFilename) {
        this.reflFilename = reflFilename;
    }

    private String reflFilename = null;

    public Material(String name) {
        this.nameOfMaterial = name;
    }
}
