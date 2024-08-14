package com.runrunfast.currency;

//import io.github.swagger2markup.Swagger2MarkupConfig;
//import io.github.swagger2markup.Swagger2MarkupConverter;
//import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
//import io.github.swagger2markup.markup.builder.MarkupLanguage;
//import org.asciidoctor.cli.AsciidoctorInvoker;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisPlusApplication {
    
//    /***
//     * <p>@author: James</p>
//     * <p>@param: []</P>
//     * <p>@return: void</P>
//     * <p>@date: 2018/11/12 14:19</P>
//     * <p>@description: 在src/docs/asciidoc/generated目录下生成api.adoc文件</p>
//     */
//    @Test
//    public void generateAsciiDocs() throws Exception {
//
//        //    输出Ascii格式
//        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//                .withGeneratedExamples()
//                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
//                .build();
//
//        Swagger2MarkupConverter.from(new URL("http://localhost:80/mybatisplus/v2/api-docs"))
//                .withConfig(config)
//                .build()
//                .toFile(Paths.get("src/docs/asciidoc/generated/api"));
//    }
//
//    /***
//     * <p>@author: James</p>
//     * <p>@param: []</P>
//     * <p>@return: void</P>
//     * <p>@date: 2018/11/12 16:26</P>
//     * <p>@description: 在src/docs/asciidoc/generated目录下生成PDF文件</p>
//     */
//    @Test
//    public void generatePDF() {
//        //样式
//        String style = "pdf-style=E:\\repertory\\mybatisplus\\src\\docs\\asciidoc\\data\\themes\\default-theme.yml";
//        //字体
//        String fontsdir = "pdf-fontsdir=E:\\repertory\\mybatisplus\\src\\docs\\asciidoc\\data\\fonts";
//        //需要指定adoc文件位置
//        String adocPath = "E:\\repertory\\mybatisplus\\src\\docs\\asciidoc\\generated\\api.adoc";
//        AsciidoctorInvoker.main(new String[]{"-a",style,"-a",fontsdir,"-b","pdf",adocPath});
//    }

}

