package labs.introtoprogramming.lab5.object.Parser;

import labs.introtoprogramming.lab5.geometry.Vector3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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

    private List<Vector3> verticesNormals = new ArrayList<>();
    private List<Vector3> verticesGeometry = new ArrayList<>();
    private PolygonObject polygonObject = null;


    public ParseObjFile(InputStream is) throws FileNotFoundException, IOException {

        polygonObject = new PolygonObject();
        parseObjFile(is);

    }

    /**
     * This is part to parse object file
     * @param is
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void parseObjFile(InputStream is) throws IOException {
        int lineCount = 0;
        InputStreamReader fileReader;
        BufferedReader bufferedReader;

        fileReader = new InputStreamReader(is, "UTF-8");
        bufferedReader = new BufferedReader(fileReader);

        String line;

        // read .obj file
        while ((line = bufferedReader.readLine()) != null) {

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

    public PolygonObject getPolygonObject() {
        return polygonObject;
    }

    /**
     * Create vertex( just coordinates of each one) from data of file.
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
        Integer[] vertexIndexAry = StringUtils.parseCodeLine(line);
        addPolygon(vertexIndexAry);
    }

    public void addPolygon(Integer[] vertexIndices) {
        Polygon polygon = new Polygon();

        int indexOfStructure = 0;
        Vertex fv;

        while (indexOfStructure + 2 < vertexIndices.length) {

            fv = new Vertex();
            fv.setVertexG(verticesGeometry.get(vertexIndices[indexOfStructure] - 1));
            if (vertexIndices[indexOfStructure + 2] != null) {
                indexOfStructure++;
            }
            fv.setVertexN(verticesNormals.get(vertexIndices[++indexOfStructure] - 1));
            polygonObject.addVertex(fv);
            polygon.addVertex(fv);
            indexOfStructure += 2;

        }

        polygon.calculatePolygonNormalTriangle();
        polygonObject.addPolygon(polygon);
    }
}
