package gov.view.common.security;

public class ScryptPasswordHashingDemo {
    public ScryptPasswordHashingDemo() {
        super();
    }

    public static void main(String[] args) {
        String originalPassword = "password";
        /*String generatedSecuredPasswordHash =
            SCryptUtil.scrypt(originalPassword, 16, 16, 16);
        System.out.println(generatedSecuredPasswordHash);

        boolean matched =
            SCryptUtil.check("password", generatedSecuredPasswordHash);
        System.out.println(matched);

        matched = SCryptUtil.check("passwordno", generatedSecuredPasswordHash);
        System.out.println(matched); */
    }
}
