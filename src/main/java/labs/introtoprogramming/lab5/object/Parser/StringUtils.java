package labs.introtoprogramming.lab5.object.Parser;

import labs.introtoprogramming.lab5.object.Builder.BuilderInterface;

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


    public static Integer[] parseListVertexNTuples(String list, int expectedValuesPerTuple) {
        if (list == null) {
            return null;
        }
        if (list.equals("")) {
            return null;
        }
        String[] temp;
        String[] vertexStrings = list.split(" ");
        temp = vertexStrings[0].split("/");
        boolean mark = true;
        Integer[] parsed;
        if (!temp[1].equals("")) {
            mark = false;
            parsed = new Integer[vertexStrings.length * 4];
        } else {
            parsed = new Integer[vertexStrings.length * 3];
        }

        int j = 0;
        for (int i = 0; i < vertexStrings.length; i++) {
            if (mark) {
                temp = vertexStrings[i].split("//");
                parsed[j] = Integer.parseInt(temp[0]);
                parsed[++j] = Integer.parseInt(temp[1]);


            } else {
                temp = vertexStrings[i].split("/");
                parsed[j] = Integer.parseInt(temp[0]);
                parsed[++j] = Integer.parseInt(temp[1]);
                parsed[++j] = Integer.parseInt(temp[2]);


            }
            parsed[++j] = null;
            j++;

        }
        return parsed;
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

        char listChars[];
        listChars = new char[list.length()];
        list.getChars(0, list.length(), listChars, 0);

        int count = 0;
        int itemStart = 0;
        int itemEnd = 0;
        String newItem = null;

        while (count < listChars.length) {

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
