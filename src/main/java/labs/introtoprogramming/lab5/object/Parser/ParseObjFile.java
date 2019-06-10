package labs.introtoprogramming.lab5.object.Parser;

import labs.introtoprogramming.lab5.geometry.Vector3;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;
import static java.util.logging.Level.WARNING;

public class ParseObjFile {
    private Logger log = Logger.getLogger(ParseObjFile.class.getName());

    /**
     * String indicators of parameter in .obj file.
     */

    private final static String OBJ_VERTEX_NORMAL = "vn";
    private final static String OBJ_VERTEX = "v";
    private final static String OBJ_FACE = "f";

    private ArrayList<Vector3> verticesNormals = new ArrayList<>();
    private ArrayList<Vector3> verticesGeometry = new ArrayList<>();
    private ArrayList<Vertex> vertices = new ArrayList<>();
    private ArrayList<PolygonObject> polygons = new ArrayList<>();
    File objFile = null;


    public ParseObjFile(String filename) throws FileNotFoundException, IOException {

        parseObjFile(filename);

    }

    /**
     * This part pars object file.
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
            } else if (line.startsWith(OBJ_VERTEX_NORMAL)) {
                processVertexNormal(line);
                // add vertex with some coordinates
            } else if (line.startsWith(OBJ_VERTEX)) {
                processVertex(line);
            } else if (line.startsWith(OBJ_FACE)) {
                processFace(line);
            } else {
                log.log(WARNING, "line " + lineCount + " unknown line |" + line + "|");
            }
            lineCount++;
        }
        bufferedReader.close();

        log.log(INFO, "Loaded " + lineCount + " lines");
    }


    /**
     * Create vertex( just coordinates of each one) from data of file.
     *
     * @param line
     */

    private void processVertex(String line) {
        String[] values = line.split(" ");
        float[] result = new float[3];
        for (int i = 2; i < values.length; i++) {
            result[i - 2] = Float.parseFloat(values[i]);
        }
        verticesGeometry.add(new Vector3(result[0], result[1], result[2]));
    }


    /**
     * Create normal-data of vertex
     *
     * @param line
     */
    private void processVertexNormal(String line) {
        String[] values = line.split(" ");
        float[] result = new float[3];
        for (int i = 2; i < values.length; i++) {
            result[i - 2] = Float.parseFloat(values[i]);
        }
        verticesNormals.add(new Vector3(result[0], result[1], result[2]));
    }


    private void processFace(String line) {
        line = line.substring(OBJ_FACE.length()).trim();
        Integer[] vertexIndexAry = StringUtils.parseCodeLine(line, 3);
        addPolygon(vertexIndexAry);


    }

    public void addPolygon(Integer[] vertexIndices) {
        PolygonObject polygonObject = new PolygonObject();

        int indexOfStructure = 0;
        Vertex fv;

        while (indexOfStructure + 2 < vertexIndices.length) {

            fv = new Vertex();
            fv.setVertexG(verticesGeometry.get(vertexIndices[indexOfStructure] - 1));
            if (vertexIndices[indexOfStructure + 2] != null) {
                indexOfStructure++;
            }
            fv.setVertexN(verticesNormals.get(vertexIndices[++indexOfStructure] - 1));
            vertices.add(fv);
            polygonObject.addVertex(fv);
            indexOfStructure+=2;

        }

        polygons.add(polygonObject);
    }
}
