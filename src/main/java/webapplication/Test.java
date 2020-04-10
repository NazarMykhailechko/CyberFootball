package webapplication;

public class Test {
    public static void main(String[] args) {

//        06.04.20 19:44
//        Манчестер Юнайтед (kalibra)
//        Арсенал Лондон (FEARGGWP)
//        1:3 (0:2)

        String str = "Манчестер Юнайтед(kalibra)";
        System.out.println(str.length());
        String subStr = str.substring(str.indexOf('(')).trim();
        System.out.println(subStr);
    }
}
