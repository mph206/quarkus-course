package tech.donau.course;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class StaticContentTest {
    @TestHTTPResource("index.html")
    URL url;

    @Test
    public void testRootPath() throws IOException {
//        query conents of the page
        final String body = IOUtils.toString(url, Charset.defaultCharset());
        System.out.println(body);
        assertTrue(body.contains("<div>\n" +
                "    This is a test div\n" +
                "</div>"));

    }
}
