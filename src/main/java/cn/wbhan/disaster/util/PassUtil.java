package cn.wbhan.disaster.util;

import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 用来编码解码的工具类
 */
@Component
public class PassUtil {

    private static final Charset charset = StandardCharsets.UTF_8;
    private static Base64.Encoder encoder;
    private static Base64.Decoder decoder;

    static {
        encoder = Base64.getEncoder();
        decoder = Base64.getDecoder();
    }

    public static String encode(String username) {
        return encoder.encodeToString(username.getBytes(charset));
    }

    public static String decode(String pass) {
        byte[] bytes = decoder.decode(pass);
        return new String(bytes, charset);
    }
}
