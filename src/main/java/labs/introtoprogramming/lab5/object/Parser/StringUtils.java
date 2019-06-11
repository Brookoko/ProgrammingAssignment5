package labs.introtoprogramming.lab5.object.Parser;

import java.util.logging.Logger;

public class StringUtils {
    private static Logger log = Logger.getLogger(StringUtils.class.getName());


    public static Integer[] parseCodeLine(String list) {
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
        if (!temp[1].equals("")) {
            mark = false;
        }
        Integer[] parsed = new Integer[vertexStrings.length * 3];


        int j = 0;
        for (int i = 0; i < vertexStrings.length; i++) {
            if (mark) {
                temp = vertexStrings[i].split("//");
                parsed[j] = Integer.parseInt(temp[0]);
                parsed[++j] = Integer.parseInt(temp[1]);


            } else {
                temp = vertexStrings[i].split("/");
                parsed[j] = Integer.parseInt(temp[0]);
                parsed[++j] = Integer.parseInt(temp[2]);


            }
            parsed[++j] = null;
            j++;

        }
        return parsed;
    }


}
