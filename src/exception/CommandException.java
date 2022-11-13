package exception;

public class CommandException {

    public static void makeException(String command) {

        switch (command) {
            case "r" :
            case "c" :
            case "o" :
            case "i" :
            case "v" :
            case "a" :
            case "p" :
            case "d" :
                break;
            default:
                throw new IllegalStateException("올바르지 않은 명령어입니다. 다시 입력해주세요");
        }
    }

    public static boolean checkCommand(String command) {
        try {
            makeException(command);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
