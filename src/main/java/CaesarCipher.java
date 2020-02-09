import java.nio.charset.Charset;

public class CaesarCipher {
    private static String encodeMessage = "Еъёчхф Вхзёюлх, адздёиу ф ждэщхб, црбх еёдюэчъщъгюъв южаижжзчх, ждчъёнъгжзчдв. Ъы зёюивй жёхчгюв бюнс ж ъы вдгивъгзхбсгрв аёхкдв. Зъеъёс вгъ дмъчющгд, мзд гъюэцъьгджзс тздшд аёхкх фчбфъзжф жбъщжзчюъв гъждчъёнъгжзчх мъбдчъмъжадшд югщючющиивх. Ф юэимюб чхни южздёюу ю чгыж юэвъгъгюф, здмгъъ дзёхэюч еджздфггиу юэвъгмючджзс мъбдчъмъжаюк едёдадч. Ю зъв гъ въгъъ, еджбъщдчхбх гъищхмх. Ф еёюнъб а чрчдщи, мзд чюгдя чжъви вдя югзъббъаз, х чдэвдьгд, вды мёъэвъёгдъ жзёъвбъгюъ ад чжъви шхёвдгюмгдви. Гхязю ёънъгюъ вгъ едвдшбх еёдшёхввх югзиюзючгдшд зюех, жеълюхбсгд ждэщхггхф щбф юэимъгюф деёъщъбъггрк жздёдг мъбдчъмъжадя щиню. Въгф вдьгд гхэчхзс дзлдв Вхзёюлр, х ъы, цъэ еёъичъбюмъгюф, вхзъёсу.";
    private static String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static void main(String args[]) {
        StringBuffer decodeMessage = new StringBuffer();
        char encodeLetter;
        char decodeLetter;
        int encodeLetterPosition;
        int decodeLetterPosition;
        boolean isUpperCaseLetter;

        for (int decryptionShift = 1; decryptionShift < alphabet.length(); decryptionShift++) {
            for (int currentPosition = 0; currentPosition < encodeMessage.length(); currentPosition++) {
                encodeLetter = encodeMessage.charAt(currentPosition);
                isUpperCaseLetter = (Character.getType(encodeLetter) == Character.UPPERCASE_LETTER) ? true : false;

                if (isUpperCaseLetter) {
                    encodeLetterPosition = alphabet.indexOf(String.valueOf(encodeLetter).toLowerCase());
                } else {
                    encodeLetterPosition = alphabet.indexOf(encodeLetter);
                }

                if (encodeLetterPosition == -1) {
                    decodeLetter = encodeLetter;
                } else {
                    decodeLetterPosition = (encodeLetterPosition + decryptionShift) < alphabet.length()
                            ? encodeLetterPosition + decryptionShift
                            : (encodeLetterPosition + decryptionShift) % alphabet.length();

                    decodeLetter = alphabet.charAt(decodeLetterPosition);

                }

                decodeMessage.append(isUpperCaseLetter ? String.valueOf(decodeLetter).toUpperCase() : decodeLetter);
            }
            System.out.println(decodeMessage);
            decodeMessage.delete(0, decodeMessage.length());
        }
    }
}
