class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            String localName = email.split("@")[0];
            String domain = email.split("@")[1];

            int i = 0;
            StringBuilder finalLocalName = new StringBuilder();
            while (i < localName.length()) {
                if (localName.charAt(i) == '.')  {
                    i++;
                }
                else if (localName.charAt(i) == '+')
                    break;
                else
                    finalLocalName.append(localName.charAt(i++));
            }

            uniqueEmails.add(finalLocalName.toString() + "@" + domain);
        }
        return uniqueEmails.size();
    }
}