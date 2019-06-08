package labs.introtoprogramming.lab5.object.Builder;

import labs.introtoprogramming.lab5.object.Builder.POJO.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;

public class BuildParserObj implements BuilderInterface {

    private Logger log = Logger.getLogger(BuildParserObj.class.getName());

    private String objFilename = null;


    private ArrayList<VertexGeometry> verticesG = new ArrayList<VertexGeometry>();
    private ArrayList<VertexTexture> verticesT = new ArrayList<VertexTexture>();
    private ArrayList<VertexNormal> verticesN = new ArrayList<VertexNormal>();



     private HashMap<String, VertexFace> faceVertexMap = new HashMap<String, VertexFace>();

    private ArrayList<VertexFace> faceVertexList = new ArrayList<VertexFace>();
    private ArrayList<FacePlate> faces = new ArrayList<FacePlate>();
    private HashMap<Long, ArrayList<FacePlate>> smoothingGroups = new HashMap<Long, ArrayList<FacePlate>>();

    private long currentSmoothingGroupNumber = NO_SMOOTHING_GROUP;
    private ArrayList<FacePlate> currentSmoothingGroup = null;
    private HashMap<String, ArrayList<FacePlate>> groups = new HashMap<String, ArrayList<FacePlate>>();
    private ArrayList<String> currentGroups = new ArrayList<String>();
    private ArrayList<ArrayList<FacePlate>> currentGroupFaceLists = new ArrayList<ArrayList<FacePlate>>();
    private String objectName = null;
    private Material currentMaterial = null;
    private Material currentMap = null;
    public HashMap<String, Material> materialLib = new HashMap<String, Material>();
    private Material currentMaterialBeingParsed = null;
    public HashMap<String, Material> mapLib = new HashMap<String, Material>();
    public int faceTriCount = 0;
    public int faceQuadCount = 0;
    public int facePolyCount = 0;
    public int faceErrorCount = 0;


    public void setObjFilename(String filename) {
        this.objFilename = filename;
    }

    public void addVertexGeometric(float x, float y, float z) {
        verticesG.add(new VertexGeometry(x, y, z));

    }

    public void addVertexTexture(float u, float v) {
        verticesT.add(new VertexTexture(u, v));

    }

    public void addVertexNormal(float x, float y, float z) {
        verticesN.add(new VertexNormal(x, y, z));
    }

    public void addPoints(int[] values) {
        log.log(INFO, "@TODO: Got " + values.length + " points in builder, ignoring");
    }

    public void addLine(int[] values) {
        log.log(INFO, "@TODO: Got a line of " + values.length + " segments in builder, ignoring");
    }

    public String getObjFilename() {
        return objFilename;
    }

    public ArrayList<VertexGeometry> getVerticesG() {
        return verticesG;
    }

    public ArrayList<VertexTexture> getVerticesT() {
        return verticesT;
    }

    public ArrayList<VertexNormal> getVerticesN() {
        return verticesN;
    }

    public HashMap<String, VertexFace> getFaceVertexMap() {
        return faceVertexMap;
    }

    public ArrayList<VertexFace> getFaceVertexList() {
        return faceVertexList;
    }

    public ArrayList<FacePlate> getFaces() {
        return faces;
    }

    public HashMap<Long, ArrayList<FacePlate>> getSmoothingGroups() {
        return smoothingGroups;
    }

    public long getCurrentSmoothingGroupNumber() {
        return currentSmoothingGroupNumber;
    }

    public ArrayList<FacePlate> getCurrentSmoothingGroup() {
        return currentSmoothingGroup;
    }

    public HashMap<String, ArrayList<FacePlate>> getGroups() {
        return groups;
    }

    public ArrayList<String> getCurrentGroups() {
        return currentGroups;
    }

    public ArrayList<ArrayList<FacePlate>> getCurrentGroupFaceLists() {
        return currentGroupFaceLists;
    }

    public String getObjectName() {
        return objectName;
    }

    public Material getCurrentMaterial() {
        return currentMaterial;
    }

    public Material getCurrentMap() {
        return currentMap;
    }

    public Material getCurrentMaterialBeingParsed() {
        return currentMaterialBeingParsed;
    }

    public void addFace(int[] vertexIndices) {
        FacePlate face = new FacePlate();

        face.material = currentMaterial;
        face.map = currentMap;

        int loopi = 0;

        while (loopi < vertexIndices.length) {


            VertexFace fv = new VertexFace();

            int vertexIndex;
            vertexIndex = vertexIndices[loopi++];


            if (vertexIndex < 0) {
                vertexIndex = vertexIndex + verticesG.size();
            }
            if (((vertexIndex - 1) >= 0) && ((vertexIndex - 1) < verticesG.size())) {

                fv.setVertexG(verticesG.get(vertexIndex - 1));
            } else {
                log.log(SEVERE, "Index for geometric vertex=" +
                        vertexIndex + " is out of the current range of geometric vertex values 1 to " + verticesG.size() + ", ignoring");
            }

            vertexIndex = vertexIndices[loopi++];
            if (vertexIndex != EMPTY_VERTEX_VALUE) {
                if (vertexIndex < 0) {
                    vertexIndex = vertexIndex + verticesT.size();
                }
                if (((vertexIndex - 1) >= 0) && ((vertexIndex - 1) < verticesT.size())) {

                    fv.setVertexT(verticesT.get(vertexIndex - 1));
                } else {
                    log.log(SEVERE, "Index for texture vertex=" + vertexIndex +
                            " is out of the current range of texture vertex values 1 to " + verticesT.size() + ", ignoring");
                }
            }

            vertexIndex = vertexIndices[loopi++];
            if (vertexIndex != EMPTY_VERTEX_VALUE) {
                if (vertexIndex < 0) {

                    vertexIndex = vertexIndex + verticesN.size();
                }
                if (((vertexIndex - 1) >= 0) && ((vertexIndex - 1) < verticesN.size())) {

                    fv.setVertexN(verticesN.get(vertexIndex - 1));
                } else {
                    log.log(SEVERE, "Index for vertex normal=" + vertexIndex +
                            " is out of the current range of vertex normal values 1 to " + verticesN.size() + ", ignoring");
                }
            }

            if (fv.getVertexN() == null) {
                log.log(SEVERE, "Can't add vertex to face with missing vertex!  Throwing away face.");
                faceErrorCount++;
                return;
            }


            String key = fv.toString();
            VertexFace fv2 = faceVertexMap.get(key);
            if (null == fv2) {
                faceVertexMap.put(key, fv);
                fv.setIndex(faceVertexList.size());
                faceVertexList.add(fv);
            } else {
                fv = fv2;
            }

            face.add(fv);
        }

        if (currentSmoothingGroup != null) {
            currentSmoothingGroup.add(face);
        }

        if (currentGroupFaceLists.size() > 0) {
            for (loopi = 0; loopi < currentGroupFaceLists.size(); loopi++) {
                currentGroupFaceLists.get(loopi).add(face);
            }
        }

        faces.add(face);


        if (face.vertices.size() == 3) {
            faceTriCount++;
        } else if (face.vertices.size() == 4) {
            faceQuadCount++;
        } else {
            facePolyCount++;
        }
    }


    public void setCurrentGroupNames(String[] names) {
        currentGroups.clear();
        currentGroupFaceLists.clear();
        if (null == names) {

            return;
        }
        for (int loopi = 0; loopi < names.length; loopi++) {
            String group = names[loopi].trim();
            currentGroups.add(group);
            if (null == groups.get(group)) {
                groups.put(group, new ArrayList<FacePlate>());
            }
            currentGroupFaceLists.add(groups.get(group));
        }
    }

    public void addObjectName(String name) {
        this.objectName = name;
    }

    public void setCurrentSmoothingGroup(long groupNumber) {
        currentSmoothingGroupNumber = groupNumber;
        if (currentSmoothingGroupNumber == NO_SMOOTHING_GROUP) {
            return;
        }
        if (null == smoothingGroups.get(currentSmoothingGroupNumber)) {
            currentSmoothingGroup = new ArrayList<FacePlate>();
            smoothingGroups.put(currentSmoothingGroupNumber, currentSmoothingGroup);
        }
    }


    public void addMapLib(String[] names) {
        if (null == names) {
            log.log(INFO, "@TODO: ERROR! Got a mapLib line with null names array - blank group line? (i.e. \"g\\n\" ?)");
            return;
        }
        if (names.length == 1) {
            log.log(INFO, "@TODO: Got a mapLib line with one name=|" + names[0] + "|");
            return;
        }
        log.log(INFO, "@TODO: Got a mapLib line;");
        for (int loopi = 0; loopi < names.length; loopi++) {
            log.log(INFO, "        names[" + loopi + "] = |" + names[loopi] + "|");
        }
    }


    public void setCurrentUseMap(String name) {
        currentMap = mapLib.get(name);
    }

    public void setCurrentUseMaterial(String name) {
        currentMaterial = materialLib.get(name);
    }

    public void newMtl(String name) {
        currentMaterialBeingParsed = new Material(name);
        materialLib.put(name, currentMaterialBeingParsed);
    }

    public void setXYZ(int type, float x, float y, float z) {
        ReflectivityTransmission rt = currentMaterialBeingParsed.getKa();
        if (type == MTL_KD) {
            rt = currentMaterialBeingParsed.getKd();
        } else if (type == MTL_KS) {
            rt = currentMaterialBeingParsed.getKs();
        } else if (type == MTL_TF) {
            rt = currentMaterialBeingParsed.getTf();
        }

        rt.setRedX(x);
        rt.setGy(y);
        rt.setBz(z);
        rt.setXYZ(true);
        rt.setRGB(false);
    }

    public void setRGB(int type, float r, float g, float b) {
        ReflectivityTransmission rt = currentMaterialBeingParsed.getKa();
        if (type == MTL_KD) {
            rt = currentMaterialBeingParsed.getKd();
        } else if (type == MTL_KS) {
            rt = currentMaterialBeingParsed.getKs();
        } else if (type == MTL_TF) {
            rt = currentMaterialBeingParsed.getTf();
        }

        rt.setRedX(r);
        rt.setGy(g);
        rt.setBz(b);
        rt.setRGB(true);
        rt.setXYZ(false);
    }

    public void setIllum(int illumModel) {
        currentMaterialBeingParsed.setIllumModel(illumModel);
    }

    public void setD(boolean halo, float factor) {
        currentMaterialBeingParsed.setdHalo( halo);
        currentMaterialBeingParsed.setdFactor(factor);

    }

    public void setNs(float exponent) {
        currentMaterialBeingParsed.setNsExponent(exponent);

    }

    public void setSharpness(float value) {
        currentMaterialBeingParsed.setSharpnessValue(value);
    }

    public void setNi(float opticalDensity) {
        currentMaterialBeingParsed.setNiOpticalDensity(opticalDensity);
    }

    public void setMapDecalDispBump(int type, String filename) {
        if (type == MTL_MAP_KA) {
            currentMaterialBeingParsed.setMapKaFilename(filename);
        } else if (type == MTL_MAP_KD) {
            currentMaterialBeingParsed.setMapKdFilename(filename);
        } else if (type == MTL_MAP_KS) {
            currentMaterialBeingParsed.setMapKsFilename(filename);
        } else if (type == MTL_MAP_NS) {
            currentMaterialBeingParsed.setMapNsFilename(filename);
        } else if (type == MTL_MAP_D) {
            currentMaterialBeingParsed.setMapDFilename(filename);
        } else if (type == MTL_DECAL) {
            currentMaterialBeingParsed.setDecalFilename(filename);
        } else if (type == MTL_DISP) {
            currentMaterialBeingParsed.setDispFilename(filename);
        } else if (type == MTL_BUMP) {
            currentMaterialBeingParsed.setBumpFilename(filename);
        }
    }

    public void setRefl(int type, String filename) {
        currentMaterialBeingParsed.setReflType(type);
        currentMaterialBeingParsed.setReflFilename(filename);
    }

    public void doneParsingMaterial() {
        currentMaterialBeingParsed = null;
    }

    public void doneParsingObj(String filename) {
        log.log(INFO, "Loaded filename '" + filename + "' with " + verticesG.size() +
                " verticesG, " + verticesT.size() + " verticesT, " + verticesN.size() +
                " verticesN and " + faces.size() + " faces, of which " + faceTriCount + " triangles, "
                + faceQuadCount + " quads, and " + facePolyCount + " with more than 4 points, and faces with errors "
                + faceErrorCount);
    }
}
