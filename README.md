beantosql
=========
This is a util to simplify the process between SQL table and Java Bean.

Download
--------
Download the latest JAR or grab via Maven:
```xml
<dependency>
  <groupId>com.github.bpazy</groupId>
  <artifactId>beantosql</artifactId>
  <version>0.1.1</version>
  <type>pom</type>
</dependency>
```
or Gradle:
```groovy
repositories {
    jcenter()
}
dependencies {
    compile 'com.github.bpazy:beantosql:0.1.1'
}
```

Usage
-----

Within the bean named `TestBean`
```
public class TestBean {
    private int id;
    private String name;
    private String content;
    private String longContent;
    private Date date;
}
```

You can run `new BeanToSQL().prettyPrinting().go(TestBean.class);`
So you may get a sql statement:
```
CREATE TABLE `TestBean` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `long_content` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
);
```

And then paste it into your DMS to create your table.


Annotation `@Name` on bean's field give you ability to custom column name.
Such as
```
@Name("id")
private int name;
```
This bean's field `name` will be transformed into `` `id` int NOT NULL``.

`@Name` to custom column name.
`@PrimaryKey` to define primary key.

beantosql also support class of string:
```Java
String go = new BeanToSQL().prettyPrinting().go("class Test {\n" +
                "    private int id;\n" +
                "    private String name;\n" +
                "    private String content;\n" +
                "    private Date date;\n" +
                "}");
System.out.println(go);
```
You would get
```sql
CREATE TABLE `Test` (
  `id`  NOT NULL,
  `name` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
);
```

中文
---
这是一款简化你在数据库的表和Java Bean之间同步修改的工具。

假设你有一个名字为`TestBean`的Java Bean
```
public class TestBean {
    private int id;
    private String name;
    private String content;
    private String longContent;
    private Date date;
}
```

你可以通过 `new BeanToSQL().prettyPrinting().go(TestBean.class);`
来获取创建表的SQL语句:
```
CREATE TABLE `TestBean` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `long_content` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
);
```