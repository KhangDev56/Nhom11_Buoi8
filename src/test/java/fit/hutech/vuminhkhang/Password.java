package fit.hutech.vuminhkhang;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Password
{
    public static void main(String[] args)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword ="123";
        String encodePassword = encoder.encode(rawPassword);
        System.out.println(encodePassword);
    }
}
