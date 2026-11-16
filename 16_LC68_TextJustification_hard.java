class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {

            int j = i;
            int letters = 0;

            // Find how many words fit in one line
            while (j < words.length &&
                   letters + words[j].length() + (j - i) <= maxWidth) {

                letters += words[j].length();
                j++;
            }

            int spaces = maxWidth - letters;
            int gaps = j - i - 1;

            StringBuilder line = new StringBuilder();

            // Last line or only one word
            if (j == words.length || gaps == 0) {

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        line.append(" ");
                    }
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }

            } else {

                int spaceBetween = spaces / gaps;
                int extraSpaces = spaces % gaps;

                for (int k = i; k < j - 1; k++) {

                    line.append(words[k]);

                    int count = spaceBetween;

                    if (extraSpaces > 0) {
                        count++;
                        extraSpaces--;
                    }

                    for (int x = 0; x < count; x++) {
                        line.append(" ");
                    }
                }

                line.append(words[j - 1]);
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}
