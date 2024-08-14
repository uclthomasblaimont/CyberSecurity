public class VigenereCipher {

    private static String extendKey(String text , String key){
        StringBuilder extendedKey = new StringBuilder();
        while(extendedKey.length()<text.length()){
            extendedKey.append(key);
        }
        return extendedKey.substring(0,text.length());
    }


    public static String encrypt(String text , String key){
        StringBuilder result = new StringBuilder();
        String extendedkey = extendKey(text,key);
        for (int i = 0 ; i < text.length() ; i++){
            char ch = text.charAt(i);
            char keych = extendedkey.charAt(i);

            if(Character.isLetter(ch)){
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char keyBase = Character.isUpperCase(keych) ? 'A': 'a';
                int shift = keych - keyBase;
                result.append((char) ((ch-base + shift) % 26 + base));

            }else {
                result.append(ch);
            }

        }
        return result.toString();

    }


    public static String  decrypt(String text , String key) {
        StringBuilder result = new StringBuilder();
        String extendedkey = extendKey(text, key);

        for (int i = 0 ; i < text.length() ; i++){
            char ch = text.charAt(i);
            char keych = extendedkey.charAt(i);

            if(Character.isLetter(ch)){
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char keyBase = Character.isUpperCase(keych) ? 'A': 'a';
                int shift = keych - keyBase;
                result.append((char) ((ch - base - shift + 26 ) % 26 + base));

            }else {
                result.append(ch);
            }

        }
        return result.toString();


    }


    public static void main(String[] args) {
        String text = "hello world";
        String key = "zzz";

        String encryptedText = encrypt(text, key);
        String decryptedText = decrypt(encryptedText, key);

        System.out.println("Text: " + text);
        System.out.println("Key : " + key);
        System.out.println("Encrypted: " + encryptedText);
        System.out.println("Decrypted: " + decryptedText);
    }





}
