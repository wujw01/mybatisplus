##项目介绍
    
    技术集成：springboot 2.0.3 + mybatis-plus 3.0.1+swagger 2.9.2
    

##生成adoc文件
    执行com.runrunfast.currency.SpringBootMybatisPlusApplication下面的generateAsciiDocs()方法
       
##生成HTML文档
    idea在terminal中输入：mvn asciidoctor:process-asciidoc 命令
    
##生成PDF文档
    下载我的项目，复制src/docs/asciidoc/目录下的data目录，发到你的项目中去，
    在执行com.runrunfast.currency.SpringBootMybatisPlusApplication下面的generatePDF()
    
##观察src/docs/asciidoc/下的generated和html目录，看是否生成了html文件和pdf文件
##至此结束!
