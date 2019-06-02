package Parser;

import Builder.BuilderInterface;

import java.util.ArrayList;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;

public class StringUtils {
    private static Logger log = Logger.getLogger(StringUtils.class.getName());

    public static void printErrMsg(String methodName, String errorMsg, int mCount, char message[]) {
        log.log(SEVERE, methodName + ": " + errorMsg);
        String msg1 = "ERROR: " + methodName + ": msg=\\";
        String msg2 = "ERROR: " + methodName + ":      ";
        for (int loopi = 0; loopi < message.length; loopi++) {
            msg1 = msg1 + message[loopi];
            msg2 = msg2 + " ";
        }
        msg1 = msg1 + "\\";
        msg2 = msg2 + "^";
        log.log(SEVERE, msg1);
        log.log(SEVERE, msg1);
    }

    public static int skipWhiteSpace(int mCount, char messageChars[], String errMsg) {

        while (mCount < messageChars.length) {
            if (messageChars[mCount] == ' ' || messageChars[mCount] == '\n' || messageChars[mCount] == '\t') {
                mCount++;
            } else {
                break;
            }
        }
        if (errMsg != null) {
            if (mCount >= messageChars.length) {
                printErrMsg("RString.skipWhiteSpace", errMsg, mCount, messageChars);
                return -1;
            }
        }
        return mCount;
    }

    public static float[] parseFloatList(int numFloats, String list, int startIndex) {
        if (list == null) {
            return null;
        }
        if (list.equals("")) {
            return null;
        }

        float[] returnArray = new float[numFloats];
        int returnArrayCount = 0;

        // Copy list into a char array.
        char listChars[];
        listChars = new char[list.length()];
        list.getChars(0, list.length(), listChars, 0);
        int listLength = listChars.length;

        int count = startIndex;
        int itemStart = startIndex;
        int itemEnd = 0;
        int itemLength = 0;

        while (count < listLength) {
            // Skip any leading whitespace
            itemEnd = skipWhiteSpace(count, listChars, null);
            count = itemEnd;
            if (count >= listLength) {
                break;
            }
            itemStart = count;
            itemEnd = itemStart;
            while (itemEnd < listLength) {
                if ((listChars[itemEnd] != ' ') && (listChars[itemEnd] != '\n') && (listChars[itemEnd] != '\t')) {
                    itemEnd++;
                } else {
                    break;
                }
            }
            itemLength = itemEnd - itemStart;
            returnArray[returnArrayCount++] = Float.parseFloat(new String(listChars, itemStart, itemLength));
            if (returnArrayCount >= numFloats) {
                break;
            }

            count = itemEnd;
        }
        return returnArray;
    }

    public static int[] parseIntList(String list, int startIndex) {
        if (list == null) {
            return null;
        }
        if (list.equals("")) {
            return null;
        }

        ArrayList<Integer> returnList = new ArrayList<Integer>();

        // Copy list into a char array.
        char listChars[];
        listChars = new char[list.length()];
        list.getChars(0, list.length(), listChars, 0);
        int listLength = listChars.length;

        int count = startIndex;
        int itemStart = startIndex;
        int itemEnd = 0;
        int itemLength = 0;

        while (count < listLength) {
            // Skip any leading whitespace
            itemEnd = skipWhiteSpace(count, listChars, null);
            count = itemEnd;
            if (count >= listLength) {
                break;
            }
            itemStart = count;
            itemEnd = itemStart;
            while (itemEnd < listLength) {
                if ((listChars[itemEnd] != ' ') && (listChars[itemEnd] != '\n') && (listChars[itemEnd] != '\t')) {
                    itemEnd++;
                } else {
                    break;
                }
            }
            itemLength = itemEnd - itemStart;
            returnList.add(Integer.parseInt(new String(listChars, itemStart, itemLength)));

            count = itemEnd;
        }

        int returnArray[] = new int[returnList.size()];
        for (int loopi = 0; loopi < returnList.size(); loopi++) {
            returnArray[loopi] = returnList.get(loopi);
        }
        return returnArray;
    }

    public static int[] parseListVerticeNTuples(String list, int expectedValuesPerTuple) {
        if (list == null) {
            return null;
        }
        if (list.equals("")) {
            return null;
        }

        //	log.log(INFO, "list=|"+list+"|");

        String[] vertexStrings = parseWhitespaceList(list);

        //	log.log(INFO, "found "+vertexStrings.length+" strings in parseWhitespaceList");

        ArrayList<Integer> returnList = new ArrayList<Integer>();
        Integer emptyMarker = new Integer(BuilderInterface.EMPTY_VERTEX_VALUE);

        for (int loopi = 0; loopi < vertexStrings.length; loopi++) {
            //	    log.log(INFO, "parsing vertexStrings["+loopi+"]=|"+vertexStrings[loopi]+"|");
            parseVerticeNTuple(vertexStrings[loopi], returnList, emptyMarker, expectedValuesPerTuple);
        }

        int returnArray[] = new int[returnList.size()];
        for (int loopi = 0; loopi < returnList.size(); loopi++) {
            returnArray[loopi] = returnList.get(loopi);
        }
        return returnArray;
    }

    private static void parseVerticeNTuple(String list, ArrayList<Integer> returnList, Integer emptyMarker, int expectedValueCount) {



        String[] numbers = parseList('/', list);

        int foundCount = 0;

        int index = 0;
        while (index < numbers.length) {

            if (numbers[index].trim().equals("")) {
//                log.log(INFO, "numbers["+index+"] is empty, adding emptymarker to list");
                returnList.add(emptyMarker);
            } else {
//                                log.log(INFO, "numbers["+index+"] is NOT empty, adding parsed int "+Integer.parseInt(numbers[index])+" to list.");
                returnList.add(Integer.parseInt(numbers[index]));
            }
            foundCount++;
            index++;
        }
        while (foundCount < expectedValueCount) {
            returnList.add(emptyMarker);
            foundCount++;
        }
    }

    public static String[] parseList(char delim, String list) {
        if (list == null) {
            return null;
        }
        if (list.equals("")) {
            return null;
        }

        ArrayList<String> returnVec = new ArrayList<String>();
        String[] returnArray = null;

        // Copy list into a char array.
        char listChars[];
        listChars = new char[list.length()];
        list.getChars(0, list.length(), listChars, 0);

        int count = 0;
        int itemStart = 0;
        int itemEnd = 0;
        String newItem = null;

        while (count < listChars.length) {
            count = itemEnd;
            if (count >= listChars.length) {
                break;
            }
            itemStart = count;
            itemEnd = itemStart;
            while (itemEnd < listChars.length) {
                if (delim != listChars[itemEnd]) {
                    itemEnd++;
                } else {
                    break;
                }
            }
            newItem = new String(listChars, itemStart, itemEnd - itemStart);
            itemEnd++;
            count = itemEnd;
            returnVec.add(newItem);
        }
        // Convert from vector to array, and return it.
        returnArray = new String[1];
        returnArray = (String[]) returnVec.toArray((Object[]) returnArray);
        return returnArray;
    }

    public static String[] parseWhitespaceList(String list) {
        if (list == null) {
            return null;
        }
        if (list.equals("")) {
            return null;
        }

        ArrayList<String> returnVec = new ArrayList<String>();
        String[] returnArray = null;

        // Copy list into a char array.
        char listChars[];
        listChars = new char[list.length()];
        list.getChars(0, list.length(), listChars, 0);

        int count = 0;
        int itemStart = 0;
        int itemEnd = 0;
        String newItem = null;

        while (count < listChars.length) {
            // Skip any leading whitespace
            itemEnd = skipWhiteSpace(count, listChars, null);
            count = itemEnd;
            if (count >= listChars.length) {
                break;
            }
            itemStart = count;
            itemEnd = itemStart;
            while (itemEnd < listChars.length) {
                if ((listChars[itemEnd] != ' ') && (listChars[itemEnd] != '\n') && (listChars[itemEnd] != '\t')) {
                    itemEnd++;
                } else {
                    break;
                }
            }
            newItem = new String(listChars, itemStart, itemEnd - itemStart);
            itemEnd++;
            count = itemEnd;
            returnVec.add(newItem);
        }
        returnArray = new String[1];
        returnArray = (String[]) returnVec.toArray((Object[]) returnArray);
        return returnArray;
    }
}
