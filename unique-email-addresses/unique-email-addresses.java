class Solution {
    public static int numUniqueEmails(String[] emails) {
        Set<String> list = new HashSet<String>();
        for (int i = 0; i < emails.length; i++) {
            list.add(parse(emails[i]));
        }
        
        return list.size();
    }

    private static String parse(String email) {
        int at = email.indexOf('@');
        int firstDot = email.indexOf('.');
        int firstPlus = email.indexOf('+');
        if (firstDot > at && (firstPlus == -1 || (firstPlus > at))) {
            return email;
        }

        // '+' takes precedence, so we parse for '+' first.
        String newEmail = "";
        if (firstPlus != -1) {
            newEmail += email.substring(0, firstPlus);
            // newEmail += email.substring(firstPlus + 1, at);
            newEmail += email.substring(at);
            at = newEmail.indexOf('@');
        }
        
        // now parse for '.'.
        if (firstPlus == -1) {
            newEmail = email;
        }
        for (int i = 0; i < at; i++) {
            if (newEmail.charAt(i) == '.') {
                newEmail = newEmail.substring(0, i) + newEmail.substring(i + 1);
            }
        }

        return newEmail;
    }
}