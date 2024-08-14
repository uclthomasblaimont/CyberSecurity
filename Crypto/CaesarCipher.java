public class CaesarCipher {


    public static String encrypt(String text , int shift){
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < text.length() ; i++){
            char ch = text.charAt(i);
            if(Character.isLetter(ch)){
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                result.append((char) ((ch-base+shift)%26+base)); // caesar formula

            }else{
                result.append(ch);
            }
        }
    return result.toString();
    }

    public static String decrypt(String text , int shift){
        return encrypt(text,26-shift);
    }




    public static void main(String[] args) {
        String text = "Thomas";
        int shift = 3;
        String encrypted = encrypt(text, shift);
        String decrypted = decrypt(encrypted, shift);

        System.out.println("Text : " + text);
        System.out.println("Shift: " + shift);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }



}
