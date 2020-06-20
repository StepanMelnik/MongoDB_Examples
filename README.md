# MongoDB Examples

The project works with <a href="IArticleNameRepository">IArticleNameRepository</a> and covers almost all aspects to work with MongoDB.

## Description

The following unit test work with different MongoDb aspects:
* <a href="ArticleNameRepositoryIntegrationTest.java">ArticleNameRepositoryIntegrationTest tests CRUD operations to work with a real Mongo DB;
* <a href="ArticleNameRepositorySearchByExampleIntegrationTest.java">ArticleNameRepositorySearchByExampleIntegrationTest<a> tests search functionality by Example instance with different matching;
* <a href="ArticleNameRepositoryTextSerachIntegrationTest.java">ArticleNameRepositoryTextSerachIntegrationTest</a> tests performs text searching. Important to index the needed fields with @TextIndexed annotations as described in ArticleName POJO. Also the index should be created as described in MongoDbConfiguration.java;

## Build

Clone and install <a href="https://github.com/StepanMelnik/Parent.git">Parent</a> project before building.

Create tester user as described in <a href="shell/start.txt">start.txt</a> file.


### Maven
	> mvn clean install
