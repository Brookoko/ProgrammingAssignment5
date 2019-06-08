package labs.introtoprogramming.lab5.object.Parser;

import labs.introtoprogramming.lab5.object.Builder.BuilderInterface;

import java.io.*;
import java.util.logging.Logger;

import static java.util.logging.Level.*;

public class ParseObj {
    private Logger log = Logger.getLogger(ParseObj.class.getName());

    /**
     * string indicators of parameter in .obj file
     */

    private final static String OBJ_VERTEX_TEXTURE = "vt";
    private final static String OBJ_VERTEX_NORMAL = "vn";
    private final static String OBJ_VERTEX = "v";
    private final static String OBJ_FACE = "f";
    private final static String OBJ_GROUP_NAME = "g";
    private final static String OBJ_OBJECT_NAME = "o";
    private final static String OBJ_SMOOTHING_GROUP = "s";
    private final static String OBJ_POINT = "p";
    private final static String OBJ_LINE = "l";
    private final static String OBJ_MAPLIB = "maplib";
    private final static String OBJ_USEMAP = "usemap";
    private final static String OBJ_MTLLIB = "mtllib";
    private final static String OBJ_USEMTL = "usemtl";
    private final static String MTL_NEWMTL = "newmtl";
    private final static String MTL_KA = "Ka";
    private final static String MTL_KD = "Kd";
    private final static String MTL_KS = "Ks";
    private final static String MTL_TF = "Tf";
    private final static String MTL_ILLUM = "illum";
    private final static String MTL_D = "d";
    private final static String MTL_D_DASHHALO = "-halo";
    private final static String MTL_NS = "Ns";
    private final static String MTL_SHARPNESS = "sharpness";
    private final static String MTL_NI = "Ni";
    private final static String MTL_MAP_KA = "map_Ka";
    private final static String MTL_MAP_KD = "map_Kd";
    private final static String MTL_MAP_KS = "map_Ks";
    private final static String MTL_MAP_NS = "map_Ns";
    private final static String MTL_MAP_D = "map_d";
    private final static String MTL_DISP = "disp";
    private final static String MTL_DECAL = "decal";
    private final static String MTL_BUMP = "bump";
    private final static String MTL_REFL = "refl";
    public final static String MTL_REFL_TYPE_SPHERE = "sphere";
    public final static String MTL_REFL_TYPE_CUBE_TOP = "cube_top";
    public final static String MTL_REFL_TYPE_CUBE_BOTTOM = "cube_bottom";
    public final static String MTL_REFL_TYPE_CUBE_FRONT = "cube_front";
    public final static String MTL_REFL_TYPE_CUBE_BACK = "cube_back";
    public final static String MTL_REFL_TYPE_CUBE_LEFT = "cube_left";
    public final static String MTL_REFL_TYPE_CUBE_RIGHT = "cube_right";
    BuilderInterface builder = null;
    File objFile = null;


    public ParseObj(BuilderInterface builder, String filename) throws FileNotFoundException, IOException {
        this.builder = builder;
        builder.setObjFilename(filename);
        parseObjFile(filename);

        builder.doneParsingObj(filename);
    }

    /**
     * this part pars object file
     *
     * @param objFilename
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void parseObjFile(String objFilename) throws FileNotFoundException, IOException {
        int lineCount = 0;
        InputStreamReader fileReader;
        BufferedReader bufferedReader;

        objFile = new File(objFilename);
        fileReader = new InputStreamReader(new FileInputStream(objFilename), "UTF-8");
        bufferedReader = new BufferedReader(fileReader);

        String line;

        // read .obj file
        while (true) {
            line = bufferedReader.readLine();
            if (null == line) {
                break;
            }

            line = line.trim();

            if (line.length() == 0) {
                continue;
            }

            // cases to process
            if (line.startsWith("#")) {
                continue;
            } else if (line.startsWith(OBJ_VERTEX_TEXTURE)) {
                processVertexTexture(line);
            } else if (line.startsWith(OBJ_VERTEX_NORMAL)) {
                processVertexNormal(line);
                // add vertex with some coordinates
            } else if (line.startsWith(OBJ_VERTEX)) {
                processVertex(line);
            } else if (line.startsWith(OBJ_FACE)) {
                processFace(line);
            } else if (line.startsWith(OBJ_GROUP_NAME)) {
                processGroupName(line);
            } else if (line.startsWith(OBJ_OBJECT_NAME)) {
                processObjectName(line);
            } else if (line.startsWith(OBJ_SMOOTHING_GROUP)) {
                processSmoothingGroup(line);
            } else if (line.startsWith(OBJ_POINT)) {
                processPoint(line);
            } else if (line.startsWith(OBJ_LINE)) {
                processLine(line);
            } else if (line.startsWith(OBJ_MAPLIB)) {
                processMapLib(line);
            } else if (line.startsWith(OBJ_USEMAP)) {
                processUseMap(line);
            } else if (line.startsWith(OBJ_USEMTL)) {
                processUseMaterial(line);
            } else if (line.startsWith(OBJ_MTLLIB)) {
                processMaterialLib(line);
            } else {
                log.log(WARNING, "line " + lineCount + " unknown line |" + line + "|");
            }
            lineCount++;
        }
        bufferedReader.close();

        log.log(INFO, "Loaded " + lineCount + " lines");
    }


    /**
     * create vertex from data of file
     * @param line
     */

    private void processVertex(String line) {
        float[] values = StringUtils.parseFloatList(3, line, OBJ_VERTEX.length());
        builder.addVertexGeometric(values[0], values[1], values[2]);
    }

    private void processVertexTexture(String line) {
        float[] values = StringUtils.parseFloatList(2, line, OBJ_VERTEX_TEXTURE.length());
        builder.addVertexTexture(values[0], values[1]);
    }

    private void processVertexNormal(String line) {
        float[] values = StringUtils.parseFloatList(3, line, OBJ_VERTEX_NORMAL.length());
        builder.addVertexNormal(values[0], values[1], values[2]);
    }


    private void processFace(String line) {
        line = line.substring(OBJ_FACE.length()).trim();
        int[] vertexIndexAry = StringUtils.parseListVertexNTuples(line, 3);

        builder.addFace(vertexIndexAry);
    }

    /**
     * add group name to builder-object
     * @param line
     */

    private void processGroupName(String line) {
        String[] groupNames = StringUtils.parseWhitespaceList(line.substring(OBJ_GROUP_NAME.length()).trim());
        builder.setCurrentGroupNames(groupNames);
    }


    /**
     * add to builder name of the object
     * @param line
     */
    private void processObjectName(String line) {
        builder.addObjectName(line.substring(OBJ_OBJECT_NAME.length()).trim());
    }


    private void processSmoothingGroup(String line) {
        line = line.substring(OBJ_SMOOTHING_GROUP.length()).trim();
        long groupNumber = 0;
        if (!line.equalsIgnoreCase("off")) {
            groupNumber = Long.parseLong(line);
        }
        builder.setCurrentSmoothingGroup(groupNumber);
    }

    private void processPoint(String line) {
        line = line.substring(OBJ_POINT.length()).trim();
        int[] values = StringUtils.parseListVertexNTuples(line, 1);
        builder.addPoints(values);
    }

    private void processLine(String line) {
        line = line.substring(OBJ_LINE.length()).trim();
        int[] values = StringUtils.parseListVertexNTuples(line, 2);
        builder.addLine(values);
    }

    /**
     * find material from files that exist (.bmp)
     * @param line
     * @throws FileNotFoundException
     * @throws IOException
     */

    private void processMaterialLib(String line) throws FileNotFoundException, IOException {
        String[] matLibNames = StringUtils.parseWhitespaceList(line.substring(OBJ_MTLLIB.length()).trim());

        if (null != matLibNames) {
            for (int loopi = 0; loopi < matLibNames.length; loopi++) {
                try {
                    parseMtlFile(matLibNames[loopi]);
                } catch (FileNotFoundException e) {
                    log.log(SEVERE, "Can't find material file name='" + matLibNames[loopi] + "', e=" + e);
                }
            }
        }
    }

    private void processUseMaterial(String line) {
        builder.setCurrentUseMaterial(line.substring(OBJ_USEMTL.length()).trim());
    }

    private void processMapLib(String line) {
        String[] multipleNames = StringUtils.parseWhitespaceList(line.substring(OBJ_MAPLIB.length()).trim());
        builder.addMapLib(multipleNames);
    }

    private void processUseMap(String line) {
        builder.setCurrentUseMap(line.substring(OBJ_USEMAP.length()).trim());
    }

    /**
     * read information from .mtl file
     * @param mtlFilename
     * @throws FileNotFoundException
     * @throws IOException
     */

    private void parseMtlFile(String mtlFilename) throws FileNotFoundException, IOException {
        int lineCount = 0;
        InputStreamReader fileReader = null;
        BufferedReader bufferedReader = null;

        File mtlFile = new File(objFile.getParent(), mtlFilename);
        fileReader = new InputStreamReader(new FileInputStream(mtlFile), "UTF-8");
        bufferedReader = new BufferedReader(fileReader);

        String line = null;

        while (true) {
            line = bufferedReader.readLine();
            if (null == line) {
                break;
            }

            line = line.trim();

            if (line.length() == 0) {
                continue;
            }

            if (line.startsWith("#")) {
                continue;
            } else if (line.startsWith(MTL_NEWMTL)) {
                processNewmtl(line);
            } else if (line.startsWith(MTL_KA)) {
                processReflectivityTransmissivity(MTL_KA, line);
            } else if (line.startsWith(MTL_KD)) {
                processReflectivityTransmissivity(MTL_KD, line);
            } else if (line.startsWith(MTL_KS)) {
                processReflectivityTransmissivity(MTL_KS, line);
            } else if (line.startsWith(MTL_TF)) {
                processReflectivityTransmissivity(MTL_TF, line);
            } else if (line.startsWith(MTL_ILLUM)) {
                processIllum(line);
            } else if (line.startsWith(MTL_D)) {
                processD(line);
            } else if (line.startsWith(MTL_NS)) {
                processNs(line);
            } else if (line.startsWith(MTL_SHARPNESS)) {
                processSharpness(line);
            } else if (line.startsWith(MTL_NI)) {
                processNi(line);
            } else if (line.startsWith(MTL_MAP_KA)) {
                processMapDecalDispBump(MTL_MAP_KA, line);
            } else if (line.startsWith(MTL_MAP_KD)) {
                processMapDecalDispBump(MTL_MAP_KD, line);
            } else if (line.startsWith(MTL_MAP_KS)) {
                processMapDecalDispBump(MTL_MAP_KS, line);
            } else if (line.startsWith(MTL_MAP_NS)) {
                processMapDecalDispBump(MTL_MAP_NS, line);
            } else if (line.startsWith(MTL_MAP_D)) {
                processMapDecalDispBump(MTL_MAP_D, line);
            } else if (line.startsWith(MTL_DISP)) {
                processMapDecalDispBump(MTL_DISP, line);
            } else if (line.startsWith(MTL_DECAL)) {
                processMapDecalDispBump(MTL_DECAL, line);
            } else if (line.startsWith(MTL_BUMP)) {
                processMapDecalDispBump(MTL_BUMP, line);
            } else if (line.startsWith(MTL_REFL)) {
                processRefl(line);
            } else {
                log.log(WARNING, "line " + lineCount + " unknown line |" + line + "|");

            }
            lineCount++;
        }
        bufferedReader.close();

        log.log(INFO, "Parse.parseMtlFile: Loaded " + lineCount + " lines");
    }

    private void processNewmtl(String line) {
        line = line.substring(MTL_NEWMTL.length()).trim();
        builder.newMtl(line);
    }

    private void processReflectivityTransmissivity(String fieldName, String line) {
        int type = BuilderInterface.MTL_KA;
        if (fieldName.equals(MTL_KD)) {
            type = BuilderInterface.MTL_KD;
        } else if (fieldName.equals(MTL_KS)) {
            type = BuilderInterface.MTL_KS;
        } else if (fieldName.equals(MTL_TF)) {
            type = BuilderInterface.MTL_TF;
        }

        String[] tokens = StringUtils.parseWhitespaceList(line.substring(fieldName.length()));
        if (null == tokens) {
            log.log(SEVERE, "Got Ka line with no tokens, line = |" + line + "|");
            return;
        }
        if (tokens.length <= 0) {
            log.log(SEVERE, "Got Ka line with no tokens, line = |" + line + "|");
            return;
        }
        if (tokens[0].equals("xyz")) {


            float x = Float.parseFloat(tokens[1]);
            float y = x;
            float z = x;
            if (tokens.length > 2) {
                y = Float.parseFloat(tokens[2]);
            }
            if (tokens.length > 3) {
                z = Float.parseFloat(tokens[3]);
            }
            builder.setXYZ(type, x, y, z);
        } else {

            float r = Float.parseFloat(tokens[0]);
            float g = r;
            float b = r;
            if (tokens.length > 1) {
                g = Float.parseFloat(tokens[1]);
            }
            if (tokens.length > 2) {
                b = Float.parseFloat(tokens[2]);
            }
            builder.setRGB(type, r, g, b);
        }
    }

    private void processIllum(String line) {
        line = line.substring(MTL_ILLUM.length()).trim();
        int illumModel = Integer.parseInt(line);
        if ((illumModel < 0) || (illumModel > 10)) {
            return;
        }
        builder.setIllum(illumModel);
    }


    private void processD(String line) {
        line = line.substring(MTL_D.length()).trim();
        boolean halo = false;
        if (line.startsWith(MTL_D_DASHHALO)) {
            halo = true;
            line = line.substring(MTL_D_DASHHALO.length()).trim();
        }
        float factor = Float.parseFloat(line);
        builder.setD(halo, factor);
    }

    private void processNs(String line) {
        line = line.substring(MTL_NS.length()).trim();
        float exponent = Float.parseFloat(line);
        builder.setNs(exponent);
    }

    @Override
    public String toString() {
        return "ParseMe{" +
                "builder=" + builder +
                ", objFile=" + objFile +
                '}';
    }

    private void processSharpness(String line) {
        line = line.substring(MTL_SHARPNESS.length()).trim();
        float value = Float.parseFloat(line);
        builder.setSharpness(value);
    }

    private void processNi(String line) {
        line = line.substring(MTL_NI.length()).trim();
        float opticalDensity = Float.parseFloat(line);
        builder.setNi(opticalDensity);
    }


    private void processMapDecalDispBump(String fieldname, String line) {
        int type = BuilderInterface.MTL_MAP_KA;
        if (fieldname.equals(MTL_MAP_KD)) {
            type = BuilderInterface.MTL_MAP_KD;
        } else if (fieldname.equals(MTL_MAP_KS)) {
            type = BuilderInterface.MTL_MAP_KS;
        } else if (fieldname.equals(MTL_MAP_NS)) {
            type = BuilderInterface.MTL_MAP_NS;
        } else if (fieldname.equals(MTL_MAP_D)) {
            type = BuilderInterface.MTL_MAP_D;
        } else if (fieldname.equals(MTL_DISP)) {
            type = BuilderInterface.MTL_DISP;
        } else if (fieldname.equals(MTL_DECAL)) {
            type = BuilderInterface.MTL_DECAL;
        } else if (fieldname.equals(MTL_BUMP)) {
            type = BuilderInterface.MTL_BUMP;
        }

        String filename = line.substring(fieldname.length()).trim();
        builder.setMapDecalDispBump(type, filename);


    }

    private void processRefl(String line) {
        String filename = null;

        int type = BuilderInterface.MTL_REFL_TYPE_UNKNOWN;
        line = line.substring(MTL_REFL.length()).trim();
        if (line.startsWith("-type")) {
            line = line.substring("-type".length()).trim();
            if (line.startsWith(MTL_REFL_TYPE_SPHERE)) {
                type = BuilderInterface.MTL_REFL_TYPE_SPHERE;
                filename = line.substring(MTL_REFL_TYPE_SPHERE.length()).trim();
            } else if (line.startsWith(MTL_REFL_TYPE_CUBE_TOP)) {
                type = BuilderInterface.MTL_REFL_TYPE_CUBE_TOP;
                filename = line.substring(MTL_REFL_TYPE_CUBE_TOP.length()).trim();
            } else if (line.startsWith(MTL_REFL_TYPE_CUBE_BOTTOM)) {
                type = BuilderInterface.MTL_REFL_TYPE_CUBE_BOTTOM;
                filename = line.substring(MTL_REFL_TYPE_CUBE_BOTTOM.length()).trim();
            } else if (line.startsWith(MTL_REFL_TYPE_CUBE_FRONT)) {
                type = BuilderInterface.MTL_REFL_TYPE_CUBE_FRONT;
                filename = line.substring(MTL_REFL_TYPE_CUBE_FRONT.length()).trim();
            } else if (line.startsWith(MTL_REFL_TYPE_CUBE_BACK)) {
                type = BuilderInterface.MTL_REFL_TYPE_CUBE_BACK;
                filename = line.substring(MTL_REFL_TYPE_CUBE_BACK.length()).trim();
            } else if (line.startsWith(MTL_REFL_TYPE_CUBE_LEFT)) {
                type = BuilderInterface.MTL_REFL_TYPE_CUBE_LEFT;
                filename = line.substring(MTL_REFL_TYPE_CUBE_LEFT.length()).trim();
            } else if (line.startsWith(MTL_REFL_TYPE_CUBE_RIGHT)) {
                type = BuilderInterface.MTL_REFL_TYPE_CUBE_RIGHT;
                filename = line.substring(MTL_REFL_TYPE_CUBE_RIGHT.length()).trim();
            } else {
                log.log(SEVERE, "unknown material refl -type, line = |" + line + "|");
                return;
            }
        } else {
            filename = line;
        }

        builder.setRefl(type, filename);
    }
}
