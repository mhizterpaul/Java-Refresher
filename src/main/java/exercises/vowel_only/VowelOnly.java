package exercises.vowel_only;

public class VowelOnly {
    /**
     *
     * @return vowels in the argument
     */
    static String vowelOnly(String wVowels){
        StringBuilder vowels = new StringBuilder();
        String baseVowels = "aeiou";
        String[] chars = wVowels.split("");

        for(String str : chars){
            if(!baseVowels.contains(str.toLowerCase())) continue;
            vowels.append(str);
        }

        return String.valueOf(vowels);
    }
}
