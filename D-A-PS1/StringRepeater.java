public class StringRepeater {
    public String repeatString(String s, int n){
        /* StringBuffer result = new StringBuffer("");
        for(int i=0; i<n; i++) {
            result.append(s);
        }
        return result.toString(); */
        String result = "";
    for(int i=0; i<n; i++) {
        result = result + s;
    }
    return result;
    }

   /* public String repeatString(String s, int n){
    String result = "";
    for(int i=0; i<n; i++) {
        result = result + s;
    }
    return result;
} */
}
