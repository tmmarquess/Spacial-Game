public class Coords {
    private static String letras = "ABCDEFGHIJ";

    public static String convertCoord(String coord){
        int i = letras.indexOf(coord.charAt(0)) + 1;
        int j = Integer.parseInt(coord.substring(1)) + 1;
        return ""+i+""+j;
    }
}
