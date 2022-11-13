package exception;

import java.util.List;

public class CheckAutomobileValid {

    public static void makeException(List<String> split) {

        if (split.get(0).equals("r")) {
            switch (split.get(1)) {
                case "c" :
                case "s" :
                case "t" :
                    break;
                default:
                    throw new IllegalStateException("차량 종류가 올바르지 않습니다. 다시 입력해주세요");
            }
        }
    }

    public static boolean checkAutomobile(List<String> split) {
        try {
            makeException(split);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
